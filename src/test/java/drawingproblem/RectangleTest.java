package drawingproblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class RectangleTest {

    private int w;
    private Rectangle newRectangle;

    @Test
    public void testRectangleCoordinates() throws InvalidParametersException {
        w = 20;
        int[] expected = {61, 62, 63, 64, 65, 66, 130, 131, 132, 133, 134, 135, 61, 84, 107, 130, 66, 89, 112, 135};

        String consoleInput = "R 15 2 20 5";
        InitialCoordinatesWrapper testCoordinates = new InitialCoordinatesWrapper(consoleInput);
        newRectangle = new Rectangle(testCoordinates);
        newRectangle.returnCoordinates(w);


        Assert.assertArrayEquals("Should be" + Arrays.toString(expected), expected, newRectangle.coordinatesOfTheFigure);
    }
}
