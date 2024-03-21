class Solution {
    public boolean isPalindrome(String s) {
        String temp = "";
        for(char c:s.toCharArray()){
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')){
                temp = temp+c;
            }
        }
        temp = temp.toLowerCase();
        return isPal(temp);
    }
    public boolean isPal(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}