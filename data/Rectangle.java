package data;

import java.util.Scanner;

public record Rectangle(Point leftDown, Point rightUp){
    public static Rectangle readRectangle(Scanner in) {
        return new Rectangle(
                new Point(in.nextInt(), in.nextInt()),
                new Point(in.nextInt(), in.nextInt())
        );
    }
}
