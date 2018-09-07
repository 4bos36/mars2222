package studio.rashka.lib.implement.aim;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public interface Aims {

    void shooting(Vector2 position, Vector2 positionFireAim, OrthographicCamera camera);

    ArrayList<ParticleEffect> fire();

    void dispose();
}
