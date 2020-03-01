package drawingproblem;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class RectangleTest {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int w;
    private Rectangle newRectangle;

    @Test
    public void testRectangleCoordinates() {
        x1 = 15;
        x2 = 2;
        y1 = 20;
        y2 = 5;
        w = 20;
        int[] expected = {61, 62, 63, 64, 65, 66, 130, 131, 132, 133, 134, 135, 61, 84, 107, 130, 66, 89, 112, 135};

        newRectangle = new Rectangle(x1, x2, y1, y2);
        newRectangle.returnCoordinates(w);


        Assert.assertArrayEquals("Should be" + Arrays.toString(expected), expected, newRectangle.coordinatesOfTheFigure);
    }
}
