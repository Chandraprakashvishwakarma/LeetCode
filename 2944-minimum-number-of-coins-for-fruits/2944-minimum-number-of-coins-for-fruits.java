class Solution {
    public int minimumCoins(int[] a) {
        int [] dp = new int[a.length+1];
        return helper(a,0,dp);
    }
    
    public int helper(int [] a, int i,int [] dp){
        if(i>=a.length) return 0;
        if(dp[i]!=0) return dp[i];
        int res = Integer.MAX_VALUE;
        for(int j=i+1;j<=2*i+2;j++){
            res = Math.min(res,helper(a,j,dp));
        }
        
        return dp[i] = a[i]+res;
    }
}