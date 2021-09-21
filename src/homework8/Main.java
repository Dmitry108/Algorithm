package homework8;

public class Main {
    public static void main(String[] args) {
        IHashTable<Product, Integer> hashTable = new ChainHashTable<>(5);

        Product product1 = new Product(1, "Orange");
        Product product3 = new Product(2, "Lemon");
        Product product4 = new Product(3, "Cherry");
        Product product2 = new Product(4, "Banana");
        Product product5 = new Product(5, "Mellon");
        Product product6 = new Product(6, "Apple");
        Product product7 = new Product(7, "Pear");

        hashTable.put(product1, 100);
        hashTable.put(product2, 80);
        hashTable.put(product3, 120);
        hashTable.put(product4, 70);
        hashTable.put(product5, 150);
        hashTable.put(product1, 60);
        hashTable.put(product6, 50);
        hashTable.put(product7, 70);

        System.out.println(hashTable.size() + " " + hashTable.get(product3) + " " + hashTable.isEmpty());
        hashTable.display();

        System.out.printf("Cost of orange is %d%n", hashTable.get(product1));
        System.out.printf("Cost of cherry is %d%n", hashTable.get(product4));
        System.out.printf("Cost of apple is %d%n", hashTable.get(product6));

        hashTable.remove(product3);
        hashTable.remove(product2);
        hashTable.display();

        hashTable.put(product7, 75);
        hashTable.display();
    }
}