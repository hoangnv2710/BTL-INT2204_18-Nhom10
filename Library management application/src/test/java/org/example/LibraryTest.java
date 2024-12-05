package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void userBorrow1() {
        try {
            Book b1 = new Book("math","Nguyen Van Hoang","1",3,"study");
            Member m1 = new Member("tien",2003,"2111","0933","123456");
            Library l = Library.getInstance();
            l.addDocument(b1);
            l.addUser(m1);
            l.userBorrow("2","2111");
            fail("Expected ISBNNotFoundException was not thrown");
        } catch (ISBNNotFoundException e) {
        } catch (Exception e) {
            fail("Unexpected exception");
        }
    }

    @Test
    void userBorrow2() {
        try {
            Book b1 = new Book("math","Nguyen Van Hoang","1",3,"study");
            Member m1 = new Member("tien",2003,"2111","0933","123456");
            Library l = Library.getInstance();
            l.addDocument(b1);
            l.addUser(m1);
            l.userBorrow("1","23213");
            fail("Expected ISBNNotFoundException was not thrown");
        } catch (UserNotFoundException e) {
        } catch (Exception e) {
            fail("Unexpected exception");
        }
    }

    @Test
    void userBorrow3() {
        boolean result = false;
        try {
            Book b1 = new Book("math","Nguyen Van Hoang","1",3,"study");
            Member m1 = new Member("tien",2003,"2111","0933","123456");
            Library l = Library.getInstance();
            l.addDocument(b1);
            l.addUser(m1);
            l.userBorrow("1","2111");
            result = Library.getInstance().userBorrow("978-3-16-148410-0","2111");
        } catch (Exception e) {
            fail("Unexpected exception");
        }
        assertEquals(true,result);
    }

}