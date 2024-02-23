//My solution reffered from Aditya Verma yt
// class Solution {
//     public String minWindow(String s, String t) {
//         Map<Character,Integer> map = new HashMap<>();
//         for(char c:t.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
//         int count = map.size();
//         int i=0,j=0;
//         int min = Integer.MAX_VALUE;
//         String res="";
//         while(j<s.length()){
//             char c = s.charAt(j);
//             if(map.get(c)!=null){
//                 map.put(c,map.get(c)-1);
//                 if(map.get(c) == 0) count--;
//             }
            
//             while(count==0){
//                 if(j-i<min){
//                     min = j-i;
//                     res = s.substring(i,j+1);
//                 }
//                 char x = s.charAt(i);
//                 if(map.get(x)!=null){
//                     int val = map.get(x);
//                     if(val == 0) count++;
//                     map.put(x,val+1);
//                 }
//                 i++;
//             }
//             j++;
//         }
//         return res;
//     }
// }

//Optimized version of above code

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        /// UPVOTE !
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() :
                new String(chS, startIndex, minLen);
    }
}