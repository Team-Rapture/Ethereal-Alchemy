package teamrapture.etherealalchemy.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class KnowledgeGem extends ItemBase {

    public KnowledgeGem() {
        super("knowledge_gem");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if(world.isRemote) {

        }
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public String getGuideInformation() {
        return "The knowledge gem provides you a guide through Ethereal Alchemy. " +
                "In it you shall find various information on the usage and progression of the mod, " +
                "as well as all the secrets you may unlock.";
    }

    @Override
    public ResourceLocation getEntryIcon() {
        return new ResourceLocation("");
    }
}
