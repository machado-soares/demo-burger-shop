package burgers;

import ingredients.types.AdditionType;
import ingredients.types.MeatType;
import ingredients.types.ToppingType;

import java.util.HashMap;
import java.util.Map;

public class Prices {

    private static Prices instance = null;
    private static Map<MeatType, Double> meatPrices;
    private static Map<ToppingType, Double> toppingPrices;
    private static Map<AdditionType,Double> additionPrices;

    private Prices() {
        meatPrices = new HashMap<>();
        toppingPrices = new HashMap<>();
        additionPrices = new HashMap<>();

        meatPrices.put(MeatType.BLACK_ANGUS, 2.3);
        meatPrices.put(MeatType.FISH, 1.9);
        meatPrices.put(MeatType.KOBE_BEEF, 10.0);
        meatPrices.put(MeatType.VEGAN, 2.8);

        toppingPrices.put(ToppingType.CHEESE, 0.5);
        toppingPrices.put(ToppingType.LETTUCE, 0.2);
        toppingPrices.put(ToppingType.ONION, 0.3);
        toppingPrices.put(ToppingType.TOMATO, 0.3);
        toppingPrices.put(ToppingType.SAUCES, 0.5);

        additionPrices.put(AdditionType.CHIPS,1.0);
        additionPrices.put(AdditionType.DRINKS,0.5);
    }

    public static Prices getInstance() {
        if (instance == null) {
            instance = new Prices();
        }
        return instance;
    }

    public Double getMeatPrice(MeatType meatType) {
        return meatPrices.getOrDefault(meatType, 0.0);
    }
    public Double getToppingPrice(ToppingType toppingType) {
        return toppingPrices.getOrDefault(toppingType, 0.0);
    }
    public Double getAdditionPrice(AdditionType additionType) {return additionPrices.getOrDefault(additionType, 0.0);
    }

}
