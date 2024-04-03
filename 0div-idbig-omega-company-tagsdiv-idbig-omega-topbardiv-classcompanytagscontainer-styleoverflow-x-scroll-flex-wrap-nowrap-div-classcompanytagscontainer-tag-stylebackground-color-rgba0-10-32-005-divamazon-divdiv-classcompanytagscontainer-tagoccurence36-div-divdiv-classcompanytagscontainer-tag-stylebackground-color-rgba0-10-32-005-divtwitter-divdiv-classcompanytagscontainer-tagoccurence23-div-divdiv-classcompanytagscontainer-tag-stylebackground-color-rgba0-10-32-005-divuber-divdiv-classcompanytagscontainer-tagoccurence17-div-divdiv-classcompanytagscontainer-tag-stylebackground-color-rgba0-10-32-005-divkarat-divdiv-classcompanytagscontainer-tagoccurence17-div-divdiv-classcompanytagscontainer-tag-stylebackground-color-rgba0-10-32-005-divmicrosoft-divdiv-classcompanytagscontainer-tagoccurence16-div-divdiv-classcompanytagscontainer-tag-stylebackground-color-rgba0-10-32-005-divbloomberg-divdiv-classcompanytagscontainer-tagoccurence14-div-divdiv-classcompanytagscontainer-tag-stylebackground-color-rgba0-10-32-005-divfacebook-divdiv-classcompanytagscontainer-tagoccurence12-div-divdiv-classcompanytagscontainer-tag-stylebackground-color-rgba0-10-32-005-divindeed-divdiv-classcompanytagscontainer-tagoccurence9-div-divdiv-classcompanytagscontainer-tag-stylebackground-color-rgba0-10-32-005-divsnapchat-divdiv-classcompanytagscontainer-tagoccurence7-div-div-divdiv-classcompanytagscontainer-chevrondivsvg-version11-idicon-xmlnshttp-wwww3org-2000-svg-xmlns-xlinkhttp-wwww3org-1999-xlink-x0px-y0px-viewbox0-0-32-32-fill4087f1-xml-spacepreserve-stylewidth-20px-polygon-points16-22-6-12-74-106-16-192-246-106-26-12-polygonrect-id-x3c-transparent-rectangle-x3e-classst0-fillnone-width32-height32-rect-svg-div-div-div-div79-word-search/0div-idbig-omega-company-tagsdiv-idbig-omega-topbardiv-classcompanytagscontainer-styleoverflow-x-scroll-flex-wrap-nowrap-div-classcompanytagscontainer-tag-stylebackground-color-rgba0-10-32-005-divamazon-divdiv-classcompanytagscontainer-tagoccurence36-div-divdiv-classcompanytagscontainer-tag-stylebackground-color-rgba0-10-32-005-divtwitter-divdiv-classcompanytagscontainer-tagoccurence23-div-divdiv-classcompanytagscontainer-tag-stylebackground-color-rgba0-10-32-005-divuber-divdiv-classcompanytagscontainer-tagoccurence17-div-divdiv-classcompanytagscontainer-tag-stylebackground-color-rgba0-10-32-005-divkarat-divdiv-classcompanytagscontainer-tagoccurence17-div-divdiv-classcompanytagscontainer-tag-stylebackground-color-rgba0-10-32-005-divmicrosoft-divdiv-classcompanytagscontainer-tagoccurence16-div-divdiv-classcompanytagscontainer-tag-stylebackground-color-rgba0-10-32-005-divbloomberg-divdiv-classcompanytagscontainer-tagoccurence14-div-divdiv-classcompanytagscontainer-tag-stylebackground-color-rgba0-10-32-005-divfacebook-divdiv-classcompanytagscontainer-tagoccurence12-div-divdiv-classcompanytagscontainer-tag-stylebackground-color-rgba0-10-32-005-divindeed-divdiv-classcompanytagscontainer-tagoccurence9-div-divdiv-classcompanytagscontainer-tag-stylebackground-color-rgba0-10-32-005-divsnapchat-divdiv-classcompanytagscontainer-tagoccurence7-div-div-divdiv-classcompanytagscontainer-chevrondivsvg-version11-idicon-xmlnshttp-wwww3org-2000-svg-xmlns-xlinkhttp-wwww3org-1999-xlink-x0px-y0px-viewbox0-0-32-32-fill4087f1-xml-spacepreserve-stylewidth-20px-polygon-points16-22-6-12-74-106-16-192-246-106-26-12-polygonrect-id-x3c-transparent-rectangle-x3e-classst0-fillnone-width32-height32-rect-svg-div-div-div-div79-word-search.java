class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,i,j,vis,0)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char [][] board,String word,int i,int j,boolean [][] vis,int idx){
        if(idx==word.length()) return true;
        if(i<0 || i==board.length || j<0 || j==board[0].length || vis[i][j]) return false;
        if(board[i][j] != word.charAt(idx)) return false;
        vis[i][j] = true;
        boolean flag = dfs(board,word,i+1,j,vis,idx+1) || 
            dfs(board,word,i-1,j,vis,idx+1) || 
            dfs(board,word,i,j+1,vis,idx+1) || 
            dfs(board,word,i,j-1,vis,idx+1);
        
        vis[i][j] = false;
        return flag;
    }
}