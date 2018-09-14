package studio.rashka.lib.implement.crystals;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Crystals {

    void update(float deltaTime);

    void render(SpriteBatch batch);

    void dispose();
}
