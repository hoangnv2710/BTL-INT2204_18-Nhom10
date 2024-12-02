package org.example;

public class Librarian extends User {

    public Librarian(String name, int yearOfBirth, String userId, String phoneNumber, String password) {
        super(name, yearOfBirth, userId, phoneNumber, password);
    }

    @Override
    public String printInfo() {
        return String.format("User ID: %s\n\tPassword: %s\n\tName: %s\n\tYear of Birth: %d\n\tPhone number: %s\n", userId, password, name, yearOfBirth, phoneNumber);
    }
}
