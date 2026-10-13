class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        int temp;

        for (int n: nums) {
            temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
