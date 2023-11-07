class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        // int [][] dp = new int[n1+1][n2+1];
        int [] prev = new int[n2+1];
        int [] cur = new int[n2+1];
        // for(int []row:dp) Arrays.fill(row,-1);
        // return LCS(s1,s2,n1,n2,dp);
        
        //Tabulation
        for(int j=0;j<n2;j++) prev[j]=0;
            
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                int lcs = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1)){  //match condition
                    lcs = 1 + prev[j-1];
                }
                else { //not match
                    lcs = 0 + Math.max(cur[j-1],prev[j]);
                }
                cur[j] = lcs;
            }
            prev = cur.clone();
        }
        
        return prev[n2];
    }
    
    // Memoization 
//     public int LCS(String s1,String s2,int i,int j,int [][] dp){
//         if(i==0 || j==0) return 0;
        
//         if(dp[i][j]!=-1) return dp[i][j];
        
//         int lcs=0;
//         if(s1.charAt(i-1) == s2.charAt(j-1)){  //match condition
//             lcs = 1 + LCS(s1,s2,i-1,j-1,dp);
//         }
//         else {
//             lcs = 0 + Math.max(LCS(s1,s2,i,j-1,dp),LCS(s1,s2,i-1,j,dp));
//         }
        
//         return dp[i][j] = lcs;
//     }
}