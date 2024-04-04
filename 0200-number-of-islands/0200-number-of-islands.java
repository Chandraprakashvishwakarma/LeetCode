class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean [][] vis = new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int i,int j,char [][] grid,boolean [][] vis){
        vis[i][j] = true;
        int [] rowAdd = new int []{0,1,0,-1};
        int [] colAdd = new int []{1,0,-1,0};
        
        for(int k=0;k<4;k++){
            int nr = i+rowAdd[k];
            int nc = j+colAdd[k];
            
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc] == '1'){
                dfs(nr,nc,grid,vis);
            }
        }
    }
}