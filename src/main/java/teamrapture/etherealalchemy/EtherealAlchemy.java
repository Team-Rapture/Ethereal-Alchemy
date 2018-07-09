package teamrapture.etherealalchemy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import teamrapture.etherealalchemy.proxy.CommonProxy;
import teamrapture.etherealalchemy.registry.ModItems;

@Mod(modid = Info.MODID, name = Info.MODNAME, version = Info.VERSION, acceptedMinecraftVersions = Info.ACCEPTED_VERSIONS)
public class EtherealAlchemy {

    @Mod.Instance(Info.MODID)
    public static EtherealAlchemy instance;

    @SidedProxy(clientSide = "teamrapture.etherealalchemy.proxy.ClientProxy", serverSide = "teamrapture.etherealalchemy.proxy.CommonProxy")
    static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        this.proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        this.proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        this.proxy.postInit(event);
    }

    public static CreativeTabs tabEthereal = new CreativeTabs("etherealtab") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.knowledgeGem);
        }
    };
}
