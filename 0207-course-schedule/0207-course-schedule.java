class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean [] vis = new boolean[numCourses];
        boolean [] pathVis = new boolean[numCourses];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<Integer>());
        getAdj(adj,prerequisites);
        
        for(int i=0;i<numCourses;i++){
            if(!vis[i] && !dfs(i,vis,pathVis,adj)) return false;
        }
        return true;
    }
    
    public boolean dfs(int node,boolean [] vis,boolean [] pathVis,ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;
        for(int i:adj.get(node)){
            if(pathVis[i] || (!vis[i] && !dfs(i,vis,pathVis,adj))) return false;
        }
        pathVis[node] = false;
        return true;
    }
    
    public void getAdj(ArrayList<ArrayList<Integer>> adj ,int[][] prerequisites ){
        for(int [] row:prerequisites){
            int u = row[0],v = row[1];
            adj.get(u).add(v);
        }
    }
}