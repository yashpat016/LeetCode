class Solution {
    public int kthFactor(int n, int k) {
        int count = 0;
        int i;
        for(i = 1; i <= n/2; i++){
            if(n % i == 0){
                count++;
            }
            if(count == k){
                return i;
            }
        }
        for(i = n/2 + 1; i <= n; i++){
            if(n%i == 0){
                count++;
            }
            if(count == k){
                return i;
            }
        }
        return -1;
    }
}