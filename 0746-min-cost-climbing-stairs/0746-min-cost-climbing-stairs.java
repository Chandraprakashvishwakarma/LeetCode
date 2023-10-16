class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length+1];
        return Math.min(f(cost,0,dp),f(cost,1,dp));
    }
    
    public int f(int[] cost, int i,int [] dp){
        if(i>=cost.length) return 0;
        if(dp[i]!=0) return dp[i];
        return dp[i] = cost[i]+Math.min(f(cost,i+1,dp),f(cost,i+2,dp));
    }
}