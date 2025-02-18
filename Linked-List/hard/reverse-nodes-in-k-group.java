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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevnode=null;
        while(temp!=null){
            ListNode kthnode=findkthnode(temp,k);
            if(kthnode==null){
                if(prevnode!=null){
                    prevnode.next=temp;
                }
                break;
            }
            ListNode nextnode=kthnode.next;
            kthnode.next=null;
            kthnode=reverse(temp);
            if(temp==head){
                head=kthnode;
            }
            else{
                prevnode.next=kthnode;
            }
            prevnode=temp;
            temp=nextnode;
        }
        return head;
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    private ListNode findkthnode(ListNode head,int k){
        ListNode temp=head;
        k=k-1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
}
