import java.awt.BorderLayout;
import javax.swing.JPanel;


public class ChessPanel extends JPanel {
    private ChessMenuBar menuBar;
    private ChessGameBoard gameBoard;
    private ChessGameLog gameLog;
    private ChessGraveyard playerOneGraveyard;
    private ChessGraveyard playerTwoGraveyard;
    private ChessGameEngine gameEngine;
    
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;

    /**
     * Creates a new ChessPanel object.
     * 
     * This method sets up the main components of the chess game and adds them to this panel.
     * It also starts the game engine to begin the game.
     */
    public ChessPanel() {
        setLayout(new BorderLayout());

        menuBar = new ChessMenuBar();
        gameBoard = new ChessGameBoard();
        gameLog = new ChessGameLog();
        playerOneGraveyard = new ChessGraveyard("Player 1's graveyard");
        playerTwoGraveyard = new ChessGraveyard("Player 2's graveyard");

        add(menuBar, BorderLayout.NORTH);
        add(gameBoard, BorderLayout.CENTER);
        add(gameLog, BorderLayout.SOUTH);
        add(playerOneGraveyard, BorderLayout.WEST);
        add(playerTwoGraveyard, BorderLayout.EAST);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        
        gameEngine = new ChessGameEngine(gameBoard); // start the game
    }

    /**
     * Gets the logger object for use in other classes.
     * 
     * @return the ChessGameLog object
     */
    public ChessGameLog getGameLog() {
        return gameLog;
    }

    /**
     * Gets the game board object for use in other classes.
     * 
     * @return the ChessGameBoard object
     */
    public ChessGameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * Gets the game engine object for use in other classes.
     * 
     * @return the ChessGameEngine object
     */
    public ChessGameEngine getGameEngine() {
        return gameEngine;
    }

    /**
     * Gets the appropriate graveyard object for use in other classes.
     * 
     * @param playerNumber the number of the player (1 or 2)
     * @return the requested ChessGraveyard object
     */
    public ChessGraveyard getGraveyard(int playerNumber) {
        if (playerNumber == 1) {
            return playerOneGraveyard;
        } else if (playerNumber == 2) {
            return playerTwoGraveyard;
        } else {
            throw new IllegalArgumentException("Invalid player number: " + playerNumber);
        }
    }
}

