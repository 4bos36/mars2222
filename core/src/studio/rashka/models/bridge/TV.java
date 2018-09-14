package studio.rashka.models.bridge;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import studio.rashka.lib.AnimationModels;
import studio.rashka.lib.Textures;

public class TV {

    private AnimationModels animation;

    public TV() {
        animation = new AnimationModels(new TextureRegion(Textures.getInstance().textureRegion.get("TV")), 2, 0.2f);
    }

    public void update(float deltaTime) {
        animation.update(deltaTime);
    }

    public void render(SpriteBatch batch, float positionX, float positionY, float width, float height, float angle) {
        batch.draw(animation.getFrame(), positionX, positionY, width / 2, height / 2, width, height, 1, 1, angle);
    }

    public void dispose() {
        try {
            animation.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}