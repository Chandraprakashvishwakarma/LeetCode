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
    public ListNode reverseBetween(ListNode head, int l, int r) {
        if(head == null) return head;
        ListNode d1 = new ListNode(0);
        d1.next = head;
        ListNode pre = d1,cur=d1,nxt=cur.next;
        for(int i=0;i<l;i++){
            pre = cur;
            cur = cur.next;
            nxt = nxt.next;
        }
         ListNode dummy = pre;
        for(int i=0;i<r-l;i++){
            pre=dummy.next;
            cur.next=nxt.next;
            dummy.next=nxt; 
            nxt.next = pre;
            nxt=cur.next;
        }
        return d1.next;
    }
}