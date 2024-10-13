package framework;

public class FrameworkException extends RuntimeException{

    public FrameworkException(String message, TestUtil testUtil, int lineNumber)
    {
        super("Error occured due to: "+message+" at the line number: "+lineNumber);
    }
}
