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
        int numOfPlayers = scanner.nextInt();
        scanner.nextLine();

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.println("Enter player " + (i) + " name:");
            players.add(new Player(scanner.nextLine(), 0));
        }
        
        Board board = new Board(Rules.initSnakes(), Rules.initLadders());
        boolean gameStart = true;
        while (gameStart) {
            for (Player player : players) {
                int diceValue = Dice.roll();
                int initialPosition = player.position;
                player.position = board.nextPosition(player.position, diceValue);
                System.out.println(player.name + " rolled a " + diceValue + " and moved from " + initialPosition + " to " + player.position);
                
                if (board.isWinningPosition(player.position)) {
                    System.out.println(player.name + " wins the game!");
                    gameStart = false;
                    break;
                }
            }
        }
        scanner.close();
        }
    

    
}
