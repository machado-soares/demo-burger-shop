import application.exceptions.InvalidToppingInsertion;
import burgers.types.HealthyBurger;
import burgers.Prices;
import ingredients.types.BreadType;
import ingredients.types.MeatType;
import ingredients.Topping;
import ingredients.types.ToppingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HealthyBurgerTest {

    @Test
    public void baseBurgerTest() throws InvalidToppingInsertion {
        HealthyBurger burger = new HealthyBurger(BreadType.BRIOCHE, MeatType.VEGAN);
        Topping cheeseTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.CHEESE), ToppingType.CHEESE.toString());
        Topping lettuceTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.LETTUCE), ToppingType.LETTUCE.toString());
        Topping onionToppping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.ONION), ToppingType.ONION.toString());
        Topping tomatoTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.TOMATO), ToppingType.TOMATO.toString());
        Topping saucesTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.SAUCES), ToppingType.SAUCES.toString());
        Topping baconTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.BACON), ToppingType.BACON.toString());
        burger.addTopping(cheeseTopping);
        burger.addTopping(lettuceTopping);
        burger.addTopping(onionToppping);
        burger.addTopping(tomatoTopping);
        burger.addTopping(saucesTopping);
        Assertions.assertThrows(InvalidToppingInsertion.class,() -> burger.addTopping(baconTopping));

        Assertions.assertTrue(burger.getAllToppings().contains(cheeseTopping));
        Assertions.assertTrue(burger.getAllToppings().contains(lettuceTopping));
        Assertions.assertTrue(burger.getAllToppings().contains(onionToppping));
        Assertions.assertTrue(burger.getAllToppings().contains(tomatoTopping));
        Assertions.assertTrue(burger.getAllToppings().contains(saucesTopping));
        Assertions.assertFalse(burger.getAllToppings().contains(baconTopping));
        System.out.println(burger.printReceipt());
    }



}
