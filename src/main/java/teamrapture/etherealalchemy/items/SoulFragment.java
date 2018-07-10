package teamrapture.etherealalchemy.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class SoulFragment extends ItemBase {

    public SoulFragment() {
        super("soul_fragment");
    }

    @Override
    public String getGuideInformation() {
        return I18n.format("soul_fragment.entry");
    }

    @Override
    public ResourceLocation getEntryIcon() {
        return null;
    }
}
