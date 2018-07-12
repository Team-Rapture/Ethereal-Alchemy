package teamrapture.etherealalchemy.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import teamrapture.etherealalchemy.registry.ModItems;

public class EntityFireSafeItem extends EntityItem {
    public EntityFireSafeItem(World worldIn) {
        super(worldIn);
        isImmuneToFire = true;
    }

    public EntityFireSafeItem(EntityItem item) {
        this(item.getEntityWorld());
        readEntityFromNBT(item.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public boolean isBurning() {
        return false;
    }

    @Override
    public boolean isEntityInvulnerable(DamageSource source) {
        if(source == DamageSource.IN_FIRE){
            if(getItem().getItem() == ModItems.unFiredSoulPhial){
                setItem(new ItemStack(ModItems.soulPhial,1,0));
                }
            }

        return super.isEntityInvulnerable(source);
    }
}
