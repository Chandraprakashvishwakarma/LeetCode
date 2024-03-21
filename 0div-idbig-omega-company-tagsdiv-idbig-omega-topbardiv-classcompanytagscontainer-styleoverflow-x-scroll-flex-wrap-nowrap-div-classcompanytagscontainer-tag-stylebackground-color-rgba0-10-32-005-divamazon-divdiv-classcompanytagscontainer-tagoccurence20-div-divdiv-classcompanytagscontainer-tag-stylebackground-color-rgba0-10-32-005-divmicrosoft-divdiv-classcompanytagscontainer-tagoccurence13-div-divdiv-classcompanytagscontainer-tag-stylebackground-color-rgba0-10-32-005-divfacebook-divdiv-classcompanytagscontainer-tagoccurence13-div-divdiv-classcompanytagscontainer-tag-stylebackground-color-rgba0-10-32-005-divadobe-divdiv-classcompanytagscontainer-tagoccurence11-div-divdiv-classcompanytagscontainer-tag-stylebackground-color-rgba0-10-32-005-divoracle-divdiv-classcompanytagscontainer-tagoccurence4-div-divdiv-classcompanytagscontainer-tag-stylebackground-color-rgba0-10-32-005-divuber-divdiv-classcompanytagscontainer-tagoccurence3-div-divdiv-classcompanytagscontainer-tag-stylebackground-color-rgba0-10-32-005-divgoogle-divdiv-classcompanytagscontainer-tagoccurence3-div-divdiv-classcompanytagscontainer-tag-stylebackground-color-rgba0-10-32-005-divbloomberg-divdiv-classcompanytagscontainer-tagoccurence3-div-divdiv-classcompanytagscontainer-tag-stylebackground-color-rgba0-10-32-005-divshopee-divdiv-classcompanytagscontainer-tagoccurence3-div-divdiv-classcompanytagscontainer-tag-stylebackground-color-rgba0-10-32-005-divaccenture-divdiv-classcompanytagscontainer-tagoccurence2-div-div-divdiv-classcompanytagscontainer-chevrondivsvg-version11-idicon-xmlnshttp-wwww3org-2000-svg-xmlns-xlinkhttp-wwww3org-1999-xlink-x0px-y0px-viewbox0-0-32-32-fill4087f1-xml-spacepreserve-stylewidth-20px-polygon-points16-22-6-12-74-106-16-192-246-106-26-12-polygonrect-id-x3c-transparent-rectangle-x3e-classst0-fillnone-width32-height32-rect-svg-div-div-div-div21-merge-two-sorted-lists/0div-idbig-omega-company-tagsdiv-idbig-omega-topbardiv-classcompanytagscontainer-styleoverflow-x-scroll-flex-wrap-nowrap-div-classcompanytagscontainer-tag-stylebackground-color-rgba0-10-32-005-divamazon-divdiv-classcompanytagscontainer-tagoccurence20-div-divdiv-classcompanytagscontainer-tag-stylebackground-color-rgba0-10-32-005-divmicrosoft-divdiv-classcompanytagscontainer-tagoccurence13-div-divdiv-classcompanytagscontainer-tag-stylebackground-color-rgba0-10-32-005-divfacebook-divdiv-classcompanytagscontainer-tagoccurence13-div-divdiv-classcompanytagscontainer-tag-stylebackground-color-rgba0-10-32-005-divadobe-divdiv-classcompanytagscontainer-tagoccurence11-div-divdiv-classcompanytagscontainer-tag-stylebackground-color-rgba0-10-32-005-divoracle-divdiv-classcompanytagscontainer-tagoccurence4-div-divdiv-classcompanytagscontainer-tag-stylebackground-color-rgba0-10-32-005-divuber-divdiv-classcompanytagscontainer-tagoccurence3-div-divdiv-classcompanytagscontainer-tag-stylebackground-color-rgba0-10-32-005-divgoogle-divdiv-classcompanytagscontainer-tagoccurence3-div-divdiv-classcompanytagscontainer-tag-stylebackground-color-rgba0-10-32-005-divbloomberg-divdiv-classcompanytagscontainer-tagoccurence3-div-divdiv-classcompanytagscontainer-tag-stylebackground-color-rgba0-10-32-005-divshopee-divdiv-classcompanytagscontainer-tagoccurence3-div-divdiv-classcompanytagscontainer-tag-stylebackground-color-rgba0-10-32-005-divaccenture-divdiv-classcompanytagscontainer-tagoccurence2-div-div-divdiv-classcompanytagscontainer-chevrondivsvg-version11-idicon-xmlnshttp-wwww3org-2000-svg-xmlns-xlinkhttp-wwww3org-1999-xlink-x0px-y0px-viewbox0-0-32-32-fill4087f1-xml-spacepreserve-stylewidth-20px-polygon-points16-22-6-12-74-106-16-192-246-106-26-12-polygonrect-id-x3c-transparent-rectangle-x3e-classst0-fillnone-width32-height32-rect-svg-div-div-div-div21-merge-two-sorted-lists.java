/*
Q. no. 27 : Merge Two Sorted Lists
*/
class Solution {
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode h1 = new ListNode(-1);
        h1.next = p1;
        ListNode h2 = h1;
        while(p1!=null && p2!=null){
            if(p1.val<p2.val) {
                h2.next = p1;
                p1 = p1.next;
                h2 = h2.next;
            }
            else {
                h2.next = p2;
                p2 = p2.next;
                h2 = h2.next;
            }
        }
        if(p1!=null) h2.next = p1;
        if(p2!=null) h2.next = p2;
        return h1.next;
    }
}

/*
Codding Ninjas: 

import java.io.*;
import java.util.* ;

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		
        if(first==null) return second;
        if(second==null) return first;
        LinkedListNode temp = new LinkedListNode(-1);
        LinkedListNode cur = temp;
        temp.next = cur;
        while(first!=null && second!=null){
            if(first.data<=second.data){
                cur.next = first;
                first = first.next;
            }
            else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        if(first!=null) cur.next = first;
        else if(second!=null) cur.next = second;
        return temp.next;
	}
}

*/