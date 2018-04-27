package minions.devfund.rafael;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * This Class contains the test related to Class Squarelotron.
 *
 * @author rafael alfaro
 * @version 1.0
 */
public class SquarelotronTest {

    private static final int SIZE_SQUARELOTRON_TWO = 2;
    private static final int SIZE_SQUARELOTRON_THREE = 3;
    private static final int SIZE_SQUARELOTRON_FIVE = 5;
    private static final int SIZE_SQUARELOTRON_FOUR = 4;

    /**
     * Verifies the numbers in the square generated.
     *
     * @param n            size
     * @param squarelotron square
     */
    private void squarelotronValidator(int n, final Squarelotron squarelotron) {
        int valueCell = 1;
        for (int indexX = 0; indexX < n; indexX++) {
            for (int indexY = 0; indexY < n; indexY++) {
                assertEquals(valueCell, squarelotron.getSquarelotronGame()[indexX][indexY]);
                valueCell++;
            }
        }
    }

    /**
     * This test will verify that was created a squarelotron 2 x 2.
     */
    @Test
    public void verifyConstructorSizeTwo() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_TWO);
        assertEquals(SIZE_SQUARELOTRON_TWO, squarelotron.getSize());
        squarelotronValidator(squarelotron.getSize(), squarelotron);
    }

    /**
     * This test will verify that was created a squarelotron 3 x 3.
     */
    @Test
    public void verifyConstructorSizeThree() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_THREE);
        assertEquals(SIZE_SQUARELOTRON_THREE, squarelotron.getSize());
        squarelotronValidator(squarelotron.getSize(), squarelotron);
    }

    /**
     * This test will verify that was created a squarelotron 5 x 5.
     */
    @Test
    public void verifyConstructorSizeFive() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_FIVE);
        assertEquals(SIZE_SQUARELOTRON_FIVE, squarelotron.getSize());
        squarelotronValidator(squarelotron.getSize(), squarelotron);
    }

    /**
     * This test will verify the rotate right.
     */
    @Test
    public void verifyRotateRight() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_TWO);
        squarelotron.rotateRight(1);
        final int[][] squarelotronValidator = {{3, 1}, {4, 2}};
        assertTrue(squarelotron.isEqualMatrix(squarelotronValidator));
    }

    /**
     * This test will verify the rotate left.
     */
    @Test
    public void verifyRotateRightWithNegativeValue() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_TWO);
        squarelotron.rotateRight(-1);
        final int[][] squarelotronValidator = {{2, 4}, {1, 3}};
        assertTrue(squarelotron.isEqualMatrix(squarelotronValidator));
    }

    /**
     * This test case will verify the squarelotron of 2x2 after to rotate two times.
     */
    @Test
    public void verifyRotateRightTwoTimes() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_TWO);
        squarelotron.rotateRight(2);
        final int[][] squarelotronValidator = {{4, 3}, {2, 1}};
        assertTrue(squarelotron.isEqualMatrix(squarelotronValidator));
    }

    /**
     * This test case will verify the external ring in the squarelotron of 3x3 after to rotate one times.
     */
    @Test
    public void verifyRotateRightSquareSizeThree() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_THREE);
        squarelotron.rotateRight(1);
        final int[][] squarelotronValidator = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertTrue(squarelotron.isEqualMatrix(squarelotronValidator));
    }

    /**
     * This test case will verify the internal ring in the squarelotron of 3x3 after to rotate one times.
     */
    @Test
    public void verifySizeNoEquals() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_THREE);
        squarelotron.rotateRight(1);
        final int[][] squarelotronValidator = {{7, 4, 1}, {8, 5, 2}};
        assertFalse(squarelotron.isEqualMatrix(squarelotronValidator));
    }

    /**
     * This test case will verify the external ring in the squarelotron of 4x4 after to rotate one times.
     */
    @Test
    public void verifyUpsideDownFlipOneTimeAndSquareSizeFour() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_FOUR);
        squarelotron = squarelotron.upsideDownFlip(1);
        final int[][] squarelotronValidator = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        assertTrue(squarelotron.isEqualMatrix(squarelotronValidator));
    }

    /**
     * This test case will verify the external ring in the squarelotron of 4x4 after to rotate two times.
     */
    @Test
    public void verifyUpsideDownFlipTwoTimesAndSquareSizeFour() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_FOUR);
        squarelotron = squarelotron.upsideDownFlip(2);
        final int[][] squarelotronValidator = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        assertTrue(squarelotron.isEqualMatrix(squarelotronValidator));
    }

    /**
     * This test case will verify the diagonal flip in the squarelotron of 4x4.
     */
    @Test
    public void verifyMainDiagonalFlipTwoTimesAndSquareSizeFour() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_FOUR);
        squarelotron = squarelotron.mainDiagonalFlip(2);
        final int[][] squarelotronValidator = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        assertTrue(squarelotron.isEqualMatrix(squarelotronValidator));
    }

    /**
     * This test case will verify the diagonal flip in the squarelotron of 2x2.
     */
    @Test
    public void verifyUpsideDownFlipOneTimesAndSquareSizeTwo() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_TWO);
        squarelotron = squarelotron.mainDiagonalFlip(1);
        final int[][] squarelotronValidator = {{1, 3}, {2, 4}};
        assertTrue(squarelotron.isEqualMatrix(squarelotronValidator));
    }

    /**
     * This test case will verify the diagonal flip in the squarelotron of 3x3.
     */
    @Test
    public void verifyUpsideDownFlipOneTimesAndSquareSizeThree() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_THREE);
        squarelotron = squarelotron.mainDiagonalFlip(1);
        final int[][] squarelotronValidator = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertTrue(squarelotron.isEqualMatrix(squarelotronValidator));
    }

    /**
     * Verify if (indexX, indexY) is in the ring.
     */
    @Test
    public void veryIsOnRingSquareSizeFour() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_FOUR);
        assertTrue(squarelotron.isOnRingValidator(0, 0, 1));
        assertTrue(squarelotron.isOnRingValidator(1, 0, 1));
        assertTrue(squarelotron.isOnRingValidator(1, 1, 2));
        assertTrue(squarelotron.isOnRingValidator(2, 2, 2));
    }

    /**
     * Verify if (indexX, indexY) is not in the ring.
     */
    @Test
    public void veryIsOnRingSquareSizeFourNegativeCase() {
        Squarelotron squarelotron = new Squarelotron(SIZE_SQUARELOTRON_FOUR);
        assertFalse(squarelotron.isOnRingValidator(0, 0, 2));
        assertFalse(squarelotron.isOnRingValidator(0, 1, 2));
        assertFalse(squarelotron.isOnRingValidator(1, 1, 1));
        assertFalse(squarelotron.isOnRingValidator(1, 2, 1));
    }

}
