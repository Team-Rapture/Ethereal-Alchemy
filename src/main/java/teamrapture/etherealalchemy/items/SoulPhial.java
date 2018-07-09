package teamrapture.etherealalchemy.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class SoulPhial extends ItemBase {
    public SoulPhial() {
        super("soul_phial");
    }

    @Override
    public String getGuideInformation() {
        return I18n.format("soul_phial.entry");
    }

    @Override
    public ResourceLocation getEntryIcon() {
        return new ResourceLocation("");
    }
}
