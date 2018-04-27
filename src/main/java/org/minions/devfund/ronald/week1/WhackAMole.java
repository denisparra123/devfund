package org.minions.devfund.ronald.week1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Whack A Mole class.
 */
public class WhackAMole {

    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * Constructor.
     *
     * @param numAttempts   number attempts
     * @param gridDimension mole grid dimension
     */
    WhackAMole(int numAttempts, int gridDimension) {
        moleGrid = new char[gridDimension][gridDimension];
        attemptsLeft = numAttempts;
        score = 0;
        molesLeft = 0;

        // Fill Mole grid with default value
        for (char[] grid : moleGrid) {
            Arrays.fill(grid, '*');
        }
    }

    /**
     * Retrieve score.
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * place mole on grid.
     *
     * @param x row
     * @param y column
     * @return true if it was placed otherwise false
     */
    boolean place(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            return false;
        }
        moleGrid[x][y] = 'M';
        molesLeft++;

        return true;
    }

    /**
     * Whack mole action.
     *
     * @param x row
     * @param y column
     */
    void whack(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            moleGrid[x][y] = 'W';
            score++;
            attemptsLeft--;
            molesLeft--;

        } else {
            attemptsLeft--;
        }
    }

    /**
     * Print Mole Grid to User. Hide moles.
     */
    void printGridToUser() {
        for (char[] row : moleGrid) {
            for (char place : row) {
                if (place == 'M') {
                    System.out.print('*' + "\t");
                } else {
                    System.out.print(place + "\t");
                }
            }
            System.out.println("\n");
        }
    }

    /**
     * Print MoleGrid.
     */
    void printGrid() {

        for (char[] row : moleGrid) {
            for (char place : row) {
                System.out.print(place + "\t");
            }
            System.out.println("\n");
        }
    }

    /**
     * Main method.
     *
     * @param args arguments
     */
    public static void main(final String[] args) {
        final int numAttempts = 50;
        final int gridDimension = 10;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);

        Random r = new Random();
        int count = Integer.valueOf(gridDimension);
        // Place a mole on grid
        while (count > 0) {
            int x = r.nextInt(gridDimension);
            int y = r.nextInt(gridDimension);
            if (whackAMole.place(x, y)) {
                count--;
            }
        }
        System.out.println("You have a maximum of " + numAttempts + " attempts");
        String charSetName = "UTF-8";
        while (whackAMole.attemptsLeft > 0) {

            // Retrieve user input
            Scanner scanner = new Scanner(System.in, charSetName);
            System.out.println("Insert 'x' parameter between 0 - 9:");
            int x = scanner.nextInt();
            System.out.println("Insert 'y' parameter between 0 - 9:");
            int y = scanner.nextInt();

           /*Finish the game.*/
            if (x == -1 && y == -1) {
                System.out.println("Game Finished");
                whackAMole.printGrid();
                break;
            }

            whackAMole.whack(x, y);

            //if the user whack all moles. Finish the game
            if (whackAMole.molesLeft == 0) {
                System.out.println("Game Finished. All moles were whacked");
                whackAMole.printGrid();
                break;
            }

            whackAMole.printGridToUser();
            System.out.println("\n");
        }
    }
}
