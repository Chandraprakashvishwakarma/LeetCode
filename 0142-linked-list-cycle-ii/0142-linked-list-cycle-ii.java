/*
Q. no. 35: Linked List Cycle II
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(true){
                    if(slow == fast) return slow;
                    slow = slow.next;
                    fast = fast.next;
                    
                }
            }
        }
        return null;
    }
}

/*

Codding Ninjas:

public class Solution {
    public static Node firstNode(Node head) {
        Node s = head,f =head;
        if(f==null || f.next==null) return null;
        while(f!=null && f.next!=null){
            s = s.next;
            f =f.next.next;
            if(s == f) break;
        }
        if(f!=s) return null;
        f= head;
        while(s!=f){
            s =s.next;
            f = f.next;
        }
        return s;
    }
}
*/