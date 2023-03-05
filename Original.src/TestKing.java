import junit.framework.TestCase;
import java.util.ArrayList;

public class TestKing extends TestCase {

    public void testCalculatePossibleMoves() {
        // Create a new game board
        ChessGameBoard board = new ChessGameBoard();

        // Create a new king at row 4, column 4, with color white
        King king = new King(board, 4, 4, ChessGamePiece.WHITE);

        // Get the possible moves for the king
        ArrayList<String> possibleMoves = king.calculatePossibleMoves(board);

        // Check that the king can move to the correct squares
        ArrayList<String> expectedMoves = new ArrayList<String>();
        expectedMoves.add("d5");
        expectedMoves.add("e5");
        expectedMoves.add("e4");
        expectedMoves.add("e3");
        expectedMoves.add("d3");
        expectedMoves.add("c3");
        expectedMoves.add("c4");
        expectedMoves.add("c5");

        assertEquals(expectedMoves, possibleMoves);
    }

    public void testIsChecked() {
        // Create a new game board
        ChessGameBoard board = new ChessGameBoard();

        // Create a new king at row 4, column 4, with color white
        King king = new King(board, 4, 4, ChessGamePiece.WHITE);

        // Set up the board so that the king is in check
        board.placePiece(new Rook(board, 4, 7, ChessGamePiece.BLACK));
        board.placePiece(new Rook(board, 7, 4, ChessGamePiece.BLACK));

        // Check that the king is in check
        assertTrue(king.isChecked(board));
    }
}
