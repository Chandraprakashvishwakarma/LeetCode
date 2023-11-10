class Solution {
    public int coinChange(int[] ar, int t) {
        int n = ar.length;
        int [][] dp = new int[n][t+1];
        int res = helper(n-1,t,ar,dp);
        return res>=Integer.MAX_VALUE-10000?-1:res;
    }
    public int helper(int i,int t,int [] ar,int [][] dp ){
        
        if(i == 0){
            return t%ar[i]==0?t/ar[i]:Integer.MAX_VALUE-10000;
        }
        
        if(dp[i][t] !=0) return dp[i][t];
        
        int not_take = helper(i-1,t,ar,dp);
        int take = Integer.MAX_VALUE;
        if(ar[i]<=t) take = 1+helper(i,t-ar[i],ar,dp);
        
        return dp[i][t] = Math.min(take,not_take);
    }
}