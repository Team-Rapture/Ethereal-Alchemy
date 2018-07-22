package teamrapture.etherealalchemy.client.render.tesr;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemBlock;
import teamrapture.etherealalchemy.tiles.TileSoulPedestal;

//TODO RENDERING FOR PEDESTAL EFFECTS
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
                }else {
                    GlStateManager.rotate((System.currentTimeMillis() / 10) % 360, 0, 1, 0);
                }
                RenderHelper.disableStandardItemLighting();
                GlStateManager.alphaFunc(516, 0.003921569F);
                Minecraft.getMinecraft().getRenderItem().renderItem(te.getStack(), ItemCameraTransforms.TransformType.GROUND);
                GlStateManager.popMatrix();

                /**
                 * doing rendering last
                if(te.isWorking) {
                    switch (te.checkShape()) {
                        case CIRCLE:
                            break;
                        case DIAMOND:
                            break;
                        case PLUS:
                            break;
                    }
                }
                */
            }
        }
    }

    @Override
    public boolean isGlobalRenderer(TileSoulPedestal te) {
        return false;
    }
}
