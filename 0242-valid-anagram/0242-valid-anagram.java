/*
Q. no. 104: Valid Anagram
*/
class Solution {
    public boolean isAnagram(String str1, String str2) {
        if(str1.length()!=str2.length()) return false;
        int arr [] = new int [26];
        for(int i =0;i<str1.length();i++){
            arr[str1.charAt(i)-'a']++;
            arr[str2.charAt(i)-'a']--;
        }
        for(int i:arr) if(i!=0) return false;
        return true;
    }
}

/*
Codding Ninjas:

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean areAnagram(String str1, String str2){
        if(str1.length()!=str2.length()) return false;
        int arr [] = new int [26];
        for(int i =0;i<str1.length();i++){
            arr[str1.charAt(i)-'a']++;
            arr[str2.charAt(i)-'a']--;
        }
        for(int i:arr) if(i!=0) return false;
        return true;
    }
}
*/