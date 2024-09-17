package main.java.lab2.exception;

public class FileNotFoundOrPermissionDeniedException extends RuntimeException {
    public FileNotFoundOrPermissionDeniedException(String message) {
        super(message);
    }
}
