package teamrapture.etherealalchemy.tiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import teamrapture.etherealalchemy.entity.EntitySoulBase;
import teamrapture.etherealalchemy.utils.enums.EnumAnimalTypes;

import java.util.List;

public class TileSoulChamber extends TileEntityBase {

    public boolean hasEntity;
    public int entityID;

    public TileSoulChamber() {
        hasEntity = false;
        entityID = -1;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        nbt.setBoolean("hasEntity", hasEntity);
        nbt.setInteger("entityStored", entityID);
        return super.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        hasEntity = nbt.getBoolean("hasEntity");
        entityID = nbt.getInteger("entityStored");
        super.readFromNBT(nbt);
    }

    @Override
    public void update() {
        if(!hasEntity && world.isBlockPowered(pos)) {
            AxisAlignedBB boundingBox = new AxisAlignedBB(pos.getX() - 2, pos.getY() - 2, pos.getZ() - 2, pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2);
            List<Entity> entities = world.getEntitiesWithinAABB(EntityLiving.class, boundingBox);
            for (Entity entity : entities) {
                if(!(entity instanceof EntityPlayer) && !(entity instanceof EntitySoulBase) && (entity instanceof EntityLiving || entity instanceof EntityLivingBase)) {
                    if(EnumAnimalTypes.getTypeByID(EntityList.getID(entity.getClass())) != null) {
                        hasEntity = true;
                        entityID = EntityList.getID(entity.getClass());
                        entity.setDead();
                        break;
                    }
                }
            }
        }

        if(hasEntity && world.isBlockPowered(pos)) {
                EntitySoulBase entitySoulBase = new EntitySoulBase(world, entityID);
                entitySoulBase.setPosition(pos.getX(), pos.getY() + 2, pos.getZ());
                world.spawnEntity(entitySoulBase);

                hasEntity = false;
                entityID = -1;
        }
    }

    public void run() {
        if(canRun()) {

        }
    }

    public boolean canRun() {

        return false;
    }

    public boolean hasItems() {

        return false;
    }
}
