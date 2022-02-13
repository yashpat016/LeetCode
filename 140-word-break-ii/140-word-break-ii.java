class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentences = new ArrayList();
        makeWordBreaks(s, wordDict, sentences, "", 0);
        return sentences;
    }
    
    private static void makeWordBreaks(String s, List<String> wordDict, List<String> sentences, String current, int index) {
        if (index >= s.length()) {
            sentences.add(current.trim());
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            if (wordDict.contains(s.substring(index, i+1))) {
                makeWordBreaks(s, wordDict, sentences, current + s.substring(index, i+1) + " ", i+1);
            }
        }
    }
}