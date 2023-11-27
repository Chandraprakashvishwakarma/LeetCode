class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length,m = mat[0].length;
        int [][] dist = new int[n][m];
        boolean vis[][] = new boolean[n][m];
        Queue<Trio> q = new LinkedList<>();
        
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.offer(new Trio(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        
        int [] nrow = {0,1,0,-1};
        int [] ncol = {1,0,-1,0};
        
        while(!q.isEmpty()){
            Trio node = q.poll();
            int i = node.i,j=node.j,d = node.d;
            dist[i][j] = d;
            for(int k=0;k<4;k++){
                int r = i+nrow[k],c = j+ncol[k];
                if(r>=0 && r<n && c>=0 && c<m){
                    if(!vis[r][c]){
                        if(mat[r][c]!=0){
                            q.offer(new Trio(r,c,d+1));
                        }
                        else q.offer(new Trio(r,c,d));
                        vis[r][c] = true;
                    }
                }
            }
        }
        
        return dist;
        
    }
}

class Trio{
    int i,j,d;
    public Trio(int i,int j,int d){
        this.i = i;
        this.j = j;
        this.d = d;
    }
}