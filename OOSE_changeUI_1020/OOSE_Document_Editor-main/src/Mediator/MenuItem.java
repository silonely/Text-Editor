package Mediator;

import javax.swing.*;
import java.awt.*;

public class MenuItem extends JMenuItem {
    private final Color fg = Color.BLACK;
    private final Color bg = new Color(246, 246, 246, 255);

    public MenuItem(){
        this.setOpaque(true);
        this.setForeground(fg);
        this.setBackground(bg);
    }

    public void setMenuItemName(String description) {
        this.setText(description);
    }
}
