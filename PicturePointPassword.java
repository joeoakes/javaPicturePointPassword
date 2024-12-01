import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PicturePointPassword extends JFrame {
    private JLabel imageLabel;
    private ArrayList<Point> selectedPoints;
    private ImageIcon image;

    public PicturePointPassword() {
        setTitle("Picture Point Password System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        selectedPoints = new ArrayList<>();

        // Load and display the image
        image = new ImageIcon("your-image.jpg"); // Replace with your image path
        imageLabel = new JLabel(image);
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clickedPoint = e.getPoint();
                selectedPoints.add(clickedPoint);
                System.out.println("Point added: " + clickedPoint);
            }
        });

        add(imageLabel);
        setVisible(true);
    }

    public ArrayList<Point> getSelectedPoints() {
        return selectedPoints;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PicturePointPassword::new);
    }
}
