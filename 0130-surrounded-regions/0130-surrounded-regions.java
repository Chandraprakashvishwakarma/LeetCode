class Solution {
    int row[] = {0,1,0,-1};
    int col[] = {1,0,-1,0};
    public void solve(char[][] board) {
        int n = board.length,m = board[0].length;
        boolean [][] vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            if(!vis[i][0] && board[i][0] == 'O') dfs(i,0,vis,board);
            if(!vis[i][m-1] && board[i][m-1] == 'O') dfs(i,m-1,vis,board);
        }
        for(int j=0;j<m;j++){
            if(!vis[0][j] && board[0][j] == 'O') dfs(0,j,vis,board);
            if(!vis[n-1][j] && board[n-1][j] == 'O') dfs(n-1,j,vis,board);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && !vis[i][j] ) board[i][j] = 'X';
            }
        }
    }
    
    public void dfs(int i,int j,boolean [][] vis,char [][] board){
        vis[i][j] = true;
        for(int k = 0;k<4;k++){
            int r = i+row[k],c = j+col[k];
            if(r>=0 && r<vis.length && c>=0 && c<vis[0].length 
               && !vis[r][c] && board[r][c] == 'O'){
                dfs(r,c,vis,board);
            }
        }
    }
}