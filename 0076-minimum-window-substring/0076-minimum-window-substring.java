class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:t.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        int count = map.size();
        int i=0,j=0;
        int min = Integer.MAX_VALUE;
        String res="";
        while(j<s.length()){
            char c = s.charAt(j);
            if(map.get(c)!=null){
                map.put(c,map.get(c)-1);
                if(map.get(c) == 0) count--;
            }
            
            while(count==0){
                if(j-i<min){
                    min = j-i;
                    res = s.substring(i,j+1);
                }
                char x = s.charAt(i);
                if(map.get(x)!=null){
                    int val = map.get(x);
                    if(val == 0) count++;
                    map.put(x,val+1);
                }
                i++;
            }
            j++;
        }
        return res;
    }
}