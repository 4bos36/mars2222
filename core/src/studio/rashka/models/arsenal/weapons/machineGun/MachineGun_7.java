package studio.rashka.models.arsenal.weapons.machineGun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import studio.rashka.MarsGame;
import studio.rashka.lib.implement.guns.Guns;

public class MachineGun_7 implements Guns {

    private float shotPower = 100 * 0.2f, // ущерб
            shotSpeed = 0.1f * 7, // скорость стрельбы
            shotRange = 100 * 0.2f, // диапазон взрыва
            shotDistance = 1500 * 0.6f; // расстояние стрельбы

    private float x1, y1;

    private ParticleEffect smoke;
    private ParticleEmitter emitter;

    public MachineGun_7() {
        shotPower = shotPower + shotPower * shotSpeed; // 20+14=34

        smoke = new ParticleEffect();
        smoke.load(Gdx.files.internal("particles/MachineGun7.p"), Gdx.files.internal("particles"));
        smoke.start();
        emitter = smoke.getEmitters().first();
    }

    private void rotation(float x, float y, float originX, float originY, float rotation) {
        // bottom left and top right corner points relative to origin
        final float worldOriginX = x + originX;
        final float worldOriginY = y + originY;
        float fx = -originX;
        float fy = -originY;

        // construct corner points, start from top left and go counter clockwise
        final float p1x = fx;
        final float p1y = fy;

        float x1;
        float y1;

        // rotate
        if (rotation != 0) {
            final float cos = MathUtils.cosDeg(rotation);
            final float sin = MathUtils.sinDeg(rotation);
            x1 = cos * p1x - sin * p1y;
            y1 = sin * p1x + cos * p1y;
        } else {
            x1 = p1x;
            y1 = p1y;
        }

        x1 += worldOriginX;
        y1 += worldOriginY;

        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public void update(float deltaTime) {
        smoke.update(deltaTime);
        if (smoke.isComplete()) smoke.reset();
    }

    @Override
    public void render(SpriteBatch batch, Vector2 position) {
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun_7"), MarsGame.WIDTH / 2 - 84, 540 - 173, 52, 237, 128, 320, 1, 1, -90 + position.angle());

        rotation(MarsGame.WIDTH / 2 + 15, MarsGame.HEIGHT / 2 - 10, -42, 70, position.angle());
        smoke.getEmitters().first().setPosition(x1, y1);
        emitter.getAngle().setHigh(position.angle());
        emitter.getAngle().setHighMax(360 + position.angle());
        emitter.getAngle().setLow(position.angle());
        smoke.draw(batch);
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
        smoke.dispose();
    }
}