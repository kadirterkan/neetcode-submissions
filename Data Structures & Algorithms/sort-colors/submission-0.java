class Solution {
    public void sortColors(int[] nums) {
        if (nums == null && nums.length == 0) return;

        int[] colours = new int[3];

        for (int i = 0; i < nums.length; i++) {
            colours[nums[i]]+=1;
        }
        int k = 0;
        for (int i = 0; i < colours.length; i++) {
            for (int j = 0; j < colours[i];j++) {
                nums[k] = i;
                k++;
            }
        }
    }
}