import javax.swing.ImageIcon;

    public class ChessPieceImageFactory {
        private static final String IMAGES_DIR = "chessImages/";
        private ChessPieceImageFactory() {}

    public static ImageIcon createImageIcon(String imageName) {
        return new ImageIcon(ChessPieceImageFactory.class.getResource(IMAGES_DIR + imageName));
    }
}