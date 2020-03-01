package drawingproblem;

public abstract class Figure {
    protected int x1;
    protected int x2;
    protected int y1;
    protected int y2;
    protected int xDiff;
    protected int yDiff;
    protected int[] coordinatesOfTheFigure;

    public Figure(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
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
