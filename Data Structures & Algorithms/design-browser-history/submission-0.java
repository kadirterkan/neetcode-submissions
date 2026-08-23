class Node {
    public Node next;
    public Node prev;
    public String url;

    public Node(String url) {
        this.url = url;
    }
}

class BrowserHistory {
    Node head;
    Node tail;

    int size;
    Node current;

    public BrowserHistory(String homepage) {
        Node newNode = new Node(homepage);
        head = newNode;
        tail = newNode;
        this.size = 1;
        current = newNode;
    }

    public void visit(String url) {
        Node visited = new Node(url);
        current.next = visited;
        visited.prev = current;
        current = visited;
    }

    public String back(int steps) {
        if (steps > 0) {
            if (current.prev != null) {
                current = current.prev;
                return back(steps-1);
            } else {
                return current.url;
            }      
        } else {
            return current.url;
        }
    }

    public String forward(int steps) {
        if (steps > 0) {
            if (current.next != null) {
                current = current.next;
                return forward(steps-1);
            } else {
                return current.url;
            }      
        } else {
            return current.url;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */