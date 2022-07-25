import application.exceptions.InvalidBurgerName;
import application.v1.VersionOneBurgerShopApp;
import application.BurgerShopApp;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, InvalidBurgerName {
        BurgerShopApp app = new VersionOneBurgerShopApp();
        app.run();
    }

}
