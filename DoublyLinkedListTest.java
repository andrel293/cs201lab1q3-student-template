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

     public void group(DoublyLinkedList<E> dll){

          if (dll.isEmpty()){
               return;
          }

          E nullPtr = head;

          while (nullPtr.getElement() != null){
               nullPtr = nullPtr.getNext();
          }

          E nxtNull = nullPtr.getNext();

          while (nxtNull != null){

               if (nxtNull.getElement() == null){
                    E prev = nxtNull.getPrev();
                    E nxt = nxtNull.getNext();
                    prev.setNext(nxt);
               }

               nxtNull = nxtNull.getNext();
               E prev = nxtNull.get

          }

          return;

     }
}
