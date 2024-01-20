class Solution {
    public int minimumEffortPath(int[][] arr) {
        int m = arr.length,n = arr[0].length;
        int [][] distance = new int [m][n];
        int [] rowAdd = new int[]{1,0,-1,0};
        int [] colAdd = new int []{0,1,0,-1};
        for(int [] row:distance) Arrays.fill(row,Integer.MAX_VALUE);
        distance[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->x.dis-y.dis);
        pq.offer(new Tuple(0,0,0));
        while(!pq.isEmpty()){
            Tuple temp = pq.poll();
            int dis = temp.dis;
            int i = temp.i;
            int j = temp.j;
            if(i == m-1 && j == n-1) return dis;
            for(int k=0;k<4;k++){
                int nr = i+rowAdd[k];
                int nc = j+colAdd[k];
                if(nr>=0 && nr<m && nc>=0 && nc<n ){
                    int d = Math.max(Math.abs(arr[nr][nc]-arr[i][j]),dis);
                    if(d<distance[nr][nc]){
                        distance[nr][nc] = d;
                        pq.offer(new Tuple(d,nr,nc));
                    }
                }
            }
        }
        return -1;
    }
}


class Tuple{
    int dis,i,j;
    public Tuple(int dis,int i,int j){
        this.dis=dis;
        this.i=i;
        this.j=j;
    }
}