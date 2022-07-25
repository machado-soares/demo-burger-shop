package application.v1;

import application.BurgerShopApp;
import application.exceptions.InvalidBurgerName;
import application.v1.services.BurgerService;
import application.v1.services.BurgerServiceImpl;
import burgers.BurgerFactory;
import burgers.types.BurgerType;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

import static application.v1.Utils.clearConsole;

//todo make burger is too big(separate into functions)
public class VersionOneBurgerShopApp implements BurgerShopApp {

    private BufferedReader reader;
    private final Pattern pattern = Pattern.compile("^[0123456789]$");
    private final BurgerService burgerService;

    public VersionOneBurgerShopApp() {
        this.burgerService = BurgerServiceImpl.getInstance();
    }

    @Override
    public void run() throws IOException, InterruptedException, InvalidBurgerName {
        clearConsole();
        BurgerType burgerType = burgerService.selectBurger(BurgerFactory.getBurgerTypes());
        burgerService.makeBurger(burgerType.toString());
    }

}
