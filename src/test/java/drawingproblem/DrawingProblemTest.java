package drawingproblem;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import java.io.BufferedReader;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DrawingProblemTest {
    private DrawingProblem dp;
    private Canvas cv;
    private Figure fg;
    String canvasDimentions = "C 20 10";
    String horizontalLine = "L 1 3 7 3";
    String verticalLine = "L 7 1 7 3";
    String rectangle = "R 11 2 15 6";
    String programQuit = "Q";



    @Test
    public void testCanvasCreated() throws IOException, Canvas.InvalidParameters
    {
        DrawingProblem dp = new DrawingProblem();
//        dp.outputAction(canvasDimentions);
//        assertEquals(true,dp.canvasCreated);

    }

}
