package studio.rashka.models.monsters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.brashmonkey.spriter.gdx.Drawer;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.monster.Monsters;
import studio.rashka.models.monsters.packMonsters.ImmunityMonsters;

public class Monster_3 implements Monsters {

    private int lifeMAX, price, attackFly = 0;
    private float life; // жизни
    private int power, // сила атаки
            armor, // броня
            speed; // скорость

    private ImmunityMonsters immunityMonsters;
    private Drawer drawer;

    private boolean isLiving = true, isShoot = false, isFinishFly = false, isAttackRobot = false;
    private float scaleSize;

    private Vector2 position;
    private Circle body;

    public Monster_3(Vector2 position, int immunity, int type) {
        this.position = new Vector2(position);

        if (type == 1) {
            scaleSize = 0.4f;
            lifeMAX = 45;
            life = 45;
            power = 5;
            armor = 1;
            speed = 30;
            price = 3;
        } else if (type == 2) {
            scaleSize = 0.8f;
            lifeMAX = 80;
            life = 80;
            power = 8;
            armor = 3;
            speed = 35;
            price = 4;
        }

        drawer = new Drawer(Textures.getInstance().loader.get("Monster_3"), MarsGame.getBatch(), null);
        immunityMonsters = new ImmunityMonsters("Monster_3", immunity);
        immunityMonsters.getMonster().setScale(scaleSize);
        immunityMonsters.getMonster().setPosition(-MarsGame.WIDTH * 2, 0);

        body = new Circle(immunityMonsters.getMonster().getX(), immunityMonsters.getMonster().getY(), 25 * scaleSize);
    }

    @Override
    public void update(float deltaTime, float angel, int numberPath) {
        if (life > 0) {
            immunityMonsters.getMonster().setAngle(angel);
            body.setPosition(immunityMonsters.getMonster().getX(), immunityMonsters.getMonster().getY());
            if (MarsGame.getFrustum().sphereInFrustum(position.x, position.y, 0, 30 * scaleSize)) immunityMonsters.getMonster().update();

            if (numberPath == 0 && isLiving && !isShoot) {
                immunityMonsters.getMonsterAttack();
                isShoot = true;
            }
            if (numberPath == -1 && isLiving && !isFinishFly) isFinishFly = true;

            if (isAttackRobot) {
                immunityMonsters.getMonster().setAnimation("attack");
                attackFly++;
                if (attackFly > 50) {
                    immunityMonsters.getMonster().setAnimation("run");
                    attackFly = 0;
                    isAttackRobot = false;
                }
            }
        }
        if (life <= 0) {
            speed = 0;
            isShoot = false;
            isFinishFly = false;
            isLiving = false;
            dispose();
        }
    }

    public void monsterAttack() {
        isAttackRobot = true;
    }

    @Override
    public void renderDie(SpriteBatch batch) {
        if (MarsGame.getFrustum().sphereInFrustum(position.x, position.y, 0, 30 * scaleSize)) {
            if (!isLiving) batch.draw(Textures.getInstance().textureRegion.get("Monsters_3Die"), position.x - 42 * scaleSize, position.y - 42 * scaleSize, 84 * scaleSize, 84 * scaleSize);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        if (MarsGame.getFrustum().sphereInFrustum(position.x, position.y, 0, 30 * scaleSize)) {
            if (life > 0) {
                immunityMonsters.getMonster().setPosition(position.x, position.y);
                drawer.draw(immunityMonsters.getMonster());
                if (MarsGame.getPreference().getTacticsTechnologiesShowMonsterLife())
                    batch.draw(Textures.getInstance().textureRegion.get("HP"), position.x - 24 * scaleSize, position.y + 64 * scaleSize, life * 48 * scaleSize / lifeMAX, 4);
            }
        }
    }

    @Override
    public float getLife() {
        return life;
    }

    @Override
    public void setLife(float life) {
        this.life -= life;
    }

    @Override
    public boolean isLiving() {
        return isLiving;
    }

    @Override
    public boolean isShoot() {
        return isShoot;
    }

    @Override
    public boolean isFinishFly() {
        return isFinishFly;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public Circle getBody() {
        return body;
    }

    @Override
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    @Override
    public String getImmunityMagic() {
        return immunityMonsters.getImmunityMagic();
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void dispose() {
        try {
            immunityMonsters = null;
            drawer = null;
            body = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}