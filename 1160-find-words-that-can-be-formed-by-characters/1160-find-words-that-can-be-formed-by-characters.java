class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int [] map = new int[26];
        for(char c:chars.toCharArray()) map[c-'a']++;
        for(int i=0;i<words.length;i++){
            res+=getLength(words[i],res,map);
        }
        return res;
    }
    
    public int getLength(String s,int res,int [] map){
        int len = 0;
        int [] m = map.clone();
        for(char c: s.toCharArray()){
            if(m[c-'a'] != 0) m[c-'a']--;
            else return 0;
        }
        return s.length();
    }
}