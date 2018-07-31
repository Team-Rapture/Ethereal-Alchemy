package teamrapture.etherealalchemy.client.render.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.etherealalchemy.entity.EntitySoulBase;
import teamrapture.etherealalchemy.utils.enums.EnumAnimalTypes;

import javax.annotation.Nullable;

public class RenderEntitySoul extends RenderLiving {

    public RenderEntitySoul(RenderManager rendermanagerIn) {
        super(rendermanagerIn, null, 0f);
    }

    public void soulRender(EntitySoulBase entity, double x, double y, double z, float entityYaw, float partialTicks) {
        EntityLiving soulEntity = this.getSoulToRender(entity, entity.world);
        GlStateManager.pushMatrix();
        GlStateManager.blendFunc(770, 1);
        GlStateManager.alphaFunc(516, 0.02f);
        GlStateManager.enableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.4f);
        Render renderer = Minecraft.getMinecraft().getRenderManager().entityRenderMap.get(soulEntity.getClass());
        renderer.doRender(soulEntity, x, y, z, entityYaw, partialTicks);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.blendFunc(770, 1);
        GlStateManager.alphaFunc(516, 0.02f);
        GlStateManager.enableBlend();
        this.renderLeash(soulEntity, x, y, z, entityYaw, partialTicks);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Override
    public void doRender(EntityLivingBase entityLivingBase, double x, double y, double z, float entityYaw, float partialTicks) {
        this.soulRender((EntitySoulBase) entityLivingBase, x, y, z, entityYaw, partialTicks);
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        this.soulRender((EntitySoulBase) entity, x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        EntitySoulBase entitySoulBase = (EntitySoulBase) entity;
        return EnumAnimalTypes.getTypeByID(entitySoulBase.getDataManager().get(entitySoulBase.ENTITY_TYPE)).getTextureLoc();
    }

    @SideOnly(Side.CLIENT)
    public EntityLiving getSoulToRender(EntitySoulBase entity, World world) {
        EntityLiving soulEntity = (EntityLiving) EntityList.createEntityByID(entity.getEntityType(), world);
        soulEntity.setPosition(entity.posX, entity.posY, entity.posZ);
        soulEntity.lastTickPosX = entity.lastTickPosX;
        soulEntity.lastTickPosY = entity.lastTickPosY;
        soulEntity.lastTickPosZ = entity.lastTickPosZ;
        soulEntity.motionX = entity.motionX;
        soulEntity.motionY = entity.motionY;
        soulEntity.motionZ = entity.motionZ;
        soulEntity.onGround = entity.onGround;
        soulEntity.prevPosX = entity.prevPosX;
        soulEntity.prevPosY = entity.prevPosY;
        soulEntity.prevPosZ = entity.prevPosZ;
        soulEntity.rotationPitch = entity.rotationPitch;
        soulEntity.rotationYaw = entity.rotationYaw;
        soulEntity.rotationYawHead = entity.rotationYawHead;
        soulEntity.prevRotationPitch = entity.prevRotationPitch;
        soulEntity.prevRotationYaw = entity.prevRotationYaw;
        soulEntity.prevRotationYawHead = entity.prevRotationYawHead;
        soulEntity.limbSwing = entity.limbSwing;
        soulEntity.limbSwingAmount = entity.limbSwingAmount;
        soulEntity.prevLimbSwingAmount = entity.prevLimbSwingAmount;
        soulEntity.isSwingInProgress = entity.isSwingInProgress;
        soulEntity.swingProgress = entity.swingProgress;
        soulEntity.prevSwingProgress = entity.prevSwingProgress;
        soulEntity.renderYawOffset = entity.renderYawOffset;
        soulEntity.prevRenderYawOffset = entity.prevRenderYawOffset;
        soulEntity.ticksExisted = entity.ticksExisted;
        soulEntity.isDead = false;
        soulEntity.isAirBorne = entity.isAirBorne;
        soulEntity.setSneaking(entity.isSneaking());
        soulEntity.setSprinting(entity.isSprinting());
        soulEntity.setInvisible(entity.isInvisible());
        return soulEntity;
    }
}
