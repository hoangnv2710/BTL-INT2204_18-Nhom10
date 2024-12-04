package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void printInfo() {
        Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
        String result = b1.printInfo();
        assertEquals("ISBN: 978-3-16-148410-0\n\tTitle: math\n\t" +
                "Author: Nguyen Van Hoang\n\tDocument type: Book\n\tGenre: study\n\tQuantity: 3\n",result);
    }
}