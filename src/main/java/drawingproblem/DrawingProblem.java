package drawingproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrawingProblem {
    protected static boolean keepExecuting;
    protected static boolean canvasCreated;
    protected Canvas canvas;

    public static void main(String[] args) throws IOException, InvalidParametersException {
        canvasCreated = false;

        DrawingProblem dp = new DrawingProblem();
        keepExecuting = true;
        while (keepExecuting) {
            System.out.println("Please enter a command.");
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String consoleInput = console.readLine();

            dp.outputAction(consoleInput);
        }
    }

    protected Boolean outputAction(String consoleInput) throws InvalidParametersException {
        char command = Character.toUpperCase(consoleInput.charAt(0));

        if (command == 'C') {

            canvasCreated = true;
            InitialCoordinatesWrapper coordinates = new InitialCoordinatesWrapper(consoleInput);

            canvas = new Canvas(coordinates);
            canvas.drawCanvas();
        } else if (command == 'L' || command == 'R') {
            if (canvasCreated) {

                InitialCoordinatesWrapper coordinates = new InitialCoordinatesWrapper(consoleInput);
                if (coordinatesValidationPassed(coordinates)) {
                    Figure newFigure = (command == 'R') ? new Rectangle(coordinates) : new Line(coordinates);
                    canvas.drawFigure(newFigure);
                } else {
                    System.out.println("Please give coordinates that are not out of canvas boundaries.");
                }
            }

        } else if (command == 'Q') {
            keepExecuting = false;
        }
        else{
            System.out.println("This command is not recognised, please type C, L or R");
        }

        if (canvas != null) {
            canvas.draw();
        }
        return keepExecuting;
    }

    protected Boolean coordinatesValidationPassed(InitialCoordinatesWrapper coordinates) {
        return coordinates.x1 > 0
        && canvas.width >= coordinates.x1
        && coordinates.x2 > 0
        && canvas.width >= coordinates.x2
        && coordinates.y1 > 0
        && canvas.height >= coordinates.y1 && coordinates.y2 > 0
        && canvas.height >= coordinates.y2;
    }
}
