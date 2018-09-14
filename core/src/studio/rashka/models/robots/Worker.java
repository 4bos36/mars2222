package studio.rashka.models.robots;

import com.badlogic.gdx.math.Vector2;
import com.brashmonkey.spriter.Player;
import com.brashmonkey.spriter.gdx.Drawer;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.Time;

public class Worker {

    private float life = 1; // жизни
    private int crystal, crystalNUN; // сколько кристалов
    private boolean isStartWorking = false;
    private int speed, speedMove = 1, died = 0;
    private String mission;

    private PathRobot path;
    private Vector2 position;

    private Player monster;
    private Drawer drawer;
    private Time time;

    public Worker(String mission) {
        this.mission = mission;
        speed = MarsGame.getPreference().getTacticsTechnologiesRobotSpeed();
        crystal = MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity();

        position = new Vector2(MarsGame.WIDTH / 2 - 32, 540 + 72);
        time = new Time(4, "sec");

        path = new PathRobot(mission, position.x, position.y, 1, -90, crystal);

        drawer = new Drawer(Textures.getInstance().loader.get("Worker"), MarsGame.getBatch(), null);
        monster = new Player(Textures.getInstance().data.get("Worker").getEntity(0));

        monster.setPosition(-MarsGame.WIDTH * 2, 0);
        monster.setScale(0.5f);
        monster.setAnimation("run");
        monster.speed = 10;
    }

    private int getCrystal() {
        return MarsGame.getPreference().getCrystal(mission);
    }

    private void crystals() {
        MarsGame.getPreference().setCrystal(mission, crystal);
        if (MarsGame.getPreference().getCrystal(mission) < 0) {
            crystalNUN = MarsGame.getPreference().getCrystal(mission);
            MarsGame.getPreference().setCrystal(mission, crystalNUN);
        }
    }

    public void update(float deltaTime) {
        if (mission.equals("Missions_3_3")) {
            if (isStartWorking) {
                if (speedMove == 1) MarsGame.getPreference().taskGame -= deltaTime * 40;
                else MarsGame.getPreference().taskGame -= deltaTime * 80;
            }
        }

        if (path.isWork()) {
            //region code
            if (path.getEffect().equals("RunWork")) {
                path.startWork();
                path.setEffect("NONE");
            } else if (path.getEffect().equals("RunHome")) {
                path.startHome();
                path.setEffect("NONE");
            } else if (path.getEffect().equals("Open")) {
                if (mission.equals("Missions_3_3")) {
                    if (!isStartWorking) {
                        monster.setAnimation("open");
                        isStartWorking = true;
                    }
                    if (monster.getTime() == 300) {
                        path.setEffect("Drilling");
                        monster.setAnimation("drilling");
                    }
                } else {
                    if (getCrystal() > 0) {
                        if (!isStartWorking) {
                            monster.setAnimation("open");
                            isStartWorking = true;
                        }
                        if (monster.getTime() == 300) {
                            if (getCrystal() > 0) {
                                path.setEffect("Drilling");
                                monster.setAnimation("drilling");
                            } else {
                                path.setEffect("Close");
                                path.setCrystal(0);
                            }
                        }
                    } else {
                        path.setEffect("Close");
                        path.setCrystal(0);
                    }
                }
            } else if (path.getEffect().equals("Drilling")) {
                time.updateTime();
                if (time.isActive()) {
                    if (getCrystal() > 0) {
                        crystals();
                        path.setCrystal(crystal + crystalNUN);
                    } else path.setCrystal(0);
                    time.setTimeReset();
                    path.setEffect("Close");
                    monster.setAnimation("close");
                }
            } else if (path.getEffect().equals("Close")) {
                if (monster.getTime() == 300) {
                    monster.setAnimation("run");
                    path.setEffect("RunHome");
                    isStartWorking = false;
                }
            }
            //endregion

            position.set(path.getPosition(deltaTime, speed, speedMove).x, path.getPosition(deltaTime, speed, speedMove).y);
            monster.setAngle(path.getAngel());
            monster.update();
        }
        if (life == 0) {
            died++;
            if (died > 40) {
                life = -1;
                died = 0;
            }
        }
        if (life == -1) {
            monster.setAnimation("run");
            path.setPosition(MarsGame.WIDTH / 2 - 32, 540 + 72);
            isStartWorking = false;
            path.setEffect("RunWork");
            crystals();
            crystal = 0;
            path.startWork();
            life = 1;
        }
    }

    public void render() {
        if (path.isWork()) {
            monster.setPosition(position.x, position.y);
            drawer.draw(monster);
        }
    }

    public void setSpeedMove(int speedMove) {
        this.speedMove = speedMove;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public float getLife() {
        return life;
    }

    public boolean isStartWorking() {
        return isStartWorking;
    }

    public void dispose() {
        try {
            monster = null;
            drawer = null;
            path = null;
            time = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}