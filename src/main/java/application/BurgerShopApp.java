package application;

import application.exceptions.InvalidBurgerName;

import java.io.IOException;

public interface BurgerShopApp {

    void run() throws IOException, InterruptedException, InvalidBurgerName;

}
