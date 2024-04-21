class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        List<List<Integer>> adj = getAdj(n,edges);
        
        boolean vis[] = new boolean[n];
        return dfs(adj,vis,source,destination);
    }
    
    private boolean dfs(List<List<Integer>> adj,boolean [] vis,int node,int d){
        if(node == d) return true;
        vis[node] = true;
        for(int i:adj.get(node)){
            if(!vis[i] && dfs(adj,vis,i,d)) return true;
        }
        return false;
    }
    
    private List<List<Integer>> getAdj(int n,int [][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<Integer>());
        
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}