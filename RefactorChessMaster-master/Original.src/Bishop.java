import java.util.List;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Represents the Bishop piece.
 */
public class Bishop extends ChessGamePiece {

    private static final int MAX_DISTANCE = 8;

    /**
     * Creates a new Bishop object.
     * 
     * @param board the board to create the bishop on
     * @param row row location of the Bishop
     * @param col col location of the Bishop
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Bishop(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     * 
     * @param board the game board to calculate moves on
     * @return the list of possible moves
     */
    @Override
    protected List<String> calculatePossibleMoves(ChessGameBoard board) {
        List<String> moves = new ArrayList<>();
        moves.addAll(calculateMovesInDirection(board, -1, -1, MAX_DISTANCE)); // northwest
        moves.addAll(calculateMovesInDirection(board, -1, 1, MAX_DISTANCE)); // northeast
        moves.addAll(calculateMovesInDirection(board, 1, -1, MAX_DISTANCE)); // southwest
        moves.addAll(calculateMovesInDirection(board, 1, 1, MAX_DISTANCE)); // southeast
        return moves;
    }

    private List<String> calculateMovesInDirection(
            ChessGameBoard board, int rowDirection, int colDirection, int maxDistance) {
        List<String> moves = new ArrayList<>();
        int row = getRow() + rowDirection;
        int col = getCol() + colDirection;
        for (int distance = 1; distance <= maxDistance; distance++) {
            if (!isWithinBoard(row, col)) {
                break;
            }
            ChessGamePiece piece = board.getPieceAt(row, col);
            if (piece == null) {
                moves.add(makeMoveString(row, col));
            } else if (piece.getColorOfPiece() != getColorOfPiece()) {
                moves.add(makeMoveString(row, col));
                break;
            } else {
                break;
            }
            row += rowDirection;
            col += colDirection;
        }
        return moves;
    }

    /**
     * Creates an icon for this piece depending on the piece's color.
     * 
     * @return the ImageIcon representation of this piece
     */
    @Override
    public ImageIcon createImageByPieceType() {
    	String filename;
    	if (getColorOfPiece() == ChessGamePiece.WHITE) {
    		filename = "chessImages/WhiteBishop.gif";
    	} else {
    		filename = "chessImages/BlackBishop.gif";
    	}
    	return new ImageIcon(getClass().getResource(filename));
    	}
    	}

    	


