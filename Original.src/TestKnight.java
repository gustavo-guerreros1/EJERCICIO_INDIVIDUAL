import junit.framework.TestCase;
import java.util.ArrayList;

public class TestKnight extends TestCase {
    
    public void testCalculateNorthMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 0, 1, ChessGamePiece.WHITE);
        ArrayList<String> expectedMoves = new ArrayList<>();
        expectedMoves.add("2,0");
        expectedMoves.add("2,2");
        expectedMoves.add("1,3");
        assertEquals(expectedMoves, knight.calculateNorthMoves(board));
    }
    
    public void testCalculateSouthMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 7, 1, ChessGamePiece.BLACK);
        ArrayList<String> expectedMoves = new ArrayList<>();
        expectedMoves.add("5,0");
        expectedMoves.add("5,2");
        expectedMoves.add("6,3");
        assertEquals(expectedMoves, knight.calculateSouthMoves(board));
    }
    
    public void testCalculatePossibleMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Knight knight = new Knight(board, 3, 3, ChessGamePiece.WHITE);
        ArrayList<String> expectedMoves = new ArrayList<>();
        expectedMoves.add("5,2");
        expectedMoves.add("5,4");
        expectedMoves.add("4,1");
        expectedMoves.add("4,5");
        expectedMoves.add("2,1");
        expectedMoves.add("2,5");
        expectedMoves.add("1,2");
        expectedMoves.add("1,4");
        assertEquals(expectedMoves, knight.calculatePossibleMoves(board));
    }
    
    public void testCreateImageByPieceType() {
        Knight whiteKnight = new Knight(new ChessGameBoard(), 0, 0, ChessGamePiece.WHITE);
        Knight blackKnight = new Knight(new ChessGameBoard(), 0, 0, ChessGamePiece.BLACK);
        Knight unassignedKnight = new Knight(new ChessGameBoard(), 0, 0, ChessGamePiece.UNASSIGNED);
        assertEquals("chessImages/WhiteKnight.gif", whiteKnight.createImageByPieceType().getDescription());
        assertEquals("chessImages/BlackKnight.gif", blackKnight.createImageByPieceType().getDescription());
        assertEquals("chessImages/default-Unassigned.gif", unassignedKnight.createImageByPieceType().getDescription());
    }
}
