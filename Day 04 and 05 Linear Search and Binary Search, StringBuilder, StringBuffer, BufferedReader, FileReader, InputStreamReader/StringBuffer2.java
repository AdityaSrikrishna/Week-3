public class StringBuffer2{
        public static void main(String[] args) {
        final int iterations = 1_000_000;
        String word = "hello";
        
        StringBuilder builder = new StringBuilder();
        long startbuilder = System.nanoTime();
        for(int i=0; i<iterations; i++){
            builder.append(word);
        }
        long endbuilder = System.nanoTime();
        long timebuilder = endbuilder - startbuilder;

        StringBuffer buffer = new StringBuffer();
        long startbuffer = System.nanoTime();
        for(int i=0; i<iterations; i++){
            buffer.append(word);
        }
        long endbuffer = System.nanoTime();
        long timebuffer = endbuffer - startbuffer;

        System.out.println("Time taken by String builder is: " + timebuilder/1_000_000 + "ms");
        System.out.println("Time taken by String buffer is: " + timebuffer/1_000_000 + "ms");
    }  
}