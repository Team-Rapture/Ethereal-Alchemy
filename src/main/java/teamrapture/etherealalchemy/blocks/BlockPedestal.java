package teamrapture.etherealalchemy.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;
import teamrapture.etherealalchemy.tiles.TileSoulPedestal;
import teamrapture.etherealalchemy.utils.InventoryUtils;

import javax.annotation.Nullable;

public class BlockPedestal extends BlockBase {

    public BlockPedestal() {
        super(Material.ROCK, "soul_pedestal", 1.5f);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileSoulPedestal tile = (TileSoulPedestal) world.getTileEntity(pos);
        if (tile != null) {
            if (!player.isSneaking()) {
                if (tile.isEmpty() && !player.getHeldItemMainhand().isEmpty()) {
                    tile.setStack(new ItemStack(player.getHeldItemMainhand().getItem(), 1));
                    InventoryUtils.shrink(player);
                } else if (!tile.isEmpty() && player.getHeldItemMainhand().isEmpty()) {
                    player.setHeldItem(EnumHand.MAIN_HAND, tile.getStack());
                    tile.setStack(ItemStack.EMPTY);
                } else if (!tile.isEmpty() && !player.getHeldItemMainhand().isEmpty() && ItemHandlerHelper.canItemStacksStack(tile.getStack(), player.getHeldItemMainhand())) {
                    if(player.getHeldItemMainhand().getCount() < player.getHeldItemMainhand().getMaxStackSize()) {
                        player.getHeldItemMainhand().grow(1);
                        tile.setStack(ItemStack.EMPTY);
                    }
                } else {
                    return false;
                }
            } else {
                tile.startWorking();
            }
        } else {
            return false;
        }

        return true;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        TileSoulPedestal tile = (TileSoulPedestal) worldIn.getTileEntity(pos);
        if(tile != null && !tile.isEmpty()) {
            if(!worldIn.isRemote) {
                worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tile.getStack()));
            }
        }
        super.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public String getGuideInformation() {
        return I18n.format("soul_pedestal.entry");
    }

    @Override
    public ResourceLocation getEntryIcon() {
        return null;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileSoulPedestal();
    }
}
