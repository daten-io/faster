package io.daten.faster;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class UnsafeUtil {

    public static final int BOOLEAN_ARRAY_OFFSET;

    public static final int BYTE_ARRAY_OFFSET;

    public static final int SHORT_ARRAY_OFFSET;

    public static final int INT_ARRAY_OFFSET;

    public static final int LONG_ARRAY_OFFSET;

    public static final int FLOAT_ARRAY_OFFSET;

    public static final int DOUBLE_ARRAY_OFFSET;

    private static final Unsafe UNSAFE;

    static {
        Unsafe unsafe;
        try {
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            unsafe = (Unsafe) unsafeField.get(null);
        } catch (final Throwable cause) {
            unsafe = null;
        }
        UNSAFE = unsafe;
        if (UnsafeUtil.UNSAFE != null) {
            BOOLEAN_ARRAY_OFFSET = UnsafeUtil.UNSAFE.arrayBaseOffset(boolean[].class);
            BYTE_ARRAY_OFFSET = UnsafeUtil.UNSAFE.arrayBaseOffset(byte[].class);
            SHORT_ARRAY_OFFSET = UnsafeUtil.UNSAFE.arrayBaseOffset(short[].class);
            INT_ARRAY_OFFSET = UnsafeUtil.UNSAFE.arrayBaseOffset(int[].class);
            LONG_ARRAY_OFFSET = UnsafeUtil.UNSAFE.arrayBaseOffset(long[].class);
            FLOAT_ARRAY_OFFSET = UnsafeUtil.UNSAFE.arrayBaseOffset(float[].class);
            DOUBLE_ARRAY_OFFSET = UnsafeUtil.UNSAFE.arrayBaseOffset(double[].class);
        } else {
            BOOLEAN_ARRAY_OFFSET = 0;
            BYTE_ARRAY_OFFSET = 0;
            SHORT_ARRAY_OFFSET = 0;
            INT_ARRAY_OFFSET = 0;
            LONG_ARRAY_OFFSET = 0;
            FLOAT_ARRAY_OFFSET = 0;
            DOUBLE_ARRAY_OFFSET = 0;
        }
    }

    /**
     * @return Unsafe instance or {@code null} if current System does not support the Unsafe
     */
    public static Unsafe getTheUnsafe() {
        return UNSAFE;
    }
}
