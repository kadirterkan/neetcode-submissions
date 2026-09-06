class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subset(0, subset, result, nums, target);
        
        return result;
    }

    void subset(int i, List<Integer> subset, List<List<Integer>> res, int[] nums, int target) {
        int sum = subset.stream().mapToInt(Integer::intValue).sum();
        if (sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        } 
        if (i>= nums.length || sum > target) {
            return;
        }
        subset.add(nums[i]);
        subset(i, subset, res, nums, target);

        subset.removeLast(); 
        subset(i + 1, subset, res, nums, target);
    }
}
