class Solution {
    public int minCost(int N, int[] price) {
        int p = price.length;
        int [] nPrice = new int[p+2];
        for(int i=0;i<nPrice.length;i++){
            if(i == 0) nPrice[i] = 0;
            else if(i == nPrice.length-1) nPrice[i] = N;
            else nPrice[i] = price[i-1];
        }
        Arrays.sort(nPrice);
        
        int dp [][] = new int[p+1][p+1];
        for(int [] row:dp) Arrays.fill(row,-1);
        return f(1,p,nPrice,dp);
    }
    
    public int f(int i,int j,int [] arr,int [][] dp){
        if(i>j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost = arr[j+1]-arr[i-1]+f(i,k-1,arr,dp)+f(k+1,j,arr,dp);
            mini = Math.min(mini,cost);
        }
        return dp[i][j] = mini;
    }
}