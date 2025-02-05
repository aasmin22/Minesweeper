import javax.swing.JOptionPane;

public class MSController {
    private MSBoard model;
    private MSView view;
    private boolean gameOver;

    public MSController(MSBoard model, MSView view) {
        this.model = model;
        this.view = view;
        this.gameOver = false;
        this.view.setController(this);
    }

    // Handles revealing a cell
    public void onReveal(int r, int c) {
        if (gameOver) return;

        try {
            int num = model.getNum(r, c);
            view.showNum(r, c, num);

            // Check if the game is won
            if (model.getNumRevealed() == (model.getRows() * model.getCols()) - model.getNumBombs()) {
                gameOver = true;
                JOptionPane.showMessageDialog(view, "You won!", "Congrats!", JOptionPane.INFORMATION_MESSAGE);
                revealAll();
            }
        } catch (GameOverException e) {
            gameOver = true;
            //view.showExplosion(r,c);
            view.showBomb(r, c);
            JOptionPane.showMessageDialog(view, "You hit a bomb!", "Game Over", JOptionPane.ERROR_MESSAGE);
            revealAll();
        }
    }

    // Handle flagging a cell
    public void onFlag(int r, int c) {
        if (gameOver) return;
        boolean isFlagged = model.setFlag(r, c);
        view.showFlag(r, c, isFlagged);
    }

    // Reveal all cells when game is over
    public void revealAll() {
        for (int r = 0; r < model.getRows(); r++) {
            for (int c = 0; c < model.getCols(); c++) {
                if (model.getSquares()[r][c].isCovered()) {
                    try {
                        int num = model.getNum(r, c);
                        view.showNum(r, c, num);
                    } catch (GameOverException e) {
                        view.showBomb(r, c);
                    }
                }
            }
        }
    }
}
