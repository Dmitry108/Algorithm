package homework4.nodelist;

public class TwoSideList<E> extends NodeList<E> implements ITwoSideList<E> {

    protected Node<E> lastNode;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastNode = firstNode;
        } else {
            firstNode.next.previous = firstNode;
        }
    }

    @Override
    public void insertLast(E value) {
        lastNode = new Node<>(value, lastNode, null);
        size++;
        if (size == 1) {
            firstNode = lastNode;
        } else {
            lastNode.previous.next = lastNode;
        }
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> node = firstNode;
        firstNode = firstNode.next;
        node.next = firstNode.previous = null;
        size--;
        if (isEmpty()) lastNode = null;
        return node.item;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        Node<E> node = lastNode;
        lastNode = lastNode.previous;
        lastNode.next = node.previous = null;
        size--;
        if (isEmpty()) firstNode = null;
        return node.item;
    }

    @Override
    public E getLast() {
        return getValue(lastNode);
    }

    @Override
    public boolean remove(E value) {
        boolean isChanged = false;
        Node<E> node = firstNode;
        while (node != null){
            if (node.item.equals(value)){
                if (node != firstNode) {
                    Node<E> removingNote = node;
                    node.previous.next = node.next;
                    if (node != lastNode) node.next.previous = node.previous;
                    node = node.next;
                    removingNote.next = removingNote.previous = null;
                    size--;
                } else {
                    removeFirst();
                    node = firstNode;
                }
                isChanged = true;
            } else {
                node = node.next;
            }
        }
        return isChanged;
    }
}