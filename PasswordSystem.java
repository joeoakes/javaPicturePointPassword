import java.awt.*;
import java.util.Scanner;
import java.util.ArrayList;

public class PasswordSystem {
    public static void main(String[] args) {
        PicturePointPassword passwordCreator = new PicturePointPassword();
        PasswordStorage passwordStorage = new PasswordStorage();

        System.out.println("Click points on the image to set your password...");
        System.out.println("Close the window when done.");

        // Wait for user to close the password setup window
        passwordCreator.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                ArrayList<Point> points = passwordCreator.getSelectedPoints();
                passwordStorage.storePassword(points);

                System.out.println("Password set successfully.");
                authenticate(passwordStorage);
            }
        });
    }

    private static void authenticate(PasswordStorage passwordStorage) {
        PicturePointPassword login = new PicturePointPassword();

        System.out.println("Click points on the image to log in...");
        System.out.println("Close the window when done.");

        login.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                ArrayList<Point> loginPoints = login.getSelectedPoints();
                boolean isAuthenticated = passwordStorage.verifyPassword(loginPoints);

                if (isAuthenticated) {
                    System.out.println("Authentication successful!");
                } else {
                    System.out.println("Authentication failed!");
                }
            }
        });
    }
}
