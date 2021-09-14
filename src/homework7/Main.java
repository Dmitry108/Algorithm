package homework7;

public class Main {
    public static void main(String[] args) {
        TownGraph graph = new TownGraph(20);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");


        graph.addEdge("Москва", "Тула", 1);
        graph.addEdge("Москва", "Рязань", 2);
        graph.addEdge("Москва", "Калуга", 3);
        graph.addEdge("Тула", "Липецк", 4);
        graph.addEdge("Липецк", "Воронеж", 5);
        graph.addEdge("Рязань", "Тамбов", 6);
        graph.addEdge("Тамбов", "Саратов", 7);
        graph.addEdge("Саратов", "Воронеж", 8);
        graph.addEdge("Калуга", "Орел", 9);
        graph.addEdge("Орел", "Курск", 10);
        graph.addEdge("Курск", "Воронеж", 11);
        graph.addEdge("Тула", "Тамбов", 12);
        graph.addEdge("Орел", "Караганда", 13);

        graph.display();
        graph.findShortPath("Москва", "Воронеж");
//        System.out.println(graph.ways);
    }
}