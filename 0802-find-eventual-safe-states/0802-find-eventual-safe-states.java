class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<Integer> res = new ArrayList();
        boolean vis[] = new boolean[v];
        boolean pathVis[] = new boolean[v];
        boolean [] safe = new boolean[v];
        
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(i,graph,vis,pathVis,safe,res);
            }
        }
        Collections.sort(res);
        return res;
             
    }
    public boolean dfs(int node,int[][] adj,boolean vis[],boolean pathVis[],boolean safe[],List<Integer> res){
        vis[node] =true;
        pathVis[node] = true;
        for(int i:adj[node]){
            if(vis[i] && pathVis[i]) return false;
            if(vis[i]) {
                if(safe[i]) continue;  // got safe node so check for other adj
                else return false;   // got unsafe node so return false
            }
            if(!dfs(i,adj,vis,pathVis,safe,res)){
                return false;
            }
        }
        safe[node] = true;
        res.add(node);
        pathVis[node] = false;
        return true;
    }
}