package teamrapture.etherealalchemy.utils.recipes;

import com.google.common.collect.Maps;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;
import teamrapture.etherealalchemy.registry.ModItems;
import teamrapture.etherealalchemy.tiles.TileSoulPedestal;
import teamrapture.etherealalchemy.utils.EnumPedestalType;

import java.util.Iterator;
import java.util.Map;

public class PedestalRecipeHandler {

    private static PedestalRecipeHandler INSTANCE = new PedestalRecipeHandler();
    private Map<ItemStack, PlusRecipes> plusRecipes = Maps.<ItemStack, PlusRecipes>newHashMap();

    public static PedestalRecipeHandler getInstance() {
        return INSTANCE;
    }

    public PedestalRecipeHandler() {
        this.addPlusRecipe(new ItemStack(ModItems.filledSoulPhial), new ItemStack(Items.BONE), new ItemStack(ModItems.spiritualBone));
    }

    public void addPlusRecipe(ItemStack center, ItemStack outside, ItemStack output) {
        plusRecipes.put(center, new PlusRecipes(center, outside, output));
    }

    public PlusRecipes getPlusForStack(ItemStack stack) {
        for (Map.Entry<ItemStack, PlusRecipes> entry : this.plusRecipes.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }

    public boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
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

    public class DiamondRecipes {

        public ItemStack armorPiece;
        public ItemStack output;
        public ItemStack[] inputs;

        public DiamondRecipes(ItemStack armorPiece, ItemStack output, ItemStack[] inputs) {
            this.armorPiece = armorPiece;
            this.output = output;
            this.inputs = inputs;
        }

        public ItemStack getArmorPiece() {
            return armorPiece;
        }

        public ItemStack getOutput() {
            return output;
        }

        public ItemStack[] getInputs() {
            return inputs;
        }
    }
}
