package teamrapture.etherealalchemy.utils.recipes;

import com.google.common.collect.Maps;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;
import scala.actors.threadpool.Arrays;
import teamrapture.etherealalchemy.registry.ModItems;
import teamrapture.etherealalchemy.tiles.TileSoulPedestal;
import teamrapture.etherealalchemy.utils.enums.EnumPedestalTypes;
import teamrapture.etherealalchemy.utils.ListUtils;

import java.util.*;

public class PedestalRecipeHandler {

    private static PedestalRecipeHandler INSTANCE = new PedestalRecipeHandler();
    private Map<ItemStack, PlusRecipes> plusRecipes = Maps.<ItemStack, PlusRecipes>newHashMap();
    private Map<ItemStack, DiamondRecipes> diamondRecipes = Maps.<ItemStack, DiamondRecipes>newHashMap();
    private Map<ItemStack, CircleRecipes> circleRecipes = Maps.<ItemStack, CircleRecipes>newHashMap();

    public static PedestalRecipeHandler getInstance() {
        return INSTANCE;
    }

    public PedestalRecipeHandler() {
        this.addPlusRecipe(new ItemStack(ModItems.filledSoulPhial), new ItemStack(Items.BONE), new ItemStack(ModItems.spiritualBone));

        //TODO TEST RECIPES, REMOVE LATER
        this.addCircleRecipe(new ItemStack(Items.EMERALD), new ItemStack(Items.DIAMOND_SWORD), new ItemStack[]{new ItemStack(Items.DIAMOND), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.GOLD_INGOT)});
        this.addDiamondRecipe(new ItemStack(Items.LEATHER_CHESTPLATE), new ItemStack(Items.DIAMOND_CHESTPLATE), new ItemStack[]{new ItemStack(Items.DIAMOND), new ItemStack(Items.DIAMOND), new ItemStack(Items.DIAMOND), new ItemStack(Items.DIAMOND)});
    }

    public void addPlusRecipe(ItemStack center, ItemStack outside, ItemStack output) {
        plusRecipes.put(center, new PlusRecipes(center, outside, output));
    }

    public void addDiamondRecipe(ItemStack armorPiece, ItemStack output, ItemStack[] inputs) {
        diamondRecipes.put(armorPiece, new DiamondRecipes(armorPiece, output, inputs));
    }

    public void addCircleRecipe(ItemStack armorPiece, ItemStack output, ItemStack[] inputs) {
        circleRecipes.put(armorPiece, new CircleRecipes(armorPiece, output, inputs));
    }

    public PlusRecipes getPlusForStack(ItemStack stack) {
        for (Map.Entry<ItemStack, PlusRecipes> entry : this.plusRecipes.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }

    public DiamondRecipes getDiamondForStack(ItemStack stack) {
        for (Map.Entry<ItemStack, DiamondRecipes> entry : this.diamondRecipes.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }

    public CircleRecipes getCircleForStack(ItemStack stack) {
        for (Map.Entry<ItemStack, CircleRecipes> entry : this.circleRecipes.entrySet()) {
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
            for (Iterator<BlockPos> it = EnumPedestalTypes.PLUS.blocksList.iterator(); it.hasNext(); ) {
                BlockPos blockPos = pos.add(it.next());
                TileSoulPedestal tile = (TileSoulPedestal) world.getTileEntity(blockPos);
                tile.setStack(getOutput());

                world.spawnEntity(new EntityLightningBolt(world, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ(), false));
            }
        }

        public boolean containKeys(World world, BlockPos pos) {
            for (Iterator<BlockPos> it = EnumPedestalTypes.PLUS.blocksList.iterator(); it.hasNext(); ) {
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
        public List<ItemStack> inputs;
        public List<ItemStack> itemsInput;

        public DiamondRecipes(ItemStack armorPiece, ItemStack output, ItemStack[] inputs) {
            this.armorPiece = armorPiece;
            this.output = output;
            this.inputs = Arrays.asList(inputs);
            this.itemsInput = new ArrayList<ItemStack>();
        }

        public ItemStack getArmorPiece() {
            return armorPiece;
        }

        public ItemStack getOutput() {
            return output;
        }

        public List<ItemStack> getInputs() {
            return inputs;
        }

        public void setRecipe(World world, BlockPos pos) {
            TileSoulPedestal tile1 = (TileSoulPedestal) world.getTileEntity(pos);
            tile1.setStack(getOutput());
            for (Iterator<BlockPos> it = EnumPedestalTypes.DIAMOND.blocksList.iterator(); it.hasNext(); ) {
                BlockPos blockPos = pos.add(it.next());
                TileSoulPedestal tilePed = (TileSoulPedestal) world.getTileEntity(blockPos);
                if(!tilePed.isEmpty()) {
                    tilePed.setStack(ItemStack.EMPTY);
                    world.spawnEntity(new EntityLightningBolt(world, tilePed.getPos().getX(), tilePed.getPos().getY(), tilePed.getPos().getZ(), false));
                }
            }
        }

        public boolean containKeys(World world, BlockPos pos) {
            for (Iterator<BlockPos> it = EnumPedestalTypes.DIAMOND.blocksList.iterator(); it.hasNext(); ) {
                BlockPos blockPos = pos.add(it.next());
                TileSoulPedestal tile = (TileSoulPedestal) world.getTileEntity(blockPos);
                if(!tile.isEmpty()) {
                    itemsInput.add(tile.getStack());
                }

                if(!it.hasNext()) {
                    if(ListUtils.areListsEqual(inputs, itemsInput)) {
                        itemsInput.clear();
                        return true;
                    }else {
                        itemsInput.clear();
                        return false;
                    }
                }
            }
            itemsInput.clear();
            return false;
        }
    }

    public class CircleRecipes {

        public ItemStack armorPiece;
        public ItemStack output;
        public List<ItemStack> inputs;
        public List<ItemStack> itemsInput;

        public CircleRecipes(ItemStack armorPiece, ItemStack output, ItemStack[] inputs) {
            this.armorPiece = armorPiece;
            this.output = output;
            this.inputs = Arrays.asList(inputs);
            this.itemsInput = new ArrayList<ItemStack>();
        }

        public ItemStack getArmorPiece() {
            return armorPiece;
        }

        public ItemStack getOutput() {
            return output;
        }

        public List<ItemStack> getInputs() {
            return inputs;
        }

        public void setRecipe(World world, BlockPos pos) {
            TileSoulPedestal tile1 = (TileSoulPedestal) world.getTileEntity(pos);
            tile1.setStack(getOutput());
            for (Iterator<BlockPos> it = EnumPedestalTypes.CIRCLE.blocksList.iterator(); it.hasNext(); ) {
                BlockPos blockPos = pos.add(it.next());
                TileSoulPedestal tilePed = (TileSoulPedestal) world.getTileEntity(blockPos);
                if(!tilePed.isEmpty()) {
                    tilePed.setStack(ItemStack.EMPTY);
                    world.spawnEntity(new EntityLightningBolt(world, tilePed.getPos().getX(), tilePed.getPos().getY(), tilePed.getPos().getZ(), false));
                }
            }
        }

        public boolean containKeys(World world, BlockPos pos) {
            for (Iterator<BlockPos> it = EnumPedestalTypes.CIRCLE.blocksList.iterator(); it.hasNext(); ) {
                BlockPos blockPos = pos.add(it.next());
                TileSoulPedestal tile = (TileSoulPedestal) world.getTileEntity(blockPos);
                if(!tile.isEmpty()) {
                    itemsInput.add(tile.getStack());
                }

                if(!it.hasNext()) {
                    if(ListUtils.areListsEqual(inputs, itemsInput)) {
                        itemsInput.clear();
                        return true;
                    }else {
                        itemsInput.clear();
                        return false;
                    }
                }
            }
            itemsInput.clear();
            return false;
        }
    }
}
