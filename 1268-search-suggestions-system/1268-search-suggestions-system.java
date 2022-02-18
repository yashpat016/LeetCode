class Solution {
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int start = 0, searchStart = 0, n = products.length;
        String prefix = new String();
        for(char c: searchWord.toCharArray()){
            prefix += c;
            start = ll(products, searchStart, prefix);
            result.add(new ArrayList<>());
            for(int i = start; i < Math.min(start + 3, n); i++){
                if(products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix)){
                    break;
                }
                result.get(result.size() - 1).add(products[i]);
            }
            searchStart = start;
        }
        return result;
    }
    int ll(String[] products, int start, String word){
        int i = start, j = products.length, mid;
        while(i < j){
            mid = (i + j) /2;
            if(products[mid].compareTo(word) >= 0){
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}