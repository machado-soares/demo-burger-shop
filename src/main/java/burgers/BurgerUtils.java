package burgers;

import ingredients.Addition;
import ingredients.types.BreadType;
import ingredients.Topping;

import java.util.List;

public class BurgerUtils {

    private BurgerUtils(){}

    public static String printReceipt(Double basePrice, BreadType breadType, List<Topping> allToppings, List<Addition> allAdditions) {
        StringBuilder result = new StringBuilder();
        result.append("Base: ").append(basePrice).append("\n");
        result.append("     ").append(breadType.toString()).append("\n");
        boolean isFirst = true;
        Double finalPrice = basePrice;
        for(Topping topping : allToppings){
            if(isFirst){ //for UI purposes only
                result.append("Toppings: \n");
                isFirst = false;
            }
            result.append("   ").append(topping.getName()).append(": ").append(topping.getPrice()).append("\n");
            finalPrice+= topping.getPrice();
        }
        isFirst = true;
        for(Addition addition : allAdditions){
            if(isFirst){
                result.append("Additions: \n");
                isFirst = false;
            }
            result.append("   ").append(addition.getName()).append(": ").append(addition.getPrice()).append("\n");
            finalPrice+= addition.getPrice();

        }
        result.append("Total price: ").append(finalPrice);
        return result.toString();

    }

}
