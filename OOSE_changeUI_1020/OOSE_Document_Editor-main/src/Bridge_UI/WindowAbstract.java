package  Bridge_UI;

import Mediator.Mediator;

import javax.swing.*;
import java.awt.*;

public abstract class WindowAbstract {
    WindowInterface impl;
    public WindowAbstract(WindowInterface impl){
        this.impl = impl;
    }
    public String getEnvironment(){ return this.impl.getOSName(); }
    public Font getSystemFont(){ return this.impl.getOSFont(); }
    public JFrame drawFrame(){ return this.impl.drawFrame(); }
    public Mediator getMediator(){ return this.impl.getMediator(); }
}



