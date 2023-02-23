import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * Represents a Pawn game piece. Unique in that it can move two locations on its
 * first turn and therefore requires a new 'notMoved' variable to keep track of
 * its turns.
 */
public class Pawn extends ChessGamePiece {
    private boolean notMoved;

    /**
     * Create a new Pawn object.
     *
     * @param board the board to create the pawn on
     * @param row row of the pawn
     * @param col column of the pawn
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Pawn(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color, true);
        notMoved = true;
        possibleMoves = calculatePossibleMoves(board);
    }

    /**
     * Moves this pawn to a row and col
     *
     * @param board the board to move on
     * @param row the row to move to
     * @param col the col to move to
     * @return boolean true if the move was successful, false otherwise
     */
    @Override
    public boolean move(ChessGameBoard board, int row, int col) {
        if (super.move(board, row, col)) {
            notMoved = false;
            possibleMoves = calculatePossibleMoves(board);
            if ((getColorOfPiece() == ChessGamePiece.BLACK && row == 7)
                    || (getColorOfPiece() == ChessGamePiece.WHITE && row == 0)) { // pawn has reached the end of the board, promote it to queen
                board.getCell(row, col).setPieceOnSquare(new Queen(board, row, col, getColorOfPiece()));
            }
            return true;
        }
        return false;
    }

    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     *
     * @param board the game board to calculate moves on
     * @return ArrayList<String> the moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<String>();
        if (isPieceOnScreen()) {
            int currRow = (getColorOfPiece() == ChessGamePiece.WHITE) ? (pieceRow - 1) : (pieceRow + 1);
            int count = 1;
            int maxIter = notMoved ? 2 : 1;
            // check for normal moves
            while (count <= maxIter && isOnScreen(currRow, pieceColumn) && board.getCell(currRow, pieceColumn).getPieceOnSquare() == null) {
                moves.add(currRow + "," + pieceColumn);
                currRow = (getColorOfPiece() == ChessGamePiece.WHITE) ? (currRow - 1) : (currRow + 1);
                count++;
            }
            // check for enemy capture points
            int[] rows = {1, -1};
            int[] cols = {1, -1};
            for (int r : rows) {
                for (int c : cols) {
                    int captureRow = pieceRow + r;
                    int captureCol = pieceColumn + c;
                    if (captureRow >= 0 && captureRow < 8 && captureCol >= 0 && captureCol < 8) {
                        ChessGamePiece pieceOnSquare = board.getCell(captureRow, captureCol).getPieceOnSquare();
                        if (pieceOnSquare != null && pieceOnSquare.getColor() != getColorOfPiece()) {
                            moves.add(captureRow + "," + captureCol);
                        }
                    }
                }
            }
        }
        return moves;
    }

    public String toString() {
        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            return "\u2659";
        } else {
            return "\u265F";
        }
    }
}
