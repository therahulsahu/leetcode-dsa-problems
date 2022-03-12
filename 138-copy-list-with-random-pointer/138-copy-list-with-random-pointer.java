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
        
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            Node rand = new Node(head.val);
            rand = head.random == null ? null : rand;
        }
        
        Node newHead = new Node(head.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(head, newHead);
        
        Node itr = newHead;
        Node temp = head.next;
        
        while(temp != null) {
            itr.next = new Node(temp.val);
            map.put(temp, itr.next);
            temp = temp.next;
            itr = itr.next;
        }
        
        temp = head;
        itr = newHead;
        
        while(temp != null) {
            if(temp.random == null) {
                itr.random = null;
            } else {
                itr.random = map.get(temp.random);
            }
            temp = temp.next;
            itr = itr.next;
        }   
        return newHead;
    }
}


