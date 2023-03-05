import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Queen extends ChessGamePiece {
    public Queen(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> northEastMoves = calculateNorthEastMoves(board, 8);
        ArrayList<String> northWestMoves = calculateNorthWestMoves(board, 8);
        ArrayList<String> southEastMoves = calculateSouthEastMoves(board, 8);
        ArrayList<String> southWestMoves = calculateSouthWestMoves(board, 8);
        ArrayList<String> northMoves = calculateNorthMoves(board, 8);
        ArrayList<String> southMoves = calculateSouthMoves(board, 8);
        ArrayList<String> eastMoves = calculateEastMoves(board, 8);
        ArrayList<String> westMoves = calculateWestMoves(board, 8);
        ArrayList<String> allMoves = new ArrayList<>();
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

    @Override
    public ImageIcon createImageByPieceType() {
        String imageName;
        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            imageName = "WhiteQueen.gif";
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            imageName = "BlackQueen.gif";
        } else {
            imageName = "default-Unassigned.gif";
        }
        return ChessPieceImageFactory.createImageIcon(imageName);
    }
}