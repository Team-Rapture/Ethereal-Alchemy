package teamrapture.etherealalchemy.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import teamrapture.etherealalchemy.Info;
import teamrapture.etherealalchemy.registry.ModEntities;
import teamrapture.etherealalchemy.registry.ModTiles;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    //public static PedestalRenderer renderer = new PedestalRenderer();

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        OBJLoader.INSTANCE.addDomain(Info.MODID);
        for (Block block : BLOCK_REGISTRY) {
            regBlock(block);
        }

        for (Item item : ITEM_REGISTRY) {
            regItem(item);
        }
        ModTiles.registerTESR();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        ModEntities.renderEntities();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    public static void regBlock(Block block) {
        ModelResourceLocation res = new
                ModelResourceLocation(block.getRegistryName().toString(), "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, res);
    }

    public static void regItem(Item item) {
        ModelResourceLocation res = new ModelResourceLocation(item.getRegistryName().toString(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, res);
    }
}
