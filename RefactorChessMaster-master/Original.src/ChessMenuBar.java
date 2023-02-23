import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ChessMenuBar extends JMenuBar {

    private static final long serialVersionUID = 1L;
    private static final String[] MENU_CATEGORIES = { "File", "Options", "Help" };
    private static final String[] MENU_ITEM_LISTS = { "New game/restart,Exit", "Toggle graveyard,Toggle game log",
            "About" };

    public ChessMenuBar() {
        createMenus();
    }

    private void createMenus() {
        for (int i = 0; i < MENU_CATEGORIES.length; i++) {
            JMenu menu = new JMenu(MENU_CATEGORIES[i]);
            String[] menuItems = MENU_ITEM_LISTS[i].split(",");
            for (String item : menuItems) {
                JMenuItem menuItem = new JMenuItem(item);
                menuItem.addActionListener(new MenuListener());
                menu.add(menuItem);
            }
            this.add(menu);
        }
    }

    private class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JMenuItem menuItem = (JMenuItem) event.getSource();
            String itemName = menuItem.getText();
            switch (itemName) {
                case "About":
                    aboutHandler();
                    break;
                case "New game/restart":
                    restartHandler();
                    break;
                case "Toggle game log":
                    toggleGameLogHandler();
                    break;
                case "Exit":
                    exitHandler();
                    break;
                default:
                    toggleGraveyardHandler();
                    break;
            }
        }
    }

    private void aboutHandler() {
        String message = "YetAnotherChessGame v1.0 by:\nBen Katz\nMyles David\n"
                + "Danielle Bushrow\n\nFinal Project for CS2114 @ VT";
        JOptionPane.showMessageDialog(this.getParent(), message);
    }

    private void restartHandler() {
        Component parent = this.getParent();
        if (parent instanceof ChessPanel) {
            ChessPanel chessPanel = (ChessPanel) parent;
            chessPanel.getGameEngine().reset();
        }
    }

    private void exitHandler() {
        JOptionPane.showMessageDialog(this.getParent(), "Thanks for leaving, quitter! >:(");
        Component parent = this.getParent();
        while (parent != null && !(parent instanceof JFrame)) {
            parent = parent.getParent();
        }
        if (parent instanceof JFrame) {
            JFrame frame = (JFrame) parent;
            frame.setVisible(false);
            frame.dispose();
        }
    }

    private void toggleGraveyardHandler() {
        Component parent = this.getParent();
        if (parent instanceof ChessPanel) {
            ChessPanel chessPanel = (ChessPanel) parent;
            chessPanel.getGraveyard(1).setVisible(!chessPanel.getGraveyard(1).isVisible());
            chessPanel.getGraveyard(2).setVisible(!chessPanel.getGraveyard(2).isVisible());
        }
    }

    private void toggleGameLogHandler() {
        Component parent = this.getParent();
        if (parent instanceof ChessPanel) {
            ChessPanel chessPanel = (ChessPanel) parent;
            chessPanel.getGameLog().setVisible(!chessPanel.getGameLog().isVisible());
            chessPanel.revalidate();
        }
    }
}
