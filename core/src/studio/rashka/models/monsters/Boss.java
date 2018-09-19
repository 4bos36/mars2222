package studio.rashka.models.monsters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.brashmonkey.spriter.Player;
import com.brashmonkey.spriter.gdx.Drawer;

import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.Time;
import studio.rashka.lib.singleton.SpeedMonster;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Boss {

    private int lifeMAX, price, numberPath = 1, typeBoss, typeBody = 1;
    private float life; // жизни
    private int power, // сила атаки
            armor, // броня
            speed, // скорость
            totalWaveMonster, choice;

    private Player monster;
    private Drawer drawer;

    private boolean isLiving = true, isShoot = false, isRecovery = false, isAbsorption = false;
    private float scaleSize;

    private Vector2 position, angel;
    private Circle body;
    private Time time;

   // ShapeRenderer renderer = new ShapeRenderer();

    public Boss(float posX, float posY, float angel, int type) {
        this.position = new Vector2(posX, posY);
        this.typeBoss = type;

        if (typeBoss == 1) {
            //region code
            scaleSize = 0.8f;
            lifeMAX = 5000;
            life = 5000;
            power = 25;
            armor = 5;
            speed = 3;
            price = 1500;

            drawer = new Drawer(Textures.getInstance().loaderBoss.get("Boss_1"), MarsGame.getBatch(), null);
            monster = new Player(Textures.getInstance().dataBoss.get("Boss_1").getEntity(0));
            monster.setPosition(-MarsGame.WIDTH * 2, 0);
            body = new Circle(monster.getX(), monster.getY(), 20 * scaleSize);
            //endregion
        } else if (typeBoss == 2) {
            //region code
            time = new Time(15, "sec");
            scaleSize = 0.8f;
            lifeMAX = 8500;
            life = 8500;
            power = 50;
            armor = 20;
            speed = 3;
            price = 2500;

            drawer = new Drawer(Textures.getInstance().loaderBoss.get("Boss_2"), MarsGame.getBatch(), null);
            monster = new Player(Textures.getInstance().dataBoss.get("Boss_2").getEntity(0));
            monster.setPosition(-MarsGame.WIDTH * 2, 0);
            body = new Circle(monster.getX(), monster.getY(), 75 * scaleSize);
            //endregion
        } else if (typeBoss == 3) {
            //region code
            time = new Time(35, "sec");
            scaleSize = 0.8f;
            lifeMAX = 16500;
            life = 16500;
            power = 150;
            armor = 30;
            speed = 3;
            price = 3150;

            drawer = new Drawer(Textures.getInstance().loaderBoss.get("Boss_3"), MarsGame.getBatch(), null);
            monster = new Player(Textures.getInstance().dataBoss.get("Boss_3").getEntity(0));
            monster.setPosition(-MarsGame.WIDTH * 2, 0);
            body = new Circle(monster.getX(), monster.getY(), 25 * scaleSize);
            //endregion
        } else if (typeBoss == 4) {
            //region code
            time = new Time(45, "sec");
            scaleSize = 0.6f;
            lifeMAX = 10000;
            life = 10000;
            power = 5;
            armor = 10;
            speed = 3;
            price = 2850;

            choice = new Random().nextInt(2);

            drawer = new Drawer(Textures.getInstance().loaderBoss.get("Boss_4"), MarsGame.getBatch(), null);
            monster = new Player(Textures.getInstance().dataBoss.get("Boss_4").getEntity(0));
            monster.setPosition(-MarsGame.WIDTH * 2, 0);
            body = new Circle(monster.getX(), monster.getY(), 25 * scaleSize);
            //endregion
        }

        this.angel = new Vector2(angel, 0);
        monster.setAngle(angel);
        monster.setScale(scaleSize);
        monster.setAnimation("run");
    }

    private void getPosition(float deltaTime) {
        if (typeBoss == 1) {
            //region code
            if (numberPath == 1) {
                position.add(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y > 640) numberPath = 2;
            } else if (numberPath == 2) {
                angel.add(deltaTime * 35 * SpeedMonster.INSTANCE.getSpeed(), 0);
                monster.setAngle(angel.x);
                if (angel.x > 0) {
                    angel.x = 0;
                    monster.setAngle(angel.x);
                    numberPath = 3;
                }
            } else if (numberPath == 3) {
                position.sub(deltaTime * speed * SpeedMonster.INSTANCE.getSpeed(), 0);
                if (position.x < 1372) numberPath = 0;
            }
            //endregion
        } else if (typeBoss == 2) {
            //region code
            if (numberPath == 1) {
                position.sub(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y < 352) numberPath = 2;
            } else if (numberPath == 2) {
                angel.sub(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                monster.setAngle(angel.x);
                if (angel.x < 0) {
                    angel.x = 0;
                    monster.setAngle(angel.x);
                    numberPath = 3;
                }
            } else if (numberPath == 3) {
                position.sub(deltaTime * speed * SpeedMonster.INSTANCE.getSpeed(), 0);
                if (position.x < 1568) numberPath = 4;
            } else if (numberPath == 4) {
                angel.add(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                monster.setAngle(angel.x);
                if (angel.x > 90) {
                    angel.x = 90;
                    monster.setAngle(angel.x);
                    numberPath = 5;
                }
            } else if (numberPath == 5) {
                position.sub(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y < 160) numberPath = 6;
            } else if (numberPath == 6) {
                angel.sub(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                monster.setAngle(angel.x);
                if (angel.x < 0) {
                    angel.x = 0;
                    monster.setAngle(angel.x);
                    numberPath = 7;
                }
            } else if (numberPath == 7) {
                position.sub(deltaTime * speed * SpeedMonster.INSTANCE.getSpeed(), 0);
                if (position.x < 160) numberPath = 8;
            } else if (numberPath == 8) {
                angel.sub(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                monster.setAngle(angel.x);
                if (angel.x < -90) {
                    angel.x = -90;
                    monster.setAngle(angel.x);
                    numberPath = 9;
                }
            } else if (numberPath == 9) {
                position.add(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y > 608) numberPath = 10;
            } else if (numberPath == 10) {
                angel.sub(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                monster.setAngle(angel.x);
                if (angel.x < -180) {
                    angel.x = -180;
                    monster.setAngle(angel.x);
                    numberPath = 11;
                }
            } else if (numberPath == 11) {
                position.add(deltaTime * speed * SpeedMonster.INSTANCE.getSpeed(), 0);
                if (position.x > 512) numberPath = 0;
            }
            //endregion
        } else if (typeBoss == 3) {
            //region code
            if (numberPath == 1) {
                if (!isAbsorption) position.add(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y > 480) numberPath = 2;
            } else if (numberPath == 2) {
                scaleSize += deltaTime * 5;
                monster.setScale(scaleSize);
                if (monster.getScale() > 3) {
                    position.set(1760, 1088);
                    angel.x = 90;
                    monster.setAngle(angel.x);
                    numberPath = 3;
                }
            } else if (numberPath == 3) {
                if (!isAbsorption) {
                    scaleSize -= deltaTime * 5;
                    monster.setScale(scaleSize);
                }
                if (monster.getScale() < 0.8f) {
                    scaleSize = 0.8f;
                    numberPath = 4;
                }
            } else if (numberPath == 4) {
                if (!isAbsorption) position.sub(deltaTime * speed * SpeedMonster.INSTANCE.getSpeed(), 0);
                if (position.x < 1504) numberPath = 5;
            } else if (numberPath == 5) {
                if (!isAbsorption) {
                    angel.add(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                    monster.setAngle(angel.x);
                }
                if (angel.x > 180) {
                    angel.x = 180;
                    monster.setAngle(angel.x);
                    numberPath = 6;
                }
            } else if (numberPath == 6) {
                if (!isAbsorption) position.sub(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y < 896) numberPath = 7;
            } else if (numberPath == 7) {
                scaleSize += deltaTime * 5;
                monster.setScale(scaleSize);
                if (monster.getScale() > 3) {
                    position.set(288, 768);
                    angel.x = 0;
                    monster.setAngle(angel.x);
                    numberPath = 8;
                }
            } else if (numberPath == 8) {
                scaleSize -= deltaTime * 5;
                monster.setScale(scaleSize);
                if (monster.getScale() < 0.8f) {
                    scaleSize = 0.8f;
                    numberPath = 9;
                }
            } else if (numberPath == 9) {
                if (!isAbsorption) position.add(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y > 1088) numberPath = 10;
            } else if (numberPath == 10) {
                if (!isAbsorption) {
                    angel.sub(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                    monster.setAngle(angel.x);
                }
                if (angel.x < -90) {
                    angel.x = -90;
                    monster.setAngle(angel.x);
                    numberPath = 11;
                }
            } else if (numberPath == 11) {
                scaleSize += deltaTime * 5;
                monster.setScale(scaleSize);
                if (monster.getScale() > 3) {
                    position.set(1504, 768);
                    angel.x = 180;
                    monster.setAngle(angel.x);
                    numberPath = 12;
                }
            } else if (numberPath == 12) {
                scaleSize -= deltaTime * 5;
                monster.setScale(scaleSize);
                if (monster.getScale() < 0.8f) {
                    scaleSize = 0.8f;
                    numberPath = 13;
                }
            } else if (numberPath == 13) {
                if (!isAbsorption) position.sub(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y < 608) numberPath = 14;
            } else if (numberPath == 14) {
                if (!isAbsorption) {
                    angel.sub(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                    monster.setAngle(angel.x);
                }
                if (angel.x < 90) {
                    angel.x = 90;
                    monster.setAngle(angel.x);
                    numberPath = 15;
                }
            } else if (numberPath == 15) {
                if (!isAbsorption) position.sub(deltaTime * speed * SpeedMonster.INSTANCE.getSpeed(), 0);
                if (position.x < 1344) numberPath = 16;
            } else if (numberPath == 16) {
                scaleSize += deltaTime * 5;
                monster.setScale(scaleSize);
                if (monster.getScale() > 3) {
                    position.set(576, 1088);
                    angel.x = -90;
                    monster.setAngle(angel.x);
                    numberPath = 17;
                }
            } else if (numberPath == 17) {
                scaleSize -= deltaTime * 5;
                monster.setScale(scaleSize);
                if (monster.getScale() < 0.8f) {
                    scaleSize = 0.8f;
                    numberPath = 18;
                }
            } else if (numberPath == 18) {
                if (!isAbsorption) position.add(deltaTime * speed * SpeedMonster.INSTANCE.getSpeed(), 0);
                if (position.x > 928) numberPath = 19;
            } else if (numberPath == 19) {
                if (!isAbsorption) {
                    angel.sub(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                    monster.setAngle(angel.x);
                }
                if (angel.x < -180) {
                    angel.x = -180;
                    monster.setAngle(angel.x);
                    numberPath = 20;
                }
            } else if (numberPath == 20) {
                if (!isAbsorption) position.sub(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y > 928) numberPath = 21;
            } else if (numberPath == 21) {
                scaleSize += deltaTime * 5;
                monster.setScale(scaleSize);
                if (monster.getScale() > 3) {
                    position.set(1280, 608);
                    angel.x = 90;
                    monster.setAngle(angel.x);
                    numberPath = 22;
                }
            } else if (numberPath == 22) {
                scaleSize -= deltaTime * 5;
                monster.setScale(scaleSize);
                if (monster.getScale() < 0.8f) {
                    scaleSize = 0.8f;
                    numberPath = 0;
                }
            }
            //endregion
        } else if (typeBoss == 4) {
            //region code
            if (numberPath == 1) {
                position.sub(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y < 160) numberPath = 2;
            } else if (numberPath == 2) {
                angel.add(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                monster.setAngle(angel.x);
                if (angel.x > 90) {
                    angel.x = 90;
                    monster.setAngle(angel.x);
                    numberPath = 3;
                }
            } else if (numberPath == 3) {
                position.add(deltaTime * speed * SpeedMonster.INSTANCE.getSpeed(), 0);
                if (position.x > 1568) numberPath = 4;
            } else if (numberPath == 4) {
                angel.add(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                monster.setAngle(angel.x);
                if (angel.x > 180) {
                    angel.x = 180;
                    monster.setAngle(angel.x);
                    numberPath = 5;
                }
            } else if (numberPath == 5) {
                position.add(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y > 928) numberPath = 6;
            } else if (numberPath == 6) {
                angel.add(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                monster.setAngle(angel.x);
                if (angel.x > 225) {
                    angel.x = 225;
                    monster.setAngle(angel.x);
                    numberPath = 7;
                }
            } else if (numberPath == 7) {
                position.add(-deltaTime * speed * SpeedMonster.INSTANCE.getSpeed(), deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y > 1120) numberPath = 8;
            } else if (numberPath == 8) {
                angel.add(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                monster.setAngle(angel.x);
                if (angel.x > 270) {
                    angel.x = 270;
                    monster.setAngle(angel.x);
                    numberPath = 9;
                }
            } else if (numberPath == 9) {
                position.sub(deltaTime * speed * SpeedMonster.INSTANCE.getSpeed(), 0);
                if (position.x < 1056) numberPath = 10;
            } else if (numberPath == 10) {
                angel.add(deltaTime * 20 * SpeedMonster.INSTANCE.getSpeed(), 0);
                monster.setAngle(angel.x);
                if (angel.x > 360) {
                    angel.x = 360;
                    monster.setAngle(angel.x);
                    numberPath = 11;
                }
            } else if (numberPath == 11) {
                position.sub(0, deltaTime * speed * SpeedMonster.INSTANCE.getSpeed());
                if (position.y < 896) numberPath = 0;
            }
            //endregion
        }
    }

    public void update(float deltaTime) {
        if (life > 0) {
            if (typeBoss == 1) {
                //region code
                getPosition(deltaTime);

                if (life <= 4000 && typeBody == 1) {
                    monster.setAnimation("run_2");
                    typeBody = 2;
                } else if (life <= 3000 && typeBody == 2) {
                    monster.setAnimation("run_3");
                    typeBody = 3;
                } else if (life <= 2000 && typeBody == 3) {
                    monster.setAnimation("run_4");
                    typeBody = 4;
                } else if (life <= 1000 && typeBody == 4) {
                    monster.setAnimation("run_5");
                    body.setRadius(30 * scaleSize);
                    typeBody = 5;
                }
                if (typeBody == 1) body.setPosition(monster.getX() + 192 * (float)cos(monster.getAngle() * 0.01745f), monster.getY() + 192 * (float)sin(monster.getAngle() * 0.01745f));
                else if (typeBody == 2) body.setPosition(monster.getX() + 128 * (float)cos(monster.getAngle() * 0.01745f), monster.getY() + 128 * (float)sin(monster.getAngle() * 0.01745f));
                else if (typeBody == 3) body.setPosition(monster.getX() + 96 * (float)cos(monster.getAngle() * 0.01745f), monster.getY() + 96 * (float)sin(monster.getAngle() * 0.01745f));
                else if (typeBody == 4) body.setPosition(monster.getX() + 64 * (float)cos(monster.getAngle() * 0.01745f), monster.getY() + 64 * (float)sin(monster.getAngle() * 0.01745f));
                else if (typeBody == 5) body.setPosition(monster.getX() - 128 * (float)cos(monster.getAngle() * 0.01745f), monster.getY() - 128 * (float)sin(monster.getAngle() * 0.01745f));

                monster.update();

                if (numberPath == 0 && isLiving) {
                    if (!isShoot) {
                        if (life > 4000) {
                            monster.setAnimation("attack");
                            typeBody = 1;
                        } else if (life > 3000 && life <= 4000) {
                            monster.setAnimation("attack_2");
                            typeBody = 2;
                        } else if (life > 2000 && life <= 3000) {
                            monster.setAnimation("attack_3");
                            typeBody = 3;
                        } else if (life > 1000 && life <= 2000) {
                            monster.setAnimation("attack_4");
                            typeBody = 4;
                        } else if (life <= 1000) {
                            monster.setAnimation("attack_5");
                            typeBody = 5;
                        }
                    }
                    isShoot = true;
                }
                if (isShoot && isLiving) {
                    if (life <= 4000 && typeBody == 1) {
                        monster.setAnimation("attack_2");
                        typeBody = 2;
                    } else if (life <= 3000 && typeBody == 2) {
                        monster.setAnimation("attack_3");
                        typeBody = 3;
                    } else if (life <= 2000 && typeBody == 3) {
                        monster.setAnimation("attack_4");
                        typeBody = 4;
                    } else if (life <= 1000 && typeBody == 4) {
                        monster.setAnimation("attack_5");
                        typeBody = 5;
                    }
                }
                //endregion
            } else if (typeBoss == 2) {
                //region code
                if (numberPath >= 1) {
                    if (!time.isActive()) time.updateTime();
                    if (time.isActive()) {
                        if (life > 6500) monster.setAnimation("recovery");
                        if (life > 3000 && life <= 6500) monster.setAnimation("recovery_2");
                        if (life <= 3000) monster.setAnimation("recovery_3");
                        isRecovery = true;
                        time.setTimeReset();
                    }
                    if (isRecovery && time.getTime() >= 5) {
                        if (life > 6500) monster.setAnimation("run");
                        if (life > 3000 && life <= 6500) monster.setAnimation("run_2");
                        if (life <= 3000) monster.setAnimation("run_3");
                        isRecovery = false;
                        time.setTimeReset();
                    }
                }
                getPosition(deltaTime);

                if (life <= 6500 && typeBody == 1) {
                    monster.setAnimation("run_2");
                    typeBody = 2;
                } else if (life <= 3000 && typeBody == 2) {
                    monster.setAnimation("run_3");
                    typeBody = 3;
                }

                body.setPosition(monster.getX(), monster.getY());
                monster.update();

                if (numberPath == 0 && isLiving) {
                    if (!isShoot) {
                        if (life > 6500) {
                            monster.setAnimation("attack");
                            typeBody = 1;
                        } else if (life > 3000 && life <= 6500) {
                            monster.setAnimation("attack_2");
                            typeBody = 2;
                        } else if (life <= 3000) {
                            monster.setAnimation("attack_3");
                            typeBody = 3;
                        }
                    }
                    isShoot = true;
                }
                if (isShoot && isLiving) {
                    if (life <= 6500 && typeBody == 1) {
                        monster.setAnimation("attack_2");
                        typeBody = 2;
                    } else if (life <= 3000 && typeBody == 2) {
                        monster.setAnimation("attack_3");
                        typeBody = 3;
                    }
                }
                //endregion
            } else if (typeBoss == 3) {
                //region code
                if (numberPath >= 1) {
                    if (!time.isActive()) time.updateTime();
                    if (time.isActive()) {
                        monster.setAnimation("attack_mana");
                        isAbsorption = true;
                        time.setTimeReset();
                    }
                    if (isAbsorption && time.getTime() >= 2) {
                        if (life > 15300) monster.setAnimation("run");
                        else if (life > 12100 && life <= 15300) monster.setAnimation("run_2");
                        else if (life > 8900 && life <= 12100) monster.setAnimation("run_3");
                        else if (life > 5000 && life <= 8900) monster.setAnimation("run_4");
                        else if (life > 2000 && life <= 5000) monster.setAnimation("run_5");
                        else if (life <= 2000) monster.setAnimation("run_6");
                        isAbsorption = false;
                        time.setTimeReset();
                    }
                }
                getPosition(deltaTime);

                if (life > 12100 && life <= 15300 && monster.getAnimation().name.equals("run")) monster.setAnimation("run_2");
                else if (life > 8900 && life <= 12100 && monster.getAnimation().name.equals("run_2")) monster.setAnimation("run_3");
                else if (life > 5000 && life <= 8900 && monster.getAnimation().name.equals("run_3")) monster.setAnimation("run_4");
                else if (life > 2000 && life <= 5000 && monster.getAnimation().name.equals("run_4")) monster.setAnimation("run_5");
                else if (life <= 2000 && monster.getAnimation().name.equals("run_5")) monster.setAnimation("run_6");

                body.setPosition(monster.getX() - 80 * (float)sin(monster.getAngle() * 0.01745f), monster.getY() + 80 * (float)cos(monster.getAngle() * 0.01745f));
                monster.update();

                if (numberPath == 0 && isLiving && !monster.getAnimation().name.equals("attack")) {
                    monster.setAnimation("attack");
                    isShoot = true;
                }
                //endregion
            } else if (typeBoss == 4) {
                //region code
                if (numberPath >= 1) {
                    if (!time.isActive()) time.updateTime();
                    if (time.isActive()) {
                        totalWaveMonster = 25;
                        time.setTimeReset();
                    }
                }
                getPosition(deltaTime);

                if (life > 6000 && life <= 8500 && monster.getAnimation().name.equals("run")) monster.setAnimation("run_2");
                else if (life > 3500 && life <= 6000 && monster.getAnimation().name.equals("run_2")) monster.setAnimation("run_3");
                else if (life > 1800 && life <= 3500 && monster.getAnimation().name.equals("run_3")) {
                    monster.setAnimation("run_4");
                    body.radius = 50 * scaleSize;
                }

                if (life > 3500 && numberPath >= 1) {
                    if (choice == 0) body.setPosition(monster.getX() + 160 * (float) cos(monster.getAngle() * 0.01745f), monster.getY() + 160 * (float) sin(monster.getAngle() * 0.01745f));
                    else body.setPosition(monster.getX() - 160 * (float) cos(monster.getAngle() * 0.01745f), monster.getY() - 160 * (float) sin(monster.getAngle() * 0.01745f));
                } else {
                    body.setPosition(monster.getX() - 60 * (float) sin(monster.getAngle() * 0.01745f), monster.getY() + 60 * (float) cos(monster.getAngle() * 0.01745f));
                }
                monster.update();

                if (numberPath == 0 && isLiving && !monster.getAnimation().name.equals("attack")) {
                    body.radius = 50 * scaleSize;
                    monster.setAnimation("attack");
                    totalWaveMonster = 1000;
                    isShoot = true;
                }
                //endregion
            }
        }
        if (life <= 0) {
            speed = 0;
            isShoot = false;
            isLiving = false;
            dispose();
        }
    }

    public void render(SpriteBatch batch) {
        if (life > 0) {
            monster.setPosition(position.x, position.y);
            drawer.draw(monster);
        }

       /* renderer.setColor(Color.RED);
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.circle(body.x * MarsGame.getRatioMonitorW(), body.y * MarsGame.getRatioMonitorH(), body.radius  * MarsGame.getRatioMonitorW());
        //renderer.circle(body2.x * MarsGame.getRatioMonitorW(), body2.y * MarsGame.getRatioMonitorH(), body2.radius  * MarsGame.getRatioMonitorW());
        renderer.end();*/
    }

    public boolean collidesAim(Circle aim) {
        return body.overlaps(aim);
    }

    public boolean collidesMagic(Circle magic) {
        return body.overlaps(magic);
    }

    public void setLifeShoot(float shoot, float deltaTime) {
        float result = shoot - armor * deltaTime;
        if (result < 0) result = 0;
        if (!isRecovery) this.life -= result;
        else {
            this.life += result * 2;
            if (this.life > lifeMAX) this.life = lifeMAX;
        }
    }

    public void setLifeMagic(float powerMagic, String typeMagic, float deltaTime) {
        float result = 0;
        if (typeBoss == 1) result = (powerMagic - armor * deltaTime) * 0.5f;
        else if (typeBoss == 2) result = (powerMagic - armor * deltaTime) * 0.8f;
        else if (typeBoss == 3) {
            if (!typeMagic.equals("Fire")) result = powerMagic - armor * deltaTime;
        } else if (typeBoss == 4) {
            if (monster.getAnimation().name.equals("run_4") || monster.getAnimation().name.equals("attack")) {
                if (!typeMagic.equals("Poison")) result = powerMagic - armor * deltaTime;
            }
        }

        if (result < 0) result = 0;
        if (!isRecovery) this.life -= result;
        else {
            this.life += result * 2;
            if (this.life > lifeMAX) this.life = lifeMAX;
        }
    }

    public float getLife() {
        return life;
    }

    public int getLifeMAX() {
        return lifeMAX;
    }

    public boolean isLiving() {
        return isLiving;
    }

    public boolean isShoot() {
        return isShoot;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isAbsorption() {
        return isAbsorption;
    }

    public Circle getBody() {
        return body;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public int getPrice() {
        return price;
    }

    public int getTotalWaveMonster() {
        return totalWaveMonster;
    }

    public void setTotalWaveMonster(int totalWaveMonster) {
        this.totalWaveMonster -= totalWaveMonster;
    }

    public void dispose() {
        try {
            monster = null;
            drawer = null;
            body = null;
            time = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}