package teamrapture.etherealalchemy.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import teamrapture.etherealalchemy.entity.EntityKnowledge;

public class KnowledgeGem extends ItemBase {

    public KnowledgeGem() {
        super("knowledge_gem");
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if(!world.isRemote) {
            world.spawnEntity(new EntityKnowledge(world, player));
        }
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public String getGuideInformation() {
        return I18n.format("knowledge_gem.entry");
    }

    @Override
    public ResourceLocation getEntryIcon() {
        return new ResourceLocation("etherealalchemy","textures/gui/knowledge_gem.png");
    }
}
