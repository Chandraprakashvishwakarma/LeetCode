class Solution {
    public int tribonacci(int n) {
        int t0=0,t1=1,t2=1;
        if(n==0) return t0;
        if(n<=2) return t1;
        int t=0;
        for(int i=3;i<=n;i++){
            t = t0+t1+t2;
            t0=t1;
            t1=t2;
            t2=t;
        }
        return t;
    }
}