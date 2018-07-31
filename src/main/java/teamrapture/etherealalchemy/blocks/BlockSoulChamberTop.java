package teamrapture.etherealalchemy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import teamrapture.etherealalchemy.registry.ModBlocks;

public class BlockSoulChamberTop extends BlockBase {

    public BlockSoulChamberTop() {
        super(Material.ROCK, "soul_chamber_top", 2.0f);
        this.setSoundType(SoundType.GLASS);
        this.setCreativeTab(null);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        drops.clear();
        drops.add(new ItemStack(ModBlocks.blockSoulChamber));
    }
}
