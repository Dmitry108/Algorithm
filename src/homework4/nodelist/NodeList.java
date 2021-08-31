package homework4.nodelist;

//1. Реализовать цикл forEach для простого связанного списка

import java.util.Iterator;

public class NodeList<E> implements INodeList<E> {

    protected Node<E> firstNode;
    protected int size;

    @Override
    public void insertFirst(E value) {
        firstNode = new Node<>(value, firstNode);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> node = firstNode;
        firstNode = firstNode.next;
        node.next = null;
        size--;
        return node.item;
    }

    @Override
    public E getFirst() {
        return getValue(firstNode);
    }

    protected E getValue(Node<E> node) {
        return node != null ? node.item : null;
    }

    @Override
    public boolean remove(E value) {
        boolean isChanged = false;
        Node<E> node = firstNode;
        Node<E> beforeNode = null;
        while (node != null){
            if (node.item.equals(value)){
                if (beforeNode != null) {
                    beforeNode.next = node.next;
                    node.next = null;
                    node = beforeNode.next;
                    size--;
                } else {
                    removeFirst();
                    node = firstNode;
                }
                isChanged = true;
            } else {
                beforeNode = node;
                node = node.next;
            }
        }
        return isChanged;
    }

    @Override
    public boolean contains(E value) {
        for (Node<E> i = firstNode; i != null; i = i.next) {
            if (i.item.equals(value)) return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (Node<E> i = firstNode; i != null; i = i.next) {
            sb.append(i.item);
            if (i.next != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> currentNode = firstNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E value = currentNode.item;
                    currentNode = currentNode.next;
                    return value;
                }
                return null;
            }
        };
    }
}