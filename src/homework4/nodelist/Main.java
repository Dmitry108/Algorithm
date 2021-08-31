package homework4.nodelist;

public class Main {
    public static void main(String[] args) {
        INodeList<Integer> list = new NodeList<>();
//        ITwoSideList<Integer> list = new TwoSideList<>();

        list.removeFirst();
        list.getFirst();

        list.insertFirst(1);
//        list.removeFirst();
//        list.display();
//        list.insertLast(10);
//        list.removeLast();
//        list.display();
        list.insertFirst(2);
        list.insertFirst(3);
//        list.insertLast(11);
//        list.display();
        list.removeFirst();
        list.insertFirst(4);
//        list.display();
        list.insertFirst(2);
        list.insertFirst(2);
        list.insertFirst(5);
        list.insertFirst(2);
//        list.insertLast(5);
//        list.insertLast(2);
//        list.display();
        list.display();
//        list.remove(2);
//        list.display();
        System.out.println(list.contains(5));
        System.out.println(list.contains(6));
//        System.out.println(list.getLast());
//        list.insertFirst(1);
//        list.display();
//        list.remove(1);
//        list.display();
        for (Integer i: list) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (Integer i: list) {
            System.out.print(i+1 + " ");
        }
        System.out.println();
    }
}