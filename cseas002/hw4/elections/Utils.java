package cseas002.hw4.elections;//package hw4.spring2021;

import java.util.Random;

public class Utils {

    private static final Random RANDOM = new Random();

    // DO NOT USE THIS METHOD IN THE CLASSES YOU WILL IMPLEMENT
    public static void setSeed(long seed) {
        RANDOM.setSeed(seed);
    }

    // Generates an integer between 0 and max (max not included)
    public static int randomInt(int max) {
        return RANDOM.nextInt(max);
    }
}

