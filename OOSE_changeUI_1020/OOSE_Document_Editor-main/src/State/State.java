package State;

import Bridge_UI.WholeWindow;

public interface State {
    String getStateType();
    void switchState(WholeWindow context);
}
