package data;

import java.util.Objects;
import java.util.Scanner;

public record Point(int x, int y){
    public static Point readPoint(Scanner in) {
        return new Point(in.nextInt(), in.nextInt());
    }

    public boolean behaveInRectangle(Rectangle rectangle) {
        return (x >= rectangle.leftDown().x && y >= rectangle.leftDown().y)
                && (x <= rectangle.rightUp().x && y <= rectangle.rightUp().y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
