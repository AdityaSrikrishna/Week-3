public class StringComparison{
    public static void main(String[] args) {
        int n1 = 1_000_000;
        String string = "";
        long start1, end1;
        start1 = System.currentTimeMillis();
        for(int i=0; i<n1; i++){
            string += "a";
        }
        end1 = System.currentTimeMillis();
        long totaltime1 = end1 - start1;
        long start2, end2;
        StringBuilder sb = new StringBuilder();
        start2 = System.currentTimeMillis();
        for(int i=0; i<n1; i++){
            sb.append("a");
        }
        end2 = System.currentTimeMillis();
        long totaltime2 = end2 - start2;
        long start3, end3;
        StringBuffer sbf = new StringBuffer();
        start3 = System.currentTimeMillis();
        for(int i=0; i<n1; i++){
            sbf.append("a");
        }
        end3 = System.currentTimeMillis();
        long totaltime3 = end3 - start3;
        System.out.println("Time taken for String: " + totaltime1);
        System.out.println("Time taken for String Builder: " + totaltime2);
        System.out.println("Time taken for String Buffer: " + totaltime3);
    }
}