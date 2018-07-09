package teamrapture.etherealalchemy.client.render.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import teamrapture.etherealalchemy.Info;
import teamrapture.etherealalchemy.entity.EntityKnowledge;

import javax.annotation.Nullable;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;

public class RenderEntityKnowledge extends Render<EntityKnowledge> {

    public ResourceLocation knowledge_home = new ResourceLocation(Info.MODID, "textures/gui/guide_base.png");
    public ResourceLocation knowledge_ring = new ResourceLocation(Info.MODID, "textures/gui/guide_ring.png");

    public RenderEntityKnowledge(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityKnowledge entity, double x, double y, double z, float entityYaw, float partialTicks) {
        Minecraft mc = Minecraft.getMinecraft();
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y + 0.4, z);
        this.bindTexture(knowledge_home);
        RenderHelper.enableStandardItemLighting();

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.rotate(180.0F - mc.getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(2.5F, 2.5F, 2.5F);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.9f);

        long angle = (System.currentTimeMillis() / 10) % 360;
        //GlStateManager.translate(x, y, z);
        //GlStateManager.rotate(angle, 0, 0, 1);
        //GlStateManager.translate(-x, -y, -z);

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        bufferbuilder.pos(-0.5D, -0.25D, 0.0D).tex(0D, 0D).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(0.5D, -0.25D, 0.0D).tex(0D, 1D).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(0.5D, 0.75D, 0.0D).tex(1D, 1D).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(-0.5D, 0.75D, 0.0D).tex(1D, 0D).normal(0.0F, 1.0F, 0.0F).endVertex();
        tessellator.draw();

        GlStateManager.enableBlend();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.popMatrix();

        doRenderRing(entity, x, y, z);
    }

    public void doRenderRing(EntityKnowledge entity, double x, double y, double z) {
        Minecraft mc = Minecraft.getMinecraft();
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        this.bindTexture(knowledge_ring);
        RenderHelper.enableStandardItemLighting();

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.rotate(180.0F - mc.getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(4.5F, 4.5F, 4.5F);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.9f);

        long angle = (System.currentTimeMillis() / 10) % 360;
        //GlStateManager.translate(x, y, z);
        //GlStateManager.rotate(angle, 0, 0, 1);
        //GlStateManager.translate(-x, -y, -z);

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        bufferbuilder.pos(-0.5D, -0.25D, 0.0D).tex(0D, 0D).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(0.5D, -0.25D, 0.0D).tex(0D, 1D).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(0.5D, 0.75D, 0.0D).tex(1D, 1D).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(-0.5D, 0.75D, 0.0D).tex(1D, 0D).normal(0.0F, 1.0F, 0.0F).endVertex();
        tessellator.draw();

        GlStateManager.enableBlend();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.popMatrix();
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(EntityKnowledge entity) {
        return knowledge_home;
    }
}
