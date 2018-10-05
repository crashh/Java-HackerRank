package Rank4;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int arrSize = arr.length;

        float postive = 0;
        float negative = 0;
        float zero = 0;

        for (int val : arr) {
            if (val == 0) {
                zero += 1;
            }
            else if (val > 0) {
                postive += 1;
            }
            else if (val < 0) {
                negative += 1;
            }
        }
        System.out.printf("%.5f" + System.lineSeparator(), postive / arrSize);
        System.out.printf("%.5f" + System.lineSeparator(), negative / arrSize);
        System.out.printf("%.5f" + System.lineSeparator(), zero / arrSize);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
