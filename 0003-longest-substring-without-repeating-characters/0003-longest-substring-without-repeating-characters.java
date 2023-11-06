/*
Q. no. 24 : Longest Substring Without Repeating Characters
*/
//Best Approch(solution) time:O(N) space: O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 1 ) return 0;
        Set<Character> set = new HashSet<>();
        int i=0,j=0;
        int max = 0;
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                max = Math.max(j-i+1,max);
                set.add(s.charAt(j++));
            }
            else while(set.contains(s.charAt(j))) set.remove(s.charAt(i++));
        }
        return max;
    }
}

/*
Codding Ninjas: time:O(2N) space: O(N)

import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
		HashSet<Character> set = new HashSet<>();
		int i=0,j=0,max=0;
		while(j<input.length()){
			if(!set.contains(input.charAt(j))){
				max = Math.max(max,j-i+1);
				set.add(input.charAt(j++));
			}
			else {
				while(set.contains(input.charAt(j))){
					set.remove(input.charAt(i++));
				}
			}
		}
		return max;
	}
}

*/