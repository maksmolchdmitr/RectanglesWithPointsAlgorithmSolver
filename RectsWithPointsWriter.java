import data.Point;
import data.Rectangle;
import solver.BruteForceSolver;
import solver.RectsWithPointsSolver;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RectsWithPointsWriter {
    protected static void write(Scanner in, PrintWriter out, RectsWithPointsSolver solver){
        List<Rectangle> rectangles = readRectangles(in);
        solver.preprocessingRectangles(rectangles);
        List<Point> points = readPoints(in);
        for (Point point:points){
            out.println(solver.getRectanglesCountWithPoint(point));
        }
    }

    private static List<Point> readPoints(Scanner in) {
        List<Point> points = new ArrayList<>();
        int pointCount = in.nextInt();
        for(int i=0; i<pointCount; i++){
            points.add(Point.readPoint(in));
        }
        return points;
    }

    private static List<Rectangle> readRectangles(Scanner in) {
        List<Rectangle> rectangles = new ArrayList<>();
        int rectCount = in.nextInt();
        for(int i=0; i<rectCount; i++){
            rectangles.add(Rectangle.readRectangle(in));
        }
        return rectangles;
    }

    public static void main(String[] args) {
        write(new Scanner(System.in),
                new PrintWriter(System.out, true),
                new BruteForceSolver());
    }
}
