class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        int [][] dp = new int[n1][n2];
        for(int []row:dp) Arrays.fill(row,-1);
        return LCS(s1,s2,s1.length()-1,s2.length()-1,dp);
    }
    
    public int LCS(String s1,String s2,int ind1,int ind2,int [][] dp){
        if(ind1<0 || ind2<0) return 0;
        
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        
        int lcs=0;
        if(s1.charAt(ind1) == s2.charAt(ind2)){  //match condition
            lcs = 1 + LCS(s1,s2,ind1-1,ind2-1,dp);
        }
        else {
            lcs = 0 + Math.max(LCS(s1,s2,ind1,ind2-1,dp),LCS(s1,s2,ind1-1,ind2,dp));
        }
        
        return dp[ind1][ind2] = lcs;
    }
}