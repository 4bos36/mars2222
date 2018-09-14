package studio.rashka.models.reactor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;

public class Energy {

    private ParticleEffect life, mana, energy;

    public Energy() {
        life = new ParticleEffect();
        life.load(Gdx.files.internal("reactor/ReactorLife.p"), Gdx.files.internal("particles"));
        life.setPosition(245, 325 + MarsGame.getRatioAdd());
        life.start();

        mana = new ParticleEffect();
        mana.load(Gdx.files.internal("reactor/ReactorMana.p"), Gdx.files.internal("particles"));
        mana.setPosition(MarsGame.WIDTH - 245, 350 + MarsGame.getRatioAdd());
        mana.start();

        energy = new ParticleEffect();
        energy.load(Gdx.files.internal("reactor/Energy.p"), Gdx.files.internal("particles"));
        energy.setPosition(MarsGame.WIDTH / 2, 780 + MarsGame.getRatioAdd());
        energy.start();
    }

    public void update(float deltaTime) {
        energy.update(deltaTime);
        life.update(deltaTime);
        mana.update(deltaTime);
    }

    public void render(SpriteBatch batch) {
        energy.draw(batch);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), MarsGame.WIDTH / 2 - 200, 290 + MarsGame.getRatioAdd(), 400, 400);
        life.draw(batch);
        mana.draw(batch);
    }

    public void dispose() {
        try {
            life.dispose();
            mana.dispose();
            energy.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}