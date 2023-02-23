import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * Represents a Rook game piece.
 */
public class Rook extends ChessGamePiece {

    /**
     * Create a new Rook object.
     *
     * @param board the board to create the rook on
     * @param x the x-coordinate to create the rook on
     * @param y the y-coordinate to create the rook on
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Rook(ChessGameBoard board, int x, int y, int color) {
        super(board, x, y, color);
    }

    /**
     * Calculates the possible moves for this Rook.
     * @param board the board to check on
     * @return the list of moves
     */
    @Override
    protected ArrayList<String> calculateMoves(ChessGameBoard board) {
        final int MAX_MOVES = 8;
        ArrayList<String> northMoves = calculateNorthMoves(board, MAX_MOVES);
        ArrayList<String> southMoves = calculateSouthMoves(board, MAX_MOVES);
        ArrayList<String> westMoves = calculateWestMoves(board, MAX_MOVES);
        ArrayList<String> eastMoves = calculateEastMoves(board, MAX_MOVES);
        ArrayList<String> allMoves = new ArrayList<>();
        allMoves.addAll(northMoves);
        allMoves.addAll(southMoves);
        allMoves.addAll(westMoves);
        allMoves.addAll(eastMoves);
        return allMoves;
    }

    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType() {
        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            return new ImageIcon(getClass().getResource("chessImages/WhiteRook.gif"));
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            return new ImageIcon(getClass().getResource("chessImages/BlackRook.gif"));
        } else {
            return new ImageIcon(getClass().getResource("chessImages/default-Unassigned.gif"));
        }
    }
}

