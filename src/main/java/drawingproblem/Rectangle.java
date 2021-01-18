package drawingproblem;

public class Rectangle extends Figure {
    Rectangle(InitialCoordinatesWrapper coordinates) {
        super(coordinates);
    }

    @Override
    public int[] returnCoordinates(int w) {
        int[] l1 = calculateCoordinatesOfHorizontalLine(y1, x1, xDiff, w);
        int[] l2 = calculateCoordinatesOfHorizontalLine(y2, x1, xDiff, w);
        int[] l3 = calculateCoordinatesOfVerticalLine(y1, x1, yDiff, w);
        int[] l4 = calculateCoordinatesOfVerticalLine(y1, x2, yDiff, w);

        int[][] allLines = {l1,l2,l3,l4};

        coordinatesOfTheFigure = new int[l1.length + l2.length + l3.length + l4.length];

        int count = 0;

        for (int[] list : allLines) {
            for (int element : list) {
                coordinatesOfTheFigure[count] = element;
                count++;
            }
        }
        if (coordinatesOfTheFigure == null) {
            System.out.println("A rectangle cannot be build with these coordinates");
            return new int[0];

        } else {
            return coordinatesOfTheFigure;
        }
    }
}
