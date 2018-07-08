package teamrapture.etherealalchemy.registry;

import net.minecraft.item.Item;
import teamrapture.etherealalchemy.items.KnowledgeGem;
import teamrapture.etherealalchemy.proxy.CommonProxy;

public class ModItems {

    public static KnowledgeGem knowledgeGem = new KnowledgeGem();

    public static void addToList() {
        register(knowledgeGem);
    }

    public static void register(Item item) {
        CommonProxy.ITEM_REGISTRY.add(item);
    }
}
