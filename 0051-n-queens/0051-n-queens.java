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
    
    //Checks if Q can be placed
    public boolean isSafe(char [][] chess,int row,int col){
        //Chech in row 
        for(int i=0;i<col;i++){
            if(chess[row][i] == 'Q') return false;
        }
        int r = row-1,c = col-1;
        //Check up 45*
        while(r>=0 && c>=0){
            if(chess[r--][c--] == 'Q') return false;
        }
        r = row+1;
        c = col-1;
        //Check down 45*
        while(r<chess.length && c>=0){
            if(chess[r++][c--] == 'Q') return false;
        }
        return true;
    }
    
    //Builds the board if all Queens are places
    public void build(char [][] chess){
        List<String> temp = new ArrayList<>();
        for(char [] c : chess){
            temp.add(new String(c));
        }
        res.add(temp);
    }
}