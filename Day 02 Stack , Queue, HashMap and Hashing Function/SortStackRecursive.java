import java.util.Stack;
public class SortStackRecursive{
    public static void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int temp = stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack, temp);
        }
    }
    public static void insertInSortedOrder(Stack<Integer> stack, int element){
        if(stack.isEmpty() || stack.peek()<=element){
            stack.push(element);
        }
        else{
            int temp = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(temp);
        }
    }
    public static void printStack(Stack<Integer> stack){
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int value = stack.pop();
            System.out.print(value + " ");
            temp.push(value);
        }
        System.out.println();
        
        // Push elements back to restore the original stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("Original Stack: ");
        printStack(stack);
        sortStack(stack);
        System.out.println("Sorted stack");
        printStack(stack);
    }
}