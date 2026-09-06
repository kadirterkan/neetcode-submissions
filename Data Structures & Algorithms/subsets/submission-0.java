class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subset(0, subset, result, nums);
        
        return result;
    }

    void subset(int i, List<Integer> subset, List<List<Integer>> res, int[] nums) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        subset(i + 1, subset, res, nums);

        subset.removeIf(val -> val == nums[i]);
        subset(i + 1, subset, res, nums);
    }
}
