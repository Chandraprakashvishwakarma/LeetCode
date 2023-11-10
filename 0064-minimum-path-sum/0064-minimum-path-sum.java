class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        int dp [][] = new int[m+1][n+1];
        // return helper(grid,m,n,dp);
        
        //Tabular
        for(int i=0;i<=m;i++) dp[i][0] = Integer.MAX_VALUE;
        for(int j=0;j<=n;j++) dp[0][j] = Integer.MAX_VALUE;
        
        for(int i=1 ; i<=m ; i++){
            for(int j=1;j<=n;j++){
                if(i == 1 && j == 1) dp[i][j] = grid[0][0];
                else dp[i][j] = grid[i-1][j-1]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[m][n];
        
    }
    // Memoization
//     public int helper(int [][] grid,int i,int j,int [][] dp){
//         if(i == 1 && j == 1) return grid[0][0];
//         if(i == 0 || j == 0) return Integer.MAX_VALUE;
        
//         if(dp[i][j] != 0) return dp[i][j];
        
//         return dp[i][j] = grid[i-1][j-1]+Math.min(helper(grid,i-1,j,dp),helper(grid,i,j-1,dp));
//     }
}