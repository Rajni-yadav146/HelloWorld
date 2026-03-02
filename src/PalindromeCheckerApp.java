// UseCase3PalindromeCheckerApp.java
import java.util.Scanner;

public class  PalindromeCheckerApp{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for input
        System.out.print("Enter a string to check if it's a palindrome: ");
        String original = scanner.nextLine();

        // Reverse the string using a for loop
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        // Compare original and reversed
        if (original.equals(reversed)) {
            System.out.println("The string \"" + original + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + original + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
}