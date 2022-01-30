class Solution {
    public int uniqueLetterString(String s) {
       int result = 0;
        int count = 0;
        int[] lastSeen = new int[26];
        int[] lastCount = new int[26];
        Arrays.fill(lastSeen, -1);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'A';
            int currCnt = i - lastSeen[idx];
            count = count - lastCount[idx] + currCnt;
            lastSeen[idx] = i;
            lastCount[idx] = currCnt;
            result += count;
        }
        
        return result;
    }
}