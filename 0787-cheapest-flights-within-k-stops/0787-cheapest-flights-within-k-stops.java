class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int []>> adj = getAdj(flights,n);
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(0,src,0));
        int cost [] = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src] = 0;
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int stop = t.stop,node = t.node,price = t.price;
            if(stop>k) continue;
            for(int [] ad:adj.get(node)){
                int d = ad[0],p=ad[1];
                if(price+p<cost[d]){
                    cost[d] = price+p;
                    q.add(new Tuple(stop+1,d,price+p));
                }
            }
        }
        if(cost[dst]==Integer.MAX_VALUE) return -1;
        return cost[dst];
        
    }
    
    public List<List<int[]>> getAdj(int[][] flights,int n){
        List<List<int []>> adj = new ArrayList();
        for(int i=0;i<n;i++) adj.add(new ArrayList<int[]>());
        for(int [] flight:flights){
            int s = flight[0];
            int [] temp = new int[]{flight[1],flight[2]};
            // adj.get(s).add(flight[1]);
            // adj.get(s).add(flight[2]);
            adj.get(s).add(temp);
        }
        return adj;
    }
}

class Tuple{
    int stop,node,price;
    public Tuple(int stop,int node,int price){
        this.stop = stop;
        this.node=node;
        this.price=price;
    }
}
