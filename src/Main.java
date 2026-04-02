import java.util.*;

// Step 1: Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// Step 2: Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        // Compare while popping
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Step 3: Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// Step 4: Context Class
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.check(input);
    }
}

// Step 5: Main Class
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack");
        System.out.println("2. Deque");

        int choice = sc.nextInt();

        // Inject strategy dynamically
        if (choice == 1) {
            context.setStrategy(new StackStrategy());
        } else {
            context.setStrategy(new DequeStrategy());
        }

        boolean result = context.execute(input);

        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        sc.close();
    }
}
