class Solution {
    public int minStartValue(int[] nums) {
        int[] pref = new int[nums.length];
        pref[0] = nums[0];
        int minVal = Math.min(Integer.MAX_VALUE, pref[0]);
        
        for(int i = 1; i < nums.length; i++){
            pref[i] = pref[i-1] + nums[i];
            minVal = Math.min(minVal, pref[i]);
        }
        if(minVal >= 1) return 1;
        else return minVal*-1 +1;
    }
}