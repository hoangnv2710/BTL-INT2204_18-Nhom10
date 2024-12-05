package org.example;

import org.example.CommandLine;
import org.example.Login;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Login login = Login.getInstance();
        login.login("2102","123456");
        CommandLine.commandLineStart();

    }
}

