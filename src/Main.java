import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

// Recursive Strategy
class RecursiveStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        return isPalindrome(str, 0, str.length() - 1);
    }

    private boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }
}

// Main Class
public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // List of strategies
        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new RecursiveStrategy()
        );

        String[] names = {"Stack", "Deque", "Recursive"};

        // Run each strategy & measure time
        for (int i = 0; i < strategies.size(); i++) {

            long start = System.nanoTime();

            boolean result = strategies.get(i).check(input);

            long end = System.nanoTime();

            long time = end - start;

            System.out.println(names[i] + " Result: " + result);
            System.out.println(names[i] + " Time (ns): " + time);
            System.out.println("------------------------");
        }

        sc.close();
    }
}
