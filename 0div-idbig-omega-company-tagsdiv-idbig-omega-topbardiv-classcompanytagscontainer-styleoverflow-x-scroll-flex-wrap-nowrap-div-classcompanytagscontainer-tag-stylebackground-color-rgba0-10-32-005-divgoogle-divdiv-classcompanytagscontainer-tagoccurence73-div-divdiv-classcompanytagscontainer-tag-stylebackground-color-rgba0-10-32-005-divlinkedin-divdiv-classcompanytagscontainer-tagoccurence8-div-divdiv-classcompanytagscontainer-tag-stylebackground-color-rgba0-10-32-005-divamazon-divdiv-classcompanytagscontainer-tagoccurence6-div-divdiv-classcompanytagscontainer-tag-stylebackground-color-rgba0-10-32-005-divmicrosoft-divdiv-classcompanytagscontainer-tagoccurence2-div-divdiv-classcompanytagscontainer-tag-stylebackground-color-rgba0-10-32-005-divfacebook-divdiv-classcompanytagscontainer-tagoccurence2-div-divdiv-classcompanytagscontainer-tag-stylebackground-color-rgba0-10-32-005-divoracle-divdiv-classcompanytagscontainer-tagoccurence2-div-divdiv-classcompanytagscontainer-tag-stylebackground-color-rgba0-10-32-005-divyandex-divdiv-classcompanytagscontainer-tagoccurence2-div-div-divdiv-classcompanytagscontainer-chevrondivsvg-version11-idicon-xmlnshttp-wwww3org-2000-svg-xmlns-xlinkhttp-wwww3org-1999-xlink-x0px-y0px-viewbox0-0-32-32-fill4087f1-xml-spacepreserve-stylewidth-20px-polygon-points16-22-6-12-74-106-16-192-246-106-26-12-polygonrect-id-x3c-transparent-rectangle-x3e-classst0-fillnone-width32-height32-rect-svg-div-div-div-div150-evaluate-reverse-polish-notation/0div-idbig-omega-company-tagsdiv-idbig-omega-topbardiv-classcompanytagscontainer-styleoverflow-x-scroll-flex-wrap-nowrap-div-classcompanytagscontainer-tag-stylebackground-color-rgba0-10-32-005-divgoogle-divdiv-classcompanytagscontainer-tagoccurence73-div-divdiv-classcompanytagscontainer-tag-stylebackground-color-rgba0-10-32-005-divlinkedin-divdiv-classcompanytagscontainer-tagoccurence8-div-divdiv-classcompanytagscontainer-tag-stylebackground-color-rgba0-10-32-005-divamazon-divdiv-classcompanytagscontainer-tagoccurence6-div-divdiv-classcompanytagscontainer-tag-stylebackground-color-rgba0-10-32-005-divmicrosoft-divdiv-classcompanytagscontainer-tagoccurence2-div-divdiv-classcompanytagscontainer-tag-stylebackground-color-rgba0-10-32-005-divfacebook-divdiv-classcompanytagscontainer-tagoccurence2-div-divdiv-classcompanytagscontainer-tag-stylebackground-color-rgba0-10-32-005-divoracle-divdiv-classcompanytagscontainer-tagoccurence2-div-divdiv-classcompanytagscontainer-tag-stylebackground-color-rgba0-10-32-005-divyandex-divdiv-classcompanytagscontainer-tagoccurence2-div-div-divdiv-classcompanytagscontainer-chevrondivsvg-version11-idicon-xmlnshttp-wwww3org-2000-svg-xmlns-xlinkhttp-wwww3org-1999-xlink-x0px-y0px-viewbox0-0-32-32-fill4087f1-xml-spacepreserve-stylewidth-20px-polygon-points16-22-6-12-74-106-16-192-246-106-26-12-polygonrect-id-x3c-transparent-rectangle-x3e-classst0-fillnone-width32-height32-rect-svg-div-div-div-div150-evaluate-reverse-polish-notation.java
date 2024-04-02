class Solution {
    public int evalRPN(String[] tokens) {
        int i=0,j=0,n=tokens.length;
        boolean vis[] = new boolean[n];
        Set<String> operators = new HashSet<>();
        operators.add("+");operators.add("-");operators.add("*");operators.add("/");
        int c = 2;
        while(j<n){
            if(operators.contains(tokens[j])){
                i=j-1;
                // vis[j] = true;
                int a ,b;
                while(vis[i]) i--;
                b = Integer.parseInt(tokens[i]);
                vis[i] = true;
                while(vis[i]) i--;
                a = Integer.parseInt(tokens[i]);
                vis[i] = true;
                tokens[j] = String.valueOf(performOperation(a,b,tokens[j]));
            }
            j++;
        }
        return Integer.parseInt(tokens[n-1]);
    }
    public int performOperation(int a,int b,String operator){
        if(operator.equals("+")) return a+b;
        if(operator.equals("-")) return a-b;
        if(operator.equals("*")) return a*b;
        if(operator.equals("/")) return a/b;
        throw new RuntimeException("Wrong operator : " +operator);
    }
}