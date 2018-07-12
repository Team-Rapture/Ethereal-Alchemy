package teamrapture.etherealalchemy.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import teamrapture.etherealalchemy.registry.ModItems;

public class EntityInvincible extends EntityItem {

    public EntityInvincible(World worldIn) {
        super(worldIn);
        isImmuneToFire = true;
    }

    public EntityInvincible(EntityItem item) {
        this(item.getEntityWorld());
        readFromNBT(item.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public boolean isBurning() {
        return false;
    }

    @Override
    public boolean isEntityInvulnerable(DamageSource source) {
        if(source == DamageSource.IN_FIRE) {
            ItemStack stack = getItem().copy();
            if (stack.getItem() == ModItems.unFiredSoulPhial) {
                setItem(new ItemStack(ModItems.soulPhial, stack.getCount(), 0));
            }
            return true;
        }else {
            return super.isEntityInvulnerable(source);
        }
    }
}
