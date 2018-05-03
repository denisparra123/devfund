package org.minions.devfund.walter;

import java.util.Arrays;

/**
 * {@link Squarelotron} class to handle the square matrix and operations.
 */
public class Squarelotron {

    private int[][] squarelotron;
    private int size;
    private static final int SIDES = 4;

    /**
     * Gets the squarelotron matrix.
     * @return matrix.
     */
    public int[][] getSquarelotron() {
        return squarelotron;
    }

    /**
     * Sets the squarelotron matrix.
     *
     * @param squarelotron square matrix.
     */
    public void setSquarelotron(final int[][] squarelotron) {
        this.squarelotron = squarelotron.clone();
    }

    /**
     * Initializes an instance of {@link Squarelotron}.
     *
     * @param n dimension of Size.
     */
    public Squarelotron(final int n) {
        size = n;
        fillSquare();
    }

    /**
     * Fills the values of the matrix.
     */
    public void fillSquare() {
        this.squarelotron = new int[size][size];
        int value = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.squarelotron[i][j] = value;
                value++;
            }
        }
        this.setSquarelotron(squarelotron);
    }

    /**
     * Performs a Upside Down Flip operation.
     *
     * @param ring number of ring.
     * @return {@link Squarelotron}.
     */
    public Squarelotron upsideDownFlip(final int ring) {
        Squarelotron newSquarelotron = new Squarelotron(size);
        int min = ring - 1;
        int max = this.size - ring;
        int pivot;
        int[][] cloneSquarelotron = squarelotron.clone();
        for (int i = min; i <= max; i++) {
            pivot = cloneSquarelotron[min][i];
            cloneSquarelotron[min][i] = cloneSquarelotron[max][i];
            cloneSquarelotron[max][i] = pivot;
        }
        if(this.size != 1) {
            for (int i = min; i <= max; i += max - min) {
                int row = max - 1;
                for (int j = min + 1; j < row; j++) {
                    pivot = cloneSquarelotron[j][i];
                    cloneSquarelotron[j][i] = cloneSquarelotron[row][i];
                    cloneSquarelotron[row][i] = pivot;
                    row--;
                }
                i = i == max ? i + 1 : i;
            }
        }
        newSquarelotron.setSquarelotron(cloneSquarelotron);
        return newSquarelotron;
    }

    /**
     * Performs a Main Diagonal Flip operation.
     *
     * @param ring number of ring.
     * @return {@link Squarelotron}.
     */
    public Squarelotron mainDiagonalFlip(final int ring) {
        Squarelotron newSquarelotron = new Squarelotron(size);
        int min = ring;
        int max = this.size - ring;
        int pivot;
        int[][] cloneSquarelotron = squarelotron.clone();
        for (int i = min; i <= max; i++) {
            pivot = cloneSquarelotron[i][ring - 1];
            cloneSquarelotron[i][ring - 1] = cloneSquarelotron[ring - 1][i];
            cloneSquarelotron[ring - 1][i] = pivot;
        }
        for (int i = min; i < max; i++) {
            pivot = cloneSquarelotron[i][max];
            cloneSquarelotron[i][max] = cloneSquarelotron[max][i];
            cloneSquarelotron[max][i] = pivot;
        }
        newSquarelotron.setSquarelotron(cloneSquarelotron);
        return newSquarelotron;
    }

    /**
     * Performs a Rotation of Matrix.
     *
     * @param numberOfTurns number of rotations.
     */
    public void rotateRight(final int numberOfTurns) {
        final int row = squarelotron.length;
        final int column = squarelotron[0].length;
        int[][] cloned = squarelotron.clone();
        int turns = numberOfTurns < 0 ? numberOfTurns % SIDES + SIDES : numberOfTurns % SIDES;
        while (turns > 0) {
            int[][] ret = new int[size][size];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    ret[j][row - 1 - i] = cloned[i][j];
                }
            }
            cloned = ret.clone();
            turns--;
            setSquarelotron(ret);
        }
    }

    /**
     * Prints the Grid of a matrix squarelotron.
     * @param matrix matrix squarelotron.
     */
    public void printMatrix(final int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row)
                    .replace("[", " | ")
                    .replace(",", "")
                    .replace("]", " | "));
        }
    }

    /**
     * Main method to execute the program.
     * @param args String arguments.
     */
    public static void main(final String[] args) {
        int size = 3;
        int rotation = -2;
        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.upsideDownFlip(2);
        squarelotron.printMatrix(squarelotron.squarelotron);
    }

}


