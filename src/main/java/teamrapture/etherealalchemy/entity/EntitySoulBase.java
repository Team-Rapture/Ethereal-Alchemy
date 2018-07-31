package teamrapture.etherealalchemy.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntitySoulBase extends EntityAnimal {

    public static final DataParameter<Integer> ENTITY_TYPE = EntityDataManager.<Integer>createKey(EntitySoulBase.class, DataSerializers.VARINT);
    private int entityType;

    public EntitySoulBase(World world) {
        super(world);
        this.entityType = EntityList.getID(EntityPig.class);
    }

    public EntitySoulBase(World world, int type) {
        super(world);
        this.entityType = type;
        this.getDataManager().set(ENTITY_TYPE, type);
        this.setInvisible(false);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.getDataManager().register(ENTITY_TYPE, entityType);
    }

    @Override
    public void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(2, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 1.0D));
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    public int getEntityType() {
        return this.dataManager.get(ENTITY_TYPE);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        this.setDead();
        return super.processInteract(player, hand);
    }

    @Override
    public boolean canBeRidden(Entity entityIn) {
        return false;
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }
}
