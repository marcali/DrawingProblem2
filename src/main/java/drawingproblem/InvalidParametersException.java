package drawingproblem;

public class InvalidParametersException extends Exception {

    public InvalidParametersException(String errorMessage, Throwable err)
        {
            super(errorMessage, err);
        }
    }
