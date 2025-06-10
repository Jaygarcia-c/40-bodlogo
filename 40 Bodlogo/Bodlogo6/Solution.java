import java.util.*;

public class Solution {

    public static int twoPluses(String[] grid) {
        int n = grid.length, m = grid[0].length();
        int[][] maxSize = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) != 'G') continue;
                int size = 0;
                while (i - size >= 0 && i + size < n &&
                       j - size >= 0 && j + size < m &&
                       grid[i - size].charAt(j) == 'G' &&
                       grid[i + size].charAt(j) == 'G' &&
                       grid[i].charAt(j - size) == 'G' &&
                       grid[i].charAt(j + size) == 'G') {
                    maxSize[i][j]++;
                    size++;
                }
            }
        }

        int maxProduct = 0;
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int size1 = 0; size1 < maxSize[i1][j1]; size1++) {
                    Set<String> occupied = getCells(i1, j1, size1);
                    for (int i2 = 0; i2 < n; i2++) {
                        for (int j2 = 0; j2 < m; j2++) {
                            for (int size2 = 0; size2 < maxSize[i2][j2]; size2++) {
                                Set<String> cells2 = getCells(i2, j2, size2);
                                boolean overlap = false;
                                for (String c : cells2) {
                                    if (occupied.contains(c)) {
                                        overlap = true;
                                        break;
                                    }
                                }
                                if (!overlap) {
                                    int area1 = size1 * 4 + 1;
                                    int area2 = size2 * 4 + 1;
                                    maxProduct = Math.max(maxProduct, area1 * area2);
                                }
                            }
                        }
                    }
                }
            }
        }

        return maxProduct;
    }

    private static Set<String> getCells(int x, int y, int size) {
        Set<String> set = new HashSet<>();
        set.add(x + "," + y);
        for (int i = 1; i <= size; i++) {
            set.add((x + i) + "," + y);
            set.add((x - i) + "," + y);
            set.add(x + "," + (y + i));
            set.add(x + "," + (y - i));
        }
        return set;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) grid[i] = sc.nextLine();
        System.out.println(twoPluses(grid));
    }
}