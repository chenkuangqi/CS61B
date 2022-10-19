package deque;


import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedListDeque<Item> implements Iterable<Item> {
    private Item[] items;

    private int size;

    private class Node {
        public Item items;
        public Node prev;
        public Node next;
        public Node(Item i, Node p, Node n){
            items = i;
            next = n;
            prev = p;
        }
    }

    private Node sentinel;


    /** Creates an empty deque. */
    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    public LinkedListDeque(Item x){
        size = 1;
        sentinel = new Node(null,null,null);
        Node node = new Node(x,sentinel,sentinel);
        sentinel.next = node;
        sentinel.prev = node;
    }

    public void addFirst(Item x){
        Node newNode = new Node(x,sentinel,sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size +=1;
    }

    public void addLast(Item x){
        Node newNode = new Node(x,sentinel.prev,sentinel);
        sentinel.prev.next  = newNode;
        sentinel.prev = newNode;
        size +=1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if (this.sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    public Item get(int index){
        Node tempNode = sentinel;
        for (int i = 0; i <= index; i ++){
            tempNode = tempNode.next;
        }
        return tempNode.items;
    }
    public void printDeque(){
        Node tempNode = sentinel;
        while (tempNode.next != sentinel){
            System.out.print(tempNode.next.items);
            System.out.print(" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public Item removeFirst(){
        if (this.size() == 0){
            return null;
        }
        Item deleteItem = sentinel.next.items;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev.prev = null;
        sentinel.next.prev.next = null;
        sentinel.next.prev = sentinel;
        size -=1;
        return deleteItem;
    }

    public Item removeLast(){
        if (isEmpty()){
            return null;
        }

        Item deleteItem = sentinel.prev.items;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next.next = null;
        sentinel.prev.next.prev = null;
        sentinel.prev.next = sentinel;
        size -=1;
        return deleteItem;

    }

    /*Iterator*/
    public Iterator<Item> iterator(){
        return new LinkedListIterator();
    }


    private class LinkedListIterator implements Iterator<Item> {
        private int wizPos;
        public LinkedListIterator(){
            wizPos = 0;
        }

        public boolean hasNext(){
            return wizPos <size;
        }

        public Item next(){
            Item returnItem = items[wizPos];
            wizPos +=1;
            return returnItem;
        }

//        public void forEachRemaining(Consumer<? super Item> action) {
//            Iterator.super.forEachRemaining(action);
    }

    @Override
    public boolean equals(Object x){
        if (this == x) {return true; }
        if (x instanceof LinkedListDeque oas) {
            if (oas.size != this.size){
                return false;
            }

            for (int i =0; i < size; i++) {
                if (oas.get(i) != this.get(i)){
                    return false;
                }
            }
        }
        return true;
    }









    public static void main(String[] args){
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        lld1.addFirst("front");
        lld1.addFirst("2");
        lld1.addFirst("3");
        lld1.addFirst("4");
        lld1.addLast("5");
        System.out.println(lld1.get(4));
        System.out.println(lld1.get(0));
        lld1.printDeque();
        System.out.println(lld1.size());
        String delete1 = lld1.removeFirst();
        System.out.println(delete1);
        lld1.printDeque();
        lld1.addFirst("4");
        lld1.addLast("5");
        System.out.println(lld1.get(4));
        System.out.println(lld1.get(0));
        lld1.printDeque();
        String delete2 = lld1.removeLast();
        System.out.println(delete2);
        lld1.printDeque();
        LinkedListDeque<String> lld3 = new LinkedListDeque<String>();
        lld3.addFirst("front");
        lld3.addFirst("2");
        lld3.addFirst("3");
        lld3.addFirst("4");
        lld3.addLast("5");
        LinkedListDeque<String> lld2 = new LinkedListDeque<String>();
        lld2.addFirst("front");
        lld2.addFirst("2");
        lld2.addFirst("3");
        lld2.addFirst("4");
        lld2.addLast("5");
//        lld2.removeFirst();
        System.out.println(lld2);
        System.out.println(lld3);
        System.out.println(lld2.equals(lld3));

    }
}


