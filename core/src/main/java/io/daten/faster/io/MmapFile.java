package io.daten.faster.io;

import java.io.Closeable;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import sun.misc.Cleaner;
import sun.nio.ch.DirectBuffer;

public final class MmapFile implements Closeable {

    private final FileChannel channel;

    private final MappedByteBuffer buffer;

    public static MmapFile open(final Path path, final long size) throws IOException {
        return new MmapFile(path, size);
    }

    private MmapFile(final Path path, final long size) throws IOException {
        channel = FileChannel.open(path);
        buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0L, size);
    }

    public void sync() {
        buffer.force();
    }

    @Override
    public void close() throws IOException {
        channel.close();
        final Cleaner cleaner = ((DirectBuffer) this.buffer).cleaner();
        if (cleaner != null) { cleaner.clean(); }
    }
}
