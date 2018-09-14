package studio.rashka.models.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.Time;
import studio.rashka.lib.TimeRegeneration;
import studio.rashka.lib.singleton.ScaleMap;
import studio.rashka.models.arsenal.BonusTactics;
import studio.rashka.models.monsters.Boss;
import studio.rashka.screen.missions.AllMonsters;

public class GamesPanel {

    private OrthographicCamera camera;
    private String mission;

    private boolean touchHome = false, touchPausePlay = false, touchNewly = false, touchRate = false, showRate = false,
            touchSettings = false, isSettings = false,
            touchFire = false, touchIce = false, touchPoison = false,
            touchShieldHPAdd = false, touchEnergyAdd = false, touchMicrowave = false,
            touchMusic = false, touchSound = false, touchVibro = false,
            resetFire = false, resetIce = false, resetPoison = false;
    private float progressHP = 240, // 0 = 0 * 240 = 100
            progressMP = 246, // 246 = 100 * 0 = 0
//            scale = 1,
            faster = 1;
    private float hideFire = 0, hidePoison = 0, hideIce = 0,
            hideFireH, hidePoisonH, hideIceH;

    private Time timeFire, timePoison, timeIce;
    private TimeRegeneration regenerationHP, regenerationMP;
    private BonusTactics bonusTactics;

    private ParticleEffect radar;
    private Magic magic;

    public GamesPanel(String mission) {
        this.mission = mission;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, MarsGame.WIDTH, MarsGame.HEIGHT);
        camera.update();

        bonusTactics = new BonusTactics();
        magic = new Magic();

        if (MarsGame.getPreference().getTacticsTechnologiesRadar()) {
            radar = new ParticleEffect();
            radar.load(Gdx.files.internal("particles/Radar.p"), Gdx.files.internal("particles"));
            radar.setPosition(144, MarsGame.HEIGHT - 144);
            radar.start();
        }

        timeFire = new Time(MarsGame.getPreference().loadHydrogenCooldown(), "noSec");
        timeIce = new Time(MarsGame.getPreference().loadRefrigerantCooldown(), "noSec");
        timePoison = new Time(MarsGame.getPreference().loadZomanCooldown(), "noSec");

        regenerationHP = new TimeRegeneration(1);
        regenerationMP = new TimeRegeneration(2);
        regenerationMP.setEnergyBonus(bonusTactics.getEnergyBonus());

        hideFireH = 120f / (float) MarsGame.getPreference().loadHydrogenCooldown();
        hideIceH = 120f / (float) MarsGame.getPreference().loadRefrigerantCooldown();
        hidePoisonH = 120f / (float) MarsGame.getPreference().loadZomanCooldown();
    }

    public void updateRadar(float deltaTime) {
        if (MarsGame.getPreference().getTacticsTechnologiesRadar()) radar.update(deltaTime);
    }

    public void update() {
        if (faster == 1) {
            regenerationHP.updateAddHP();
            regenerationMP.updateAddMP();
        } else {
            regenerationHP.updateAddHP2();
            regenerationMP.updateAddMP2();
        }

        progressHP = regenerationHP.getHp() * 240 / MarsGame.getPreference().loadHPBase();
        progressMP = regenerationMP.getMp() * 246 / MarsGame.getPreference().loadMPEnergy();

        if (resetFire) {
            timeFire.setTimeReset();
            resetFire = false;
        }
        if (resetIce) {
            timeIce.setTimeReset();
            resetIce = false;
        }
        if (resetPoison) {
            timePoison.setTimeReset();
            resetPoison = false;
        }

        if (!timeFire.isActive()) {
            if (faster == 1) timeFire.updateTime();
            else timeFire.updateTime2();
            hideFire = 120 - hideFireH * timeFire.getTime();
        }
        if (!timeIce.isActive()) {
            if (faster == 1) timeIce.updateTime();
            else timeIce.updateTime2();
            hideIce = 120 - hideIceH * timeIce.getTime();
        }
        if (!timePoison.isActive()) {
            if (faster == 1) timePoison.updateTime();
            else timePoison.updateTime2();
            hidePoison = 120 - hidePoisonH * timePoison.getTime();
        }

        if (bonusTactics.isLifeActive() && regenerationHP.getHp() < regenerationHP.getUpLife()) {
            regenerationHP.setHp(-(MarsGame.getPreference().loadHPBase() * bonusTactics.getUpLife() / 100));
            bonusTactics.setLifeActive(false);
        }
    }

    public void render(SpriteBatch batch, ArrayList<AllMonsters> monsterses) {
        batch.setProjectionMatrix(camera.combined);

        //region Panel
        batch.draw(Textures.getInstance().textureRegion.get("FrameTopBG"), MarsGame.WIDTH / 2 - 96, -48, 96, 224, 192, 448, 1, 1, -90);
        batch.draw(Textures.getInstance().textureRegion.get("BallHandle"), 185, 8, 320, 128);
        batch.draw(Textures.getInstance().textureRegion.get("BallHandle"), MarsGame.WIDTH - 185, 8, -320, 128);

        batch.draw(Textures.getInstance().textureRegion.get("FonButtons"), MarsGame.WIDTH / 2 - 640, 8, 640, 214);
        batch.draw(Textures.getInstance().textureRegion.get("FonButtons"), MarsGame.WIDTH / 2 + 640, 8, -640, 214);

        batch.draw(Textures.getInstance().textureRegion.get("HP"), MarsGame.WIDTH / 2 - 119, 102, progressHP, 27);
        batch.draw(Textures.getInstance().textureRegion.get("ProgressHP"), MarsGame.WIDTH / 2 - 125, 100, 256, 32);
        batch.draw(Textures.getInstance().textureRegion.get("ShieldHP"), MarsGame.WIDTH / 2 - 210, 48, 100, 110);

        batch.draw(Textures.getInstance().textureRegion.get("MP"), MarsGame.WIDTH / 2 + 160 - progressMP, 57, (progressMP - 14), 27);
        batch.draw(Textures.getInstance().textureRegion.get("ProgressMP_line"), MarsGame.WIDTH / 2 + 146 - progressMP, 60, 28, 18);
        batch.draw(Textures.getInstance().textureRegion.get("ProgressMP"), MarsGame.WIDTH / 2 - 110, 55, 256, 32);
        batch.draw(Textures.getInstance().textureRegion.get("BatteryMP"), MarsGame.WIDTH / 2 + 140, 48, 64, 115);

        if (!touchShieldHPAdd) {
            batch.draw(Textures.getInstance().textureRegion.get("ShieldHPAdd"), MarsGame.WIDTH / 2 - 608, 60, 120, 120);
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 - 608, 70, 120, 30);
        } else {
            batch.draw(Textures.getInstance().textureRegion.get("ShieldHPAdd"), MarsGame.WIDTH / 2 - 603, 65, 110, 110);
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 - 603, 70, 110, 30);
        }
        if (!touchEnergyAdd) {
            batch.draw(Textures.getInstance().textureRegion.get("EnergyAdd"), MarsGame.WIDTH / 2 - 472, 60, 120, 120);
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 - 472, 70, 120, 30);
        } else {
            batch.draw(Textures.getInstance().textureRegion.get("EnergyAdd"), MarsGame.WIDTH / 2 - 467, 65, 110, 110);
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 - 467, 70, 110, 30);
        }
        if (!touchMicrowave) {
            batch.draw(Textures.getInstance().textureRegion.get("Microwave"), MarsGame.WIDTH / 2 - 338, 60, 120, 120);
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 - 338, 70, 120, 30);
        } else {
            batch.draw(Textures.getInstance().textureRegion.get("Microwave"), MarsGame.WIDTH / 2 - 333, 65, 110, 110);
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 - 333, 70, 110, 30);
        }

        if (MarsGame.getPreference().loadShieldHPAdd() >= 1) batch.draw(Textures.getInstance().textureRegion.get("Active"), MarsGame.WIDTH / 2 - 596, 182, 96, 19);
        else {
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 - 608, 60, 120, 120);
            batch.draw(Textures.getInstance().textureRegion.get("NotActive"), MarsGame.WIDTH / 2 - 596, 182, 96, 19);
        }
        if (MarsGame.getPreference().loadEnergyAdd() >= 1) batch.draw(Textures.getInstance().textureRegion.get("Active"), MarsGame.WIDTH / 2 - 460, 182, 96, 19);
        else {
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 - 472, 60, 120, 120);
            batch.draw(Textures.getInstance().textureRegion.get("NotActive"), MarsGame.WIDTH / 2 - 460, 182, 96, 19);
        }
        if (MarsGame.getPreference().loadMicrowave() >= 1) batch.draw(Textures.getInstance().textureRegion.get("Active"), MarsGame.WIDTH / 2 - 326, 182, 96, 19);
        else {
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 - 338, 60, 120, 120);
            batch.draw(Textures.getInstance().textureRegion.get("NotActive"), MarsGame.WIDTH / 2 - 326, 182, 96, 19);
        }

        if (!touchFire) batch.draw(Textures.getInstance().textureRegion.get("Fire"), MarsGame.WIDTH / 2 + 218, 60, 120, 120);
        else batch.draw(Textures.getInstance().textureRegion.get("Fire"), MarsGame.WIDTH / 2 + 223, 65, 110, 110);
        if (!touchPoison) batch.draw(Textures.getInstance().textureRegion.get("Poison"), MarsGame.WIDTH / 2 + 352, 60, 120, 120);
        else batch.draw(Textures.getInstance().textureRegion.get("Poison"), MarsGame.WIDTH / 2 + 357, 65, 110, 110);
        if (!touchIce) batch.draw(Textures.getInstance().textureRegion.get("Ice"), MarsGame.WIDTH / 2 + 488, 60, 120, 120);
        else batch.draw(Textures.getInstance().textureRegion.get("Ice"), MarsGame.WIDTH / 2 + 493, 65, 110, 110);

        if (timeFire.isActive()) batch.draw(Textures.getInstance().textureRegion.get("Active"), MarsGame.WIDTH / 2 + 230, 182, 96, 19);
        else if (!timeFire.isActive()) {
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 + 218, 60, 120, hideFire);
            batch.draw(Textures.getInstance().textureRegion.get("NotActive"), MarsGame.WIDTH / 2 + 230, 182, 96, 19);
        }
        if (timePoison.isActive()) batch.draw(Textures.getInstance().textureRegion.get("Active"), MarsGame.WIDTH / 2 + 364, 182, 96, 19);
        else if (!timePoison.isActive()) {
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 + 352, 60, 120, hidePoison);
            batch.draw(Textures.getInstance().textureRegion.get("NotActive"), MarsGame.WIDTH / 2 + 364, 182, 96, 19);
        }
        if (timeIce.isActive()) batch.draw(Textures.getInstance().textureRegion.get("Active"), MarsGame.WIDTH / 2 + 500, 182, 96, 19);
        else if (!timeIce.isActive()) {
            batch.draw(Textures.getInstance().textureRegion.get("Hide"), MarsGame.WIDTH / 2 + 488, 60, 120, hideIce);
            batch.draw(Textures.getInstance().textureRegion.get("NotActive"), MarsGame.WIDTH / 2 + 500, 182, 96, 19);
        }
        batch.draw(Textures.getInstance().textureRegion.get("EnergyIcon"), MarsGame.WIDTH / 2 + 243, 68, 30, 30);
        batch.draw(Textures.getInstance().textureRegion.get("EnergyIcon"), MarsGame.WIDTH / 2 + 377, 68, 30, 30);
        batch.draw(Textures.getInstance().textureRegion.get("EnergyIcon"), MarsGame.WIDTH / 2 + 513, 68, 30, 30);
        //endregion
        bonusTactics.render(batch);
//        batch.draw(Textures.getInstance().textureRegion.get("Move"), 32, 32, 256, 256);
        batch.draw(Textures.getInstance().textureRegion.get("Shot"), MarsGame.WIDTH - 288, 32, 256, 256);
        //region Radar
        if (MarsGame.getPreference().getTacticsTechnologiesRadar()) {
            batch.draw(Textures.getInstance().textureRegion.get("Radar"), 16, MarsGame.HEIGHT - 272, 256, 256);
            for (int i = 0; i < monsterses.size(); i++) {
                if (mission.equals("Missions_1_3") || mission.equals("Missions_1_4")) {
                    if (monsterses.get(i).isLiving() && !monsterses.get(i).isShoot())
                        batch.draw(Textures.getInstance().textureRegion.get("ColorWhite"),
                                monsterses.get(i).getPosition().x / 11 + 40, MarsGame.HEIGHT - 200 + monsterses.get(i).getPosition().y / 6 - 45, 4, 4);
                    else if (monsterses.get(i).isLiving() && monsterses.get(i).isShoot())
                        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"),
                                monsterses.get(i).getPosition().x / 11 + 40, MarsGame.HEIGHT - 200 + monsterses.get(i).getPosition().y / 6 - 45, 4, 4);
                } else if (mission.equals("Missions_1_6")) {
                    if (monsterses.get(i).isLiving() && !monsterses.get(i).isShoot())
                        batch.draw(Textures.getInstance().textureRegion.get("ColorWhite"),
                                monsterses.get(i).getPosition().x / 9f + 40, MarsGame.HEIGHT - 200 + monsterses.get(i).getPosition().y / 6 - 45, 4, 4);
                    else if (monsterses.get(i).isLiving() && monsterses.get(i).isShoot())
                        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"),
                                monsterses.get(i).getPosition().x / 9f + 40, MarsGame.HEIGHT - 200 + monsterses.get(i).getPosition().y / 6 - 45, 4, 4);
                } else {
                    if (monsterses.get(i).isLiving() && !monsterses.get(i).isShoot())
                        batch.draw(Textures.getInstance().textureRegion.get("ColorWhite"),
                                monsterses.get(i).getPosition().x / 8.5f + 40, MarsGame.HEIGHT - 200 + monsterses.get(i).getPosition().y / 6 - 45, 4, 4);
                    else if (monsterses.get(i).isLiving() && monsterses.get(i).isShoot())
                        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"),
                                monsterses.get(i).getPosition().x / 8.5f + 40, MarsGame.HEIGHT - 200 + monsterses.get(i).getPosition().y / 6 - 45, 4, 4);
                }
            }
            radar.draw(batch);
        }
        //endregion
        //region Menu
        batch.draw(Textures.getInstance().textureRegion.get("MenuGames"), MarsGame.WIDTH - 170, MarsGame.HEIGHT - 171, 96, 78, 192, 156, 1, 1, 90);
        batch.draw(Textures.getInstance().textureRegion.get("MenuGamesLine"), MarsGame.WIDTH - 106, MarsGame.HEIGHT - 270, 32, 78, 64, 156, 1, 1, 90);
        batch.draw(Textures.getInstance().textureRegion.get("MenuGamesLine"), MarsGame.WIDTH - 106, MarsGame.HEIGHT - 334, 32, 78, 64, 156, 1, 1, 90);
        batch.draw(Textures.getInstance().textureRegion.get("MenuGamesLine"), MarsGame.WIDTH - 106, MarsGame.HEIGHT - 398, 32, 78, 64, 156, 1, 1, 90);
        batch.draw(Textures.getInstance().textureRegion.get("MenuGamesLine"), MarsGame.WIDTH - 106, MarsGame.HEIGHT - 462, 32, 78, 64, 156, 1, 1, 90);
        batch.draw(Textures.getInstance().textureRegion.get("MenuGamesLine"), MarsGame.WIDTH - 106, MarsGame.HEIGHT - 500, 32, 78, 64, 156, 1, 1, 90);
        batch.draw(Textures.getInstance().textureRegion.get("MenuGames2"), MarsGame.WIDTH - 114, MarsGame.HEIGHT - 569, 40, 78, 80, 156, 1, 1, 90);
        if (!touchHome) batch.draw(Textures.getInstance().textureRegion.get("MenuGamesHome"), MarsGame.WIDTH - 107, MarsGame.HEIGHT - 100, 90, 90);
        else batch.draw(Textures.getInstance().textureRegion.get("MenuGamesHome"), MarsGame.WIDTH - 104, MarsGame.HEIGHT - 97, 84, 84);
        if (!touchPausePlay) {
            if (MarsGame.getPreference().isPlay) batch.draw(Textures.getInstance().textureRegion.get("MenuGamesPause"), MarsGame.WIDTH - 107, MarsGame.HEIGHT - 203, 90, 90);
            else batch.draw(Textures.getInstance().textureRegion.get("MenuGamesPlay"), MarsGame.WIDTH - 107, MarsGame.HEIGHT - 203, 90, 90);
        }
        else {
            if (MarsGame.getPreference().isPlay) batch.draw(Textures.getInstance().textureRegion.get("MenuGamesPause"), MarsGame.WIDTH - 104, MarsGame.HEIGHT - 200, 84, 84);
            else batch.draw(Textures.getInstance().textureRegion.get("MenuGamesPlay"), MarsGame.WIDTH - 104, MarsGame.HEIGHT - 200, 84, 84);
        }
        if (!touchNewly) batch.draw(Textures.getInstance().textureRegion.get("MenuGamesNewly"), MarsGame.WIDTH - 107, MarsGame.HEIGHT - 306, 90, 90);
        else batch.draw(Textures.getInstance().textureRegion.get("MenuGamesNewly"), MarsGame.WIDTH - 104, MarsGame.HEIGHT - 303, 84, 84);
        if (!touchRate) batch.draw(Textures.getInstance().textureRegion.get("MenuGamesRate"), MarsGame.WIDTH - 107, MarsGame.HEIGHT - 409, 90, 90);
        else batch.draw(Textures.getInstance().textureRegion.get("MenuGamesRate"), MarsGame.WIDTH - 104, MarsGame.HEIGHT - 406, 84, 84);
        if (!touchSettings) batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettings"), MarsGame.WIDTH - 107, MarsGame.HEIGHT - 512, 90, 90);
        else batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettings"), MarsGame.WIDTH - 104, MarsGame.HEIGHT - 509, 84, 84);
        if (isSettings) {
            if (!touchMusic) {
                if (MarsGame.getPreference().loadMusic() == 1)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsMusicOn"), MarsGame.WIDTH - 220, MarsGame.HEIGHT - 512, 90, 90);
                else if (MarsGame.getPreference().loadMusic() == 0)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsMusicOff"), MarsGame.WIDTH - 220, MarsGame.HEIGHT - 512, 90, 90);
            } else {
                if (MarsGame.getPreference().loadMusic() == 1)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsMusicOn"), MarsGame.WIDTH - 217, MarsGame.HEIGHT - 509, 84, 84);
                else if (MarsGame.getPreference().loadMusic() == 0)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsMusicOff"), MarsGame.WIDTH - 217, MarsGame.HEIGHT - 509, 84, 84);
            }
            if (!touchSound) {
                if (MarsGame.getPreference().loadSound() == 1)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsSoundOn"), MarsGame.WIDTH - 204, MarsGame.HEIGHT - 602, 90, 90);
                else if (MarsGame.getPreference().loadSound() == 0)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsSoundOff"), MarsGame.WIDTH - 204, MarsGame.HEIGHT - 602, 90, 90);
            } else {
                if (MarsGame.getPreference().loadSound() == 1)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsSoundOn"), MarsGame.WIDTH - 201, MarsGame.HEIGHT - 599, 84, 84);
                else if (MarsGame.getPreference().loadSound() == 0)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsSoundOff"), MarsGame.WIDTH - 201, MarsGame.HEIGHT - 599, 84, 84);
            }
            if (!touchVibro) {
                if (MarsGame.getPreference().loadVibro() == 1)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsVibroOn"), MarsGame.WIDTH - 107, MarsGame.HEIGHT - 625, 90, 90);
                else if (MarsGame.getPreference().loadVibro() == 0)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsVibroOff"), MarsGame.WIDTH - 107, MarsGame.HEIGHT - 625, 90, 90);
            } else {
                if (MarsGame.getPreference().loadVibro() == 1)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsVibroOn"), MarsGame.WIDTH - 104, MarsGame.HEIGHT - 622, 84, 84);
                else if (MarsGame.getPreference().loadVibro() == 0)
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGamesSettingsVibroOff"), MarsGame.WIDTH - 104, MarsGame.HEIGHT - 622, 84, 84);
            }
        }
        if (ScaleMap.INSTANCE.getScale() == 1) batch.draw(Textures.getInstance().textureRegion.get("X1"), MarsGame.WIDTH - 240, MarsGame.HEIGHT - 80, 60, 60);
        else if (ScaleMap.INSTANCE.getScale() == 0.5) batch.draw(Textures.getInstance().textureRegion.get("X2"), MarsGame.WIDTH - 240, MarsGame.HEIGHT - 80, 60, 60);

        if (faster == 1) batch.draw(Textures.getInstance().textureRegion.get("FastOff"), MarsGame.WIDTH - 320, MarsGame.HEIGHT - 80, 60, 60);
        else if (faster == 2) batch.draw(Textures.getInstance().textureRegion.get("FastOk"), MarsGame.WIDTH - 320, MarsGame.HEIGHT - 80, 60, 60);
        //endregion
        //region Rate
        if (showRate) {
            batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 - 266, MarsGame.HEIGHT / 2 - 74, 532, 276);
            batch.draw(Textures.getInstance().textureRegion.get("Black"), MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 64, 512, 256);
            batch.draw(Textures.getInstance().textureRegion.get("Rank_4"), MarsGame.WIDTH / 2 - 320, MarsGame.HEIGHT / 2 - 128, 128, 128);
            batch.draw(Textures.getInstance().textureRegion.get("Rank_4"), MarsGame.WIDTH / 2 - 320, MarsGame.HEIGHT / 2 + 128, 128, 128);
            batch.draw(Textures.getInstance().textureRegion.get("Rank_4"), MarsGame.WIDTH / 2 + 192, MarsGame.HEIGHT / 2 - 128, 128, 128);
            batch.draw(Textures.getInstance().textureRegion.get("Rank_4"), MarsGame.WIDTH / 2 + 192, MarsGame.HEIGHT / 2 + 128, 128, 128);
        }
        //endregion
    }

    public void renderBoss(SpriteBatch batch, Boss boss) {
        if (MarsGame.getPreference().getTacticsTechnologiesShowMonsterLife()) {
            batch.draw(Textures.getInstance().textureRegion.get("Black"), MarsGame.WIDTH / 2 - 503, MarsGame.HEIGHT - 62, 1006, 28);
            batch.draw(Textures.getInstance().textureRegion.get("HP"), MarsGame.WIDTH / 2 - 503, MarsGame.HEIGHT - 62, boss.getLife() * 1006 / boss.getLifeMAX(), 28);
            batch.draw(Textures.getInstance().textureRegion.get("ProgressBarHPCenter"), MarsGame.WIDTH / 2 - 500, MarsGame.HEIGHT - 64, 1000, 32);
            batch.draw(Textures.getInstance().textureRegion.get("ProgressBarHP"), MarsGame.WIDTH / 2 - 512, MarsGame.HEIGHT - 64, 32, 32);
            batch.draw(Textures.getInstance().textureRegion.get("ProgressBarHP"), MarsGame.WIDTH / 2 + 512, MarsGame.HEIGHT - 64, -32, 32);
        }
    }

    public void setRemoveHP(float removeHP) {
        regenerationHP.setHp(removeHP);
    }

    public void setRemoveMP(float removeMP) {
        regenerationMP.setMp(removeMP);
    }

    public int getHP() {
        return regenerationHP.getHp();
    }

    public int getMP() {
        return regenerationMP.getMp();
    }

    public boolean isGoodLife() {
        return regenerationHP.isGoodLife();
    }

    public void setResetFire(boolean resetFire) {
        this.resetFire = resetFire;
    }

    public void setResetIce(boolean resetIce) {
        this.resetIce = resetIce;
    }

    public void setResetPoison(boolean resetPoison) {
        this.resetPoison = resetPoison;
    }

    public void setTouchHome(boolean touchHome) {
        this.touchHome = touchHome;
    }

    public void setTouchNewly(boolean touchNewly) {
        this.touchNewly = touchNewly;
    }

    public void setTouchRate(boolean touchRate) {
        this.touchRate = touchRate;
    }

    public boolean isShowRate() {
        return showRate;
    }

    public void setShowRate(boolean showRate) {
        this.showRate = showRate;
    }

    public void setTouchSettings(boolean touchSettings) {
        this.touchSettings = touchSettings;
    }

    public void setTouchPausePlay(boolean tocuhPausePlay) {
        this.touchPausePlay = tocuhPausePlay;
    }

    public void setTouchMusic(boolean touchMusic) {
        this.touchMusic = touchMusic;
    }

    public void setTouchSound(boolean touchSound) {
        this.touchSound = touchSound;
    }

    public void setTouchVibro(boolean touchVibro) {
        this.touchVibro = touchVibro;
    }

    public void setTouchShieldHPAdd(boolean touchShieldHPAdd) {
        this.touchShieldHPAdd = touchShieldHPAdd;
    }

    public void setTouchEnergyAdd(boolean touchEnergyAdd) {
        this.touchEnergyAdd = touchEnergyAdd;
    }

    public void setTouchMicrowave(boolean touchMicrowave) {
        this.touchMicrowave = touchMicrowave;
    }

    public void setTouchFire(boolean touchFire) {
        this.touchFire = touchFire;
    }

    public void setTouchIce(boolean touchIce) {
        this.touchIce = touchIce;
    }

    public void setTouchPoison(boolean touchPoison) {
        this.touchPoison = touchPoison;
    }

    public boolean isActiveFire() {
        return timeFire.isActive();
    }

    public boolean isActiveIce() {
        return timeIce.isActive();
    }

    public boolean isActivePoison() {
        return timePoison.isActive();
    }

    public boolean isSettings() {
        return isSettings;
    }

    public void setSettings(boolean settings) {
        isSettings = settings;
    }

    public float getFaster() {
        return faster;
    }

    public void setFaster(float faster) {
        this.faster = faster;
    }

    public float getEnergyBonus() {
        return bonusTactics.getEnergyBonus();
    }

    public float getShieldBonus() {
        return bonusTactics.getShieldBonus();
    }

    public float getDamageBonus() {
        return bonusTactics.getDamageBonus();
    }

    public Magic getMagic() {
        return magic;
    }

    public void dispose() {
        try {
            if (MarsGame.getPreference().getTacticsTechnologiesRadar()) radar.dispose();
            timeFire = null;
            timePoison = null;
            timeIce = null;
            regenerationHP = null;
            regenerationMP = null;
            bonusTactics = null;
            magic.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}