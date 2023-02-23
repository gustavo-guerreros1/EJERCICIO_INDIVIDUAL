import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * Represents a King game piece.
 */
public class King extends ChessGamePiece {

    /**
     * Create a new King object.
     *
     * @param board the board to create the king on
     * @param row the row to create the king on
     * @param col the column to create the king on
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public King(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color, false);
    }

    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     *
     * @param board the game board to calculate moves on
     * @return the possible moves as an ArrayList of strings
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> northEastMoves = calculateNorthEastMoves(board, 1);
        ArrayList<String> northWestMoves = calculateNorthWestMoves(board, 1);
        ArrayList<String> southEastMoves = calculateSouthEastMoves(board, 1);
        ArrayList<String> southWestMoves = calculateSouthWestMoves(board, 1);
        ArrayList<String> northMoves = calculateNorthMoves(board, 1);
        ArrayList<String> southMoves = calculateSouthMoves(board, 1);
        ArrayList<String> eastMoves = calculateEastMoves(board, 1);
        ArrayList<String> westMoves = calculateWestMoves(board, 1);
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll(northEastMoves);
        allMoves.addAll(northWestMoves);
        allMoves.addAll(southWestMoves);
        allMoves.addAll(southEastMoves);
        allMoves.addAll(northMoves);
        allMoves.addAll(southMoves);
        allMoves.addAll(westMoves);
        allMoves.addAll(eastMoves);
        return allMoves;
    }

    /**
     * Determines if this King is checked.
     *
     * @param board the board to check on
     * @return true if checked, false if not checked
     */
    public boolean isChecked(ChessGameBoard board) {
        return getCurrentAttackers(board).size() > 0;
    }

    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType() {
        String color = getColorOfPiece() == ChessGamePiece.WHITE ? "White" :
            getColorOfPiece() == ChessGamePiece.BLACK ? "Black" : "default-Unassigned";
        return new ImageIcon(getClass().getResource("chessImages/" + color + "King.gif"));
    }
}

