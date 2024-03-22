/*
Q. no. 26 : Middle of the Linked List
*/
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

/*
Codding Ninjas :

public class Solution
{
    public static Node findMiddle(Node head)
    {
        Node slow =head,fast =head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

*/