package homework6;

public interface ITree<E extends Comparable<? super E>> {
    boolean add(E value);
    boolean contains(E value);
    boolean remove(E value);
    boolean isEmpty();
    int size();
    void display();
    void traverse(TraversMode mode);

    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }
}