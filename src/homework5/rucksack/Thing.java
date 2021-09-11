package homework5.rucksack;

enum Thing {
    Notebook("Notebook", 150, 3),
    Photo("Photo", 10, 2),
    Guitar("Guitar", 70, 5),
    TV("TV", 30, 6),
    MediaPlayer("Player", 20, 4),
    Jewelry("Jewelry", 180, 1),
    Phone("Phone", 15, 2),
    Money("Money", 300, 1),
    Clothes("Clothes", 15, 5),
    Furniture("Furniture", 100, 8);

    private String name;
    private int price;
    private int weight;

    Thing(String name, int price, int weight){
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString(){
//        return String.format("%s price: %d, weight: %d", name, price, weight);
//    }
}