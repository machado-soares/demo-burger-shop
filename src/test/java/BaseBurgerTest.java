import application.exceptions.InvalidToppingInsertion;
import burgers.types.BaseBurger;
import burgers.Prices;
import ingredients.*;
import ingredients.types.BreadType;
import ingredients.types.MeatType;
import ingredients.types.ToppingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class BaseBurgerTest {

    @Test
    public void baseBurgerTest() throws InvalidToppingInsertion {
        BaseBurger burger = new BaseBurger(BreadType.WHITE, MeatType.BLACK_ANGUS);
        Topping cheeseTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.CHEESE), ToppingType.CHEESE.toString());
        Topping lettuceTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.LETTUCE), ToppingType.LETTUCE.toString());
        Topping onionTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.ONION), ToppingType.ONION.toString());
        Topping tomatoTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.TOMATO), ToppingType.TOMATO.toString());
        Topping saucesTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.SAUCES), ToppingType.SAUCES.toString());
        burger.addTopping(cheeseTopping);
        burger.addTopping(lettuceTopping);
        burger.addTopping(onionTopping);
        burger.addTopping(tomatoTopping);
        Assertions.assertThrows(InvalidToppingInsertion.class,() -> burger.addTopping(saucesTopping));

        Assertions.assertTrue(burger.getAllToppings().contains(cheeseTopping));
        Assertions.assertTrue(burger.getAllToppings().contains(lettuceTopping));
        Assertions.assertTrue(burger.getAllToppings().contains(onionTopping));
        Assertions.assertTrue(burger.getAllToppings().contains(tomatoTopping));
        Assertions.assertFalse(burger.getAllToppings().contains(saucesTopping));

        System.out.println(burger.printReceipt());
    }



}
