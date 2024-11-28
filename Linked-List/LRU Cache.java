class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key,int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}

class LRUCache {

    private int cap;
    private HashMap<Integer,Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap=capacity;
        this.cache=new HashMap<>();
        this.left=new Node(0,0);
        this.right=new Node(0,0);
        this.left.next=this.right;
        this.right.prev=this.left;        
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }        
        Node newnode=new Node(key,value);
        cache.put(key,newnode);
        insert(newnode);
        
        if(cache.size()>cap){
            Node lru=this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    //insert at right most i.e most recently used 
    private void insert(Node node){
        Node prev=this.right.prev;
        prev.next=node;
        node.prev=prev;
        node.next=this.right;
        this.right.prev=node;

    }

    //remove from the left i.e least recently used
    private void remove(Node node){
        Node prev=node.prev;
        Node next=node.next;
        prev.next=next;
        next.prev=prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
