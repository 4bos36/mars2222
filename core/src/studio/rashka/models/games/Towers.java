package studio.rashka.models.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import studio.rashka.MarsGame;
import studio.rashka.lib.implement.Buttons;

public class Towers {

    private boolean isActiveLauncher, isActiveFlare, isActiveLaser, isPlayFireWeapon = true;
    private boolean isActiveMenu = false, isBuy = false, isActiveShoot = false, isDamage = false,
            isStopShoot = false, isStopShootTower = false;
    private float angelTower, repeatShotTower = 0;
    private float shotPower, // ущерб
            shotSpeed, // скорость стрельбы
            shotRange, // диапазон взрыва
            shotDistance,
            shotRadius = 195;

    private ArrayList<Buttons> buttons;
    private String typeTower, towerLV;
    private float posX, posY, mp, sizeBtn = 128;
    private float posBtnX, posBtnY, energy;
    private int distance = 84, distanceMini = 42, priceBuy;
    private Circle zone, aimShoot;
    private Vector2 posMonster;

    private ParticleEffect fire;
    private Map<String, Sound> sounds;
    private AssetManager loadSoundWeapon;

    private static final Drawable img = MarsGame.getTextures().getTextureButtonSkin().getDrawable("NULL");

    public Towers(float x, float y) {
        posX = x;
        posY = y;
        posBtnX = x;
        posBtnY = y;
        typeTower = "NONE";
        towerLV = "NONE";

        sounds = new HashMap<String, Sound>();
        loadSoundWeapon = new AssetManager();

        isActiveLauncher = MarsGame.getPreference().getTacticsAttackLauncherGun();
        isActiveFlare = MarsGame.getPreference().getTacticsAttackFlareGun();
        isActiveLaser = MarsGame.getPreference().getTacticsAttackLaserGun();

        posMonster = new Vector2(0, 0);
        buttons = new ArrayList<Buttons>();
        buttonBuildTower();

        zone = new Circle(x + 64, y + 64, shotRadius);
        aimShoot = new Circle(posMonster.x, posMonster.y, 0);
    }

    private void loadSoundWeapon() {
        if (towerLV.equals("MachineGun_1")) loadSoundWeapon.load("sounds/weapons/MachineGun_1.ogg", Sound.class);
        else if (towerLV.equals("MachineGun_2")) loadSoundWeapon.load("sounds/weapons/MachineGun_2.ogg", Sound.class);
        else if (towerLV.equals("MachineGun_3")) loadSoundWeapon.load("sounds/weapons/MachineGun_3.ogg", Sound.class);
        else if (towerLV.equals("MachineGun_4")) loadSoundWeapon.load("sounds/weapons/MachineGun_4.ogg", Sound.class);
        else if (towerLV.equals("MachineGun_5")) loadSoundWeapon.load("sounds/weapons/MachineGun_5.ogg", Sound.class);
        else if (towerLV.equals("MachineGun_6")) loadSoundWeapon.load("sounds/weapons/MachineGun_6.ogg", Sound.class);
        else if (towerLV.equals("MachineGun_7")) loadSoundWeapon.load("sounds/weapons/MachineGun_7.ogg", Sound.class);
        else if (towerLV.equals("MachineGun_8")) loadSoundWeapon.load("sounds/weapons/MachineGun_8.ogg", Sound.class);
        else if (towerLV.equals("LauncherGun_1")) loadSoundWeapon.load("sounds/weapons/LauncherGun_1.ogg", Sound.class);
        else if (towerLV.equals("LauncherGun_2")) loadSoundWeapon.load("sounds/weapons/LauncherGun_2.ogg", Sound.class);
        else if (towerLV.equals("LauncherGun_3")) loadSoundWeapon.load("sounds/weapons/LauncherGun_3.ogg", Sound.class);
        else if (towerLV.equals("LauncherGun_4")) loadSoundWeapon.load("sounds/weapons/LauncherGun_4.ogg", Sound.class);
        else if (towerLV.equals("LauncherGun_5")) loadSoundWeapon.load("sounds/weapons/LauncherGun_5.ogg", Sound.class);
        else if (towerLV.equals("LauncherGun_6")) loadSoundWeapon.load("sounds/weapons/LauncherGun_6.ogg", Sound.class);
        else if (towerLV.equals("LauncherGun_7")) loadSoundWeapon.load("sounds/weapons/LauncherGun_7.ogg", Sound.class);
        else if (towerLV.equals("LauncherGun_8")) loadSoundWeapon.load("sounds/weapons/LauncherGun_8.ogg", Sound.class);
        else if (towerLV.equals("FlareGun_1")) loadSoundWeapon.load("sounds/weapons/FlareGun_1.ogg", Sound.class);
        else if (towerLV.equals("FlareGun_2")) loadSoundWeapon.load("sounds/weapons/FlareGun_2.ogg", Sound.class);
        else if (towerLV.equals("FlareGun_3")) loadSoundWeapon.load("sounds/weapons/FlareGun_3.ogg", Sound.class);
        else if (towerLV.equals("FlareGun_4")) loadSoundWeapon.load("sounds/weapons/FlareGun_4.ogg", Sound.class);
        else if (towerLV.equals("FlareGun_5")) loadSoundWeapon.load("sounds/weapons/FlareGun_5.ogg", Sound.class);
        else if (towerLV.equals("FlareGun_6")) loadSoundWeapon.load("sounds/weapons/FlareGun_6.ogg", Sound.class);
        else if (towerLV.equals("LaserGun_1")) loadSoundWeapon.load("sounds/weapons/LaserGun_1.ogg", Sound.class);
        else if (towerLV.equals("LaserGun_2")) loadSoundWeapon.load("sounds/weapons/LaserGun_2.ogg", Sound.class);
        else if (towerLV.equals("LaserGun_3")) loadSoundWeapon.load("sounds/weapons/LaserGun_3.ogg", Sound.class);
        else if (towerLV.equals("LaserGun_4")) loadSoundWeapon.load("sounds/weapons/LaserGun_4.ogg", Sound.class);
        else if (towerLV.equals("LaserGun_5")) loadSoundWeapon.load("sounds/weapons/LaserGun_5.ogg", Sound.class);
        else if (towerLV.equals("LaserGun_6")) loadSoundWeapon.load("sounds/weapons/LaserGun_6.ogg", Sound.class);
        else if (towerLV.equals("LaserGun_7")) loadSoundWeapon.load("sounds/weapons/LaserGun_7.ogg", Sound.class);
        else if (towerLV.equals("LaserGun_8")) loadSoundWeapon.load("sounds/weapons/LaserGun_8.ogg", Sound.class);
        loadSoundWeapon.finishLoading();
    }

    private void soundWeapon() {
        if (towerLV.equals("MachineGun_1")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_1.ogg", Sound.class));
        else if (towerLV.equals("MachineGun_2")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_2.ogg", Sound.class));
        else if (towerLV.equals("MachineGun_3")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_3.ogg", Sound.class));
        else if (towerLV.equals("MachineGun_4")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_4.ogg", Sound.class));
        else if (towerLV.equals("MachineGun_5")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_5.ogg", Sound.class));
        else if (towerLV.equals("MachineGun_6")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_6.ogg", Sound.class));
        else if (towerLV.equals("MachineGun_7")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_7.ogg", Sound.class));
        else if (towerLV.equals("MachineGun_8")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_8.ogg", Sound.class));
        else if (towerLV.equals("LauncherGun_1")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_1.ogg", Sound.class));
        else if (towerLV.equals("LauncherGun_2")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_2.ogg", Sound.class));
        else if (towerLV.equals("LauncherGun_3")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_3.ogg", Sound.class));
        else if (towerLV.equals("LauncherGun_4")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_4.ogg", Sound.class));
        else if (towerLV.equals("LauncherGun_5")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_5.ogg", Sound.class));
        else if (towerLV.equals("LauncherGun_6")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_6.ogg", Sound.class));
        else if (towerLV.equals("LauncherGun_7")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_7.ogg", Sound.class));
        else if (towerLV.equals("LauncherGun_8")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_8.ogg", Sound.class));
        else if (towerLV.equals("FlareGun_1")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_1.ogg", Sound.class));
        else if (towerLV.equals("FlareGun_2")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_2.ogg", Sound.class));
        else if (towerLV.equals("FlareGun_3")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_3.ogg", Sound.class));
        else if (towerLV.equals("FlareGun_4")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_4.ogg", Sound.class));
        else if (towerLV.equals("FlareGun_5")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_5.ogg", Sound.class));
        else if (towerLV.equals("FlareGun_6")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_6.ogg", Sound.class));
        else if (towerLV.equals("LaserGun_1")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_1.ogg", Sound.class));
        else if (towerLV.equals("LaserGun_2")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_2.ogg", Sound.class));
        else if (towerLV.equals("LaserGun_3")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_3.ogg", Sound.class));
        else if (towerLV.equals("LaserGun_4")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_4.ogg", Sound.class));
        else if (towerLV.equals("LaserGun_5")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_5.ogg", Sound.class));
        else if (towerLV.equals("LaserGun_6")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_6.ogg", Sound.class));
        else if (towerLV.equals("LaserGun_7")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_7.ogg", Sound.class));
        else if (towerLV.equals("LaserGun_8")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_8.ogg", Sound.class));
    }

    private void buttonBuildTower() {
        buttons.add(0, new Buttons("0", img, 128, 128, posX - distance, posY - distance));
        buttons.add(1, new Buttons("1", img, 128, 128, posX - distance, posY + distance));
        buttons.add(2, new Buttons("2", img, 128, 128, posX + distance, posY + distance));
        buttons.add(3, new Buttons("3", img, 128, 128, posX + distance, posY - distance));

        buttons.get(0).addListener(new ButtonsInputListener(buttons.get(0).getName()));
        buttons.get(1).addListener(new ButtonsInputListener(buttons.get(1).getName()));
        buttons.get(2).addListener(new ButtonsInputListener(buttons.get(2).getName()));
        buttons.get(3).addListener(new ButtonsInputListener(buttons.get(3).getName()));
    }

    private void loadParticleShoot() {
        loadSoundWeapon();
        if (typeTower.equals("MachineGun")) {
            fire = new ParticleEffect();
            fire.load(Gdx.files.internal("particles/shoot/tower/TowerMachineGun.p"), Gdx.files.internal("particles"));
        } else if (typeTower.equals("LauncherGun")) {
            fire = new ParticleEffect();
            fire.load(Gdx.files.internal("particles/shoot/tower/TowerLauncherGun.p"), Gdx.files.internal("particles"));
        } else if (typeTower.equals("FlareGun")) {
            fire = new ParticleEffect();
            fire.load(Gdx.files.internal("particles/shoot/tower/TowerFlareGun.p"), Gdx.files.internal("particles"));
        } else if (typeTower.equals("LaserGun")) {
            fire = new ParticleEffect();
            fire.load(Gdx.files.internal("particles/shoot/tower/TowerLaserGun.p"), Gdx.files.internal("particles"));
        }
    }

    private void powerTower() {
        if (typeTower.equals("MachineGun")) {
            //region code
            if (towerLV.equals("MachineGun_1")) {
                shotPower = 100 * 0.1f / 3; // ущерб
                shotSpeed = 0.1f * 1; // скорость стрельбы
                shotRange = 100 * 0.1f / 3; // диапазон взрыва
                shotDistance = 1.5f;
            } else if (towerLV.equals("MachineGun_2")) {
                shotPower = 100 * 0.1f / 3;
                shotSpeed = 0.1f * 3;
                shotRange = 100 * 0.1f / 3;
                shotDistance = 1.5f;
            } else if (towerLV.equals("MachineGun_3")) {
                shotPower = 100 * 0.1f / 3;
                shotSpeed = 0.1f * 5;
                shotRange = 100 * 0.1f / 3;
                shotDistance = 1.5f;
            } else if (towerLV.equals("MachineGun_4")) {
                shotPower = 100 * 0.1f / 3;
                shotSpeed = 0.1f * 5;
                shotRange = 100 * 0.2f / 3;
                shotDistance = 3;
            } else if (towerLV.equals("MachineGun_5")) {
                shotPower = 100 * 0.2f / 3;
                shotSpeed = 0.1f * 3;
                shotRange = 100 * 0.2f / 3;
                shotDistance = 7.5f;
            } else if (towerLV.equals("MachineGun_6")) {
                shotPower = 100 * 0.2f / 3;
                shotSpeed = 0.1f * 5;
                shotRange = 100 * 0.2f / 3;
                shotDistance = 7.5f;
            } else if (towerLV.equals("MachineGun_7")) {
                shotPower = 100 * 0.2f / 3;
                shotSpeed = 0.1f * 7;
                shotRange = 100 * 0.2f / 3;
                shotDistance = 8;
            } else if (towerLV.equals("MachineGun_8")) {
                shotPower = 100 * 0.3f / 3;
                shotSpeed = 0.1f * 6;
                shotRange = 100 * 0.3f / 3;
                shotDistance = 8.5f;
            }
            shotPower = shotPower + shotPower * shotSpeed;
            //endregion
        } else if (typeTower.equals("LauncherGun")) {
            //region code
            if (towerLV.equals("LauncherGun_1")) {
                shotPower = 100 * 0.4f / 3; // ущерб
                shotSpeed = 0.1f * 9; // скорость стрельбы
                shotRange = 100 * 0.2f / 3; // диапазон взрыва
                shotDistance = 3;
            } else if (towerLV.equals("LauncherGun_2")) {
                shotPower = 100 * 0.4f / 3;
                shotSpeed = 0.1f * 8;
                shotRange = 100 * 0.2f / 3;
                shotDistance = 4.5f;
            } else if (towerLV.equals("LauncherGun_3")) {
                shotPower = 100 * 0.6f / 3;
                shotSpeed = 0.1f * 8;
                shotRange = 100 * 0.3f / 3;
                shotDistance = 4.5f;
            } else if (towerLV.equals("LauncherGun_4")) {
                shotPower = 100 * 0.4f / 3;
                shotSpeed = 0.1f * 8;
                shotRange = 100 * 0.3f / 3;
                shotDistance = 9;
            } else if (towerLV.equals("LauncherGun_5")) {
                shotPower = 100 * 0.8f / 3;
                shotSpeed = 0.1f * 8;
                shotRange = 100 * 0.4f / 3;
                shotDistance = 7.5f;
            } else if (towerLV.equals("LauncherGun_6")) {
                shotPower = 100 * 1.0f / 3;
                shotSpeed = 0.1f * 8;
                shotRange = 100 * 0.5f / 3;
                shotDistance = 7.5f;
            } else if (towerLV.equals("LauncherGun_7")) {
                shotPower = 100 * 1.2f / 3;
                shotSpeed = 0.1f * 7;
                shotRange = 100 * 0.6f / 3;
                shotDistance = 7.5f;
            } else if (towerLV.equals("LauncherGun_8")) {
                shotPower = 100 * 1.4f / 3;
                shotSpeed = 0.1f * 8;
                shotRange = 100 * 0.7f / 3;
                shotDistance = 10.5f;
            }
            //endregion
        } else if (typeTower.equals("FlareGun")) {
            //region code
            if (towerLV.equals("FlareGun_1")) {
                shotPower = 100 * 0.4f / 3; // ущерб
                shotSpeed = 0.1f * 9; // скорость стрельбы
                shotRange = 100 * 0.2f / 3; // диапазон взрыва
                shotDistance = 6;
            } else if (towerLV.equals("FlareGun_2")) {
                shotPower = 100 * 0.6f / 3;
                shotSpeed = 0.1f * 9;
                shotRange = 100 * 0.2f / 3;
                shotDistance = 7.5f;
            } else if (towerLV.equals("FlareGun_3")) {
                shotPower = 100 * 0.8f / 3;
                shotSpeed = 0.1f * 9;
                shotRange = 100 * 0.3f / 3;
                shotDistance = 7.5f;
            } else if (towerLV.equals("FlareGun_4")) {
                shotPower = 100 * 0.4f / 3;
                shotSpeed = 0.1f * 5;
                shotRange = 100 * 0.3f / 3;
                shotDistance = 7.5f;
            } else if (towerLV.equals("FlareGun_5")) {
                shotPower = 100 * 1.0f / 3;
                shotSpeed = 0.1f * 8;
                shotRange = 100 * 0.4f / 3;
                shotDistance = 9;
            } else if (towerLV.equals("FlareGun_6")) {
                shotPower = 100 * 0.6f / 3;
                shotSpeed = 0.1f * 4;
                shotRange = 100 * 0.3f / 3;
                shotDistance = 10.5f;
            }
            //endregion
        } else if (typeTower.equals("LaserGun")) {
            //region code
            if (towerLV.equals("LaserGun_1")) {
                shotPower = 100 * 0.8f / 3; // ущерб
                shotSpeed = 0.1f * 9; // скорость стрельбы
                shotRange = 100 * 0.1f / 3; // диапазон взрыва
                shotDistance = 9;
            } else if (towerLV.equals("LaserGun_2")) {
                shotPower = 100 * 1.0f / 3;
                shotSpeed = 0.1f * 9;
                shotRange = 100 * 0.2f / 3;
                shotDistance = 9;
            } else if (towerLV.equals("LaserGun_3")) {
                shotPower = 100 * 0.2f / 3;
                shotSpeed = 0.1f * 4;
                shotRange = 100 * 0.3f / 3;
                shotDistance = 9;
            } else if (towerLV.equals("LaserGun_4")) {
                shotPower = 100 * 0.6f / 3;
                shotSpeed = 0.1f * 5;
                shotRange = 100 * 0.3f / 3;
                shotDistance = 10.5f;
            } else if (towerLV.equals("LaserGun_5")) {
                shotPower = 100 * 0.2f / 3;
                shotSpeed = 0.1f * 1;
                shotRange = 100 * 0.3f / 3;
                shotDistance = 10.5f;
            } else if (towerLV.equals("LaserGun_6")) {
                shotPower = 100 * 1.0f / 3;
                shotSpeed = 0.1f * 5;
                shotRange = 100 * 0.3f / 3;
                shotDistance = 13.5f;
            } else if (towerLV.equals("LaserGun_7")) {
                shotPower = 100 * 1.6f / 3;
                shotSpeed = 0.1f * 4;
                shotRange = 100 * 0.3f / 3;
                shotDistance = 12;
            } else if (towerLV.equals("LaserGun_8")) {
                shotPower = 100 * 1.8f / 3;
                shotSpeed = 0.1f * 6;
                shotRange = 100 * 0.6f / 3;
                shotDistance = 13.5f;
            }
            //endregion
        }
        aimShoot.setRadius(shotRange * 2);
        zone.setRadius(shotRadius + 5 * shotDistance);
        loadParticleShoot();
        soundWeapon();
        buttons.clear();
    }

    private float getAngel(float posX, float posY, float centerX, float centerY) {
        float x = posX - centerX;
        float y = posY - centerY;
        if (x == 0) return (y > 0) ? 180 : 0;
        float a = (float) (Math.atan(y / x) * 180 / Math.PI);
        a = (x > 0) ? a+90 : a+270;
        return a;
    }

    public void update(Vector2 positionMap, float deltaTime, float mp, float scale) {
        this.mp = mp;
        if (!isBuy) {
            //region Position Buttons
            if (scale == 1) {
                if (sizeBtn != 128) {
                    buttons.get(0).setSize(128, 128);
                    buttons.get(1).setSize(128, 128);
                    buttons.get(2).setSize(128, 128);
                    buttons.get(3).setSize(128, 128);
                    sizeBtn = 128;
                }
                buttons.get(0).setPosition(posBtnX - distance + positionMap.x, posBtnY - distance + positionMap.y);
                buttons.get(1).setPosition(posBtnX - distance + positionMap.x, posBtnY + distance + positionMap.y);
                buttons.get(2).setPosition(posBtnX + distance + positionMap.x, posBtnY + distance + positionMap.y);
                buttons.get(3).setPosition(posBtnX + distance + positionMap.x, posBtnY - distance + positionMap.y);
            } else {
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(posBtnX - distanceMini + positionMap.x * scale, posBtnY - distanceMini + positionMap.y * scale);
                buttons.get(1).setPosition(posBtnX - distanceMini + positionMap.x * scale, posBtnY + distanceMini + positionMap.y * scale);
                buttons.get(2).setPosition(posBtnX + distanceMini + positionMap.x * scale, posBtnY + distanceMini + positionMap.y * scale);
                buttons.get(3).setPosition(posBtnX + distanceMini + positionMap.x * scale, posBtnY - distanceMini + positionMap.y * scale);
            }
            //endregion
        } else {
            zone.setPosition(posX + 64, posY + 64);
            aimShoot.setPosition(posMonster.x, posMonster.y);

            if (isActiveShoot && this.mp > energy) {
                if (typeTower.substring(0, 4).equals("Mach")) {
                    fire.update(deltaTime);
                    isDamage = true;
                    if (MarsGame.getPreference().loadSound() == 1 && isPlayFireWeapon) {
                        sounds.get("SoundWeapon").loop(0.4f);
                        isPlayFireWeapon = false;
                        isStopShoot = true;
                    }
                } else {
                    if (MarsGame.getPreference().loadSound() == 1 && isPlayFireWeapon) {
                        sounds.get("SoundWeapon").play(0.5f);
                        isPlayFireWeapon = false;
                    }
                    fire.update(deltaTime);
                    isDamage = true;
                    if (fire.isComplete()) {
                        isDamage = false;
                        repeatShotTower += deltaTime;
                        if (repeatShotTower >= shotSpeed) {
                            fire.reset();
                            repeatShotTower = 0;
                            isDamage = true;
                            isPlayFireWeapon = true;
                        }
                    }
                }
            } else {
                fire.reset();
                isDamage = false;
                isPlayFireWeapon = true;
                if (isStopShoot) {
                    isStopShoot = false;
                    sounds.get("SoundWeapon").stop();
                }
            }
            if (MarsGame.getPreference().loadSound() == 0) sounds.get("SoundWeapon").stop();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(MarsGame.getTextures().textureRegion.get("Base"), posX + 24, posY + 28, 80, 80);
        if (!isBuy) {
            if (!isActiveMenu)
                batch.draw(MarsGame.getTextures().textureRegion.get("BuyTower"), posX, posY);
            else batch.draw(MarsGame.getTextures().textureRegion.get("BuyTowerClose"), posX, posY);
            if (isActiveMenu) {
                if (MarsGame.getPreference().loadMissionFinish("Missions_1_1")) batch.draw(MarsGame.getTextures().textureRegion.get("BuyTowerMachineGun"), posX - distance, posY - distance);
                else batch.draw(MarsGame.getTextures().textureRegion.get("BuyTowerNone"), posX - distance, posY - distance);
                if (isActiveLauncher) batch.draw(MarsGame.getTextures().textureRegion.get("BuyTowerLauncherGun"), posX - distance, posY + distance);
                else batch.draw(MarsGame.getTextures().textureRegion.get("BuyTowerNone"), posX - distance, posY + distance);
                if (isActiveFlare) batch.draw(MarsGame.getTextures().textureRegion.get("BuyTowerFlareGun"), posX + distance, posY + distance);
                else batch.draw(MarsGame.getTextures().textureRegion.get("BuyTowerNone"), posX + distance, posY + distance);
                if (isActiveLaser) batch.draw(MarsGame.getTextures().textureRegion.get("BuyTowerLaserGun"), posX + distance, posY - distance);
                else batch.draw(MarsGame.getTextures().textureRegion.get("BuyTowerNone"), posX + distance, posY - distance);
            }
        } else {
            //region MachineGun
            if (towerLV.equals("MachineGun_1"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun_1"),
                        posX + 32, posY - 60, 32, 128, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("MachineGun_2"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun_2"),
                        posX + 32, posY - 60, 32, 128, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("MachineGun_3"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun_3"),
                        posX + 32, posY - 40, 32, 108, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("MachineGun_4"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun_4"),
                        posX + 32, posY - 50, 32, 118, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("MachineGun_5"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun_5"),
                        posX + 32, posY - 45, 32, 113, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("MachineGun_6"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun_6"),
                        posX + 36, posY - 45, 26, 113, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("MachineGun_7"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun_7"),
                        posX + 36, posY - 44, 26, 112, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("MachineGun_8"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun_8"),
                        posX + 32, posY - 28, 32, 96, 64, 128, 1, 1, angelTower);
            //endregion
            //region LauncherGun
            else if (towerLV.equals("LauncherGun_1"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun_1"),
                        posX + 32, posY - 60, 32, 128, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("LauncherGun_2"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun_2"),
                        posX + 32, posY - 60, 32, 128, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("LauncherGun_3"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun_3"),
                        posX + 32, posY - 60, 32, 128, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("LauncherGun_4"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun_4"),
                        posX + 32, posY - 60, 32, 128, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("LauncherGun_5"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun_5"),
                        posX + 32, posY - 40, 32, 108, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("LauncherGun_6"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun_6"),
                        posX + 32, posY - 42, 32, 110, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("LauncherGun_7"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun_7"),
                        posX + 32, posY - 20, 32, 88, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("LauncherGun_8"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun_8"),
                        posX + 32, posY - 40, 32, 108, 64, 160, 1, 1, angelTower);
            //endregion
            //region FlareGun
            else if (towerLV.equals("FlareGun_1"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun_1"),
                        posX + 32, posY + 13, 32, 55, 64, 80, 1, 1, angelTower);
            else if (towerLV.equals("FlareGun_2"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun_2"),
                        posX + 32, posY + 13, 32, 55, 64, 80, 1, 1, angelTower);
            else if (towerLV.equals("FlareGun_3"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun_3"),
                        posX + 25, posY - 20, 39, 88, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("FlareGun_4"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun_4"),
                        posX + 32, posY + 32, 32, 32, 64, 64, 1, 1, angelTower);
            else if (towerLV.equals("FlareGun_5"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun_5"),
                        posX + 32, posY - 45, 32, 113, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("FlareGun_6"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun_6"),
                        posX + 32, posY + 32, 32, 32, 64, 64, 1, 1, angelTower);
            else if (towerLV.equals("FlareGun_7"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun_7"),
                        posX + 32, posY - 35, 32, 103, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("FlareGun_8"))
              batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun_8"),
                    posX + 24, posY + 35, 40, 33, 80, 80, 1, 1, angelTower);
            //endregion
            //region LaserGun
            else if (towerLV.equals("LaserGun_1"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun_1"),
                        posX + 32, posY - 28, 32, 96, 64, 128, 1, 1, angelTower);
            else if (towerLV.equals("LaserGun_2"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun_2"),
                        posX + 32, posY - 28, 32, 96, 64, 128, 1, 1, angelTower);
            else if (towerLV.equals("LaserGun_3"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun_3"),
                        posX + 32, posY - 60, 32, 128, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("LaserGun_4"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun_4"),
                        posX + 32, posY - 28, 32, 96, 64, 128, 1, 1, angelTower);
            else if (towerLV.equals("LaserGun_5"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun_5"),
                        posX + 32, posY - 60, 32, 128, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("LaserGun_6"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun_6"),
                        posX + 32, posY - 22, 32, 90, 64, 128, 1, 1, angelTower);
            else if (towerLV.equals("LaserGun_7"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun_7"),
                        posX + 32, posY - 50, 32, 118, 64, 160, 1, 1, angelTower);
            else if (towerLV.equals("LaserGun_8"))
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun_8"),
                        posX + 32, posY - 50, 32, 118, 64, 160, 1, 1, angelTower);
            //endregion
            fire.setPosition(posMonster.x, posMonster.y);
            if (isActiveShoot && this.mp > energy) fire.draw(batch);
        }
        if (mp <= 0 && isBuy) batch.draw(MarsGame.getTextures().textureRegion.get("EnergyIcon"), posX + 48, posY + 52, 32, 32);
    }

    public void setPosBtnX(float posBtnX) {
        this.posBtnX = posBtnX;
    }

    public void setPosBtnY(float posBtnY) {
        this.posBtnY = posBtnY;
    }

    public float getPosBtnX() {
        return posBtnX;
    }

    public float getPosBtnY() {
        return posBtnY;
    }

    public boolean isBuy() {
        return isBuy;
    }

    public void setActiveShoot(boolean active) {
        if (isActiveShoot != active) isActiveShoot = active;
    }

    public boolean isActiveMenu() {
        return isActiveMenu;
    }

    public void setActiveMenu(boolean activeMenu) {
        isActiveMenu = activeMenu;
    }

    public ArrayList<Buttons> getButtons() {
        return buttons;
    }

    public int getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(int priceBuy) {
        this.priceBuy = priceBuy;
    }

    public float getEnergy() {
        return energy;
    }

    public float getShotPower() {
        return shotPower;
    }

    public boolean isDamage() {
        return isDamage;
    }

    public float getMp() {
        return mp;
    }

    public Circle getZoneTower() {
        return zone;
    }

    public Circle getAimShootTower() {
        return aimShoot;
    }

    public void setSounds(boolean active) {
        if (!active) {
            if (sounds.get("SoundWeapon") != null) sounds.get("SoundWeapon").stop();
            if (isStopShoot) isStopShootTower = true;
        } else {
            if (isStopShoot) {
                sounds.get("SoundWeapon").loop(0.4f);
                isStopShootTower = false;
            }
        }
    }

    public void soundsStop() {
        if (sounds.get("SoundWeapon") != null) sounds.get("SoundWeapon").stop();
    }

    public void setAngel(Vector2 posMonster) {
        this.posMonster.set(posMonster);
        this.angelTower = getAngel(posMonster.x, posMonster.y, posX + 32 + 32, posY - 60 + 128);
    }

    public boolean isStopShootTower() {
        return isStopShootTower;
    }

    public void dispose() {
        try {
            if (sounds.get("SoundWeapon") != null) {
                sounds.get("SoundWeapon").dispose();
                fire.dispose();
            }
            zone = null;
            aimShoot = null;
            posMonster = null;
            buttons.clear();
            sounds.clear();
            loadSoundWeapon.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ButtonsInputListener extends ClickListener {
        private String name;

        public ButtonsInputListener(String name) {
            this.name = name;
        }

        @Override
        public void clicked (InputEvent event, float x, float y) {

            if (name.equals("0")) {
                //region
                if (!isBuy && isActiveMenu) {
                    if (MarsGame.getPreference().loadMissionFinish("Missions_1_1")) {
                        if (mp > 10) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            typeTower = "MachineGun";
                            if (MarsGame.getPreference().getWeaponUpgrade(typeTower).equals("")) towerLV = "MachineGun_1";
                            else towerLV = MarsGame.getPreference().getWeaponUpgrade(typeTower);
                            powerTower();
                            isBuy = true;
                            priceBuy = 10;
                            energy = 1;
                        }
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("1")) {
                //region
                if (!isBuy && isActiveMenu) {
                    if (isActiveLauncher) {
                        if (mp > 20) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            typeTower = "LauncherGun";
                            if (MarsGame.getPreference().getWeaponUpgrade(typeTower).equals("")) towerLV = "LauncherGun_1";
                            else towerLV = MarsGame.getPreference().getWeaponUpgrade(typeTower);
                            powerTower();
                            isBuy = true;
                            priceBuy = 20;
                            energy = MarsGame.getPreference().getTacticsAttackLauncherGunEnergy();
                        } else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                    else {
                        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("2")) {
                //region
                if (!isBuy && isActiveMenu) {
                    if (isActiveFlare) {
                        if (mp > 30) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            typeTower = "FlareGun";
                            if (MarsGame.getPreference().getWeaponUpgrade(typeTower).equals("")) towerLV = "FlareGun_1";
                            else towerLV = MarsGame.getPreference().getWeaponUpgrade(typeTower);
                            powerTower();
                            isBuy = true;
                            priceBuy = 30;
                            energy = MarsGame.getPreference().getTacticsAttackFlareGunEnergy();
                        } else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("3")) {
                //region
                if (!isBuy && isActiveMenu) {
                    if (isActiveLaser) {
                        if (mp > 40) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            typeTower = "LaserGun";
                            if (MarsGame.getPreference().getWeaponUpgrade(typeTower).equals("")) towerLV = "LaserGun_1";
                            else towerLV = MarsGame.getPreference().getWeaponUpgrade(typeTower);
                            powerTower();
                            isBuy = true;
                            priceBuy = 40;
                            energy = MarsGame.getPreference().getTacticsAttackLaserGunEnergy();
                        } else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            }
        }
    }
}