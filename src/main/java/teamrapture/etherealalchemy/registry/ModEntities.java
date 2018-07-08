package teamrapture.etherealalchemy.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import teamrapture.etherealalchemy.EtherealAlchemy;
import teamrapture.etherealalchemy.Info;

public class ModEntities {

    public static void registerEntities() {

    }

    public static void renderEntities() {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        //renderManager.entityRenderMap.put(EntityHere.class, new RENDERENTITY(renderManager));
    }

    public static void createEntity(Class entityClass, String entityName, int ID) {
        EntityRegistry.registerModEntity(new ResourceLocation(Info.MODID, entityName), entityClass, entityName, ID, EtherealAlchemy.instance, 64, 1, false);
    }
}
