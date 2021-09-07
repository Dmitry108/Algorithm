package homework5.rucksack;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Rucksack {
    private final List<Thing> hata = new ArrayList<>();
    private List<Bag> resultSet = new ArrayList<>();
    private static int iterationCounter = 0;

    public Rucksack() {
        SecureRandom rn = new SecureRandom();
        for (int i = 0; i < 6; i++) {
            this.hata.add(Thing.values()[rn.nextInt(Thing.values().length)]);
        }
    }

    public static void main(String[] args) {
        Rucksack rr = new Rucksack();
        System.out.println(rr.hata);
        iterationCounter = 0;
        System.out.println(rr.find());
        System.out.println(iterationCounter);
        System.out.println(rr.findBySorting(new Bag(10)));
    }

    //вариант 1: методом перебора всех комбинаций, сложность O(2^n)
    public Bag find() {
        resultSet.clear();
        find(hata);
        resultSet.sort((b1, b2) -> b2.getPrice() - b1.getPrice());
        return resultSet.get(0);
    }

    private void find(List<Thing> list) {
        iterationCounter++;
        Bag bag = new Bag(10);
        boolean isTooMuch = false;
        for (int i = 0; i < list.size(); i++){
           if (!bag.put(list.get(i))) {
               isTooMuch = true;
               break;
           }
        }
        if (!isTooMuch) {
            resultSet.add(bag);
        } else {
            for (int i = 0; i < list.size(); i++){
                List<Thing> newList = new ArrayList<>(list);
                newList.remove(i);
                if (!newList.isEmpty()) find(newList);
            }
        }
    }

    //вариант 2:
    // 1) для каждой вещи введем показатель сколько стоит единица веса
    // 2) отсорируем вещи по максимально стоимости за единицу веса
    // 3) наберем в рюкзак по-порядку отсортированные вещи
    // O-большая зависит от сложности сортировки
    // алгоритм имеет погрешности, так как не учитывает оставшийся вес
    public Bag findBySorting(Bag bag) {
        List<Thing> list = new ArrayList<>(hata);
        list.sort(new Comparator<Thing>() {
            private double dearness(Thing t) {
                return 1.0 * t.getPrice() / t.getWeight() / t.getWeight();
            }

            @Override
            public int compare(Thing t1, Thing t2) {
                return (int) (dearness(t2) - dearness(t1));
            }
        });
        for (Thing thing : list) {
            bag.put(thing);
        }
        return bag;
    }
}