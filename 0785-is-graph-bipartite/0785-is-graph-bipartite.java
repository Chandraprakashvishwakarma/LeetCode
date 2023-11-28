class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int color[] = new int[v];
        Arrays.fill(color,-1);
        for(int i = 0;i<v;i++){
            if(color[i]==-1 && !dfs(i,0,color,graph,-1)) return false;
        }
        return true;
    }
    
    public boolean dfs(int cur,int c,int [] color,int [][] adj,int par){
        color[cur] = c;
        int tempc = (c == 1)?0:1;
        for(int i:adj[cur]){
            if((color[i]!=-1 && color[i]==c) || 
               (color[i]==-1 && !dfs(i,tempc,color,adj,cur))) return false;
        }
        return true;
    }
}