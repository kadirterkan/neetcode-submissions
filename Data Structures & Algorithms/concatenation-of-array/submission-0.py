class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        i = 0
        length = len(nums)

        while (i < length):
            nums.append(nums[i])
            i+=1
        return nums