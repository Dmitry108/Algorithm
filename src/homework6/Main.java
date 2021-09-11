package homework6;

import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        final int maxLevel = 4;
        int balancedTreeCounter = 0;
        final int size = 20;
        boolean isBalanced;
        for (int i = 0; i < size; i++) {
            Tree<Integer> tree = new Tree<>(maxLevel);
            while (tree.add(random.nextInt(51) - 25));
            isBalanced = tree.isBalanced(tree.getRoot());
            tree.display();
            System.out.println(isBalanced);
            if (isBalanced) balancedTreeCounter++;
        }
        System.out.printf("Amount of balanced tree is %d in percent", balancedTreeCounter*100/size);
    }
}