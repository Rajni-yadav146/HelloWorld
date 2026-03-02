<<<<<<< HEAD
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (checker.checkPalindrome(input)) {
            System.out.println("It is a Palindrome.");
        } else {
            System.out.println("It is NOT a Palindrome.");
        }

        scanner.close();
=======

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
>>>>>>> 737cd848ceecb3ce399b217f281d3e36672f8f91
    }
}