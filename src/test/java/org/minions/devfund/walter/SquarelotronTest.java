package org.minions.devfund.walter;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * {@link SquarelotronTest} class to handle the tests of square matrix and operations.
 */
public class SquarelotronTest {

    /**
     * Compares an Expected Matrix with an Actual Matrix.
     *
     * @param expectedMatrix expected Matrix.
     * @param actualMatrix actual Matrix.
     */
    public void compareMatrix(final int[][] expectedMatrix, final int[][] actualMatrix) {
        for (int i = 0; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], actualMatrix[i]);
        }
    }

    /**
     * Tests a basic Upside Down Flip.
     */
    @Test
    public void upsideDownFlipBasicTest() {
        final int ringNumber = 1;
        final int dimension = 2;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{3, 4}, {1, 2}};
        Squarelotron squarelotronResult = squarelotron.upsideDownFlip(ringNumber);
        compareMatrix(expectedMatrix, squarelotronResult.getSquarelotron());
    }

    /**
     * Tests a complex Upside Down Flip.
     */
    @Test
    public void upsideDownFlipComplexTest() {
        final int ringNumber = 1;
        final int dimension = 4;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        Squarelotron squarelotronResult = squarelotron.upsideDownFlip(ringNumber);
        compareMatrix(expectedMatrix, squarelotronResult.getSquarelotron());
    }

    /**
     * Tests a basic Main Diagonal Flip.
     */
    @Test
    public void mainDiagonalFlipBasicTest() {
        final int ringNumber = 1;
        final int dimension = 2;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{1, 3}, {2, 4}};
        Squarelotron squarelotronResult = squarelotron.mainDiagonalFlip(ringNumber);
        compareMatrix(expectedMatrix, squarelotronResult.getSquarelotron());
    }

    /**
     * Tests a complex Main Diagonal Flip.
     */
    @Test
    public void mainDiagonalFlipComplexTest() {
        final int ringNumber = 1;
        final int dimension = 4;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        Squarelotron squarelotronResult = squarelotron.mainDiagonalFlip(ringNumber);
        compareMatrix(expectedMatrix, squarelotronResult.getSquarelotron());
    }

    /**
     * Tests a Clockwise rotation of Squarelotron matrix.
     */
    @Test
    public void rotateClockwiseMatrixTest() {
        final int numberOfTurns  = 1;
        final int dimension = 3;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        squarelotron.rotateRight(numberOfTurns);
        compareMatrix(expectedMatrix, squarelotron.getSquarelotron());
    }

    /**
     * Tests a Counter Clockwise rotation of Squarelotron matrix.
     */
    @Test
    public void rotateCounterClockwiseTest() {
        final int numberOfTurns  = -1;
        final int dimension = 3;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        squarelotron.rotateRight(numberOfTurns);
        compareMatrix(expectedMatrix, squarelotron.getSquarelotron());
    }

}
