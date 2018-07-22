package teamrapture.etherealalchemy.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import teamrapture.etherealalchemy.EtherealAlchemy;
import teamrapture.etherealalchemy.Info;
import teamrapture.etherealalchemy.client.render.entity.RenderEntityKnowledge;
import teamrapture.etherealalchemy.client.render.entity.RenderEntitySoul;
import teamrapture.etherealalchemy.entity.EntityInvincible;
import teamrapture.etherealalchemy.entity.EntityKnowledge;
import teamrapture.etherealalchemy.entity.EntitySoulBase;

public class ModEntities {

    public static void registerEntities() {
        createEntity(EntityKnowledge.class, "entity_knowledge", 0);
        createEntity(EntityInvincible.class, "entity_invincible", 1);
        createEntity(EntitySoulBase.class, "entity_soul", 2);
    }

    public static void renderEntities() {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        renderManager.entityRenderMap.put(EntityKnowledge.class, new RenderEntityKnowledge(renderManager));
        renderManager.entityRenderMap.put(EntitySoulBase.class, new RenderEntitySoul(renderManager));
    }

    public static void createEntity(Class entityClass, String entityName, int ID) {
        EntityRegistry.registerModEntity(new ResourceLocation(Info.MODID, entityName), entityClass, entityName, ID, EtherealAlchemy.instance, 64, 1, false);
    }
}
