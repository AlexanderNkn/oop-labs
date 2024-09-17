package main.java.lab3.exception;

public class IncorrectFileException extends RuntimeException{
    public IncorrectFileException(String message) {
        super(message);
    }
}
