class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Trio> q = new LinkedList<>();
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new Trio(i,j,0));
                }
                if(grid[i][j]==1) count++;
            }
        }
        
        int [] rowAdd = new int []{0,-1,0,1};
        int [] colAdd = new int []{1,0,-1,0};
        
        int max = 0;
        while(!q.isEmpty()){
            Trio rottonOrange = q.poll();
            int i= rottonOrange.i, j = rottonOrange.j, t = rottonOrange.t; 
            max = Math.max(max,t);
            for(int k=0;k<4;k++){
                int nr = i+rowAdd[k];
                int nc = j+colAdd[k];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                    grid[nr][nc] = 2;
                    q.add(new Trio(nr,nc,t+1));
                    count--;
                }
            }
        }

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