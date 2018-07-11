package teamrapture.etherealalchemy.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class SpiritualBone extends ItemBase {

    public SpiritualBone() {
        super("spiritual_bone");
    }

    @Override
    public String getGuideInformation() {
        return I18n.format("spiritual_bone.entry");
    }

    @Override
    public ResourceLocation getEntryIcon() {
        return null;
    }
}
