package teamrapture.etherealalchemy.registry.events;

import net.minecraft.client.audio.Sound;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import teamrapture.etherealalchemy.registry.ModItems;

@Mod.EventBusSubscriber
public class EtherealEvents {

    @SubscribeEvent
    public static void gentleSoulExtraction(LivingDeathEvent event) {
        if (event.getEntityLiving() instanceof EntityAnimal) {
            if(event.getSource().getTrueSource() instanceof EntityPlayer){
                EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
                if(!player.getHeldItemOffhand().isEmpty()){
                    if(ItemHandlerHelper.canItemStacksStack(player.getHeldItemOffhand(), new ItemStack(ModItems.soulPhial))){
                        player.sendStatusMessage(new TextComponentString(TextFormatting.BOLD.DARK_PURPLE + I18n.format("gentle_soul_extracted.msg")),true);
                        player.world.playSound(null,player.getPosition(),SoundEvents.BLOCK_FIRE_EXTINGUISH,SoundCategory.PLAYERS,1.0F,-2.0F);
                        player.setHeldItem(EnumHand.OFF_HAND, new ItemStack(ModItems.filledSoulPhial));
                    }
                }
            }
        }
    }
}
