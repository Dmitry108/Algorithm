package homework7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TownGraph implements IWeightedGraph {

    private final List<Vertex> elements;
    private final int[][] adjMatrix;
    private Map<String, Integer> ways;

    public TownGraph(int maxSize) {
        this.ways = new TreeMap<>();
        this.elements = new ArrayList<>(maxSize);
        this.adjMatrix = new int[maxSize][maxSize];
    }

    @Override
    public void addVertex(String label) {
        elements.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String endLabel, int weight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);
        if (startIndex == -1 || endIndex == -1) return false;
        adjMatrix[startIndex][endIndex] = weight;
        adjMatrix[endIndex][startIndex] = weight;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getLabel().equals(label)) return i;
        }
        return -1;
    }

    @Override
    public int getSize() {
        return elements.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(elements.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != 0) {
                    System.out.println(" -> " + elements.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void findShortPath(String startLabel, String finishLabel) {
        ways.clear();
        List<String> backTowns = new ArrayList<>();
        backTowns.add(startLabel);
        findPath(startLabel, finishLabel, backTowns, 0);
        Map.Entry<String, Integer> minEntry = ways.entrySet().stream()
                .min((way1, way2) -> way1.getValue() - way2.getValue()).get();
        String minKey = minEntry.getKey();
        Integer minValue = minEntry.getValue();
        System.out.printf("The optimal way is %s, distance is %d\n", minKey, minValue);
    }

    //Решение при помощи рекурсии
    private void findPath(String startLabel, String finishLabel, List<String> towns, Integer distance) {
        if (indexOf(startLabel) == -1 || indexOf(finishLabel) == -1) {
            throw new IllegalArgumentException("Incorrect argument");
        }
        if (startLabel.equals(finishLabel)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < towns.size(); i++) {
                if (i > 0) sb.append(" -> ");
                sb.append(towns.get(i));
            }
            ways.put(sb.toString(), distance);
            return;
        }
        int indexStart = indexOf(startLabel);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[indexStart][i] != 0 && !towns.contains(elements.get(i).getLabel())){
                List<String> newWay = new ArrayList<>(towns);
                int newDistance = distance + adjMatrix[indexStart][i];
                newWay.add(elements.get(i).getLabel());
                findPath(elements.get(i).getLabel(), finishLabel, newWay, newDistance);
            }
        }
    }
}