package studio.rashka.models.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.guns.AbstractFactoryGuns;
import studio.rashka.lib.implement.guns.Guns;
import studio.rashka.lib.implement.guns.CreateGun;

public class Base {

    private AbstractFactoryGuns createGuns = new CreateGun();
    private Guns gun;

    private ArrayList<ParticleEffect> fireBase;

    public Base() {
        fireBase = new ArrayList<ParticleEffect>();
        for (int i = 0; i < 4; i++) {
            fireBase.add(i, new ParticleEffect());
            fireBase.get(i).load(Gdx.files.internal("particles/baseFire.p"), Gdx.files.internal("particles"));
            fireBase.get(i).start();
        }
        fireBase.get(0).getEmitters().first().setPosition(MarsGame.WIDTH / 2 + 76, 540 - 37);
        fireBase.get(1).getEmitters().first().setPosition(MarsGame.WIDTH / 2 + 76, 540 + 165);
        fireBase.get(2).getEmitters().first().setPosition(MarsGame.WIDTH / 2 - 137, 540 + 165);
        fireBase.get(3).getEmitters().first().setPosition(MarsGame.WIDTH / 2 - 137, 540 - 37);

        //region New Guns
        if (MarsGame.getPreference().getWeaponInstalled("MachineGun_1")) gun = createGuns.createGuns(1);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_2")) gun = createGuns.createGuns(2);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_3")) gun = createGuns.createGuns(3);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_4")) gun = createGuns.createGuns(4);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_5")) gun = createGuns.createGuns(5);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_6")) gun = createGuns.createGuns(6);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_7")) gun = createGuns.createGuns(7);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_8")) gun = createGuns.createGuns(8);

        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_1")) gun = createGuns.createGuns(9);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_2")) gun = createGuns.createGuns(10);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_3")) gun = createGuns.createGuns(11);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_4")) gun = createGuns.createGuns(12);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_5")) gun = createGuns.createGuns(13);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_6")) gun = createGuns.createGuns(14);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_7")) gun = createGuns.createGuns(15);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_8")) gun = createGuns.createGuns(16);

        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_1")) gun = createGuns.createGuns(17);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_2")) gun = createGuns.createGuns(18);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_3")) gun = createGuns.createGuns(19);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_4")) gun = createGuns.createGuns(20);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_5")) gun = createGuns.createGuns(21);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_6")) gun = createGuns.createGuns(22);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_7")) gun = createGuns.createGuns(23);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_8")) gun = createGuns.createGuns(24);

        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_1")) gun = createGuns.createGuns(25);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_2")) gun = createGuns.createGuns(26);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_3")) gun = createGuns.createGuns(27);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_4")) gun = createGuns.createGuns(28);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_5")) gun = createGuns.createGuns(29);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_6")) gun = createGuns.createGuns(30);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_7")) gun = createGuns.createGuns(31);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_8")) gun = createGuns.createGuns(32);
    }

    public void update(float deltaTime) {
        for (int i = 0; i < 4; i++) {
            if (MarsGame.getFrustum().boundsInFrustum(fireBase.get(i).getBoundingBox()))
                fireBase.get(i).update(deltaTime);
        }
        gun.update(deltaTime);
    }

    public void render(SpriteBatch batch, Vector2 position) {
        batch.draw(Textures.getInstance().textureRegion.get("BaseGoal"), MarsGame.WIDTH / 2 - 70, 540 - 60, 76, 54);
        batch.draw(Textures.getInstance().textureRegion.get("BaseSupport"), MarsGame.WIDTH / 2 - 189, 540 - 89, 128, 128);
        batch.draw(Textures.getInstance().textureRegion.get("BaseSupport"), MarsGame.WIDTH / 2 + 125, 540 - 89, -128, 128);
        batch.draw(Textures.getInstance().textureRegion.get("BaseSupport"), MarsGame.WIDTH / 2 - 189, 540 + 225, 128, -128);
        batch.draw(Textures.getInstance().textureRegion.get("BaseSupport"), MarsGame.WIDTH / 2 + 125, 540 + 225, -128, -128);
        batch.draw(Textures.getInstance().textureRegion.get("Base"), MarsGame.WIDTH / 2 - 128, 540 - 28, 192, 192);
        for (int i = 0; i < 4; i++) {
            if (MarsGame.getFrustum().boundsInFrustum(fireBase.get(i).getBoundingBox()))
                fireBase.get(i).draw(batch);
        }

        gun.render(batch, position);
    }

    public float getShotPower() {
        return gun.getShotPower();
    }

    public float getShotSpeed() {
        return gun.getShotSpeed();
    }

    public float getShotRange() {
        return gun.getShotRange();
    }

    public float getShotDistance() {
        return gun.getShotDistance();
    }

    public void dispose() {
        try {
            fireBase.clear();
            gun.dispose();
            createGuns = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}