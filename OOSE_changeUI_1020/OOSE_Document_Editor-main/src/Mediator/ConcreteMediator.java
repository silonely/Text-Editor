package Mediator;

import Memento.WindowEventListener;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class ConcreteMediator extends Mediator {
    Menu fontStyleMenu;
    Menu colorMenu;
    Menu sizeMenu;
    Menu fontMenu;
    Menu alignMenu;

    @Override
    public ScrollBar createScrollbar() {
        return new ScrollBar();
    }

    @Override
    public MenuBar createMenuBar() {
        return new MenuBar();
    }

    @Override
    public Menu createMenu() {
        return new Menu();
    }

    @Override
    public MenuItem createMenuItem() {
        return new MenuItem();
    }

    public static Mediator getInstance(){
        return new ConcreteMediator();
    }

    @Override
    public Menu getFontStyleMenu(){
        return fontStyleMenu;
    }
    @Override
    public Menu getColorMenu() {
        return colorMenu;
    }

    @Override
    public Menu getSizeMenu() {
        return sizeMenu;
    }

    @Override
    public Menu getFontMenu() {
        return fontMenu;
    }

    @Override
    public Menu getAlignMenu() {
        return alignMenu;
    }

    @Override
    public MenuBar createMenuBar(WindowEventListener windowEventListener) {
        MenuBar bar = createMenuBar();

        // MenuBar物件宣告
        Menu fileMenu;
        MenuItem newFileMenu;
        MenuItem openFileMenu;
        MenuItem saveFileMenu;
        Menu editMenu;
        MenuItem undoEditMenu;
        MenuItem cutEditMenu;
        MenuItem copyEditMenu;
        MenuItem pasteEditMenu;

        // FontStyleMenu
        MenuItem boldFontStyleMenu;
        MenuItem italicFontStyleMenu;
        MenuItem underlineFontStyleMenu;
        MenuItem styleoneFontStyleMenu;
        MenuItem styletwoFontStyleMenu;
        MenuItem stylethreeFontStyleMenu;
        MenuItem customstyleFontStyleMenu;
        MenuItem customMenu;


        // ColorMenu
        MenuItem redForegroundColorMenu;
        MenuItem greenForegroundColorMenu;
        MenuItem blueForegroundColorMenu;
        MenuItem blackForegroundColorMenu;

        Menu formatMenu;
        MenuItem fullFormatMenu;
        MenuItem plaintextFormatMenu;
        MenuItem ProtectionModeFormatMenu;

        Menu helpMenu;
        MenuItem aboutHelpMenu;

        // SizeMenu
        MenuItem size1Menu;
        MenuItem size2Menu;
        MenuItem size3Menu;


        // FontMenu
        MenuItem TimesNewRomanFontMenu;
        MenuItem ComicSansMSFontMenu;
        MenuItem BradleyHandITCFontMenu;
        MenuItem sthupoFontMenu;
        MenuItem STXingkaiFontMenu;

        // AlignMenu
        MenuItem leftalignMenu;
        MenuItem rightalignMenu;
        MenuItem centeralignMenu;

        // --------------------------------------------------建立選單選項 [檔案]--------------------------------------------------
        fileMenu = createMenu();
        fileMenu.setMenuName("File");
        // 建立 [檔案] 選單子選項
        // --------------------
        newFileMenu =  createMenuItem();
        newFileMenu.setMenuItemName("New");
        newFileMenu.setActionCommand("new");
        // --------------------
        openFileMenu = createMenuItem();
        openFileMenu.setMenuItemName("Open");
        openFileMenu.setActionCommand("open");
        // --------------------
        saveFileMenu = createMenuItem();
        saveFileMenu.setMenuItemName("Save");
        saveFileMenu.setActionCommand("save");

        // 監聽指定選項
        newFileMenu.addActionListener(windowEventListener);
        openFileMenu.addActionListener(windowEventListener);
        saveFileMenu.addActionListener(windowEventListener);

        // 按鈕加入上級選單中
        fileMenu.addMenuItem(newFileMenu);
        fileMenu.addMenuItem(openFileMenu);
        fileMenu.addMenuItem(saveFileMenu);

        // --------------------------------------------------建立選單選項 [編輯]--------------------------------------------------
        editMenu = createMenu();
        editMenu.setMenuName("Edit");
        // 建立 [編輯] 選單子選項
        // --------------------
        undoEditMenu = createMenuItem();
        undoEditMenu.setMenuItemName("Undo");
        undoEditMenu.setActionCommand("undo");
        // --------------------
        cutEditMenu = createMenuItem();
        cutEditMenu.setMenuItemName("Cut (ctrl+x)");
        cutEditMenu.setActionCommand("cut");
        // --------------------
        copyEditMenu = createMenuItem();
        copyEditMenu.setMenuItemName("Copy (ctrl+c)");
        copyEditMenu.setActionCommand("copy");
        // --------------------
        pasteEditMenu = createMenuItem();
        pasteEditMenu.setMenuItemName("Paste (ctrl+v)");
        pasteEditMenu.setActionCommand("paste");
        // --------------------


        // 監聽指定選項
        undoEditMenu.addActionListener(windowEventListener);
        cutEditMenu.addActionListener(windowEventListener);
        copyEditMenu.addActionListener(windowEventListener);
        pasteEditMenu.addActionListener(windowEventListener);


        // 按鈕加入上級選單中
        editMenu.addMenuItem(undoEditMenu);
        editMenu.addMenuItem(cutEditMenu);
        editMenu.addMenuItem(copyEditMenu);
        editMenu.addMenuItem(pasteEditMenu);

        // ----------------------------------建立字型選單-------------------------

        sizeMenu = createMenu();
        sizeMenu.setMenuName("Font Size");

        size1Menu = createMenuItem();
        size1Menu.setMenuItemName("Middle");
        size1Menu.setActionCommand("size1");
        size2Menu = createMenuItem();
        size2Menu.setMenuItemName("Large");
        size2Menu.setActionCommand("size2");
        size3Menu = createMenuItem();
        size3Menu.setMenuItemName("Oversized");
        size3Menu.setActionCommand("size3");


        //監聽字形加入
        size1Menu.addActionListener(windowEventListener);
        size2Menu.addActionListener(windowEventListener);
        size3Menu.addActionListener(windowEventListener);

        sizeMenu.addMenuItem(size1Menu);
        sizeMenu.addMenuItem(size2Menu);
        sizeMenu.addMenuItem(size3Menu);

        // ----------------------------------建立字型選單-------------------------

        fontMenu = createMenu();
        fontMenu.setMenuName("Font");

        // --------------------
        sthupoFontMenu = createMenuItem();
        sthupoFontMenu.setMenuItemName("STHupo");
        sthupoFontMenu.setActionCommand("STHupo");
        sthupoFontMenu.setFont(new Font("STHupo", Font.PLAIN, 14));
        // --------------------
        STXingkaiFontMenu = createMenuItem();
        STXingkaiFontMenu.setMenuItemName("STXingkai");
        STXingkaiFontMenu.setActionCommand("STXingkai");
        STXingkaiFontMenu.setFont(new Font("STXingkai", Font.PLAIN, 14));
        // --------------------
        TimesNewRomanFontMenu = createMenuItem();
        TimesNewRomanFontMenu.setMenuItemName("Times New Roman");
        TimesNewRomanFontMenu.setActionCommand("Times New Roman");
        TimesNewRomanFontMenu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        // --------------------
        ComicSansMSFontMenu = createMenuItem();
        ComicSansMSFontMenu.setMenuItemName("Comic Sans MS");
        ComicSansMSFontMenu.setActionCommand("Comic Sans MS");
        ComicSansMSFontMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        // --------------------
        BradleyHandITCFontMenu = createMenuItem();
        BradleyHandITCFontMenu.setMenuItemName("Bradley Hand ITC");
        BradleyHandITCFontMenu.setActionCommand("Bradley Hand ITC");
        BradleyHandITCFontMenu.setFont(new Font("Bradley Hand ITC", Font.PLAIN, 14));


        // 監聽指定選項
        sthupoFontMenu.addActionListener(windowEventListener);
        STXingkaiFontMenu.addActionListener(windowEventListener);
        TimesNewRomanFontMenu.addActionListener(windowEventListener);
        ComicSansMSFontMenu.addActionListener(windowEventListener);
        BradleyHandITCFontMenu.addActionListener(windowEventListener);
        // 按鈕加入上級選單中
        fontMenu.addMenuItem(TimesNewRomanFontMenu);
        fontMenu.addMenuItem(ComicSansMSFontMenu);
        fontMenu.addMenuItem(BradleyHandITCFontMenu);
        fontMenu.addMenuItem(sthupoFontMenu);
        fontMenu.addMenuItem(STXingkaiFontMenu);
        // --------------------------------------------------建立選單選項 [樣式]--------------------------------------------------
        fontStyleMenu = createMenu();
        fontStyleMenu.setMenuName("Style");
        // 建立 [樣式] 選單子選項
        // --------------------
        boldFontStyleMenu = createMenuItem();
        boldFontStyleMenu.setMenuItemName("Bold");
        boldFontStyleMenu.setActionCommand("Bold");
        boldFontStyleMenu.setFont(new Font(boldFontStyleMenu.getFont().getFontName(), Font.BOLD, 16));
        // --------------------
        italicFontStyleMenu = createMenuItem();
        italicFontStyleMenu.setMenuItemName("Italic");
        italicFontStyleMenu.setActionCommand("Italic");
        italicFontStyleMenu.setFont(new Font(italicFontStyleMenu.getFont().getFontName(), Font.ITALIC, 16));
        // --------------------
        underlineFontStyleMenu = createMenuItem();
        underlineFontStyleMenu.setMenuItemName("Underline");
        underlineFontStyleMenu.setActionCommand("Underline");
        Map attributes = underlineFontStyleMenu.getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        underlineFontStyleMenu.setFont(underlineFontStyleMenu.getFont().deriveFont(attributes));
        // --------------------
        styleoneFontStyleMenu = createMenuItem();
        styleoneFontStyleMenu.setMenuItemName("Style 1");
        styleoneFontStyleMenu.setActionCommand("styleone");
        styleoneFontStyleMenu.setFont(new Font("Bradley Hand ITC", Font.BOLD, 24));
        styleoneFontStyleMenu.setForeground(Color.RED);
        // --------------------
        styletwoFontStyleMenu = createMenuItem();
        styletwoFontStyleMenu.setMenuItemName("Style 2");
        styletwoFontStyleMenu.setActionCommand("styletwo");
        styletwoFontStyleMenu.setFont(new Font("STXingkai", Font.ITALIC, 24));
        styletwoFontStyleMenu.setForeground(Color.BLUE);
        // --------------------
        stylethreeFontStyleMenu = createMenuItem();
        stylethreeFontStyleMenu.setMenuItemName("Style 3");
        stylethreeFontStyleMenu.setActionCommand("stylethree");
        stylethreeFontStyleMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        stylethreeFontStyleMenu.setForeground(Color.GREEN);
        // --------------------
        customstyleFontStyleMenu = createMenuItem();
        customstyleFontStyleMenu.setMenuItemName("Custom Style");
        customstyleFontStyleMenu.setActionCommand("customStyle");
        // --------------------
        customMenu = createMenuItem();
        customMenu.setMenuItemName("Custom...");
        customMenu.setActionCommand("custom");

        // 監聽指定選項
        boldFontStyleMenu.addActionListener(windowEventListener);
        italicFontStyleMenu.addActionListener(windowEventListener);
        underlineFontStyleMenu.addActionListener(windowEventListener);
        styleoneFontStyleMenu.addActionListener(windowEventListener);
        styletwoFontStyleMenu.addActionListener(windowEventListener);
        stylethreeFontStyleMenu.addActionListener(windowEventListener);
        customstyleFontStyleMenu.addActionListener(windowEventListener);
        customMenu.addActionListener(windowEventListener);

        // 按鈕加入上級選單中
        fontStyleMenu.addMenuItem(boldFontStyleMenu);
        fontStyleMenu.addMenuItem(italicFontStyleMenu);
        fontStyleMenu.addMenuItem(underlineFontStyleMenu);
        fontStyleMenu.addMenuItem(styleoneFontStyleMenu);
        fontStyleMenu.addMenuItem(styletwoFontStyleMenu);
        fontStyleMenu.addMenuItem(stylethreeFontStyleMenu);
        fontStyleMenu.addMenuItem(customstyleFontStyleMenu);
        fontStyleMenu.addMenuItem(customMenu);

        // ----------------------------------建立對齊選單-------------------------

        alignMenu = createMenu();
        alignMenu.setMenuName("Align");

        leftalignMenu = createMenuItem();
        leftalignMenu.setMenuItemName("Left");
        leftalignMenu.setActionCommand("left");
        rightalignMenu = createMenuItem();
        rightalignMenu.setMenuItemName("Right");
        rightalignMenu.setActionCommand("right");
        centeralignMenu = createMenuItem();
        centeralignMenu.setMenuItemName("Center");
        centeralignMenu.setActionCommand("center");


        //監聽字形加入
        leftalignMenu.addActionListener(windowEventListener);
        rightalignMenu.addActionListener(windowEventListener);
        centeralignMenu.addActionListener(windowEventListener);

        alignMenu.addMenuItem(leftalignMenu);
        alignMenu.addMenuItem(centeralignMenu);
        alignMenu.addMenuItem(rightalignMenu);

        // --------------------------------------------------建立選單選項 [色彩]--------------------------------------------------
        colorMenu = createMenu();
        colorMenu.setMenuName("Color");
        // 建立 [色彩] 選單子選項
        // --------------------
        redForegroundColorMenu = createMenuItem();
        redForegroundColorMenu.setMenuItemName("Red");
        redForegroundColorMenu.setActionCommand("FG-Red");
        redForegroundColorMenu.setForeground(Color.RED);
        // --------------------
        greenForegroundColorMenu = createMenuItem();
        greenForegroundColorMenu.setMenuItemName("Green");
        greenForegroundColorMenu.setActionCommand("FG-Green");
        greenForegroundColorMenu.setForeground(Color.GREEN);
        // --------------------
        blueForegroundColorMenu = createMenuItem();
        blueForegroundColorMenu.setMenuItemName("Blue");
        blueForegroundColorMenu.setActionCommand("FG-Blue");
        blueForegroundColorMenu.setForeground(Color.BLUE);
        // --------------------

        // --------------------
        blackForegroundColorMenu = createMenuItem();
        blackForegroundColorMenu.setMenuItemName("Black");
        blackForegroundColorMenu.setActionCommand("FG-Black");

        // 監聽指定選項
        redForegroundColorMenu.addActionListener(windowEventListener);
        greenForegroundColorMenu.addActionListener(windowEventListener);
        blueForegroundColorMenu.addActionListener(windowEventListener);

        blackForegroundColorMenu.addActionListener(windowEventListener);

        // 按鈕加入上級選單中
        colorMenu.addMenuItem(redForegroundColorMenu);
        colorMenu.addMenuItem(greenForegroundColorMenu);
        colorMenu.addMenuItem(blueForegroundColorMenu);
        colorMenu.addMenuItem(blackForegroundColorMenu);

        // --------------------------------------------------建立選單選項 [排版]--------------------------------------------------
        formatMenu = createMenu();
        formatMenu.setMenuName("Present");
        // 建立 [排版] 選單子選項
        // --------------------
        fullFormatMenu = createMenuItem();
        fullFormatMenu.setMenuItemName("Normal");
        fullFormatMenu.setActionCommand("Normal");
        // --------------------
        plaintextFormatMenu = createMenuItem();
        plaintextFormatMenu.setMenuItemName("Plain text");
        plaintextFormatMenu.setActionCommand("TextOnly");
        // --------------------
        ProtectionModeFormatMenu = createMenuItem();
        ProtectionModeFormatMenu.setMenuItemName("View");
        ProtectionModeFormatMenu.setActionCommand("ViewOnly");
        // 監聽指定選項
        fullFormatMenu.addActionListener(windowEventListener);
        plaintextFormatMenu.addActionListener(windowEventListener);
        ProtectionModeFormatMenu.addActionListener(windowEventListener);
        // 按鈕加入上級選單中
        formatMenu.addMenuItem(fullFormatMenu);
        formatMenu.addMenuItem(plaintextFormatMenu);
        formatMenu.addMenuItem(ProtectionModeFormatMenu);
        // --------------------------------------------------建立選單選項 [幫助]--------------------------------------------------
        helpMenu = createMenu();
        helpMenu.setMenuName("Help");
        // 建立 [幫助] 選單子選項
        // --------------------
        aboutHelpMenu = createMenuItem();
        aboutHelpMenu.setMenuItemName("WordList check");
        aboutHelpMenu.setActionCommand("about");

        // 監聽指定選項
        aboutHelpMenu.addActionListener(windowEventListener);

        // 按鈕加入上級選單中
        helpMenu.addMenuItem(aboutHelpMenu);

        // --------------------------------------------------按鈕加入上級選單中--------------------------------------------------
        bar.addMenu(fileMenu);
        bar.addMenu(editMenu);
        bar.addMenu(fontMenu);
        bar.addMenu(sizeMenu);
        bar.addMenu(alignMenu);
        bar.addMenu(fontStyleMenu);
        bar.addMenu(colorMenu);
        bar.addMenu(formatMenu);
        bar.addMenu(helpMenu);
        return bar;

    }
}
