package solver;

import data.Point;
import data.Rectangle;

import java.util.*;

public class CompressedCoordsMapSolver implements RectsWithPointsSolver {
    private int[][] map;
    protected List<Integer> mappedX, mappedY;
    @Override
    public void preprocessingRectangles(List<Rectangle> rectangles) {
        mappedX = new ArrayList<>();
        mappedY = new ArrayList<>();
        for(Rectangle rectangle:rectangles){
            mappedX.add(rectangle.leftDown().x());
            mappedX.add(rectangle.rightUp().x()+1);
            mappedY.add(rectangle.leftDown().y());
            mappedY.add(rectangle.rightUp().y()+1);
        }
        Collections.sort(mappedX);
        Collections.sort(mappedY);
        mappedX = getListWithRemovedUniqueValues(mappedX);
        mappedY = getListWithRemovedUniqueValues(mappedY);
        map = new int[mappedX.size()-1][mappedY.size()-1];
        for(Rectangle rectangle:rectangles){
            Point mappedLeftDown = findMappedPoint(rectangle.leftDown());
            Point mappedRightUp = findMappedPoint(rectangle.rightUp());
            for(int mappedX=mappedLeftDown.x(); mappedX<=mappedRightUp.x(); mappedX++){
                for(int mappedY=mappedLeftDown.y(); mappedY<=mappedRightUp.y(); mappedY++){
                    map[mappedX][mappedY]++;
                }
            }
        }
    }
    protected Point findMappedPoint(Point point){
        int x = findMappedIndex(mappedX, point.x());
        int y = findMappedIndex(mappedY, point.y());
        if(x==-1||y==-1) return null;
        return new Point(x, y);
    }
    protected static int findMappedIndex(List<Integer> mappedList, int value) {
        if(value==mappedList.get(0)) return 0;
        if(value<mappedList.get(0)) return -1;
        if(value>=mappedList.get(mappedList.size()-1)) return -1;
        int index = 1;
        while (index<mappedList.size() && mappedList.get(index)<value){
            index = index << 1;
        }
        if(index>=mappedList.size()){
            index = mappedList.size()-1;
        }
        while (value<mappedList.get(index)){
            index--;
        }
        return index;
    }

    protected static List<Integer> getListWithRemovedUniqueValues(List<Integer> list) {
        List<Integer> res = new ArrayList<>(list.size());
        Integer prev = null;
        for(Integer value:list){
            if(prev==null||!prev.equals(value)){
                res.add(value);
            }
            prev = value;
        }
        return res;
    }

    @Override
    public int getRectanglesCountWithPoint(Point point) {
        Point mappedPoint = findMappedPoint(point);
        if(mappedPoint==null) return 0;
        return map[mappedPoint.x()][mappedPoint.y()];
    }
}
