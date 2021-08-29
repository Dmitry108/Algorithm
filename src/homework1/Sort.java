package homework1;

import java.util.Random;

/* Отсортировать массив, состоящий из экземпляров класса Notebook в количестве 5000 штук.
Условия для сортировки:
1) по цене. От 500 до 1000 долларов с шагом в 100
если цена равная, то
2) по кол-ву оперативной памяти (от 4 до 12 с шагом 4)
если памяти тоже равное количество, то 3) по производителю:
Lenuvo > Asos > MacNote > Eser > Xamiou
Добиваться максимально оптимальной сложности О-большая
*/

public class Sort {
    private static final Random random = new Random();
    private static int iterationCounter = 0;

    public static void main(String[] args) {
        int n = 5000;

        Notebook[] notebooks = new Notebook[n];
        for (int i = 0; i < n; i ++) {
            notebooks[i] = new Notebook(
                    (random.nextInt(6) + 5) * 100,
                    random.nextInt(3) * 4 + 4,
                    Maker.getMaker(random.nextInt(Maker.values().length)));
        }
        long time = combSortNotebook(notebooks);
        printObjectArray(notebooks);
        System.out.printf("время: %-5d итерации: %-10d%n", time, iterationCounter);
    }

    private static long combSortNotebook(Notebook[] notebooks) {
        int gap = notebooks.length;
        boolean isChange = false;
        iterationCounter = 0;
        long time = System.currentTimeMillis();
        while (gap > 1 || isChange) {
            if (gap > 1) {
                gap = (int) (gap / 1.247);
            }
            isChange = false;
            for (int i = 0; i + gap < notebooks.length; i++) {
                if (Notebook.compare(notebooks[i], notebooks[i + gap]) > 0) {
                    changeElementsInArray(notebooks, i, i+gap);
                    isChange = true;
                }
                iterationCounter++;
            }
        }
        return System.currentTimeMillis() - time;
    }

    private static void printObjectArray(Object[] objs) {
        for (Object obj : objs) {
            System.out.println(obj.toString());
        }
        System.out.println();
    }

    private static void changeElementsInArray(Object[] objects, int index1, int index2){
        Object object = objects[index1];
        objects[index1] = objects[index2];
        objects[index2] = object;
    }
}