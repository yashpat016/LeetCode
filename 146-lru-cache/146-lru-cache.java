class LRUCache {

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> nodeMap;
    int cacheSize;
    
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
    }
    
    public LRUCache(int capacity) {
        nodeMap = new HashMap<>(capacity);
        this.cacheSize = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int res = -1;
        Node node = nodeMap.get(key);
        if(node != null){
            res = node.val;
            remove(node);
            add(node);
        }
        return res;
    }
    
    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if(node != null){
            node.val = value;
            remove(node);
            add(node);
        } else {
            if(nodeMap.size() == cacheSize){
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
                
            }
            Node newNode = new Node();
                newNode.key = key;
                newNode.val = value;
                
                nodeMap.put(key, newNode);
                add(newNode);
        }
    }
    
    public void add(Node node){
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public void remove(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */