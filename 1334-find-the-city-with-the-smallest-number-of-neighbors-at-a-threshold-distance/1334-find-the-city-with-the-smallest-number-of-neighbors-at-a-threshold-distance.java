class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][] dist = new int[n][n];
        int max = (int) 10e9;
        for(int i=0;i<n;i++) {
            Arrays.fill(dist[i],max);
            dist[i][i]=0;                
        }
        for(int [] tuple:edges){
            int u = tuple[0];
            int v = tuple[1];
            int w = tuple[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int via = 0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if((dist[i][via] != max && dist[via][j]!=max) && dist[i][via]+dist[via][j]<dist[i][j]){
                        dist[i][j] = dist[i][via]+dist[via][j];
                    }
                }
            }
        }
        
        int minCities = Integer.MAX_VALUE;
        int res = n+1;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=minCities){
                minCities = count;
                res = i;
            }
        }
        return res;
        
    }
}