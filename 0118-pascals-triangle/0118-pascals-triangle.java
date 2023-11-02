class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        for(int row=1;row<=numRows;row++){
            List<Integer> temp = new ArrayList();
            long val = 1;
            temp.add((int)val);
            for(int col=1;col<row;col++){
                val = (val*(row-col))/col;
                temp.add((int)val);
            }
            res.add(temp);
        }
        return res;
    }
}