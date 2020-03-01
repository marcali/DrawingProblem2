package drawingproblem;

public class Line extends Figure {
    Line(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }


    @Override
    public int[] returnCoordinates(int w) {
        if (yDiff == 0) {
            coordinatesOfTheFigure = calculateCoordinatesOfHorizontalLine(y1, x1, xDiff, w);

        } else if (xDiff == 0) {
            coordinatesOfTheFigure = calculateCoordinatesOfVerticalLine(y1, x1, yDiff, w);
        }

        return coordinatesOfTheFigure;
    }
}
