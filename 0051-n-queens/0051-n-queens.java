class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        char [][] chess = new char[n][n];
        for(char [] c:chess){
            Arrays.fill(c,'.');
        }
        res = new ArrayList();
        helper(chess,0);
        return res;
    }
    
    public void helper(char [][] chess,int col){
        if(col==chess[0].length) {
            build(chess);
            return;
        }

        for (int row = 0; row < chess.length; row++) {
            if (isSafe(chess,row, col)) {
                chess[row][col] = 'Q';
                helper(chess,col + 1);
                chess[row][col] = '.';
            }
        }
    }
    
    public boolean isSafe(char [][] chess,int row,int col){
        for(int i=0;i<row;i++){
            if(chess[i][col] == 'Q') return false;
        }
        for(int i=0;i<col;i++){
            if(chess[row][i] == 'Q') return false;
        }
        int r = row-1,c = col-1;
        while(r>=0 && c>=0){
            if(chess[r--][c--] == 'Q') return false;
        }
        r = row+1;
        c = col-1;
        while(r<chess.length && c>=0){
            if(chess[r++][c--] == 'Q') return false;
        }
        return true;
    }
    
    public void build(char [][] chess){
        List<String> temp = new ArrayList<>();
        for(char [] c : chess){
            temp.add(new String(c));
        }
        res.add(temp);
    }
}