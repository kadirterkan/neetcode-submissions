class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int ROWS = grid.length, COLS = grid[0].length;
        int[] rows = returnZeros(COLS);
        rows[COLS-1] = 1;

        for (int i = ROWS - 1; i >= 0; i--) {
            for (int j = COLS - 1; j>= 0; j--) {
                if (grid[i][j] == 1)
                    rows[j] = 0;
                else if (j+1 < COLS)
                    rows[j] = rows[j] + rows[j + 1];
                else
                    rows[j] = rows[j] + 0;
            }            
        }
        return rows[0];
    }

    int[] returnZeros(int n) {
        int[] prev = new int[n];
        for (int i =0; i < n; i++) {
            prev[i] = 0;
        }
        return prev;
    }

    void print(int[] rows) {
        for (int i : rows) {
            System.out.print(i);
        }
        System.out.println();
    }
}