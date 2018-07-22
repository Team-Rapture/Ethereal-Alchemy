package teamrapture.etherealalchemy.utils.shader;

import org.lwjgl.opengl.GL11;

public class PedestalRenderer {

    private StaticShader shader = new StaticShader();

    public PedestalRenderer() {
        enableCulling();
    }

    public static void enableCulling() {
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glCullFace(GL11.GL_BACK);
    }

    public static void disableCulling() {
        GL11.glDisable(GL11.GL_CULL_FACE);
    }

    public void render() {
        this.prepare();
        shader.start();
        shader.loadTime();
        shader.stop();
    }

    public void cleanUp() {
        shader.cleanUp();
    }

    public void prepare() {
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }
}
