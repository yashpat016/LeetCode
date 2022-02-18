class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (!curChildren.containsKey(ch)) {
                cur = new TrieNode(ch);
                curChildren.put(ch, cur);
            }
            else {
                cur = curChildren.get(ch);
            }
            curChildren = cur.children;
            
            if (i == chs.length - 1)
                cur.hasWord = true;
        }
    }
    
    public boolean search(String word) {  
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        
        return DFS(chs, 0, cur);
    }
    
    public boolean DFS (char[] chs, int k, TrieNode cur) {
        if (k == chs.length) {
            return cur.hasWord;
        }
        
        char ch = chs[k];
                        
        if (ch != '.') {
            if (cur.children.containsKey(ch)) {
                return DFS (chs, k + 1, cur.children.get(ch));
            }
            else 
                return false;
        }
        else {
            for (TrieNode child:cur.children.values()) {
                if (DFS(chs, k + 1, child) == true)
                    return true;
            }
            return false;
        }
        
    }
}

class TrieNode {
    char c;
    boolean hasWord;
    HashMap<Character, TrieNode> children = new HashMap<>();
    
    public TrieNode() {
        
    }
    
    public TrieNode(char c) {
        this.c = c;
    }
}