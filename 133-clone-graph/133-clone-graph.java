/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        if(node.neighbors.size() == 0) {
            return new Node(node.val);
        }
        
        Node copyNode = new Node(node.val, new ArrayList<>());
        
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, copyNode);
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()) {
            Node polled = queue.poll();
            
            for(Node neighbor: polled.neighbors) {
                if(!map.containsKey(neighbor)) {
                    Node copyNeighbor = new Node(neighbor.val, new ArrayList<>());
                    map.put(neighbor, copyNeighbor);
                    queue.add(neighbor);
                }
                map.get(polled).neighbors.add(map.get(neighbor));
            }
        }
        return copyNode;
    }
}