package teamrapture.etherealalchemy.utils.recipes;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;
import teamrapture.etherealalchemy.registry.ModItems;
import teamrapture.etherealalchemy.tiles.TileSoulPedestal;
import teamrapture.etherealalchemy.utils.EnumPedestalType;

import java.util.HashMap;
import java.util.Iterator;

public class PedestalRecipeHandler {

    public static PedestalRecipeHandler INSTANCE = new PedestalRecipeHandler();
    public HashMap<ItemStack, PlusRecipes> plusRecipes = new HashMap<ItemStack, PlusRecipes>();

    public static PedestalRecipeHandler getInstance() {
        return INSTANCE;
    }

    private PedestalRecipeHandler() {
        addPlusRecipe(new ItemStack(ModItems.filledSoulPhial), new ItemStack(Items.BONE), new ItemStack(ModItems.spiritualBone));
    }

    public void addPlusRecipe(ItemStack center, ItemStack outside, ItemStack output) {
        PlusRecipes recipes = new PlusRecipes(center, outside, output);
        plusRecipes.put(center, new PlusRecipes(center, outside, output));
    }

    public PlusRecipes getPlusForStack(ItemStack stack) {
        if(plusRecipes.containsKey(stack)) {
            return plusRecipes.get(stack);
        }else {
            return null;
        }
    }

    public class PlusRecipes {

        public ItemStack center;
        public ItemStack outside;
        public ItemStack output;

        public PlusRecipes(ItemStack center, ItemStack outside, ItemStack output) {
            this.center = center;
            this.output = output;
            this.outside = outside;
        }

        public ItemStack getCenter() {
            return center;
        }

        public ItemStack getOutside() {
            return outside;
        }

        public ItemStack getOutput() {
            return output;
        }

        public void setRecipe(World world, BlockPos pos) {
            for (Iterator<BlockPos> it = EnumPedestalType.PLUS.blocksList.iterator(); it.hasNext(); ) {
                BlockPos blockPos = pos.add(it.next());
                TileSoulPedestal tile = (TileSoulPedestal) world.getTileEntity(blockPos);
                tile.setStack(getOutput());
                world.spawnEntity(new EntityLightningBolt(world, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ(), false));
            }
        }

        public boolean containKeys(World world, BlockPos pos) {
            for (Iterator<BlockPos> it = EnumPedestalType.PLUS.blocksList.iterator(); it.hasNext(); ) {
                BlockPos blockPos = pos.add(it.next());
                TileSoulPedestal tile = (TileSoulPedestal) world.getTileEntity(blockPos);
                if (ItemHandlerHelper.canItemStacksStack(tile.getStack(), getOutside())) {
                    if(it.hasNext()) {
                        continue;
                    }else {
                        return true;
                    }
                } else {
                    return false;
                }
            }

            return false;
        }
    }
}
