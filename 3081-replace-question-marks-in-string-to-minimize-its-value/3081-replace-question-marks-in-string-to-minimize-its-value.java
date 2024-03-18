//Correct solution but giving TLE 

// class Solution {
//     public String minimizeStringValue(String s) {
//         int [] map = new int[26];
//         int c=0;
        
//         for(char ch:s.toCharArray()) {
//             if(ch!='?') map[ch-'a']++; 
//             else c++; 
//         }
//         PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p1,p2)->p1.val==p2.val?p1.i-p2.i:p1.val-p2.val);
        
//         for(int i=0;i<26;i++) pq.offer(new Pair(map[i],i));
        
//         int [] temp = new int[c];
//         int j=0;
        
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i)=='?'){
//                 Pair top = pq.poll();
//                 temp[j++] = top.i;
//                 map[top.i]++;
//                 pq.offer(new Pair(map[top.i],top.i));
//             }
//         }
        
//         Arrays.sort(temp);
        
//         j=0;
//         String res="";
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i)=='?'){
//                 res += (char)(temp[j++]+'a');
//             }
//             else res+=s.charAt(i);
//         }
//         return res;
//     }
// }

// class Pair{
//     int val,i;
//     public Pair(int val,int i){
//         this.val = val;
//         this.i = i;
//     }
// }


class Solution {
    public String minimizeStringValue(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        List<Integer> pos = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (ch != '?')  {
                charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
            }
        }
        List<Character> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                pos.add(i);
            }
        }
        for (int i = 0; i < pos.size(); i++) {
            int freq = Integer.MAX_VALUE;
            for (char c = 'a'; c <= 'z'; c++) {
                freq = Math.min(charFreq.getOrDefault(c, 0), freq);
            }
            for (char c = 'a'; c <= 'z'; c++) {
                if (freq == charFreq.getOrDefault(c, 0)) {
                    ans.add(c);
                    charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
                    break;
                }
            }
        }
        Collections.sort(ans);
        int j = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i : pos) {
            sb.setCharAt(i, ans.get(j++));
        }
        return sb.toString();
    }
}