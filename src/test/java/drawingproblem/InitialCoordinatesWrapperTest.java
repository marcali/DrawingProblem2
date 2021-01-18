package drawingproblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InitialCoordinatesWrapperTest {

    @Test
    public void testCanvasCoordinates()
    {
        int x1 = 20;
        int y1 = 20;
        String consoleInput = "C 20 20";
        InitialCoordinatesWrapper testCoordinates = new InitialCoordinatesWrapper(consoleInput);
        assertEquals("Should be" + toString().valueOf(x1), x1, testCoordinates.x1);
        assertEquals("Should be" + toString().valueOf(y1), x1, testCoordinates.y1);

    }

    @Test
    public void testFigureCoordinates()
    {
        int x1 = 7;
        int y1 = 1;
        int x2 = 7;
        int y2 = 3;
        String consoleInput = "L 7 1 7 3";
        InitialCoordinatesWrapper testCoordinates = new InitialCoordinatesWrapper(consoleInput);

        assertEquals("Should be" + toString().valueOf(x1), x1, testCoordinates.x1);
        assertEquals("Should be" + toString().valueOf(y1), y1, testCoordinates.y1);
        assertEquals("Should be" + toString().valueOf(x2), x2, testCoordinates.x2);
        assertEquals("Should be" + toString().valueOf(y2), y2, testCoordinates.y2);

    }
}
