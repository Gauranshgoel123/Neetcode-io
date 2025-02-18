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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow=head;
        //start fast from one step ahead
        //so that slow pointers tops just before mid
        //preventing otherwise more linear traversals of LL to get to prev of mid 
        ListNode fast=head.next.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //slow just points to the prev of mid since we started fast pointer from one step ahead
        slow.next=slow.next.next;
        return head;
   }
}





BRUTE FORCE

  
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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null) return null;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        int len=0;
        ListNode h=head;
        while(h!=null){
            h=h.next;
            len++;
        }
        ListNode mid;
        if(len%2==0){
            mid=slow.next;
        }
        else{
            mid=slow;
        }
        ListNode curr=head;
        if(curr==mid) return curr.next;
        while(curr.next!=mid){
            curr=curr.next;
        }
        ListNode temp=mid.next;
        curr.next=temp;
        return head;
    }
}
