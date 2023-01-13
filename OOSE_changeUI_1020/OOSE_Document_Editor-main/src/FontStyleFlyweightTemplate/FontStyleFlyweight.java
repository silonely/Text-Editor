package FontStyleFlyweightTemplate;

import Strategy.*;
import Memento.WindowEventListener.ForegroundColor;
import javax.swing.text.StyledEditorKit;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public abstract class FontStyleFlyweight {
    protected String FontStyleName;
    protected static int FontSize;
    protected static int b;
    protected static int i;
    protected static int u;
    protected static String FGColor;
    protected static String align;
    protected static Color c=null;
    protected static int a=0;
    protected FontContext context;

    //template method
    public final void setFontStyle(){
        reset();
        DoSetting();    //hook method
        show();
    }

    public abstract void DoSetting();

    private Map<String,Color> fgcolorlist =new HashMap<String,Color>(){{
        put("FG-Red",Color.RED);
        put("FG-Blue",Color.BLUE);
        put("FG-Green",Color.GREEN);
    }};
    private Map<String,Integer> alignlist =new HashMap<String,Integer>(){{
        put("center",1);
        put("right",2);
        put("left",0);
    }};
    private Map<String, FontStrategy> fontlist =new HashMap<String,FontStrategy>(){{
        put("Bradley Hand ITC",new BradleyHandITC());
        put("STXingkai",new STXingkai());
        put("Comic Sans MS",new ComicSansMS());
    }};

    protected void reset(){
        if (b==1){
            new StyledEditorKit.BoldAction().actionPerformed(null);
            b = 0;
        }
        if (i==1){
            new StyledEditorKit.ItalicAction().actionPerformed(null);
            i = 0;
        }
        if (u==1){
            new StyledEditorKit.UnderlineAction().actionPerformed(null);
            u = 0;
        }
    }

    protected void show(){
        c = fgcolorlist.get(FGColor);
        a = alignlist.get(align);
        context = new FontContext(fontlist.get(FontStyleName));
        context.runStrategy(FontStyleName);
        new StyledEditorKit.FontSizeAction("font-size-"+FontSize,FontSize).actionPerformed(null);
        new StyledEditorKit.AlignmentAction(align,a).actionPerformed(null);
        new ForegroundColor(FGColor, c).actionPerformed(null);
        reset();
    }
}