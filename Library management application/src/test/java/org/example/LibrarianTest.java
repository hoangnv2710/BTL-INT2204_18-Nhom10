package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {

    @Test
    void printInfo() {
        Librarian l1 = new Librarian("Hoang",2003,"21020435","0948702162","123456");
        String result = l1.printInfo();
        assertEquals("Librarian ID: 21020435\n\tPassword: 123456\n\tName: Hoang\n" +
                "\tYear of Birth: 2003\n\tPhone number: 0948702162\n",result);
    }
}