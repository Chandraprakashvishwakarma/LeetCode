class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        getAllSubstrings(n,"",res,'2');
        return res;
    }
    public void getAllSubstrings(int n,String temp,List<String> res,char pre){
        if(temp.length() == n) {
            res.add(String.valueOf(temp));
            return;
        }
        
        if(pre == '0') getAllSubstrings(n,temp+'1',res,'1');
        else {
            temp = temp + '0';
            getAllSubstrings(n,temp,res,'0');
            temp = temp.substring(0,temp.length()-1) + '1';
            getAllSubstrings(n,temp,res,'1');
            temp = temp.substring(0,temp.length()-1);
        }
    }
}