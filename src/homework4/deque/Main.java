package homework4.deque;

public class Main {
    public static void main(String[] args) {
//        IDeque<Integer> deque = new Deque<>(5);
        IDeque<Integer> deque = new NodeListDeque<>();

        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertRight(5);
        deque.insertLeft(4);
        deque.insertRight(6);
        deque.insertRight(7);

        deque.display();

        deque.removeLeft();
        deque.display();
        deque.removeLeft();
        deque.display();
        deque.removeRight();
        deque.display();

        deque.insertRight(9);
        deque.insertRight(8);
        deque.insertLeft(7);

        deque.display();
    }
}
