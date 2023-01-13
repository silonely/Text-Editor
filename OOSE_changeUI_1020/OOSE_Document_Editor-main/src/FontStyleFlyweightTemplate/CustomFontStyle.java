package FontStyleFlyweightTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class CustomFontStyle extends FontStyleFlyweight{
    public  static String CustomFontStyleName;
    public static int CustomFontSize;
    public static int CustomBold;
    public static int CustomItalic;
    public static int CustomUnderline;
    public static String CustomAlign;
    public static String CustomFGColor;
    public static int Control = 0;
    @Override
    public void DoSetting() {
        if(Control == 0){
            FontStyleName = "Bradley Hand ITC";
            FontSize = 16;
            b = 0;
            i = 0;
            u = 0;
            align = "left";
            FGColor = "FG-Red";
        }
        else{
            FontStyleName = CustomFontStyleName;
            FontSize = CustomFontSize;
            b = CustomBold;
            i = CustomItalic;
            u = CustomUnderline;
            align = CustomAlign;
            FGColor = CustomFGColor;
        }
    }

    public static void CustomStyle(){
        // create new setting window
        final JDialog window = new JDialog();
        window.setVisible(true);
        window.setLayout(new GridLayout(15,1));
        window.setBounds(500,300,250,500);
        window.setTitle("Custom Style");
        ImageIcon img = new ImageIcon("icon.jpg");
        window.setIconImage(img.getImage());

        //Button
        JButton CheckButton = new JButton("OK");
        //Labels
        JLabel FontComboBoxLabel = new JLabel("Select Font Style");
        JLabel FontSizeLabel = new JLabel("Select Font Size");
        JLabel FontAlignLable = new JLabel("Select Align");
        JLabel BoldLabel = new JLabel("Bold");
        JLabel ItalicLabel = new JLabel("Italic");
        JLabel UnderlineLabel = new JLabel("Underline");
        JLabel FontColorLabel = new JLabel("Font Color");
        //ComboBox
        String[] FontStyleList = {"Bradley Hand ITC", "STXingkai", "Comic Sans MS"};
        JComboBox FontStyleComboBox = new JComboBox(FontStyleList);

        String[] FontSizeList = {"Middle", "Large", "OverSized"};
        JComboBox FontSizeComboBox = new JComboBox(FontSizeList);

        String[] FontAlignList = {"Left", "Center", "Right"};
        JComboBox FontAlignComboBox = new JComboBox(FontAlignList);

        String[] YesNoList = {"No", "Yes"};
        JComboBox BoldComboBox = new JComboBox(YesNoList);
        JComboBox ItalicComboBox = new JComboBox(YesNoList);
        JComboBox UnderlineComboBox = new JComboBox(YesNoList);

        String[] FontColorList = {"Red", "Blue", "Green"};
        JComboBox FontColorComboBox = new JComboBox(FontColorList);

        //ActionListener
        ActionListener FontStyleActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SelectedFontName = FontStyleComboBox.getSelectedIndex();
                CustomFontStyleName = FontStyleList[SelectedFontName];
            }
        };
        ActionListener FontSizeActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SelectedFontSize = FontSizeComboBox.getSelectedIndex();
                switch (SelectedFontSize){
                    case 0:
                        CustomFontSize = 16;
                        break;
                    case 1:
                        CustomFontSize = 24;
                        break;
                    case 2:
                        CustomFontSize = 30;
                        break;
                }
            }
        };
        ActionListener FontAlignActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SelectedFontAlign = FontAlignComboBox.getSelectedIndex();
                switch (SelectedFontAlign){
                    case 0:
                        CustomAlign = "left";
                        break;
                    case 1:
                        CustomAlign = "center";
                        break;
                    case 2:
                        CustomAlign = "right";
                        break;
                }
            }
        };
        ActionListener BoldActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SelectedBoldOption = BoldComboBox.getSelectedIndex();
                switch (SelectedBoldOption){
                    case 0:
                        CustomBold = 0;
                        break;
                    case 1:
                        CustomBold = 1;
                        break;
                }
            }
        };
        ActionListener ItalicActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SelectedItalicOption = ItalicComboBox.getSelectedIndex();
                switch (SelectedItalicOption){
                    case 0:
                        CustomItalic = 0;
                        break;
                    case 1:
                        CustomItalic = 1;
                        break;
                }
            }
        };
        ActionListener UnderlineActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SelectedUnderlineOption = UnderlineComboBox.getSelectedIndex();
                switch (SelectedUnderlineOption){
                    case 0:
                        CustomUnderline = 0;
                        break;
                    case 1:
                        CustomUnderline = 1;
                        break;
                }
            }
        };
        ActionListener FontColorActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SelectedFontColorOption = FontColorComboBox.getSelectedIndex();
                switch(SelectedFontColorOption){
                    case 0:
                        CustomFGColor = "FG-Red";
                        break;
                    case 1:
                        CustomFGColor = "FG-Blue";
                        break;
                    case 2:
                        CustomFGColor = "FG-Green";
                        break;
                }
            }
        };
        ActionListener CheckButtonActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
            }
        };

        FontStyleComboBox.addActionListener(FontStyleActionListener);
        FontSizeComboBox.addActionListener(FontSizeActionListener);
        FontAlignComboBox.addActionListener(FontAlignActionListener);
        BoldComboBox.addActionListener(BoldActionListener);
        ItalicComboBox.addActionListener(ItalicActionListener);
        UnderlineComboBox.addActionListener(UnderlineActionListener);
        FontColorComboBox.addActionListener(FontColorActionListener);
        CheckButton.addActionListener(CheckButtonActionListener);
        //layout
        window.add(FontComboBoxLabel);
        window.add(FontStyleComboBox);

        window.add(FontSizeLabel);
        window.add(FontSizeComboBox);

        window.add(FontAlignLable);
        window.add(FontAlignComboBox);

        window.add(BoldLabel);
        window.add(BoldComboBox);

        window.add(ItalicLabel);
        window.add(ItalicComboBox);

        window.add(UnderlineLabel);
        window.add(UnderlineComboBox);

        window.add(FontColorLabel);
        window.add(FontColorComboBox);

        window.add(CheckButton);

        //default selected option
        Control = 1;
        CustomFontStyleName = "Bradley Hand ITC";
        CustomFontSize = 16;
        CustomAlign = "left";
        CustomBold = 0;
        CustomItalic = 0;
        CustomUnderline = 0;
        CustomFGColor = "FG-Red";
    }

}