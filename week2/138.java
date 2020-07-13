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
        if (head == null) {
            return head;
        }
        Node dummy = new Node(0), cur = dummy;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node node = map.get(head);
            if (node == null) {
                node = new Node(head.val);
                map.put(head, node);
            }
            if (head.next != null) {
                Node nextNode = map.get(head.next);
                if (nextNode == null) {
                    nextNode = new Node(head.next.val);
                    map.put(head.next, nextNode);
                }
                node.next = nextNode;
            }
            if (head.random != null) {
                Node randomNode = map.get(head.random);
                if (randomNode == null) {
                    randomNode = new Node(head.random.val);
                    map.put(head.random, randomNode);
                }
                node.random = randomNode;
            }
            cur.next = node;
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }

    // Time = O(n)
    // Space = O(n)

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return head;
        }
        
        Node cur = head;
        while (cur != null) {
            Node nextNode = cur.next;
            Node copyNode = new Node(cur.val);
            cur.next = copyNode;
            copyNode.next = nextNode;
            cur = nextNode;
        }
        
        cur = head;
        while (cur != null && cur.next != null) {
            Node copyNode = cur.next;
            Node nextNode = copyNode.next;
            if (cur.random != null) {
                copyNode.random = cur.random.next;
            }
            cur = nextNode;
        }

        cur = head;
        Node newHead = head.next;
        Node copy = newHead;
        while (copy.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;

            copy.next = copy.next.next;
            copy = copy.next;
        }
        cur.next = null;
        return newHead;
    }
    // Time = O(n)
    // Space = O(1)
}