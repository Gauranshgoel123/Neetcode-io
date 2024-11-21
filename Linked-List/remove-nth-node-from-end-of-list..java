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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            l++;
        }
        int p=l-n;

        if(l==1 && n==1) return null;
        if(p==0){
            return removebeg(head);
        }

        ListNode newcurr=head;
        int count=0;
        while(newcurr!=null){
            count++;
            if(count==p){
                ListNode ptr=newcurr;
                ListNode temp=ptr.next;
                ptr.next=temp.next;
            }
            newcurr=newcurr.next;
        }
        return head;
    }
    private ListNode removebeg(ListNode head){
        ListNode curr=head;
        head=curr.next;
        return head;
    }
}
