class Solution {
    int row[] = {0,1,0,-1};
    int col[] = {1,0,-1,0};
    public void solve(char[][] board) {
        int n = board.length,m = board[0].length;
        boolean [][] npos = new boolean[n][m];
        boolean [][] vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j == 0 || i == n-1 || j == m-1) && board[i][j] == 'O' && !vis[i][j]){
                    dfs(i,j,vis,board,npos);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && !npos[i][j] ) board[i][j] = 'X';
            }
        }
    }
    
    public void dfs(int i,int j,boolean [][] vis,char [][] board,boolean [][] npos){
        vis[i][j] = true;
        npos[i][j] = true;
        for(int k = 0;k<4;k++){
            int r = i+row[k],c = j+col[k];
            if(r>=0 && r<npos.length && c>=0 && c<npos[0].length 
               && !vis[r][c] && board[r][c] == 'O'){
                dfs(r,c,vis,board,npos);
            }
        }
    }
}