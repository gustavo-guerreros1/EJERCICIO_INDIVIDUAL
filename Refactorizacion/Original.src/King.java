import javax.swing.ImageIcon;
import java.util.ArrayList;

public class King extends ChessGamePiece{
    public King(ChessGameBoard board, int row, int col, int color){
        super(board, row, col, color, false);
    }

    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board){
        ArrayList<String> possibleMoves = new ArrayList<>();
        
        // Add all possible moves in different directions to the ArrayList
        possibleMoves.addAll(calculateNorthEastMoves(board, 1));
        possibleMoves.addAll(calculateNorthWestMoves(board, 1));
        possibleMoves.addAll(calculateSouthEastMoves(board, 1));
        possibleMoves.addAll(calculateSouthWestMoves(board, 1));
        possibleMoves.addAll(calculateNorthMoves(board, 1));
        possibleMoves.addAll(calculateSouthMoves(board, 1));
        possibleMoves.addAll(calculateEastMoves(board, 1));
        possibleMoves.addAll(calculateWestMoves(board, 1));
        
        return possibleMoves;
    }

    public boolean isChecked(ChessGameBoard board){
        return getCurrentAttackers(board).size() > 0;
    }

    @Override
    public ImageIcon createImageByPieceType(){
        String imagePath = "chessImages/default-Unassigned.gif";
        if (getColorOfPiece() == ChessGamePiece.WHITE){
            imagePath = "chessImages/WhiteKing.gif";            
        }
        else if (getColorOfPiece() == ChessGamePiece.BLACK){
            imagePath = "chessImages/BlackKing.gif";            
        }
        return new ImageIcon(getClass().getResource(imagePath));
    }
}