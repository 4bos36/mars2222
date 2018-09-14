package studio.rashka.models.reactor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import studio.rashka.MarsGame;
import studio.rashka.lib.AnimationModels;
import studio.rashka.lib.Textures;

public class CaseReactor {

    private AnimationModels caseReactor;
    private float ration = 0;

    public CaseReactor() {
        caseReactor = new AnimationModels(new TextureRegion(Textures.getInstance().textureRegionScreen.get("ReactorCase")), 2, 0.6f);
    }

    public void update(float deltaTime) {
        caseReactor.update(deltaTime);
        ration -= deltaTime * 10;
    }

    public void render(SpriteBatch batch) {
        batch.draw(caseReactor.getFrame(), MarsGame.WIDTH / 2 - 241, 491 - caseReactor.getFrame().getRegionHeight() / 2 + MarsGame.getRatioAdd(),
                caseReactor.getFrame().getRegionWidth() / 2, caseReactor.getFrame().getRegionHeight() / 2,
                caseReactor.getFrame().getRegionWidth(), caseReactor.getFrame().getRegionHeight(), 1, 1, ration);
    }

    public void dispose() {
        try {
            caseReactor.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}