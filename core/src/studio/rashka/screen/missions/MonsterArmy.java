package studio.rashka.screen.missions;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.StringBuilder;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Time;
import studio.rashka.models.games.Magic;
import studio.rashka.models.games.Towers;
import studio.rashka.models.monsters.Boss;
import studio.rashka.models.monsters.WormCave;
import studio.rashka.models.robots.Worker;

public class MonsterArmy {

    private String mission;
    private Random random;
    private Boss boss;

    private ArrayList<WormCave> wormCaves;
    private ArrayList<Worker> workers;
    private ArrayList<AllMonsters> monster_List;
    private Label showTextEnd;

    private Time timeStart, timeStart2, timeStart3, timeFinish, timeStartRobot;
    private int workersNumber, timeFinishMinute, timeFinishSecond,
            add = 0, miniAdd = -1, wavesMonster = 0, totalWaveMonster, speedMoveBoss = 1;
    private boolean isGameEnd = false, isStartNewWave = false, isBoss = false, isMiniAdd = false, isFaster = false;

    public MonsterArmy(String mission) {
        this.mission = mission;

        random = new Random();
        wormCaves = new ArrayList<WormCave>();
        workers = new ArrayList<Worker>();
        monster_List = new ArrayList<AllMonsters>();
        showTextEnd = new Label("", new LabelStyle(MarsGame.getFontTTF().getFont54(), Color.WHITE));

        timeStartRobot = new Time(4, "sec");
        workersNumber = MarsGame.getPreference().getTacticsTechnologiesRobot();

        //region 1
        if (mission.equals("Missions_1_1")) {
            //region code
            timeFinish = new Time(1, "sec");
            timeFinishMinute = 7;
            timeFinishSecond = 0;
            timeStart = new Time(3.5f, "noSec");
            timeStart2 = new Time(0, "sec");
            wormCaves.add(0, new WormCave(300, 1080 - 84, 1.0f, 90));
            wormCaves.add(1, new WormCave(MarsGame.WIDTH - 230, 750, 0.8f, 180));
            //endregion
        } else if (mission.equals("Missions_1_2")) {
            //region code
            timeFinish = new Time(1, "sec");
            timeFinishMinute = 8;
            timeFinishSecond = 0;
            timeStart = new Time(8.5f, "noSec");
            timeStart2 = new Time(6.5f, "noSec");
            wormCaves.add(0, new WormCave(272, 1080 - 32, 1.0f, 0));
            wormCaves.add(1, new WormCave(272, 256, 1.0f, 180));
            wormCaves.add(2, new WormCave(MarsGame.WIDTH - 272, 1080 - 32, 1.0f, 0));
            wormCaves.add(3, new WormCave(MarsGame.WIDTH - 272, 256, 1.0f, 180));
            //endregion
        } else if (mission.equals("Missions_1_3")) {
            //region code
            wavesMonster = 5;
            totalWaveMonster = 35;
            timeStart = new Time(3.5f, "noSec");
            timeStart2 = new Time(7.5f, "noSec");
            //endregion
        } else if (mission.equals("Missions_1_4")) {
            //region code
            wavesMonster = 8;
            totalWaveMonster = 50;
            timeStart = new Time(3.5f, "noSec");
            timeStart2 = new Time(8.5f, "noSec");
            wormCaves.add(0, new WormCave(352, 1080 - 64, 1.0f, 0));
            wormCaves.add(1, new WormCave(352, 256, 1.0f, 180));
            //endregion
        } else if (mission.equals("Missions_1_5")) {
            //region code
            wavesMonster = 7;
            totalWaveMonster = 100;
            timeStart = new Time(3.5f, "noSec");
            timeStart2 = new Time(0, "sec");
            wormCaves.add(0, new WormCave(MarsGame.WIDTH - 230, 192, 1.0f, 180));
            //endregion
        } else if (mission.equals("Missions_1_6")) {
            //region code
            isBoss = true;
            boss = new Boss(1888, 192, -90, 1);
            timeStart = new Time(3.5f, "noSec");
            timeStart2 = new Time(6.5f, "noSec");
            wormCaves.add(0, new WormCave(352, 288, 1.0f, 90));
            //endregion
        }
        //endregion
        //region 2
        else if (mission.equals("Missions_2_1")) {
            //region code
            wavesMonster = 6;
            totalWaveMonster = 75;
            timeStart = new Time(3.5f, "noSec");
            timeStart2 = new Time(0, "sec");
            wormCaves.add(0, new WormCave(170, 160, 0.8f, 180));
            //endregion
        } else if (mission.equals("Missions_2_2")) {
            //region code
            wavesMonster = 10;
            totalWaveMonster = 30;
            timeStart = new Time(2.5f, "noSec");
            timeStart2 = new Time(0, "sec");
            wormCaves.add(0, new WormCave(224, 1072, 0.8f, 0));
            //endregion
        } else if (mission.equals("Missions_2_3")) {
            //region code
            timeFinish = new Time(1, "sec");
            timeFinishMinute = 10;
            timeFinishSecond = 0;
            timeStart = new Time(5.5f, "noSec");
            timeStart2 = new Time(3, "sec");
            wormCaves.add(0, new WormCave(160, 1024, 1.0f, 90));
            //endregion
        } else if (mission.equals("Missions_2_4")) {
            //region code
            timeFinish = new Time(1, "sec");
            timeFinishMinute = 11;
            timeFinishSecond = 30;
            timeStart = new Time(4.5f, "noSec");
            timeStart2 = new Time(2.5f, "noSec");
            wormCaves.add(0, new WormCave(1696, 1088, 1.0f, 0));
            //endregion
        } else if (mission.equals("Missions_2_5")) {
            //region code
            wavesMonster = 12;
            totalWaveMonster = 45;
            timeStart = new Time(5.5f, "noSec");
            timeStart2 = new Time(4, "sec");
            wormCaves.add(0, new WormCave(832, 1088, 1.0f, 90));
            //endregion
        } else if (mission.equals("Missions_2_6")) {
            //region code
            isBoss = true;
            boss = new Boss(1760, 1152, 90, 2);
            timeStart = new Time(3.5f, "noSec");
            timeStart2 = new Time(6.5f, "noSec");
            wormCaves.add(0, new WormCave(736, 1088, 1.0f, -90));
            //endregion
        }
        //endregion
        //region 3
        else if (mission.equals("Missions_3_1")) {
            //region code
            wavesMonster = 11;
            totalWaveMonster = 55;
            timeStart = new Time(5.5f, "noSec");
            timeStart2 = new Time(4.5f, "noSec");
            wormCaves.add(0, new WormCave(224, 192, 1.0f, 180));
            //endregion
        } else if (mission.equals("Missions_3_2")) {
            //region code
            timeFinish = new Time(1, "sec");
            timeFinishMinute = 15;
            timeFinishSecond = 0;
            timeStart = new Time(4.5f, "noSec");
            timeStart2 = new Time(2.5f, "noSec");
            wormCaves.add(0, new WormCave(192, 1088, 1.0f, 90));
            wormCaves.add(1, new WormCave(1728, 1088, 1.0f, -90));
            //endregion
        } else if (mission.equals("Missions_3_3")) {
            //region code
            timeStart = new Time(1.5f, "noSec");
            timeStart2 = new Time(4.5f, "noSec");
            wormCaves.add(0, new WormCave(224, 1088, 1.0f, 0));
            wormCaves.add(1, new WormCave(224, 192, 1.0f, 180));
            //endregion
        } else if (mission.equals("Missions_3_4")) {
            //region code
            wavesMonster = 10;
            totalWaveMonster = 250;
            timeStart = new Time(4.5f, "noSec");
            timeStart2 = new Time(1.5f, "noSec");
            wormCaves.add(0, new WormCave(224, 1100, 1.0f, 90));
            wormCaves.add(1, new WormCave(224, 180, 1.0f, 90));
            wormCaves.add(2, new WormCave(1740, 1088, 1.0f, 0));
            wormCaves.add(3, new WormCave(1728, 180, 1.0f, -90));
            //endregion
        } else if (mission.equals("Missions_3_5")) {
            //region code
            timeFinish = new Time(1, "sec");
            timeFinishMinute = 8;
            timeFinishSecond = 45;
            timeStart = new Time(4.5f, "noSec");
            timeStart2 = new Time(2.5f, "noSec");
            wormCaves.add(0, new WormCave(1740, 1088, 1.0f, 0));
            wormCaves.add(1, new WormCave(1728, 180, 1.0f, 180));
            //endregion
        } else if (mission.equals("Missions_3_6")) {
            //region code
            isBoss = true;
            boss = new Boss(288, 96, 0, 3);
            timeStart = new Time(4.5f, "noSec");
            timeStart2 = new Time(2.5f, "noSec");
            wormCaves.add(0, new WormCave(1728, 180, 1.0f, 180));
            //endregion
        }
        //endregion
        //region 4
        else if (mission.equals("Missions_4_1")) {
            //region code
            wavesMonster = 15;
            totalWaveMonster = 35;
            timeStart = new Time(1.5f, "noSec");
            timeStart2 = new Time(3.5f, "noSec");
            wormCaves.add(0, new WormCave(1730, 192, 1.0f, -90));
            //endregion
        } else if (mission.equals("Missions_4_2")) {
            //region code
            isMiniAdd = true;
            wavesMonster = 10;
            totalWaveMonster = 80;
            timeStart = new Time(14.5f, "noSec");
            timeStart2 = new Time(4.5f, "noSec");
            timeStart3 = new Time(0.5f, "noSec");
            wormCaves.add(0, new WormCave(192, 1118, 1.0f, 0));
            wormCaves.add(1, new WormCave(1730, 680, 1.0f, 180));
            wormCaves.add(2, new WormCave(1728, 192, 1.0f, -90));
            //endregion
        } else if (mission.equals("Missions_4_3")) {
            //region code
            wavesMonster = 8;
            totalWaveMonster = 180;
            timeStart = new Time(8.5f, "noSec");
            timeStart2 = new Time(2.5f, "noSec");
            wormCaves.add(0, new WormCave(864, 1024, 1.0f, -90));
            //endregion
        } else if (mission.equals("Missions_4_4")) {
            //region code
            isMiniAdd = true;
            wavesMonster = 14;
            totalWaveMonster = 75;
            timeStart = new Time(8.5f, "noSec");
            timeStart2 = new Time(4.5f, "noSec");
            timeStart3 = new Time(1.5f, "noSec");
            wormCaves.add(0, new WormCave(170, 192, 1.0f, 90));
            //endregion
        } else if (mission.equals("Missions_4_5")) {
            //region code
            isMiniAdd = true;
            wavesMonster = 5;
            totalWaveMonster = 125;
            timeStart = new Time(3.0f, "sec");
            timeStart2 = new Time(6.0f, "sec");
            timeStart3 = new Time(3.0f, "sec");
            wormCaves.add(0, new WormCave(224, 704, 1.0f, 145));
            //endregion
        } else if (mission.equals("Missions_4_6")) {
            //region code
            isBoss = true;
            isMiniAdd = true;
            boss = new Boss(352, 1184, 0, 4);
            timeStart = new Time(16.5f, "noSec");
            timeStart2 = new Time(8.5f, "noSec");
            timeStart3 = new Time(0.5f, "noSec");
            wormCaves.add(0, new WormCave(1760, 1130, 0.8f, 0));
            //endregion
        }
        //endregion

        if (isBoss) {
            showTextEnd.setText(new StringBuilder().append("BOSS"));
            showTextEnd.setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - showTextEnd.getPrefWidth() / 2, 224 * MarsGame.getRatioMonitorH());
        }
    }

    //region Collides
    private void collidesMonsterBase(float deltaTime, int monster, Circle aim, float shotPower, int isFire, float damageBonus) {
        if (monster_List.get(monster).getLife() > 0 && isFire > 0) {
            if (monster_List.get(monster).collidesAim(aim))
                if (random.nextInt(100 - MarsGame.getPreference().getTacticsAttackPowerShot()) == 0) monster_List.get(monster).setLifeShoot((shotPower + shotPower * damageBonus) * 2 * deltaTime, deltaTime);
                else monster_List.get(monster).setLifeShoot((shotPower + shotPower * damageBonus) * deltaTime, deltaTime);
        }
    }

    private void collidesMonsterTower(float deltaTime, int monster, Circle towerShoot, Towers towerses, float damageBonus) {
        if (monster_List.get(monster).getLife() > 0 && towerses.isBuy()) {
            if (monster_List.get(monster).collidesTower(towerShoot)) {
                towerses.setAngel(monster_List.get(monster).getPosition());
                if (towerses.getMp() > towerses.getEnergy()) {
                    towerses.setActiveShoot(true);
                    collidesTowerAim(deltaTime, monster, towerses.getAimShootTower(), towerses, damageBonus);
                }
                else towerses.setActiveShoot(false);
            }
        } else towerses.setActiveShoot(false);
    }

    private void collidesTowerAim(float deltaTime, int monster, Circle towerAim, Towers towerses, float damageBonus) {
        if (monster_List.get(monster).collidesTowerAim(towerAim))
            if (towerses.isDamage()) {
                if (random.nextInt(100 - MarsGame.getPreference().getTacticsAttackPowerShot()) == 0) monster_List.get(monster).setLifeShoot((towerses.getShotPower() + towerses.getShotPower() * damageBonus) * 2 * deltaTime, deltaTime);
                else monster_List.get(monster).setLifeShoot((towerses.getShotPower() + towerses.getShotPower() * damageBonus) * deltaTime, deltaTime);
            }
    }

    private void collidesMonsterMagic(float deltaTime, int monster, Magic magic) {
        if (monster_List.get(monster).getLife() > 0) {
            if (monster_List.get(monster).collidesMagic(magic.getZoneFire()) && magic.isActiveMagicFire()) monster_List.get(monster).setLifeMagic(magic.getMagicPowerFire() * deltaTime, "Fire");
            if (monster_List.get(monster).collidesMagic(magic.getZoneIce()) && magic.isActiveMagicIce()) monster_List.get(monster).setLifeMagic(magic.getMagicPowerIce() * deltaTime, "Ice");
            if (monster_List.get(monster).collidesMagic(magic.getZonePoison()) && magic.isActiveMagicPoison()) monster_List.get(monster).setLifeMagic(magic.getMagicPowerPoison() * deltaTime, "Poison");
        }
    }

    private void collidesBossBase(float deltaTime, Circle aim, float shotPower, int isFire, float damageBonus) {
        if (boss.getLife() > 0 && isFire > 0) {
            if (boss.collidesAim(aim))
                if (random.nextInt(100 - MarsGame.getPreference().getTacticsAttackPowerShot()) == 0) boss.setLifeShoot((shotPower + shotPower * damageBonus) * 2 * deltaTime, deltaTime);
                else boss.setLifeShoot((shotPower + shotPower * damageBonus) * deltaTime, deltaTime);
        }
    }

    private void collidesBossMagic(float deltaTime, Magic magic) {
        if (boss.getLife() > 0) {
            if (boss.collidesMagic(magic.getZoneFire()) && magic.isActiveMagicFire()) boss.setLifeMagic(magic.getMagicPowerFire() * deltaTime, "Fire", deltaTime);
            if (boss.collidesMagic(magic.getZoneIce()) && magic.isActiveMagicIce()) boss.setLifeMagic(magic.getMagicPowerIce() * deltaTime, "Ice", deltaTime);
            if (boss.collidesMagic(magic.getZonePoison()) && magic.isActiveMagicPoison()) boss.setLifeMagic(magic.getMagicPowerPoison() * deltaTime, "Poison", deltaTime);
        }
    }

    private void collidesWormCaves(float deltaTime, int monster, Circle aim, float shotPower, int isFire, float damageBonus) {
        if (wormCaves.get(monster).getLife() > 0)
            if (wormCaves.get(monster).collidesAim(aim) && isFire > 0) {
                if (random.nextInt(100 - MarsGame.getPreference().getTacticsAttackPowerShot()) == 0) wormCaves.get(monster).setLifeShoot((shotPower + shotPower * damageBonus) * 2 * deltaTime, deltaTime);
                else wormCaves.get(monster).setLifeShoot((shotPower + shotPower * damageBonus) * deltaTime, deltaTime);
            }
    }

    private void collidesWormCavesMagic(float deltaTime, int monster, Magic magic) {
        if (wormCaves.get(monster).getLife() > 0) {
            if (wormCaves.get(monster).collidesMagic(magic.getZoneFire()) && magic.isActiveMagicFire()) wormCaves.get(monster).setLifeMagic(magic.getMagicPowerFire() * deltaTime);
            if (wormCaves.get(monster).collidesMagic(magic.getZoneIce()) && magic.isActiveMagicIce()) wormCaves.get(monster).setLifeMagic(magic.getMagicPowerIce() * deltaTime);
            if (wormCaves.get(monster).collidesMagic(magic.getZonePoison()) && magic.isActiveMagicPoison()) wormCaves.get(monster).setLifeMagic(magic.getMagicPowerPoison() * deltaTime);
        }
    }
    //endregion

    private static float round(float number, int scale) { // округление числа
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        float tmp = number * pow;
        return (float) (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) / pow;
    }

    private void timeGame() {
        if (!timeFinish.isActive()) {
            if (!isFaster) timeFinish.updateTime();
            else timeFinish.updateTimeFinish();
        }
        if (timeFinish.isActive()) {
            if (timeFinishSecond > 0) {
                timeFinishSecond--;
                timeFinish.setTimeReset();
            }
            if (timeFinishSecond == 0) {
                timeFinishMinute--;
                timeFinishSecond = 59;
                timeFinish.setTimeReset();
            }
            if (timeFinishMinute < 0) isGameEnd = true;
            if (timeFinishSecond < 10) showTextEnd.setText(new StringBuilder().append(timeFinishMinute).append(":0").append(timeFinishSecond));
            else showTextEnd.setText(new StringBuilder().append(timeFinishMinute).append(":").append(timeFinishSecond));
            showTextEnd.setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - showTextEnd.getPrefWidth() / 2, 224 * MarsGame.getRatioMonitorH());
        }
    }

    private void taskGame() {
        if (mission.equals("Missions_3_3")) {
            if (MarsGame.getPreference().taskGame <= 0) {
                isGameEnd = true;
                showTextEnd.setText(new StringBuilder().append(0).append(" m"));
            } else showTextEnd.setText(new StringBuilder().append(round(MarsGame.getPreference().taskGame, 1)).append(" m"));
            showTextEnd.setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - showTextEnd.getPrefWidth() / 2, 224 * MarsGame.getRatioMonitorH());
        }
    }

    public void wavesTotalMonster() {
        if (wavesMonster > 1) {
            isStartNewWave = false;
            wavesMonster--;
            if (mission.equals("Missions_1_3")) totalWaveMonster += 25;
            else if (mission.equals("Missions_1_4")) totalWaveMonster += 20;
            else if (mission.equals("Missions_1_5")) totalWaveMonster += 45;
            else if (mission.equals("Missions_2_1")) totalWaveMonster += 50;
            else if (mission.equals("Missions_2_2")) totalWaveMonster += 50;
            else if (mission.equals("Missions_2_5")) totalWaveMonster += 55;
            else if (mission.equals("Missions_3_1")) totalWaveMonster += 60;
            else if (mission.equals("Missions_3_4")) totalWaveMonster += 80;
            else if (mission.equals("Missions_4_1")) totalWaveMonster += 105;
            else if (mission.equals("Missions_4_2")) totalWaveMonster += 200;
            else if (mission.equals("Missions_4_3")) totalWaveMonster += 110;
            else if (mission.equals("Missions_4_4")) totalWaveMonster += random.nextInt(100) + 50;
            else if (mission.equals("Missions_4_5")) totalWaveMonster += random.nextInt(350) + 75;
        }
    }

    private void wavesMonsterFinish() {
        int die = getDieMonster();
        if (wavesMonster > 1 && totalWaveMonster - die == 0) isStartNewWave = true;
        else if (wavesMonster == 1 && totalWaveMonster - die == 0) isGameEnd = true;
        showTextEnd.setText(new StringBuilder().append(wavesMonster).append(" : ").append(totalWaveMonster - die));
        showTextEnd.setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - showTextEnd.getPrefWidth() / 2, 224 * MarsGame.getRatioMonitorH());
    }

    private void addMonstersMissions() {
        //region 1
        if (mission.equals("Missions_1_1")) {
            //region code
            if (timeStart.isActive()) {
                if (wormCaves.get(0).isLiving() && wormCaves.get(1).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 1, 0, 1, random.nextInt(2)));
                    timeStart.setTimeReset();
                    add++;
                } else if (!wormCaves.get(0).isLiving() && wormCaves.get(1).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 1, 0, 1, 1));
                    timeStart.setTimeReset();
                    add++;
                } else if (wormCaves.get(0).isLiving() && !wormCaves.get(1).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 1, 0, 1, 0));
                    timeStart.setTimeReset();
                    add++;
                }
            }
            if (!wormCaves.get(0).isLiving() && !wormCaves.get(1).isLiving()) {
                if (monster_List.size() == getDieMonster()) isGameEnd = true;
            }
            timeGame();
            //endregion
        } else if (mission.equals("Missions_1_2")) {
            //region code
            if (timeStart.isActive()) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 1, random.nextInt(4), 1, 0));
                    timeStart.setTimeReset();
                    add++;
                }
                if (wormCaves.get(2).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 1, random.nextInt(4), 1, 2));
                    timeStart2.setTimeReset();
                    add++;
                }
            }
            if (timeStart2.isActive()) {
                if (wormCaves.get(1).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 1, random.nextInt(4), 1, 1));
                    timeStart.setTimeReset();
                    add++;
                }
                if (wormCaves.get(3).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 1, random.nextInt(4), 1, 3));
                    timeStart2.setTimeReset();
                    add++;
                }
            }
            if (!wormCaves.get(0).isLiving() && !wormCaves.get(1).isLiving() && !wormCaves.get(2).isLiving() && !wormCaves.get(3).isLiving()) {
                if (monster_List.size() == getDieMonster()) isGameEnd = true;
            }
            timeGame();
            //endregion
        } else if (mission.equals("Missions_1_3")) {
            //region code
            if (timeStart.isActive() && add < totalWaveMonster) {
                if (add == 115) wormCaves.add(0, new WormCave(352, 1080 - 64, 0.2f, 0));
                monster_List.add(add, new AllMonsters(mission, 1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(4)+1));
                timeStart.setTimeReset();
                add++;
            }
            if (timeStart2.isActive() && add < totalWaveMonster) {
                if (add > 116) {
                    if (wormCaves.get(0).isLiving() && wormCaves.get(0).getScaleSize() >= 1.0f) {
                        monster_List.add(add, new AllMonsters(mission, 1, random.nextInt(4), 1, 0));
                        timeStart2.setTimeReset();
                        add++;
                    }
                }
            }
            if (add > 116 && add < 160) {
                if (wormCaves.get(0).isLiving() && wormCaves.get(0).getScaleSize() < 1.0f) {
                    wormCaves.get(0).setScaleSize(0.025f);
                    wormCaves.get(0).getMonster().setScale(wormCaves.get(0).getScaleSize());
                }
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_1_4")) {
            //region code
            if (timeStart2.isActive() && add < totalWaveMonster) {
                if (wormCaves.get(0).isLiving() && wormCaves.get(1).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 1, random.nextInt(4), 2, random.nextInt(2)));
                    timeStart2.setTimeReset();
                    add++;
                } else if (!wormCaves.get(0).isLiving() && wormCaves.get(1).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 1, random.nextInt(4), random.nextInt(2)+1, 1));
                    timeStart2.setTimeReset();
                    add++;
                } else if (wormCaves.get(0).isLiving() && !wormCaves.get(1).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 1, random.nextInt(4), random.nextInt(2)+1, 0));
                    timeStart2.setTimeReset();
                    add++;
                }
            }
            if (timeStart.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, 1, random.nextInt(4), 1, random.nextInt(4)+2));
                timeStart.setTimeReset();
                add++;
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_1_5")) {
            //region code
            if (timeStart.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(2)+1));
                timeStart.setTimeReset();
                add++;
                if (wormCaves.get(0).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    timeStart.setTimeReset();
                    add++;
                }
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_1_6")) {
            //region code
            if (timeStart2.isActive()) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 3));
                    timeStart2.setTimeReset();
                    add++;
                }
            }
            if (timeStart.isActive()) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(3)));
                timeStart.setTimeReset();
                add++;
            }
            if (!boss.isLiving()) isGameEnd = true;
            //endregion
        }
        //endregion
        //region 2
        else if (mission.equals("Missions_2_1")) {
            //region code
            if (timeStart.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(2)+1));
                timeStart.setTimeReset();
                add++;
                if (wormCaves.get(0).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    timeStart.setTimeReset();
                    add++;
                }
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_2_2")) {
            //region code
            if (timeStart.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 1));
                timeStart.setTimeReset();
                add++;
                if (wormCaves.get(0).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    timeStart.setTimeReset();
                    add++;
                }
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_2_3")) {
            //region code
            if (timeStart2.isActive()) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    timeStart2.setTimeReset();
                    add++;
                }
            }
            if (timeStart.isActive()) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(4)+1));
                add++;
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(4)+1));
                timeStart.setTimeReset();
                add++;
            }
            timeGame();
            //endregion
        } else if (mission.equals("Missions_2_4")) {
            //region code
            if (timeStart.isActive()) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    timeStart.setTimeReset();
                    add++;
                }
            }
            if (timeStart2.isActive()) {
                if (random.nextInt(3) == 0) {
                    monster_List.add(add, new AllMonsters(mission, 3, random.nextInt(4), 1, -1));
                    add++;
                }
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(3)+1));
                timeStart2.setTimeReset();
                add++;
            }
            timeGame();
            //endregion
        } else if (mission.equals("Missions_2_5")) {
            //region code
            if (timeStart2.isActive() && add < totalWaveMonster) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    timeStart2.setTimeReset();
                    add++;
                }
            }
            if (timeStart.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(4)+1));
                add++;
                if (random.nextInt(3) == 0 && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, 3, random.nextInt(4), random.nextInt(2)+1, -1));
                    add++;
                }
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(4)+1));
                    add++;
                }
                timeStart.setTimeReset();
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_2_6")) {
            //region code
            if (timeStart2.isActive()) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    timeStart2.setTimeReset();
                    add++;
                }
            }
            if (timeStart.isActive()) {
                if (random.nextInt(3) == 0) {
                    monster_List.add(add, new AllMonsters(mission, 3, random.nextInt(4), random.nextInt(2)+1, -1));
                    add++;
                }
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(4)+1));
                add++;
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(4)+1));
                timeStart.setTimeReset();
                add++;
            }
            if (!boss.isLiving()) isGameEnd = true;
            //endregion
        }
        //endregion
        //region 3
        else if (mission.equals("Missions_3_1")) {
            //region code
            if (timeStart.isActive() && add < 1) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 2));
                add++;
                if (wormCaves.get(0).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, 2, random.nextInt(4), random.nextInt(2)+1, 0));
                    add++;
                }
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, 3, random.nextInt(4), random.nextInt(2)+1, -1));
                    add++;
                }
                timeStart.setTimeReset();
            }
            if (timeStart2.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 1));
                add++;
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 3));
                    add++;
                }
                timeStart2.setTimeReset();
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_3_2")) {
            //region code
            if (timeStart.isActive()) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    timeStart.setTimeReset();
                    add++;
                }
                if (wormCaves.get(1).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 1));
                    timeStart.setTimeReset();
                    add++;
                }
                if (random.nextInt(3) == 0) {
                    monster_List.add(add, new AllMonsters(mission, 3, random.nextInt(4), 1, -1));
                    timeStart.setTimeReset();
                    add++;
                }
            }
            if (timeStart2.isActive() && timeFinishMinute < 10) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 2));
                add++;
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 3));
                add++;
                timeStart2.setTimeReset();
            }
            timeGame();
            //endregion
        } else if (mission.equals("Missions_3_3")) {
            //region code
            if (timeStart2.isActive()) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    timeStart2.setTimeReset();
                    add++;
                }
                if (wormCaves.get(1).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 1));
                    timeStart2.setTimeReset();
                    add++;
                }
                if (random.nextInt(3) == 0) {
                    monster_List.add(add, new AllMonsters(mission, 3, random.nextInt(4), random.nextInt(2)+1, -1));
                    timeStart2.setTimeReset();
                    add++;
                }
            }
            if (timeStart.isActive()) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(2)+2));
                timeStart.setTimeReset();
                add++;
            }
            taskGame();
            //endregion
        } else if (mission.equals("Missions_3_4")) {
            //region code
            if (timeStart.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(3)+4));
                add++;

                if (wormCaves.get(0).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    add++;
                }
                if (wormCaves.get(1).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 1));
                    add++;
                }
                if (wormCaves.get(2).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 2));
                    add++;
                }
                if (wormCaves.get(3).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 3));
                    add++;
                }
                timeStart.setTimeReset();
            }
            if (wormCaves.get(0).isLiving() || wormCaves.get(1).isLiving() || wormCaves.get(2).isLiving() || wormCaves.get(3).isLiving()) {
                if (timeStart2.isActive() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(3)+4));
                    add++;
                    timeStart2.setTimeReset();
                }
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_3_5")) {
            //region code
            if (timeStart.isActive()) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(3)+2));
                add++;
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    add++;
                }
                if (wormCaves.get(1).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 1));
                    add++;
                }
                timeStart.setTimeReset();
            }
            if (timeStart2.isActive() && timeFinishMinute < 3) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(3)+2));
                add++;
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(3)+2));
                add++;
                timeStart2.setTimeReset();
            }
            timeGame();
            //endregion
        } else if (mission.equals("Missions_3_6")) {
            //region code
            if (timeStart.isActive()) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 0));
                    add++;
                }
                if (random.nextInt(8) == 0) {
                    monster_List.add(add, new AllMonsters(mission, 4, random.nextInt(4), random.nextInt(2)+1, 4));
                    add++;
                }
                timeStart.setTimeReset();
            }
            if (timeStart2.isActive()) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(3)+1));
                timeStart2.setTimeReset();
                add++;
            }
            if (!boss.isLiving()) isGameEnd = true;
            //endregion
        }
        //endregion
        //region 4
        else if (mission.equals("Missions_4_1")) {
            //region code
            if (timeStart.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(3)+1));
                add++;
                if (wormCaves.get(0).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), 1, 0));
                    add++;
                }
                if (add < totalWaveMonster && random.nextInt(10) == 0) {
                    monster_List.add(add, new AllMonsters(mission, 4, random.nextInt(4), random.nextInt(2)+1, random.nextInt(3)+4));
                    add++;
                }
                timeStart.setTimeReset();
            }
            if (timeStart2.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 1));
                add++;
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 2));
                    add++;
                }
                timeStart2.setTimeReset();
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_4_2")) {
            //region code
            if (timeStart.isActive() && add < totalWaveMonster) {
                if (wormCaves.get(0).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, 4, random.nextInt(4), random.nextInt(2)+1, 0));
                    add++;
                }
                if (wormCaves.get(1).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, 4, random.nextInt(4), random.nextInt(2)+1, 1));
                    add++;
                }
                if (wormCaves.get(2).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, 4, random.nextInt(4), random.nextInt(2)+1, 2));
                    add++;
                }
                timeStart.setTimeReset();
            }
            if (timeStart2.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(5)+3));
                add++;

                if (random.nextInt(10) == 0) miniAdd = 0;
                timeStart2.setTimeReset();
            }
            if (miniAdd >= 0) {
                if (timeStart3.isActive()) {
                    if (add < totalWaveMonster) {
                        monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 1, random.nextInt(2)+8));
                        add++;
                        miniAdd++;
                    } else miniAdd = -1;
                    timeStart3.setTimeReset();
                }
                if (miniAdd >= 20) miniAdd = -1;
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_4_3")) {
            //region code
            if (timeStart.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 2, random.nextInt(4)+1));
                add++;
                if (wormCaves.get(0).isLiving() && add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, 4, random.nextInt(4), random.nextInt(2)+1, 0));
                    add++;
                }
                timeStart.setTimeReset();
            }
            if (timeStart2.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 1));
                add++;
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 2));
                    add++;
                }
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 3));
                    add++;
                }
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 4));
                    add++;
                }
                timeStart2.setTimeReset();
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_4_4")) {
            //region code
            if (timeStart.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, 4, random.nextInt(4), random.nextInt(2)+1, random.nextInt(2)+5));
                add++;
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 2, random.nextInt(4)+1));
                    add++;
                }
                timeStart.setTimeReset();
            }
            if (timeStart2.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 1));
                add++;
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 2));
                    add++;
                }
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 3));
                    add++;
                }
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, 4));
                    add++;
                }
                timeStart2.setTimeReset();
            }
            if (timeStart3.isActive() && add < totalWaveMonster) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 1, 0));
                    add++;
                }
                timeStart3.setTimeReset();
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_4_5")) {
            //region code
            if (timeStart.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), random.nextInt(2)+1, random.nextInt(5)+1));
                add++;
                timeStart.setTimeReset();
            }
            if (timeStart2.isActive() && add < totalWaveMonster) {
                monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 1, 6));
                add++;
                if (add < totalWaveMonster) {
                    monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), random.nextInt(2)+1, random.nextInt(5)+1));
                    add++;
                }
                timeStart2.setTimeReset();
            }
            if (timeStart3.isActive() && add < totalWaveMonster) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 1, 0));
                    add++;
                }
                timeStart3.setTimeReset();
            }
            wavesMonsterFinish();
            //endregion
        } else if (mission.equals("Missions_4_6")) {
            //region code
            if (timeStart.isActive()) {
                monster_List.add(add, new AllMonsters(mission, 4, random.nextInt(4), random.nextInt(2)+1, random.nextInt(2)+6));
                timeStart.setTimeReset();
            }
            if (timeStart2.isActive()) {
                if (wormCaves.get(0).isLiving()) {
                    monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 2, 0));
                    add++;
                }
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(5)+1));
                add++;
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(5)+1));
                add++;
                monster_List.add(add, new AllMonsters(mission, random.nextInt(2)+1, random.nextInt(4), random.nextInt(2)+1, random.nextInt(5)+1));
                add++;
                timeStart2.setTimeReset();
            }
            if (timeStart3.isActive() && boss.getTotalWaveMonster() > 0) {
                monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 1, 7));
                add++;
                boss.setTotalWaveMonster(1);
                if (boss.getTotalWaveMonster() > 0) {
                    monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 1, 8));
                    add++;
                    boss.setTotalWaveMonster(1);
                }
                if (boss.getTotalWaveMonster() > 0) {
                    monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 1, 9));
                    add++;
                    boss.setTotalWaveMonster(1);
                }
                if (boss.getTotalWaveMonster() > 0) {
                    monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 1, 10));
                    add++;
                    boss.setTotalWaveMonster(1);
                }
                if (boss.getTotalWaveMonster() > 0) {
                    monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 1, 11));
                    add++;
                    boss.setTotalWaveMonster(1);
                }
                if (boss.getTotalWaveMonster() > 0) {
                    monster_List.add(add, new AllMonsters(mission, 5, random.nextInt(4), 1, 12));
                    add++;
                    boss.setTotalWaveMonster(1);
                }
                timeStart3.setTimeReset();
            }
            if (!boss.isLiving()) isGameEnd = true;
            //endregion
        }
        //endregion
    }

    public void update(float deltaTime, Circle aim, float shotPower, int isFire, ArrayList<Towers> tower, float damageBonus, Magic magic) {
        if (!timeStart.isActive()) timeStart.updateTime();
        if (!timeStart2.isActive()) timeStart2.updateTime();
        if (isMiniAdd) {
            if (!timeStart3.isActive()) timeStart3.updateTime();
        }
        if (workers.size() != workersNumber) {
            timeStartRobot.updateTime();
            if (timeStartRobot.isActive()) {
                workers.add(new Worker(mission));
                timeStartRobot.setTimeReset();
            }
        }
        addMonstersMissions();
        for (int i = 0; i < monster_List.size(); i++) {
            if (monster_List.get(i).isLiving()) {
                monster_List.get(i).update(deltaTime);
                collidesMonsterBase(deltaTime, i, aim, shotPower, isFire, damageBonus);
                collidesMonsterMagic(deltaTime, i, magic);
                for (int j = 0; j < tower.size(); j++) {
                    if (tower.get(j).isBuy())
                        collidesMonsterTower(deltaTime, i, tower.get(j).getZoneTower(), tower.get(j), damageBonus);
                }
            }
        }
        for (int i = 0; i < wormCaves.size(); i++) {
            if (wormCaves.get(i).isLiving()) {
                wormCaves.get(i).update();
                collidesWormCaves(deltaTime, i, aim, shotPower, isFire, damageBonus);
                collidesWormCavesMagic(deltaTime, i, magic);
            }
        }
        for (int i = 0; i < workers.size(); i++) {
            workers.get(i).update(deltaTime);

            if (workers.get(i).isStartWorking()) {
                for (int j = 0; j < monster_List.size(); j++) {
                    if (monster_List.get(j).isFinishFly()) {
                        monster_List.get(j).isAttackMonster();
                        workers.get(i).setLife(0);
                    }
                }
            }
        }

        if (isBoss) {
            boss.update(deltaTime, speedMoveBoss);
            collidesBossBase(deltaTime, aim, shotPower, isFire, damageBonus);
            collidesBossMagic(deltaTime, magic);
        }
    }

    public void renderDie(SpriteBatch batch) {
        for (int i = 0; i < wormCaves.size(); i++) if (!wormCaves.get(i).isLiving()) wormCaves.get(i).renderDie(batch);
        for (int i = 0; i < monster_List.size(); i++) if (!monster_List.get(i).isLiving()) monster_List.get(i).renderDie(batch);
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < workers.size(); i++) workers.get(i).render();
        for (int i = 0; i < monster_List.size(); i++) if (monster_List.get(i).isLiving()) monster_List.get(i).render(batch);
        for (int i = 0; i < wormCaves.size(); i++) if (wormCaves.get(i).isLiving()) wormCaves.get(i).render(batch);
        if (isBoss) boss.render(batch);
    }

    public int getDamage() {
        int damage = 0;
        for (int i = 0; i < monster_List.size(); i++)
            if (monster_List.get(i).isShoot()) {
                if (!isFaster) damage += monster_List.get(i).getPower();
                else damage += monster_List.get(i).getPower() * 2;
            }
        if (isBoss)
            if (boss.isShoot()) {
                if (!isFaster) damage += boss.getPower();
                else damage += boss.getPower() * 2;
            }
        return damage;
    }

    public int getMonsterPrice() {
        int price = 0;
        for (int i = 0; i < monster_List.size(); i++) if (!monster_List.get(i).isLiving()) price += monster_List.get(i).getPrice();
        for (int i = 0; i < wormCaves.size(); i++) if (!wormCaves.get(i).isLiving()) price += wormCaves.get(i).getPrice();
        if (isBoss) if (!boss.isLiving()) price += boss.getPrice();
        return price;
    }

    public int getDieMonster() {
        int die = 0;
        for (int i = 0; i < monster_List.size(); i++) if (!monster_List.get(i).isLiving()) die++;
        return die;
    }

    public boolean getDieWormCave() {
        boolean die = false;
        for (int i = 0; i < wormCaves.size(); i++) if (wormCaves.get(i).isCompleteDieWormCave()) die = true;
        return die;
    }

    public ArrayList<AllMonsters> getMonster_List() {
        return monster_List;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public Boss getBoss() {
        return boss;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }

    public Label getShowTextEnd() {
        return showTextEnd;
    }

    public boolean isStartNewWave() {
        return isStartNewWave;
    }

    public void setSpeedMoveBoss(int speedMoveBoss) {
        this.speedMoveBoss = speedMoveBoss;
    }

    public int getSpeedMoveBoss() {
        return speedMoveBoss;
    }

    public boolean isAbsorption() {
        if (isBoss) return boss.isAbsorption();
        else return false;
    }

    public void setFaster(boolean faster) {
        isFaster = faster;
    }

    public void dispose() {
        try {
            monster_List.clear();
            wormCaves.clear();
            workers.clear();
            showTextEnd.clear();
            timeStart = null;
            timeStart2 = null;
            if (isMiniAdd) timeStart3 = null;
            timeFinish = null;
            timeStartRobot = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}