class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        getAllSubstrings(n,"",res,'2');
        return res;
    }
    public void getAllSubstrings(int n,String temp,List<String> res,char pre){
        if(temp.length() == n) {
            res.add(temp);
            return;
        }
        
        getAllSubstrings(n,temp+'1',res,'1');
        if(pre != '0') getAllSubstrings(n,temp+'0',res,'0');
    }
}