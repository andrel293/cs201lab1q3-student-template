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
       Node<E> lastNull = header;
       Node<E> current = header.getNext();
   
       while (current != trailer) {
           Node<E> next = current.getNext();
   
           if (current.getElement() == null) {
               if (current.getPrev() != lastNull) {
                   current.getPrev().setNext(current.getNext());
                   current.getNext().setPrev(current.getPrev());
   
                   Node<E> after = lastNull.getNext();
   
                   lastNull.setNext(current);
                   current.setPrev(lastNull);
                   current.setNext(after);
                   after.setPrev(current);
               }
   
               lastNull = current;
           }
   
           current = next;
       }
   }
}
