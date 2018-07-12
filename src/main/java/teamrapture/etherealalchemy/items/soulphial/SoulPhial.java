package teamrapture.etherealalchemy.items.soulphial;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.etherealalchemy.items.ItemBase;

public class SoulPhial extends ItemBase {

    public SoulPhial() {
        super("soul_phial");
        this.setMaxStackSize(1);
    }

    @Override
    public String getGuideInformation() {
        return I18n.format("soul_phial.entry");
    }

    @Override
    public ResourceLocation getEntryIcon() {
        return null;
    }
}
