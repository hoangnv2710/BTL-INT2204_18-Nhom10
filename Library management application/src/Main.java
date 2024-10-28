import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library l = Library.getInstance();
        Document a = new Book("xstk","LTA","4",4,"Sach");
        System.out.println(l.addDocument(a));
        System.out.println(l.addDocument(a));
        System.out.println(a.printInfo());
//        System.out.println(l.removeDocument(a));
//        System.out.println(l.removeDocument(a));
        List<Document> l1 = new ArrayList<>();
        l1.add(a);
        User u1 = new Member("hung",18,"21034","094816",l1);
        System.out.println(l.addUser(u1));
        System.out.println(l.userBorrow("4","21034"));
        System.out.println(l.userBorrow("4","21034"));
    }
}

