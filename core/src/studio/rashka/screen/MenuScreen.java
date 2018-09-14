package studio.rashka.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.util.HashMap;
import java.util.Map;

import studio.rashka.MarsGame;
import studio.rashka.lib.FontTTF;
import studio.rashka.lib.Game;
import studio.rashka.lib.State;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.Buttons;
import studio.rashka.models.Loading;
import studio.rashka.models.Stars;
import studio.rashka.models.lightbulb.RedLightbulb;

public class MenuScreen extends State {

    private Stage stage;
    private Map<String, Buttons> buttons;
    private Label logoName, logoNumber, logoTire;
    private boolean flyUp = false,
            touchFacebook = false, touchVK = false, touchTwitter = false,
            touchGooglePlus = false, touchExit = false, touchStart = false;
    private float angleMars = 0, flyNLO = 0;

    private Stars stars;
    private RedLightbulb redLightbulb;

    public MenuScreen(Game game) {
        super(game);
        stage = new Stage();
        stars = new Stars();
        redLightbulb = new RedLightbulb();

        buttons();
        logoText();
    }

    private void logoText() {
        logoName = new Label("m  a  r  s", new LabelStyle(FontTTF.getInstance().getFont200(), Color.WHITE));
        logoTire = new Label("--------", new LabelStyle(FontTTF.getInstance().getFont100(), Color.WHITE));
        logoNumber = new Label("2 2 2 2", new LabelStyle(FontTTF.getInstance().getFont100(), Color.WHITE));

        logoName.setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - logoName.getPrefWidth() / 2, MarsGame.HEIGHT / 2 * MarsGame.getRatioMonitorH());
        logoTire.setPosition((MarsGame.WIDTH / 2 + 20) * MarsGame.getRatioMonitorW() - logoTire.getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 35) * MarsGame.getRatioMonitorH());
        logoNumber.setPosition((MarsGame.WIDTH / 2 + 20) * MarsGame.getRatioMonitorW() - logoNumber.getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 80) * MarsGame.getRatioMonitorH());

        stage.addActor(logoName);
        stage.addActor(logoTire);
        stage.addActor(logoNumber);
    }

    private void buttons() {
        buttons = new HashMap<String, Buttons>();
        Drawable drawable = Textures.getInstance().getTextureButtonSkin().getDrawable("NULL");

        buttons.put("Exit", new Buttons("Exit", drawable, 128, 128, 32, 16));
        buttons.put("Start", new Buttons("Start", drawable, 192, 192, MarsGame.WIDTH / 2 - 96, 128));
        buttons.put("Music", new Buttons("Music", drawable, 64, 64, MarsGame.WIDTH - 116, MarsGame.HEIGHT - 112));
        buttons.put("Sound", new Buttons("Sound", drawable, 64, 64, MarsGame.WIDTH - 116, MarsGame.HEIGHT - 208));
        buttons.put("Vibro", new Buttons("Vibro", drawable, 64, 64, MarsGame.WIDTH - 201, MarsGame.HEIGHT - 162));
        buttons.put("AboutUs", new Buttons("AboutUs", drawable, 64, 64, MarsGame.WIDTH - 118, 48));
        buttons.put("Help", new Buttons("Help", drawable, 64, 64, MarsGame.WIDTH - 197, 96));
        buttons.put("Ru", new Buttons("Ru", drawable, 128, 64, MarsGame.WIDTH / 2 - 360, MarsGame.HEIGHT - 128));
        buttons.put("En", new Buttons("En", drawable, 128, 64, MarsGame.WIDTH / 2 - 160, MarsGame.HEIGHT - 128));
        buttons.put("Facebook", new Buttons("Facebook", drawable, 80, 80, 98, MarsGame.HEIGHT - 136));
        buttons.put("VK", new Buttons("VK", drawable, 80, 80, 183, MarsGame.HEIGHT - 136));
        buttons.put("Twitter", new Buttons("Twitter", drawable, 80, 80, 56, MarsGame.HEIGHT - 212));
        buttons.put("GooglePlus", new Buttons("GooglePlus", drawable, 80, 80, 141, MarsGame.HEIGHT - 212));

        buttons.get("Exit").addListener(new ButtonsInputListener(buttons.get("Exit").getName()));
        buttons.get("Start").addListener(new ButtonsInputListener(buttons.get("Start").getName()));
        buttons.get("Music").addListener(new ButtonsInputListener(buttons.get("Music").getName()));
        buttons.get("Sound").addListener(new ButtonsInputListener(buttons.get("Sound").getName()));
        buttons.get("Vibro").addListener(new ButtonsInputListener(buttons.get("Vibro").getName()));
        buttons.get("AboutUs").addListener(new ButtonsInputListener(buttons.get("AboutUs").getName()));
        buttons.get("Help").addListener(new ButtonsInputListener(buttons.get("Help").getName()));
        buttons.get("Ru").addListener(new ButtonsInputListener(buttons.get("Ru").getName()));
        buttons.get("En").addListener(new ButtonsInputListener(buttons.get("En").getName()));
        buttons.get("Facebook").addListener(new ButtonsInputListener(buttons.get("Facebook").getName()));
        buttons.get("VK").addListener(new ButtonsInputListener(buttons.get("VK").getName()));
        buttons.get("Twitter").addListener(new ButtonsInputListener(buttons.get("Twitter").getName()));
        buttons.get("GooglePlus").addListener(new ButtonsInputListener(buttons.get("GooglePlus").getName()));

        stage.addActor(buttons.get("Exit"));
        stage.addActor(buttons.get("Start"));
        stage.addActor(buttons.get("Music"));
        stage.addActor(buttons.get("Sound"));
        stage.addActor(buttons.get("Vibro"));
        stage.addActor(buttons.get("AboutUs"));
        stage.addActor(buttons.get("Help"));
        stage.addActor(buttons.get("Ru"));
        stage.addActor(buttons.get("En"));
        stage.addActor(buttons.get("Facebook"));
        stage.addActor(buttons.get("VK"));
        stage.addActor(buttons.get("Twitter"));
        stage.addActor(buttons.get("GooglePlus"));
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void update(float deltaTime) {
        stars.update();
        redLightbulb.update(deltaTime / 2);
        angleMars -= deltaTime / 3;
        if (!flyUp) {
            flyNLO += deltaTime * 10;
            if (flyNLO > 64) flyUp = true;
        }
        else if (flyUp) {
            flyNLO -=deltaTime * 10;
            if (flyNLO < 0) flyUp = false;
        }
        buttons.get("Ru").setPosition(MarsGame.WIDTH / 2 - 360 - flyNLO, MarsGame.HEIGHT - 128);
        buttons.get("En").setPosition(MarsGame.WIDTH / 2 - 160 - flyNLO, MarsGame.HEIGHT - 128);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        stars.render(batch);
        batch.draw(Textures.getInstance().textureRegion.get("Mars"), MarsGame.WIDTH - 760, MarsGame.HEIGHT - 660, 352, 352, 704, 704, 1, 1, angleMars);
        if (!touchStart) batch.draw(Textures.getInstance().textureRegion.get("Start"), MarsGame.WIDTH / 2 - 96, 128);
        else batch.draw(Textures.getInstance().textureRegion.get("Start"), MarsGame.WIDTH / 2 - 90, 134, 180, 180);
        if (!touchExit) batch.draw(Textures.getInstance().textureRegion.get("Exit"), 32, 16, 128, 128);
        else batch.draw(Textures.getInstance().textureRegion.get("Exit"), 36, 20, 120, 120);
        if (MarsGame.getPreference().loadMusic() == 0)
            batch.draw(Textures.getInstance().textureRegion.get("MusicOff"), MarsGame.WIDTH - 132, MarsGame.HEIGHT - 128, 96, 96);
        else if (MarsGame.getPreference().loadMusic() == 1)
            batch.draw(Textures.getInstance().textureRegion.get("MusicOn"), MarsGame.WIDTH - 132, MarsGame.HEIGHT - 128, 96, 96);
        if (MarsGame.getPreference().loadSound() == 1)
            batch.draw(Textures.getInstance().textureRegion.get("SoundOn"), MarsGame.WIDTH - 132, MarsGame.HEIGHT - 224, 96, 96);
        else if (MarsGame.getPreference().loadSound() == 0)
            batch.draw(Textures.getInstance().textureRegion.get("SoundOff"), MarsGame.WIDTH - 132, MarsGame.HEIGHT - 224, 96, 96);
        if (MarsGame.getPreference().loadVibro() == 1)
            batch.draw(Textures.getInstance().textureRegion.get("VibroOn"), MarsGame.WIDTH - 216, MarsGame.HEIGHT - 176, 96, 96);
        else if (MarsGame.getPreference().loadVibro() == 0)
            batch.draw(Textures.getInstance().textureRegion.get("VibroOff"), MarsGame.WIDTH - 216, MarsGame.HEIGHT - 176, 96, 96);
        batch.draw(Textures.getInstance().textureRegion.get("AboutUs"), MarsGame.WIDTH - 132, 32, 96, 96);
        batch.draw(Textures.getInstance().textureRegion.get("Help"), MarsGame.WIDTH - 216, 80, 96, 96);

        if (!touchFacebook) batch.draw(Textures.getInstance().textureRegion.get("Facebook"), 90, MarsGame.HEIGHT - 144, 96, 96);
        else batch.draw(Textures.getInstance().textureRegion.get("Facebook"), 93, MarsGame.HEIGHT - 141, 90, 90);
        if (!touchVK) batch.draw(Textures.getInstance().textureRegion.get("VK"), 175, MarsGame.HEIGHT - 144, 96, 96);
        else batch.draw(Textures.getInstance().textureRegion.get("VK"), 178, MarsGame.HEIGHT - 141, 90, 90);
        if (!touchTwitter) batch.draw(Textures.getInstance().textureRegion.get("Twitter"), 48, MarsGame.HEIGHT - 220, 96, 96);
        else batch.draw(Textures.getInstance().textureRegion.get("Twitter"), 51, MarsGame.HEIGHT - 217, 90, 90);
        if (!touchGooglePlus) batch.draw(Textures.getInstance().textureRegion.get("GooglePlus"), 133, MarsGame.HEIGHT - 220, 96, 96);
        else batch.draw(Textures.getInstance().textureRegion.get("GooglePlus"), 136, MarsGame.HEIGHT - 217, 90, 90);

        batch.draw(Textures.getInstance().textureRegion.get("NLO"), MarsGame.WIDTH / 2 - (360 + flyNLO), MarsGame.HEIGHT - 128);
        batch.draw(Textures.getInstance().textureRegion.get("Ru"), MarsGame.WIDTH / 2 - (265 + flyNLO), MarsGame.HEIGHT - 94, 48, 48);
        batch.draw(Textures.getInstance().textureRegion.get("NLO"), MarsGame.WIDTH / 2 - (160 + flyNLO), MarsGame.HEIGHT - 128);
        batch.draw(Textures.getInstance().textureRegion.get("En"), MarsGame.WIDTH / 2 - (65 + flyNLO), MarsGame.HEIGHT - 94, 48, 48);
        if (MarsGame.getPreference().language().equals("ru")) batch.draw(Textures.getInstance().textureRegion.get("Ru"), MarsGame.WIDTH / 2 - (325 + flyNLO), MarsGame.HEIGHT - 94, -48, 48);
        else batch.draw(Textures.getInstance().textureRegion.get("En"), MarsGame.WIDTH / 2 - (125 + flyNLO), MarsGame.HEIGHT - 94, -48, 48);

        batch.draw(Textures.getInstance().textureRegion.get("OrbitalStation"), 256 + flyNLO / 2, 160 + flyNLO / 2, 560, 320);
        redLightbulb.render(batch, 367 + flyNLO / 2, 456 + flyNLO / 2, 10, 6);
        redLightbulb.render(batch, 648 + flyNLO / 2, 466 + flyNLO / 2, 8, 7);
        redLightbulb.render(batch, 710 + flyNLO / 2, 300 + flyNLO / 2, 13, 10);
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
            stage.dispose();
            stars.dispose();
            redLightbulb.dispose();
            buttons.clear();
            logoName.clear();
            logoNumber.clear();
            logoTire.clear();
            MarsGame.getMusicSound().disposeSounds();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ButtonsInputListener extends InputListener {
        private String name;

        public ButtonsInputListener(String name) {
            this.name = name;
        }

        @Override
        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            if (name.equals("Exit")) touchExit = true;
            else if (name.equals("Start")) touchStart = true;
            else if (name.equals("Facebook")) touchFacebook = true;
            else if (name.equals("VK")) touchVK = true;
            else if (name.equals("Twitter")) touchTwitter = true;
            else if (name.equals("GooglePlus")) touchGooglePlus = true;
            return true;
        }

        @Override
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            if (name.equals("Exit")) {
                touchExit = false;
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                if (MarsGame.playServices.getSignedInGPGS()) MarsGame.playServices.logoutGPGS();
                //Gdx.app.exit();
                System.exit(0);
            } else if (name.equals("Start")) {
                touchStart = false;
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                game.set(new Loading(game, "Game"));
            } else if (name.equals("Music")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                if (MarsGame.getPreference().loadMusic() == 0) {
                    MarsGame.getPreference().saveMusic(1);
                    MarsGame.getMusicSound().fon.get("Fon").setLooping(true);
                    MarsGame.getMusicSound().fon.get("Fon").play();
                } else if (MarsGame.getPreference().loadMusic() == 1) {
                    MarsGame.getPreference().saveMusic(0);
                    MarsGame.getMusicSound().fon.get("Fon").setLooping(false);
                    MarsGame.getMusicSound().fon.get("Fon").stop();
                }
            } else if (name.equals("Sound")) {
                if (MarsGame.getPreference().loadSound() == 0) {
                    MarsGame.getPreference().saveSound(1);
                    MarsGame.getMusicSound().sounds.get("Click").play();
                }
                else if (MarsGame.getPreference().loadSound() == 1) MarsGame.getPreference().saveSound(0);
            } else if (name.equals("Vibro")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                if (MarsGame.getPreference().loadVibro() == 0) MarsGame.getPreference().saveVibro(1);
                else if (MarsGame.getPreference().loadVibro() == 1) MarsGame.getPreference().saveVibro(0);
            } else if (name.equals("AboutUs")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                game.set(new Loading(game, "About"));
            } else if (name.equals("Help")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                game.set(new Loading(game, "Help"));
            } else if (name.equals("Ru")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                MarsGame.getPreference().setLanguage("ru");
            } else if (name.equals("En")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                MarsGame.getPreference().setLanguage("en");
            } else if (name.equals("Facebook")) {
                touchFacebook = false;
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                Gdx.net.openURI("https://www.facebook.com/groups/rashka.studio/");
            } else if (name.equals("VK")) {
                touchVK = false;
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                Gdx.net.openURI("https://vk.com/rashka.studio");
            } else if (name.equals("Twitter")) {
                touchTwitter = false;
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                Gdx.net.openURI("https://twitter.com/rashka_studio/");
            } else if (name.equals("GooglePlus")) {
                touchGooglePlus = false;
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("Click").play();
                Gdx.net.openURI("https://plus.google.com/communities/117036335723806113531/");
            }
        }
    }
}