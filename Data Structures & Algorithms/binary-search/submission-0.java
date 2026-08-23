class Solution {
    public int search(int[] nums, int target) {
        if (nums != null && nums.length == 0) return -1;
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    int binarySearch(int[] nums, int lo, int hi, int target) {
        if (hi < lo) {
            return -1;
        }
        int midd = (lo + hi) / 2;
        if (nums[midd] == target) {
            return midd;
        } else if (nums[midd] < target) {
            return binarySearch(nums, midd + 1, hi, target);
        } else {
            return binarySearch(nums, lo, midd - 1, target);
        }
    }
}
