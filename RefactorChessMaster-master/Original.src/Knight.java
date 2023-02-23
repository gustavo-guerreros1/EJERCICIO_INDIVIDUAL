import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * Represents a Knight game piece.
 */
public class Knight extends ChessGamePiece {

    /**
     * Creates a new Knight with the given color at the specified row and column.
     *
     * @param board the board on which the piece is located
     * @param row the row on which the piece is located
     * @param col the column on which the piece is located
     * @param color the color of the piece
     */
    public Knight(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    /**
     * Calculates the moves of the knight in the north direction relative to the location of the piece.
     *
     * @param board the board to check moves on
     * @return a list of the possible moves
     */
    private ArrayList<String> calculateNorthMoves(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<>();

        // Check moves in all possible directions
        for (int i = 2; i >= -2; i -= 4) {
            for (int j = 1; j >= -1; j -= 2) {
                int toRow = pieceRow + i;
                int toCol = pieceColumn + j;
                if (isOnScreen(toRow, toCol) && (isEnemy(board, toRow, toCol) || board.getCell(toRow, toCol).getPieceOnSquare() == null)) {
                    moves.add(toRow + "," + toCol);
                }
            }
        }

        return moves;
    }

    /**
     * Calculates the moves of the knight in the south direction relative to the location of the piece.
     *
     * @param board the board to check moves on
     * @return a list of the possible moves
     */
    private ArrayList<String> calculateSouthMoves(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<>();

        // Check moves in all possible directions
        for (int i = 1; i >= -1; i -= 2) {
            for (int j = 2; j >= -2; j -= 4) {
                int toRow = pieceRow + i;
                int toCol = pieceColumn + j;
                if (isOnScreen(toRow, toCol) && (isEnemy(board, toRow, toCol) || board.getCell(toRow, toCol).getPieceOnSquare() == null)) {
                    moves.add(toRow + "," + toCol);
                }
            }
        }

        return moves;
    }

    /**
     * Calculates the possible moves for this Knight.
     *
     * @param board the game board to check
     * @return the list of possible moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<>();

        // Add all possible moves
        moves.addAll(calculateNorthMoves(board));
        moves.addAll(calculateSouthMoves(board));

        return moves;
    }

    /**
     * Creates an icon for this piece depending on the piece's color.
     *
     * @return the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType() {
        String color = getColorOfPiece() == ChessGamePiece.WHITE ? "White" :
            getColorOfPiece() == ChessGamePiece.BLACK ? "Black" : "default-Unassigned";
        return new ImageIcon(getClass().getResource("chessImages/" + color + "Image.png "));
    }
    }
