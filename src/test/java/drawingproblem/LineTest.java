package drawingproblem;

import org.junit.*;

import java.util.*;

public class LineTest {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int w;
    private Line newline;

    @Test
    public void testVerticalLineCoordinates() {
        x1 = 7;
        x2 = 1;
        y1 = 7;
        y2 = 3;
        w = 20;
        int[] expected = {30, 53, 76};

        newline = new Line(x1, x2, y1, y2);
        newline.returnCoordinates(w);


        Assert.assertArrayEquals("Should be" + Arrays.toString(expected),expected, newline.coordinatesOfTheFigure);
    }

    @Test
    public void testHorizontalLineCoordinates() {
        x1 = 1;
        x2 = 3;
        y1 = 7;
        y2 = 3;
        w = 20;
        int[] expected = {70, 71, 72, 73, 74, 75, 76};

        newline = new Line(x1, x2, y1, y2);
        newline.returnCoordinates(w);


        Assert.assertArrayEquals("Should be" + Arrays.toString(expected),expected, newline.coordinatesOfTheFigure);
    }
}
