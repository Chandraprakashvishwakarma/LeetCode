class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i:arr) sum+=i;
        if(n<2 || sum%2!=0) return false;
        int [][] dp = new int[n][sum/2+1];
        // for(int [] row:dp) Arrays.fill(row,-1);
        // return helper(arr,n-1,sum/2,dp)==1;
        
        
        //Tabulation
        for(int i = 0;i<n;i++) dp[i][0] = 1;
        for(int j = 0;j<=sum/2;j++) dp[0][j] = arr[0] == j?1:0;
        
        for(int i=1;i<n;i++){
            for(int t=1;t<=sum/2;t++){
                int not_take= dp[i-1][t];
                int take = Integer.MIN_VALUE;
                    if(t-arr[i]>=0) take = dp[i-1][t-arr[i]];

                dp[i][t]= Math.max(take,not_take);
            }
        }
        return dp[n-1][sum/2]==1;
    }
    
    // Memoization
//     public int helper(int [] arr,int i,int t,int [][] dp){
//         if(t == 0) return 1;
//         if(i == 0 ){
//             return arr[0] == t?1:0;
//         }
//         if(dp[i][t]!=-1) return dp[i][t];
        
//         int not_take= helper(arr,i-1,t,dp);
//         int take = Integer.MIN_VALUE;
//             if(t-arr[i]>=0) take = helper(arr,i-1,t-arr[i],dp);
        
//         return dp[i][t]= Math.max(take,not_take);
//     }
}