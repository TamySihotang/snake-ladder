package com.nostratech;

import java.util.Map;

public class Board {
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;
    private static final int WINNING_POSITION = 100;

    public Board(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getNewPosition(int currentPosition, int diceValue) {
        int newPosition = currentPosition + diceValue;
        if (newPosition > WINNING_POSITION) {
            return currentPosition;
        }
        while (snakes.containsKey(newPosition) || ladders.containsKey(newPosition)) {
            if (snakes.containsKey(newPosition)) {
                newPosition = snakes.get(newPosition);
            } else if (ladders.containsKey(newPosition)) {
                newPosition = ladders.get(newPosition);
            }
        }
        return newPosition;
    }

    public boolean winningPosition(int position) {
        return position == WINNING_POSITION;
    }
}
