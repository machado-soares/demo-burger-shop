package burgers;

import application.exceptions.InvalidBurgerName;
import burgers.types.BaseBurger;
import burgers.types.BurgerType;
import burgers.types.ComboBurger;
import burgers.types.HealthyBurger;
import ingredients.types.BreadType;
import ingredients.types.MeatType;

import java.util.Arrays;
import java.util.List;

public class BurgerFactory {

    private BurgerFactory() {
    }

    public static Burger getBurger(String name, BreadType breadType, MeatType meatType) throws InvalidBurgerName {
        if (name.equals("Base")) {
            return new BaseBurger(breadType, meatType);
        } else if (name.equals("Healthy")) {
            return new HealthyBurger(breadType, meatType);
        } else if (name.equals("Combo")) {
            return new ComboBurger(breadType, meatType);
        } else {
            throw new InvalidBurgerName();
        }
    }

    public static List<BurgerType> getBurgerTypes() {
        return Arrays.asList(BurgerType.values());
    }

}
