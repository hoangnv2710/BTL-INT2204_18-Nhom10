package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    /**
     * Kiểm tra chức năng cho thành viên mượn tài liệu.
     *
     * Kịch bản:
     * - Thành viên "tien" cố gắng mượn sách "math".
     * - Sách có đủ số lượng (3 cuốn).
     *
     * Kỳ vọng:
     * - Cho mượn tài liệu thành công và trả về true.
     */
    @Test
    void borrowDocument1() {
        Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
        Member m1 = new Member("tien",2003,"2111","0933","123456");
        boolean result = m1.borrowDocument(b1);
        assertEquals(true, result);
    }

    /**
     * Kiểm tra chức năng cho thành viên mượn tài liệu.
     *
     * Kịch bản:
     * - Thành viên "tien" cố gắng mượn sách "math" lần 2.
     *
     * Kỳ vọng:
     * - Cho mượn thất bại và trả về false do "tien" đã mượn sách này trước đó(không cho một người mượn một tài liệu với số lượng lớn hơn 1).
     */
    @Test
    void borrowDocument2() {
        Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
        Member m1 = new Member("tien",2003,"2111","0933","123456");
        m1.borrowDocument(b1);
        boolean result = m1.borrowDocument(b1);
        assertEquals(false, result);
    }

    /**
     * Kiểm tra chức năng thành viên trả tài liệu.
     *
     * Kịch bản:
     * - Thành viên chưa mượn nhưng lại trả sách.
     *
     * Kỳ vọng:
     * - Trả về false do "tien" chưa mượn tài liệu này.
     */
    @Test
    void returnBorrowedDocument1() {
        Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
        Member m1 = new Member("tien",2003,"2111","0933","123456");
        boolean result = m1.returnBorrowedDocument(b1);
        assertEquals(false, result);
    }

    /**
     * Kiểm tra chức năng thành viên trả tài liệu.
     *
     * Kịch bản:
     * - Thành viên mượn và trả sách.
     *
     * Kỳ vọng:
     * - Trả về true.
     */
    @Test
    void returnBorrowedDocument2() {
        Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
        Member m1 = new Member("tien",2003,"2111","0933","123456");
        m1.borrowDocument(b1);
        boolean result = m1.returnBorrowedDocument(b1);
        assertEquals(true, result);
    }

    /**
     * Kiểm tra chức năng thành viên có đang mượn một tài liệu.
     *
     * Kịch bản:
     * - Cho thành viên mượn và kiểm tra.
     *
     * Kỳ vọng:
     * - Trả về true.
     */
    @Test
    void isBorrowedDocument1() {
        Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
        Member m1 = new Member("tien",2003,"2111","0933","123456");
        m1.borrowDocument(b1);
        boolean result = m1.isBorrowedDocument(b1);
        assertEquals(true, result);
    }

    /**
     * Kiểm tra chức năng thành viên có đang mượn một tài liệu.
     *
     * Kịch bản:
     * - Cho thành viên mượn sau đó trả và kiểm tra.
     *
     * Kỳ vọng:
     * - Trả về false do thành viên này đã trả sách.
     */
    @Test
    void isBorrowedDocument2() {
        Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
        Member m1 = new Member("tien",2003,"2111","0933","123456");
        m1.borrowDocument(b1);
        m1.returnBorrowedDocument(b1);
        boolean result = m1.isBorrowedDocument(b1);
        assertEquals(false, result);
    }

    /**
     * Kiểm tra chức năng in danh sách tài liệu đã mượn của một thành viên.
     *
     * Kịch bản:
     * - Cho thành viên mượn và kiểm tra.
     *
     * Kỳ vọng:
     * - Trả về đúng danh sách cho mượn.
     */
    @Test
    void borrowedInfo1() {
        Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
        Thesis t1 = new Thesis("thesis test","HoangNV","VNU-2102-0435",1,"test");
        Member m1 = new Member("tien",2003,"2111","0933","123456");
        m1.borrowDocument(b1);
        m1.borrowDocument(t1);
        String result = m1.borrowedInfo();
        assertEquals("tien has borrowed the following documents\n\t 978-3-16-148410-0   : math - Nguyen Van Hoang\n" +
                "\t VNU-2102-0435       : thesis test - HoangNV\n", result);
    }

    /**
     * Kiểm tra chức năng in danh sách tài liệu đã mượn của một thành viên.
     *
     * Kịch bản:
     * - Kiểm tra thành viên chưa hiện sách nào.
     *
     * Kỳ vọng:
     * - Trả về thông tin thành viên này chưa mượn sách.
     */
    @Test
    void borrowedInfo2() {
        Member m1 = new Member("tien",2003,"2111","0933","123456");
        String result = m1.borrowedInfo();
        assertEquals("tien hasn't borrowed any documents.", result);
    }

    /**
     * Kiểm tra chức năng in thông tin của thành viên.
     */
    @Test
    void printInfo() {
        Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
        Thesis t1 = new Thesis("thesis test","HoangNV","VNU-2102-0435",1,"test");
        Member m1 = new Member("tien",2003,"2111","0933","123456");
        m1.borrowDocument(b1);
        m1.borrowDocument(t1);
        String result = m1.printInfo();
        assertEquals("Member ID: 2111\n\tPassword: 123456\n\tName: tien\n" +
                "\tYear of Birth: 2003\n\tPhone number: 0933\ntien has borrowed the following documents\n" +
                "\t 978-3-16-148410-0   : math - Nguyen Van Hoang\n\t VNU-2102-0435       : thesis test - HoangNV\n",result);
    }
}