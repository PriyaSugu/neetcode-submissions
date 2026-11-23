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
        Node dummy = new Node(0);
        Node curr = head;
        Node nPre = dummy;
        HashMap<Node, Node> map = new HashMap<>();

        while(curr != null){
            Node node = new Node(curr.val);
            map.put(curr, node);
            nPre.next = node;
            nPre = node;
            curr = curr.next;
        }

        curr = head;
        Node nCurr = dummy.next;
        while(curr != null){
            Node node = map.get(curr.random);
            nCurr.random = node;
            curr = curr.next;
            nCurr = nCurr.next;
        }

        return dummy.next;

    }
}
