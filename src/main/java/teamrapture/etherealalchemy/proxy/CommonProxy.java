package teamrapture.etherealalchemy.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import teamrapture.etherealalchemy.blocks.BlockBase;
import teamrapture.etherealalchemy.client.gui.EtherealGuide;
import teamrapture.etherealalchemy.items.ItemBase;
import teamrapture.etherealalchemy.registry.ModBlocks;
import teamrapture.etherealalchemy.registry.ModEntities;
import teamrapture.etherealalchemy.registry.ModItems;
import teamrapture.etherealalchemy.registry.ModTiles;
import teamrapture.etherealalchemy.registry.events.EtherealEvents;
import teamrapture.etherealalchemy.utils.shader.ClientTickHandler;
import teamrapture.etherealalchemy.utils.shader.ShaderIcons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mod.EventBusSubscriber
public class CommonProxy {

    public static List<Block> BLOCK_REGISTRY = new ArrayList<>();
    public static List<Item> ITEM_REGISTRY = new ArrayList<>();
    public static HashMap<Class<? extends TileEntity>, String> TILE_REGISTRY = new HashMap<>();

    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.addToList();
        ModItems.addToList();
        ModTiles.addToList();
        MinecraftForge.EVENT_BUS.register(new ShaderIcons());

        for (Block block : BLOCK_REGISTRY) {
            if (block instanceof BlockBase) {
                BlockBase blockBase = (BlockBase) block;
                EtherealGuide.ETHEREAL_INFORMATION.put(block, blockBase.getGuideInformation());
                EtherealGuide.ETHEREAL_ICONS.put(block, blockBase.getEntryIcon());
            }
            ForgeRegistries.BLOCKS.register(block);
            ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        }

        for (Item item : ITEM_REGISTRY) {
            if (item instanceof ItemBase) {
                ItemBase itemBase = (ItemBase) item;
                EtherealGuide.ETHEREAL_INFORMATION.put(item, itemBase.getGuideInformation());
                EtherealGuide.ETHEREAL_ICONS.put(item, itemBase.getEntryIcon());
            }
            ForgeRegistries.ITEMS.register(item);
        }
    }

    public void init(FMLInitializationEvent event) {
        ModEntities.registerEntities();
        for (Class<? extends TileEntity> te : TILE_REGISTRY.keySet()) {
            GameRegistry.registerTileEntity(te, TILE_REGISTRY.get(te));
        }
        MinecraftForge.EVENT_BUS.register(new EtherealEvents());
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}
