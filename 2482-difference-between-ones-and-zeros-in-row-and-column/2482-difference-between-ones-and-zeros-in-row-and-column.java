class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        int [] row = new int[m];
        int [] col = new int[n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        
        int [][] dif = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dif[i][j] = (row[i]+col[j])-(m-row[i]+n-col[j]);
            }
        }
        return dif;
    }
}