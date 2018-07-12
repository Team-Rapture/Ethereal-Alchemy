package teamrapture.etherealalchemy.items.soulphial;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamrapture.etherealalchemy.items.ItemBase;

public class FilledSoulPhial extends ItemBase {


        public FilledSoulPhial() {
            super("filled_soul_phial");
            this.setMaxStackSize(16);
        }

        @Override
        public EnumRarity getRarity(ItemStack stack) {
            return EnumRarity.RARE;
        }

        @SideOnly(Side.CLIENT)
        @Override
        public boolean hasEffect(ItemStack stack) {
            return true;
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

