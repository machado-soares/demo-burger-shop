package burgers;

import application.exceptions.InvalidToppingInsertion;
import ingredients.Topping;

public interface Burger {

    Integer getMaxToppings();

    void addTopping(Topping topping) throws InvalidToppingInsertion;

    String printReceipt();

}
