package Rank8;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        List<String> dateFormats = Arrays.asList("hh:mm:ss aa", "hh:mm:ssaa", "hh:mm:ss:aa");
        Date date = null;

        for (String format: dateFormats) {
            try {
                date = new SimpleDateFormat(format).parse(s);
            } catch (ParseException e) {
                // ignored
            }
        }

        if (date == null) {
            return "Parsing failed.";
        }

        return new SimpleDateFormat("HH:mm:ss").format(date);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        System.out.println(result);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
