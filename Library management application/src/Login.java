import java.util.Optional;

public class Login {
    private static Login instance;
    private User userLoggedIn;

     private Login() {
    }

    public static Login getInstance() {
         if(instance == null) {
             instance = new Login();
         }
         return instance;
    }

    public User getUserLoggedIn() {
         return userLoggedIn;
    }

    public boolean login(String userId, String password) {
         Library library = Library.getInstance();
         Optional<User> userOpt = library.findUserByUserId(userId);
         if(userOpt.isPresent()) {
             User user = userOpt.get();
             if(user.getPassword().equals(password)) {
                 userLoggedIn = user;
                 return true;
             }
         }
         return false;
    }

    public boolean register(String name, int yearOfBirth, String userId, String phoneNumber, String password, boolean isMember) {
         Library library = Library.getInstance();
         if(isMember) {
             if (library.addUser(new Member(name, yearOfBirth, userId, phoneNumber, password))) {
                 return true;
             }
         } else {
             if (library.addUser(new Librarian(name, yearOfBirth, userId, phoneNumber, password))) {
                 return true;
             }
         }
         return false;
    }

    public boolean isLoggedIn() {
         return userLoggedIn != null;
    }

    public void logout() {
         userLoggedIn = null;
    }

}
