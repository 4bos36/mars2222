package studio.rashka.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import java.util.HashMap;
import java.util.Map;

import studio.rashka.MarsGame;
import studio.rashka.lib.Game;
import studio.rashka.lib.State;
import studio.rashka.models.Stars;

public class LoadScreen extends State {

    private Stage stage;
    private Map<String, Label> text;
    private Map<String, TextureRegion> loading;
    private Stars stars;
    private int i = 0;

    public LoadScreen(Game game) {
        super(game);
        stage = new Stage();
        text = new HashMap<String, Label>();
        MarsGame.getFontTTF().loadSizeParameter54();

        loading = new HashMap<String, TextureRegion>();
        loading.put("logo", new TextureRegion(new Texture("loading.tga"), 0, 0, 256, 160));
        loading.put("progressBar", new TextureRegion(new Texture("loading.tga"), 155, 64, 1, 1));

        MarsGame.getTextures().loadFile();
        MarsGame.getMusicSound().loadSounds();

        text.put("loading", new Label(MarsGame.getLanguage().textScreen.get("loading"), new LabelStyle(MarsGame.getFontTTF().getFont54(), Color.WHITE)));
        text.put("logo", new Label("rashka.studio", new LabelStyle(MarsGame.getFontTTF().getFont54(), Color.LIME)));
        text.get("loading").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("loading").getPrefWidth() / 2, 128 * MarsGame.getRatioMonitorH());
        text.get("logo").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("logo").getPrefWidth() / 2, 16 * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("loading"));
        stage.addActor(text.get("logo"));
    }

    @Override
    public void update(float deltaTime) {
        if (MarsGame.getMusicSound().getLoadSound().update()) {
            MarsGame.getMusicSound().click();
            MarsGame.getMusicSound().fonSound();
        }
        if (MarsGame.getTextures().getSpaceShip().get("SpaceShip").update()) {
            if (MarsGame.getTextures().getSpaceShip().get("SpaceShip").update() && i <= 60) i++;
            if (i == 2) {
                MarsGame.getTextures().spaceship();
                stars = new Stars();
            }
            if (i == 10) MarsGame.getTextures().loadFile2();
            if (i == 20) {
                MarsGame.getFontTTF().loadSizeParameter28_48();
                MarsGame.getFontTTF().loadSizeParameter100_200();
                MarsGame.getTextures().loadFileTexture();
                MarsGame.playServices.showAds(200);
            }
            if (i == 30) MarsGame.getTextures().loadMonsters();
            if (i == 35) {
                MarsGame.getTextures().loadMonsters2();
                MarsGame.playServices.showAds(404);
            }
            if (i == 40) {
                if (!MarsGame.playServices.getSignedInGPGS()) MarsGame.playServices.loginGPGS();
            }
            /*if (i == 43) MarsGame.getTextures().loadMonstersBoss2();
            if (i == 46) MarsGame.getTextures().loadMonstersBoss3();
            if (i == 48) MarsGame.getTextures().loadMonstersBoss4();*/
            if (i == 50) {
                if (MarsGame.getPreference().loadMusic() == 1) {
                    try {
                        MarsGame.getMusicSound().fon.get("Fon").setLooping(true);
                        MarsGame.getMusicSound().fon.get("Fon").setVolume(1.0f);
                        MarsGame.getMusicSound().fon.get("Fon").play();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                text.get("loading").setText(MarsGame.getLanguage().textScreen.get("touch"));
                text.get("loading").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("loading").getPrefWidth() / 2, 128 * MarsGame.getRatioMonitorH());
            }
        }
        if (i > 4) stars.update();
        if (i > 55) {
            if (Gdx.input.isTouched()) game.set(new MenuScreen(game));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        if (i > 4) stars.render(batch);
        batch.draw(loading.get("logo"), MarsGame.WIDTH / 2 - 160, MarsGame.HEIGHT / 2 - 100, 320, 200);
        batch.draw(loading.get("progressBar"), 0, 0, 34.9f * i, 4);
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
            stage.dispose();
            text.clear();
            loading.clear();
            stars.dispose();
            MarsGame.getLanguage().disposeText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}