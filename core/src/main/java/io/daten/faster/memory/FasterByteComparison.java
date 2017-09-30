package io.daten.faster.memory;

import io.daten.faster.PlatformUtil;
import io.daten.faster.UnsafeUtil;
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
        final int minLength = Math.min(length1, length2);
        // Shortcut for (minLength / 8) * 8
        final int fullWordBytes = minLength & ~7;
        final int memPos1 = offset1 + UnsafeUtil.BYTE_ARRAY_OFFSET;
        final int memPos2 = offset2 + UnsafeUtil.BYTE_ARRAY_OFFSET;
        for (int i = 0; i < fullWordBytes; i += Long.BYTES) {
            final long left = UNSAFE.getLong(buffer1, (long) memPos1 + (long) i);
            final long right = UNSAFE.getLong(buffer2, (long) memPos2 + (long) i);
            if (left != right) {
                if (PlatformUtil.IS_LITTLE_ENDIAN) {
                    return Long.compareUnsigned(Long.reverseBytes(left), Long.reverseBytes(right));
                } else {
                    return Long.compareUnsigned(left, right);
                }
            }
        }
        for (int i = fullWordBytes; i < minLength; i++) {
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

}
