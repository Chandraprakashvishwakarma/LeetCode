class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s:wordList) set.add(s);
        if(!set.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.s.equals(endWord)) return p.level;
            char [] sArr = p.s.toCharArray();
            for(int i=0;i<sArr.length;i++){
                char originalChar = sArr[i];
                for(char c='a';c<='z';c++){
                    sArr[i] = c;
                    String nS = new String(sArr);
                    if(set.contains(nS)){
                        q.offer(new Pair(nS,p.level+1));
                        set.remove(nS);
                    }
                }
                sArr[i] = originalChar;
            }
        }
        return 0;
    }
}

class Pair{
    String s;
    int level;
    public Pair(String s,int level){
        this.s = s;
        this.level = level;
    }
}