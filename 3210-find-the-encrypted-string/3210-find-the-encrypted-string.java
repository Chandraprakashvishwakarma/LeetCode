class Solution {
    public String getEncryptedString(String s, int k) {
        char [] str = s.toCharArray();
        int n = s.length();
        for(int i=0;i<s.length();i++){
            str[i] = s.charAt((i+k)%n);
        }
        return new String(str);
    }
}