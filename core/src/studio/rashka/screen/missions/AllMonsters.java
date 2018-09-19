package studio.rashka.screen.missions;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.implement.monster.AbstractFactoryMonsters;
import studio.rashka.lib.implement.monster.CreateMonster;
import studio.rashka.lib.implement.monster.Monsters;
import studio.rashka.lib.singleton.MicrowavesMonster;
import studio.rashka.lib.singleton.SpeedMonster;
import studio.rashka.models.monsters.packMonsters.PathChoice;

public class AllMonsters {

    private AbstractFactoryMonsters createMonsters = new CreateMonster();
    private Monsters monsters;

    private float typeMonster;
    private int speed;
    private boolean isWork = true;

    private Random random;
    private Vector2 position;

    private PathChoice path;

    public AllMonsters(String mission, int typeMonster, int immunity, int type, int positionStart) {
        this.typeMonster = typeMonster;

        random = new Random();
        position = new Vector2(0, 0);

        path = new PathChoice(mission, positionStart, random);
        monsters = createMonsters.createMonsters(typeMonster, position, immunity, type);

        this.speed = monsters.getSpeed();

        if (typeMonster == 3 && !mission.equals("Missions_3_3")) {
            if (MarsGame.getPreference().getCrystal(mission) <= 0) isWork = false;
        }
    }

    public void update(float deltaTime) {
        if (typeMonster == 3) {
            if (isWork) position.set(path.getPath().getPositionFlyToWorker(deltaTime, speed, SpeedMonster.INSTANCE.getSpeed() * MicrowavesMonster.INSTANCE.getRunMicrowaves()).x, path.getPath().getPosition(deltaTime, speed, SpeedMonster.INSTANCE.getSpeed() * MicrowavesMonster.INSTANCE.getRunMicrowaves()).y);
            else position.set(path.getPath().getPositionFlyToBase(deltaTime, speed, SpeedMonster.INSTANCE.getSpeed() * MicrowavesMonster.INSTANCE.getRunMicrowaves()).x, path.getPath().getPosition(deltaTime, speed, SpeedMonster.INSTANCE.getSpeed() * MicrowavesMonster.INSTANCE.getRunMicrowaves()).y);
        } else {
            position.set(path.getPath().getPosition(deltaTime, speed, SpeedMonster.INSTANCE.getSpeed() * MicrowavesMonster.INSTANCE.getRunMicrowaves()).x, path.getPath().getPosition(deltaTime, speed, SpeedMonster.INSTANCE.getSpeed() * MicrowavesMonster.INSTANCE.getRunMicrowaves()).y);
        }
        monsters.setPosition(position);
        monsters.update(deltaTime, path.getPath().getAngel(), path.getPath().getNumberPath());
    }

    public void render(SpriteBatch batch) {
        monsters.render(batch);
    }

    public void renderDie(SpriteBatch batch) {
        monsters.renderDie(batch);
    }

    public boolean collidesAim(Circle aim) {
        return monsters.getBody().overlaps(aim);
    }

    public boolean collidesTower(Circle tower) {
        return monsters.getBody().overlaps(tower);
    }

    public boolean collidesTowerAim(Circle towerAim) {
        return monsters.getBody().overlaps(towerAim);
    }

    public boolean collidesMagic(Circle magic) {
        return monsters.getBody().overlaps(magic);
    }

    public void setLifeShoot(float shoot, float deltaTime) {
        if (typeMonster == 3) {
            if (random.nextInt(3) == 0) {
                float result = shoot - monsters.getArmor() * deltaTime;
                monsters.setLife(result);
            }
        } else {
            float result = shoot - monsters.getArmor() * deltaTime;
            monsters.setLife(result);
        }
    }

    public void setLifeMagic(float powerMagic, String typeMagic) {
        if (!typeMagic.equals(monsters.getImmunityMagic())) monsters.setLife(powerMagic);
    }

    public int getPower() {
        return monsters.getPower();
    }

    public boolean isLiving() {
        return monsters.isLiving();
    }

    public float getLife() {
        return monsters.getLife();
    }

    public boolean isShoot() {
        return monsters.isShoot();
    }

    public boolean isFinishFly() {
        return monsters.isFinishFly();
    }

    public void isAttackMonster() {
        monsters.monsterAttack();
    }

    public int getPrice() {
        return monsters.getPrice();
    }

    public Vector2 getPosition() {
        return position;
    }

    public void dispose() {
        try {
            path = null;
            position = null;
            monsters = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}