package org.example;

public class ISBNNotFoundException extends Exception {
    public ISBNNotFoundException() {}
    public ISBNNotFoundException(String message) {
        super(message);
    }
}
