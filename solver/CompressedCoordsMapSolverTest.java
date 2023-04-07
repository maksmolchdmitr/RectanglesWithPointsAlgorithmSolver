package solver;

import data.Point;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CompressedCoordsMapSolverTest {
    @Test
    void findMappedIndex(){
        List<Integer> mappedList = new ArrayList<>(List.of(1, 3, 6, 7));
        assertEquals(CompressedCoordsMapSolver.findMappedIndex(mappedList, 0), -1);
        assertEquals(CompressedCoordsMapSolver.findMappedIndex(mappedList, 1), 0);
        assertEquals(CompressedCoordsMapSolver.findMappedIndex(mappedList, 2), 0);
        assertEquals(CompressedCoordsMapSolver.findMappedIndex(mappedList, 3), 1);
        assertEquals(CompressedCoordsMapSolver.findMappedIndex(mappedList, 4), 1);
        assertEquals(CompressedCoordsMapSolver.findMappedIndex(mappedList, 5), 1);
        assertEquals(CompressedCoordsMapSolver.findMappedIndex(mappedList, 6), 2);
        assertEquals(CompressedCoordsMapSolver.findMappedIndex(mappedList, 7), -1);
    }

    @Test
    void findMappedPoint(){
        CompressedCoordsMapSolver solver = new CompressedCoordsMapSolver();
        solver.mappedX = List.of(1, 3, 6, 7);
        solver.mappedY = List.of(1, 2, 5, 7);
        for(int x=-3; x<=0; x++){
            for(int y=-3; y<=0; y++){
                assertNull(solver.findMappedPoint(new Point(x, y)));
            }
        }
        for(int x=1; x<=2; x++){
            for(int y=1; y<=1; y++){
                assertEquals(solver.findMappedPoint(new Point(x, y)),
                        new Point(0, 0));
            }
        }
        for(int x=3; x<=5; x++){
            for(int y=2; y<=4; y++){
                assertEquals(solver.findMappedPoint(new Point(x, y)),
                        new Point(1, 1));
            }
        }
        assertNull(solver.findMappedPoint(new Point(7, 7)));
    }
    @Test
    void getListWithRemovedUniqueValues() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 3, 3, 4, 5, 5, 6, 7, 8, 9));
        assertEquals(CompressedCoordsMapSolver.getListWithRemovedUniqueValues(list),
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
}