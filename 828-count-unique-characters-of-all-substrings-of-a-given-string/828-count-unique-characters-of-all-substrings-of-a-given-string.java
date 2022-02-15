class Solution {
    public int uniqueLetterString(String s) {
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            map.putIfAbsent(c, -1);
            left[i] = map.get(c);
            map.put(c, i);
        }
        map.clear();
        for(int i = s.length() - 1; i>=0; i--){
            char c = s.charAt(i);
            map.putIfAbsent(c, s.length());
            right[i] = map.get(c);
            map.put(c, i);
        }
        
        int res = 0;
        for(int i =0; i< s.length(); i++){
            int numLeft = i - left[i];
            int numRight = right[i] - i;
            res += numLeft * numRight;
        }
        return res;
    }
}