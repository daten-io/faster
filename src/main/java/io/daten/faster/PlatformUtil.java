package io.daten.faster;

import java.nio.ByteOrder;

public final class PlatformUtil {

    public static final boolean IS_LITTLE_ENDIAN =
        ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);
}
