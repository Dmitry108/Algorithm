package homework4.nodelist;

public interface ITwoSideList<E> extends INodeList<E> {
    void insertLast(E value);
    E removeLast();
    E getLast();
}