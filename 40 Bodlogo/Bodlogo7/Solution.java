import java.util.*;

public class Solution {

    public static int lilysHomework(List<Integer> arr) {
        return Math.min(getMinSwaps(arr, true), getMinSwaps(arr, false));
    }

    private static int getMinSwaps(List<Integer> arr, boolean ascending) {
        int n = arr.size();
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) sorted[i] = arr.get(i);

        Arrays.sort(sorted);
        if (!ascending) {
            for (int i = 0; i < n / 2; i++) {
                int tmp = sorted[i];
                sorted[i] = sorted[n - 1 - i];
                sorted[n - 1 - i] = tmp;
            }
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) indexMap.put(arr.get(i), i);

        int swaps = 0;
        List<Integer> a = new ArrayList<>(arr);
        for (int i = 0; i < n; i++) {
            int correctValue = sorted[i];
            if (a.get(i) != correctValue) {
                swaps++;
                int idxToSwap = indexMap.get(correctValue);

                indexMap.put(a.get(i), idxToSwap);
                indexMap.put(correctValue, i);

                int temp = a.get(i);
                a.set(i, a.get(idxToSwap));
                a.set(idxToSwap, temp);
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(sc.nextInt());
        System.out.println(lilysHomework(arr));
    }
}