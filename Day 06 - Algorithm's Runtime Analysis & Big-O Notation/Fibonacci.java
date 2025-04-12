

public class Fibonacci{
    public static int FibRecursive(int n){
        if(n<=1) return n;
        return FibRecursive(n-1) + FibRecursive(n-2);
    }
    public static int FibIterative(int n){
        int a=0, b=1, nextsum = 0;
        if(n<=1) return n;
        for(int i=2; i<=n; i++){
            nextsum = a+b;
            a=b;
            b=nextsum;
        }
        return b;
    }
    public static int FibonacciMemoised(int n, int[] memo){
        if(n<=1) return n;
        if(memo[n]!=-1) return memo[n];
        memo[n] = FibonacciMemoised(n-1, memo) + FibonacciMemoised(n-2, memo);
        return memo[n];
    }
    public static void main(String[] args) {
        int n= 30;
        long start = System.currentTimeMillis();
        int FibRecursivE = FibRecursive(n);
        long end = System.currentTimeMillis();
        System.out.println("Recursive Fibonacci( " + n + " )= " + FibRecursivE + " in " + (end-start) + " ms");

        start = System.currentTimeMillis();
        int fibit = FibIterative(n);
        end = System.currentTimeMillis();
        System.out.println("Iterative Fibonacci( " + n + " )=" + fibit + " in " + (end-start) + " ms");
        
        int[] memo = new int[n+1];
        for(int i=0; i<=n; i++){
            memo[i] = -1;
        }
        start = System.currentTimeMillis();
        int fibmemo = FibonacciMemoised(n, memo);
        end = System.currentTimeMillis();
        System.out.println("Memoised Fibonacci( " + n + " )=" + fibmemo + " in " + (end-start) + " ms");
    }
}