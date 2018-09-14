package studio.rashka.models.lightbulb;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import studio.rashka.lib.AnimationModels;
import studio.rashka.lib.Textures;

public class BlackLightbulb {

    private AnimationModels animation;

    public BlackLightbulb() {
        animation = new AnimationModels(new TextureRegion(Textures.getInstance().textureRegion.get("LightbulbBlack")), 2, 0.8f);
    }

    public void update(float deltaTime) {
        animation.update(deltaTime);
    }

    public void render(SpriteBatch batch, float positionX, float positionY, float width, float height) {
        batch.draw(animation.getFrame(), positionX, positionY, width, height);
    }

    public void dispose() {
        try {
            animation.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}