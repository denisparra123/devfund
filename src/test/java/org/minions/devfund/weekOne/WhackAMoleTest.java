/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minions.devfund.weekOne;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Denis Parra
 */
public class WhackAMoleTest {

    private static final int INIT_LENGTH = 10;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 4;
    private static final int NINE = 9;
    private WhackAMole whackAMole;

    /**
     *  Setup test before each test.
     */
    @Before
    public void setUp() {
       whackAMole = new WhackAMole(INIT_LENGTH, INIT_LENGTH);
    }

    /**
     * Test to put a mole in a place.
     */
    @Test
    public void testPlaceAMole() {
        assertTrue(whackAMole.place(TWO, TWO));
    }

    /**
     *  Test try to put a mole in same place.
     */
    @Test
    public void testPlaceAMoleInInvalidPlace() {
        whackAMole.place(TWO, TWO);
        assertFalse(whackAMole.place(TWO, TWO));
    }

    /**
     * Test to find a mole in a place.
     */
    @Test
    public void testFoundAMole() {
        whackAMole.place(TWO, TWO);
        whackAMole.whack(TWO, TWO);
        assertEquals(ONE, whackAMole.getScore());
        assertEquals(NINE, whackAMole.getMolesLeft());
        assertEquals(NINE, whackAMole.getAttemptsLeft());
    }

    /**
     *  Test to finad a module in a place when not exist.
     */
    @Test
    public void testSearchAMoleWhenTheMoleIsNotInTheCoordinate() {
        whackAMole.place(TWO, TWO);
        whackAMole.whack(TWO, ONE);
        assertEquals(0, whackAMole.getScore());
    }

    /**
     *  Test to print the grid to user.
     */
    @Test
    public void testPrintUserGrid() {
        whackAMole.place(ZERO, ZERO);
        whackAMole.place(ONE, ONE);
        whackAMole.place(TWO, TWO);
        whackAMole.place(THREE, THREE);
        whackAMole.place(FOUR, FOUR);
        whackAMole.place(FIVE, FIVE);
        StringBuilder boardExpected = new StringBuilder();
        boardExpected.append("**********\n");
        boardExpected.append("**********\n");
        boardExpected.append("**********\n");
        boardExpected.append("**********\n");
        boardExpected.append("**********\n");
        boardExpected.append("**********\n");
        boardExpected.append("**********\n");
        boardExpected.append("**********\n");
        boardExpected.append("**********\n");
        boardExpected.append("**********");
        assertEquals(boardExpected.toString(), whackAMole.printGridToUser());
    }

    /**
     *  Test to print the entire grid.
     */
    @Test
    public void testPrintGrid() {
        whackAMole.place(ZERO, ZERO);
        whackAMole.place(ONE, ONE);
        whackAMole.place(TWO, TWO);
        whackAMole.place(THREE, THREE);
        whackAMole.place(FOUR, FOUR);
        whackAMole.place(FIVE, FIVE);
        StringBuilder boardExpected = new StringBuilder();
        boardExpected.append("M*********\n");
        boardExpected.append("*M********\n");
        boardExpected.append("**M*******\n");
        boardExpected.append("***M******\n");
        boardExpected.append("****M*****\n");
        boardExpected.append("*****M****\n");
        boardExpected.append("**********\n");
        boardExpected.append("**********\n");
        boardExpected.append("**********\n");
        boardExpected.append("**********");
        assertEquals(boardExpected.toString(), whackAMole.printGrid());
    }
}
