class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        freq={}
        start=0
        temp=0
        maximum =0
        for i in range(len(nums)):
            while freq.get(nums[i],0):
                freq[nums[start]] -=1
                temp -=nums[start]
                start +=1
            temp +=nums[i]
            freq[nums[i]] =1
            maximum = max(maximum,temp)
        return maximum

        