package application.v1.services;

import application.exceptions.InvalidBurgerName;
import burgers.types.BurgerType;

import java.io.IOException;
import java.util.List;

public interface BurgerService {

    void makeBurger(String burgerType) throws IOException, InterruptedException, InvalidBurgerName;

    BurgerType selectBurger(List<BurgerType> burgerTypes) throws IOException, InterruptedException;
}
