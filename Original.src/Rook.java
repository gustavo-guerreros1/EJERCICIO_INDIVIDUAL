import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Rook extends ChessGamePiece {

    public Rook(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> allMoves = new ArrayList<>();
        allMoves.addAll(calculateNorthMoves(board, 8));
        allMoves.addAll(calculateSouthMoves(board, 8));
        allMoves.addAll(calculateWestMoves(board, 8));
        allMoves.addAll(calculateEastMoves(board, 8));
        return allMoves;
    }

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