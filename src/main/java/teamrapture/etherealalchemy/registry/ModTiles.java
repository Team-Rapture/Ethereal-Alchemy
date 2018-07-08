package teamrapture.etherealalchemy.registry;

import net.minecraft.tileentity.TileEntity;
import teamrapture.etherealalchemy.proxy.CommonProxy;

public class ModTiles {

    public static void addToList() {

    }

    public static void register(Class<? extends TileEntity> te, String name) {
        CommonProxy.TILE_REGISTRY.put(te, name);
    }
}
