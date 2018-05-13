/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minions.devfund.weekOne;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Denis Parra
 */
public class WhackAMoleTest {
    
    private WhackAMole whackAMole;
    
    @Before
    public void setUp() {
       whackAMole = new WhackAMole(10, 10);
    }

    @Test
    public void testPlaceAMole() {
        assertTrue(whackAMole.place(2, 2));
    }

    @Test
    public void testPlaceAMoleInInvalidPlace() {
        whackAMole.place(2, 2);
        assertFalse(whackAMole.place(2, 2));
    }

    @Test
    public void testFoundAMole() {
        whackAMole.place(2, 2);
        whackAMole.whack(2, 2);
        assertEquals(1, whackAMole.getScore());
        assertEquals(9, whackAMole.getMolesLeft());
        assertEquals(9, whackAMole.getAttemptsLeft());
    }

    @Test
    public void testSearchAMoleWhenTheMoleIsNotInTheCoordinate() {
        whackAMole.place(2, 2);
        whackAMole.whack(2, 1);
        assertEquals(0, whackAMole.getScore());
    }

    @Test
    public void testPrintUserGrid() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.place(3, 3);
        whackAMole.place(4, 4);
        whackAMole.place(5, 5);
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

    @Test
    public void testPrintGrid() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.place(3, 3);
        whackAMole.place(4, 4);
        whackAMole.place(5, 5);
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
