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
    public void reorderList(ListNode head) {
        //use tortoise nad hare algo to fing middle of linked list
        if(head==null) return;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;

        //reverse second half
        ListNode curr=mid.next;
        mid.next=null;
        ListNode prev=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        ListNode right=prev;

         //alternate merge - zigzag merging using two pointers
        ListNode left=head;
        while(left!=null && right!=null){
            ListNode nextl=left.next;
            left.next=right;
            ListNode nextr=right.next;
            right.next=nextl;
            left=nextl;
            right=nextr;
        }
    }
}
