package teamrapture.etherealalchemy.registry.events;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teamrapture.etherealalchemy.registry.ModItems;

public class EtherealEvents {
    @SubscribeEvent
    public static void onDeathEvent(LivingDeathEvent event) {
        if (event.getEntity() instanceof EntityAnimal) {
            if(event.getSource().getTrueSource() instanceof EntityPlayer){
                EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
                if(!player.getHeldItemOffhand().isEmpty()){
                    if(player.getHeldItemOffhand().getItem() == ModItems.soulPhial){
                        player.setHeldItem(EnumHand.OFF_HAND, new ItemStack(ModItems.filledSoulPhial));
                    }
                }
            }

        }
    }
}
