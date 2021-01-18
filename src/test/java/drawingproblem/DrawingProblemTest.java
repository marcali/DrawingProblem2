package drawingproblem;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;

public class DrawingProblemTest {

    @Test
    public void testCoordinatesValidation() throws IOException, InvalidParametersException
    {
        DrawingProblem dp = new DrawingProblem();

        String canvasInput = "c 10 10";
        InitialCoordinatesWrapper testCanvasCoordinates = new InitialCoordinatesWrapper(canvasInput);
        Canvas testCanvas = new Canvas(testCanvasCoordinates);
        dp.canvas = testCanvas;

        String wrongLineCoordinates = "L 11 3 11 6";
        InitialCoordinatesWrapper testLineCoordinates = new InitialCoordinatesWrapper(wrongLineCoordinates);

        Boolean testValidation = dp.coordinatesValidationPassed(testLineCoordinates);

        assertEquals("Should be false", false, testValidation);

    }

    @Test
    public void testCanvasCreated() throws IOException, InvalidParametersException
    {
        DrawingProblem dp = new DrawingProblem();

        String canvasInput = "c 10 10";
        dp.outputAction(canvasInput);

        assertEquals("canvasCreated value should be true", true, dp.canvasCreated);

    }

}
