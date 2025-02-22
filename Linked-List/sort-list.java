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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode middle=findmiddle(head);
        ListNode righthead=middle.next;
        ListNode lefthead=head;
        middle.next=null;
        lefthead=sortList(lefthead);
        righthead=sortList(righthead);
        return merge(lefthead,righthead);
    }
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode();
        ListNode tail=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next=l1;
                l1=l1.next;
            }
            else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        if(l1==null){
            tail.next=l2;
        }
        if(l2==null){
            tail.next=l1;
        }
        return dummy.next;
    }
    private ListNode findmiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
