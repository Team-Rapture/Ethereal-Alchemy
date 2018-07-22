package teamrapture.etherealalchemy.utils.enums;

import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.List;

public enum EnumKeyTypes {
    CLOTHING(new Item[]{}),
    FEAR(new Item[]{}),
    FOOD(new Item[]{}),
    WEAPON(new Item[]{}),
    TREASURE(new Item[]{});

    private List<Item> keyValues;

    private EnumKeyTypes(Item[] keys) {
        keyValues = Arrays.asList(keys);
    }

    public List<Item> getKeyValues() {
        return keyValues;
    }
}
