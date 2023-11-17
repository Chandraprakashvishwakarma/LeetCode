/*
Q. no. 29: Add Two Numbers(LinkedList)
*/

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int carry = 0;
      ListNode head = new ListNode(-1);
      ListNode n = head;
      while(l1!=null || l2!=null || carry!=0){
          if(l1!=null) {
              carry+=l1.val;
              l1=l1.next;
          }
          if(l2!=null) {
              carry+=l2.val;
              l2=l2.next;
          }
          ListNode temp = new ListNode(carry%10);
          n.next = temp;
          n = n.next;
          carry = carry/10;
      }
      if(carry>0){
          ListNode temp = new ListNode(carry%10);
          n.next = temp;
          n = n.next;
          carry = carry/10;
      }
      return head.next;
  }
}


/*

// Second approach with time : O(M+N) space : O(1)
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode head = l1, preL1 = null, preL2 = null;
    while (l1 != null && l2 != null) {
      carry = carry + l1.val + l2.val;
      if (carry > 9) {
        l1.val = carry % 10;
      } else {
        l1.val = carry;
      }
      carry = carry / 10;
      preL1 = l1;
      l1 = l1.next;
      l2 = l2.next;
    }
    if (l1 != null) {
      while (l1 != null) {
        carry += l1.val;
        if (carry > 9) {
          l1.val = carry % 10;
        } else {
          l1.val = carry;
        }
        carry = carry / 10;
        preL1 = l1;
        l1 = l1.next;
      }
      if (carry != 0) {
        ListNode temp = new ListNode(carry);
        preL1.next = temp;
      }
    } else if (l2 != null) {
      preL1.next = l2;
      while (l2 != null) {
        carry += l2.val;
        if (carry > 9) {
          l2.val = carry % 10;
        } else {
          l2.val = carry;
        }
        carry = carry / 10;
        preL2 = l2;
        l2 = l2.next;
      }
      if (carry != 0) {
        ListNode temp = new ListNode(carry);
        preL2.next = temp;
      }
    } else {
      if (carry != 0) {
        ListNode temp = new ListNode(carry);
        preL1.next = temp;
      }
    }
    return head;
  }
}


Codding Ninjas:

Note : Java code was not getting accepted in Codding ninjas IDE


void insertAtTail(Node* &head,Node* &tail,int digit)
{
    Node* temp=new Node(digit);
    if(head==NULL)
    {
        head=temp;
        tail=temp;
        return;
    } 
    else {
      tail->next = temp;
      tail = temp;
    }
}
Node* add(Node* first,Node* second)
{
    Node* head=NULL;
    Node* tail=NULL;
    int carry=0;

    while(first != NULL || second != NULL || carry !=0)
    {
        int val1=0,val2=0;
        if(first != NULL)
         val1=first->data;
        if(second != NULL)
         val2=second->data;
        
        int sum= carry+ val1 + val2;

        int digit=sum%10;

        insertAtTail(head,tail,digit);
        carry=sum/10;
        if(first != NULL)
         first=first->next;
        if(second != NULL)
         second=second->next;
    }
    return head;
}
Node *addTwoNumbers(Node *num1, Node *num2)
{
    return add(num1,num2);
}

*/


