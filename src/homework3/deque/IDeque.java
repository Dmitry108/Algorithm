package homework3.deque;

public interface IDeque<E> {
    boolean insertLeft(E value);
    boolean insertRight(E value);
    E removeLeft();
    E removeRight();
    E peekLeft();
    E peekRight();
    int size();
    boolean isEmpty();
    boolean isFull();
}
