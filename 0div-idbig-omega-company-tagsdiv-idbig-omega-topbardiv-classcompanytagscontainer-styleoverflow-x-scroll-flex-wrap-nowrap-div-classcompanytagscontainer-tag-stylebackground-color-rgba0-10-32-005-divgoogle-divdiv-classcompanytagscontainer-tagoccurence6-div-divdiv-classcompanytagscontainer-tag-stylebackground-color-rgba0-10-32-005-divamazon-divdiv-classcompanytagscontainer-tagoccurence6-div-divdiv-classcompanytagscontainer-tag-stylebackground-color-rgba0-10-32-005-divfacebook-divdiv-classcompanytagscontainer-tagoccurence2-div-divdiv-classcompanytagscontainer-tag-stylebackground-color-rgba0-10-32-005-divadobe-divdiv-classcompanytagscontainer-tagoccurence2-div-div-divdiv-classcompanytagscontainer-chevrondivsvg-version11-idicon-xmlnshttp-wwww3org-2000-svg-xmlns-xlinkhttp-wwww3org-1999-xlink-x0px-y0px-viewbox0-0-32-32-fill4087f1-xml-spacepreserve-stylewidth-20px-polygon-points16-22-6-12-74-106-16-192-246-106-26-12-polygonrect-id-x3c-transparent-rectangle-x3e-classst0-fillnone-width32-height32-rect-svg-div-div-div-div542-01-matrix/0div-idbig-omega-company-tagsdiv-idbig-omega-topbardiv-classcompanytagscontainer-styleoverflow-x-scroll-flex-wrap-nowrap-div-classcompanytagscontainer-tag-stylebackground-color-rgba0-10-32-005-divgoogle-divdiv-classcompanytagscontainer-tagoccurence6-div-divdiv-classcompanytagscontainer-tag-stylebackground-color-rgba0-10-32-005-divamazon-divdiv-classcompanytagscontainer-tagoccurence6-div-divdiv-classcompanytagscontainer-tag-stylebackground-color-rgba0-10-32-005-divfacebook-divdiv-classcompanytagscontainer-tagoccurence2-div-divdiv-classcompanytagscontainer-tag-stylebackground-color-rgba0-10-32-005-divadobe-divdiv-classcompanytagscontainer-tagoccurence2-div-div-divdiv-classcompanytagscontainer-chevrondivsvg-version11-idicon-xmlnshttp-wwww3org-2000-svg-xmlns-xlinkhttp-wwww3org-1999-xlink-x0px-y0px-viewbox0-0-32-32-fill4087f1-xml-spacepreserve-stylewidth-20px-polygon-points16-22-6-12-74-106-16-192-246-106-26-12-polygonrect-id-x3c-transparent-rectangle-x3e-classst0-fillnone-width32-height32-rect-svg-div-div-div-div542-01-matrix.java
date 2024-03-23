class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length,n = mat[0].length;
        int [][] dist = new int[m][n];
        boolean [][] vis = new boolean[m][n];
        Queue<Trio> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(mat[i][j] == 0){
                    q.offer(new Trio(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        
        int [] row = new int[]{1,0,-1,0};
        int [] col = new int[]{0,1,0,-1};
        
        while(!q.isEmpty()){
            Trio node = q.poll();
            int i=node.i,j=node.j,d=node.d;
            dist[i][j] = d;
            for(int k=0;k<4;k++){
                int r = i+row[k], c=j+col[k];
                if(r<m && c<n && r>=0 && c>=0 && !vis[r][c]){
                    if(mat[r][c]!=0) {
                        q.offer(new Trio(r,c,d+1));
                    }
                    else q.offer(new Trio(r,c,0));
                    vis[r][c] = true;
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