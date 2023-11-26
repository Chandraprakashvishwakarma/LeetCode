class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int max = 0;
        Queue<Trio> q = new LinkedList<>();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2) {
                    q.add(new Trio(i,j,0));
                    vis[i][j] =true;
                }
                if(grid[i][j] == 1) count++;
            }
        }
        
        int delrow[] = {0,1,0,-1};
        int delcol[] = {1,0,-1,0};
        
        while(!q.isEmpty()){
            Trio temp = q.poll();
            int i = temp.i,j=temp.j,t=temp.t;
            
            max = Math.max(max,t);
            for(int k =0;k<delrow.length;k++){
                int nrow = i+delrow[k],ncol = j+delcol[k];
                if(nrow<n && nrow>=0 && ncol>=0 && ncol<m 
                   && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                    q.add(new Trio(nrow,ncol,t+1));
                    vis[nrow][ncol] = true;
                    count--;
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(grid[i][j] == 1 && !vis[i][j]) return -1;
        //     }
        // }
        if(count != 0) return -1;
        return max;
    }
}
class Trio{
    int i,j,t=0;
    public Trio(int i,int j,int t){
        this.i = i;
        this.j = j;
        this.t = t;
    }
}