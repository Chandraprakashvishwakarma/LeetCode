class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = getAdj(n,prerequisites);
        boolean [] vis = new boolean[n];
        boolean [] pathVis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i] && !dfs(i,vis,pathVis,adj)) return false;
        }
        return true;
    }
    
    public boolean dfs(int node,boolean [] vis,boolean [] pathVis,List<List<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;
        for(int i:adj.get(node)){
            if(pathVis[i] || (!vis[i] && !dfs(i,vis,pathVis,adj))) return false;
        }
        pathVis[node] = false;
        return true;
    }
    
    public List<List<Integer>> getAdj(int n,int [][] prerequisites){
         List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<Integer>());
        
        for(int [] row:prerequisites){
            int u = row[0];
            int v = row[1];
            adj.get(v).add(u);
        }
        return adj;
    }
}