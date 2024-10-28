import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        System.out.println("Welcome to My Application!");
        do {
            System.out.println("[0] Exit");
            System.out.println("[1] Add Document");
            System.out.println("[2] Remove Document");
            System.out.println("[3] Update Document");
            System.out.println("[4] Find Document");
            System.out.println("[5] Display Document");
            System.out.println("[6] Add User");
            System.out.println("[7] Borrow Document");
            System.out.println("[8] Return Document");
            System.out.println("[9] Display User Info");
            System.out.println("[9] Login & Logout");
            System.out.print("Your action: ");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 0:

                    break;
                case 1:
                    try {
                        CommandLine.choice1();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please try later!!");
                    }
                    break;
                case 2:
                    CommandLine.choice2();
                    break;
                case 3:
                    CommandLine.choice3();
                    break;
                case 4:
                    CommandLine.choice4();
                    break;
                case 5:
                    CommandLine.choice5();
                    break;
                case 6:
                    CommandLine.choice6();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Action is not supported");
            }
        } while (choice != 0);

    }
}

