/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minions.devfund.weekTwo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Denis Parra
 */
public class SquarelotronTest {

    private static final int[][] MATRIZ_ONE = new int [][] {{1}};
    private static final int[][] MATRIZ_TWO = new int [][] {{1, 2}, {3, 4}};
    private static final int[][] MATRIZ_THREE = new int [][] {{1, 2, 3},
                                                              {4, 5, 6},
                                                              {7, 8, 9}};
    private static final int[][] MATRIZ_FOUR = new int [][] {{1, 2, 3, 4},
                                                             {5, 6, 7, 8},
                                                             {9, 10, 11, 12},
                                                             {13, 14, 15, 16}};
    private static final int[][] MATRIZ_FIVE = new int [][] {{1, 2, 3, 4, 5},
                                                             {6, 7, 8, 9, 10},
                                                             {11, 12, 13, 14, 15},
                                                             {16, 17, 18, 19, 20},
                                                             {21, 22, 23, 24, 25}};
    private static final int[][] EXPECTED_ONE = {{3, 4}, {1, 2}};
    private static final int[][] EXPECTTED_TWO = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
    private static final int[][] EXPECTED_THREE = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static final int[][] EXPECTED_FOUR = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
    private static final int[][] EXPECTED_FIVE = {{1, 2, 3, 4},{5, 10, 11, 8},{9, 6, 7, 12}, {13, 14, 15, 16}};
    private static final int[][] EXPECTED_SIX = {{21, 22, 23, 24, 25},
                                                 {16, 7, 8, 9, 20},
                                                 {11, 12, 13, 14, 15},
                                                 {6, 17, 18, 19, 10},
                                                 {1, 2, 3, 4, 5}};
    private static final int[][] EXPECTED_SEVEN = {{1, 2, 3, 4, 5},
                                                   {6, 17, 18, 19, 10},
                                                   {11, 12, 13, 14, 15},
                                                   {16, 7, 8, 9, 20},
                                                   {21, 22, 23, 24, 25}};
    private static final int[][] EXECTED_EIGTH = {{1, 2, 3, 4, 5},
                                                  {6, 7, 8, 9, 10},
                                                  {11, 12, 13, 14, 15},
                                                  {16, 17, 18, 19, 20},
                                                  {21, 22, 23, 24, 25}};
    private static final int[][] EXPECTED_NINE = {{1, 3}, {2, 4}};
    private static final int[][] EXPECTED_TEN = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
    private static final int[][] EXPECTED_ELEVEN = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static final int[][] EXPECTED_TWELVE = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
    private static final int[][] EXPECTED_THIRTEEN = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
    private static final int[][] EXPECTED_FORTEEN = {{1, 6, 11, 16, 21},
                                                     {2, 7, 8, 9, 22},
                                                     {3, 12, 13, 14, 23},
                                                     {4, 17, 18, 19, 24},
                                                     {5, 10, 15, 20, 25}};
    private static final int[][] EXPECTED_FIFTHEEN = {{1, 2, 3, 4, 5},
                                                      {6, 7, 12, 17, 10},
                                                      {11, 8, 13, 18, 15},
                                                      {16, 9, 14, 19, 20},
                                                      {21, 22, 23, 24, 25}};
    private static final int[][] EXPECTED_SIXTEEN = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
    private static final int[][] EXPECTED_SEVENTEEN = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
    private static final int[][] EXPECTED_EIGTHEEN = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
    private static final int[][] EXPECTED_NINETTEN = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static final int[][] EXPECTED_TWENTY_ONE = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
    private static final int[][] EXPECTED_TWENTY_TWO = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int ONE_NEGATIVE = -1;
    private static final int TWO_NEGATIVE = -2;
    private static final int THREE_NEGATIVE = -3;
    private static final int FOUR_NEGATIVE = -4;

    /**
     * To execute before each test.
     */
    @Before
    public void setUp() {
    }

    /**
     * Test to create a {@link Squarelotron} 1 * 1.
     */
    @Test
    public void testCreateASquarelotronWithLengthOne() {
        Squarelotron squarelotron = new Squarelotron(ONE);
        Assert.assertArrayEquals(MATRIZ_ONE, squarelotron.getMatriz());
    }

    /**
     * Test to create a {@link Squarelotron} 2 * 2.
     */
    @Test
    public void testCreateASquarelotronWithLengthTwo() {
        Squarelotron squarelotron = new Squarelotron(TWO);
        Assert.assertArrayEquals(MATRIZ_TWO, squarelotron.getMatriz());
    }

    /**
     * Test to create a {@link Squarelotron} 3 * 3.
     */
    @Test
    public void testCreateASquarelotronWithLengthThree() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        Assert.assertArrayEquals(MATRIZ_THREE, squarelotron.getMatriz());
    }

    /**
     * Test to create a {@link Squarelotron} 4 * 4.
     */
    @Test
    public void testCreateASquarelotronWithLengthFour() {
        Squarelotron squarelotron = new Squarelotron(FOUR);
        Assert.assertArrayEquals(MATRIZ_FOUR, squarelotron.getMatriz());
    }

    /**
     * Test to create a {@link Squarelotron} 5 * 5.
     */
    @Test
    public void testCreateASquarelotronWithLengthFive() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        Assert.assertArrayEquals(MATRIZ_FIVE, squarelotron.getMatriz());
    }

    /**
     * Test to upside Down Flip method.
     */
    @Test
    public void testUpsideDownFlipInMatrizOneByOne() {
        Squarelotron squarelotron = new Squarelotron(ONE);
        int[][] result = squarelotron.upsideDownFlip(ONE);
        Assert.assertArrayEquals(MATRIZ_ONE, result);
    }

    /**
     * Test to upside Down Flip method.
     */
    @Test
    public void testUpsideDownFlipInMatrizTwoByTwo() {
        Squarelotron squarelotron = new Squarelotron(TWO);
        int[][] result = squarelotron.upsideDownFlip(ONE);
        Assert.assertArrayEquals(EXPECTED_ONE, result);
    }

    /**
     * Test to upside Down Flip method.
     */
    @Test
    public void testUpsideDownFlipInMatrizThreeByThree() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        int[][] result = squarelotron.upsideDownFlip(ONE);
        Assert.assertArrayEquals(EXPECTTED_TWO, result);
    }

    /**
     * Test to upside Down Flip method.
     */
    @Test
    public void testUpsideDownFlipInMatrizThreeByThreeSecondRing() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        int[][] result = squarelotron.upsideDownFlip(TWO);
        Assert.assertArrayEquals(EXPECTED_THREE, result);
    }

    
    /**
     * Test to upside Down Flip method.
     */
    @Test
    public void testUpsideDownFlipInMatrizFourByFour() {
        Squarelotron squarelotron = new Squarelotron(FOUR);
        int[][] result = squarelotron.upsideDownFlip(ONE);
        Assert.assertArrayEquals(EXPECTED_FOUR, result);
    }

    /**
     * Test to upside Down Flip method.
     */
    @Test
    public void testUpsideDownFlipInMatrizFourByFourSecondRing() {
        Squarelotron squarelotron = new Squarelotron(FOUR);
        int[][] result = squarelotron.upsideDownFlip(TWO);
        Assert.assertArrayEquals(EXPECTED_FIVE, result);
    }

    /**
     * Test to upside Down Flip method.
     */
    @Test
    public void testUpsideDownFlipInMatrizFivebyFive() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        int[][] result = squarelotron.upsideDownFlip(ONE);
        Assert.assertArrayEquals(EXPECTED_SIX, result);
    }

    /**
     * Test to upside Down Flip method.
     */
    @Test
    public void testUpsideDownFlipInMatrizFivebyFiveSeconRing() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        int[][] result = squarelotron.upsideDownFlip(TWO);
        Assert.assertArrayEquals(EXPECTED_SEVEN, result);
    }

    
    /**
     * Test to upside Down Flip method.
     */
    @Test
    public void testUpsideDownFlipInMatrizFivebyFiveThirdRing() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        int[][] result = squarelotron.upsideDownFlip(THREE);
        Assert.assertArrayEquals(EXECTED_EIGTH, result);
    }

    /**
     * Test to main diagonal flip method..
     */
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizTwoByTwo() {
        Squarelotron squarelotron = new Squarelotron(TWO);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(ONE);
        Assert.assertArrayEquals(EXPECTED_NINE, result);
    }

    /**
     * Test to main diagonal flip method..
     */
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizThreeByThree() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(ONE);
        Assert.assertArrayEquals(EXPECTED_TEN, result);
    }

    /**
     * Test to main diagonal flip method..
     */
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizThreeByThreeSeconRing() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(TWO);
        Assert.assertArrayEquals(EXPECTED_ELEVEN, result);
    }

    
    /**
     * Test to main diagonal flip method..
     */
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizFourByFour() {
        Squarelotron squarelotron = new Squarelotron(FOUR);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(ONE);
        Assert.assertArrayEquals(EXPECTED_TWELVE, result);
    }

    
    /**
     * Test to main diagonal flip method..
     */
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizFourByFourSecondRing() {
        Squarelotron squarelotron = new Squarelotron(FOUR);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(TWO);
        Assert.assertArrayEquals(EXPECTED_THIRTEEN, result);
    }

    
    /**
     * Test to main diagonal flip method..
     */
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizFiveByFive() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(ONE);
        Assert.assertArrayEquals(EXPECTED_FORTEEN, result);
    }

    
    /**
     * Test to main diagonal flip method..
     */
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizFiveByFiveSecondRing() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(TWO);
        Assert.assertArrayEquals(EXPECTED_FIFTHEEN, result);
    }

    
    /**
     * Test to main diagonal flip method..
     */
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizFiveByFiveThirdRing() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(THREE);
        Assert.assertArrayEquals(MATRIZ_FIVE, result);
    }

    /**
     * Test to retotate rigth curretn matriz.
     */
    @Test
    public void testRotateRigthOneTime() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        squarelotron.rotateRigth(ONE);
        Assert.assertArrayEquals(EXPECTED_SIXTEEN, squarelotron.getMatriz());
    }

    /**
     * Test to retotate rigth curretn matriz.
     */    
    @Test
    public void testRotateRigthTwoTimes() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        squarelotron.rotateRigth(TWO);
        Assert.assertArrayEquals(EXPECTED_SEVENTEEN, squarelotron.getMatriz());
    }
    
    /**
     * Test to retotate rigth curretn matriz.
     */
    @Test
    public void testRotateRigthThreeTimes() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        squarelotron.rotateRigth(THREE);
        Assert.assertArrayEquals(EXPECTED_EIGTHEEN, squarelotron.getMatriz());
    }

        
    /**
     * Test to retotate rigth curretn matriz.
     */
    @Test
    public void testRotateRigthFourTimes() {
        Squarelotron squarelotron = new Squarelotron(3);
        squarelotron.rotateRigth(FOUR);
        Assert.assertArrayEquals(EXPECTED_NINETTEN, squarelotron.getMatriz());
    }

        
    /**
     * Test to retotate rigth curretn matriz.
     */
    @Test
    public void testRotateRigthOneTimeNegative() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        squarelotron.rotateRigth(ONE_NEGATIVE);
        Assert.assertArrayEquals(EXPECTED_EIGTHEEN, squarelotron.getMatriz());
    }

        
    /**
     * Test to retotate rigth curretn matriz.
     */
    @Test
    public void testRotateRigthTwoTimesNegative() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        squarelotron.rotateRigth(TWO_NEGATIVE);
        Assert.assertArrayEquals(EXPECTED_SEVENTEEN, squarelotron.getMatriz());
    }
    
    /**
     * Test to retotate rigth curretn matriz.
     */
    @Test
    public void testRotateRigthThreeTimesNegative() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        squarelotron.rotateRigth(THREE_NEGATIVE);
        Assert.assertArrayEquals(EXPECTED_TWENTY_ONE, squarelotron.getMatriz());
    }

        
    /**
     * Test to retotate rigth curretn matriz.
     */
    @Test
    public void testRotateRigthFourTimesNegative() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        squarelotron.rotateRigth(FOUR_NEGATIVE);
        Assert.assertArrayEquals(EXPECTED_TWENTY_TWO, squarelotron.getMatriz());
    }
}
