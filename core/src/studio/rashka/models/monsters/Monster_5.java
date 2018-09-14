package studio.rashka.models.monsters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.brashmonkey.spriter.gdx.Drawer;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.monster.Monsters;
import studio.rashka.models.monsters.packMonsters.ImmunityMonsters;

public class Monster_5 implements Monsters {

    private int lifeMAX, price;
    private float life; // жизни
    private int power, // сила атаки
            armor, // броня
            speed; // скорость

    private ImmunityMonsters immunityMonsters;
    private Drawer drawer;

    private boolean isLiving = true, isShoot = false;
    private float scaleSize;

    private Vector2 position;
    private Circle body;

    public Monster_5(Vector2 position, int immunity, int type) {
        this.position = new Vector2(position);

        if (type == 1) {
            scaleSize = 0.5f;
            lifeMAX = 15;
            life = 15;
            power = 5;
            armor = 0;
            speed = 50;
            price = 1;
        } else if (type == 2) {
            scaleSize = 1.1f;
            lifeMAX = 140;
            life = 140;
            power = 12;
            armor = 4;
            speed = 30;
            price = 5;
        }

        drawer = new Drawer(Textures.getInstance().loader.get("Monster_5"), MarsGame.getBatch(), null);
        immunityMonsters = new ImmunityMonsters("Monster_5", immunity);

        immunityMonsters.getMonster().setPosition(-MarsGame.WIDTH * 2, 0);
        immunityMonsters.getMonster().setScale(scaleSize);
        immunityMonsters.getMonster().setAnimation("run");
        body = new Circle(immunityMonsters.getMonster().getX(), immunityMonsters.getMonster().getY(), 17 * scaleSize);
    }

    @Override
    public void update(float deltaTime, float angel, int numberPath) {
        if (life > 0) {
            immunityMonsters.getMonster().setAngle(angel);
            body.setPosition(immunityMonsters.getMonster().getX(), immunityMonsters.getMonster().getY());
            if (MarsGame.getFrustum().sphereInFrustum(position.x, position.y, 0, 25 * scaleSize)) immunityMonsters.getMonster().update();

            if (numberPath == 0 && isLiving && !isShoot) {
                immunityMonsters.getMonsterAttack();
                isShoot = true;
            }
        }
        if (life <= 0) {
            speed = 0;
            isShoot = false;
            isLiving = false;
            dispose();
        }
    }

    @Override
    public void renderDie(SpriteBatch batch) {
        if (MarsGame.getFrustum().sphereInFrustum(position.x, position.y, 0, 25 * scaleSize)) {
            if (!isLiving) batch.draw(Textures.getInstance().textureRegion.get("Monsters_5Die"), position.x - 42 * scaleSize, position.y - 42 * scaleSize, 84 * scaleSize, 84 * scaleSize);
        }
    }

    @Override
    public void monsterAttack() {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (MarsGame.getFrustum().sphereInFrustum(position.x, position.y, 0, 25 * scaleSize)) {
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
        return false;
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