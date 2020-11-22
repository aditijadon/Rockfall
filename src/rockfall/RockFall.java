package rockfall;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class RockFall extends JFrame {
    private JLabel statusbar;
    public RockFall() {
        initUI();
    }

    private void initUI() {
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("rockfall.Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar() { return statusbar; }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var game = new RockFall();
            game.setVisible(true);
        });
    }
}

