class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            count[i] = count(i);
        }
        return count;
    }

    int count(int n) {
        int count = 0;
        while (n > 0) {
            if ((n&1) == 1) {
                count+=1;
            }
            n = n >> 1;
        }
        return count;
    }
}
