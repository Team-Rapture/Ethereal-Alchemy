package teamrapture.etherealalchemy.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityKnowledge extends EntityLiving {

    private int ticksAlive;
    private EntityPlayer thrower;
    private double x;
    private double y;
    private double z;
    private int moved;

    public EntityKnowledge(World world) {
        super(world);
    }

    public EntityKnowledge(World worldIn, EntityPlayer player) {
        super(worldIn);
        this.thrower = player;
        this.posX = player.getPosition().getX();
        this.posY = player.getPosition().getY() + 1;
        this.posZ = player.getPosition().getZ();
        this.noClip = false;
        this.setSize(3, 3);
        this.setLocationAndAngles(player.posX, player.posY + 1, player.posZ, player.rotationYaw, player.rotationPitch);
        this.ticksAlive = 0;
        this.x = MathHelper.sin(this.rotationYaw * 0.017453292F) * MathHelper.cos(this.rotationPitch * 0.017453292F);
        this.y = MathHelper.sin(this.rotationPitch * 0.017453292F);
        this.z = MathHelper.cos(this.rotationYaw * 0.017453292F) * MathHelper.cos(this.rotationPitch * 0.017453292F);
        this.moved = 0;
        this.setEntityInvulnerable(true);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if(moved < 3) {
            moved++;
            posX+=x;
            posY+=y;
            posZ+=z;
        }
    }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        return super.processInteract(player, hand);
    }

    @Override
    protected boolean canBeRidden(Entity entityIn) {
        return false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public boolean isNonBoss() {
        return true;
    }

    @Override
    public boolean isEntityInvulnerable(DamageSource source) {
        return true;
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
    }
}
