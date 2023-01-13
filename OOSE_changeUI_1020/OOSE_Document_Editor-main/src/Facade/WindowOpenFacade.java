package Facade;

import Bridge_UI.Mac_WindowInterface;
import Bridge_UI.WholeWindow;
import Bridge_UI.Win_WindowInterface;
import Bridge_UI.WindowInterface;

import javax.swing.*;

public class WindowOpenFacade {
    private static  WindowInterface impl;
    private WholeWindow mainWindow;
    private JFrame frame;

    public  WindowOpenFacade(){
        String os = System.getProperty("os.name").toLowerCase();

        if(os.indexOf("win")>=0){
            impl = new Win_WindowInterface().getInstance();
        }else if(os.indexOf("mac")>=0){
            impl = new Mac_WindowInterface().getInstance();
        }
        mainWindow = new WholeWindow(impl);
        frame=  mainWindow.getframe();
    }

    public void start(){
        //set impl Font
        impl.setOSBaseFont();
        //set all UI text font
        impl.initfont();
        //mainWindow run init...
        mainWindow.run();
        //And frame will process pack...
        frame.pack();
        //set base setting
        mainWindow.SetBaseSetting();
        //show EditorViewer
        mainWindow.loadFromEditorViewer();

    }

}
