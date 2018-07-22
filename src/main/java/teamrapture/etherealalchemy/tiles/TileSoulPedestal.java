package teamrapture.etherealalchemy.tiles;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import teamrapture.etherealalchemy.registry.ModBlocks;
import teamrapture.etherealalchemy.utils.enums.EnumPedestalTypes;
import teamrapture.etherealalchemy.utils.recipes.PedestalRecipeHandler;

import java.util.Iterator;

public class TileSoulPedestal extends TileEntityBase {

    public boolean isWorking = false;
    private int workTime = 0;
    private int totalWorkTime = 90;
    private ItemStack stack = ItemStack.EMPTY;

    public TileSoulPedestal() {
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        nbt.setBoolean("isWorking", isWorking);
        nbt.setInteger("workTime", workTime);
        nbt.setInteger("totalWorkTime", totalWorkTime);
        return super.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.isWorking = nbt.getBoolean("isWorking");
        workTime = nbt.getInteger("workTime");
        totalWorkTime = nbt.getInteger("totalWorlTime");
    }

    @Override
    public void update() {
        if(isWorking) {
            workTime++;
            //if(workTime >= 90) {
            if(workTime >= 100000) {
                workTime = 0;
                isWorking = false;
                switch (checkShape()) {
                    case PLUS:
                        PedestalRecipeHandler.getInstance().getPlusForStack(stack).setRecipe(world, pos);
                        stack = ItemStack.EMPTY;
                        break;
                    case DIAMOND:
                        PedestalRecipeHandler.getInstance().getDiamondForStack(stack).setRecipe(world, pos);
                        break;
                    case CIRCLE:
                        PedestalRecipeHandler.getInstance().getCircleForStack(stack).setRecipe(world, pos);
                        break;
                }
            }
        }
    }

    public void startWorking() {
        if(canWork()) {
            isWorking = true;
            world.spawnEntity(new EntityLightningBolt(world, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), false));
        }
    }

    public boolean canWork() {
        EnumPedestalTypes type = checkShape();
        if(type != null) {
            switch (type) {
                case PLUS:
                    if(!stack.isEmpty()) {
                        if (PedestalRecipeHandler.getInstance().getPlusForStack(stack) != null) {
                            if (PedestalRecipeHandler.getInstance().getPlusForStack(stack).containKeys(world, pos)) {
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }

                    break;
                case CIRCLE:
                    if(!stack.isEmpty()) {
                        if(PedestalRecipeHandler.getInstance().getCircleForStack(stack) != null) {
                            if(PedestalRecipeHandler.getInstance().getCircleForStack(stack).containKeys(world, pos)) {
                                return true;
                            }else {
                                return false;
                            }
                        }else {
                            return false;
                        }
                    }

                    break;
                case DIAMOND:
                    if(!stack.isEmpty()) {
                        if(PedestalRecipeHandler.getInstance().getDiamondForStack(stack) != null) {
                            if(PedestalRecipeHandler.getInstance().getDiamondForStack(stack).containKeys(world, pos)) {
                                return true;
                            }else {
                                return false;
                            }
                        }else {
                            return false;
                        }
                    }
                    break;
            }
        }else {
            return false;
        }
        return false;
    }

    public EnumPedestalTypes checkShape() {
        for (Iterator<BlockPos> it = EnumPedestalTypes.PLUS.blocksList.iterator(); it.hasNext();) {
            BlockPos blockPos = pos.add(it.next());
            if(!it.hasNext()) {
                return EnumPedestalTypes.PLUS;
            }else {
                if (getState(blockPos).getBlock() == ModBlocks.blockPedestal) {
                    continue;
                } else {
                    break;
                }
            }
        }

        for (Iterator<BlockPos> it = EnumPedestalTypes.CIRCLE.blocksList.iterator(); it.hasNext();) {
            BlockPos blockPos = pos.add(it.next());
            if (!it.hasNext()) {
                return EnumPedestalTypes.CIRCLE;
            }else {
                if (getState(blockPos).getBlock() == ModBlocks.blockPedestal) {
                    continue;
                }else {
                    break;
                }
            }
        }

        for (Iterator<BlockPos> it = EnumPedestalTypes.DIAMOND.blocksList.iterator(); it.hasNext();) {
            BlockPos blockPos = pos.add(it.next());
            if (!it.hasNext()) {
                return EnumPedestalTypes.DIAMOND;
            }else {
                if (getState(blockPos).getBlock() == ModBlocks.blockPedestal) {
                    continue;
                }else {
                    break;
                }
            }
        }

        return null;
    }

    public void setStack(ItemStack itemStack) {
        this.stack = itemStack;
    }

    public ItemStack getStack() {
        return this.stack;
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}
