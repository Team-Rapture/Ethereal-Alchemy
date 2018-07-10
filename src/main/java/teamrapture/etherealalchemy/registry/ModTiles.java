package teamrapture.etherealalchemy.registry;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import teamrapture.etherealalchemy.client.render.tesr.RenderSoulPedestal;
import teamrapture.etherealalchemy.proxy.CommonProxy;
import teamrapture.etherealalchemy.tiles.TileSoulPedestal;

public class ModTiles {

    public static void addToList() {
        register(TileSoulPedestal.class, "etherealalchemt:soul_pedestal");
    }

    public static void registerTESR() {
        register(TileSoulPedestal.class, new RenderSoulPedestal());
    }

    public static void register(Class<? extends TileEntity> te, String name) {
        CommonProxy.TILE_REGISTRY.put(te, name);
    }

    public static void register(Class<? extends TileEntity> te, TileEntitySpecialRenderer tesr) {
        ClientRegistry.bindTileEntitySpecialRenderer(te, tesr);
    }
}
