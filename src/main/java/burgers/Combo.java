package burgers;

import ingredients.Addition;

import java.util.List;

public interface Combo {

    List<Addition> getAdditions();
    void incrementAdditions(Addition addition);

}
