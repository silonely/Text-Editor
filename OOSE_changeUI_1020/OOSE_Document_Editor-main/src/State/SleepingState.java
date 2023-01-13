package State;

import Bridge_UI.WholeWindow;

public class SleepingState implements State{
    private String stateType = "Sleeping";
    public SleepingState(){ }

    @Override
    public String getStateType(){ return stateType;}
    @Override
    public void switchState(WholeWindow context){
        context.setState(new WorkingState());
        context.editorViewer.setVisible(true);
    }
}
