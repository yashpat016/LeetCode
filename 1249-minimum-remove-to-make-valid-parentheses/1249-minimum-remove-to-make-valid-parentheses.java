class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> faultPar = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0 ; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    faultPar.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()){
            faultPar.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < s.length(); i++){
            if(!faultPar.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}