import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final String[] NUM_WORDS = {
        "", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine", "ten", "eleven", "twelve", "thirteen",
        "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
        "nineteen", "twenty", "twenty one", "twenty two", "twenty three",
        "twenty four", "twenty five", "twenty six", "twenty seven",
        "twenty eight", "twenty nine"
    };

    public static String timeInWords(int h, int m) {
        if (m == 0) {
            return NUM_WORDS[h] + " o' clock";
        } else if (m == 1) {
            return "one minute past " + NUM_WORDS[h];
        } else if (m == 15) {
            return "quarter past " + NUM_WORDS[h];
        } else if (m == 30) {
            return "half past " + NUM_WORDS[h];
        } else if (m == 45) {
            return "quarter to " + NUM_WORDS[h + 1];
        } else if (m < 30) {
            return NUM_WORDS[m] + " minutes past " + NUM_WORDS[h];
        } else {
            return NUM_WORDS[60 - m] + " minutes to " + NUM_WORDS[h + 1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        System.out.println(timeInWords(h, m));
    }
}