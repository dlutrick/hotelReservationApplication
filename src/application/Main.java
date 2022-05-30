package application;

import application.controller.Application;
import application.controller.LoggedIn;

public class Main {
    public static void main(String[] args) {
        LoggedIn loggedIn = new LoggedIn(true);
        Application app = new Application();
        try {
            app.start(loggedIn.getLoggedIn());
        } catch(Exception e) {
            System.out.println(e);
        }

    }
}
