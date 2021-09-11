package homework5.rucksack;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Thing> things = new ArrayList<>();
    private int price = 0;
    private int weight = 0;
    private final int MAX_WEIGHT;

    public Bag(int maxWeight){
        this.MAX_WEIGHT = maxWeight;
    }

    public boolean put(Thing thing){
        if (thing.getWeight() + weight > MAX_WEIGHT) return false;
        things.add(thing);
        weight += thing.getWeight();
        price += thing.getPrice();
        return true;
    }

    public boolean remove(Thing thing){
        return things.remove(thing);
    }

    @Override
    public String toString(){
        return String.format("%s weight: %d, price: %d\n", things, weight, price);
    }

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxWeight() {
        return MAX_WEIGHT;
    }

    public int getCount(){
        return things.size();
    }

    public Thing getLast() {
        return things.isEmpty() ? null : things.get(things.size() - 1);
    }
}