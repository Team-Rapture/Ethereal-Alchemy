package teamrapture.etherealalchemy.utils.shader;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teamrapture.etherealalchemy.Info;

@Mod.EventBusSubscriber(modid = Info.MODID)
public class ShaderIcons {

    public static TextureAtlasSprite pedestalStar;

    @SubscribeEvent
    public void onTextureStitch(TextureStitchEvent.Pre evt) {
        pedestalStar = forName(evt.getMap(), "star_particle", "entity");
    }

    public static TextureAtlasSprite forName(TextureMap ir, String name, String dir) {
        return ir.registerSprite(new ResourceLocation(Info.MODID, "entity/" + name));
    }
}
