package teamrapture.etherealalchemy.items.soulphial;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import teamrapture.etherealalchemy.items.ItemBase;

public class UnFiredSoulPhial extends ItemBase {
        public UnFiredSoulPhial(){
            super("unfired_soul_phial");
            this.setMaxStackSize(1);
        }

        @Override
        public String getGuideInformation() {
            return I18n.format("unfired_soul_phial.entry");
        }

        @Override
        public ResourceLocation getEntryIcon() {
            return null ;
        }
}

