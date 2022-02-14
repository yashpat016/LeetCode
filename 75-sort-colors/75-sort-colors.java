class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int c = 0;
        for(int i = 0; i< nums.length; i++){
            c = count.getOrDefault(nums[i], 0) + 1;
            count.put(nums[i], c);
        }
        int i=0;
        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            for(int j=0;j<entry.getValue();j++)
            {
                nums[i]=entry.getKey();
                i++;
            }
        }
    }
}