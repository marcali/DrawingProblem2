package drawingproblem;

import java.util.*;

public class Rectangle extends Figure {
    Rectangle(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public int[] returnCoordinates(int w) {
        int[] l1 = calculateCoordinatesOfHorizontalLine(y1, x1, xDiff, w);
        int[] l2 = calculateCoordinatesOfHorizontalLine(y2, x1, xDiff, w);
        int[] l3 = calculateCoordinatesOfVerticalLine(y1, x1, yDiff, w);
        int[] l4 = calculateCoordinatesOfVerticalLine(y1, x2, yDiff, w);

        List<int[]> allL = new ArrayList();
        allL.add(l1);
        allL.add(l2);
        allL.add(l3);
        allL.add(l4);

        coordinatesOfTheFigure = new int[l1.length + l2.length + l3.length + l4.length];

        int count = 0;

        for (int[] list : allL) {
            for (int element : list) {
                coordinatesOfTheFigure[count] = element;
                count++;
            }
        }

        return coordinatesOfTheFigure;
    }
}
