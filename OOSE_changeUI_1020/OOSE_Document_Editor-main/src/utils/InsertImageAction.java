package utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTML;
import java.awt.event.ActionEvent;

public class InsertImageAction {
    private String absPath;

    public InsertImageAction(String absPath) {
        this.absPath = absPath;
    }

    public AttributeSet actionPerformed(ActionEvent ae) {
        // 設定attribute
        SimpleAttributeSet attr = new SimpleAttributeSet();
        attr.addAttribute(HTML.Attribute.SRC, "file:///"+absPath);
        attr.addAttribute(HTML.Attribute.WIDTH, "600");
        // 設定tag
        MutableAttributeSet outerAttr = new SimpleAttributeSet();
        outerAttr.addAttribute(HTML.Tag.IMG, attr);
        // 回傳
        return outerAttr;
    }
}