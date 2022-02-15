class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, i =0;
        while(i <= p2){
           if(nums[i] == 0){
               int temp = nums[i];
               nums[i++] = nums[p0];
               nums[p0++] = temp;
           } else if(nums[i] == 1){
               i++;
           } else {
               int temp2 = nums[p2];
               nums[p2--] = nums[i];
               nums[i] = temp2;
           }
        }
    }
}