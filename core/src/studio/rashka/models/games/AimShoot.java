package studio.rashka.models.games;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.aim.AbstractFactoryAim;
import studio.rashka.lib.implement.aim.Aims;
import studio.rashka.lib.implement.aim.CreateAim;

public class AimShoot {

    private AbstractFactoryAim createAim = new CreateAim();
    private Aims aims;

    private ParticleEmitter emitter;

    private String nameWeapon = "Null";
    private int fireType;
    private float energy = 0, energyAim = 0, repeat = 0,
            shotPower, // ущерб
            shotSpeed; // скорость стрельбы
    private Circle aim;

    private static final float posCamX = MarsGame.WIDTH / 2, posCamY = 540;
    private boolean isFire = false, isShoot = true, isPlayFireWeapon = true;

    public AimShoot(float shotPower, float shotSpeed, float shotRange, float shotDistance) {
        this.shotPower = shotPower;
        this.shotSpeed = shotSpeed;

        emitter = new ParticleEmitter();

        aim = new Circle(MarsGame.WIDTH / 2 - 32, 540 + 72, shotRange * 2);

        //region load shoots
        if (MarsGame.getPreference().getWeaponInstalled("MachineGun_1")) {
            nameWeapon = "MachineGun_1";
            fireType = 1;
        } else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_2")) {
            nameWeapon = "MachineGun_2";
            fireType = 1;
        } else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_3")) {
            nameWeapon = "MachineGun_3";
            fireType = 1;
        } else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_4")) {
            nameWeapon = "MachineGun_4";
            fireType = 1;
        } else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_5")) {
            nameWeapon = "MachineGun_5";
            fireType = 1;
        } else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_6") || MarsGame.getPreference().getWeaponInstalled("MachineGun_7")) {
            nameWeapon = "MachineGun_6";
            fireType = 1;
        } else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_8")) {
            nameWeapon = "MachineGun_8";
            fireType = 1;
        } else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_1")) {
            nameWeapon = "LauncherGun_1";
            fireType = 2;
        } else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_2")) {
            nameWeapon = "LauncherGun_2";
            fireType = 2;
        } else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_3")) {
            nameWeapon = "LauncherGun_3";
            fireType = 2;
        } else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_4")) {
            nameWeapon = "LauncherGun_4";
            fireType = 2;
        } else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_5")) {
            nameWeapon = "LauncherGun_5";
            fireType = 2;
        } else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_6")) {
            nameWeapon = "LauncherGun_6";
            fireType = 2;
        } else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_7")) {
            nameWeapon = "LauncherGun_7";
            fireType = 2;
        } else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_8")) {
            nameWeapon = "LauncherGun_8";
            fireType = 2;
        } else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_1")) {
            nameWeapon = "FlareGun_1";
            fireType = 3;
        } else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_2")) {
            nameWeapon = "FlareGun_2";
            fireType = 3;
        } else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_3")) {
            nameWeapon = "FlareGun_3";
            fireType = 3;
        } else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_4")) {
            nameWeapon = "FlareGun_4";
            fireType = 3;
        } else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_5")) {
            nameWeapon = "FlareGun_5";
            fireType = 3;
        } else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_6")) {
            nameWeapon = "FlareGun_6";
            fireType = 3;
        } else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_7")) {
            nameWeapon = "FlareGun_7";
            fireType = 3;
        } else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_8")) {
            nameWeapon = "FlareGun_8";
            fireType = 3;
        } else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_1")) {
            nameWeapon = "LaserGun_1";
            energy = 2;
            fireType = 4;
        } else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_2")) {
            nameWeapon = "LaserGun_2";
            energy = 2;
            fireType = 4;
        } else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_3")) {
            nameWeapon = "LaserGun_3";
            energy = 1;
            fireType = 4;
        } else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_4")) {
            nameWeapon = "LaserGun_4";
            energy = 1;
            fireType = 4;
        } else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_5")) {
            nameWeapon = "LaserGun_5";
            energy = 1;
            fireType = 4;
        } else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_6")) {
            nameWeapon = "LaserGun_6";
            energy = 2;
            fireType = 4;
        } else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_7")) {
            nameWeapon = "LaserGun_7";
            energy = 3;
            fireType = 4;
        } else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_8")) {
            nameWeapon = "LaserGun_8";
            energy = 4;
            fireType = 4;
        }
        //endregion

        aims = createAim.createAim(nameWeapon);
        emitter = aims.fire().get(0).getEmitters().first();
    }

    private float position(float realPos, float movePos, float posCam, float zoom) {
        float newPos;
        if (zoom == 1.0f) newPos = realPos - posCam + movePos;
        else newPos = (realPos - posCam) * zoom + movePos;
        return newPos;
    }

    public void update(float deltaTime, int mp) {
        if (isFire) {
            if (fireType == 1) {
                for (int i = 0; i < aims.fire().size(); i++)
                    aims.fire().get(i).update(deltaTime);
            } else {
                if (MarsGame.getPreference().loadSound() == 1 && isPlayFireWeapon) {
                    MarsGame.getMusicSound().sounds.get("SoundWeapon").play();
                    isPlayFireWeapon = false;
                }
                isShoot = false;
                for (int i = 0; i < aims.fire().size(); i++) aims.fire().get(i).update(deltaTime);
                if (energy != 0) energyAim = energy * deltaTime;
                if (aims.fire().get(0).isComplete() && aims.fire().get(1).isComplete()) {
                    energyAim = 0;
                    isShoot = true;
                    repeat += deltaTime;
                    if (fireType == 4) {
                        if (repeat >= shotSpeed && mp >= energy) {
                            for (int i = 0; i < aims.fire().size(); i++) aims.fire().get(i).reset();
                            isPlayFireWeapon = true;
                            repeat = 0;
                        }
                    } else {
                        if (repeat >= shotSpeed) {
                            for (int i = 0; i < aims.fire().size(); i++) aims.fire().get(i).reset();
                            isPlayFireWeapon = true;
                            repeat = 0;
                        }
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch, Vector2 position, Vector2 pos, Vector2 positionFireAim, OrthographicCamera camera) {
        batch.draw(Textures.getInstance().textureRegion.get("Aim"), position(MarsGame.WIDTH / 2, camera.position.x, posCamX, camera.zoom) - 64, position(540 - MarsGame.getRatioAdd() / 2, camera.position.y, posCamY, camera.zoom) + 36, 32, 32, 64, 64, 1, 1, pos.angle());
        aim.setPosition(position(MarsGame.WIDTH / 2 + positionFireAim.x, camera.position.x, posCamX, camera.zoom) - 32, position(540 + positionFireAim.y - MarsGame.getRatioAdd() / 2, camera.position.y, posCamY, camera.zoom) + 72);
        aims.shooting(position, positionFireAim, camera);
        if (isFire)
            for (int i = 0; i < aims.fire().size(); i++)
                aims.fire().get(i).draw(batch);
    }

    public ParticleEmitter getEmitter() {
        return emitter;
    }

    public void setFire(boolean fire) {
        isFire = fire;
    }

    public boolean isShoot() {
        return isShoot;
    }

    public float getShotPower() {
        return shotPower;
    }

    public float getEnergy() {
        return energyAim;
    }

    public String getNameWeapon() {
        return nameWeapon;
    }

    public ParticleEffect getFireAim() {
        return aims.fire().get(0);
    }

    public ParticleEffect getFireShot() {
        return aims.fire().get(1);
    }

    public Circle getAim() {
        return aim;
    }

    public void dispose() {
        try {
            aims.dispose();
            emitter = null;
            aim = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}