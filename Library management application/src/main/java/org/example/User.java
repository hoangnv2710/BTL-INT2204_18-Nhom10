package org.example;

public abstract class User {
    protected String name;
    protected int yearOfBirth;
    protected String phoneNumber;
    protected String userId;
    protected String password;

    public User(String name, int yearOfBirth, String userId, String phoneNumber, String password) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public abstract String printInfo();
}
