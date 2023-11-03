class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<m;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++) reverse(matrix[i],m);
    }
     public void reverse(int [] matrix,int m){
         int i=0,j=m-1;
         while(i<=j){
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
             i++;j--;
         }
     }
}