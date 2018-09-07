package studio.rashka.models.load;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import studio.rashka.MarsGame;
import studio.rashka.lib.GifDecoder;

public class Space {

    private Animation<TextureRegion> animation;
    float deltaTime;

    public Space() {
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("load/load.gif").read());
    }

    public void render(SpriteBatch batch) {
        deltaTime += Gdx.graphics.getDeltaTime();
        batch.begin();
        batch.draw(animation.getKeyFrame(deltaTime), MarsGame.WIDTH / 2 - 100, MarsGame.HEIGHT / 2 - 200 + MarsGame.getRatioAdd() / 2);
        batch.end();
    }
}