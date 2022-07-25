package burgers.types;

import application.exceptions.InvalidToppingInsertion;
import burgers.Burger;
import burgers.BurgerUtils;
import burgers.Combo;
import burgers.Prices;
import ingredients.Addition;
import ingredients.Topping;
import ingredients.types.AdditionType;
import ingredients.types.BreadType;
import ingredients.types.MeatType;

import java.util.ArrayList;
import java.util.List;

public class ComboBurger implements Burger, Combo {

    private static final Double BASE_PRICE = 2.5;
    private final BreadType breadType;
    private final MeatType meatType;
    private final List<Addition> additions;
    private static final Integer MAX_ADDITIONAL_TOPPINGS = 6;


    public ComboBurger(BreadType bread, MeatType meat) {
        this.breadType = bread;
        this.meatType = meat;
        this.additions = new ArrayList<>();
        this.additions.add(new Addition(Prices.getInstance().getAdditionPrice(AdditionType.CHIPS), AdditionType.CHIPS.toString()));
        this.additions.add(new Addition(Prices.getInstance().getAdditionPrice(AdditionType.CHIPS), AdditionType.DRINKS.toString()));
    }

    public List<Topping> getAllToppings() {
        List<Topping> result = new ArrayList<>();
        result.add(new Topping(Prices.getInstance().getMeatPrice(meatType), meatType.toString()));
        return result;
    }

    @Override
    public Integer getMaxToppings() {
        return MAX_ADDITIONAL_TOPPINGS;
    }

    @Override
    public void addTopping(Topping topping) throws InvalidToppingInsertion {
        throw new InvalidToppingInsertion();
    }

    @Override
    public String printReceipt() {
        return BurgerUtils.printReceipt(BASE_PRICE, breadType, this.getAllToppings(), this.additions);
    }

    @Override
    public List<Addition> getAdditions() {
        return additions;
    }

    @Override
    public void incrementAdditions(Addition addition) {
        this.additions.add(addition);
    }
}
