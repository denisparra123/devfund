/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minions.devfund.weekTwo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Denis Parra
 */
public class SquarelotronTest {
    
    private int[][] matrizTestOne;
    private int[][] matrizTestTwo;
    private int[][] matrizTestThree;
    private int[][] matrizTestFour;
    private int[][] matrizTestFive;
    @Before
    public void setUp() {
        matrizTestOne = new int [][] {{1}};
        matrizTestTwo = new int [][] {{1, 2}, {3, 4}};
        matrizTestThree = new int [][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrizTestFour = new int [][] {{1, 2, 3, 4},
                                       {5, 6, 7, 8},
                                       {9, 10, 11, 12},
                                       {13, 14, 15, 16}};
        matrizTestFive = new int [][] {{1, 2, 3, 4, 5},
                                       {6, 7, 8, 9, 10},
                                       {11, 12, 13, 14, 15}, 
                                       {16, 17, 18, 19, 20},
                                       {21, 22, 23, 24, 25}};
    }

    @Test
    public void testCreateASquarelotronWithLengthOne() {
        Squarelotron squarelotron = new Squarelotron(1);
        Assert.assertArrayEquals(matrizTestOne, squarelotron.getMatriz());
    }

    @Test
    public void testCreateASquarelotronWithLengthTwo() {
        Squarelotron squarelotron = new Squarelotron(2);
        Assert.assertArrayEquals(matrizTestTwo, squarelotron.getMatriz());
    }

    @Test
    public void testCreateASquarelotronWithLengthThree() {
        Squarelotron squarelotron = new Squarelotron(3);
        Assert.assertArrayEquals(matrizTestThree, squarelotron.getMatriz());
    }

    @Test
    public void testCreateASquarelotronWithLengthFour() {
        Squarelotron squarelotron = new Squarelotron(4);
        Assert.assertArrayEquals(matrizTestFour, squarelotron.getMatriz());
    }

    @Test
    public void testCreateASquarelotronWithLengthFive() {
        Squarelotron squarelotron = new Squarelotron(5);
        Assert.assertArrayEquals(matrizTestFive, squarelotron.getMatriz());
    }
    
    @Test
    public void testUpsideDownFlipInMatrizOneByOne() {
        Squarelotron squarelotron = new Squarelotron(1);
        int[][] result = squarelotron.upsideDownFlip(1);
        Assert.assertArrayEquals(matrizTestOne, result);
    }
    
    @Test
    public void testUpsideDownFlipInMatrizTwoByTwo() {
        Squarelotron squarelotron = new Squarelotron(2);
        int[][] result = squarelotron.upsideDownFlip(1);
        int[][] expected = {{3, 4}, {1, 2}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testUpsideDownFlipInMatrizThreeByThree() {
        Squarelotron squarelotron = new Squarelotron(3);
        int[][] result = squarelotron.upsideDownFlip(1);
        int[][] expected = {{7, 8, 9},{4, 5, 6},{1, 2, 3}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testUpsideDownFlipInMatrizThreeByThreeSecondRing() {
        Squarelotron squarelotron = new Squarelotron(3);
        int[][] result = squarelotron.upsideDownFlip(2);
        int[][] expected = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testUpsideDownFlipInMatrizFourByFour() {
        Squarelotron squarelotron = new Squarelotron(4);
        int[][] result = squarelotron.upsideDownFlip(1);
        int[][] expected = {{13, 14, 15, 16},{9, 6, 7, 12},{5, 10, 11, 8}, {1, 2, 3, 4}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testUpsideDownFlipInMatrizFourByFourSecondRing() {
        Squarelotron squarelotron = new Squarelotron(4);
        int[][] result = squarelotron.upsideDownFlip(2);
        int[][] expected = {{1, 2, 3, 4},{5, 10, 11, 8},{9, 6, 7, 12}, {13, 14, 15, 16}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testUpsideDownFlipInMatrizFivebyFive() {
        Squarelotron squarelotron = new Squarelotron(5);
        int[][] result = squarelotron.upsideDownFlip(1);
        int[][] expected = {{21, 22, 23, 24, 25},
                            {16, 7, 8, 9, 20},
                            {11, 12, 13, 14, 15}, 
                            {6, 17, 18, 19, 10},
                            {1, 2, 3, 4, 5}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testUpsideDownFlipInMatrizFivebyFiveSeconRing() {
        Squarelotron squarelotron = new Squarelotron(5);
        int[][] result = squarelotron.upsideDownFlip(2);
        int[][] expected = {{1, 2, 3, 4, 5},
                            {6, 17, 18, 19, 10},
                            {11, 12, 13, 14, 15}, 
                            {16, 7, 8, 9, 20},
                            {21, 22, 23, 24, 25}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testUpsideDownFlipInMatrizFivebyFiveThirdRing() {
        Squarelotron squarelotron = new Squarelotron(5);
        int[][] result = squarelotron.upsideDownFlip(3);
        int[][] expected = {{1, 2, 3, 4, 5},
                            {6, 7, 8, 9, 10},
                            {11, 12, 13, 14, 15}, 
                            {16, 17, 18, 19, 20},
                            {21, 22, 23, 24, 25}};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizTwoByTwo() {
        Squarelotron squarelotron = new Squarelotron(2);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(1);
        int[][] expected = {{1, 3}, {2, 4}};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizThreeByThree() {
        Squarelotron squarelotron = new Squarelotron(3);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(1);
        int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizThreeByThreeSeconRing() {
        Squarelotron squarelotron = new Squarelotron(3);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(2);
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizFourByFour() {
        Squarelotron squarelotron = new Squarelotron(4);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(1);
        int[][] expected = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizFourByFourSecondRing() {
        Squarelotron squarelotron = new Squarelotron(4);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(2);
        int[][] expected = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizFiveByFive() {
        Squarelotron squarelotron = new Squarelotron(5);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(1);
        int[][] expected = {{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22}, {3, 12, 13, 14, 23}, {4, 17, 18, 19, 24}, {5, 10, 15, 20, 25}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizFiveByFiveSecondRing() {
        Squarelotron squarelotron = new Squarelotron(5);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(2);
        int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10}, {11, 8, 13, 18, 15}, {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSquarelotronMainDiagonalFlipInMatrizFiveByFiveThirdRing() {
        Squarelotron squarelotron = new Squarelotron(5);
        int[][] result = squarelotron.squarelotronMainDiagonalFlip(3);
        Assert.assertArrayEquals(matrizTestFive, result);
    }
    
    @Test
    public void testRotateRigthOneTime() {
        Squarelotron squarelotron = new Squarelotron(3);
        squarelotron.rotateRigth(1);
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Assert.assertArrayEquals(expected, squarelotron.getMatriz());
    }
    
    @Test
    public void testRotateRigthTwoTimes() {
        Squarelotron squarelotron = new Squarelotron(3);
        squarelotron.rotateRigth(2);
        int[][] expected = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Assert.assertArrayEquals(expected, squarelotron.getMatriz());
    }
    
    @Test
    public void testRotateRigthThreeTimes() {
        Squarelotron squarelotron = new Squarelotron(3);
        squarelotron.rotateRigth(3);
        int[][] expected = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        Assert.assertArrayEquals(expected, squarelotron.getMatriz());
    }
    
    @Test
    public void testRotateRigthFourTimes() {
        Squarelotron squarelotron = new Squarelotron(3);
        squarelotron.rotateRigth(4);
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Assert.assertArrayEquals(expected, squarelotron.getMatriz());
    }
    
    @Test
    public void testRotateRigthOneTimeNegative() {
        Squarelotron squarelotron = new Squarelotron(3);
        squarelotron.rotateRigth(-1);
        int[][] expected = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        Assert.assertArrayEquals(expected, squarelotron.getMatriz());
    }
    
    @Test
    public void testRotateRigthTwoTimesNegative() {
        Squarelotron squarelotron = new Squarelotron(3);
        squarelotron.rotateRigth(-2);
        int[][] expected = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Assert.assertArrayEquals(expected, squarelotron.getMatriz());
    }
    
    @Test
    public void testRotateRigthThreeTimesNegative() {
        Squarelotron squarelotron = new Squarelotron(3);
        squarelotron.rotateRigth(-3);
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Assert.assertArrayEquals(expected, squarelotron.getMatriz());
    }
    
    @Test
    public void testRotateRigthFourTimesNegative() {
        Squarelotron squarelotron = new Squarelotron(3);
        squarelotron.rotateRigth(-4);
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Assert.assertArrayEquals(expected, squarelotron.getMatriz());
    }
}