class Solution {
    public String licenseKeyFormatting(String s, int kk) {
        int n = s.length();
        int i = n-1;
        String res = "";
        
        while(i>=0){
            int k = kk;
            while(i>=0 && k>0){
                if(s.charAt(i) == '-') i--;
                else {
                    char c = s.charAt(i);
                    if(c>='a' && c<='z') c = (char)(c-'a'+'A');
                    res = c + res;
                    i--;k--;
                }
                if(k == 0) res = '-'+res;
            }
        }
        if(res.length()<1) return res;
        return res.charAt(0) == '-'?res.substring(1,res.length()):res;
    }
}