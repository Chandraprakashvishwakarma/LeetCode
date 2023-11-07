class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n<2) return n;
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        int i=0,j=1;
        while(j<n){
            if(i==j){
                j++;i=0;
            }
            else {
                if(nums[i]<nums[j]) dp[j] = Math.max(dp[j],dp[i]+1);
                i++;
            }
        }
        int res = 1;
        for(int val:dp) res = Math.max(res,val);
        return res;
        
//         int n = nums.length;
//         int dp[][] = new int[n][n+1];
//         return helper(nums,0,-1,dp);
//     }
    
//     public int helper(int [] nums,int ind,int pre_ind,int [][] dp){
//         if(ind == nums.length) return 0;
        
//         if(dp[ind][pre_ind+1] != 0) return dp[ind][pre_ind+1];
        
//         int len = helper(nums,ind+1,pre_ind,dp);
//         if(pre_ind == -1 || nums[ind]>nums[pre_ind]){
//             len = Math.max(len,1+helper(nums,ind+1,ind,dp));
//         }
//         return dp[ind][pre_ind+1] = len;
    }
}