package teamrapture.etherealalchemy.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import teamrapture.etherealalchemy.EtherealAlchemy;
import teamrapture.etherealalchemy.Info;
import teamrapture.etherealalchemy.client.render.entity.RenderEntityKnowledge;
import teamrapture.etherealalchemy.entity.EntityFireSafeItem;
import teamrapture.etherealalchemy.entity.EntityKnowledge;

public class ModEntities {

    public static void registerEntities() {
        createEntity(EntityKnowledge.class, "entity_knowledge", 0);
        createEntity(EntityFireSafeItem.class, "fire_safe_item",0);
    }

    public static void renderEntities() {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        renderManager.entityRenderMap.put(EntityKnowledge.class, new RenderEntityKnowledge(renderManager));

    }

    public static void createEntity(Class entityClass, String entityName, int ID) {
        EntityRegistry.registerModEntity(new ResourceLocation(Info.MODID, entityName), entityClass, entityName, ID, EtherealAlchemy.instance, 64, 1, false);
    }
}
