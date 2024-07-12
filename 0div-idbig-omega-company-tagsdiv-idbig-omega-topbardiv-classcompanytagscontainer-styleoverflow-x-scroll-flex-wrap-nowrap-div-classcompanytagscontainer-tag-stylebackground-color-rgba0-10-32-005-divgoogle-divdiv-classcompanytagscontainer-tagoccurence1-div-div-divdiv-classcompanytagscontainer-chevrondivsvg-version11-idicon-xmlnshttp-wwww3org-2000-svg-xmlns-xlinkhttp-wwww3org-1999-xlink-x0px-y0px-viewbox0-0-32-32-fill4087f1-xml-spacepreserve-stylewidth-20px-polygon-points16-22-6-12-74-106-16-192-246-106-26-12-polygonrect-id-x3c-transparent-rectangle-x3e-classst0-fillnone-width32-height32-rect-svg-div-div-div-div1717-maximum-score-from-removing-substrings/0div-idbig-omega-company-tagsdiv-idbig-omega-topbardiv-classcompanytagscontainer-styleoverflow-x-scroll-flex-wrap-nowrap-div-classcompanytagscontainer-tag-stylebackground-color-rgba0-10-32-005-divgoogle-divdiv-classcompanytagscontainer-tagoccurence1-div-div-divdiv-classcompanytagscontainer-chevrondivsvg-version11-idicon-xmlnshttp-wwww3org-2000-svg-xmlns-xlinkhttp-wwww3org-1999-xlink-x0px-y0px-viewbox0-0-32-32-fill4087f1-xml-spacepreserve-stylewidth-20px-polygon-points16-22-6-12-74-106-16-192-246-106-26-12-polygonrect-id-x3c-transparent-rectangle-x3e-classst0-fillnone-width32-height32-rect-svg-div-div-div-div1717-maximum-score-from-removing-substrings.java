class Solution {
    public int maximumGain(String s, int x, int y) {
        int i=0;
        StringBuilder sb = new StringBuilder(s);
        int p=0;
        
        if(x<y){
            int temp = x;
            x = y;
            y = temp;
            sb.reverse();
        }
        
        Stack<Boolean> a = new Stack<>();
        Stack<Boolean> b = new Stack<>();
        while(i<sb.length()){
            char c = sb.charAt(i);
            if(c == 'a') a.push(true);
            else if(c == 'b'){
                if(a.size()>0){
                    a.pop();
                    p+=x;
                }
                else b.push(true);
            }
            else {
                while(a.size()>0 && b.size()>0){
                    a.pop();b.pop();
                    p+=y;
                }
                a.clear();
                b.clear();
            }
            i++;
        }
        while(a.size()>0 && b.size()>0){
                    a.pop();b.pop();
                    p+=y;
                }
        return p;
    }
}

