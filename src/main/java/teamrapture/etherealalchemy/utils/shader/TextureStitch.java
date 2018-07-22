package teamrapture.etherealalchemy.utils.shader;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teamrapture.etherealalchemy.Info;

@Mod.EventBusSubscriber(modid = Info.MODID)
public class TextureStitch {

    public static TextureAtlasSprite PEDESTAL_SPRITE;

    public static TextureAtlasSprite forName(TextureMap ir, String name, String dir) {
        return ir.registerSprite(new ResourceLocation(Info.MODID + ":" + dir + "/" + name));
    }

    @SubscribeEvent
    public void onTextureStitch(TextureStitchEvent.Pre evt) {
        PEDESTAL_SPRITE = forName(evt.getMap(), "star_particle", "entity");
    }
}
