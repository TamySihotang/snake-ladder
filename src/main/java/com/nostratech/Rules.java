package com.nostratech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Rules {

    public static Map<Integer, Integer> initSnakes(){
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(98, 64);
        snakes.put(95, 75);
        snakes.put(93, 73);
        snakes.put(87, 15);
        snakes.put(62, 5);
        snakes.put(56, 53);
        snakes.put(41, 20);
        snakes.put(49, 9);
        snakes.put(33, 6);
        return snakes;
    }

    public static Map<Integer, Integer> initLadders(){
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(2, 37);
        ladders.put(10, 32);
        ladders.put(27, 46);
        ladders.put(51, 68);
        ladders.put(61, 79);
        ladders.put(65, 84);
        ladders.put(71, 91);
        ladders.put(81, 100);
        return ladders;
    }
}