import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.util.Arrays;

public class TicTacToeGUI extends JFrame {
        private JLabel label1;
        private JLabel label2;
        private JButton btn1;
        private JButton btn2;
        private JButton btn3;
        private JLabel label3;
        private JButton btn4;
        private JButton btn5;
        private JButton btn6;
        private JLabel label4;
        private JLabel label5;
        private JLabel label6;
        private JButton btn7;
        private JButton btn8;
        private JButton btn9;
        private JLabel label7;
        private JLabel label8;
        private JLabel label9;

    private int[] boardState = new int[9];

    public TicTacToeGUI() {
        initComponents();

        btn1.addActionListener(e -> buttonActionPerformed(0));
        btn2.addActionListener(e -> buttonActionPerformed(1));
        btn3.addActionListener(e -> buttonActionPerformed(2));
        btn4.addActionListener(e -> buttonActionPerformed(3));
        btn5.addActionListener(e -> buttonActionPerformed(4));
        btn6.addActionListener(e -> buttonActionPerformed(5));
        btn7.addActionListener(e -> buttonActionPerformed(6));
        btn8.addActionListener(e -> buttonActionPerformed(7));
        btn9.addActionListener(e -> buttonActionPerformed(8));
        label4.addComponentListener(new ComponentAdapter() {
        });
    }

    private void initComponents() {
        // Initialize components

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(new java.awt.GridLayout(4, 3));

            label1 = new JLabel();
            label2 = new JLabel();
            btn1 = new JButton();
            btn2 = new JButton();
            btn3 = new JButton();
            label3 = new JLabel();
            btn4 = new JButton();
            btn5 = new JButton();
            btn6 = new JButton();
            label4 = new JLabel();
            label5 = new JLabel();
            label6 = new JLabel();
            btn7 = new JButton();
            btn8 = new JButton();
            btn9 = new JButton();
            label7 = new JLabel();
            label8 = new JLabel();
            label9 = new JLabel();

            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setText("Label 1");
            getContentPane().add(label1);

            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setText("Label 2");
            getContentPane().add(label2);

            btn1.setText("Button 1");
            getContentPane().add(btn1);

            btn2.setText("Button 2");
            getContentPane().add(btn2);

            btn3.setText("Button 3");
            getContentPane().add(btn3);

            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setText("Label 3");
            getContentPane().add(label3);

            btn4.setText("Button 4");
            getContentPane().add(btn4);

            btn5.setText("Button 5");
            getContentPane().add(btn5);

            btn6.setText("Button 6");
            getContentPane().add(btn6);

            label4.setHorizontalAlignment(SwingConstants.CENTER);
            label4.setText("Label 4");
            getContentPane().add(label4);

            label5.setHorizontalAlignment(SwingConstants.CENTER);
            label5.setText("Label 5");
            getContentPane().add(label5);

            label6.setHorizontalAlignment(SwingConstants.CENTER);
            label6.setText("Label 6");
            getContentPane().add(label6);

            btn7.setText("Button 7");
            getContentPane().add(btn7);

            btn8.setText("Button 8");
            getContentPane().add(btn8);

            btn9.setText("Button 9");
            getContentPane().add(btn9);

            label7.setHorizontalAlignment(SwingConstants.CENTER);
            label7.setText("Label 7");
            getContentPane().add(label7);

            label8.setHorizontalAlignment(SwingConstants.CENTER);
            label8.setText("Label 8");
            getContentPane().add(label8);

            label9.setHorizontalAlignment(SwingConstants.CENTER);
            label9.setText("Label 9");
            getContentPane().add(label9);

            pack();
        }


    private void buttonActionPerformed(int index) {
        if (boardState[index] == 0) {
            boardState[index] = 1;
            JButton button = getButtonByIndex(index);
            button.setText("X");
            checkBoard();
        }
    }

    private void checkBoard() {
        int[][] winCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                {0, 4, 8}, {2, 4, 6} // Diagonals
        };

        for (int[] combination : winCombinations) {
            int pos1 = combination[0];
            int pos2 = combination[1];
            int pos3 = combination[2];

            if (boardState[pos1] != 0 &&
                    boardState[pos1] == boardState[pos2] &&
                    boardState[pos1] == boardState[pos3]) {
                String winner = (boardState[pos1] == 1) ? "X" : "O";
                label9.setText("Player " + winner + " wins!");
                disableButtons();
                return;
            }
        }

        if (Arrays.stream(boardState).allMatch(pos -> pos != 0)) {
            label9.setText("It's a tie!");
            disableButtons();
        }
    }

    private void disableButtons() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    private JButton getButtonByIndex(int index) {
        switch (index) {
            case 0:
                return btn1;
            case 1:
                return btn2;
            case 2:
                return btn3;
            case 3:
                return btn4;
            case 4:
                return btn5;
            case 5:
                return btn6;
            case 6:
                return btn7;
            case 7:
                return btn8;
            case 8:
                return btn9;
            default:
                throw new IllegalArgumentException("Invalid index: " + index);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeGUI frame = new TicTacToeGUI();
            frame.setTitle("Tic-Tac-Toe");
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
