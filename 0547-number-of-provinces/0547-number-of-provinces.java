class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        int n = isConnected.length;
        for(int i=0;i<n;i++) adj.add(new ArrayList<Integer>());
        getAdj(adj,isConnected);
        int vis[] = new int [n];
        int count =0;
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                helper(adj,vis,i);
                count++;
            }
        }
        return count;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> adj,int vis[],int node){
        if(vis[node]!=1){
            vis[node] = 1;
            for(int i:adj.get(node)){
                if(vis[i]!=1) helper(adj,vis,i);
            }
        }
    }
    
    public void getAdj(ArrayList<ArrayList<Integer>> adj,int[][] isConnected){
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(i == j) continue;
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
    }
}