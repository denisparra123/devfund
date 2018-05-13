/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minions.devfund.weekOne;

import java.util.Arrays;

/**
 *
 * @author Denis Parra
 */
public class WhackAMole {

    private static final char AVAILABLE_SPACE = '*';
    private static final char MOLE = 'M';
    private static final char WHACKAMOLE = 'W';
    private static final char END_OF_LINE = '\n';
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private final char[][] moleGrid;

    /**
     * Contructor to WhackAMole.
     * @param numAttempts number of attempts.
     * @param gridDimension length of board.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        attemptsLeft = numAttempts;
        molesLeft = gridDimension;
        moleGrid = new char[gridDimension][gridDimension];
        fillDefaultGrid();
        score = 0;
    }

    /**
     * This method is to put a mole in the grid.
     * @param x coordinate X of the grid.
     * @param y cooridnate Y of the grid.
     * @return true if stored succesfully or false in otherwise.
     */
    public boolean place(int x, int y) {
        boolean isAvailableSpace = AVAILABLE_SPACE == moleGrid[x][y];
        moleGrid[x][y] = isAvailableSpace ? MOLE : AVAILABLE_SPACE;
        return isAvailableSpace;
    }

    /**
     * This method is to check if exist a mole in a coordinate.
     * @param x coordinate X of the grid.
     * @param y cooridnate Y of the grid.
     */
    public void whack(int x, int y) {
        boolean isMole = MOLE == moleGrid[x][y];
        if (isMole) {
            moleGrid[x][y] = WHACKAMOLE;
            score++;
            molesLeft--;
        }
        attemptsLeft--;
    }

    /**
     *  This method is to print the grid to user player
     *  notice the moles is hidden.
     * @return the grid.
     */
    public String printGridToUser() {
        return getMoleGrid(true);
    }

    /**
     * This method is to print the entire grid.
     * @return the grid.
     */
    public String printGrid() {
        return getMoleGrid(false);
    }

    /**
     * This methosd is to get the current scrore.
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * This method is to get the current Moles left.
     * @return number of moles left
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * This method is to get the Attempts left.
     * @return number of attempts left
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * This method is to get the board.
     * @param isUser board is to user.
     * @return the board.
     */
    private String getMoleGrid(boolean isUser) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                boolean isMole = moleGrid[i][j] == MOLE;
                builder.append(isMole && isUser ? AVAILABLE_SPACE : moleGrid[i][j]);
            }
            builder.append(END_OF_LINE);
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }

    /**
     * Method to fill the board whit default value.
     */
    private void fillDefaultGrid() {
        for (char[] row : moleGrid) {
            Arrays.fill(row, AVAILABLE_SPACE);
        }
    }
}
