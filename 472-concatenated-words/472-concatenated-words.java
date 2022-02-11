class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> wordsSet = new HashSet<>();
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        for(int i = 0; i < words.length; i++) {
            if(wordBreak(words[i], wordsSet)) {
                res.add(words[i]);
            }
            wordsSet.add(words[i]);
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