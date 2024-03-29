import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    private Image x, o;

    private TicTacToeViewer ttt;


    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer ttt) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

        this.ttt = ttt;

        x = ttt.getXImage();
        o = ttt.getOImage();
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g) {
        if(isWinningSquare){
            g.setColor(Color.GREEN);
            g.fillRoundRect((col + 1) * 100, (row + 1) *100, 100, 100, 10, 10);
        }
        g.setColor(Color.BLACK);
        g.drawRoundRect((col + 1) * 100, (row + 1) *100, 100, 100, 10, 10);
        if(marker.equals("X")){
            g.drawImage(x, (col + 1)* 100, (row + 1) * 100, 100, 100, ttt);
        }
        if(marker.equals("O")){
            g.drawImage(o, (col + 1)* 100, (row + 1) * 100, 100, 100, ttt);
        }
    }
}
