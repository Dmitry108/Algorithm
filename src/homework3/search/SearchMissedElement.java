package homework3.search;

import java.security.SecureRandom;
import java.util.Arrays;

/*  Дан массив из n элементов, начиная с 1.
    Каждый следующий элемент равен (предыдущий + 1).
    Но в массиве гарантированно 1 число пропущено.
    Необходимо вывести на экран пропущенное число.
*/

/*      Примеры:
        [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
        [1, 2, 4, 5, 6] => 3
        [] => 1
*/

public class SearchMissedElement {
    private static SecureRandom random = new SecureRandom();

    private static int[] getSomeArray(int size) {
        int[] array = new int[size];
        int r = random.nextInt(size);
        for (int i = 1; i <= size; i++) {
            array[i - 1] = i < r ? i : i + 1;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = getSomeArray(10);
//        int[] array = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
//        int[] array = {1, 2, 4, 5, 6};
//        int[] array = {};
        System.out.println(Arrays.toString(array));
        System.out.printf("Missed element is %d\n", searchMissedElement(array));
    }

    public static int searchMissedElement(int[] array){
        int start = 0;
        int end = array.length - 1;
        int base = 0;
        while (start <= end){
            base = (start + end)/2;
            if (array[base] == base + 1){
                start = ++base;
            } else {
                end = base - 1;
            }
        }
        return base + 1;
    }
}