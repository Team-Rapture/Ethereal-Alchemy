package teamrapture.etherealalchemy.registry.events;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import teamrapture.etherealalchemy.registry.ModItems;

@Mod.EventBusSubscriber
public class EtherealEvents {

    @SubscribeEvent
    public static void onDeathEvent(LivingDeathEvent event) {
        if (event.getEntityLiving() instanceof EntityAnimal) {
            if(event.getSource().getTrueSource() instanceof EntityPlayer){
                EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
                if(!player.getHeldItemOffhand().isEmpty()){
                    if(ItemHandlerHelper.canItemStacksStack(player.getHeldItemOffhand(), new ItemStack(ModItems.soulPhial))){
                        player.setHeldItem(EnumHand.OFF_HAND, new ItemStack(ModItems.filledSoulPhial));
                    }
                }
            }
        }
    }
}
