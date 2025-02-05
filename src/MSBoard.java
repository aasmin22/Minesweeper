import java.util.Random;

public class MSBoard {
    private MSCell[][] squares;
    private int rows;
    private int cols;
    private int numBombs;
    private int numRevealed;

    public int getNumRevealed() {
        return numRevealed;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getNumBombs() {
        return numBombs;
    }

    public MSCell[][] getSquares() {
        return squares;
    }

    public MSBoard(int rows, int cols, double difficulty) {
        this.rows = rows;
        this.cols = cols;
        this.numBombs = (int) (rows * cols * difficulty);
        this.numRevealed = 0;
        this.squares = new MSCell[rows][cols];

        // Board with empty cells
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                squares[r][c] = new MSCell();
            }
        }

        // Place bombs randomly on the board
        placeBombs();

        // Calculate the no of adjacent mines for each cell
        calculateAdjacentMines();
    }

    // Place bombs randomly on the board
    private void placeBombs() {
        Random random = new Random();
        int bombsPlaced = 0;

        while (bombsPlaced < numBombs) {
            int r = random.nextInt(rows);
            int c = random.nextInt(cols);

            // Places a bomb if the cell doesn't already contain a bomb
            if (!squares[r][c].isBomb()) {
                squares[r][c].setBomb(true);
                bombsPlaced++;
            }
        }
    }

    // Calculate the no of adjacent mines for each cell
    private void calculateAdjacentMines() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!squares[r][c].isBomb()) {
                    int adjacentMines = 0;

                    // Check all 8 possible adjacent cells
                    for (int dr = -1; dr <= 1; dr++) {
                        for (int dc = -1; dc <= 1; dc++) {
                            int adjR = r + dr;
                            int adjC = c + dc;

                            // Check the adjacent cell is within bounds
                            if (adjR >= 0 && adjR < rows && adjC >= 0 && adjC < cols) {
                                if (squares[adjR][adjC].isBomb()) {
                                    adjacentMines++;
                                }
                            }
                        }
                    }
                    // Set the no of adjacent mines for the cell
                    squares[r][c].setAdjacentMines(adjacentMines);
                }
            }
        }
    }

    // Get the no of adjacent bombs for a given cell
    public int getNum(int r, int c) throws GameOverException {
        if (squares[r][c].isBomb()) {
            throw new GameOverException("You revealed a bomb! Game Over!");
        }
        numRevealed++;
        return squares[r][c].getAdjacentMines();
    }

    // Set a flag and return the new flag state
    public boolean setFlag(int r, int c) {
        MSCell cell = squares[r][c];
        cell.setFlagged(!cell.isFlagged());
        return cell.isFlagged();
    }
}
