package teamrapture.etherealalchemy.registry.events;

import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import teamrapture.etherealalchemy.registry.ModItems;

@Mod.EventBusSubscriber
public class EtherealEvents {

    @SubscribeEvent
    public static void gentleSoulExtraction(LivingDeathEvent event) {
        if (event.getEntityLiving() instanceof EntityAnimal) {
            if (event.getSource().getTrueSource() instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
                if (!player.getHeldItemOffhand().isEmpty()) {
                    if (ItemHandlerHelper.canItemStacksStack(player.getHeldItemOffhand(), new ItemStack(ModItems.soulPhial))) {
                        player.sendStatusMessage(new TextComponentString(TextFormatting.BOLD.DARK_PURPLE + I18n.format("gentle_soul_extracted.msg")), true);
                        player.world.playSound(null, player.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.PLAYERS, 1.0F, -2.0F);
                        player.setHeldItem(EnumHand.OFF_HAND, new ItemStack(ModItems.filledSoulPhial));
                    }
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void entityOnFire(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if(!event.getWorld().isRemote) {
            if(entity instanceof EntityItem) {
                EntityItem entityItem = (EntityItem) entity;
                if(!entityItem.getItem().isEmpty() && entityItem.getItem().getItem() == ModItems.unFiredSoulPhial) {
                    ((EntityItem) entity).setEntityInvulnerable(true);
                    if(event.getWorld().getBlockState(event.getEntity().getPosition()).getMaterial() == Material.FIRE) {
                        entityItem.setItem(new ItemStack(ModItems.soulPhial,1,0));
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void entityEvent(EntityEvent event) {
        if(event.getEntity() instanceof EntityItem) {
            EntityItem entity = (EntityItem) event.getEntity();
            if(entity.getItem().getItem() == ModItems.unFiredSoulPhial) {
                if(entity.isBurning()) {
                    ((EntityItem) event.getEntity()).setItem(new ItemStack(ModItems.soulPhial));
                }
            }
        }
    }


}
