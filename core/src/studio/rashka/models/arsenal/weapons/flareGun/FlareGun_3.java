package studio.rashka.models.arsenal.weapons.flareGun;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.guns.Guns;

public class FlareGun_3 implements Guns {

    private float shotPower = 100 * 0.8f, // ущерб
            shotSpeed = 0.1f * 9, // скорость стрельбы
            shotRange = 100 * 0.3f, // диапазон взрыва
            shotDistance = 1500 * 0.5f; // расстояние стрельбы

    public FlareGun_3() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch, Vector2 position) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_3"), MarsGame.WIDTH / 2 - 108, 540 - 51, 76, 120, 128, 256, 1, 1, -90 + position.angle());
    }

    @Override
    public float getShotPower() {
        return shotPower;
    }

    @Override
    public float getShotSpeed() {
        return shotSpeed;
    }

    @Override
    public float getShotRange() {
        return shotRange;
    }

    @Override
    public float getShotDistance() {
        return shotDistance;
    }

    @Override
    public void dispose() {

    }
}