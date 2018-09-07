package studio.rashka.models.arsenal.weapons.launcherGun;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import studio.rashka.MarsGame;
import studio.rashka.lib.implement.guns.Guns;

public class LauncherGun_7 implements Guns {

    private float shotPower = 100 * 1.2f, // ущерб
            shotSpeed = 0.1f * 7, // скорость стрельбы
            shotRange = 100 * 0.6f, // диапазон взрыва
            shotDistance = 1500 * 0.5f; // расстояние стрельбы

    public LauncherGun_7() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch, Vector2 position) {
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun_7"), MarsGame.WIDTH / 2 - 96, 540 - 108, 64, 176, 128, 320, 1, 1, -90 + position.angle());
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