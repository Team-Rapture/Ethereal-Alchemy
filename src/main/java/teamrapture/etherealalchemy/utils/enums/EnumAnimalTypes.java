package teamrapture.etherealalchemy.utils.enums;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.*;
import net.minecraft.util.ResourceLocation;

public enum EnumAnimalTypes {
    PIG(EntityList.getID(EntityPig.class), EntityPig.class, EnumSoulTypes.GENTLE, new ResourceLocation("textures/entity/pig/pig.png")),
    COW(EntityList.getID(EntityCow.class), EntityCow.class, EnumSoulTypes.GENTLE, new ResourceLocation("textures/entity/cow/cow.png")),
    CHICKEN(EntityList.getID(EntityChicken.class), EntityChicken.class, EnumSoulTypes.GENTLE, new ResourceLocation("textures/entity/chicken.png")),
    HORSE(EntityList.getID(EntityHorse.class), EntityHorse.class, EnumSoulTypes.GENTLE, new ResourceLocation("textures/entity/horse/horse_brown.png")),
    GOLEM(EntityList.getID(EntityIronGolem.class), EntityIronGolem.class, EnumSoulTypes.PERPETUAL, new ResourceLocation("textures/entity/iron_golem.png")),
    LLAMA(EntityList.getID(EntityLlama.class), EntityLlama.class, EnumSoulTypes.GENTLE, new ResourceLocation("textures/entity/llama/llama_white.png")),
    MOOSHROOM(EntityList.getID(EntityMooshroom.class), EntityMooshroom.class, EnumSoulTypes.GENTLE, new ResourceLocation("textures/entity/cow/mooshroom.png")),
    OCELOT(EntityList.getID(EntityOcelot.class), EntityOcelot.class, EnumSoulTypes.PREYING, new ResourceLocation("textures/entity/cat/ocelot.png")),
    POLAR_BEAR(EntityList.getID(EntityPolarBear.class), EntityPolarBear.class, EnumSoulTypes.PREYING, new ResourceLocation("textures/entity/bear/polarbear.png")),
    RABBIT(EntityList.getID(EntityRabbit.class), EntityRabbit.class, EnumSoulTypes.GENTLE, new ResourceLocation("textures/entity/rabbit/white.png")),
    VILLAGER(EntityList.getID(EntityVillager.class), EntityVillager.class, EnumSoulTypes.SENSIBLE, new ResourceLocation("textures/entity/rabbit/white.png")),;

    private int type;
    private Class entityClass;
    private ResourceLocation textureLoc;
    private EnumSoulTypes soulType;

    private EnumAnimalTypes(int type, Class entityClass, EnumSoulTypes soulType, ResourceLocation textureLoc) {
        this.type = type;
        this.entityClass = entityClass;
        this.soulType = soulType;
        this.textureLoc = textureLoc;
    }

    public int getType() {
        return type;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public ResourceLocation getTextureLoc() {
        return textureLoc;
    }

    public EnumSoulTypes getSoulType() {
        return soulType;
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
