package teamrapture.etherealalchemy.client.render.tesr;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import teamrapture.etherealalchemy.tiles.TileSoulChamber;
import teamrapture.etherealalchemy.utils.enums.EnumAnimalTypes;

public class RenderSoulChamber extends TileEntitySpecialRenderer<TileSoulChamber> {

    @Override
    public void render(TileSoulChamber te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        if(te.hasEntity) {
            GlStateManager.pushMatrix();
            EntityLiving soulEntity = (EntityLiving) EntityList.createEntityByID(te.entityID, te.getWorld());
            Render renderer = Minecraft.getMinecraft().getRenderManager().entityRenderMap.get(EnumAnimalTypes.getTypeByID(te.entityID).getEntityClass());
            GlStateManager.scale(0.8, 0.8, 0.8);
            GlStateManager.translate(x, y + 0.5, z);
            renderer.doRender(soulEntity, x, y + 0.5, z, 0, partialTicks);
            GlStateManager.popMatrix();
        }
    }
}
