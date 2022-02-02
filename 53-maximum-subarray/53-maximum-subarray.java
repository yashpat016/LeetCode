class Solution {
    public int maxSubArray(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
     
        for(int i = 1; i < nums.length; i++){
            int value = nums[i];
            
            currentSubarray = Math.max(value, currentSubarray + value);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        return maxSubarray;
    } 
    
}