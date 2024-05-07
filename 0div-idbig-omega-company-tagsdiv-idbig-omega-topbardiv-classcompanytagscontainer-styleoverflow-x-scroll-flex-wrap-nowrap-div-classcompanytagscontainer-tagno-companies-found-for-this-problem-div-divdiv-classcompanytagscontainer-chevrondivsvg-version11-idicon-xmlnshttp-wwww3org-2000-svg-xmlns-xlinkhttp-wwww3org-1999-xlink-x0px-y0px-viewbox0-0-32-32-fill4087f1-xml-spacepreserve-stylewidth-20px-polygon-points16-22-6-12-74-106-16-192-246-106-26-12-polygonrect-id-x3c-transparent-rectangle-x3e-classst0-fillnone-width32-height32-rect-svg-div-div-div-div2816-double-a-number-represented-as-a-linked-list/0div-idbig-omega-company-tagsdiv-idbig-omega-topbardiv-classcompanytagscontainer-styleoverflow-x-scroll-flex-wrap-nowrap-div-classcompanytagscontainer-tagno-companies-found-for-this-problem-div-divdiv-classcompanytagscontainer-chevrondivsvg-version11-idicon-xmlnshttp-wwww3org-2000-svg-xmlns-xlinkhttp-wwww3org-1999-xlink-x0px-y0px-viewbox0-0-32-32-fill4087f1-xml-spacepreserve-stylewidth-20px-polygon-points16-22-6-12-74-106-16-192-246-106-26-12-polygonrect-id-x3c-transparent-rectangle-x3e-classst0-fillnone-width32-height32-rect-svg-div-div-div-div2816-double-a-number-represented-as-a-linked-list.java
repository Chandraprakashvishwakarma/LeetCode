/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        int carry = getCarry(head);
        ListNode temp;
        if(carry!=0) {
            temp = new ListNode(carry);
            temp.next = head;
            return temp;
        }
        return head;
    }  
    
    public int getCarry(ListNode head){
        if(head == null) return 0;
        
        int carry = getCarry(head.next);
        carry+=2*head.val;
        head.val = carry%10;
        return carry/10;
    }
}