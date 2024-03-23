class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Trio> pq = new PriorityQueue<>((x,y)->Long.compare(y.d,x.d));
        for(int [] point:points){
            int x = point[0], y=point[1];
            int d = x*x + y*y;
            pq.offer(new Trio(x,y,d));
            while(pq.size()>k) pq.poll();
        }
        int [][] res= new int[k][2];k--;
        while(!pq.isEmpty()){
            Trio node = pq.poll();
            res[k][0] = node.x;
            res[k][1] = node.y;
            k--;
        }
        return res;
    }
}

class Trio{
    long d;
    int x,y;
    public Trio(int x,int y,long d){
        this.x=x;
        this.y=y;
        this.d=d;
    }
}