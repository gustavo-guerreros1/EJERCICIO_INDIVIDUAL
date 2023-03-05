import java.util.ArrayList;
import javax.swing.ImageIcon;
import junit.framework.TestCase;

public class TestQueen extends TestCase {

    public void testCalculatePossibleMoves() {
        ChessGameBoard board = new ChessGameBoard();
        Queen queen = new Queen(board, 3, 3, ChessGamePiece.WHITE);
        ArrayList<String> expectedMoves = new ArrayList<String>();
        expectedMoves.add("a3");
        expectedMoves.add("b3");
        expectedMoves.add("c3");
        expectedMoves.add("d3");
        expectedMoves.add("e3");
        expectedMoves.add("f3");
        expectedMoves.add("g3");
        expectedMoves.add("h3");
        expectedMoves.add("d1");
        expectedMoves.add("d2");
        expectedMoves.add("d4");
        expectedMoves.add("d5");
        expectedMoves.add("d6");
        expectedMoves.add("d7");
        expectedMoves.add("d8");
        expectedMoves.add("a6");
        expectedMoves.add("b5");
        expectedMoves.add("c4");
        expectedMoves.add("e2");
        expectedMoves.add("f1");
        expectedMoves.add("c2");
        expectedMoves.add("b1");
        expectedMoves.add("e4");
        expectedMoves.add("f5");
        expectedMoves.add("g6");
        expectedMoves.add("h7");
        expectedMoves.add("c6");
        expectedMoves.add("b7");
        expectedMoves.add("a8");
        expectedMoves.add("e6");
        expectedMoves.add("f7");
        expectedMoves.add("g8");
        expectedMoves.add("e2");
        expectedMoves.add("f1");
        expectedMoves.add("g2");
        expectedMoves.add("h1");
        expectedMoves.add("c2");
        expectedMoves.add("b1");
        expectedMoves.add("a2");
        expectedMoves.add("c4");
        expectedMoves.add("b5");
        expectedMoves.add("a6");
        expectedMoves.add("f4");
        expectedMoves.add("g5");
        expectedMoves.add("h6");
        expectedMoves.add("f2");
        expectedMoves.add("g1");
        expectedMoves.add("b4");
        expectedMoves.add("a5");
        expectedMoves.add("e4");
        expectedMoves.add("f5");
        expectedMoves.add("g6");
        expectedMoves.add("h7");
        expectedMoves.add("a4");
        expectedMoves.add("b5");
        expectedMoves.add("c6");
        expectedMoves.add("e4");
        expectedMoves.add("f3");
        expectedMoves.add("g2");
        expectedMoves.add("h1");
        ArrayList<String> actualMoves = queen.calculatePossibleMoves(board);
        assertEquals(expectedMoves, actualMoves);
    }

    public void testCreateImageByPieceType() {
        ChessGameBoard board = new ChessGameBoard();
        Queen queen = new Queen(board, 3, 3, ChessGamePiece.WHITE);
        ImageIcon expectedIcon = ChessPieceImageFactory.createImageIcon("WhiteQueen.gif");
        ImageIcon actualIcon = queen.createImageByPieceType();
        assertEquals(expectedIcon.getImage().getSource(), actualIcon.getImage().getSource());
    }
}
