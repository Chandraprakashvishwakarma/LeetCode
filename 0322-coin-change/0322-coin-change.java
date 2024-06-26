class Solution {
    public int coinChange(int[] ar, int target) {
        int n = ar.length;
        int [][] dp = new int[n][target+1];
        
        //Tabulation
        for(int t=0;t<=target;t++){
            if(t%ar[0]==0) dp[0][t] = t/ar[0];
            else dp[0][t] =Integer.MAX_VALUE-1;
        } 
        
        for(int i=1;i<n;i++){
            for(int t=1;t<=target;t++){
                int not_take = dp[i-1][t];
                int take = Integer.MAX_VALUE-1;
                if(ar[i]<=t) take = 1 +dp[i][t-ar[i]];

                dp[i][t] = Math.min(take,not_take);
            }
        }
    
        return dp[n-1][target]>=Integer.MAX_VALUE-1?-1:dp[n-1][target];
        // int res = helper(n-1,t,ar,dp);
        // return res>=Integer.MAX_VALUE-10000?-1:res;
    }
    
    // Memoization
//     public int helper(int i,int t,int [] ar,int [][] dp ){
        
//         if(i == 0){
//             return t%ar[i]==0?t/ar[i]:Integer.MAX_VALUE-10000;
//         }
        
//         if(dp[i][t] !=0) return dp[i][t];
        
//         int not_take = helper(i-1,t,ar,dp);
//         int take = Integer.MAX_VALUE;
//         if(ar[i]<=t) take = 1+helper(i,t-ar[i],ar,dp);
        
//         return dp[i][t] = Math.min(take,not_take);
//     }
}