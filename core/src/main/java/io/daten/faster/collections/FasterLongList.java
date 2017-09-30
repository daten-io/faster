package io.daten.faster.collections;

public final class FasterLongList {

    private int count;

    private long[] data;

    FasterLongList(final int size) {
        data = new long[size];
        count = 0;
    }

    public void add(final long num) {
        ensureCapacity(count + 1);
        data[count++] = num;
    }

    public long get(final int index) {
        return data[index];
    }

    public void set(final int index, final long value) {
        final int minCount = index + 1;
        ensureCapacity(minCount);
        data[index] = value;
        count = Math.max(minCount, count);
    }

    public int size() {
        return count;
    }

    private void ensureCapacity(final int capacity) {
        if (data.length < capacity) {
            final long[] old = data;
            data = new long[Math.max(capacity, (data.length << 1) + 1)];
            System.arraycopy(old, 0, data, 0, old.length);
        }
    }
}
