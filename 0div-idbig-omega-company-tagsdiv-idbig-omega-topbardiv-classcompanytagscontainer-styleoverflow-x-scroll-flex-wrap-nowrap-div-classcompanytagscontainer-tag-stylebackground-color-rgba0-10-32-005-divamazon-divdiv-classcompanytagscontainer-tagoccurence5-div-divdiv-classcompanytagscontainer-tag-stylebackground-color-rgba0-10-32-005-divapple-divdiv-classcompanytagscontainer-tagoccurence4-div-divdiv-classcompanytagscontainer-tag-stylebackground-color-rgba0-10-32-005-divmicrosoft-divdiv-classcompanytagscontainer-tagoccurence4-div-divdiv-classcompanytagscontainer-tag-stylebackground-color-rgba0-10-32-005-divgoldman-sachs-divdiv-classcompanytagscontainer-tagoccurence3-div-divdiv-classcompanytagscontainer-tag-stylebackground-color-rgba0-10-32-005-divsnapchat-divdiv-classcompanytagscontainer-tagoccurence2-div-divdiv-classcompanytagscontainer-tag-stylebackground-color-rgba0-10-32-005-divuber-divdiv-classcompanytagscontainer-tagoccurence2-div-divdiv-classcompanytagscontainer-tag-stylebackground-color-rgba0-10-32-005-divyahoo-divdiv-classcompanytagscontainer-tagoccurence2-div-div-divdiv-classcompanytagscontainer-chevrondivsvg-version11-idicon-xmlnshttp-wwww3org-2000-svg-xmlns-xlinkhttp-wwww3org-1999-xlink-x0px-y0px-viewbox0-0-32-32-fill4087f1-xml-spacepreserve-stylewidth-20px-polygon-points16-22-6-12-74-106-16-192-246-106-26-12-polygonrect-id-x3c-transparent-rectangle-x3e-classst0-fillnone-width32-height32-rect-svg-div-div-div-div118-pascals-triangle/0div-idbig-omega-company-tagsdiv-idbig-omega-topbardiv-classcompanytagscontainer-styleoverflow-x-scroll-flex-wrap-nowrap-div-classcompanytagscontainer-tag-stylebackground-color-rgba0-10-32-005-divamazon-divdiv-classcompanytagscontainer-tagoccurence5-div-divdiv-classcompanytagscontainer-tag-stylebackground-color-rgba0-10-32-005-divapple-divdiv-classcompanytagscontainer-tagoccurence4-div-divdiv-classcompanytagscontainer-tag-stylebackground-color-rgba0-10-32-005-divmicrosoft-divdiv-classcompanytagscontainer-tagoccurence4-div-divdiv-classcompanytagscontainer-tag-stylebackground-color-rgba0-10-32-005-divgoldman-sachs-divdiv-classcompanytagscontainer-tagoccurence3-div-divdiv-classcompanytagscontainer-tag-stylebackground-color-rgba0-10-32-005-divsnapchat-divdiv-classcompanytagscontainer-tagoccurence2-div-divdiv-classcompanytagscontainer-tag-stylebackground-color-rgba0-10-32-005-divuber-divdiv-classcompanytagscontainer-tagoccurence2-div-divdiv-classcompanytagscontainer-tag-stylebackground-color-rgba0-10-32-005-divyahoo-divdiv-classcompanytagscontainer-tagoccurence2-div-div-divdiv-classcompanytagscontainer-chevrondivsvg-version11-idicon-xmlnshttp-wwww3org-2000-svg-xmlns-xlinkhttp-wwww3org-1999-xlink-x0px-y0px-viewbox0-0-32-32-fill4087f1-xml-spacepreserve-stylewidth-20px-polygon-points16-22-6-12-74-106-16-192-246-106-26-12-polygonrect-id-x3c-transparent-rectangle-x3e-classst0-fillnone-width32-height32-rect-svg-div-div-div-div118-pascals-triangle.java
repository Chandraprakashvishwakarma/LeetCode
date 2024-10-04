/*
Q. no. 2: Pascal's Triangle
*/
class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        int row = 0;
        while(row<n){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<=row;i++){
                if(i == 0 || i == row) temp.add(1);
                else{
                    temp.add(res.get(row-1).get(i-1)+res.get(row-1).get(i));
                }
            }
            res.add(new ArrayList(temp));
            row++;
        }
        return res;
    }
}