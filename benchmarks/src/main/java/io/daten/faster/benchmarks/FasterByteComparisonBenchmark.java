package io.daten.faster.benchmarks;

import io.daten.faster.memory.FasterByteComparison;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@Warmup(iterations = 3, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(1)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class FasterByteComparisonBenchmark {

    private static final int COMPARISONS_PER_INVOCATION = 10_000_000;

    private static final byte[] MANY_BYTES;

    private static final byte[] ONE_BYTE;

    private static final byte[] TWO_BYTES;

    private static final byte[] THREE_BYTES;

    private static final byte[] FOUR_BYTES;

    private static final byte[] FIVE_BYTES;

    private static final byte[] SIX_BYTES;

    private static final byte[] SEVEN_BYTES;

    private static final byte[] EIGHT_BYTES;

    private static final byte[] NINE_BYTES;

    private static final byte[] TEN_BYTES;

    private static final byte[] THIRTY_TWO_BYTES;

    static {
        final Random random = new Random();
        MANY_BYTES = new byte[128];
        random.nextBytes(MANY_BYTES);
        ONE_BYTE = Arrays.copyOf(MANY_BYTES, 1);
        TWO_BYTES = Arrays.copyOf(MANY_BYTES, 2);
        THREE_BYTES = Arrays.copyOf(MANY_BYTES, 3);
        FOUR_BYTES = Arrays.copyOf(MANY_BYTES, 4);
        FIVE_BYTES = Arrays.copyOf(MANY_BYTES, 5);
        SIX_BYTES = Arrays.copyOf(MANY_BYTES, 6);
        SEVEN_BYTES = Arrays.copyOf(MANY_BYTES, 7);
        EIGHT_BYTES = Arrays.copyOf(MANY_BYTES, 8);
        NINE_BYTES = Arrays.copyOf(MANY_BYTES, 9);
        TEN_BYTES = Arrays.copyOf(MANY_BYTES, 10);
        THIRTY_TWO_BYTES = Arrays.copyOf(MANY_BYTES, 32);
    }

    @Benchmark
    @OperationsPerInvocation(COMPARISONS_PER_INVOCATION)
    public final void compareOneByte(final Blackhole blackhole) {
        int res = 0;
        for (int i = 0; i < COMPARISONS_PER_INVOCATION; ++i) {
            res += FasterByteComparison.compare(ONE_BYTE, MANY_BYTES);
        }
        blackhole.consume(res);
    }

    @Benchmark
    @OperationsPerInvocation(COMPARISONS_PER_INVOCATION)
    public final void compareTwoBytes(final Blackhole blackhole) {
        int res = 0;
        for (int i = 0; i < COMPARISONS_PER_INVOCATION; ++i) {
            res += FasterByteComparison.compare(TWO_BYTES, MANY_BYTES);
        }
        blackhole.consume(res);
    }

    @Benchmark
    @OperationsPerInvocation(COMPARISONS_PER_INVOCATION)
    public final void compareThreeBytes(final Blackhole blackhole) {
        int res = 0;
        for (int i = 0; i < COMPARISONS_PER_INVOCATION; ++i) {
            res += FasterByteComparison.compare(THREE_BYTES, MANY_BYTES);
        }
        blackhole.consume(res);
    }

    @Benchmark
    @OperationsPerInvocation(COMPARISONS_PER_INVOCATION)
    public final void compareFourBytes(final Blackhole blackhole) {
        int res = 0;
        for (int i = 0; i < COMPARISONS_PER_INVOCATION; ++i) {
            res += FasterByteComparison.compare(FOUR_BYTES, MANY_BYTES);
        }
        blackhole.consume(res);
    }

    @Benchmark
    @OperationsPerInvocation(COMPARISONS_PER_INVOCATION)
    public final void compareFiveBytes(final Blackhole blackhole) {
        int res = 0;
        for (int i = 0; i < COMPARISONS_PER_INVOCATION; ++i) {
            res += FasterByteComparison.compare(FIVE_BYTES, MANY_BYTES);
        }
        blackhole.consume(res);
    }

    @Benchmark
    @OperationsPerInvocation(COMPARISONS_PER_INVOCATION)
    public final void compareSixBytes(final Blackhole blackhole) {
        int res = 0;
        for (int i = 0; i < COMPARISONS_PER_INVOCATION; ++i) {
            res += FasterByteComparison.compare(SIX_BYTES, MANY_BYTES);
        }
        blackhole.consume(res);
    }

    @Benchmark
    @OperationsPerInvocation(COMPARISONS_PER_INVOCATION)
    public final void compareSevenBytes(final Blackhole blackhole) {
        int res = 0;
        for (int i = 0; i < COMPARISONS_PER_INVOCATION; ++i) {
            res += FasterByteComparison.compare(SEVEN_BYTES, MANY_BYTES);
        }
        blackhole.consume(res);
    }

    @Benchmark
    @OperationsPerInvocation(COMPARISONS_PER_INVOCATION)
    public final void compareEightBytes(final Blackhole blackhole) {
        int res = 0;
        for (int i = 0; i < COMPARISONS_PER_INVOCATION; ++i) {
            res += FasterByteComparison.compare(EIGHT_BYTES, MANY_BYTES);
        }
        blackhole.consume(res);
    }

    @Benchmark
    @OperationsPerInvocation(COMPARISONS_PER_INVOCATION)
    public final void compareNineBytes(final Blackhole blackhole) {
        int res = 0;
        for (int i = 0; i < COMPARISONS_PER_INVOCATION; ++i) {
            res += FasterByteComparison.compare(NINE_BYTES, MANY_BYTES);
        }
        blackhole.consume(res);
    }

    @Benchmark
    @OperationsPerInvocation(COMPARISONS_PER_INVOCATION)
    public final void compareTenBytes(final Blackhole blackhole) {
        int res = 0;
        for (int i = 0; i < COMPARISONS_PER_INVOCATION; ++i) {
            res += FasterByteComparison.compare(TEN_BYTES, MANY_BYTES);
        }
        blackhole.consume(res);
    }

    @Benchmark
    @OperationsPerInvocation(COMPARISONS_PER_INVOCATION)
    public final void compareThirtyTwoBytes(final Blackhole blackhole) {
        int res = 0;
        for (int i = 0; i < COMPARISONS_PER_INVOCATION; ++i) {
            res += FasterByteComparison.compare(THIRTY_TWO_BYTES, MANY_BYTES);
        }
        blackhole.consume(res);
    }
}
