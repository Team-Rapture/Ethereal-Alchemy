package teamrapture.etherealalchemy.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import teamrapture.etherealalchemy.EtherealAlchemy;
import teamrapture.etherealalchemy.api.IGuideEntryHandler;

import javax.annotation.Nullable;

public class BlockBase extends BlockContainer implements IGuideEntryHandler {

    protected BlockBase(Material material, String name, float hardness) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(EtherealAlchemy.tabEthereal);
        this.setHardness(hardness);
        this.setHarvestLevel("pickaxe", 1);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isTranslucent(IBlockState state) {
        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

    @Override
    public String getGuideInformation() {
        return null;
    }

    @Override
    public ResourceLocation getEntryIcon() {
        return null;
    }
}
