import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Login login = Login.getInstance();
        login.login("2102","123456");
        CommandLine.commandLineStart();

//        Library library = Library.getInstance();
//        User a = new Member("tam",2004,"112","03233","123456");
//        Document b = new Book("oop","nvh","122",1,"st");
//        library.addUser(a);
//        library.addDocument(b);
//        System.out.println(library.userBorrow("123","112"));
//        System.out.println(((Member) a).borrowDocument(b));



    }
}

