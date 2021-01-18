package drawingproblem;

public class InitialCoordinatesWrapper
{
    public int x1;
    public int x2;
    public int y1;
    public int y2;
    private int[] result;

    public InitialCoordinatesWrapper(String consoleInput) {
        this.result = returnCoordinatesArray(consoleInput);
        this.x1 = result[0];
        this.y1 = result[1];
        this.x2 = result[2];
        this.y2 = result[3];

    }

    protected int[] returnCoordinatesArray(String consoleInput) {
        String[] console = consoleInput.split(" ");
        //possibly better identifier of length for result is console var
        result = new int[consoleInput.length() - 1];

        for (int i = 1; i <= console.length - 1; i++) {
            int n = Integer.parseInt(console[i]);
            result[i - 1] = n;
        }

        return result;
    }

}

