package teamrapture.etherealalchemy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import teamrapture.etherealalchemy.tiles.TileSoulChamber;

import javax.annotation.Nullable;

public class BlockSoulChamber extends BlockBase {

    public BlockSoulChamber() {
        super(Material.ROCK, "soul_chamber", 2.0f);
        setSoundType(SoundType.GLASS);
    }

    @Override
    public String getGuideInformation() {
        return super.getGuideInformation();
    }

    @Override
    public ResourceLocation getEntryIcon() {
        return super.getEntryIcon();
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileSoulChamber();
    }
}
