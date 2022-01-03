class Solution {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int max = 0, left = 0, right = 0, temp = 0;
        for(int i= chars.length - 1; i >=0; i--) {
            int v = chars[i];
            if(v > max){
                temp = i;
            } else if(v < max){
                temp = temp;
                right = temp;                
                left = i;
            }
            max = Math.max(max, v);            
        }
        if(left < right) {
            swap(chars, left, right);
            num = Integer.valueOf(new String(chars));            
        } 
        return num;
    }
    
    private void swap(char[] chars, int i , int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}