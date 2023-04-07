package solver;

import data.Point;
import data.Rectangle;

import java.util.List;

public interface RectsWithPointsSolver {
    void preprocessingRectangles(List<Rectangle> rectangles);
    int getRectanglesCountWithPoint(Point point);
}
