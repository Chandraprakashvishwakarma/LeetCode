class Solution {
    public boolean isSubstringPresent(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.get(c)!=null) {
                int index = map.get(c);
                if(index<s.length()-1 && s.charAt(index+1) == s.charAt(i-1)) return true;
            }
            map.put(c,i);
        }
        return false;
    }
}