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
        head = reverseList(head);
        ListNode h = head;
        int carry = 0;
        ListNode pre = null;
        while(h!=null || carry!=0){
            if(h!=null){
                carry += h.val*2;
                h.val = carry%10;
                pre = h;
                h = h.next;
            }
            else if(carry!=0){
                ListNode temp = new ListNode(carry);
                pre.next = temp;
            }
            carry/=10;
        }
        return reverseList(head);
    }
    
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