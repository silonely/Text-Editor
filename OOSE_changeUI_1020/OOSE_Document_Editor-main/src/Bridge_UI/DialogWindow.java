package Bridge_UI;

import visitor.ContentVisitor;

import javax.swing.*;

public class DialogWindow extends WindowAbstract {
    private JFrame frame;
    ContentVisitor cv = new ContentVisitor();
    public DialogWindow(WindowInterface impl) {
        super(impl);
        frame = super.drawFrame();
    }
    public void showDialog(String message, String title){
        String[] s = cv.getAry();
        JOptionPane.showMessageDialog(frame,s,title, JOptionPane.INFORMATION_MESSAGE);
    }
}