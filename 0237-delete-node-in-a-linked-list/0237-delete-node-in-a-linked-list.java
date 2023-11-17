/*
Q. no. 30: Delete Node in a Linked List
*/

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

/*
Codding Ninjas:

public class Solution {
	public static void deleteNode(LinkedListNode<Integer> node) {
		node.data = node.next.data;
        node.next = node.next.next;
	}
}
*/