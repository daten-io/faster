package io.daten.faster.memory;

import java.nio.charset.StandardCharsets;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FasterByteComparisonTest {

    @Test
    public void compare() {
        final byte[] bigger = "zxabcdefngfngdfgfdgf".getBytes(StandardCharsets.UTF_8);
        final byte[] smaller = "ababababcdefngfngdfgfdgf".getBytes(StandardCharsets.UTF_8);
        assertThat(FasterByteComparison.compare(smaller, bigger)).isLessThan(0);
        assertThat(FasterByteComparison.compare(bigger, smaller)).isGreaterThan(0);
        assertThat(FasterByteComparison.compare(smaller, smaller)).isEqualTo(0);
    }
}
