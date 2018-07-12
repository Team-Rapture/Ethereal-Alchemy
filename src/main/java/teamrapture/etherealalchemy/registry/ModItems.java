package teamrapture.etherealalchemy.registry;

import net.minecraft.item.Item;
import teamrapture.etherealalchemy.items.SpiritualBone;
import teamrapture.etherealalchemy.items.KnowledgeGem;
import teamrapture.etherealalchemy.items.soulphial.FilledSoulPhial;
import teamrapture.etherealalchemy.items.soulphial.SoulPhial;
import teamrapture.etherealalchemy.items.soulphial.UnFiredSoulPhial;
import teamrapture.etherealalchemy.proxy.CommonProxy;

public class ModItems {

    public static KnowledgeGem knowledgeGem = new KnowledgeGem();
    public static SoulPhial soulPhial = new SoulPhial();
    public static FilledSoulPhial filledSoulPhial = new FilledSoulPhial();
    public static UnFiredSoulPhial unFiredSoulPhial = new UnFiredSoulPhial();
    public static SpiritualBone spiritualBone = new SpiritualBone();

    public static void addToList() {
        register(knowledgeGem);
        register(soulPhial);
        register(filledSoulPhial);
        register(unFiredSoulPhial);
        register(spiritualBone);
    }

    public static void register(Item item) {
        CommonProxy.ITEM_REGISTRY.add(item);
    }
}
