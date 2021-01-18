package drawingproblem;

public class Canvas {
    public int width;
    public int height;
    public char[] result;

    private final char NEW_LINE = '\n';
    private final char SLASH = '|';
    private final char BLANK = ' ';
    private final char DASH = '-';
    private final char X_CHAR = 'x';


    public Canvas(InitialCoordinatesWrapper widthAndHeightCoordinates) {
        this.width = widthAndHeightCoordinates.x1;
        this.height = widthAndHeightCoordinates.y1;
        if(width < 100 || height < 100 )
        {
            this.result = new char[(width + 2) * (height + 2) + height + 2];
        }else
        {
            System.out.println("These canvas coordinates are too large, please chose smaller canvas");
        }

    }

    public char[] drawCanvas() throws InvalidParametersException {
        int count = 0;

        try {
            for (int i = 0; i < height + 2; i++) {
                if (i == 0 || i == height + 1) {
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
            throw new InvalidParametersException("An error has occurred due to invalid coordinates", e);
        }

        return result;
    }

    private char[] returnMiddleLineArray() {
        char[] middleLine = new char[width + 3];

        for (int j = 0; j < width + 3; j++) {
            if (j == 0 || j == width + 1) {
                middleLine[j] = SLASH;
            } else if (j < width + 2) {
                middleLine[j] = BLANK;
            } else {
                middleLine[j] = NEW_LINE;
            }
        }
        return middleLine;
    }


    private char[] returnFirstAndLastLineArray() {
        char[] firstAndLastLine = new char[width + 3];
        
        for (int i = 0; i < width + 3; i++) {
            if (i < width + 2) {
             firstAndLastLine[i] = DASH;
            } else {
             firstAndLastLine[i] = NEW_LINE;
            }
        }
        return firstAndLastLine;
    }

    public void drawFigure(Figure fig) throws InvalidParametersException {

        for (int i : fig.returnCoordinates(this.width)) {
         result[i] = X_CHAR;
        }

    }

    public void draw() {
        System.out.print(new String(result));
    }

}