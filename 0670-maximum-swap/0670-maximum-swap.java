class Solution {
    public int maximumSwap(int num) {
        int n = num;
        List<Integer> digits = new ArrayList<>();
        while(n>0){
            int r = n%10;
            n/=10;
            digits.add(r);
        }
        Collections.reverse(digits);
        int [] maxes = new int[digits.size()];
        int max = Integer.MIN_VALUE;
        for(int i=digits.size()-1;i>=0;i--){
            if(digits.get(i)>max){
                max = digits.get(i);
                maxes[i] = i;
            }
            else{
                maxes[i] = maxes[i+1];
            }
        }
        
        for(int i=0;i<digits.size();i++){
            if(maxes[i]!=i && digits.get(i) == digits.get(maxes[i])) continue;
            if(maxes[i]!=i){
                swap(digits,maxes[i],i);
                break;
            }
        }
        
        int res = 0;
        for(int i=0;i<digits.size();i++){
            res = res*10+digits.get(i);
        }
        return res;
        
    }
    public void swap(List<Integer> digits,int i,int j){
        int temp = digits.get(i);
        digits.set(i,digits.get(j));
        digits.set(j,temp);
    }
}