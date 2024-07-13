// class Solution {
//     public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
//         int n = positions.length;
//         int [][] ar = new int[n][4];
//         List<Integer> res = new ArrayList();
//         for(int i=0;i<n;i++){
//             ar[i][0] = directions.charAt(i)=='R'?1:-1;
//             ar[i][1] = healths[i];
//             ar[i][2] = positions[i];
//             ar[i][3] = i;
//         }
        
//         Arrays.sort(ar,(x,y)->Integer.compare(x[2],y[2]));
//         // for(int [] arr:ar) System.out.println(Arrays.toString(arr));
        
//         Stack<int[]> st = new Stack<>();
//         int i=0;
//         while(i<n){
            
//             if(st.isEmpty()) st.push(ar[i++]);
//             else {
//                 int [] top = st.peek();
//                 // System.out.println(Arrays.toString(top)+" "+Arrays.toString(ar[i]));
//                 if(top[0]==1 && ar[i][0] == -1){
//                     if(top[1]==ar[i][1]){
//                         st.pop();i++;
//                     }
//                     else if(top[1]>ar[i][1]){
//                         int [] temp = st.pop();
//                         temp[1]--;
//                         //yaha health 0 pe remove ka line aa sakta hai baad me 
//                         st.push(temp);
//                         i++;
//                     }
//                     else {
//                         st.pop();
//                         ar[i][1]--;
//                     }
//                 }
//                 else st.push(ar[i++]);
//             }
            
//         }
//         int[][] temp = new int [st.size()][2];
//         for(int j=0;j<temp.length;j++){
//             int [] top = st.pop();
//             temp[j][0] = top[1];
//             temp[j][1] = top[3];
//         }
//         Arrays.sort(temp,(x,y)->Integer.compare(x[1],y[1]));
//         for(int [] tp:temp){
//             res.add(tp[0]);
//         }
//         return res;
//     }
// }



class Solution {

    public List<Integer> survivedRobotsHealths(
        int[] positions,
        int[] healths,
        String directions
    ) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < n; ++index) {
            indices[index] = index;
        }

        Arrays.sort(
            indices,
            (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs])
        );

        for (int currentIndex : indices) {
            // Add right-moving robots to the stack
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    // Pop the top robot from the stack for collision check
                    int topIndex = stack.pop();

                    // Top robot survives, current robot is destroyed
                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        // Current robot survives, top robot is destroyed
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        // Both robots are destroyed
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        // Collect surviving robots
        for (int index = 0; index < n; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }
        return result;
    }
}