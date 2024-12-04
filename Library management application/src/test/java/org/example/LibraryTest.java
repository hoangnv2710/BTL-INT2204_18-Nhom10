package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void userBorrow1() {
        try {
            Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
            Member m1 = new Member("tien",2003,"2111","0933","123456");
            Library.getInstance().userBorrow("1234","2111");
            fail("Expected ISBNNotFoundException was not thrown");
        } catch (ISBNNotFoundException e) {
        } catch (Exception e) {
            fail("Unexpected exception");
        }
    }

    @Test
    void userBorrow2() {
        try {
            Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
            Member m1 = new Member("tien",2003,"2111","0933","123456");
            Library.getInstance().userBorrow("978-3-16-148410-0","1234");
            fail("Expected UserNotFoundException was not thrown");
        } catch (UserNotFoundException e) {
        } catch (Exception e) {
            fail("Unexpected exception");
        }
    }

    @Test
    void userBorrow3() {
        boolean result = false;
        try {
            Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
            Member m1 = new Member("tien",2003,"2111","0933","123456");
            result = Library.getInstance().userBorrow("978-3-16-148410-0","2111");
        } catch (UserNotFoundException e) {
            fail("No exception was expected, but got UserNotFoundException");
        } catch (ISBNNotFoundException e) {
            fail("No exception was expected, but got ISBNNotFoundException");
        }
        assertEquals(true,result);
    }

//    @Test
//    void userBorrow() {
//        try {
//            Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
//            Thesis t1 = new Thesis("thesis test","HoangNV","VNU-2102-0435",1,"test");
//            Member m1 = new Member("tien",2003,"2111","0933","123456");
//            Library.getInstance().userBorrow("1234","2111");
//            fail("Expected ISBNNotFoundException was not thrown");
//        } catch (UserNotFoundException e) {
//        } catch (ISBNNotFoundException e) {
//        }
//    }

    @Test
    void userReturn() {
    }

    @Test 
    void removeDocumentByISBN() {
    }

    @Test
    void findDocumentByIBSN() {
    }
}