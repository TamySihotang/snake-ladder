package com.nostratech;

import java.util.Random;

public class Dice {
     private static final Random random = new Random();
    
    public static int roll() {
        return random.nextInt(7);
    }
}
