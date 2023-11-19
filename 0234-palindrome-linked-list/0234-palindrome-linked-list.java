/*
Q. no. 34: Palindrome Linked List
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow =head,fast = head;
        while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
        ListNode temp = revrse(slow);
        while(temp!=null){
            if(temp.val!=head.val) return false;
            temp = temp.next;
            head = head.next;
        }
        return true;
    }
    
    public ListNode revrse(ListNode head){
        if(head==null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre =null ;
        while(cur !=null ){
            ListNode temp = cur.next; 
            cur.next = pre;
            pre=cur;
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