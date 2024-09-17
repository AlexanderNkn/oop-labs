package main.java.lab2.exception;

public class MatrixSizeExceededException extends RuntimeException {
    public MatrixSizeExceededException(String message) {
        super(message);
    }
}
