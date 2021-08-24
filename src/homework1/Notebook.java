package homework1;

public class Notebook {
    private int price;
    private int ram;
    private Maker maker;

    Notebook(int price, int ram, Maker maker){
        this.price = price;
        this.ram = ram;
        this.maker = maker;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setMaker(Maker maker) {
        this.maker = maker;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public Maker getMaker() {
        return maker;
    }

    @Override
    public String toString(){
        return String.format("price: %s, RA memory: %s, maker: %s", price, ram, maker.getName());
    }

    public static int compare(Notebook nb1, Notebook nb2){
        int result = nb1.price - nb2.price;
        if (result == 0) {
            result = nb1.ram - nb2.ram;
            if (result == 0) {
                result = nb1.maker.ordinal() - nb2.maker.ordinal();
            }
        }
        return result;
    }
}