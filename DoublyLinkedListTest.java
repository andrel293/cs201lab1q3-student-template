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
       Node<E> firstNull = null;
      Node<E> lastNull = null;
      Node<E> firstValue = null;
      Node<E> lastValue = null;
      
      while (current != trailer) {
          Node<E> next = current.getNext();
      
          if (current.getElement() == null) {
              if (firstNull == null) {
                  firstNull = current;
              } else {
                  lastNull.setNext(current);
                  current.setPrev(lastNull);
              }
              lastNull = current;
          } else {
              if (firstValue == null) {
                  firstValue = current;
              } else {
                  lastValue.setNext(current);
                  current.setPrev(lastValue);
              }
              lastValue = current;
          }
      
          current = next;
      }
      
      if (firstNull != null) {
          header.setNext(firstNull);
          firstNull.setPrev(header);
      
          if (firstValue != null) {
              lastNull.setNext(firstValue);
              firstValue.setPrev(lastNull);
      
              lastValue.setNext(trailer);
              trailer.setPrev(lastValue);
          } else {
              lastNull.setNext(trailer);
              trailer.setPrev(lastNull);
          }
      } else if (firstValue != null) {
          header.setNext(firstValue);
          firstValue.setPrev(header);
      
          lastValue.setNext(trailer);
          trailer.setPrev(lastValue);
      } else {
          header.setNext(trailer);
          trailer.setPrev(header);
      }
}
