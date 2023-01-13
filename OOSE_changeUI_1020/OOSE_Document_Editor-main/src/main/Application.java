package main;
import Facade.WindowOpenFacade;

public class Application
{
    public static void main(String[] args)
    {
        WindowOpenFacade windowOpenFacade = new WindowOpenFacade();
        windowOpenFacade.start();
    }
}