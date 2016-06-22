/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */
public class Model {
private int w = 7, h = 6, blockSize = 75, speler = 1;
    private int[][] board = new int[h][w];

    /*twee dimensionele array het aantal rijen en kolommen
    Start spel zonder chips in het bord
    0     0     0     0     0     0     0 
    0     0     0     0     0     0     0 
    0     0     0     0     0     0     0 
    0     0     0     0     0     0     0 
    0     0     0     0     0     0     0 
    0     0     0     0     0     0     0  */
    public void resetArray() {
        board= new int[h][w];
    }
    public int getSpeler(){
        return speler;
    }
    public int[][] getArray(){
        return board;
    }
    public void setChip(int kolom) {
        int rij = nextAvailable(kolom);
        if (rij >= 0) { 
            board[rij][kolom] = speler;
            // als de eerste speler aan zet was veranderen naar speler 2 ander andersom
          if(!isWinner()){
             if (speler == 1) {
                speler = 2;
            } else {
                speler = 1;
            }
          }


        }
    }

    void setSpeler(int i) {
        speler = i;
    }

    private int nextAvailable(int x) {
        int slot = -1;
        //van onder in de desbetreffende kolom naar boven kijken
        for (int y = h - 1; y >= 0; y--) {
            //als de positie op 0 staat wordt de bepaalde rij doorgegeven anders -1
            if (board[y][x] == 0) {
                slot = y;
                break;
            }
        }
        return slot;
    }

    private int onBoard(int y, int x) {
        //returned de positie van het bord maar als bij het checken van winneer een chip word gecheckt die niet op het bord ligt returned het 0
        return (y < 0 || x < 0 || y >= h || x >= w) ? 0 : board[y][x];
    }

    public boolean isWinner() {
        //rijen, kolommen en diagonalen checken op vier op een rij

        boolean winner = false;
        //Check rij
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                //als de positie niet nul is en het stuk rechts naast het stuk hetzelfde is enz... 
                if (onBoard(y, x) != 0 && onBoard(y, x) == onBoard(y, x + 1) && onBoard(y, x) == onBoard(y, x + 2) && onBoard(y, x) == onBoard(y, x + 3)) {
                    winner = true;
                    /*   board[y][x] = 3;
                    board[y][x + 1] = 3;
                    board[y][x + 2] = 3;
                    board[y][x + 3] = 3; */
                    break;
                }
            }
        }
        //Check kolom
        //hetzelfde als kolom maar dan verticaal
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (onBoard(y, x) != 0 && onBoard(y, x) == onBoard(y + 1, x) && onBoard(y, x) == onBoard(y + 2, x) && onBoard(y, x) == onBoard(y + 3, x)) {
                    winner = true;
                    /*  board[y][x] = 3;
                    board[y + 1][x] = 3;
                    board[y + 2][x] = 3;
                    board[y + 3][x] = 3; */
                    break;
                }
            }
        }
        //Check diagonaal (anders twee soorten diagonalen van linker boven hoek naar de rechter onderhoek --> d = 1 en van de rechter boven hoek naar de linker onderhoek --> -1
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                for (int d = -1; d <= 1; d += 2) {
                    if (onBoard(y, x) != 0 && onBoard(y, x) == onBoard(y + 1 * d, x + 1) && onBoard(y, x) == onBoard(y + 2 * d, x + 2) && onBoard(y, x) == onBoard(y + 3 * d, x + 3)) {
                        winner = true;
                        /*  board[y][x] = 3;
                        board[y + 1 * d][x + 1] = 3;
                        board[y + 2 * d][x + 2] = 3;
                        board[y + 3 * d][x + 3] = 3; */
                        break;
                    }
                }
            }
        }
        return winner;
    }
}
