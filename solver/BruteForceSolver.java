package solver;

import data.Point;
import data.Rectangle;

import java.util.List;

public class BruteForceSolver implements RectsWithPointsSolver {
    private List<Rectangle> rectangles;
    @Override
    public void preprocessingRectangles(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    @Override
    public int getRectanglesCountWithPoint(Point point) {
        int count = 0;
        for(Rectangle rectangle:rectangles){
            if(point.behaveInRectangle(rectangle)){
                count++;
            }
        }
        return count;
    }
}
