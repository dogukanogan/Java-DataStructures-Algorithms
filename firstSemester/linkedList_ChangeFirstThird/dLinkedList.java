public class dLinkedList {
    Node head;

    public void changeFirstThird() {
        Node first = head;
        Node second = head.next;

        head = second.next;
        head.next = first.next;
        second.next = first;
    }

    public static void main(String[] args) {
        dLinkedList listl = new dLinkedList();

        listl = {"1", "2", "3", "4"};
    }
}
