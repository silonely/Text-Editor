package FontStyleFlyweightTemplate;

import javax.swing.text.StyledEditorKit;

public class ItalicStyle extends FontStyleFlyweight{
    public void DoSetting(){
        if(i==0){
            i=1;
        }else{
            i=0;
        }
        new StyledEditorKit.ItalicAction().actionPerformed(null);
    }
}
