package Mediator;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ScrollBar extends JScrollBar {
    private final int Thumb_size = 12;
    public ScrollBar(){
        BasicScrollBarUI ui = new BasicScrollBarUI() {
            protected JButton createDecreaseButton(int orientation) {
                return new InvisibleScrollBar();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return new InvisibleScrollBar();
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                Graphics2D g2d = (Graphics2D) g;
                g.setColor(new Color(230, 230, 230));
                g2d.fill(trackBounds);
                g2d.draw(trackBounds);
            }

            @Override
            protected void setThumbBounds(int x, int y, int width, int height) {
                super.setThumbBounds(x, y, width, height);
                scrollbar.repaint();
            }

            class InvisibleScrollBar extends JButton {
                private InvisibleScrollBar() {
                    setOpaque(false);
                    setFocusable(false);
                    setFocusPainted(false);
                    setBorderPainted(false);
                    setBorder(BorderFactory.createEmptyBorder());
                }
            }
        };

        this.setPreferredSize(new Dimension(Thumb_size, Thumb_size));
        this.setUI(ui);
    }

    public ScrollBar setDirection(int direction) {
        this.setOrientation(direction);
        return this;
    }
}
