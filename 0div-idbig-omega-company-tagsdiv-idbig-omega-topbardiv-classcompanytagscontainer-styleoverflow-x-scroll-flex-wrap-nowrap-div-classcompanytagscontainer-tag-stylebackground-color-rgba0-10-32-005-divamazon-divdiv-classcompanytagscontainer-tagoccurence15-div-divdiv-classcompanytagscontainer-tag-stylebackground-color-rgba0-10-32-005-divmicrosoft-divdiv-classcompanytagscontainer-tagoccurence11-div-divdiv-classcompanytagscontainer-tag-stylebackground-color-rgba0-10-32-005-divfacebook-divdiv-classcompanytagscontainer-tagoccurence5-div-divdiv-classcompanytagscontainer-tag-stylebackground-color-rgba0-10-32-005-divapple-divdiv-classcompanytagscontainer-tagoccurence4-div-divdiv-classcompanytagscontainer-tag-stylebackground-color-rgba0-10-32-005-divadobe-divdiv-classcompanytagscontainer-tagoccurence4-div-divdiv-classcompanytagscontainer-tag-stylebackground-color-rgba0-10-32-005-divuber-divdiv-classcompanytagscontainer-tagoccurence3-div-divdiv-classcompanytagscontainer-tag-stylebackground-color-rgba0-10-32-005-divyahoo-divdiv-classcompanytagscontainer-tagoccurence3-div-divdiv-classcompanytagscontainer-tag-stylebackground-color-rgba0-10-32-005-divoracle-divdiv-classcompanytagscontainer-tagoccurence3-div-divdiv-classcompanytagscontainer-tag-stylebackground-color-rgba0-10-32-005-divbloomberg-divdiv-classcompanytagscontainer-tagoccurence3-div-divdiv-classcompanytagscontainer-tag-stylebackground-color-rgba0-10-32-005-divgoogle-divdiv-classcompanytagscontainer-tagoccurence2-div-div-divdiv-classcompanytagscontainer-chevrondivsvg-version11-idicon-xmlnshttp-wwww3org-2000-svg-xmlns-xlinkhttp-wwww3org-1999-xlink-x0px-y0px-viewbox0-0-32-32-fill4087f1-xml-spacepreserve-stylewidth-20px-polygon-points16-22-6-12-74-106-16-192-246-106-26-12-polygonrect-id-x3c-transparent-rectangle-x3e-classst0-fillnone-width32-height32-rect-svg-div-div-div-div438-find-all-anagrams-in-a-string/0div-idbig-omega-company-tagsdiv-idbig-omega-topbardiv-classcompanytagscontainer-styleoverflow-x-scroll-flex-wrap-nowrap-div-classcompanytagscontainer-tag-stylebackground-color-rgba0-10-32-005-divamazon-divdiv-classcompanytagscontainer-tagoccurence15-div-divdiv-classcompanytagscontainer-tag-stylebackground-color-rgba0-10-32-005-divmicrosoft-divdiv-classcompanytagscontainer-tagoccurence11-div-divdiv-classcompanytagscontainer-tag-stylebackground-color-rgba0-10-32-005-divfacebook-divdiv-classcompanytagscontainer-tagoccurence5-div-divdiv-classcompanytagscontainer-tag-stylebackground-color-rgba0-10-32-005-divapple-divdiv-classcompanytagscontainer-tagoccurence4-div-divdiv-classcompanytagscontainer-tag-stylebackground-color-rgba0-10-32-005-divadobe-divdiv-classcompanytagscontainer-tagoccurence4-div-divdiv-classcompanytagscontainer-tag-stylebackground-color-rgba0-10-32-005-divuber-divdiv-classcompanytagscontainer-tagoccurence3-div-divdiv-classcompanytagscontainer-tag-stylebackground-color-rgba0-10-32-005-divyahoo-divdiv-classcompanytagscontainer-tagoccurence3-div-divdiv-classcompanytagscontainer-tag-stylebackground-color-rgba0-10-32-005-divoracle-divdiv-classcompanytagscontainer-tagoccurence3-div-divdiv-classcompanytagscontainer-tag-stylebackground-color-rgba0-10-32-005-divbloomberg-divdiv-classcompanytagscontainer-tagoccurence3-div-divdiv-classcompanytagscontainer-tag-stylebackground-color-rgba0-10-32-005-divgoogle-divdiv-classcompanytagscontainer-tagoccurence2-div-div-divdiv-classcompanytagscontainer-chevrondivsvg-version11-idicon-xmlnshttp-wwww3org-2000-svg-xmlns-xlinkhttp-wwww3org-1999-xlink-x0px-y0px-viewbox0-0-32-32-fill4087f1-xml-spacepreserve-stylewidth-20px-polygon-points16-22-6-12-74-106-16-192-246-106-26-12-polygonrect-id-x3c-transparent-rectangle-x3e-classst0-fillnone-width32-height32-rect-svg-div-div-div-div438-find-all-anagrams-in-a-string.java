class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        if(s.length()<p.length()) return res;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:p.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        int count = map.size();
        
        int i=0,j=0;
        
        while(j<p.length()){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) count--;
            }
            j++;
        }

        while(j<=s.length()){
            if(count==0){
                res.add(i);
            }
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))==0) count++;
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            if(j<s.length() && map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j))==0) count--;
            }
            i++;j++;
        }
        
        return res;
    }
}