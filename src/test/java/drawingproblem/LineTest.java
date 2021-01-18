package drawingproblem;

import org.junit.*;
import java.util.*;

public class LineTest {

    private int w;
    private Line newline;

    @Test
    public void testVerticalLineCoordinates() throws InvalidParametersException {
        w = 20;
        int[] expected = {30, 53, 76};

        String consoleInput = "L 7 1 7 3";
        InitialCoordinatesWrapper testCoordinates = new InitialCoordinatesWrapper(consoleInput);
        newline = new Line(testCoordinates);
        newline.returnCoordinates(w);


        Assert.assertArrayEquals("Should be" + Arrays.toString(expected), expected, newline.coordinatesOfTheFigure);
    }

    @Test
    public void testHorizontalLineCoordinates() throws InvalidParametersException {
        w = 20;
        int[] expected = {70, 71, 72, 73, 74, 75, 76};

        String consoleInput = "L 1 3 7 3";
        InitialCoordinatesWrapper testCoordinates = new InitialCoordinatesWrapper(consoleInput);
        newline = new Line(testCoordinates);
        newline.returnCoordinates(w);


        Assert.assertArrayEquals("Should be" + Arrays.toString(expected), expected, newline.coordinatesOfTheFigure);
    }
}
