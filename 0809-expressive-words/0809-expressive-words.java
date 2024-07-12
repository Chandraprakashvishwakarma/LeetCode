class Solution {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for(String t:words){
            int i=0,j=0;
            int m = s.length(),n = t.length();
            while(i<m && j<n){
                int c1=0,c2=0;
                while(i<m-1 && s.charAt(i) == s.charAt(i+1)){
                    i++;c1++;
                }
                while(j<n-1 && t.charAt(j) == t.charAt(j+1)){
                    j++;c2++;
                }
                if(s.charAt(i)!=t.charAt(j) || c1<c2 || (c1!=c2 && c1<2)) break;
                i++;j++;
            }
            if(i == m && j == n) res++;
        }
        return res;
    }
}