import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferStrategy;
public class TicTacToeViewer extends JFrame{
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private final int TITLE_BAR_HEIGHT = 23;
    private  Square[][] board;;

    private TicTacToe ttt;
    private Image xImage, oImage;
    public TicTacToeViewer(Square[][] board, TicTacToe ttt){
        this.board = board;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.ttt = ttt;
        xImage = new ImageIcon("Resources/X.png").getImage();
        oImage = new ImageIcon("Resources/O.png").getImage();
    }


    public Image getXImage() {
        return xImage;
    }

    public Image getOImage() {
        return oImage;
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("0", 140, 85);
        g.drawString("1", 240, 85);
        g.drawString("2", 340, 85);
        g.drawString("0", 65, 155);
        g.drawString("1", 65, 255);
        g.drawString("2", 65, 355);

        if(ttt.getWinner().equals("X")) {
            g.setFont(new Font("Bold", Font.BOLD, 50));
            g.drawString("X Wins", 170, 450);
        }
        if(ttt.getWinner().equals("O")) {
            g.setFont(new Font("Bold", Font.BOLD, 50));
            g.drawString("O Wins", 170, 450);
        }
        if(ttt.checkTie()){
            g.setFont(new Font("Bold", Font.BOLD, 50));
            g.drawString("It's a Tie!", 145, 450);
        }
        for(Square[] row : board){
            for(Square square : row){
                square.draw(g);
            }
        }
    }



}
