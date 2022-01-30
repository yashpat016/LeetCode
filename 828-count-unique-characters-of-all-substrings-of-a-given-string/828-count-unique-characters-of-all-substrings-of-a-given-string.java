class Solution {
    public int uniqueLetterString(String s) {
        
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.putIfAbsent(ch, -1);
            left[i] = map.get(ch);
            map.put(ch, i);
        }
        map.clear();
        
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            map.putIfAbsent(ch, s.length());
            right[i] = map.get(ch);
            map.put(ch, i);
        }
        
        int res = 0;
        
        for(int i = 0; i < s.length(); i++){
            int numOfLeft = i - left[i];
            int numOfRight = right[i] - i;
            res += numOfLeft * numOfRight;
        }
        return res;
    }
}