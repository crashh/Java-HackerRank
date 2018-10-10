package Rank9;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;

public class Solution {

    static int getMaxPalindromesFromString(String s) {
        int start = 0;
        int length = 1;
        int max = 0;

        while (start < s.length()) {

            // Check if we reached end of string,
            // and if so start looking from next starting position:
            if (start+length > s.length()) {

                if (max >= s.length() - start) {
                    break; // no longer results exists.
                }

                start++;
                length = 1;
                continue;
            }

            String subString = s.substring(start, start+length);
            boolean isPalindrome = subString.equalsIgnoreCase(new StringBuilder(subString).reverse().toString());

            if (isPalindrome && subString.length() > max) {
                max = subString.length();
            }

            // Increment to next string length:
            length++;
        }

        return max;
    }

    /*
     * Complete the circularPalindromes function below.
     */
    static int[] circularPalindromes(String s) {
        int[] result = new int[s.length()];

        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < s.length(); i++) {
            // Flip letters:

            final int iteration = i;
            es.execute(() -> {
                String input = s.substring(iteration) + s.substring(0, iteration);

                result[iteration] = getMaxPalindromesFromString(input);
            });
        }

        try {
            es.shutdown();
            es.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            es.shutdownNow();
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    /// https://www.hackerrank.com/challenges/circular-palindromes/problem
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int n = Integer.parseInt(scanner.nextLine().trim());

        String s = scanner.nextLine();

        int[] result = circularPalindromes(s);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            //System.out.println(String.valueOf(result[resultItr]));
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }


        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
