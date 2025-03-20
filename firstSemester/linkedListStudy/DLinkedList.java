

public class DLinkedList {
    Node head;

    public void addFirst(int num) {
        if (head == null) head = new Node(num, null, null);
        else {
            Node newNode = new Node(num, head, null);
            head.prev = newNode;
            head = newNode;
        }
    }

    public void remove(int n) {
        if (head == null || n < 0) return;

        Node current = head;
        int index = 0;

        while (current != null && index < n) {
            current = current.next;
            index++;
        }

        if (current == null) {
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }

    public void duplicate(int n) {
        if (head == null || n < 0) return;

        Node current = head;
        int index = 0;

        while (current != null && index < n) {
            current = current.next;
            index++;
        }

        if (current == null) return;

        Node duplicateNode = new Node(current.data, current.next, current);

        if (current.next != null) {
            current.next.prev = duplicateNode;
        }

        current.next = duplicateNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DLinkedList dlist = new DLinkedList();

        dlist.addFirst(30);
        dlist.addFirst(20);
        dlist.addFirst(10);

        System.out.println("Original list: ");
        dlist.printList();

        dlist.remove(1);
        System.out.println("After removing the second node: ");
        dlist.printList();

        dlist.duplicate(0);
        System.out.println("After duplicating the first node: ");
        dlist.printList();
    }
}
