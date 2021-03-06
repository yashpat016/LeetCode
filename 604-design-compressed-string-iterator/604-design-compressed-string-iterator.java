class StringIterator {
    String res;
    int ptr = 0, num = 0;
    char ch = ' ';
    
    public StringIterator(String compressedString) {
        res = compressedString;    
    }
    
    public char next() {
        if(!hasNext()){
            System.out.println("blank");
            return ' ';
            
        }
        if(num == 0){
            ch = res.charAt(ptr++);
            while(ptr < res.length() && Character.isDigit(res.charAt(ptr))){
                num = num * 10 + res.charAt(ptr++) - '0';
                System.out.println(num);
            }
        }
        num--;
        System.out.println(num);
        System.out.println(ch);
        return ch;
    }
    
    public boolean hasNext() {
        return ptr != res.length() || num != 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */