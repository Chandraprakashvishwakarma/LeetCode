/*
Q. no. 32: Linked List Cycle
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head,slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}

/*

Codding Ninjas:

public class Solution {
    public static boolean detectCycle(Node head) {
        Node slow = head,fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}

*/