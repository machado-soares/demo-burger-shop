package ingredients.types;

public enum BreadType {
    WHOLEGRAIN{
        @Override
        public String toString(){
            return "Wholegrain bread";
        }
    },
    WHITE{
        @Override
        public String toString(){
            return "White bread";
        }
    },
    BRIOCHE{
        @Override
        public String toString(){
            return "Brioche bread";
        }
    },
    CIABATTA{
        @Override
        public String toString(){
            return "Ciabatta bread";
        }

    }
}
