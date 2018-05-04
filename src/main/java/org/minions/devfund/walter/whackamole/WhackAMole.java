package org.minions.devfund.walter.whackamole;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Class that handles the Whack a Mole game.
 */
public class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private int gridDimension;
    private char[][] moleGrid;

    private static final int SIZE = 10;
    private static final int NUM_ATTEMPTS = 50;
    private static final int MOLES = 10;

    /**
     * Returns the Score of the game.
     * @return integer as score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns the Grid Dimension.
     * @return integer of the dimension.
     */
    public int getGridDimension() {
        return gridDimension;
    }

    /**
     * Sets the grid dimension.
     * @param gridDimension integer of grid dimension.
     */
    public void setGridDimension(final int gridDimension) {
        this.gridDimension = gridDimension;
    }

    /**
     * Sets the score for the game.
     * @param score integer with new score.
     */
    public void setScore(final Integer score) {
        this.score = score;
    }

    /**
     * Gets the moles that left in the grid.
     * @return integer of moles left.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Sets the moles that left in the grid.
     * @param molesLeft integer with moles in grid.
     */
    public void setMolesLeft(final int molesLeft) {
        this.molesLeft = molesLeft;
    }

    /**
     * Gets the attempts remaining.
     * @return integer of attempts
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Sets the Attempts remaining.
     * @param attemptsLeft integer of attempts remaining.
     */
    private void setAttemptsLeft(final int attemptsLeft) {
        this.attemptsLeft = attemptsLeft;
    }

    /**
     * Prepares the Grid for the game.
     */
    public void setModeGrid() {
        this.moleGrid = new char[this.gridDimension][this.gridDimension];
        for (char[] row : moleGrid) {
            Arrays.fill(row, '*');
        }
    }

    /**
     * Constructor of WhackAMole game.
     * @param numAttempts number of attempts as integer.
     * @param gridDimension dimensions of the grid as integer.
     */
    public WhackAMole(final int numAttempts, final int gridDimension) {
        setAttemptsLeft(numAttempts);
        setGridDimension(gridDimension);
        setModeGrid();
        setScore(0);
    }

    /**
     * Places the moles in the grid.
     * @param x coordinate of the grid.
     * @param y coordinate of the grid.
     * @return Boolean if a mole can be placed in the grid
     */
    public Boolean place(final int x, final int y) {
        if (moleGrid[x][y] == '*') {
            moleGrid[x][y] = 'M';
            molesLeft++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Performs the whack in the grid.
     * @param x coordinate for the whack.
     * @param y coordinate for the whack.
     */
    public void whack(final int x, final int y) {
        if (x > 0 && x <= getGridDimension() && y > 0 && y <= getGridDimension()) {
            if (moleGrid[x][y] == 'M') {
                System.out.println("Great !!! you whack a mole ...");
                moleGrid[x][y] = 'W';
                score++;
                molesLeft--;
            } else {
                System.out.println("Ops !!! you didn't find a mole ...");
                moleGrid[x][y] = '*';
            }
        } else {
            System.out.println("Dimension of the grid is: " + getGridDimension() + "x" + getGridDimension());
            System.out.println("Please select a valid coordinates");
        }
        attemptsLeft--;
    }

    /**
     * Prints the Grid for the user hidden the Mole locations.
     */
    public void printGridToUser() {
        for (char[] row : moleGrid) {
            System.out.println(Arrays.toString(row).replace("M", "*")
                    .replace("[", " | ")
                    .replace(",", "")
                    .replace("]", " | "));
        }
    }

    /**
     * Prints the Grid with all the positions of the Moles and Whacks.
     */
    public void printGrid() {
        for (char[] row : moleGrid) {
            System.out.println(Arrays.toString(row).replace("[", " | ")
                    .replace(",", "")
                    .replace("]", " | "));
        }
    }

    /**
     * Generates a random number to locate a Mole.
     * @return integer.
     */
    public int getRandomNumberInRange() {

        if (0 >= getGridDimension() - 1) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt(getGridDimension() - 1);
    }

    /**
     * Main method to play the WhackAMole game.
     * @param args arguments.
     */
    public static void main(final String[] args) {
        Scanner reader = new Scanner(System.in, "UTF-8");
        int moles = MOLES;

        WhackAMole game = new WhackAMole(NUM_ATTEMPTS, SIZE);
        System.out.println(":::: Locate Moles in the Grid ::::");
        do {
            int xCoordinate = game.getRandomNumberInRange();
            int yCoordinate = game.getRandomNumberInRange();
            if (game.place(xCoordinate, yCoordinate)) {
                moles--;
            }
        } while (moles > 0);

        game.printGridToUser();

        System.out.println(":::: Time to Whack to Moles in the Grid ::::");
        do {
            System.out.println("Introduce Coordinate X to Whack:");
            int xWhack = reader.nextInt();
            System.out.println("Introduce Coordinate Y to Whack:");
            int yWhack = reader.nextInt();
            if (xWhack == -1 && yWhack == -1) {
                System.out.println("Try Again!!! ... Don't give up !!!");
                break;
            }
            game.whack(xWhack, yWhack);
            game.printGridToUser();
        } while (game.getAttemptsLeft() > 0 && game.getMolesLeft() > 0);

        System.out.println(":::: Final Grid ::::");
        game.printGrid();
        System.out.println("Your Score is: " + game.getScore());
        System.out.println("Moles alive: " + game.getMolesLeft());
    }
}

