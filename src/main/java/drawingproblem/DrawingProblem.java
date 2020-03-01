package drawingproblem;

import com.google.common.annotations.VisibleForTesting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrawingProblem {
    private static boolean keepExecuting;
    private static boolean canvasCreated;
    private Canvas cv;

    public static void main(String[] args) throws IOException, Canvas.InvalidParameters {
        canvasCreated = false;

        DrawingProblem dp = new DrawingProblem();
        keepExecuting = true;
        while (keepExecuting == true) {
            System.out.println("Please enter a command.");
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String consoleInput = console.readLine();

            dp.outputAction(consoleInput);
        }
    }

    @VisibleForTesting
    private Boolean outputAction(String consoleInput) throws Canvas.InvalidParameters {
        char command = Character.toUpperCase(consoleInput.charAt(0));
        int[] coordinates = returnCoordinatesArray(consoleInput);

        if (command == 'C') {

            canvasCreated = true;
            int w = coordinates[0];
            int h = coordinates[1];
            cv = new Canvas(w, h);
            cv.drawCanvas();
        } else if (command == 'L' || command == 'R') {
            if (canvasCreated == true) {
                int x1 = coordinates[0];
                int y1 = coordinates[1];
                int x2 = coordinates[2];
                int y2 = coordinates[3];

                if (x1 > 0 & cv.w >= x1 & x2 > 0 && cv.w >= x2 & y1 > 0 & cv.h >= y1 & y2 > 0 & cv.h >= y2) {
                    Figure nf = (command == 'R') ? new Rectangle(x1, y1, x2, y2) : new Line(x1, y1, x2, y2);
                    cv.drawFigure(nf);
                } else {
                    System.out.print("Please give coordinates are not out of canvas boundaries.\n");
                }
            }


        } else if (command == 'Q') {
            keepExecuting = false;
        }

        if (cv != null) {
            cv.draw();
        }
        return keepExecuting;
    }

    private int[] returnCoordinatesArray(String consoleInput) {
        String[] console = consoleInput.split(" ");
        int[] result = new int[consoleInput.length() - 1];

        for (int i = 1; i <= console.length - 1; i++) {
            int n = Integer.parseInt(console[i]);
            result[i - 1] = n;
        }

        return result;
    }

}
