package Rank1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the compareTriplets function below.
    // Complete the function compareTriplets in the editor below. It must return an array of two integers,
    // the first being Alice's score and the second being Bob's.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        Integer[] score = {0, 0};

        if (a.size() != b.size()) {
            return Arrays.asList(score);
        }

        int length = a.size();
        for (int i = 0; i < length; i++) {

            // Alice gets one point
            if (a.get(i) > b.get(i)) {
                score[0] += 1;
            }

            // Bob gets one point
            else if (a.get(i) < b.get(i)) {
                score[1] += 1;
            }
        }

        return Arrays.asList(score);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        System.out.println(result.stream()
                .map(Object::toString)
                .collect(joining(" "))
                + "\n");

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}