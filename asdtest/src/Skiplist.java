public class Skiplist {
    public Node head;
    public Node tail;

    public Skiplist() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        Node current = head;
        int counter = 0;
        while (current != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot remove from empty list");
        }
        if (head.next == null) {
            head = null;
            return;
        }
        head.next.prev = null;
        head = head.next;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot remove from empty list");
        }
        if (tail.prev == null) {
            head = null;
            return;
        }
        tail.prev.next = null;
        tail = tail.prev;

    }

    public void insert(int index, int data) {
        // doesn't work with ind = 0 and ind = list.len - 1
        Node current = head;
        int counter = 0;
        while (current != null && counter < index) {
            current = current.next;
            counter++;
        }
        Node newNode = new Node(data);
        current.prev.next = newNode;
        newNode.prev = current.prev;
        current.prev = newNode;
        newNode.next = current;
    }
    public void getByIndex(int index, int data) {
        Node current = head;
        int counter = 0;
        while (current != null && counter < index) {
            current = current.next;
            counter++;
        }
        Node newNode = new Node(data);
        current.prev.next = newNode;
        newNode.prev = current.prev;
        current.prev = newNode;
        newNode.next = current;
    }


    public void removeByIndex(int index) {
        Node current = head;
        int counter = 0;
        while (current != null && counter < index) {
            current = current.next;
            counter++;
        }
        if (current == null && counter <= index)
            throw new IndexOutOfBoundsException("Incorrect index");
        if ((current != null ? current.prev : null) == null) {
            removeFirst();
            return;
        }
        if (current.next == null) {
            removeLast();
            return;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }




    public void set(int index, int data) {
        removeByIndex(index);
        insert(index, data);
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}