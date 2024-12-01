import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.awt.*;

public class PasswordStorage {
    private ArrayList<String> hashedPoints;

    public PasswordStorage() {
        hashedPoints = new ArrayList<>();
    }

    public void storePassword(ArrayList<Point> points) {
        for (Point point : points) {
            String hashed = hashPoint(point.x, point.y);
            hashedPoints.add(hashed);
        }
    }

    public boolean verifyPassword(ArrayList<Point> inputPoints) {
        if (inputPoints.size() != hashedPoints.size()) {
            return false;
        }

        for (int i = 0; i < inputPoints.size(); i++) {
            String inputHash = hashPoint(inputPoints.get(i).x, inputPoints.get(i).y);
            if (!inputHash.equals(hashedPoints.get(i))) {
                return false;
            }
        }

        return true;
    }

    private String hashPoint(int x, int y) {
        try {
            String pointString = x + "," + y;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(pointString.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
