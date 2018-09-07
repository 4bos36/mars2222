package studio.rashka.lib.implement.monster;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public interface Monsters {

    void update(float deltaTime, float angel, int numberPath);

    void render(SpriteBatch batch);

    void renderDie(SpriteBatch batch);

    void monsterAttack();

    float getLife();

    void setLife(float life);

    boolean isLiving();

    boolean isShoot();

    boolean isFinishFly();

    int getPower();

    int getArmor();

    int getSpeed();

    Circle getBody();

    void setPosition(Vector2 position);

    String getImmunityMagic();

    int getPrice();

    void dispose();
}