import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Mine Sweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int rows = 10;
        int cols = 10;
        double difficulty = 0.2;

        MSBoard board = new MSBoard(rows, cols, difficulty);
        MSView view = new MSView(rows, cols);

        MSController controller = new MSController(board, view);
        frame.add(view);

        frame.pack();
        frame.setVisible(true);
    }
}
