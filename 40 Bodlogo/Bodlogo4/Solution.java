import java.util.*;

public class Solution {
    public static List<Integer> absolutePermutation(int n, int k) {
        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i - k > 0 && !used[i - k]) {
                result.add(i - k);
                used[i - k] = true;
            } else if (i + k <= n && !used[i + k]) {
                result.add(i + k);
                used[i + k] = true;
            } else {
                return Arrays.asList(-1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            List<Integer> res = absolutePermutation(n, k);
            for (int num : res) System.out.print(num + " ");
            System.out.println();
        }
    }
}
