/* 
Q. no. 100: Longest Palindromic Substring

Intution : 1) Check if substring len is max then  
2) If max len of pal is EVEN then check from middle 2 element and 
try to expand outward untill you get non equal character.
3) If max len of pal is ODD then check from middle element and 
try to expand outward untill you get non equal character.
*/
class Solution {
    public String longestPalindrome(String str) {
        String res = "";
		int maxLen=0;
		for(int i=0;i<str.length();i++){
			//Odd
			int l = i,r = i;
			while(l>=0 && r<str.length() && str.charAt(l)==str.charAt(r)){
				if(r-l+1>maxLen){
					res = str.substring(l,r+1);
					maxLen = res.length();
				}
				l--;r++;
			}
			//Even
			l = i;r =i+1;
			while(l>=0 && r<str.length() && str.charAt(l)==str.charAt(r)){
				if(r-l+1>maxLen){
					res = str.substring(l,r+1);
					maxLen = res.length();
				}
				l--;r++;
			}
		}
		return res;
    }
}

/*
Codding Ninjas:

public class Solution {	
	public static String longestPalinSubstring(String str) {
		// Write your code here.
		String res = "";
		int maxLen=0;
		for(int i=0;i<str.length();i++){
			//Odd
			int l = i,r = i;
			while(l>=0 && r<str.length() && str.charAt(l)==str.charAt(r)){
				if(r-l+1>maxLen){
					res = str.substring(l,r+1);
					maxLen = res.length();
				}
				l--;r++;
			}
			//Even
			l = i;r =i+1;
			while(l>=0 && r<str.length() && str.charAt(l)==str.charAt(r)){
				if(r-l+1>maxLen){
					res = str.substring(l,r+1);
					maxLen = res.length();
				}
				l--;r++;
			}
		}
		return res;
	}
}
*/