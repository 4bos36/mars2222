package studio.rashka.models.arsenal.weapons.laserGun;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.guns.Guns;

public class LaserGun_3 implements Guns {

    private float shotPower = 100 * 0.2f, // ущерб
            shotSpeed = 0.1f * 4, // скорость стрельбы
            shotRange = 100 * 0.3f, // диапазон взрыва
            shotDistance = 1500 * 0.6f; // расстояние стрельбы

    public LaserGun_3() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch, Vector2 position) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_3"), MarsGame.WIDTH / 2 - 96, 540 - 188, 64, 256, 128, 320, 1, 1, -90 + position.angle());
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