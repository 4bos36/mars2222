package studio.rashka.models.laboratory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import studio.rashka.MarsGame;

public class Chemicals {

    private ParticleEffect fire, ice, toxins;

    public Chemicals() {
        fire = new ParticleEffect();
        ice = new ParticleEffect();
        toxins = new ParticleEffect();
        fire.load(Gdx.files.internal("laboratory/FireLab.p"), Gdx.files.internal("particles"));
        ice.load(Gdx.files.internal("laboratory/IceLab.p"), Gdx.files.internal("particles"));
        toxins.load(Gdx.files.internal("laboratory/ToxinsLab.p"), Gdx.files.internal("particles"));
    }

    public void update(float deltaTime) {
        fire.update(deltaTime);
        ice.update(deltaTime);
        toxins.update(deltaTime);
    }

    public void render(SpriteBatch batch) {
        fire.setPosition(MarsGame.WIDTH / 2 - 388, 340 + MarsGame.getRatioAdd());
        fire.draw(batch);
        ice.setPosition(MarsGame.WIDTH / 2 - 8, 370 + MarsGame.getRatioAdd());
        ice.draw(batch);
        toxins.setPosition(MarsGame.WIDTH / 2 + 382, 350 + MarsGame.getRatioAdd());
        toxins.draw(batch);
    }

    public void dispose() {
        try {
            fire.dispose();
            ice.dispose();
            toxins.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}