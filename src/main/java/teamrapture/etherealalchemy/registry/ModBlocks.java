package teamrapture.etherealalchemy.registry;

import net.minecraft.block.Block;
import teamrapture.etherealalchemy.proxy.CommonProxy;

public class ModBlocks {

    public static void addToList() {
    }

    public static void register(Block block) {
        CommonProxy.BLOCK_REGISTRY.add(block);
    }
}
