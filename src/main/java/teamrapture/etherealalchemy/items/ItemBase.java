package teamrapture.etherealalchemy.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import teamrapture.etherealalchemy.EtherealAlchemy;
import teamrapture.etherealalchemy.api.IGuideEntryHandler;

public class ItemBase extends Item implements IGuideEntryHandler {

    public ItemBase(String name) {
        super();
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(EtherealAlchemy.tabEthereal);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public String getGuideInformation() {
        return null;
    }

    @Override
    public ResourceLocation getEntryIcon() {
        return null;
    }
}
