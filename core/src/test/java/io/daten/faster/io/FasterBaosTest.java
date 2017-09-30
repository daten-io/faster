package io.daten.faster.io;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@link FasterBaos}.
 */
public final class FasterBaosTest {

    @Test
    public void writesSingleBytes() {
        final FasterBaos baos = new FasterBaos();
        baos.write(2);
        assertThat(baos.size(), is(1));
    }
}
