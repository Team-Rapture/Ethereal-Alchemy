package teamrapture.etherealalchemy.registry;

import net.minecraft.item.Item;
import teamrapture.etherealalchemy.items.KnowledgeGem;
import teamrapture.etherealalchemy.items.SoulPhial;
import teamrapture.etherealalchemy.proxy.CommonProxy;

public class ModItems {

    public static KnowledgeGem knowledgeGem = new KnowledgeGem();
    public  static SoulPhial soulPhial = new SoulPhial();
    public static SoulPhial.FilledSoulPhial filledSoulPhial = new SoulPhial.FilledSoulPhial();

    public static void addToList() {
        register(knowledgeGem);
        register(soulPhial);
        register(filledSoulPhial);
    }

    public static void register(Item item) {
        CommonProxy.ITEM_REGISTRY.add(item);
    }
}
