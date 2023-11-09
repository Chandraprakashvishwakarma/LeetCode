public class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length(),m=s2.length();
        int [][] dp = new int[n+1][m+1];
        // for(int [] row :dp) Arrays.fill(row,-1);
        
        for(int i=0;i<=n;i++) dp[i][0] = i;
        for(int j=0;j<=m;j++) dp[0][j] = j;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
            }
        }  
        return dp[n][m];
        // return editDist(s1,s2,n,m,dp);
    }
//     public int editDist(String s1,String s2,int i,int j,int [][] dp){
        
//         if(i==0) return j;
//         else if(j==0) return i;
        
//         if(dp[i][j]!=-1) return dp[i][j];
        
//         if(s1.charAt(i-1)==s2.charAt(j-1)) return dp[i][j] = 0 + editDist(s1,s2,i-1,j-1,dp);
//         else {
//             return dp[i][j] = 1 + Math.min(editDist(s1,s2,i-1,j-1,dp),Math.min(editDist(s1,s2,i,j-1,dp),editDist(s1,s2,i-1,j,dp)));
//         }
//     }
}