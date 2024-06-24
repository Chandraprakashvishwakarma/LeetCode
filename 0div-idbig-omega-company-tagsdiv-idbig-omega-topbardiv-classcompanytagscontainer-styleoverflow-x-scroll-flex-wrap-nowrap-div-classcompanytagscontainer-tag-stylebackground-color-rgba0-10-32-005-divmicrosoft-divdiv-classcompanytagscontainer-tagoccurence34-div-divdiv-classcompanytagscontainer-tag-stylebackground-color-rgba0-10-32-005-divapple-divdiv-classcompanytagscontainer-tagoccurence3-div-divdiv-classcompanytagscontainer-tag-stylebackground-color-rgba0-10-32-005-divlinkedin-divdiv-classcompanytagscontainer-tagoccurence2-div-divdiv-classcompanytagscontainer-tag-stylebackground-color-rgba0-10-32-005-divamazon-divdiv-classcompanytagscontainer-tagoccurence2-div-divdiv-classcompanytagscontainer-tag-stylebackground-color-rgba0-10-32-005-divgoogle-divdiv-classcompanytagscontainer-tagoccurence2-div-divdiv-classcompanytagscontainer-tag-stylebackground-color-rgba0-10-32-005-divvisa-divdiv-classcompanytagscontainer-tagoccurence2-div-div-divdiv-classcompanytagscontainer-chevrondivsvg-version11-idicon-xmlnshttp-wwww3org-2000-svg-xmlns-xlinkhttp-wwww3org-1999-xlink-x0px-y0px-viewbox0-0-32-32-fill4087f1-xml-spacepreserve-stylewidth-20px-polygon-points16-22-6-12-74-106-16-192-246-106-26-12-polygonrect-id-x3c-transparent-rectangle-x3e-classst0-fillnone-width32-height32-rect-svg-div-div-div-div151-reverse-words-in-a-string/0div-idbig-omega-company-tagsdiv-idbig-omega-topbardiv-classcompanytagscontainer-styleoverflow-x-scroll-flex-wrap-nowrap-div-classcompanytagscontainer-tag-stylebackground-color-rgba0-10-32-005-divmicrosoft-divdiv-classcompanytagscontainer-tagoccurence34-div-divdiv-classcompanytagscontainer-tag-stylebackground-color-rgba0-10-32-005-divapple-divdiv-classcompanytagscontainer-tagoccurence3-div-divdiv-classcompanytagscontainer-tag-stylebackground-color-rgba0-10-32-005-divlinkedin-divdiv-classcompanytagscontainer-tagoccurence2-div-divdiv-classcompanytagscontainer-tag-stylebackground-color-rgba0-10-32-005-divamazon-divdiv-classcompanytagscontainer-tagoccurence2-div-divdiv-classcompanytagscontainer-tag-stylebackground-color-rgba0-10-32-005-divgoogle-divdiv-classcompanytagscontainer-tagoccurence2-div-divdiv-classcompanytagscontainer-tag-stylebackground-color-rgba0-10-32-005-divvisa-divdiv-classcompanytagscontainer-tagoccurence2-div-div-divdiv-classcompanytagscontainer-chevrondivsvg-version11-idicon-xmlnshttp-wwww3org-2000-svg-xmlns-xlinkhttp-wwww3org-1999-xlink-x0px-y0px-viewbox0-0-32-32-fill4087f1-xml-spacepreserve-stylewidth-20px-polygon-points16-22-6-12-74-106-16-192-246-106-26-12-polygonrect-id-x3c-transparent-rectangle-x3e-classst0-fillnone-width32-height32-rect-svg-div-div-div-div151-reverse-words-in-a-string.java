class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String [] ar = s.split(" ");
        int i=0,j=ar.length-1;
        
        String res="";
        for(String str:ar){
            if(str.length()==0 || str.charAt(0)==' ') continue;
            res = str+" "+res;
        }
        return res.trim();
    }
}