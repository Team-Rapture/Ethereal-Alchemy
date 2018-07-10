package teamrapture.etherealalchemy.registry;

import net.minecraft.block.Block;
import teamrapture.etherealalchemy.blocks.BlockPedestal;
import teamrapture.etherealalchemy.proxy.CommonProxy;

public class ModBlocks {

    public static BlockPedestal blockPedestal = new BlockPedestal();

    public static void addToList() {
        register(blockPedestal);
    }

    public static void register(Block block) {
        CommonProxy.BLOCK_REGISTRY.add(block);
    }
}
