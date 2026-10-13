class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = returnZeros(n);

        for (int i = m - 1; i >= 0; i--) {
            int[] curRow = returnZeros(n);
            curRow[n - 1] = 1;
            for (int j = n - 2; j >= 0; j--) {
                curRow[j] = curRow[j + 1] + prev[j];
            }
            prev = curRow;
        }
        return prev[0];
    }

    int[] returnZeros(int n) {
        int[] prev = new int[n];
        for (int i =0; i < n; i++) {
            prev[i] = 0;
        }
        return prev;
    }
}
