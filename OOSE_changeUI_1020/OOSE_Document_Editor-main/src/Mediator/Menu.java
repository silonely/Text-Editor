package Mediator;

import javax.swing.*;
import java.awt.*;

public class Menu extends JMenu {
    private final Color fg = Color.BLACK;
    private final Color bg = new Color(246, 246, 246, 255);
    private final Color selected_fg = Color.WHITE;
    private final Color selected_bg = new Color(43, 151, 246, 255);

    public Menu(){
        this.setOpaque(true);
        this.setBackground(bg);
        this.setForeground(fg);

        this.addChangeListener(e -> {
            if (e.getSource() instanceof Menu) {
                Menu item = (Menu) e.getSource();
                if (item.isSelected() || item.isArmed()) {
                    item.setForeground(selected_fg);
                    item.setBackground(selected_bg);
                } else {
                    item.setForeground(fg);
                    item.setBackground(bg);
                }
            }
        });
    }

    public void setMenuName(String description) {
        super.setText(description);
    }

    public void addMenuItem(MenuItem m) {
        this.add(m);
    }
}
