import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


    public class base extends JFrame {

        JLabel statusbar;


        public base() {

            statusbar = new JLabel(" 0");
            add(statusbar, BorderLayout.SOUTH);
            Boards b = new Boards();

            this.add(b);
            b.start();
            b.setVisible(true);

            setSize(200, 560);
            setTitle("Tetris");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }



        public JLabel getStatusBar() {
            return statusbar;
        }

        public static void main(String[] args) {

            base game = new base();
            game.setLocationRelativeTo(null);
            game.setVisible(true);

        }
    }

