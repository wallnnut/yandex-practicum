package ru.common.random;

public class Random {
    private long seed = System.currentTimeMillis();

    private int next() {
        seed = (seed * 1103515245 + 12345) & 0x7fffffff;
        return (int) seed;
    }

    public int nextInt(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        return Math.abs(next()) % bound;
    }
}
