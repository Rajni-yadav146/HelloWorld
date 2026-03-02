// File: UseCase5PalindromeCheckerApp.java

import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it's a palindrome:");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome!");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        str = str.replaceAll("\\s+", "").toLowerCase(); // remove spaces and ignore case

        // Push all characters onto the stack
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters and compare with original
        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false; // mismatch found
            }
        }

        return true; // all characters matched
    }
}
