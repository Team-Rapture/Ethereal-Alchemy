package teamrapture.etherealalchemy.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import teamrapture.etherealalchemy.utils.enums.EnumAnimalTypes;

import javax.annotation.Nullable;

public class EntitySoulBase extends EntityAnimal {

    public static final DataParameter<Integer> ENTITY_TYPE = EntityDataManager.<Integer>createKey(EntitySoulBase.class, DataSerializers.VARINT);
    private int entityType;
    private String entityName;
    public String entityTypeString;

    public EntitySoulBase(World world) {
        super(world);
        this.entityType = -1;
        this.entityName = "";
        this.entityTypeString = "Pig";
        this.setCustomNameTag(entityName);

    }

    public EntitySoulBase(World world, int type, String entityType) {
        super(world);
        this.entityType = type;
        this.entityTypeString = entityType;
        this.entityName = EnumAnimalTypes.getTypeByID(type).getSoulName();
        this.setCustomNameTag(entityName);
        this.getDataManager().set(ENTITY_TYPE, type);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(ENTITY_TYPE, entityType);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        this.setDead();
        return super.processInteract(player, hand);
    }

    @Override
    protected boolean canBeRidden(Entity entityIn) {
        return false;
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }
}
