import application.exceptions.InvalidToppingInsertion;
import burgers.Prices;
import burgers.types.ComboBurger;
import ingredients.types.BreadType;
import ingredients.types.MeatType;
import ingredients.Topping;
import ingredients.types.ToppingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ComboBurgerTest {

    @Test
    public void baseBurgerTest() throws InvalidToppingInsertion {
        ComboBurger burger = new ComboBurger(BreadType.WHOLEGRAIN, MeatType.KOBE_BEEF);
        Topping cheeseTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.CHEESE), ToppingType.CHEESE.toString());
        Topping lettuceTopping = new Topping(Prices.getInstance().getToppingPrice(ToppingType.LETTUCE), ToppingType.LETTUCE.toString());
        Assertions.assertThrows(InvalidToppingInsertion.class,() -> burger.addTopping(cheeseTopping));
        Assertions.assertThrows(InvalidToppingInsertion.class,() -> burger.addTopping(lettuceTopping));

        Assertions.assertFalse(burger.getAllToppings().contains(cheeseTopping));
        Assertions.assertFalse(burger.getAllToppings().contains(lettuceTopping));
        Assertions.assertEquals(1,burger.getAllToppings().size());
        Assertions.assertEquals(2,burger.getAdditions().size());
        System.out.println(burger.printReceipt());
    }



}
