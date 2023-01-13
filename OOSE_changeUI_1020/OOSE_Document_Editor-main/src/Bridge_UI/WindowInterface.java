package  Bridge_UI;

import Mediator.Mediator;

import javax.swing.*;
import java.awt.*;

public interface WindowInterface {
    String getOSName();
    JFrame drawFrame();
    void setOSFont(Font systemFont);
    void setOSBaseFont();
    Font getOSFont();
    void  initfont();
    Mediator getMediator();
}
