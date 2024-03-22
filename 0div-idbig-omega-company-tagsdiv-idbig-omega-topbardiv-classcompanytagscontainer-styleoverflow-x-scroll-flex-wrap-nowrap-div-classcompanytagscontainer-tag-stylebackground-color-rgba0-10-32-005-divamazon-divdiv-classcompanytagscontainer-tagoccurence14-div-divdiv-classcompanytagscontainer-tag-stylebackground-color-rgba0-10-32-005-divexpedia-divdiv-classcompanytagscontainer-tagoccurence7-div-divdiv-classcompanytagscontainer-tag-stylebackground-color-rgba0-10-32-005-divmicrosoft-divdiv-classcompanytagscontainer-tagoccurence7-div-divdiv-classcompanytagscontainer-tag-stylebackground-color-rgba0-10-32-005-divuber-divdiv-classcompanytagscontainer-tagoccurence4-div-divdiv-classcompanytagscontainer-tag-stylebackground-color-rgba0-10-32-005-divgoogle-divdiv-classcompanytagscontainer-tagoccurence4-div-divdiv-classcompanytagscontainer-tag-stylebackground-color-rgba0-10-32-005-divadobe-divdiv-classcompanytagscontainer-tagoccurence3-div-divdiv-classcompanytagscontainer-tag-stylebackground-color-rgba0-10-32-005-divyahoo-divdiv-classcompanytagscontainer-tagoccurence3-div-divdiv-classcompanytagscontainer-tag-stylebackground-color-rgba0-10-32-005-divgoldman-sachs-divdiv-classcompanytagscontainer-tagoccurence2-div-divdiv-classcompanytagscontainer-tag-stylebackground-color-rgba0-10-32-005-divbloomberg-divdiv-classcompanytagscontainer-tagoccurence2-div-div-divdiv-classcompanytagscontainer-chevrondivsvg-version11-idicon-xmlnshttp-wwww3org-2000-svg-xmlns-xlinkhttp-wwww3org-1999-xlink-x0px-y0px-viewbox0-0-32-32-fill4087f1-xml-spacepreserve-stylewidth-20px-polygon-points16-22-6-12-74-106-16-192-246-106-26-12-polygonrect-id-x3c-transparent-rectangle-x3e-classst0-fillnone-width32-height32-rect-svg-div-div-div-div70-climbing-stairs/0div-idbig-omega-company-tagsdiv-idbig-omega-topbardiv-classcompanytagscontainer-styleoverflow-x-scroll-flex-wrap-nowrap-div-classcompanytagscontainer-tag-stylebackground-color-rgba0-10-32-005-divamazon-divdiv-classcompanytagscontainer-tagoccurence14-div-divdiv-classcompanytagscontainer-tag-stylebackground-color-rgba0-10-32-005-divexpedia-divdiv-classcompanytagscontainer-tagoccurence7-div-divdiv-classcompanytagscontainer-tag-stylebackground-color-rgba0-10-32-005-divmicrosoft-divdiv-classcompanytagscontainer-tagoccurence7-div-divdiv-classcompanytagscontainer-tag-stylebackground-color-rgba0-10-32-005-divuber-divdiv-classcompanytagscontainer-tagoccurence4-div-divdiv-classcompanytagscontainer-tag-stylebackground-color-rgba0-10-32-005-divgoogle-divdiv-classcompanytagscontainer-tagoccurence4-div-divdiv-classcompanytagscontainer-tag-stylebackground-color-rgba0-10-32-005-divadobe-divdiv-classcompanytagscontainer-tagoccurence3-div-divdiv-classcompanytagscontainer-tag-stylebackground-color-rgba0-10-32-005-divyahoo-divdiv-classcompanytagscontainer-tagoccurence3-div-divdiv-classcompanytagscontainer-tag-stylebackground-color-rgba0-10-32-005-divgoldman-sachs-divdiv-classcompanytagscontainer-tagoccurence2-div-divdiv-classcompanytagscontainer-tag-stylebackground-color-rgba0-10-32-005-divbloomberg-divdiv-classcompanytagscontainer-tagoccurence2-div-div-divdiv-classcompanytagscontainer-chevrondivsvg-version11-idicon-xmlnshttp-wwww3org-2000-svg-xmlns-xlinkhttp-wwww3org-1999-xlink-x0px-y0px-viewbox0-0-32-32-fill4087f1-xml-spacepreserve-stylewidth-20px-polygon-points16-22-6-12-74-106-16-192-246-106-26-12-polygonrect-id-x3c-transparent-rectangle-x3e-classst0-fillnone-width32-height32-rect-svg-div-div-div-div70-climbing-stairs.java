class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        if(n<3) return n;
        int res = a+b;
        for(int i=2;i<n;i++){
            res = a+b;
            a = b;
            b = res;
        }
        return res;
    }
}