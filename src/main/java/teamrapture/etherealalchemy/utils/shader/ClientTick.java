package teamrapture.etherealalchemy.utils.shader;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import teamrapture.etherealalchemy.Info;

@Mod.EventBusSubscriber(modid = Info.MODID)
public class ClientTick {

    public static int ticksInGame = 0;

    @SubscribeEvent
    public static void clientTickEnd(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ticksInGame++;
        }
    }
}
