package homework5.degree;

import java.util.Scanner;

public class Degree {
    public static void main(String[] args) {
        System.out.printf("3^0=%d   3^1=%d   3^2=%d   3^3=%d",
                degree(3, 0), degree(3, 1),
                degree(3, 2), degree(3, 3));
        System.out.printf("\n2^10=%d   27^2=%d   2^23=%d",
                degree(2, 10), degree(27, 2),
                degree(2, 23));
    }

    public static int degree(int base, int power) {
        if (power == 0) return 1;
        if (power == 1) return base;
        return base * degree(base, --power);
    }
}