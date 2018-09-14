package studio.rashka.models.arsenal.weapons.launcherGun;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.guns.Guns;

public class LauncherGun_6 implements Guns {

    private float shotPower = 100 * 1.0f, // ущерб
            shotSpeed = 0.1f * 8, // скорость стрельбы
            shotRange = 100 * 0.5f, // диапазон взрыва
            shotDistance = 1500 * 0.5f; // расстояние стрельбы

    public LauncherGun_6() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch, Vector2 position) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_6"), MarsGame.WIDTH / 2 - 96, 540 - 152, 64, 220, 128, 320, 1, 1, -90 + position.angle());
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