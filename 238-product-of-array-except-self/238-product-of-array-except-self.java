class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];
        
        leftProd[0] = 1;
        int prod = 1;
        for(int i = 1; i < nums.length; i++){
            leftProd[i] = prod * nums[i-1];
            prod = leftProd[i];
        }
        prod = 1;
        rightProd[nums.length-1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            rightProd[i] = prod * nums[i+1];
            prod = rightProd[i];
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = leftProd[i] * rightProd[i];
        }
        return res;
    }
}