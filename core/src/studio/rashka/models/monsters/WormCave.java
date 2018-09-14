package studio.rashka.models.monsters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.brashmonkey.spriter.Player;
import com.brashmonkey.spriter.gdx.Drawer;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;

public class WormCave {

    private int lifeMAX = 2000, price = 150;
    private float life = 2000; // жизни
    private int armor = 50; // броня
    private float scaleSize;
    private boolean isLiving = true, isCompleteDieWormCave = false;

    private Vector2 position;
    private Circle body;

    private Player monster;
    private Drawer drawer;

    public WormCave(int x, int y, float scale, float angle) {
        scaleSize = scale;
        position = new Vector2(x, y);

        drawer = new Drawer(Textures.getInstance().loader.get("WormCave"), MarsGame.getBatch(), null);
        monster = new Player(Textures.getInstance().data.get("WormCave").getEntity(0));
        monster.setPosition(x, y);
        monster.setScale(scale);

        body = new Circle(monster.getX(), monster.getY(), 55 * scaleSize);
        monster.setScale(scale);
        monster.setAngle(angle);
        monster.speed = 10;
    }

    public void update() {
        if (life > 0) {
            body.setPosition(monster.getX(), monster.getY());
            if (MarsGame.getFrustum().sphereInFrustum(position.x, position.y, 0, 75 * scaleSize)) monster.update();
        }
        if (life <= 0 && isLiving) {
            isLiving = false;
            isCompleteDieWormCave = true;
            dispose();
        }
    }

    public void renderDie(SpriteBatch batch) {
        if (MarsGame.getFrustum().sphereInFrustum(position.x, position.y, 0, 75 * scaleSize))
            batch.draw(Textures.getInstance().textureRegion.get("WormCaveDie"), position.x - 64 * scaleSize, position.y - 64 * scaleSize, 128 * scaleSize, 128 * scaleSize);
    }

    public void render(SpriteBatch batch) {
        if (MarsGame.getFrustum().sphereInFrustum(position.x, position.y, 0, 75 * scaleSize)) {
            if (life > 0) {
                drawer.draw(monster);
                if (MarsGame.getPreference().getTacticsTechnologiesShowMonsterLife()) {
                    if (monster.getAngle() == 90 || monster.getAngle() == 270)
                        batch.draw(Textures.getInstance().textureRegion.get("HP"), position.x - 96 * scaleSize, position.y + 120 * scaleSize, life * 192 * scaleSize / lifeMAX, 4);
                    else if (monster.getAngle() == 180)
                        batch.draw(Textures.getInstance().textureRegion.get("HP"), position.x - 96 * scaleSize, position.y + 140 * scaleSize, life * 192 * scaleSize / lifeMAX, 4);
                    else if (monster.getAngle() == 0)
                        batch.draw(Textures.getInstance().textureRegion.get("HP"), position.x - 96 * scaleSize, position.y + 100 * scaleSize, life * 192 * scaleSize / lifeMAX, 4);
                }
            }
        }
    }

    public void renderHelp() {
        drawer.draw(monster);
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
        this.life -= result;
    }

    public void setLifeMagic(float powerMagic) {
        this.life -= powerMagic;
    }

    public float getLife() {
        return life;
    }

    public boolean isLiving() {
        return isLiving;
    }

    public boolean isCompleteDieWormCave() {
        return isCompleteDieWormCave;
    }

    public int getPrice() {
        return price;
    }

    public void setScaleSize(float scaleSize) {
        this.scaleSize += scaleSize;
    }

    public float getScaleSize() {
        return scaleSize;
    }

    public Player getMonster() {
        return monster;
    }

    public void dispose() {
        try {
            body = null;
            monster = null;
            drawer = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}