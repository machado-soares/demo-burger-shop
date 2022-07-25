package ingredients.types;

public enum MeatType {

    BLACK_ANGUS {
        @Override
        public String toString(){
            return "Black Angus";
        }
    },

    KOBE_BEEF {
        @Override
        public String toString(){
            return "Kobe beef";
        }
    },

    VEGAN {
        @Override
        public String toString(){
            return "Vegan";
        }
    },

    FISH {
        @Override
        public String toString(){
            return "Fish";
        }
    },
}
