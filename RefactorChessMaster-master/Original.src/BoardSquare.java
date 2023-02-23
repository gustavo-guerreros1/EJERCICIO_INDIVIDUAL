import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Representa una celda en el tablero de ajedrez. Contiene una pieza de juego.
 * 
 * @autor Ben Katz (bakatz)
 * @autor Myles David II (davidmm2)
 * @autor Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class BoardSquare extends JPanel {
    private int row;
    private int col;
    private ChessGamePiece piece;
    private JLabel imageLabel;

    /**
     * Crea un nuevo objeto BoardSquare.
     * 
     * @param row el número de fila.
     * @param col el número de columna.
     * @param piece la pieza de juego.
     */
    public BoardSquare(int row, int col, ChessGamePiece piece) {
        super();
        this.row = row;
        this.col = col;
        this.piece = piece;
        updateImage();
    }

    /**
     * Actualiza la imagen de este BoardSquare.
     */
    private void updateImage() {
        // Si ya hay una imagen, la eliminamos.
        if (imageLabel != null) {
            removeAll();
        }
        // Si hay una pieza en este BoardSquare, agregamos su imagen.
        if (piece != null) {
            imageLabel = new JLabel();
            imageLabel.setIcon(piece.getImage());
            add(imageLabel);
        }
        revalidate(); // Repintar no estaba funcionando, hay que forzar al administrador de ventanas a redibujar.
    }

    /**
     * Obtiene el número de fila.
     * 
     * @return int el número de fila.
     */
    public int getRow() {
        return row;
    }

    /**
     * Obtiene el número de columna.
     * 
     * @return int el número de columna.
     */
    public int getColumn() {
        return col;
    }

    /**
     * Obtiene la pieza en este cuadrado.
     * 
     * @return ChessGamePiece la pieza.
     */
    public ChessGamePiece getPieceOnSquare() {
        return piece;
    }

    /**
     * Establece la pieza en este cuadrado.
     * 
     * @param p la pieza.
     */
    public void setPieceOnSquare(ChessGamePiece p) {
        piece = p;
        updateImage();
    }

    /**
     * Limpia este cuadrado, eliminando el icono y la pieza.
     */
    public void clearSquare() {
        piece = null;
        removeAll();
    }
}
