class Solution {
    public int longestPalindrome(String s) {
        boolean singleTaken = false;
        int map [] = new int[52];
        for(char c:s.toCharArray()){
            if(c<='Z'){
                map[26 + c -'A']++;
            }
            else {
                map[c-'a']++;
            }
        }
        int res=0;
        for(int i:map){
            if(i!=0 && i%2==0){
                res+=i;
            }
            if(i%2==1 && !singleTaken){
                res+=1;
                singleTaken = true;
            }
            if(i>1 && i%2==1){
                res = res + (i-1);
            }
        }
        return res;
    }
}