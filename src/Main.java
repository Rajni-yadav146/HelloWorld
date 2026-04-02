import java.util.Scanner;

// Service class (Encapsulation)
class PalindromeChecker {

    // Public method to check palindrome
    public boolean checkPalindrome(String input) {

        // Normalize input (ignore spaces & case)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        // Two-pointer logic
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

// Main class
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        sc.close();
    }
}