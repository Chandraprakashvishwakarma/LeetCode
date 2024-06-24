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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode h = head,pre = dummy;
        int last = -110;
        while(h!=null){
            if(h.val == last){
                h = h.next;
                pre.next = h;
            }
            else if(h.next!=null && h.val == h.next.val){
                last = h.val;
                h.next = h.next.next;
            }
            else {
                pre = h;
                h = h.next;
            }
        }
        return dummy.next;
    }
}