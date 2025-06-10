import java.util.*;

public class Solution {

    public static String[] bomberMan(int n, String[] grid) {
        if (n == 1) return grid;
        if (n % 2 == 0) {
            String[] full = new String[grid.length];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < grid[0].length(); i++) sb.append('O');
            Arrays.fill(full, sb.toString());
            return full;
        }

        String[] grid3 = explode(grid);
        String[] grid5 = explode(grid3);

        return (n % 4 == 3) ? grid3 : grid5;
    }

    private static String[] explode(String[] grid) {
        int r = grid.length, c = grid[0].length();
        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) Arrays.fill(map[i], 'O');

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i].charAt(j) == 'O') {
                    map[i][j] = '.';
                    if (i > 0) map[i - 1][j] = '.';
                    if (i < r - 1) map[i + 1][j] = '.';
                    if (j > 0) map[i][j - 1] = '.';
                    if (j < c - 1) map[i][j + 1] = '.';
                }
            }
        }

        String[] result = new String[r];
        for (int i = 0; i < r; i++) result[i] = new String(map[i]);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        String[] grid = new String[r];
        for (int i = 0; i < r; i++) grid[i] = sc.nextLine();
        String[] result = bomberMan(n, grid);
        for (String line : result) System.out.println(line);
    }
}
