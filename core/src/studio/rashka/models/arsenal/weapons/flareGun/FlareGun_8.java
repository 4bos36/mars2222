package studio.rashka.models.arsenal.weapons.flareGun;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.guns.Guns;

public class FlareGun_8 implements Guns {

    private float shotPower = 100 * 1.6f, // ущерб
            shotSpeed = 0.1f * 6, // скорость стрельбы
            shotRange = 100 * 0.4f, // диапазон взрыва
            shotDistance = 1500 * 0.7f; // расстояние стрельбы

    public FlareGun_8() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch, Vector2 position) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_8"), MarsGame.WIDTH / 2 - 128, 540 - 28, 96, 96, 192, 192, 1, 1, -90 + position.angle());
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