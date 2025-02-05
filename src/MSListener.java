import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MSListener implements MouseListener {
    private MSController controller;
    private int row;
    private int col;
    public MSListener(MSController controller, int row, int col) {
        this.controller = controller;
        this.row = row;
        this.col = col;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            controller.onFlag(row, col);

        }

        else if (e.getButton() == MouseEvent.BUTTON1) {
            controller.onReveal(row, col);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
