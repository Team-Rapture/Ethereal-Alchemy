package teamrapture.etherealalchemy.client.render.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
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
import teamrapture.etherealalchemy.entity.EntitySoulBase;
import teamrapture.etherealalchemy.utils.enums.EnumAnimalTypes;

import javax.annotation.Nullable;

public class RenderEntitySoul extends RenderLiving {

    private ResourceLocation textureLocation;

    public RenderEntitySoul(RenderManager rendermanagerIn) {
        super(rendermanagerIn, null, 0f);
    }

    public void soulRender(EntitySoulBase entity, double x, double y, double z, float entityYaw, float partialTicks) {
        EntityLiving soulEntity = this.getSoulToRender(entity, entity.world);
        GlStateManager.pushMatrix();
        GlStateManager.blendFunc(770, 1);
        GlStateManager.alphaFunc(516, 0.02f);
        GlStateManager.enableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.3f);
        final Render renderer = Minecraft.getMinecraft().getRenderManager().entityRenderMap.get(EnumAnimalTypes.getTypeByID(entity.getDataManager().get(entity.ENTITY_TYPE)).getEntityClass());
        renderer.doRender(soulEntity, x, y, z, entityYaw, partialTicks);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.blendFunc(770, 1);
        GlStateManager.alphaFunc(516, 0.02f);
        GlStateManager.enableBlend();
        this.renderLeash((EntitySoulBase) entity, x, y, z, entityYaw, partialTicks);
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

    @Override
    protected void renderModel(EntityLivingBase entityLivingBase, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        if(entityLivingBase instanceof EntitySoulBase) {
            EntitySoulBase entitySoulBase = (EntitySoulBase) entityLivingBase;
            if (mainModel == null) {
                try {
                    mainModel = (ModelBase) EnumAnimalTypes.getTypeByID(entitySoulBase.getDataManager().get(entitySoulBase.ENTITY_TYPE)).getRenderClass().newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        super.renderModel(entityLivingBase, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        if(entity instanceof EntitySoulBase) {
            EntitySoulBase entitySoulBase = (EntitySoulBase) entity;
            if(textureLocation == null) {
                return textureLocation = EnumAnimalTypes.getTypeByID(entitySoulBase.getDataManager().get(entitySoulBase.ENTITY_TYPE)).getLocation();
            }

            return textureLocation;
        }

        return null;
    }

    public EntityLiving getSoulToRender(EntitySoulBase entity, World world) {
        EntityLiving soulEntity = (EntityLiving) EntityList.createEntityByIDFromName(new ResourceLocation(entity.entityTypeString), world);
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
