package homework7;

public interface IWeightedGraph {
    void addVertex(String label);
    boolean addEdge(String startLabel, String endLabel, int weight);
    int getSize();
    void display();
    void findShortPath(String startLabel, String finishLabel);
}
