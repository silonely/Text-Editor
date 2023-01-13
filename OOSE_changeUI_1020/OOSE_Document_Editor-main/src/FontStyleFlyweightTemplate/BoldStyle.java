package FontStyleFlyweightTemplate;

import javax.swing.text.StyledEditorKit;

public class BoldStyle extends FontStyleFlyweight{
    public void DoSetting(){
        if(b==0){
            b=1;
        }else{
            b=0;
        }
        new StyledEditorKit.BoldAction().actionPerformed(null);
    }
}
