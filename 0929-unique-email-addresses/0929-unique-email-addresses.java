class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email:emails){
            String [] s = email.split("@");
            String local = s[0] , domain = s[1];
            
            String res = "";
            for(char c:local.toCharArray()){
                if(c == '.') continue;
                if(c == '+') break;
                res+=c;
            }
            set.add(res+"@"+domain);
        }
        return set.size();
    }
}
