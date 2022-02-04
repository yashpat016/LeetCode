class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] base = new int[length];
        for(int[] update: updates){
            int startIdx = update[0];
            int endIdx = update[1];
            int inc = update[2];
            for(int i = startIdx; i < length && i <= endIdx; i++){
                base[i] += inc;
            }
        }
        return base;
    }
}