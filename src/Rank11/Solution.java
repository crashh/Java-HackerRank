package Rank11;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter(System.lineSeparator());

        String a = scan.next();
        String b = scan.next();
        String c = scan.next();

        scan.close();

        System.out.println("String: " + c);
        System.out.println("Double: " + Double.parseDouble(b.trim()));
        System.out.println("Int: " + Integer.parseInt(a.trim()));
    }
}