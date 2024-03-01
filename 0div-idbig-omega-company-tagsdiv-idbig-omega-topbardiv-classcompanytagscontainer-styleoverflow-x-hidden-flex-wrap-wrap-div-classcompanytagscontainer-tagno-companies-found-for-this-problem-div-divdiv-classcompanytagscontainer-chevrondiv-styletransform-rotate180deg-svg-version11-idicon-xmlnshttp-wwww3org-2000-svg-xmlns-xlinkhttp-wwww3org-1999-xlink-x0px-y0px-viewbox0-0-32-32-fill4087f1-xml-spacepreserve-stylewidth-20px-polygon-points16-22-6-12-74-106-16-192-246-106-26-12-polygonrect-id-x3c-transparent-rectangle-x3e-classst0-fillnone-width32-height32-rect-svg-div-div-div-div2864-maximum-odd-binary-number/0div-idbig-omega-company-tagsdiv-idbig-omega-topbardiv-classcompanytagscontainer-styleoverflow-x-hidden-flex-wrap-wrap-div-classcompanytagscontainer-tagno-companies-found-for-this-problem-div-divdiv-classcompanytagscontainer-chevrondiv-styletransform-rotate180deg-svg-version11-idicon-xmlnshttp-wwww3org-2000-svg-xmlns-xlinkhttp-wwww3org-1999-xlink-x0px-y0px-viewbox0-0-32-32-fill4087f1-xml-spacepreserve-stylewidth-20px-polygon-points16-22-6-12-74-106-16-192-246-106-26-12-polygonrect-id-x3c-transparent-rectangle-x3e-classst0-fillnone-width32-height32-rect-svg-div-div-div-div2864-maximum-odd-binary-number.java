class Solution {
    public String maximumOddBinaryNumber(String s) {
        int l = s.length();
        int o = 0;
        String res = "";
        for(char c:s.toCharArray()) if(c == '1') o++;
        for(int i=0;i<o-1;i++) res = res + '1';
        for(int i=0;i<l-o;i++) res = res + '0';
        res = res + '1';
        return res;
    }
}