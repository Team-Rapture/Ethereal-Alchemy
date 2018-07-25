package teamrapture.etherealalchemy.registry;

import net.minecraft.block.Block;
import teamrapture.etherealalchemy.blocks.BlockPedestal;
import teamrapture.etherealalchemy.blocks.BlockSoulChamber;
import teamrapture.etherealalchemy.blocks.BlockSoulChamberTop;
import teamrapture.etherealalchemy.proxy.CommonProxy;

public class ModBlocks {

    public static BlockPedestal blockPedestal = new BlockPedestal();
    public static BlockSoulChamber blockSoulChamber = new BlockSoulChamber();
    public static BlockSoulChamberTop blockSoulChamberTop = new BlockSoulChamberTop();

    public static void addToList() {
        register(blockPedestal);
        register(blockSoulChamber);
        register(blockSoulChamberTop);
    }

    public static void register(Block block) {
        CommonProxy.BLOCK_REGISTRY.add(block);
    }
}
