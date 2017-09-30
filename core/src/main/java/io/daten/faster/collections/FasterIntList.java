package io.daten.faster.collections;

public final class FasterIntList {

    private int count;

    private int[] data;

    FasterIntList(final int size) {
        data = new int[size];
        count = 0;
    }

    public void add(final int num) {
        ensureCapacity(count + 1);
        data[count++] = num;
    }

    public int get(final int index) {
        return data[index];
    }

    public void set(final int index, final int value) {
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
            final int[] old = data;
            data = new int[Math.max(capacity, (data.length << 1) + 1)];
            System.arraycopy(old, 0, data, 0, old.length);
        }
    }
}
