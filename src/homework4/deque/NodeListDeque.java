package homework4.deque;

//2. Реализовать Deque на основе двунаправленного списка

import homework4.nodelist.ITwoSideList;
import homework4.nodelist.TwoSideList;

public class NodeListDeque<E> implements IDeque<E> {

    private final ITwoSideList<E> data;

    public NodeListDeque(){
        data = new TwoSideList<>();
    }

    @Override
    public boolean insertLeft(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        return data.removeLast();
    }

    @Override
    public E peekLeft() {
        return data.getFirst();
    }

    @Override
    public E peekRight() {
        return data.getLast();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }
}