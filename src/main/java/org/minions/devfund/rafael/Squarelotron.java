package org.minions.devfund.rafael;

import java.util.Arrays;

/**
 * A Squarelotron consists basically of a matrix of numbers. This matrix can be decomposed as square rings which
 * can flip independently in two different ways: Upside-Down and through the Main Diagonal.
 *
 * @author rafael alfaro
 * @version 1.0
 */
public class Squarelotron {

    public static final int MULTIPLE_FOUR = 4;
    public static final int SIZE_SQUARE = 5;
    private int[][] squarelotronGame;
    private int size;

    /**
     * Gets  squarelotronGame variable.
     *
     * @return int[] [] squarelotronGame game
     */
    public int[][] getSquarelotronGame() {
        return squarelotronGame;
    }

    /**
     * Gets  getSize variable.
     *
     * @return int Size
     */
    public int getSize() {
        return size;
    }

    /**
     * Squarelotron(int n) - It fills the 2-dimensional array with the numbers 1 to n squared, in order.
     * It also sets the size instance variable to be n.
     *
     * @param n nxn size of square
     */
    public Squarelotron(int n) {
        this.size = n;
        int valueCell = 1;
        squarelotronGame = new int[n][n];
        for (int indexX = 0; indexX < n; indexX++) {
            for (int indexY = 0; indexY < n; indexY++) {
                this.squarelotronGame[indexX][indexY] = valueCell;
                valueCell++;
            }
        }
    }

    /**
     * Verify that a square is inside the ring.
     *
     * @param indexX X
     * @param indexY Y
     * @param ring   ring to verify
     * @return boolean
     */
    public boolean isOnRingValidator(int indexX, int indexY, int ring) {
        return isOnRing(indexX, indexY, ring) && !isOutRing(indexX, indexY, ring);
    }

    /**
     * Verify if it is part of ring.
     *
     * @param indexX X
     * @param indexY Y
     * @param ring   ring to validate
     * @return boolean
     */
    private boolean isOutRing(int indexX, int indexY, int ring) {
        return indexX <= ring - 2 || indexX >= size + 1 - ring || indexY <= ring - 2 || indexY >= size + 1 - ring;
    }

    /**
     * Verify if cell with position (indexX,indexX) is part of ring.
     *
     * @param indexX X
     * @param indexY Y
     * @param ring   ring to validate
     * @return boolean
     */
    private boolean isOnRing(int indexX, int indexY, int ring) {
        boolean positionRing = indexX == ring - 1 || indexY == ring - 1;
        boolean positionSize = indexX == size - ring || indexY == size - ring;
        return positionRing || positionSize;
    }

    /**
     * This method calculate the rings number.
     *
     * @return int size
     */
    private int calculateTotalRings() {
        if (size % 2 == 0) {
            return (size + 1) / 2;
        } else {
            return size / 2;
        }
    }

    /**
     * This method performs the Upside-Down Flip of the squarelotronGame, as described above,
     * and returns the new squarelotronGame. The original squarelotronGame should not be modified
     * (we will check for this).
     *
     * @param ring ring number
     * @return Squarelotron square result
     */
    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron newSquarelotron = new Squarelotron(size);
        for (int indexX = 0; indexX < size; indexX++) {
            for (int indexY = 0; indexY < size; indexY++) {
                if (isOnRingValidator(indexX, indexY, ring)) {
                    newSquarelotron.squarelotronGame[indexX][indexY] = this.squarelotronGame[size - 1 - indexX][indexY];
                }
            }
        }
        return newSquarelotron;
    }

    /**
     * This method performs the Main Diagonal Flip of the squarelotronGame, as described above, and returns
     * the new squarelotronGame. The original squarelotronGame should not be modified (we will check for this).
     *
     * @param ring ring number
     * @return Squarelotron square result
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron newSquarelotron = new Squarelotron(size);
        for (int indexX = 0; indexX < size; indexX++) {
            for (int indexY = 0; indexY < size; indexY++) {
                if (isOnRingValidator(indexX, indexY, ring)) {
                    newSquarelotron.squarelotronGame[indexX][indexY] = this.squarelotronGame[indexY][indexX];
                }
            }
        }
        return newSquarelotron;
    }

    /**
     * The argument numberOfTurns indicates the number of times the entire squarelotronGame should be rotated 90° clockwise
     * Any integer, including zero and negative integers, is allowable as the argument.
     * A value of -1 indicates a 90° counterclockwise rotation. This method modifies the internal representation
     * of the squarelotronGame; it does not create a new squarelotronGame.
     *
     * @param numberOfTurns number of turns
     */
    public void rotateRight(int numberOfTurns) {
        // take care of negative number of turns
        numberOfTurns = (numberOfTurns % MULTIPLE_FOUR + MULTIPLE_FOUR) % MULTIPLE_FOUR;

        for (int n = 0; n < numberOfTurns; n++) {
            Squarelotron newSquarelotron = new Squarelotron(size);
            for (int indexX = 0; indexX < size; indexX++) {
                for (int indexY = 0; indexY < size; indexY++) {
                    newSquarelotron.squarelotronGame[indexY][size - 1 - indexX] = squarelotronGame[indexX][indexY];
                }
            }
            this.squarelotronGame = newSquarelotron.squarelotronGame;
        }
    }

    /**
     * Displays the squarelotronGame in the screen.
     *
     * @param size         size
     * @param squarelotron game
     */
    private void displaySquarelotron(final int size, final Squarelotron squarelotron) {
        for (int indexX = 0; indexX < size; indexX++) {
            for (int indexY = 0; indexY < size; indexY++) {
                System.out.print(" " + squarelotron.isOnRingValidator(indexX, indexY, calculateTotalRings()));
            }
            System.out.println();
        }
    }

    /**
     * Verify that the matrix is equal to squarelotronGame.
     *
     * @param matrix matrix to compare
     * @return boolean true if the matrix are equals
     */
    public boolean isEqualMatrix(final int[][] matrix) {
        if ((squarelotronGame.length != matrix.length) && (squarelotronGame[0].length != matrix[0].length)) {
            System.out.println("The Sizes are not equals");
            return false;
        }
        return Arrays.deepEquals(squarelotronGame, matrix);
    }

    /**
     * Squarelotron main program.
     *
     * @param args this program doesn't have arguments
     */
    public static void main(final String[] args) {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARE);
        squarelotron = squarelotron.mainDiagonalFlip(SIZE_SQUARE);
        squarelotron.displaySquarelotron(SIZE_SQUARE, squarelotron);
    }
}
