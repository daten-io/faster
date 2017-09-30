package io.daten.faster;

import sun.misc.Unsafe;

public final class FasterByteComparison {

    private static final Unsafe UNSAFE = UnsafeUtil.getTheUnsafe();

    private FasterByteComparison() {
        // Utility Class
    }

    public static int compare(final byte[] buffer1, final byte[] buffer2) {
        return compare(buffer1, 0, buffer1.length, buffer2, 0, buffer2.length);
    }

    public static int compare(final byte[] buffer1, final int offset1, final int length1,
        final byte[] buffer2, final int offset2, final int length2) {
        if (buffer1 == buffer2 &&
            offset1 == offset2 &&
            length1 == length2) {
            return 0;
        }
        final int minLength = Math.min(length1, length2);
        final int minWords = minLength / Long.BYTES;
        final int offset1Adj = offset1 + UnsafeUtil.BYTE_ARRAY_OFFSET;
        final int offset2Adj = offset2 + UnsafeUtil.BYTE_ARRAY_OFFSET;
        for (int i = 0; i < minWords * Long.BYTES; i += Long.BYTES) {
            final long left = UNSAFE.getLong(buffer1, offset1Adj + (long) i);
            final long right = UNSAFE.getLong(buffer2, offset2Adj + (long) i);
            final long diff = left ^ right;
            if (diff != 0L) {
                if (!PlatformUtil.IS_LITTLE_ENDIAN) {
                    return lessThanUnsigned(left, right) ? -1 : 1;
                }
                // Use binary search
                int n = 0;
                int y;
                int x = (int) diff;
                if (x == 0) {
                    x = (int) (diff >>> 32);
                    n = 32;
                }
                y = x << 16;
                if (y == 0) {
                    n += 16;
                } else {
                    x = y;
                }
                y = x << 8;
                if (y == 0) {
                    n += 8;
                }
                return (int) ((left >>> n & 0xFFL) - (right >>> n & 0xFFL));
            }
        }
        for (int i = minWords * Long.BYTES; i < minLength; i++) {
            final int result = Long.compareUnsigned(
                buffer1[offset1 + i],
                buffer2[offset2 + i]
            );
            if (result != 0) {
                return result;
            }
        }
        return length1 - length2;
    }

    private static boolean lessThanUnsigned(final long x1, final long x2) {
        return x1 + Long.MIN_VALUE < x2 + Long.MIN_VALUE;
    }
}
