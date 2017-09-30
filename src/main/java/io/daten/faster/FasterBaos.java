package io.daten.faster;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * <h2>Faster drop in replacement for {@link ByteArrayOutputStream}.</h2>
 */
public final class FasterBaos extends ByteArrayOutputStream {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    @Override
    public void write(final int b) {
        ensureCapacity(count + 1);
        buf[count] = (byte) b;
        count += 1;
    }

    @Override
    public void write(final byte[] b, final int off, final int len) {
        if (off < 0 || off > b.length || len < 0 ||
            off + len - b.length > 0) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(count + len);
        System.arraycopy(b, off, buf, count, len);
        count += len;
    }

    @Override
    public void writeTo(final OutputStream out) throws IOException {
        out.write(buf, 0, count);
    }

    private void ensureCapacity(final int minCapacity) {
        if (minCapacity - buf.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(final int minCapacity) {
        int newCapacity = buf.length << 1;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - FasterBaos.MAX_ARRAY_SIZE > 0) {
            newCapacity = FasterBaos.hugeCapacity(minCapacity);
        }
        buf = Arrays.copyOf(buf, newCapacity);
    }

    private static int hugeCapacity(final int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return minCapacity > FasterBaos.MAX_ARRAY_SIZE
            ? Integer.MAX_VALUE : FasterBaos.MAX_ARRAY_SIZE;
    }
}
