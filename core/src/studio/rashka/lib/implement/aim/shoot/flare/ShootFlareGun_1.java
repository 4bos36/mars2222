package studio.rashka.lib.implement.aim.shoot.flare;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import studio.rashka.MarsGame;
import studio.rashka.lib.implement.aim.Aims;

public class ShootFlareGun_1 implements Aims {

    private ArrayList<ParticleEffect> fire;
    private float x1, y1;
    private static final float posCamX = MarsGame.WIDTH / 2, posCamY = 540;

    public ShootFlareGun_1() {
        fire = new ArrayList<ParticleEffect>();

        fire.add(0, new ParticleEffect());
        fire.add(1, new ParticleEffect());
        fire.get(0).load(Gdx.files.internal("particles/shoot/aim/FlareGun1.p"), Gdx.files.internal("particles"));
        fire.get(1).load(Gdx.files.internal("particles/shoot/gun/FlareGun1.p"), Gdx.files.internal("particles"));

        for (int i = 0; i < fire.size(); i++) fire.get(i).start();
    }

    private float position(float realPos, float movePos, float posCam, float zoom) {
        float newPos;
        if (zoom == 1.0f) newPos = realPos - posCam + movePos;
        else newPos = (realPos - posCam) * zoom + movePos;
        return newPos;
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
    public void shooting(Vector2 position, Vector2 positionFireAim, OrthographicCamera camera) {
        fire.get(0).setPosition(position(MarsGame.WIDTH / 2 + positionFireAim.x, camera.position.x, posCamX, camera.zoom) - 32,
                position(540 + positionFireAim.y - MarsGame.getRatioAdd() / 2, camera.position.y, posCamY, camera.zoom) + 71);

        rotation(MarsGame.WIDTH / 2 - 140, 540 + 71, 110, 0, position.angle());
        fire.get(1).setPosition(x1, y1);
        fire.get(0).getEmitters().first().getAngle().setHigh(position.angle());
        fire.get(0).getEmitters().first().getAngle().setHighMax(360 + position.angle());
        fire.get(1).getEmitters().first().getAngle().setHigh(90 + position.angle());
        fire.get(1).getEmitters().first().getAngle().setHighMax(270 + position.angle());
    }

    @Override
    public ArrayList<ParticleEffect> fire() {
        return fire;
    }

    @Override
    public void dispose() {
        fire.clear();
    }
}