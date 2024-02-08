class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length,n = land[0].length;
        boolean [][] vis = new boolean[m][n];
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && land[i][j]==1){
                    bfs(i,j,land,vis,res);
                }
            }
        }
        int [][] ans = new int[res.size()][4];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    
    public void bfs(int i,int j,int[][] land,boolean [][] vis,List<int[]> res){
        Queue<Pair> q = new LinkedList<>();
        int [] row = new int[]{1,0};
        int [] col = new int[]{0,1};
        int tlr=Integer.MAX_VALUE,tlc=Integer.MAX_VALUE,brr=0,brc=0;
        q.offer(new Pair(i,j));
        vis[i][j] = true;
        while(!q.isEmpty()){
            int r = q.peek().i;
            int c = q.peek().j;
            tlr = Math.min(tlr,r);
            tlc = Math.min(tlc,c);
            brr = Math.max(brr,r);
            brc = Math.max(brc,c);
            q.poll();
            for(int k=0;k<2;k++){
                int nr = r+row[k];
                int nc = c+col[k];
                if(nr>=0 && nr<land.length && nc>=0 && nc<land[0].length && land[nr][nc]==1 && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.offer(new Pair(nr,nc));
                }
            }
        }
        res.add(new int[]{tlr,tlc,brr,brc});
    }
}

class Pair{
    int i,j;
    public Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}