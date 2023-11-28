class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      boolean [] vis = new boolean[numCourses];
        boolean [] pathVis = new boolean[numCourses];
        
        Stack<Integer> st = new Stack<>();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<Integer>());
        getAdj(adj,prerequisites);
        
        for(int i=0;i<numCourses;i++){
            if(!vis[i] && !dfs(i,vis,pathVis,adj,st)) return new int[]{};
        }
        int i=0;
        int [] res = new int[numCourses];
        while(!st.isEmpty()) res[i++] = st.pop();
        i=0;
        while(i<numCourses-1){
            int temp = res[i];
            res[i] = res[numCourses-1];
            res[numCourses-1] = temp;
            i++;numCourses--;
        }
        return res;
    }
    
    public boolean dfs(int node,boolean [] vis,boolean [] pathVis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node] = true;
        pathVis[node] = true;
        for(int i:adj.get(node)){
            if(pathVis[i] || (!vis[i] && !dfs(i,vis,pathVis,adj,st))) return false;
        }
        pathVis[node] = false;
        st.push(node);
        return true;
    }
    
    public void getAdj(ArrayList<ArrayList<Integer>> adj ,int[][] prerequisites ){
        for(int [] row:prerequisites){
            int u = row[0],v = row[1];
            adj.get(u).add(v);
        }
    }
}