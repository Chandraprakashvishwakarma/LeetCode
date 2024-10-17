class Solution {
    public int maximumSwap(int num) {
        char [] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int [] maxes = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(digits[i]>max){
                max = digits[i];
                maxes[i] = i;
            }
            else {
                maxes[i] = maxes[i+1];
            }
        }
        
        for(int i=0;i<n;i++){
            if(maxes[i]!=i && digits[i] == digits[maxes[i]]) continue;
            if(maxes[i]!=i){
                swap(digits,i,maxes[i]);
                break;
            }
        }
        return Integer.parseInt(String.valueOf(digits));
    }
    public void swap(char [] digits,int i,int j){
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}