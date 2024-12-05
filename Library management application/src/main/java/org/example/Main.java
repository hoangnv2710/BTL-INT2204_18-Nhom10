package org.example;

import org.example.CommandLine;
import org.example.Login;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Book b1 = new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study");
//        Thesis t1 = new Thesis("thesis test","HoangNV","VNU-2102-0435",1,"test");
//        Member m1 = new Member("tien",2003,"2111","0933","123456");
//        m1.borrowDocument(b1);
//        m1.borrowDocument(t1);
//        String result = m1.printInfo();
//        System.out.println(result);
//        Librarian l1 = new Librarian("Hoang",2003,"21020435","0948702162","123456");
//        String result = l1.printInfo();
//        System.out.println(result);

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


        //Public API:
        //https://www.metaweather.com/api/location/search/?query=<CITY>
        //https://www.metaweather.com/api/location/44418/
//        try {
//            URL url = new URL("https://www.metaweather.com/api/location/search/?query=London");
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.connect();
//
//            //Check if connect is made
//            int responseCode = conn.getResponseCode();
//
//            // 200 OK
//            if (responseCode != 200) {
//                throw new RuntimeException("HttpResponseCode: " + responseCode);
//            } else {
//
//                StringBuilder informationString = new StringBuilder();
//                Scanner scanner = new Scanner(url.openStream());
//
//                while (scanner.hasNext()) {
//                    informationString.append(scanner.nextLine());
//                }
//                //Close the scanner
//                scanner.close();
//
//                System.out.println(informationString);
//
//
//                //JSON simple library Setup with Maven is used to convert strings to JSON
//                JSONParser parse = new JSONParser();
//                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));
//
//                //Get the first JSON object in the JSON array
//                System.out.println(dataObject.get(0));
//
//                JSONObject countryData = (JSONObject) dataObject.get(0);
//
//                System.out.println(countryData.get("woeid"));
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}

