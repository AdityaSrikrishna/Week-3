import java.util.Stack;

class MyQueue{
    private Stack<Integer> stackEnqueue;
    private Stack<Integer> stackDequeue;
    public MyQueue(){
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }
    public void enqueue(int x){
       stackEnqueue.push(x);
    }
    public int dequeue(){
        if(stackDequeue.isEmpty()){
            while (!stackEnqueue.isEmpty()){ 
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        if(stackDequeue.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return stackDequeue.pop();
    }
    public int peek(){
        if(stackDequeue.isEmpty()){
            while(!stackEnqueue.isEmpty()){
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        if(stackDequeue.isEmpty()){
            throw  new RuntimeException("Queue is Empty.");
        }
        return stackDequeue.peek();
    }
    public boolean isEmpty(){
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }
}
public class QueueMain{
    public static void main(String[] Args){
        MyQueue queue1 = new MyQueue();
        queue1.enqueue(10);
        queue1.enqueue(20);
        queue1.enqueue(30);
        System.out.println(queue1.dequeue());
        System.out.println(queue1.peek());
        System.out.println(queue1.isEmpty());
    }
}
