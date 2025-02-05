public class MSCell {
    private boolean isBomb;
    private boolean isFlagged;
    private int adjacentMines;
    private boolean isCovered;

    public MSCell() {
        this.isBomb = false;
        this.isFlagged = false;
        this.adjacentMines = 0;
        this.isCovered = true;
    }

    // Check if the cell contains a bomb
    public boolean isBomb() {
        return isBomb;
    }

    // Set whether the cell contains a bomb
    public void setBomb(boolean bomb) {
        this.isBomb = bomb;
    }

    // Check if the cell is flagged
    public boolean isFlagged() {
        return isFlagged;
    }

    // Set whether the cell is flagged
    public void setFlagged(boolean flagged) {
        this.isFlagged = flagged;
    }

    // Get the no of adjacent bombs
    public int getAdjacentMines() {
        return adjacentMines;
    }

    // Set the no of adjacent bombs
    public void setAdjacentMines(int num) {
        this.adjacentMines = num;
    }

    // Check if the cell is covered
    public boolean isCovered() {
        return isCovered;
    }

}
