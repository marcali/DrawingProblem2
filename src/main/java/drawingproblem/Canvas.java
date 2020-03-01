package drawingproblem;

public class Canvas {
    public int w;
    public int h;
    public char[] result;


    public Canvas(int w, int h) {
        this.w = w;
        this.h = h;
        this.result = new char[(w + 2) * (h + 2) + h + 2];
    }


    public char[] drawCanvas() throws InvalidParameters {
        int count = 0;

        try {
            for (int i = 0; i < h + 2; i++) {
                if (i == 0 || i == h + 1) {
                    for (char element : returnFirstAndLastLineArray()) {
                        result[count] = element;
                        count++;
                    }
                } else {
                    for (char element : returnMiddleLineArray()) {
                        result[count] = element;
                        count++;
                    }
                }
            }
        } catch (Exception e) {
            throw new InvalidParameters("Parameters entered are Invalid", e);
        }

        return result;
    }

    private char[] returnMiddleLineArray() {
        char[] result = new char[w + 3];
        char newLine = '\n';
        char slash = '|';
        char blank = ' ';

        for (int j = 0; j < w + 3; j++) {
            if (j == 0 || j == w + 1) {
                result[j] = slash;
            } else if (j < w + 2) {
                result[j] = blank;
            } else {
                result[j] = newLine;
            }
        }
        return result;
    }


    private char[] returnFirstAndLastLineArray() {
        char[] result = new char[w + 3];
        char dash = '-';
        char newLine = '\n';

        for (int i = 0; i < w + 3; i++) {
            if (i < w + 2) {
                result[i] = dash;
            } else {
                result[i] = newLine;
            }
        }
        return result;
    }

    public void drawFigure(Figure fig) {

        for (int i : fig.returnCoordinates(this.w)) {
            result[i] = 'x';
        }

    }

    public void draw() {
        System.out.print(new String(result));
    }


    public static class InvalidParameters extends Exception {
        public InvalidParameters(String errorMessage, Throwable err)
        {
            super(errorMessage, err);
        }
    }
}