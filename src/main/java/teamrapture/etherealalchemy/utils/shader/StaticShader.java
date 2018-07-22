package teamrapture.etherealalchemy.utils.shader;

public class StaticShader extends ShaderProgram {

    private static final String FRAGMENT_FILE = "assets/etherealalchemy/shaders/soul_pedestal.frag";

    private int time;

    public StaticShader() {
        super(FRAGMENT_FILE);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
        super.bindAttribute(1, "textureCoords");
        super.bindAttribute(2, "normal");
    }

    @Override
    protected void getAllUniformLocations() {
        time = super.getUniformLocation("time");
    }

    public void loadTime() {
        super.loadFloat(time, ClientTick.ticksInGame);
    }
}