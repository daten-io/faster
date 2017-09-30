package io.daten.faster.collections;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link FasterLongList}.
 */
public final class FasterLongListTest {

    @Test
    public void providesRandomAccessList() {
        final FasterLongList list = new FasterLongList(10);
        final int index = 1000;
        final long value = 444L;
        list.set(index, value);
        assertThat(list.get(index)).isEqualTo(value);
        assertThat(list.get(0)).isEqualTo(0);
        assertThat(list.size()).isEqualTo(index + 1);
        final long head = 2222L;
        list.add(head);
        assertThat(list.size()).isEqualTo(index + 2);
        assertThat(list.get(index + 1)).isEqualTo(head);
    }
}
