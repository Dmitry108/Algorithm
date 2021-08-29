package homework3.deque;

public class Main {
    public static void main(String[] args) {
        IDeque<Integer> deque = new Deque<>(5);

        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertRight(5);
        deque.insertLeft(4);
        deque.insertRight(6);
        deque.insertRight(7);

        System.out.println(deque);

        deque.removeLeft();
        System.out.println(deque);
        deque.removeLeft();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);

        deque.insertRight(9);
        deque.insertRight(8);
        deque.insertLeft(7);

        System.out.println(deque);
    }
}