package drawingproblem;

import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CanvasTest {


    private Canvas cv;

    @Test
    public void testCanvasCreation() throws Canvas.InvalidParameters
    {
        int w = 20;
        int h = 20;
        char dash = '-';
        int count = 0;
        char newLine = '\n';
        char slash = '|';
        char blank = ' ';

        cv =  new Canvas(w, h);
        cv.drawCanvas();

        for(int i=0;i<w+2;i++) {
            assertEquals("Should be -", dash, cv.result[i]);
            count++;
        }

        assertEquals("Should be /n", newLine, cv.result[count]);
        count++;
        assertEquals("Should be |", slash, cv.result[count]);
        count++;


        for(int i=count;i<w+2;i++) {
            assertEquals("Should be blank", blank, cv.result[i]);
            count++;
        }
    }

    @Test
    public void testDrawingPoints() throws Canvas.InvalidParameters
    {
        int w = 20;
        int h = 20;
        char x = 'x';
        cv =  new Canvas(w, h);
        cv.drawCanvas();

        Line myLine =  Mockito.mock(Line.class);
        when(myLine.returnCoordinates(w)).thenReturn( new int[]{70, 71, 72, 73,74});
        cv.drawFigure(myLine);
        for(int i = 70; i < 75; i++)
        {
            assertEquals("Should be x", x, cv.result[i]);
        }
    }
}
