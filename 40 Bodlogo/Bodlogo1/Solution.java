import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static long getWays(int n, List<Long> coins) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (long coin : coins) {
            for (int i = (int) coin; i <= n; i++) {
                dp[i] += dp[i - (int) coin];
            }
        }

        return dp[n];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstInput[0]);
        int m = Integer.parseInt(firstInput[1]);

        String[] coinsStr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Long> coins = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            coins.add(Long.parseLong(coinsStr[i]));
        }

        long ways = Result.getWays(n, coins);
        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}