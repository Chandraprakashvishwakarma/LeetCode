/*
Q. no. 102: Implement Atoi Function
 */
 class Solution {
    public int myAtoi(String s) {
        long res = 0;
        int i=0;
        boolean neg = false;
        while(i<s.length() && s.charAt(i)==' ') i++;
        if(i<s.length()){
            if(s.charAt(i)=='-') {neg = true;i++;}
            else if(s.charAt(i)=='+'){neg = false;i++;}
        }
        while(i<s.length()){
            if(res>Integer.MAX_VALUE) break;
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                res = res*10 + (c-'0');
            }
            else break;
            i++;
        }
        if(res>Integer.MAX_VALUE && neg) res = Integer.MAX_VALUE+1;
        if(res>Integer.MAX_VALUE && !neg) res = Integer.MAX_VALUE;
        
        return (int)(neg?-res:res);
    }
}

/*
Codding Ninjas:
//(Problem with java IDE)Java code was not running on codding ninjas.

#include <bits/stdc++.h> 
int atoi(string s) {
    // Write your code here.
    int n = s.length();
    bool neg=false;
    string  ans ="";
    for(int i=0; i<n; i++){
        if(s[i]=='-')neg=true;
        if(s[i]<65 && s[i]!='-'){
            ans = ans+s[i];
        }
    }
    //cout<<ans;
    if(neg==true)return -stoi(ans);
    return stoi(ans);
}
 */
