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
    public ListNode oddEvenList(ListNode head) {
        if(head==null ||head.next==null || head.next.next==null) return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode firsteven=head.next;
        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next; 
        }
        odd.next=firsteven;
        return head;        
    }
}
//even pointer will always be ahead of odd so in while condition only even case is checked
