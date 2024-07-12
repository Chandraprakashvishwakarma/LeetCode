// class Solution {
//     public int expressiveWords(String s, String[] words) {
//         int res = 0;
//         for(String t:words){
//             int i=0,j=0;
//             int m = s.length(),n = t.length();
//             while(i<m && j<n){
//                 int c1=0,c2=0;
//                 while(i<m-1 && s.charAt(i) == s.charAt(i+1)){
//                     i++;c1++;
//                 }
//                 while(j<n-1 && t.charAt(j) == t.charAt(j+1)){
//                     j++;c2++;
//                 }
//                 if(s.charAt(i)!=t.charAt(j) || c1<c2 || (c1!=c2 && c1<2)) break;
//                 i++;j++;
//             }
//             if(i == m && j == n) res++;
//         }
//         return res;
//     }
// }

class Solution {
public int expressiveWords(String S, String[] words) {
    int result = 0;
    for (int i = 0; i < words.length; ++i) {
        if (isStretchy(S, words[i])) result++;        
    }
    return result;
}

private boolean isStretchy(String S, String word) {
    int i = 0, j = 0;
    while (i < S.length() && j < word.length()) {
        if (S.charAt(i) != word.charAt(j)) return false;    // Characters don't match.
        int sBlockSize = 1; 
        i++;
        // Count block size starting at S.charAt(i);
        while (i < S.length() && S.charAt(i - 1) == S.charAt(i)) {
            sBlockSize++;
            i++;
        }
        int wordBlockSize = 1;
        j++;
        // Count block size starting at word.charAt(j);
        while (j < word.length() && word.charAt(j - 1) == word.charAt(j)) {
            wordBlockSize++;
            j++;
        }
       
        if (sBlockSize < wordBlockSize || (wordBlockSize < sBlockSize && sBlockSize < 3)) {
            return false;         
        }
    }
    return i == S.length() && j == word.length();   
}
}