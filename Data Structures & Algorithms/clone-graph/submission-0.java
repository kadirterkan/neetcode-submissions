/*
Definition for a Node.
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
        if (node == null) {
            return null;
        }
        Map<Node, Node> visit = new HashMap<Node, Node>();
        Node head = copyNode(node, visit);
        return head;
    }

    Node copyNode(Node node, Map<Node, Node> visit) {
        if (visit.containsKey(node)) {
            return visit.get(node);
        }
        Node newNode = new Node(node.val);
        visit.put(node, newNode);
        node.neighbors.forEach((subNode) -> newNode.neighbors.add(copyNode(subNode, visit)));
        return newNode;
    } 
}