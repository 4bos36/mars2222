package studio.rashka.models.arsenal.weapons.laserGun;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import studio.rashka.MarsGame;
import studio.rashka.lib.implement.guns.Guns;

public class LaserGun_2 implements Guns {

    private float shotPower = 100 * 1.0f, // ущерб
            shotSpeed = 0.1f * 9, // скорость стрельбы
            shotRange = 100 * 0.2f, // диапазон взрыва
            shotDistance = 1500 * 0.6f; // расстояние стрельбы

    public LaserGun_2() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch, Vector2 position) {
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun_2"), MarsGame.WIDTH / 2 - 96, 540 - 124, 64, 192, 128, 256, 1, 1, -90 + position.angle());
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