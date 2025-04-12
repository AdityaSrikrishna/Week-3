import java.util.Stack;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while the current price is greater or equal
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, then all previous prices were <= current
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push this day's index onto the stack
            stack.push(i);
        }

        return span;
    }

    // Testing the function
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] result = calculateSpan(prices);

        System.out.print("Span: ");
        for (int s : result) {
            System.out.print(s + " ");
        }
    }
}
