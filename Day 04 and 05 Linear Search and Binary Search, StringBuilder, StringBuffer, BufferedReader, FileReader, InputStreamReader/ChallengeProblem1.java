import java.io.*;

public class ChallengeProblem1 {

    public static void main(String[] args) {
        // Step 1: Test StringBuilder and StringBuffer for String concatenation
        String[] testStrings = {"hello"};
        int repetitions = 1000000;

        // Test StringBuilder
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            for (String str : testStrings) {
                stringBuilder.append(str);
            }
        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        System.out.println("StringBuilder Time: " + stringBuilderTime / 1_000_000 + " ms");

        // Test StringBuffer
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < repetitions; i++) {
            for (String str : testStrings) {
                stringBuffer.append(str);
            }
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        System.out.println("StringBuffer Time: " + stringBufferTime / 1_000_000 + " ms");

        // Step 2: Test FileReader and InputStreamReader for reading a large file and counting words
        String filePath = "large_file.txt";  // Ensure this file exists and is 100MB
        try {
            // Test FileReader
            startTime = System.nanoTime();
            int wordCount = countWordsUsingFileReader(filePath);
            endTime = System.nanoTime();
            long fileReaderTime = endTime - startTime;
            System.out.println("FileReader Word Count: " + wordCount);
            System.out.println("FileReader Time: " + fileReaderTime / 1_000_000 + " ms");

            // Test InputStreamReader
            startTime = System.nanoTime();
            wordCount = countWordsUsingInputStreamReader(filePath);
            endTime = System.nanoTime();
            long inputStreamReaderTime = endTime - startTime;
            System.out.println("InputStreamReader Word Count: " + wordCount);
            System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1_000_000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to count words using FileReader
    private static int countWordsUsingFileReader(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int wordCount = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        bufferedReader.close();
        return wordCount;
    }

    // Method to count words using InputStreamReader
    private static int countWordsUsingInputStreamReader(String filePath) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int wordCount = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        bufferedReader.close();
        return wordCount;
    }
}
