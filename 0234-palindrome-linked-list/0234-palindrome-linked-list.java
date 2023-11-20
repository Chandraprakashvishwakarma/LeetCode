/*
Q. no. 34: Palindrome Linked List
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode s = head,f=head;
        while(f.next!=null && f.next.next!=null) {
            s = s.next;
            f = f.next.next;
        }
        s.next = reverse(s.next);
        s = s.next;
        f = head;
        while(s!=null){
            if(f.val!=s.val) return false;
            f= f.next;
            s=s.next;
        }
        return true;
    }
    public ListNode reverse(ListNode cur){
        ListNode pre = null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

/*
Codding Ninjas:

public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		LinkedListNode dummy  = new LinkedListNode(0);dummy.next = head;
		LinkedListNode slow = dummy, fast = dummy;
		
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		slow.next = reverse(slow.next);
		slow = slow.next;
		while(slow!=null){
			if((slow.data).equals(head.data)){
				slow= slow.next;
				head = head.next;
			}
			else return false;
		}
		return true;
	}
	public static LinkedListNode reverse(LinkedListNode head){
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