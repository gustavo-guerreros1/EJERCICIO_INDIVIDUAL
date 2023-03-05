import java.util.ArrayList;

import javax.swing.ImageIcon;

import junit.framework.TestCase;

public class TestRook extends TestCase {

    ChessGameBoard board;

    Rook whiteRook;
    Rook blackRook;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        board = new ChessGameBoard();
        whiteRook = new Rook(board, 0, 0, ChessGamePiece.WHITE);
        blackRook = new Rook(board, 7, 7, ChessGamePiece.BLACK);
    }

    public void testCalculatePossibleMoves() {
        ArrayList<String> whiteMoves = whiteRook.calculatePossibleMoves(board);
        ArrayList<String> blackMoves = blackRook.calculatePossibleMoves(board);

        // Test white rook moves
        assertTrue(whiteMoves.contains("a2"));
        assertTrue(whiteMoves.contains("a3"));
        assertTrue(whiteMoves.contains("a4"));
        assertTrue(whiteMoves.contains("a5"));
        assertTrue(whiteMoves.contains("a6"));
        assertTrue(whiteMoves.contains("a7"));
        assertTrue(whiteMoves.contains("a8"));
        assertTrue(whiteMoves.contains("b1"));
        assertTrue(whiteMoves.contains("c1"));
        assertTrue(whiteMoves.contains("d1"));
        assertTrue(whiteMoves.contains("e1"));
        assertTrue(whiteMoves.contains("f1"));
        assertTrue(whiteMoves.contains("g1"));
        assertTrue(whiteMoves.contains("h1"));
        assertEquals(whiteMoves.size(), 14);

        // Test black rook moves
        assertTrue(blackMoves.contains("b8"));
        assertTrue(blackMoves.contains("c8"));
        assertTrue(blackMoves.contains("d8"));
        assertTrue(blackMoves.contains("e8"));
        assertTrue(blackMoves.contains("f8"));
        assertTrue(blackMoves.contains("g8"));
        assertTrue(blackMoves.contains("h8"));
        assertTrue(blackMoves.contains("a7"));
        assertTrue(blackMoves.contains("a6"));
        assertTrue(blackMoves.contains("a5"));
        assertTrue(blackMoves.contains("a4"));
        assertTrue(blackMoves.contains("a3"));
        assertTrue(blackMoves.contains("a2"));
        assertTrue(blackMoves.contains("a1"));
        assertEquals(blackMoves.size(), 14);
    }

    public void testCreateImageByPieceType() {
        ImageIcon whiteIcon = whiteRook.createImageByPieceType();
        ImageIcon blackIcon = blackRook.createImageByPieceType();

        assertNotNull(whiteIcon);
        assertNotNull(blackIcon);

        assertEquals(whiteIcon.getIconHeight(), 64);
        assertEquals(whiteIcon.getIconWidth(), 64);

        assertEquals(blackIcon.getIconHeight(), 64);
        assertEquals(blackIcon.getIconWidth(), 64);
    }
}


