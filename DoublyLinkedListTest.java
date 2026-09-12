//test

public class DoublyLinkedListTest {
   public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
         
        dll.addFirst(2);
        dll.addFirst(null);
        dll.addFirst(1);
        System.out.println("Before Group :");
        display(dll);
        dll.group();
        System.out.println("After Group :");
        display(dll);
        System.out.println("------------------------");

        dll = new DoublyLinkedList<Integer>();
        dll.addFirst(3);
        dll.addFirst(null);
        dll.addFirst(1);
        dll.addFirst(null);
        dll.addFirst(4);
        System.out.println("Before Group :");
        display(dll);
        dll.group();
        System.out.println("After Group :");
        display(dll);
        System.out.println("------------------------");
   }    

   public static <E> void display(DoublyLinkedList<E> dll){
      System.out.println("Linked List : " + dll);
      System.out.println("First Element : " + dll.first());
      System.out.println("Last Element : " + dll.last());
      System.out.println();
     }

    public void group() {
    if (isEmpty()) {
        return;
    }

    Node<E> firstNull = head;
    while (firstNull != null && firstNull.getElement() != null) {
        firstNull = firstNull.getNext();
    }

    if (firstNull == null) {
        return; 
    }

    Node<E> groupTail = firstNull;
    Node<E> cur = groupTail.getNext();

    while (cur != null) {
        Node<E> nextCur = cur.getNext(); 

        if (cur.getElement() == null) {
            Node<E> p = cur.getPrev();
            Node<E> n = cur.getNext();

            p.setNext(n);
            if (n != null) {
                n.setPrev(p);
            } else {
                tail = p;
            }

            Node<E> afterGroup = groupTail.getNext();
            groupTail.setNext(cur);
            cur.setPrev(groupTail);
            cur.setNext(afterGroup);
            if (afterGroup != null) {
                afterGroup.setPrev(cur);
            } else {
                tail = cur; 

            groupTail = cur; 
        }

        cur = nextCur; 
    }
}
}
