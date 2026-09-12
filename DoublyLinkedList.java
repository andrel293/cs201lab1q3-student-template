public class DoublyLinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
    
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
    
        public E getElement(){
            return element;
        }
    
        public Node<E> getNext(){
            return next;
        }

        public Node<E> getPrev(){
            return prev;
        }
    
        public void setNext(Node<E> n){
            next = n;
        }

        public void setPrev(Node<E> p){
            prev = p;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    
    public E first(){
        if (isEmpty()){
            return null;
        } 
        return header.getNext().getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }
        return remove(header.getNext());
    }

    public E removeLast(){
        if (isEmpty()){
            return null;
        }
        return remove(trailer.getPrev());
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();

        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();        
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = header.getNext();
        while (current != trailer) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    public void group(){
        if (isEmpty()) {
            return;
        }
    
        // Step 1: find the first null node
        Node<E> firstNull = head;
        while (firstNull != null && firstNull.getElement() != null) {
            firstNull = firstNull.getNext();
        }
    
        if (firstNull == null) {
            return; // no nulls in the list, nothing to group
        }
    
        // groupTail tracks the last node currently in the "null block"
        Node<E> groupTail = firstNull;
        Node<E> cur = groupTail.getNext();
    
        while (cur != null) {
            Node<E> nextCur = cur.getNext(); // save before we unlink cur
    
            if (cur.getElement() == null) {
                // --- unlink cur from its current position ---
                Node<E> p = cur.getPrev();
                Node<E> n = cur.getNext();
    
                p.setNext(n);
                if (n != null) {
                    n.setPrev(p);
                } else {
                    tail = p; // cur was the old tail
                }
    
                // --- insert cur right after groupTail ---
                Node<E> afterGroup = groupTail.getNext();
                groupTail.setNext(cur);
                cur.setPrev(groupTail);
                cur.setNext(afterGroup);
                if (afterGroup != null) {
                    afterGroup.setPrev(cur);
                } else {
                    tail = cur; // cur becomes the new tail
                }
    
                groupTail = cur; // extend the null block
            }
    
            cur = nextCur; // continue from where we originally were
            }
        }
    }
}
