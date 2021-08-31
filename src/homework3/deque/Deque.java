package homework3.deque;

import java.util.Arrays;

public class Deque<E> implements IDeque<E> {

    private E[] data;
    private int size;
    private int left;
    private int right;

    Deque(int maxSize){
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) return false;
        left = isEmpty() ? 0 : previousIndex(left);
        data[left] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) return false;
        right = isEmpty() ? 0 : nextIndex(right);
        data[right] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) return null;
        E value = data[left];
        data[left] = null;
        size--;
        left = nextIndex(left);
        return value;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) return null;
        E value = data[right];
        data[right] = null;
        size--;
        right = previousIndex(right);
        return value;
    }

    @Override
    public E peekLeft() {
        return data[left];
    }

    @Override
    public E peekRight(){
        return data[right];
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
    public boolean isFull() {
        return size == data.length;
    }

    //реализация динамического изменения индексов
    //начала и конца массива при добавлении новых элементов
    private int nextIndex(int index) {
        return ++index % data.length;
    }

    private int previousIndex(int index){
        return (--index + data.length) % data.length;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0, index = left; i < size; index = nextIndex(index), i++){
            sb.append(data[index]);
                if (i < size - 1) sb.append(", ");
            }
            sb.append("]");
            sb.append("\nreal array: ").append(Arrays.toString(data));
            return sb.toString();
        }
}