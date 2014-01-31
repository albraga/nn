
package knearestneighbor;

public enum Type {
        APARTMENT, 
        HOUSE, 
        FLAT;
    
        static public Type get(String tp) {
            switch(tp) {
                case "apartment" :
                    return Type.APARTMENT;
                case "house" :
                    return Type.HOUSE;
                case "flat" :
                    return Type.FLAT;
                default : return null;
            }
        }
    
    }
