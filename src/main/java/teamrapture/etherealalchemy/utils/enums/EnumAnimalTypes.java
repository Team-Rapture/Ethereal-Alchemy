package teamrapture.etherealalchemy.utils.enums;

import net.minecraft.client.model.*;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.*;
import net.minecraft.util.ResourceLocation;
import org.apache.http.util.EntityUtils;

public enum EnumAnimalTypes {
    PIG(EntityList.getID(EntityPig.class), "Soul Pig", EntityPig.class, ModelPig.class, new ResourceLocation("textures/entity/pig/pig.png")),
    COW(EntityList.getID(EntityCow.class), "Soul Cow", EntityCow.class, ModelCow.class, new ResourceLocation("textures/entity/cow/cow.png")),
    CHICKEN(EntityList.getID(EntityChicken.class), "Soul Chicken", EntityChicken.class, ModelChicken.class, new ResourceLocation("textures/entity/chicken.png")),
    HORSE(EntityList.getID(EntityHorse.class), "Soul Horse", EntityHorse.class, ModelHorse.class, new ResourceLocation("textures/entity/horse/horse_brown.png")),
    GOLEM(EntityList.getID(EntityIronGolem.class), "Soul Iron Golem", EntityIronGolem.class, ModelIronGolem.class, new ResourceLocation("textures/entity/iron_golem.png")),
    LLAMA(EntityList.getID(EntityLlama.class), "Soul Llama", EntityLlama.class, ModelLlama.class, new ResourceLocation("textures/entity/llama/llama_white.png")),
    MOOSHROOM(EntityList.getID(EntityMooshroom.class), "Soul Mooshroom", EntityMooshroom.class, ModelCow.class, new ResourceLocation("textures/entity/cow/mooshroom.png")),
    OCELOT(EntityList.getID(EntityOcelot.class), "Soul Ocelot", EntityOcelot.class, ModelOcelot.class, new ResourceLocation("textures/entity/cat/ocelot.png")),
    POLAR_BEAR(EntityList.getID(EntityPolarBear.class), "Soul Polar Bear", EntityPolarBear.class, ModelPolarBear.class, new ResourceLocation("textures/entity/bear/polarbear.png")),
    RABBIT(EntityList.getID(EntityRabbit.class), "Soul Rabbit", EntityRabbit.class, ModelRabbit.class, new ResourceLocation("textures/entity/rabbit/white.png")),
    VILLAGER(EntityList.getID(EntityVillager.class), "Soul Villager", EntityVillager.class, ModelVillager.class, new ResourceLocation("textures/entity/villager/villager.png"));

    private int type;
    private String soulName;
    private Class entityClass;
    private Class renderClass;
    private ResourceLocation location;

    private EnumAnimalTypes(int type, String soulName, Class entityClass, Class renderClass, ResourceLocation loc) {
        this.type = type;
        this.soulName = soulName;
        this.entityClass = entityClass;
        this.renderClass = renderClass;
        this.location = loc;
    }

    public Class getRenderClass() {
        return renderClass;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public int getType() {
        return type;
    }

    public String getSoulName() {
        return soulName;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public static EnumAnimalTypes getTypeByID(int type) {
        for (EnumAnimalTypes types : values()) {
            if(types.getType() == type) {
                return types;
            }
        }

        return null;
    }
}
