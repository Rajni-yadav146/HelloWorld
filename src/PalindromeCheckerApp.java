// File: UseCase6PalindromeCheckerApp.java

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it's a palindrome:");
        String input = scanner.nextLine();

        if (isPalindromeUsingQueueAndStack(input)) {
            System.out.println("The string is a palindrome!");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        scanner.close();
    }

    public static boolean isPalindromeUsingQueueAndStack(String str) {
        // Preprocess string: ignore spaces and case
        str = str.replaceAll("\\s+", "").toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue characters and push to stack
        for (char ch : str.toCharArray()) {
            queue.add(ch);  // FIFO
            stack.push(ch); // LIFO
        }

        // Compare dequeued vs popped characters
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                return false; // mismatch found
            }
        }

        return true; // all characters matched
    }
}