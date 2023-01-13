package State;

import Bridge_UI.WholeWindow;

public class WorkingState implements State{
    private String stateType = "Working";

    public WorkingState(){ }
    @Override
    public String getStateType(){
        return stateType;
    }
    @Override
    public void switchState(WholeWindow context){
        context.setState(new SleepingState());
        context.editorViewer.setVisible(false);
    }
}
