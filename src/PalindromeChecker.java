import java.util.Stack;

public class PalindromeChecker {

    // Method to check palindrome
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Remove spaces and convert to lowercase
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        // Compare characters
        for (char ch : processed.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}