package teamrapture.etherealalchemy.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class InventoryUtils {

    public static void shrink(EntityPlayer player) {
        if(player.getHeldItemMainhand().getCount() > 1) {
            player.getHeldItemMainhand().shrink(1);
        }else {
            player.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY);
        }
    }
}
