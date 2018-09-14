package studio.rashka.models.arsenal.weapons.machineGun;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.guns.Guns;

public class MachineGun_6 implements Guns {

    private float shotPower = 100 * 0.2f, // ущерб
            shotSpeed = 0.1f * 5, // скорость стрельбы
            shotRange = 100 * 0.2f, // диапазон взрыва
            shotDistance = 1500 * 0.5f; // расстояние стрельбы

    public MachineGun_6() {
        shotPower = shotPower + shotPower * shotSpeed; // 20+10=30
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch, Vector2 position) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_6"), MarsGame.WIDTH / 2 - 84, 540 - 168, 52, 232, 128, 320, 1, 1, -90 + position.angle());
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