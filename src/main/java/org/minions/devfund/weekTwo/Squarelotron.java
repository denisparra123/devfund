/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.minions.devfund.weekTwo;

/**
 *
 * @author Denis Parra
 */
public class Squarelotron {

    private static final int MAX_ROTATIONS_TO_GET_INIT_MATRIZ = 4;
    private int[][] matriz;

    /**
     * THis default constructor.
     * @param n length of squarelotron
     */
    public Squarelotron(int n) {
        matriz = new int[n][n];
        fillMatriz(n);
    }

    /**
     * This method is to do a upside down flip.
     * @param ring number of ring where do this.
     * @return  a matriz with the action executed.
     */
    public int[][] upsideDownFlip(final int ring) {
        int[][] result = copyArray();
        if (matriz.length > 1) {
            int maxX = matriz.length - ring;
            int minX = ring - 1;
            for (int i = minX; i <= maxX; i++) {
                result[minX][i] = matriz[maxX][i];
                result[maxX][i] = matriz[minX][i];
            }
            int limit = (maxX - 1) / 2;
            int newMinX = minX + 1;
            int newMaxX = maxX - 1;
            for (int j = 0; j < limit; j++) {
                result[newMinX][minX] = matriz[newMaxX][minX];
                result[newMinX][maxX] = matriz[newMaxX][maxX];
                result[newMaxX][minX] = matriz[newMinX][minX];
                result[newMaxX][maxX] = matriz[newMinX][maxX];
                newMinX++;
                newMaxX--;
            }
        }
        return result;
    }

    /**
     * This method is to execute a main diagonal flip.
     * @param ring number of ring where execute this.
     * @return a matriz with the action executed
     */
    public int[][] squarelotronMainDiagonalFlip(final int ring) {
        int[][] result = copyArray();
        int initX = ring;
        int initY = ring - 1;
        int length = matriz.length;
        int repeats = matriz.length - ((ring - 1) * 2);
        repeats = getNumberOfRepeats(repeats);
        for (int i = 0; i < repeats; i++) {
            result[initX][initY] = matriz[initY][initX];
            result[initY][initX] = matriz[initX][initY];
            if (initX < length - ring) {
                initX++;
            } else {
                initY++;
            }
        }
        return result;
    }

    /**
     * this method is to rotate rigth the {@link Squarelotron}.
     * @param numberOfTurns number of rotations over matriz.
     */
    public void rotateRigth(int numberOfTurns) {
        while (numberOfTurns != 0) {
            if (numberOfTurns % MAX_ROTATIONS_TO_GET_INIT_MATRIZ == 0) {
                break;
            }
            if (numberOfTurns < 0) {
                matriz = squarelotronMainDiagonalFlip(1);
                matriz = upsideDownFlip(1);
                numberOfTurns++;
            } else {
                matriz = upsideDownFlip(1);
                matriz = squarelotronMainDiagonalFlip(1);
                numberOfTurns--;
            }
        }
    }

    /**
     * This method is to get the current matriz of {@link Squarelotron}.
     * @return a  matriz
     */
    public int[][] getMatriz() {
        return copyArray();
    }

    /**
     * This method create a copy of {@link Squarelotron} matriz.
     * @return a matriz.
     */
    private int[][] copyArray() {
        int[][] result = new int[matriz.length][];
        for (int i = 0; i < matriz.length; i++) {
            int[] aux = matriz[i];
            int aLength = aux.length;
            result[i] = new int[aLength];
            System.arraycopy(aux, 0, result[i], 0, aLength);
        }
        return result;
    }

    /**
     * This method is to calculate the numbber of iterations.
     * when a digonal flip is executed.
     * @param n current length of ring.
     * @return number of iterations to execute into diagonal flip.
     */
    private int getNumberOfRepeats(final int n) {
        if (n == 1) {
            return 0;
        }
        int result = 1;
        for (int i = 2; i < n; i++) {
            result = result + 2;
        }
        return result;
    }

    /**
     * This methos is to fill the {@link Squarelotron} matriz.
     * @param n length of the matriz.
     */
    private void fillMatriz(final int n) {
        int cont = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = cont++;
            }
        }
    }

}
