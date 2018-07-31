package teamrapture.etherealalchemy.utils.enums;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.List;

public enum EnumKeyTypes {
    CLOTHING(new Item[]{Items.LEATHER_HELMET, Items.LEATHER_CHESTPLATE, Items.LEATHER_LEGGINGS, Items.LEATHER_BOOTS, Items.IRON_HELMET, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS,Items.GOLDEN_HELMET, Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS, Items.GOLDEN_BOOTS,Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS,Items.CHAINMAIL_HELMET, Items.CHAINMAIL_CHESTPLATE, Items.CHAINMAIL_LEGGINGS, Items.CHAINMAIL_BOOTS }),
    FEAR(new Item[]{Items.ROTTEN_FLESH, Items.SPIDER_EYE, Items.GHAST_TEAR, Items.ENDER_PEARL,Items.SLIME_BALL, Items.BLAZE_ROD}),
    FOOD(new Item[]{Items.CARROT, Items.BAKED_POTATO, Items.COOKED_BEEF, Items.COOKED_CHICKEN, Items.COOKED_FISH, Items.COOKED_MUTTON, Items.COOKED_PORKCHOP,Items.COOKED_RABBIT,Items.BEETROOT_SOUP,Items.MUSHROOM_STEW}),
    WEAPON(new Item[]{Items.BOW, Items.WOODEN_SWORD, Items.STONE_SWORD,Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.DIAMOND_SWORD,Items.SHIELD}),
    TREASURE(new Item[]{Items.GOLD_INGOT, Items.DIAMOND, Items.EMERALD});

    private List<Item> keyValues;

    private EnumKeyTypes(Item[] keys) {
        keyValues = Arrays.asList(keys);
    }

    public List<Item> getKeyValues() {
        return keyValues;
    }
}
