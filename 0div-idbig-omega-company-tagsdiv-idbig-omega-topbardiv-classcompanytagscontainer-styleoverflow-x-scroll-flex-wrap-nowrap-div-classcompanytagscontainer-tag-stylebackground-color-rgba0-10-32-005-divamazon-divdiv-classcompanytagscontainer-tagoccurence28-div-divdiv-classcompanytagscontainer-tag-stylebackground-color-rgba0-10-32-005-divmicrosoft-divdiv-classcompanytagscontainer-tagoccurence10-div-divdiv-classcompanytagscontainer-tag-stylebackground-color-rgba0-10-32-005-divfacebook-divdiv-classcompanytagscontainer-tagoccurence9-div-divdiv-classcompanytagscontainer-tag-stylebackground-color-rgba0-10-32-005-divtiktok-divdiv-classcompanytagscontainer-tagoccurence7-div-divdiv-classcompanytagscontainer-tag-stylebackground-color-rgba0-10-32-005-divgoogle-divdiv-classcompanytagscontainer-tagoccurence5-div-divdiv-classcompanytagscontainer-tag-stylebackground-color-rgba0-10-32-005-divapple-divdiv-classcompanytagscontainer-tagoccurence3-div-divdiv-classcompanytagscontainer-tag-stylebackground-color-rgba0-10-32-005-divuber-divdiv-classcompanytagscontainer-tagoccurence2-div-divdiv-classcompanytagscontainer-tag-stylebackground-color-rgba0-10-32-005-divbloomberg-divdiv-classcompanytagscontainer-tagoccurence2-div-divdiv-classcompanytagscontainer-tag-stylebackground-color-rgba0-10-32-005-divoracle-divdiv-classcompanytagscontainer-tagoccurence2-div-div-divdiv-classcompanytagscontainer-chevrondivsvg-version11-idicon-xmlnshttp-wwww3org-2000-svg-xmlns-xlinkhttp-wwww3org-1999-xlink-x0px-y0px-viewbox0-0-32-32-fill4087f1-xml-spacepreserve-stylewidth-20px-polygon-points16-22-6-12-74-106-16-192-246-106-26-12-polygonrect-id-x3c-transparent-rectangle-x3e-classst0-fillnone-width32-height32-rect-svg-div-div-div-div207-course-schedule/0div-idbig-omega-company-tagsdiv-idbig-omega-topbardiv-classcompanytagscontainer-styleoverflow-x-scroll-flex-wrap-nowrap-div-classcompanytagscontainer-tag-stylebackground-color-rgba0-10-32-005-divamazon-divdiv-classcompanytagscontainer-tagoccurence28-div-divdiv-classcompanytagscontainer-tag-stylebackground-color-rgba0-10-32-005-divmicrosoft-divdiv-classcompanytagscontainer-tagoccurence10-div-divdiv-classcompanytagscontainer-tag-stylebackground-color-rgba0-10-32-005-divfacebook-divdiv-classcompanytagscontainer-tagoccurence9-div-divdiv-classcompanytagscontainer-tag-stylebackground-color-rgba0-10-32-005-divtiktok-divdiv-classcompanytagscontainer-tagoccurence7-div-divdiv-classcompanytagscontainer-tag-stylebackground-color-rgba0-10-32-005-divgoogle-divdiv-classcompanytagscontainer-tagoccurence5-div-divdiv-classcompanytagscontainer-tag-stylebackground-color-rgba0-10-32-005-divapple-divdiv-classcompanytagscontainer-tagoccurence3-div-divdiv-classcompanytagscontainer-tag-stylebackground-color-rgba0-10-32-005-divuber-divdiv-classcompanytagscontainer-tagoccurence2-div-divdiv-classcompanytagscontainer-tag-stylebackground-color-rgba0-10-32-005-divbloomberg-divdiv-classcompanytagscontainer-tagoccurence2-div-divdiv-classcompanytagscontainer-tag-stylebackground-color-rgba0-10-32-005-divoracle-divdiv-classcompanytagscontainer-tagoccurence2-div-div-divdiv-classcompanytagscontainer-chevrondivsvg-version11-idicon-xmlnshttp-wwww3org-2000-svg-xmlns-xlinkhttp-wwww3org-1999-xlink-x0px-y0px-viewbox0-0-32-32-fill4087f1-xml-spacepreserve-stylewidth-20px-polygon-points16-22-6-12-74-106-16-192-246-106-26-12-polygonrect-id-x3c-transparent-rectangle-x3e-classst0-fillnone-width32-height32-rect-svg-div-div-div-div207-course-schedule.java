class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> ad = getAdj(prerequisites,numCourses);
        boolean [] vis = new boolean[numCourses];
        boolean [] pathVis = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i] && !dfs(ad,i,vis,pathVis)) return false;
        }
        return true;
    }
    
    public boolean dfs(List<List<Integer>> ad,int i,boolean [] vis,boolean [] pathVis){
        vis[i] = true;
        pathVis[i] = true;
        for(int node:ad.get(i)){
            if(pathVis[node] || (!vis[node] && !dfs(ad,node,vis,pathVis))) return false;
        }
        pathVis[i] = false;
        return true;
    }
    
    public List<List<Integer>> getAdj(int[][] prerequisites,int numCourses){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int [] temp : prerequisites){
            int u = temp[0];
            int v = temp[1];
            adj.get(u).add(v);
        }
        return adj;
    }
}