class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(words, (String s1, String s2) -> Integer.compare(s1.length(), s2.length()) );
        
        for(int i = 0; i < words.length; i++) {
            if(wordBreak(words[i], set)) {
                res.add(words[i]);
            }
            set.add(words[i]);
        }
        
        return res;
    }
    
    private boolean wordBreak(String word, Set<String> set) {
        if(set.isEmpty()) return false; 
        boolean[] dp = new boolean[word.length() + 1]; 
        dp[0] = true; 
        for(int i = 1; i <= word.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && set.contains(word.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        
        return dp[word.length()];
    }
}