package drawingproblem;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CanvasTest {

    private Canvas cv;
    private final char NEW_LINE = '\n';
    private final char SLASH = '|';
    private final char BLANK = ' ';
    private final char DASH = '-';
    private final char X_CHAR = 'x';

    @Test
    public void testCanvasCreation() throws InvalidParametersException
    {
        int w = 20;
        int count = 0;
        
        String consoleInput = "C 20 20";
        InitialCoordinatesWrapper testCoordinates = new InitialCoordinatesWrapper(consoleInput);
        cv =  new Canvas(testCoordinates);
        cv.drawCanvas();

        for(int i=0;i<w+2;i++) {

            assertEquals("Should be -", DASH, cv.result[i]);
            count++;
        }

        assertEquals("Should be /n", NEW_LINE, cv.result[count]);
        count++;
        assertEquals("Should be |", SLASH, cv.result[count]);
        count++;


        for(int i=count;i<w+2;i++) {
            assertEquals("Should be blank", BLANK, cv.result[i]);
            count++;
        }
    }

    @Test
    public void testDrawingPoints() throws InvalidParametersException
    {
        int w = 20;
        char x = X_CHAR;
        String consoleInput = "C 20 20";
        InitialCoordinatesWrapper testCoordinates = new InitialCoordinatesWrapper(consoleInput);
        cv =  new Canvas(testCoordinates);
        cv.drawCanvas();

        Line mockLine =  Mockito.mock(Line.class);
        when(mockLine.returnCoordinates(w)).thenReturn( new int[]{70, 71, 72, 73, 74});
        cv.drawFigure(mockLine);
        for(int i = 70; i < 75; i++)
        {
            assertEquals("Should be x", x, cv.result[i]);
        }
    }
}
