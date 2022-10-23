package bstmap;
import java.util.Set;
import java.util.Iterator;
import java.util.function.Consumer;

public class BSTMap<K extends Comparable<K> , V> implements Map61B<K, V>, Iterable<K> {

    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int size;

        public Node ( K key, V val, int size){
            this.key = key;
            this.val = val;
            this.size =size;
        }
    }
    public BSTMap(){
        root = null;
    }

    public void clear(){
        root = null;
    }

    public V get(K key){
        return get(root, key);
    }

    private V get(Node x, K key){
//        if (key == null) throw new  IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp<0) {
            return get(x.left, key);
        }
        else if (cmp>0) {
            return get(x.right, key);
        }
        else return x.val;
    }

    public boolean containsKey(K key){
//        if (key == null) {
//            throw new  IllegalArgumentException("calls containsKey() with a null key");
//        }
        if (get(key)!= null){
            return true;
        }
        return false;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x == null) return 0;
        return x.size;
    }

    public Iterator<K> iterator(){
        return new BSTMapIterator();
    }


    private class BSTMapIterator implements Iterator<K> {


        public BSTMapIterator(){

        }



        public boolean hasNext(){
            return true;
        }

        public K next(){

            return null;
        }

        @Override
        public void forEachRemaining(Consumer<? super K> action) {
            Iterator.super.forEachRemaining(action);
        }

//        public void forEachRemaining(Consumer<? super Item> action) {
//            Iterator.super.forEachRemaining(action);
    }
    public void put(K key,V val){
        if (key == null) throw new  IllegalArgumentException("calls get() with a null key");

        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val){
        if (x == null) return new Node(key, val,1);
        int cmp = key.compareTo(x.key);
        if (cmp <0) x.left = put(x.left, key, val);
        else if (cmp>0) x.right = put(x.right,key,val);
        else x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }


    public  V remove(K key){throw new UnsupportedOperationException();}
    public  V iterator(K key){throw new UnsupportedOperationException();}
    public  Set<K> keySet(){throw new UnsupportedOperationException();}
    public  V remove(K key, V val){throw new UnsupportedOperationException();}
}
