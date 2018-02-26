package com.jait.util

import groovy.transform.CompileStatic

/**
 * https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string
 */
@CompileStatic
class RandomString {

    static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    static final String lower = upper.toLowerCase(Locale.ROOT)

    static final String digits = "0123456789"

    static final String alphanum = upper + lower + digits

    private Random random

    private char[] symbols

    private char[] buf

    RandomString(Random random, String symbols) {
        if (symbols.length() < 2) throw new IllegalArgumentException()
        this.random = Objects.requireNonNull(random)
        this.symbols = symbols.toCharArray()
    }

    /**
     * Generate a random string.
     */
    String nextRandom(int length) {
        buf = new char[length] //costly?
        for (int idx = 0; idx < buf.length; ++idx) buf[idx] = symbols[random.nextInt(symbols.length)]
        return new String(buf)
    }
}
