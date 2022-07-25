package ingredients.types;

public enum AdditionType {

    CHIPS {
        @Override
        public String toString(){
            return "French fries";
        }
    },

    DRINKS {
        @Override
        public String toString(){
            return "Coke";
        }
    }
}
