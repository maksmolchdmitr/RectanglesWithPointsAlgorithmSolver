import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import solver.BruteForceSolver;
import solver.CompressedCoordsMapSolver;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

class RectsWithPointsWriterTest {

    @Test
    void writeWithBruteForceAlgorithm() {
        String inputData = """
                4
                2 2 6 8
                5 4 9 10
                4 0 11 6
                8 2 12 12
                5
                2 2
                12 12
                10 4
                5 5
                2 10
                """;
        StringWriter output = new StringWriter();
        RectsWithPointsWriter.write(new Scanner(inputData),
                new PrintWriter(output),
                new BruteForceSolver());
        Assertions.assertEquals(output.toString(), """
                1
                1
                2
                3
                0
                """);
    }

    @Test
    void writeWithCompressedCoordinateMap() {
        String inputData = """
                4
                2 2 6 8
                5 4 9 10
                4 0 11 6
                8 2 12 12
                5
                2 2
                12 12
                10 4
                5 5
                2 10
                """;
        StringWriter output = new StringWriter();
        RectsWithPointsWriter.write(new Scanner(inputData),
                new PrintWriter(output),
                new CompressedCoordsMapSolver());
        Assertions.assertEquals(output.toString(), """
                1
                1
                2
                3
                0
                """);
    }

    @Test
    void writeWithCompressedCoordinateMap_verySimpleTest() {
        String inputData = """
                2
                1 1 5 4
                3 2 6 6
                5
                1 1
                3 2
                4 3
                5 4
                6 6
                """;
        StringWriter output = new StringWriter();
        RectsWithPointsWriter.write(new Scanner(inputData),
                new PrintWriter(output),
                new CompressedCoordsMapSolver());
        Assertions.assertEquals(output.toString(), """
                1
                2
                2
                2
                1
                """);
    }

    @Test void writeWithCompressedCoordinateMap_secondSimpleTest(){
        String inputData = """
                2
                1 1 5 4
                3 2 6 6
                10
                0 0
                1 1
                2 3
                4 1
                5 4
                6 5
                7 3
                7 7
                8 8
                6 6
                """;
        StringWriter output = new StringWriter();
        RectsWithPointsWriter.write(new Scanner(inputData),
                new PrintWriter(output),
                new CompressedCoordsMapSolver());
        Assertions.assertEquals(output.toString(), """
                0
                1
                1
                1
                2
                1
                0
                0
                0
                1
                """);
    }
}