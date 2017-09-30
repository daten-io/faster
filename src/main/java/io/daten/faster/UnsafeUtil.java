package io.daten.faster;

import sun.misc.Unsafe;

public final class UnsafeUtil {

    public static boolean unsafeSupported() {
        return false;
    }

    public static Unsafe getTheUnsafe() {
        return null;
    }
}
