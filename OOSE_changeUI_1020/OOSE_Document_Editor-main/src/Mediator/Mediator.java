package Mediator;

import Memento.WindowEventListener;

public abstract class Mediator {
    public abstract ScrollBar createScrollbar();
    public abstract MenuBar createMenuBar();
    public abstract Menu createMenu();
    public abstract MenuItem createMenuItem();
    public abstract MenuBar createMenuBar(WindowEventListener windowEventListener);
    public abstract Menu getFontStyleMenu();
    public abstract Menu getColorMenu();
    public abstract Menu getSizeMenu();
    public abstract Menu getFontMenu();
    public abstract Menu getAlignMenu();
}
