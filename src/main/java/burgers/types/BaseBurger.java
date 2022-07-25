package burgers.types;

import application.exceptions.InvalidToppingInsertion;
import burgers.Burger;
import burgers.BurgerUtils;
import burgers.Prices;
import ingredients.Topping;
import ingredients.types.BreadType;
import ingredients.types.MeatType;

import java.util.ArrayList;
import java.util.List;

public class BaseBurger implements Burger {

    private static final Integer MAX_ADDITIONAL_TOPPINGS = 4;
    private static final Double BASE_PRICE = 1.5;
    private final BreadType breadType;
    private final MeatType meatType;
    private final List<Topping> additionalToppings;


    public BaseBurger(BreadType bread, MeatType meat) {
        this.breadType = bread;
        this.meatType = meat;
        this.additionalToppings = new ArrayList<>();
    }

    public List<Topping> getAllToppings() {
        List<Topping> result = new ArrayList<>(additionalToppings);
        result.add(new Topping(Prices.getInstance().getMeatPrice(meatType), meatType.toString()));
        return result;
    }

    @Override
    public Integer getMaxToppings() {
        return MAX_ADDITIONAL_TOPPINGS;
    }

    @Override
    public void addTopping(Topping topping) throws InvalidToppingInsertion {
        if (this.additionalToppings.size() < MAX_ADDITIONAL_TOPPINGS) {
            this.additionalToppings.add(topping);
        }else{
            throw new InvalidToppingInsertion();
        }
    }

    @Override
    public String printReceipt() {
        return BurgerUtils.printReceipt(BASE_PRICE, breadType, this.getAllToppings(), new ArrayList<>());
    }
}
