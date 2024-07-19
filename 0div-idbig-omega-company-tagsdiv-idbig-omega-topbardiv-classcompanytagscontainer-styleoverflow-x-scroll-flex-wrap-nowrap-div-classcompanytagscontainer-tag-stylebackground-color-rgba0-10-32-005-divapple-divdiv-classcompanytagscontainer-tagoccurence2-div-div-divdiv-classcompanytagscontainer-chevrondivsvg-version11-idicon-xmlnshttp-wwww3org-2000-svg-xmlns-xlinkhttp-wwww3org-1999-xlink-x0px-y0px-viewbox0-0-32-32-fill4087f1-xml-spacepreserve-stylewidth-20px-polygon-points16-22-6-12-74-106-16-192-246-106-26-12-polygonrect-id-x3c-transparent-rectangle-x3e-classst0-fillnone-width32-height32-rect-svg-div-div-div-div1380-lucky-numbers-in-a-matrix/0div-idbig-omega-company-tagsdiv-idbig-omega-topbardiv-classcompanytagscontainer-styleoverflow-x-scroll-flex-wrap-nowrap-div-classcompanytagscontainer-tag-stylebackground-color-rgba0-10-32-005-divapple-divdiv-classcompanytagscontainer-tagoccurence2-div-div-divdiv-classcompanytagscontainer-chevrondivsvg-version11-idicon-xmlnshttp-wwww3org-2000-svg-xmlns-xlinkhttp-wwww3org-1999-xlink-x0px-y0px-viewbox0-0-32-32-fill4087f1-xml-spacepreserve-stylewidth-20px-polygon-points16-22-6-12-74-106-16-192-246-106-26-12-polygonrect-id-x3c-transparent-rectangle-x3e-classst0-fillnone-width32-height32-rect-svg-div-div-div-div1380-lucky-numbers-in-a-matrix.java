class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int [] row = new int [m];
        Arrays.fill(row,Integer.MAX_VALUE);
        int [] col = new int [n];
        Arrays.fill(col,Integer.MIN_VALUE);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                row[i] = Math.min(row[i],matrix[i][j]);
                col[j] = Math.max(col[j],matrix[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i] == matrix[i][j] && col[j] == matrix[i][j]) res.add(matrix[i][j]);
            }
        }
        return res;
    }
}

//     col1 col2 col3
// row1
// row2
// row3