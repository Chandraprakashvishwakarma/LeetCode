class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        return helper(nums,0,-1,dp);
    }
    
    public int helper(int [] nums,int ind,int pre_ind,int [][] dp){
        if(ind == nums.length) return 0;
        
        if(dp[ind][pre_ind+1] != 0) return dp[ind][pre_ind+1];
        
        int len = helper(nums,ind+1,pre_ind,dp);
        if(pre_ind == -1 || nums[ind]>nums[pre_ind]){
            len = Math.max(len,1+helper(nums,ind+1,ind,dp));
        }
        return dp[ind][pre_ind+1] = len;
    }
}