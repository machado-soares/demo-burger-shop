package ingredients.types;

public enum ToppingType {

    CHEESE {
        @Override
        public String toString(){
            return "Cheese";
        }
    },

    LETTUCE {
        @Override
        public String toString(){
            return "Lettuce";
        }
    },

    SAUCES {
        @Override
        public String toString(){
            return "Sauces";
        }
    },

    TOMATO {
        @Override
        public String toString(){
            return "Tomato";
        }
    },
    ONION {
        @Override
        public String toString(){
            return "Onion";
        }
    },
    BACON {
        @Override
        public String toString(){
            return "Bacon";
        }
    }
}
