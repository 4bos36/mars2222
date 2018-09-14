package studio.rashka.models.arsenal.weapons.machineGun;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.guns.Guns;

public class MachineGun_1 implements Guns {

    private float shotPower = 100 * 0.1f, // ущерб
            shotSpeed = 0.1f * 1, // скорость стрельбы
            shotRange = 100 * 0.1f, // диапазон взрыва
            shotDistance = 1500 * 0.1f; // расстояние стрельбы

    public MachineGun_1() {
        shotPower = shotPower + shotPower * shotSpeed; // 10+1=11
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch, Vector2 position) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_1"), MarsGame.WIDTH / 2 - 96, 540 - 188, 64, 256, 128, 320, 1, 1, -90 + position.angle());
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