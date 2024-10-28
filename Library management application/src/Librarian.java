public class Librarian extends User {

    public Librarian(String name, int yearOfBirth, String userId, String phoneNumber, String password) {
        super(name, yearOfBirth, userId, phoneNumber, password);
    }

    @Override
    public String printInfo() {
        return "";
    }
}
