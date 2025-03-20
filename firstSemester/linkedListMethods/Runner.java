public class Runner {
    public static void main(String[] args) {

        dLinkedList list = new dLinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);

        list.insertAtStart(25);

        list.insertAt(0, 55);

        list.deleteAt(2);

        list.show();
    }
}
