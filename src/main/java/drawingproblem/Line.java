package drawingproblem;

import javax.lang.model.util.ElementScanner6;

public class Line extends Figure {
    Line(InitialCoordinatesWrapper coordinates) {
        super(coordinates);
    }


    @Override
    public int[] returnCoordinates(int w) {

        if(x1==x2 || y1==y2)
        {
            if (yDiff == 0) {
                coordinatesOfTheFigure = calculateCoordinatesOfHorizontalLine(y1, x1, xDiff, w);
            } else if (xDiff == 0) {
                coordinatesOfTheFigure = calculateCoordinatesOfVerticalLine(y1, x1, yDiff, w);
            }
        } else
        {
            System.out.println("A line cannot be bulild with these coordinates");
            return new int[0];
        }
        return coordinatesOfTheFigure;

    }
}
