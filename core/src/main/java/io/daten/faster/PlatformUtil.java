package io.daten.faster;

import java.nio.ByteOrder;

public final class PlatformUtil {

    public static final boolean IS_LITTLE_ENDIAN =
        ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);

    public static final String OS_NAME = System.getProperty("os.name");

    public static final boolean IS_WINDOWS = OS_NAME.startsWith("Windows");
}
