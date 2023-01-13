package Mediator;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {
    private final Color bg= new Color(246, 246, 246, 255);

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bg);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

    public void addMenu(Menu m) {
        this.add(m);
    }
}
