import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MSView extends JPanel {
    private MSLabel[][] labels;
    private MSController controller;
    private ImageIcon[] numberIcons;
    //private ImageIcon explosionIcon;
    private ImageIcon bombIcon;
    private static final String BPATH = "MineSweeperIcons/";
    public MSView(int rows, int cols) {
        setPreferredSize(new Dimension(300,300));
        setLayout(new GridLayout(rows, cols));
        labels = new MSLabel[rows][cols];

        numberIcons = new ImageIcon[8];
        for (int i = 0; i < numberIcons.length; i++) {
            numberIcons[i] = new ImageIcon(BPATH + i + ".png");
        }

        //explosionIcon = new ImageIcon(BPATH + "Explode.png");
        bombIcon = new ImageIcon(BPATH + "Bomb.png");

        // Create the labels and add listeners
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                MSLabel label = new MSLabel(r, c, numberIcons);
                label.addMouseListener(new MSListener());
                labels[r][c] = label;
                add(label);
            }
        }
    }

    // Set the controller for this view
    public void setController(MSController controller) {
        this.controller = controller;
    }

    // Show the number of adjacent bombs at a given cell
    public void showNum(int r, int c, int num) {
        labels[r][c].showNum(num);
    }

    // Show a bomb at a given cell
    public void showBomb(int r, int c) {
        labels[r][c].setIcon(bombIcon);
    }

    // Show a flag at a given cell
    public void showFlag(int r, int c, boolean marked) {
        labels[r][c].showFlag(marked);
    }

    // Mouse listener for user interaction
    private class MSListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            MSLabel label = (MSLabel) e.getSource();
            int r = label.getRow();
            int c = label.getCol();

            if (SwingUtilities.isLeftMouseButton(e)) {
                controller.onReveal(r, c);
            } else if (SwingUtilities.isRightMouseButton(e)) {
                controller.onFlag(r, c);
            }
        }

    }
}
