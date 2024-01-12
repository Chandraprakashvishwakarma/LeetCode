class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1]==1) return -1;
        int [][] distance = new int[m][n];
        for(int i=0;i<n;i++) Arrays.fill(distance[i],Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1,0,0));
        distance[0][0] = 1;
        while(!q.isEmpty()){
            Pair cur = q.peek();
            int dis = cur.dis,i=cur.i,j=cur.j;
            q.poll();
            if(i == m-1 && j == n-1) return dis;
            // System.out.println(i+"   "+j);
            for(int r=-1;r<=1;r++){
                for(int c=-1;c<=1;c++){
                    if(r==0 && c==0) continue;
                    int nr = i+r,nc = j+c;
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==0){
                        int ndis = dis+1;
                        if(ndis<distance[nr][nc]){
                            distance[nr][nc] = ndis;
                            q.offer(new Pair(ndis,nr,nc));
                            if(nr == m-1 && nc == n-1) return ndis;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

class Pair{
    int dis;
    int i,j;
    public Pair(int dis,int i,int j){
        this.dis = dis;
        this.i =i;
        this.j =j;
    }
}