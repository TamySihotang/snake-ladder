package com.nostratech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of players:");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + " name:");
            players.add(new Player(scanner.nextLine()));
        }

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
        
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(2, 37);
        ladders.put(10, 32);
        ladders.put(27, 46);
        ladders.put(51, 68);
        ladders.put(61, 79);
        ladders.put(65, 84);
        ladders.put(71, 91);
        ladders.put(81, 100);
        
        Board board = new Board(snakes, ladders);
        boolean gameOn = true;
        while (gameOn) {
            for (Player player : players) {
                int diceValue = Dice.roll();
                int initialPosition = player.position;
                player.position = board.getNewPosition(player.position, diceValue);
                System.out.println(player.name + " rolled a " + diceValue + " and moved from " + initialPosition + " to " + player.position);
                
                if (board.winningPosition(player.position)) {
                    System.out.println(player.name + " wins the game!");
                    gameOn = false;
                    break;
                }
            }
        }
        scanner.close();
    }
}
