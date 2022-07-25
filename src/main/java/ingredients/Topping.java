package ingredients;

public class Topping {

    private final Double price;
    private final String name;

    public Topping(Double price, String name){
        this.price = price;
        this.name = name;
    }

    public Double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

}
