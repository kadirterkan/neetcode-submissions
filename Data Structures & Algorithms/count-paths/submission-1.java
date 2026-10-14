class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = returnZeros(n);
        prev[n-1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j + 1 < n) 
                    prev[j] = prev[j + 1] + prev[j];
                else
                    prev[j] = prev[j];
            }
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
