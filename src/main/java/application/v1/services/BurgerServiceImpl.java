package application.v1.services;

import application.exceptions.InvalidBurgerName;
import application.exceptions.InvalidToppingInsertion;
import burgers.Burger;
import burgers.BurgerFactory;
import burgers.Prices;
import burgers.types.BurgerType;
import burgers.types.ComboBurger;
import ingredients.Topping;
import ingredients.types.BreadType;
import ingredients.types.MeatType;
import ingredients.types.ToppingType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static application.v1.Utils.clearConsole;
import static application.v1.Utils.printList;

public class BurgerServiceImpl implements BurgerService {

    private static BurgerServiceImpl instance = null;
    private BufferedReader reader;
    private final Pattern pattern = Pattern.compile("^[0123456789]$");

    private BurgerServiceImpl() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static BurgerServiceImpl getInstance() {
        if (instance == null) {
            instance = new BurgerServiceImpl();
        }
        return instance;
    }

    @Override
    public void makeBurger(String burgerType) throws IOException, InterruptedException, InvalidBurgerName {
        BreadType breadType;
        MeatType meatType;
        breadType = selectBread(Arrays.asList(BreadType.values()));
        meatType = selectMeat(Arrays.asList(MeatType.values()));
        Burger burger = BurgerFactory.getBurger(burgerType, breadType, meatType);
        selectTopping(Arrays.asList(ToppingType.values()), burger);
        clearConsole();
        System.out.println(burger.printReceipt());
    }

    @Override
    public BurgerType selectBurger(List<BurgerType> burgerTypes) throws IOException, InterruptedException {
        boolean retry = true;
        BurgerType burgerType = null;
        while (retry) {
            clearConsole();
            burgerType = select(burgerTypes, "Please select your burger: ");
            if (burgerType != null) {
                retry = false;
            } else {
                printInvalidOptionMessage();
            }
        }
        return burgerType;

    }

    private BreadType selectBread(List<BreadType> breadTypes) throws IOException, InterruptedException {
        boolean retry = true;
        BreadType breadType = null;
        while (retry) {
            clearConsole();
            breadType = select(breadTypes, "Select your preferred bread: ");
            if (breadType != null) {
                retry = false;
            } else {
                printInvalidOptionMessage();
            }
        }
        return breadType;
    }

    private MeatType selectMeat(List<MeatType> meatTypes) throws IOException, InterruptedException {
        boolean retry = true;
        MeatType meatType = null;
        while (retry) {
            clearConsole();
            meatType = select(meatTypes, "Select your preferred meat: ");
            if (meatType != null) {
                retry = false;
            } else {
                printInvalidOptionMessage();
            }
        }
        return meatType;
    }

    private void selectTopping(List<ToppingType> toppingTypes, Burger burger) throws IOException, InterruptedException {
        ToppingType toppingType;
        boolean retry = !(burger instanceof ComboBurger);
        while (retry) {
            clearConsole();
            System.out.println("Would you like to add toppings?(Y/N)");
            String userInput = reader.readLine();
            if (userInput.equalsIgnoreCase("y")) {
                toppingType = select(toppingTypes, "Select your topping to add: ");
                Topping topping = new Topping(Prices.getInstance().getToppingPrice(toppingType), toppingType.toString());
                try {
                    burger.addTopping(topping);
                } catch (InvalidToppingInsertion e) {
                    retry = false;
                    System.out.println("You can't add any more toppings. Press enter to continue.");
                    reader.readLine();
                }
            } else {
                retry = false;
            }
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private <T> T select(List<? extends Enum> types, String message) throws IOException {
        System.out.println(message);
        printList(types.stream().map(Enum::toString).collect(Collectors.toList()));
        String userInput = reader.readLine();
        Matcher matcher = pattern.matcher(userInput);
        int convertedUserInput = Integer.parseInt(userInput);
        if (matcher.matches() && convertedUserInput < types.size()) {
            return (T) types.get(convertedUserInput);
        }
        return null;
    }

    private void printInvalidOptionMessage() throws IOException {
        System.out.println("You have select an invalid option. Press enter and try again");
        reader.readLine();
    }

}
