class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i:arr) sum+=i;
        if(n<2 || sum%2!=0) return false;
        int [][] dp = new int[n][sum/2+1];
        for(int [] row:dp) Arrays.fill(row,-1);
        return helper(arr,n-1,sum/2,dp)==1;
    }
    
    public int helper(int [] arr,int i,int t,int [][] dp){
        if(t == 0) return 1;
        if(t<0) return 0;
        if(i == 0 ){
            return arr[0] == t?1:0;
        }
        if(dp[i][t]!=-1) return dp[i][t];
        
        int not_take= helper(arr,i-1,t,dp);
        int take =  helper(arr,i-1,t-arr[i],dp);
        
        return dp[i][t]= Math.max(take,not_take);
    }
}