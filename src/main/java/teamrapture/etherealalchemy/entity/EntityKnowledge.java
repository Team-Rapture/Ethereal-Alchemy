package teamrapture.etherealalchemy.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityKnowledge extends EntityLiving {

    private int ticksAlive;
    private EntityPlayer thrower;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;
    private int moved;

    public EntityKnowledge(World world) {
        super(world);
    }

    public EntityKnowledge(World worldIn, EntityPlayer player) {
        super(worldIn);
        this.thrower = player;
        this.setSize(2, 2);
        this.setLocationAndAngles(player.posX, player.posY + 1, player.posZ, player.rotationYaw, player.rotationPitch);
        this.noClip = false;
        this.ticksAlive = 0;
        this.moved = 0;
        this.setEntityInvulnerable(true);
        this.resetPositionToBB();
        this.setNoGravity(true);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        double accelX = 1.0f;
        double accelY = 1.0f;
        double accelZ = 1.0f;
        accelX = accelX + this.rand.nextGaussian() * 0.4D;
        accelY = accelY + this.rand.nextGaussian() * 0.4D;
        accelZ = accelZ + this.rand.nextGaussian() * 0.4D;
        double d0 = (double)MathHelper.sqrt(accelX * accelX + accelY * accelY + accelZ * accelZ);
        this.accelerationX = accelX / d0 * 0.1D;
        this.accelerationY = accelY / d0 * 0.1D;
        this.accelerationZ = accelZ / d0 * 0.1D;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    protected void collideWithEntity(Entity entityIn) {
        if(moved < 3) {

        }else {
            this.motionX = 0;
            this.motionY = 0;
            this.motionZ = 0;
        }
    }

    @Override
    public boolean isInRangeToRenderDist(double distance) {
        double distance1 = (this.getEntityBoundingBox().getAverageEdgeLength() * 4) * 64;
        return distance < distance1 * distance1;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if(moved < 16) {
            moved++;

            this.motionX += this.accelerationX;
            this.motionZ += this.accelerationZ;
            this.motionX *= 1.01;
            this.motionZ *= 1.01;
        }else {
            ticksAlive++;
        }

        if(ticksAlive >= (20 * 15)) {
            ticksAlive = 0;
            //this.setDead();
        }
    }

    @Override
    public boolean isEntityInvulnerable(DamageSource source) {
        return true;
    }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        ticksAlive = 0;
        this.setDead();
        return true;
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
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
    }
}
