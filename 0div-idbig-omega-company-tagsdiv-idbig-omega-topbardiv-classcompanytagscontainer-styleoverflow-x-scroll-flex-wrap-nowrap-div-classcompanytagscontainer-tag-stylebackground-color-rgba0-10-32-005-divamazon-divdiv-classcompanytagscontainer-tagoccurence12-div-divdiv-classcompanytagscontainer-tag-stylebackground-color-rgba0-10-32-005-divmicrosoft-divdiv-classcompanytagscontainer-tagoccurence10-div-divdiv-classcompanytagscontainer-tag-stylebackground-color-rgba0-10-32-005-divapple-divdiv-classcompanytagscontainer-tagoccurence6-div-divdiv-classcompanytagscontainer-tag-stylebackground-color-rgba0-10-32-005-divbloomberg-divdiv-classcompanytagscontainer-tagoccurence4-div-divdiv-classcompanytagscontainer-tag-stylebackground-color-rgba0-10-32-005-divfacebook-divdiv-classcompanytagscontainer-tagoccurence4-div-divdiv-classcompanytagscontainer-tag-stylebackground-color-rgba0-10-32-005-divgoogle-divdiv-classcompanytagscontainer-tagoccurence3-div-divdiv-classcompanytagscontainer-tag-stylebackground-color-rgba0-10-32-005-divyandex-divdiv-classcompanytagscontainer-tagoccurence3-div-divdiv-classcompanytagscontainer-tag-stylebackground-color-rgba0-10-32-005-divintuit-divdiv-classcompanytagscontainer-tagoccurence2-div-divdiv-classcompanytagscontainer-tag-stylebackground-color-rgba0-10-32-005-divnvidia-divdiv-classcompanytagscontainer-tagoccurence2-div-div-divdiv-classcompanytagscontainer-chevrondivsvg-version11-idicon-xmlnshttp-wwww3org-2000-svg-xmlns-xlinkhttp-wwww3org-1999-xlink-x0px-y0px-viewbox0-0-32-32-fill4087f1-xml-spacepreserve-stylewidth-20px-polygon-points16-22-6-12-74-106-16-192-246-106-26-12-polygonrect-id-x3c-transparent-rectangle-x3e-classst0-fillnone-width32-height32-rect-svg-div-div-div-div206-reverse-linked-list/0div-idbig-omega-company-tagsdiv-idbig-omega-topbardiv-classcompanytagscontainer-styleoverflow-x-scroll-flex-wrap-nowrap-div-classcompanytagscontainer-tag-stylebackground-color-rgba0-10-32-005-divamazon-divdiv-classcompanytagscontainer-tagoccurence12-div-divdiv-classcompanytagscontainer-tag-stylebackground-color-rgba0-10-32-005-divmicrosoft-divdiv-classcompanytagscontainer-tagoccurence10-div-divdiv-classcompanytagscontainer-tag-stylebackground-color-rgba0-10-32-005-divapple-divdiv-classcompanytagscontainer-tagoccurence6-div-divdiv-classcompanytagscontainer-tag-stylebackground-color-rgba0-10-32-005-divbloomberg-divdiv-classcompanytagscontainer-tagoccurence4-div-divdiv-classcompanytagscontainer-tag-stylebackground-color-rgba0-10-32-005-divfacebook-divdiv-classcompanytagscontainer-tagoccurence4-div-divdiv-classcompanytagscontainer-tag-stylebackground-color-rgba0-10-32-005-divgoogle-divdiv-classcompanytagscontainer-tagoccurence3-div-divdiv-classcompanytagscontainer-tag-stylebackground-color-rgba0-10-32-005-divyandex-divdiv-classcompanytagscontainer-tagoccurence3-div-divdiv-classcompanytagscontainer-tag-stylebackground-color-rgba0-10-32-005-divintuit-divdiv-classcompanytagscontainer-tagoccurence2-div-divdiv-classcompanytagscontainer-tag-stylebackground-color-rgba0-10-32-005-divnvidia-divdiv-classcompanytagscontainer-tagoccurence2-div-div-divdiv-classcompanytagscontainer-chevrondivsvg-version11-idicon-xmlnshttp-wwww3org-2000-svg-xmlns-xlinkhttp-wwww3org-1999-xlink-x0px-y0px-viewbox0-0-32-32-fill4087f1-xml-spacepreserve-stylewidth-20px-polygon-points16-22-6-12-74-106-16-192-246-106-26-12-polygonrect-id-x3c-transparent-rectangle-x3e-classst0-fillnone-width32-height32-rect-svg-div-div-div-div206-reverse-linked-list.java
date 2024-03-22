
/*
Q. no. 25 : Reverse Linked List
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }  
}


/*
Codding Ninjas:

import java.io.*;
import java.util.* ;

public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
		if(head==null || head.next == null) return head;
        LinkedListNode pre = null;
		while(head!=null){
			LinkedListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
		return pre;
    }
}
*/