package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ThesisTest {

    @Test
    void printInfo() {
        Thesis t1 = new Thesis("thesis test","HoangNV","VNU-2102-0435",1,"test");
        String result = t1.printInfo();
        assertEquals("ISRN: VNU-2102-0435\n\tTitle: thesis test\n\tAuthor: HoangNV\n" +
                "\tDocument type: Thesis\n\tTopic: test\n\tQuantity: 1\n",result);
    }
}