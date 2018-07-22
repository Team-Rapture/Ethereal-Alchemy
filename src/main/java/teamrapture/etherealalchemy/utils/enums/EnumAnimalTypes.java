package teamrapture.etherealalchemy.utils.enums;

import net.minecraft.client.model.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.*;
import net.minecraft.util.ResourceLocation;

public enum EnumAnimalTypes {
    PIG(0, "Soul Pig", EntityPig.class, ModelPig.class, new ResourceLocation("textures/entity/pig/pig.png")),
    COW(1, "Soul Cow", EntityCow.class, ModelCow.class, new ResourceLocation("textures/entity/cow/cow.png")),
    CHICKEN(2, "Soul Chicken", EntityChicken.class, ModelChicken.class, new ResourceLocation("textures/entity/chicken.png")),
    HORSE(3, "Soul Horse", EntityHorse.class, ModelHorse.class, new ResourceLocation("textures/entity/horse/horse_brown.png")),
    GOLEM(4, "Soul Iron Golem", EntityIronGolem.class, ModelIronGolem.class, new ResourceLocation("textures/entity/iron_golem.png")),
    LLAMA(5, "Soul Llama", EntityLlama.class, ModelLlama.class, new ResourceLocation("textures/entity/llama/llama_white.png")),
    MOOSHROOM(6, "Soul Mooshroom", EntityCow.class, ModelCow.class, new ResourceLocation("textures/entity/cow/mooshroom.png")),
    OCELOT(7, "Soul Ocelot", EntityOcelot.class, ModelOcelot.class, new ResourceLocation("textures/entity/cat/ocelot.png")),
    POLAR_BEAR(8, "Soul Polar Bear", EntityPolarBear.class, ModelPolarBear.class, new ResourceLocation("textures/entity/bear/polarbear.png")),
    RABBIT(9, "Soul Rabbit", EntityRabbit.class, ModelRabbit.class, new ResourceLocation("textures/entity/rabbit/white.png")),
    VILLAGER(10, "Soul Villager", EntityVillager.class, ModelVillager.class, new ResourceLocation("textures/entity/villager/villager.png"));

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
        return values()[type];
    }
}
