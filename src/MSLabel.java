import javax.swing.*;

public class MSLabel extends JLabel {
    private int row;
    private int col;
    private ImageIcon[] numberIcons;
    private ImageIcon flagIcon;
    private ImageIcon bombIcon;
    private ImageIcon explosionIcon;

    private static final String BPATH = "MineSweeperIcons/";

    public MSLabel(int row, int col, ImageIcon[] numberIcons) {
        this.row = row;
        this.col = col;
        flagIcon = new ImageIcon(BPATH+"Flag.png");
        bombIcon = new ImageIcon(BPATH + "path/to/Bomb.png");
        this.numberIcons = numberIcons;

        // Set default appearance and behavior
        setHorizontalAlignment(SwingConstants.CENTER);
        setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void showNum(int num) {
        setIcon(numberIcons[num]);
        revalidate();
        repaint();
    }

    public void showBomb() {
        setIcon(bombIcon);
    }

    public void showFlag(boolean marked) {
        if (marked) {
            setIcon(flagIcon);
        } else {
            setIcon(null);
        }
        revalidate();
        repaint();
    }

}
