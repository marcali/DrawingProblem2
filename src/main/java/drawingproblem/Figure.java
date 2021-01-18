package drawingproblem;

public abstract class Figure {
    protected int x1;
    protected int x2;
    protected int y1;
    protected int y2;
    protected int xDiff;
    protected int yDiff;
    protected int[] coordinatesOfTheFigure;

    public Figure(InitialCoordinatesWrapper coordinates) {
        this.x1 = coordinates.x1;
        this.y1 = coordinates.y1;
        this.x2 = coordinates.x2;
        this.y2 = coordinates.y2;
        this.xDiff = Math.abs(x2 - x1);
        this.yDiff = Math.abs(y2 - y1);

    }

    public abstract int[] returnCoordinates(int w);

    protected int[] calculateCoordinatesOfVerticalLine(Integer y, Integer x, Integer diff, int w) {
        int[] nl = new int[diff + 1];
        int start = lineStart(y, x, w);
        nl[0] = start;

        for (int i = 1; i <= diff; i++) {

            nl[i] = nl[i - 1] + w + 3;
        }

        return nl;
    }

    protected int[] calculateCoordinatesOfHorizontalLine(Integer y, Integer x, Integer diff, int w) {
        int[] nl = new int[diff + 1];
        int start = lineStart(y, x, w);
        nl[0] = start;

        for (int i = 1; i <= diff; i++) {
            nl[i] = nl[i - 1] + 1;
        }

        return nl;
    }

    protected int lineStart(Integer min, Integer max, int w) {
        int lineStart = ((w + 2) * (min)) + max + (min - 1) + 1;
        return lineStart;
    }
}
