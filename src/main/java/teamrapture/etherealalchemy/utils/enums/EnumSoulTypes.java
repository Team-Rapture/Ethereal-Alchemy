package teamrapture.etherealalchemy.utils.enums;

//TODO FIGURE OUT HOW TO IMPLEMENT THESE WITH SOULS &&& SPELLS
public enum  EnumSoulTypes {
    GENTLE(0),
    PREYING(1),
    DISTURBED(2),
    SENSIBLE(3),
    PLIABLE(4),
    PERPETUAL(5);

    private int index;

    private EnumSoulTypes(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static EnumSoulTypes getTypeByIndex(int index) {
        for (EnumSoulTypes type : values()) {
            if(type.getIndex() == index) {
                return type;
            }
        }

        return null;
    }
}
