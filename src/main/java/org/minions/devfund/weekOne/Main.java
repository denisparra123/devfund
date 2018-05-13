/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minions.devfund.weekOne;

import java.util.Scanner;

/**
 *
 * @author Denis Parra
 */
public final class Main {

    private static final int ATTEMPTS = 50;
    private static final int LENGTH_GRID = 10;
    private static final int DEFAULT_NUMBER_TO_GIVE_UP = -1;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int NINE = 9;

    /**
     * Default constructor.
     */
    private Main() {
      //not called
    }

    /**
     * Main method.
     * @param args args.
     */
    public static void main(final String[] args) {
        WhackAMole board = new WhackAMole(ATTEMPTS, LENGTH_GRID);
        generateMoles(board, LENGTH_GRID);
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to the Whack a mole game, you must insert a coordinate x");
        System.out.println("and coordinate y to check if exists a mole, to give up in the game");
        System.out.println("you should insert -1 how coordinate x and y.");
        do {
            System.out.println("inster coordinate x: ");
            int coordinateX = reader.nextInt();
            System.out.println("insert coordinate y: ");
            int coordinateY = reader.nextInt();
            if (coordinateX == DEFAULT_NUMBER_TO_GIVE_UP
                    && coordinateY == DEFAULT_NUMBER_TO_GIVE_UP) {
                System.out.println("You give up!!!");
                System.out.println(board.printGrid());
                break;
            } else {
                board.whack(coordinateX, coordinateY);
                if (board.getAttemptsLeft() == ZERO) {
                    System.out.println("You lose the game !!!");
                    break;
                }
                if (board.getMolesLeft() == ZERO) {
                    System.out.println("You win the game!!!");
                    break;
                }
            }
        } while (true);
    }

    /**
     * Method to generate Moles to board.
     * @param board the board.
     * @param numberOfMoles max moles to generate.
     */
    private static void generateMoles(final WhackAMole board, final int numberOfMoles) {
        int cont = ZERO;
        while (cont != numberOfMoles) {
            int coordinateX = (int) (Math.random() * NINE) + ONE;
            int coordinateY = (int) (Math.random() * NINE) + ONE;
            boolean isMoleStored = board.place(coordinateX, coordinateY);
            if (isMoleStored) {
                cont = cont + ONE;
            }
        }
    }
}
