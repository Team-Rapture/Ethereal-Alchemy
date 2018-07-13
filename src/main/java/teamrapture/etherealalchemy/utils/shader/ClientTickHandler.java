package teamrapture.etherealalchemy.utils.shader;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import teamrapture.etherealalchemy.Info;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Info.MODID)
public class ClientTickHandler {

    public static int ticksInGame = 0;

    @SubscribeEvent
    public static void clientTickEnd(TickEvent.ClientTickEvent event) {
        if(event.phase == TickEvent.Phase.END) {
            GuiScreen gui = Minecraft.getMinecraft().currentScreen;
            if (gui == null || !gui.doesGuiPauseGame()) {
                ticksInGame++;
            }
        }
    }
}
