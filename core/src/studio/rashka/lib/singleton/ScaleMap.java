package studio.rashka.lib.singleton;

public class ScaleMap {

    public static final ScaleMap INSTANCE = new ScaleMap();

    private float scale;

    private ScaleMap() {
        scale = 1;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}