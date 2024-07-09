class Solution {
    public String getEncryptedString(String s, int k) {
        String res = "";
        int n = s.length();
        for(int i=0;i<s.length();i++){
            res += s.charAt((i+k)%n);
        }
        return res;
    }
}