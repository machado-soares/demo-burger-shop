package burgers.types;

public enum BurgerType {

    BASE {
        @Override
        public String toString(){
            return "Base";
        }
    },

    HEALTHY {
        @Override
        public String toString(){
            return "Healthy";
        }
    },

    COMBO {
        @Override
        public String toString(){
            return "Combo";
        }
    }

}
