package State;

import Bridge_UI.WholeWindow;

import java.awt.*;

public class InitialState implements State{
    private String stateType = "Initial";
    public InitialState(){ }

    @Override
    public String getStateType(){
        return stateType;
    }
    @Override
    public void switchState(WholeWindow context){
        context.setState(new WorkingState());
        context.editorViewer.setText("");
        context.editorViewer.setBackground(Color.white);
    }
}
