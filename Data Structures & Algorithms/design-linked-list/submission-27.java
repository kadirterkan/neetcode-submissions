class Node {
    public int val;
    public Node next;
    public Node prev;

    public Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {

    public Node head;
    public Node tail;
    public int count = 0;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if (index >= count) {
            return -1;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void test() {
        Node temp = head;
        for (int i = 0; i < count; i++) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        this.count++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        this.count++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > count) return;  // do nothing
        if (index == count) {
            addAtTail(val);         // or implement inline
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        // temp is now the node at index
        newNode.next = temp;
        newNode.prev = temp.prev;
        if (temp.prev == null) {    // inserting before head
            head = newNode;
        } else {
            temp.prev.next = newNode;
        }
        temp.prev = newNode;
        count++;
    }
    
    public void deleteAtIndex(int index) {
        if (index >= count) return;   // invalid index (including index == count)
        // Handle head deletion
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;          // list became empty
            } else {
                head.prev = null;     // new head's prev must be null
            }
            count--;
            return;
        }

        // General case: traverse to node at index
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        // Unlink the node
        temp.prev.next = temp.next;
        if (temp.next == null) {
            tail = temp.prev;         // deleted tail
        } else {
            temp.next.prev = temp.prev;
        }
        count--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */