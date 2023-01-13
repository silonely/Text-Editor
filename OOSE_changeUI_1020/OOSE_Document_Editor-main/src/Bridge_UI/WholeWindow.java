package Bridge_UI;

import Memento.UiOperateListener;
import Memento.WindowEventListener;
import State.State;
import builder.*;
import Mediator.Mediator;
import CompositeAndDecorator.HTML;
import utils.HTMLParser;
import visitor.ContentVisitor;
import visitor.CounterVisitor;
import visitor.WrapLabelVisitor;
import Mediator.Menu;
import Mediator.MenuBar;
import Mediator.MenuItem;
import State.InitialState;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

public class WholeWindow extends WindowAbstract {
    // Frame
    private final JFrame frame;
    private final int width = 800;
    private final int height = 600;
    private final DialogWindow dialogWindow;

    // Listener初始化
    private final WindowEventListener windowEventListener = new WindowEventListener(this);
    private final UiOperateListener uiOperateListener = new UiOperateListener(this);
    private final Mediator mediator;

    // 編輯區初始化
    public final JTextPane editorViewer = new JTextPane();
    private final JPanel statusBar = new JPanel(new BorderLayout());
    private final JLabel statusLabel = new JLabel();

    // 排版物件初始化
    private Builder formatting = new NormalBuild();
    private State state = new InitialState();
    private int old_t = 0;
    private int new_t = -1;
    private int c = 300;

    // Glyph初始化
    private HTML root = null;

    //    變數
    private Menu fontStyleMenu;
    private Menu colorMenu;
    private Menu sizeMenu;
    private Menu fontMenu;
    private Menu alignMenu;
    WrapLabelVisitor wrapLabelVisitor;
    //================================================== GUI ==================================================
    public WholeWindow(WindowInterface win_impl) {
        super(win_impl);                                //把Implementor存著
        mediator = super.getMediator();   //依不同的Implementor取得WidgetFactory
        //-------------------- JFrame --------------------
        // 建立JFrame
        frame = super.drawFrame();                  //依不同的Implementor建出Frame
        frame.setTitle("Group4 Document Editor");
        //設置icon
        ImageIcon img = new ImageIcon("icon.jpg");
        frame.setIconImage(img.getImage());
        frame.setBounds(60, 60, width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 建立MenuBar
        frame.setJMenuBar(createMenuBar());
        // 設定Layout
        frame.setLayout(new BorderLayout());
        frame.add(createScrollPane(editorViewer), BorderLayout.CENTER);
        frame.add(statusBar, BorderLayout.SOUTH);

        // 設定 Dialog Window
        dialogWindow = new DialogWindow(win_impl);
        //設定游標
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

        fontMenu = mediator.getFontMenu();
        fontStyleMenu = mediator.getFontStyleMenu();
        colorMenu = mediator.getColorMenu();
        sizeMenu = mediator.getSizeMenu();
        alignMenu = mediator.getAlignMenu();

        //-------------------- 狀態欄 --------------------
        statusLabel.setHorizontalAlignment(JLabel.RIGHT);
        statusLabel.setFont(super.getSystemFont());
        statusBar.setPreferredSize(new Dimension(statusBar.getWidth(), 30));
        statusBar.add(statusLabel);
        //-------------------- 編輯器區 --------------------
        editorViewer.setContentType("text/html");
        editorViewer.setText("<p><font face=\"Kozuka Gothic Pro B\" size=\"10\" color=\"#000000\">Welcome &nbsp; to &nbsp; Group4 &nbsp; Document &nbsp; Editor...</font></p>" +
                "<p><font face=\"Kozuka Gothic Pro B\" size=\"7\" color=\"#000000\">！！Press &nbsp; any &nbsp; key &nbsp; to &nbsp; start！！</font></p>"); //初始畫面
        //editorViewer.setBackground(Color.blue);
        editorViewer.getDocument().addDocumentListener(uiOperateListener);
        editorViewer.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) { insertBlankText(); }
        });

    }

    public JFrame getframe(){
        return  this.frame;
    }
    public  void SetBaseSetting(){
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    // 執行
    public void run(){
        //打包frame並顯示
        frame.pack();
        frame.setSize(width, height);
        frame.setVisible(true);
        loadFromEditorViewer();
        monitorState();
    }

    //====================================== WholeWindow作為State的Context ======================================
    //監控State
    public void monitorState(){
        while(true){
            try{
                Thread.sleep(100);
                if(old_t == new_t && new_t != 0){
                    if (getState().equals("Working")){ // Now is WorkingState.
                        if (c<=1){
                            changeState(); //change to SleepingState
                            loadFromEditorViewer();
                            c = 300;
                            new_t--;
                        }else{ //倒數30秒
                            c--;
                            if(c<=50 && c%10==0){
                                System.out.println("倒數 "+c/10+" 秒");
                            }
                        }
                    }
                }else if(old_t != new_t){
                    if (getState().equals("Initial") || getState().equals("Sleeping")){ // Now is InitialState or SleepingState
                        changeState(); // change to Working State
                    }
                    old_t = new_t;
                    c = 300;
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    //切換State
    public void changeState(){ state.switchState(this);}
    public void setState(State state){ this.state=state;}
    public String getState(){ return state.getStateType();}

    //================================================== 繪製 ==================================================
    // 繪製 Glyph 內容到 editorViewer 上
    public void drawIntoEditorViewer(){
        if(uiOperateListener.getActive()) {
            Runnable doAssist = () -> {
                // 暫停監聽
                uiOperateListener.setActive(false);
                new_t++;
                // 儲存游標狀態
                int caretPosition = editorViewer.getCaretPosition();
                // 執行Visit
                wrapLabelVisitor = new WrapLabelVisitor(formatting);
                CounterVisitor counterVisitor = new CounterVisitor();
                ContentVisitor contentVisitor = new ContentVisitor();
                root.accept(wrapLabelVisitor);      //傳入drawGlyphVisitor處理Glyph解析
                root.accept(counterVisitor); //利用countCharacterVisitor計算字數
                root.accept(contentVisitor);
                //觀察body
                //System.out.println(drawGlyphVisitor.getParseString());
                // 畫到 editorViewer上
                editorViewer.setText("<html><head><style>*{margin: 20px;}</style></head>" + wrapLabelVisitor.getWholeLebelString() + "</html>");
                //觀察html
                System.out.println(editorViewer.getText());
                editorViewer.setCaretPosition(Math.min(caretPosition, editorViewer.getDocument().getLength()-1));
                // 顯示目前狀態
                statusLabel.setText( counterVisitor.getParagraph() + " Paragraph　" + counterVisitor.getCharacter() + " Character　|　Present mode：" + formatting.getType() + "　|　State: "+getState()+ "　");
                // 重新監聽
                uiOperateListener.setActive(true);
            };
            SwingUtilities.invokeLater(doAssist);
        }
    }

    // 讀取使用者輸入的字
    public void loadFromEditorViewer(){ setEditorContent(new HTMLParser().parse(editorViewer.getText())); }


    //================================================== GETTER SETTER ==================================================
    // 設定內容到 editorViewer
    public void setEditorContent(HTML root){
        this.root = root;
        drawIntoEditorViewer();
    }
    // 設定排版
    public void setFormatting(Builder formatting){
        // 設定排版模式
        this.formatting = formatting;
        drawIntoEditorViewer();
        // 選單按鈕調整
        boolean enabled = this.formatting.getType().equals("Normal");
        fontStyleMenu.setEnabled(enabled);
        colorMenu.setEnabled(enabled);
        sizeMenu.setEnabled(enabled);
        fontMenu.setEnabled(enabled);
        alignMenu.setEnabled(enabled);
        editorViewer.setEditable(true);
    }
    // 取得排版
    public Builder getFormatting(){ return this.formatting; }
    // 取得Glyph
    public HTML getRoot() { return this.root; }
    // 啟動Dialog Window
    public void showDialog(String message, String title) {
        dialogWindow.showDialog(message, title);
    }

    public WrapLabelVisitor getDrawGlyphVisitor(){
        return this.wrapLabelVisitor;
    }
    public void undo(String s){
        editorViewer.setText(s);
    }
    //================================================== INSERT ACTION ==================================================
    // 插入空白字元
    public void insertBlankText(){
        try {
            editorViewer.getDocument().insertString(editorViewer.getCaretPosition(),"&nbsp;", null);
            editorViewer.setCaretPosition(Math.max(0, editorViewer.getCaretPosition()-6));
        }
        catch (BadLocationException e) { e.printStackTrace(); }
    }


    // ==================================================建立 ScrollPane==================================================
    public JScrollPane createScrollPane(Component component){
        JScrollPane scrollPane = new JScrollPane();
        // 建立並設定 ScrollBar
        scrollPane.setVerticalScrollBar(mediator.createScrollbar().setDirection(JScrollBar.VERTICAL));
        scrollPane.setHorizontalScrollBar(mediator.createScrollbar().setDirection(JScrollBar.HORIZONTAL));
        // 內容放入 ScrollPane
        scrollPane.setViewportView(component);
        scrollPane.setBorder(null);
        scrollPane.setEnabled(false);
        return scrollPane;
    }

    // ==================================================建立選單列==================================================
    public MenuBar createMenuBar() {
        return mediator.createMenuBar(this.windowEventListener);
    }
}
