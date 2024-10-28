public abstract class User {
    private String name;
    private int age;
    private String phoneNumber;
    private String userId;

    public User(String name, int age, String userId, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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



    public abstract String printInfo();
}
