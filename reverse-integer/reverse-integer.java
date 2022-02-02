class Solution {
    public int reverse(int x) {
        boolean negative = false;
        long rev = 0;
        if (x < 0){
            negative = true;
            x *= -1;
        }
        while (x > 0){
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }
        if (rev > Integer.MAX_VALUE) {
            return 0;
        }
        return negative ? (int)(-1 * rev) : (int)rev;
     
    }
}