package studio.rashka.models.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;
import java.util.Map;

import studio.rashka.MarsGame;
import studio.rashka.lib.singleton.ScaleMap;

public class Magic {

    private boolean isActiveMagicFire = false, isActiveMagicIce = false, isActiveMagicPoison = false;
    private float magicPowerFire, magicPowerIce, magicPowerPoison,
            shotRadius = 150;

    private Circle zoneFire, zoneIce, zonePoison;
    private Vector2 positionFire, positionIce, positionPoison;

    private Map<String, ParticleEffect> magic;

    public Magic() {
        positionFire = new Vector2(0, 0);
        positionIce = new Vector2(0, 0);
        positionPoison = new Vector2(0, 0);

        magic = new HashMap<String, ParticleEffect>();
        magic.put("Fire", new ParticleEffect());
        magic.put("Ice", new ParticleEffect());
        magic.put("Poison", new ParticleEffect());

        magic.get("Fire").load(Gdx.files.internal("particles/Fire.p"), Gdx.files.internal("particles"));
        magic.get("Ice").load(Gdx.files.internal("particles/Ice.p"), Gdx.files.internal("particles"));
        magic.get("Poison").load(Gdx.files.internal("particles/Poison.p"), Gdx.files.internal("particles"));
        magic.get("Fire").start();
        magic.get("Ice").start();
        magic.get("Poison").start();

        zoneFire = new Circle(0, 0, shotRadius);
        zoneIce = new Circle(0, 0, shotRadius);
        zonePoison = new Circle(0, 0, shotRadius);
    }

    public void update(float deltaTime) {
        if (isActiveMagicFire) {
            zoneFire.setPosition(positionFire.x, positionFire.y);
            magic.get("Fire").update(deltaTime);
            if (magic.get("Fire").isComplete()) {
                magic.get("Fire").reset();
                isActiveMagicFire = false;
                magicPowerFire = 0;
            }
        }
        if (isActiveMagicIce) {
            zoneIce.setPosition(positionIce.x, positionIce.y);
            magic.get("Ice").update(deltaTime);
            if (magic.get("Ice").isComplete()) {
                magic.get("Ice").reset();
                isActiveMagicIce = false;
                magicPowerIce = 0;
            }
        }
        if (isActiveMagicPoison) {
            zonePoison.setPosition(positionPoison.x, positionPoison.y);
            magic.get("Poison").update(deltaTime);
            if (magic.get("Poison").isComplete()) {
                magic.get("Poison").reset();
                isActiveMagicPoison = false;
                magicPowerPoison = 0;
            }
        }
    }

    public void render(SpriteBatch batch) {
        if (isActiveMagicFire) {
            magic.get("Fire").setPosition(positionFire.x, positionFire.y);
            magic.get("Fire").draw(batch);
        }
        if (isActiveMagicIce) {
            magic.get("Ice").setPosition(positionIce.x, positionIce.y);
            magic.get("Ice").draw(batch);
        }
        if (isActiveMagicPoison) {
            magic.get("Poison").setPosition(positionPoison.x, positionPoison.y);
            magic.get("Poison").draw(batch);
        }
    }

    public boolean isActiveMagicFire() {
        return isActiveMagicFire;
    }

    public boolean isActiveMagicIce() {
        return isActiveMagicIce;
    }

    public boolean isActiveMagicPoison() {
        return isActiveMagicPoison;
    }

    public Circle getZoneFire() {
        return zoneFire;
    }

    public Circle getZoneIce() {
        return zoneIce;
    }

    public Circle getZonePoison() {
        return zonePoison;
    }

    public void setMagicPowerFire(float magicPower) {
        this.magicPowerFire = magicPower;
    }

    public void setMagicPowerIce(float magicPower) {
        this.magicPowerIce = magicPower;
    }

    public void setMagicPowerPoison(float magicPower) {
        this.magicPowerPoison = magicPower;
    }

    public float getMagicPowerFire() {
        return magicPowerFire;
    }

    public float getMagicPowerIce() {
        return magicPowerIce;
    }

    public float getMagicPowerPoison() {
        return magicPowerPoison;
    }

    public void setPushMagicFire(float posX, float posY, boolean active) {
        if (ScaleMap.INSTANCE.getScale() == 1.0f) {
            this.positionFire.x = posX - MarsGame.WIDTH / 2;
            this.positionFire.y = posY - MarsGame.HEIGHT / 2;
        } else if (ScaleMap.INSTANCE.getScale() == 0.5f) {
            this.positionFire.x = posX - MarsGame.WIDTH;
            this.positionFire.y = posY - MarsGame.HEIGHT;
        }
        isActiveMagicFire = active;
    }

    public void setPushMagicIce(float posX, float posY, boolean active) {
        if (ScaleMap.INSTANCE.getScale() == 1.0f) {
            this.positionIce.x = posX - MarsGame.WIDTH / 2;
            this.positionIce.y = posY - MarsGame.HEIGHT / 2;
        } else if (ScaleMap.INSTANCE.getScale() == 0.5f) {
            this.positionIce.x = posX - MarsGame.WIDTH;
            this.positionIce.y = posY - MarsGame.HEIGHT;
        }
        isActiveMagicIce = active;
    }

    public void setPushMagicPoison(float posX, float posY, boolean active) {
        if (ScaleMap.INSTANCE.getScale() == 1.0f) {
            this.positionPoison.x = posX - MarsGame.WIDTH / 2;
            this.positionPoison.y = posY - MarsGame.HEIGHT / 2;
        } else if (ScaleMap.INSTANCE.getScale() == 0.5f) {
            this.positionPoison.x = posX - MarsGame.WIDTH;
            this.positionPoison.y = posY - MarsGame.HEIGHT;
        }
        isActiveMagicPoison = active;
    }

    public void dispose() {
        try {
            zoneFire = null;
            zoneIce = null;
            zonePoison = null;
            positionFire = null;
            positionIce = null;
            positionPoison = null;
            magic.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}