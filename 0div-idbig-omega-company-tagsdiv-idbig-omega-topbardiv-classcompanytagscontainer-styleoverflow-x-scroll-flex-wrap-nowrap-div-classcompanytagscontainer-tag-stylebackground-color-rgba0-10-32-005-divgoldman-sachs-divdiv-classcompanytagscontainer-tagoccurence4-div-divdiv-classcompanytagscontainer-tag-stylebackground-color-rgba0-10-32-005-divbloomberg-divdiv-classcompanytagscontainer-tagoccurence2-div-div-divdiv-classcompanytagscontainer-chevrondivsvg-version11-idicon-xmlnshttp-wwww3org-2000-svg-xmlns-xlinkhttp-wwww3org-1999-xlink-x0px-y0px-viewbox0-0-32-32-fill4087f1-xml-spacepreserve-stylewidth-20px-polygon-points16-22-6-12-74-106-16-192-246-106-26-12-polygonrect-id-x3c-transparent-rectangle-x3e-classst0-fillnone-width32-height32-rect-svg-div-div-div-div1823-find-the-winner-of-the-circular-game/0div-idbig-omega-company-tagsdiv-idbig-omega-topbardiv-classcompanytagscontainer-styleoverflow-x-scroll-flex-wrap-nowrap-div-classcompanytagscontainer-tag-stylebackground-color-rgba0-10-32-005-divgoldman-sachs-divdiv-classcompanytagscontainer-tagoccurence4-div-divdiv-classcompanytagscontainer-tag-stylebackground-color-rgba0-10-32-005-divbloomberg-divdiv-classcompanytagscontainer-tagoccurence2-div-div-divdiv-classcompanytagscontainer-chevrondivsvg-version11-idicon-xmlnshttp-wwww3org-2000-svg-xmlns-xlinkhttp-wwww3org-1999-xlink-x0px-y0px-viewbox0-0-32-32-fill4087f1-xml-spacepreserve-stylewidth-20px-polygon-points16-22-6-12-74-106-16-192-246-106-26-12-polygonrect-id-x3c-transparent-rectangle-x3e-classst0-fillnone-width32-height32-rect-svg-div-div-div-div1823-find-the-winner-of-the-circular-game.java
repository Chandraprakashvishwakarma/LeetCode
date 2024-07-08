class Solution {
    public int findTheWinner(int n, int k) {
        
        // return helper1(n,k)+1;
        return helper2(n,k)+1;
        
        //brute force solution
//         Queue<Integer> q = new LinkedList<>();
//         for(int i=1;i<=n;i++) q.offer(i);
        
//         while(q.size()>1){
//             for(int i=0;i<k-1;i++){
//                 q.offer(q.poll());
//             }
//             q.poll();
//         }
//         return q.poll();
    }
    
//     time: O(n) and spcae: O(1)
    public int helper2(int n,int k){
        int ans = 0;
        for(int i=1;i<=n;i++){
            ans = (ans+k)%i;
        }
        return ans;
    }
    
    
    //time: O(n) and space: O(n)-stack space
    // public int helper1(int n ,int k){
    //     return n == 1 ? 0 : (helper1(n-1,k) + k) % n ;
    // }
}