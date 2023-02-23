import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * Represents a Queen game piece.
 * 
 * Authors:
 * Ben Katz (bakatz)
 * Myles David II (davidmm2)
 * Danielle Bushrow (dbushrow)
 * 
 * Date: 2010.11.17
 */
public class Queen extends ChessGamePiece {

    /**
     * Create a new Queen object.
     *
     * @param board the board the queen is on
     * @param row the row location of the queen
     * @param col the column location of the queen
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Queen(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    /**
     * Calculates the possible moves for this Queen.
     *
     * @param board the board to check on
     * @return ArrayList<String> the list of moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll(calculateNorthEastMoves(board, 8));
        allMoves.addAll(calculateNorthWestMoves(board, 8));
        allMoves.addAll(calculateSouthEastMoves(board, 8));
        allMoves.addAll(calculateSouthWestMoves(board, 8));
        allMoves.addAll(calculateNorthMoves(board, 8));
        allMoves.addAll(calculateSouthMoves(board, 8));
        allMoves.addAll(calculateWestMoves(board, 8));
        allMoves.addAll(calculateEastMoves(board, 8));
        return allMoves;
    }

    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType() {
        String imagePath;
        switch (getColorOfPiece()) {
            case ChessGamePiece.WHITE:
                imagePath = "chessImages/WhiteQueen.gif";
                break;
            case ChessGamePiece.BLACK:
                imagePath = "chessImages/BlackQueen.gif";
                break;
            default:
                imagePath = "chessImages/default-Unassigned.gif";
        }
        return new ImageIcon(getClass().getResource(imagePath));
    }
}
