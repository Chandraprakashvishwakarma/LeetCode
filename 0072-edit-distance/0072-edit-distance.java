public class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length(),m=s2.length();
        // int [][] dp = new int[n+1][m+1];
        // for(int [] row :dp) Arrays.fill(row,-1);
        
        int [] pre = new int [m+1];
        int [] cur = new int [m+1];
        
        for(int j=0;j<=m;j++) pre[j] = j;
        
        for(int i=1;i<=n;i++){
            cur[0]=i;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) cur[j] = pre[j-1];
                else cur[j] = 1 + Math.min(pre[j-1],Math.min(cur[j-1],pre[j]));
            }
            pre = cur.clone();
        }  
        return pre[m];
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