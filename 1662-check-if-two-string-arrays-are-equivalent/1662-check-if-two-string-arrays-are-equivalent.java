class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a = "";
        for(int i=0;i<word1.length;i++){
            for(int j=0;j<word1[i].length();j++) a+=word1[i].charAt(j);
        }
        String b = "";
        for(int i=0;i<word2.length;i++){
            for(int j=0;j<word2[i].length();j++) b+=word2[i].charAt(j);
        }
        return a.equals(b);
    }
}