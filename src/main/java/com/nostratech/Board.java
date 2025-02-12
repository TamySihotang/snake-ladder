package com.nostratech;

import java.util.Map;

public class Board {
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int nextPosition(int currentPosition, int diceValue) {
        int newPosition = currentPosition + diceValue;
        if (newPosition > 100) {
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

    public boolean isWinningPosition(int position) {
        return position == 100;
    }
}
