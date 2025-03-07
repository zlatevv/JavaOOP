package WorkingWithAbstraction.PointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] coordinates = scanner.nextLine().split("\\s+");

        int bottomLeftX = Integer.parseInt(coordinates[0]);
        int bottomLeftY = Integer.parseInt(coordinates[1]);
        int topRightX = Integer.parseInt(coordinates[2]);
        int topRightY = Integer.parseInt(coordinates[3]);

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] pointCoords = scanner.nextLine().split(" ");
            int pointX = Integer.parseInt(pointCoords[0]);
            int pointY = Integer.parseInt(pointCoords[1]);
            Point point = new Point(pointX, pointY);
            System.out.println(rectangle.contains(point));
        }
    }
}
