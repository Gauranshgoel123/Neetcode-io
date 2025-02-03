/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        Node curr=head;
        //cloning nodes and putting in map
        while(curr!=null){
            Node copynode=new Node(curr.val);
            map.put(curr,copynode);
            curr=curr.next;
        }
        //now setting pointers
        curr=head;
        while(curr!=null){
            Node copy=map.get(curr);
            copy.next=map.get(curr.next);
            copy.random=map.get(curr.random);
            curr=curr.next;
        }
        return map.get(head);
    }
}

/*
1 loop. copy of each node and hashmap of old node to new node
2 loop. link the new nodes together (next)
        and link their random ptrs using hashmap O(1) lookup
*/

