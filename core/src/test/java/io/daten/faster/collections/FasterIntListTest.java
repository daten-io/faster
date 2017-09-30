package io.daten.faster.collections;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link FasterIntList}.
 */
public class FasterIntListTest {

    @Test
    public void providesRandomAccessList() {
        final FasterIntList list = new FasterIntList(10);
        final int index = 1000;
        final int value = 444;
        list.set(index, value);
        assertThat(list.get(index)).isEqualTo(value);
        assertThat(list.get(0)).isEqualTo(0);
        assertThat(list.size()).isEqualTo(index + 1);
        final int head = 2222;
        list.add(head);
        assertThat(list.size()).isEqualTo(index + 2);
        assertThat(list.get(index + 1)).isEqualTo(head);
    }
}
