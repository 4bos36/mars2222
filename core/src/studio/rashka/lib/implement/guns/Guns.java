package studio.rashka.lib.implement.guns;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public interface Guns {

    void update(float deltaTime);

    void render(SpriteBatch batch, Vector2 position);

    float getShotPower();

    float getShotSpeed();

    float getShotRange();

    float getShotDistance();

    void dispose();
}