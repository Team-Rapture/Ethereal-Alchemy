package teamrapture.etherealalchemy.client.render.tesr;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemBlock;
import org.lwjgl.opengl.GL11;
import teamrapture.etherealalchemy.tiles.TileSoulPedestal;
import teamrapture.etherealalchemy.utils.shader.ShaderHelper;
import teamrapture.etherealalchemy.utils.shader.ShaderIcons;

public class RenderSoulPedestal extends TileEntitySpecialRenderer<TileSoulPedestal> {

    @Override
    public void render(TileSoulPedestal te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        if(te != null) {
            if(!te.getStack().isEmpty()) {
                GlStateManager.pushMatrix();
                if(te.getStack().getItem() instanceof ItemBlock) {
                    GlStateManager.translate(x + 0.5, y + 0.75, z + 0.5);
                    GlStateManager.scale(0.8f, 0.8f, 0.8f);
                }else {
                    GlStateManager.translate(x + 0.5, y + 0.85, z + 0.5);
                    GlStateManager.scale(0.65f, 0.65f, 0.65f);
                }

                if(te.isWorking) {
                    GlStateManager.rotate(System.currentTimeMillis() * 4 % 360, 0, 1, 0);
                    switch (te.checkShape()) {
                        case CIRCLE:
                            break;
                        case DIAMOND:
                            break;
                        case PLUS:
                            GlStateManager.pushMatrix();
                            GlStateManager.enableBlend();
                            GlStateManager.enableCull();
                            GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                            GlStateManager.disableAlpha();
                            GlStateManager.color(1F, 1F, 1F, 0.9f);
                            GlStateManager.translate(x, y + 5, z);
                            //GlStateManager.rotate(90F, 1F, 0F, 0F);
                            GlStateManager.scale(1, 1, 1);

                            ShaderHelper.useShader(ShaderHelper.pedestalStar);
                            renderIcon(0, 0, ShaderIcons.pedestalStar, 16, 16, 240);
                            ShaderHelper.releaseShader();

                            GlStateManager.disableCull();
                            GlStateManager.enableAlpha();
                            GlStateManager.disableBlend();
                            GlStateManager.popMatrix();
                            break;
                    }
                }else {
                    GlStateManager.rotate((System.currentTimeMillis() / 10) % 360, 0, 1, 0);
                }
                RenderHelper.disableStandardItemLighting();
                GlStateManager.alphaFunc(516, 0.003921569F);
                Minecraft.getMinecraft().getRenderItem().renderItem(te.getStack(), ItemCameraTransforms.TransformType.GROUND);
                GlStateManager.popMatrix();
            }
        }
    }

    public void renderIcon(int par1, int par2, TextureAtlasSprite par3Icon, int par4, int par5, int brightness) {
        Tessellator tessellator = Tessellator.getInstance();
        if(par3Icon != null) {
            tessellator.getBuffer().begin(GL11.GL_QUADS, ShaderHelper.POSITION_TEX_LMAP);
            tessellator.getBuffer().pos(par1 + 0, par2 + par5, 0).tex(par3Icon.getMinU(), par3Icon.getMaxV()).lightmap(brightness, brightness).endVertex();
            tessellator.getBuffer().pos(par1 + par4, par2 + par5, 0).tex(par3Icon.getMaxU(), par3Icon.getMaxV()).lightmap(brightness, brightness).endVertex();
            tessellator.getBuffer().pos(par1 + par4, par2 + 0, 0).tex(par3Icon.getMaxU(), par3Icon.getMinV()).lightmap(brightness, brightness).endVertex();
            tessellator.getBuffer().pos(par1 + 0, par2 + 0, 0).tex(par3Icon.getMinU(), par3Icon.getMinV()).lightmap(brightness, brightness).endVertex();
            tessellator.draw();
        }
    }

    @Override
    public boolean isGlobalRenderer(TileSoulPedestal te) {
        return true;
    }
}
