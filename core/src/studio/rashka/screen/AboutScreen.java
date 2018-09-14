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
import studio.rashka.models.bridge.TV;
import studio.rashka.models.robots.R_7;

public class AboutScreen extends State {

    private Stage stage;
    private Map<String, Label> text;
    private boolean
            touchSite = false, touchGoogle = false, touchVK = false,
            touchFacebook = false, touchVKgroup = false, touchTwitter = false;
    private float angleMars = 0;

    private Map<String, Buttons> buttons;
    private R_7 r_7;
    private TV tv;
    private Stars stars;

    private static final Drawable img = Textures.getInstance().getTextureButtonSkin().getDrawable("NULL");
    private static final LabelStyle style28 = new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE);

    public AboutScreen(Game game) {
        super(game);
        tv = new TV();
        r_7 = new R_7();
        stage = new Stage();
        stars = new Stars();
        text = new HashMap<String, Label>();
        buttons = new HashMap<String, Buttons>();

        r_7.setX(MarsGame.WIDTH / 2);
        r_7.setAddToMove(MarsGame.WIDTH / 2 + 128);
        r_7.setY(96);
        r_7.setMove(1);
        stage.addActor(r_7.getClick());

        buttons();
        textLoading();
    }

    private void buttons() {
        buttons.put("Facebook", new Buttons("Facebook", img, 96, 96, 589, 345 + MarsGame.getRatioAdd()));
        buttons.put("VK", new Buttons("VK", img, 96, 96, 589, 475 + MarsGame.getRatioAdd()));
        buttons.put("Twitter", new Buttons("Twitter", img, 96, 96, 1233, 425 + MarsGame.getRatioAdd()));
        buttons.put("Home", new Buttons("Home", img, 96, 128, 325, 192 + MarsGame.getRatioAdd()));
        buttons.put("Site", new Buttons("Site", img, 60, 60, MarsGame.WIDTH / 2 - 160, 265 + MarsGame.getRatioAdd()));
        buttons.put("Google", new Buttons("Google", img, 60, 60, MarsGame.WIDTH / 2 - 30, 265 + MarsGame.getRatioAdd()));
        buttons.put("VKpage", new Buttons("VKpage", img, 60, 60, MarsGame.WIDTH / 2 + 98, 265 + MarsGame.getRatioAdd()));

        buttons.get("Facebook").addListener(new ButtonsInputListener(buttons.get("Facebook").getName()));
        buttons.get("VK").addListener(new ButtonsInputListener(buttons.get("VK").getName()));
        buttons.get("Twitter").addListener(new ButtonsInputListener(buttons.get("Twitter").getName()));
        buttons.get("Home").addListener(new ButtonsInputListener(buttons.get("Home").getName()));
        buttons.get("Site").addListener(new ButtonsInputListener(buttons.get("Site").getName()));
        buttons.get("Google").addListener(new ButtonsInputListener(buttons.get("Google").getName()));
        buttons.get("VKpage").addListener(new ButtonsInputListener(buttons.get("VKpage").getName()));

        stage.addActor(buttons.get("Facebook"));
        stage.addActor(buttons.get("VK"));
        stage.addActor(buttons.get("Twitter"));
        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("Site"));
        stage.addActor(buttons.get("Google"));
        stage.addActor(buttons.get("VKpage"));
        Gdx.input.setInputProcessor(stage);
    }

    private void textLoading() {
        text.put("Menu", new Label(MarsGame.getLanguage().textScreen.get("Menu"), style28));
        text.put("Developer", new Label(MarsGame.getLanguage().textScreen.get("Developer"), new LabelStyle(FontTTF.getInstance().getFont40(), Color.WHITE)));
        text.put("Name", new Label(MarsGame.getLanguage().textScreen.get("Name"), new LabelStyle(FontTTF.getInstance().getFont40(), Color.WHITE)));
        text.put("Version", new Label(MarsGame.getLanguage().textScreen.get("Version"), style28));
        text.put("Site", new Label(MarsGame.getLanguage().textScreen.get("Site"), style28));
        text.put("GooglePlay", new Label(MarsGame.getLanguage().textScreen.get("GooglePlay"), style28));
        text.put("VK", new Label(MarsGame.getLanguage().textScreen.get("VK"), style28));
        text.put("Facebook", new Label(MarsGame.getLanguage().textScreen.get("Facebook"), style28));
        text.put("VKgroup", new Label(MarsGame.getLanguage().textScreen.get("VKgroup"), style28));
        text.put("Twitter", new Label(MarsGame.getLanguage().textScreen.get("Twitter"), style28));

        text.get("Menu").setPosition(320 * MarsGame.getRatioMonitorW() - text.get("Menu").getPrefWidth(), (356 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Developer").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("Developer").getPrefWidth() / 2,
                (416 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH() + text.get("Developer").getPrefHeight());
        text.get("Name").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("Name").getPrefWidth() / 2,
                (416 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Version").setPosition((MarsGame.WIDTH / 2 + 240) * MarsGame.getRatioMonitorW() - text.get("Version").getPrefWidth(),
                (352 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Site").setPosition((MarsGame.WIDTH / 2 - 182) * MarsGame.getRatioMonitorW() - text.get("Site").getPrefWidth(),
                (210 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("GooglePlay").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("GooglePlay").getPrefWidth() / 2,
                (180 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("VK").setPosition((MarsGame.WIDTH / 2 + 184) * MarsGame.getRatioMonitorW(),
                (210 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        text.get("Facebook").setPosition(580 * MarsGame.getRatioMonitorW() - text.get("Facebook").getPrefWidth(), (320 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("VKgroup").setPosition(580 * MarsGame.getRatioMonitorW() - text.get("VKgroup").getPrefWidth(), (565 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Twitter").setPosition(1325 * MarsGame.getRatioMonitorW(), (515 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("Developer"));
        stage.addActor(text.get("Name"));
        stage.addActor(text.get("Version"));
        stage.addActor(text.get("Menu"));
        stage.addActor(text.get("Site"));
        stage.addActor(text.get("GooglePlay"));
        stage.addActor(text.get("VK"));
        stage.addActor(text.get("Facebook"));
        stage.addActor(text.get("VKgroup"));
        stage.addActor(text.get("Twitter"));
    }

    @Override
    public void update(float deltaTime) {
        tv.update(deltaTime);
        r_7.update(deltaTime);
        angleMars -= deltaTime * 2;
        stars.update();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        stars.render(batch);
        batch.draw(Textures.getInstance().textureRegion.get("Mars"), MarsGame.WIDTH / 2 - 160, 604 + MarsGame.getRatioAdd(), 80, 80, 160, 160, 1, 1, angleMars);
        batch.draw(Textures.getInstance().textureRegion.get("FonBG"), 0, MarsGame.HEIGHT - 64 - MarsGame.getRatioAdd(), MarsGame.WIDTH, 64 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("FonSpaceshipDeck"), 0, 0 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("Terminal"), MarsGame.WIDTH / 2 - 576 / 2, 192 + MarsGame.getRatioAdd());

        if (!touchFacebook) batch.draw(Textures.getInstance().textureRegion.get("Facebook"), 589, 345 + MarsGame.getRatioAdd(), 96, 96);
        else batch.draw(Textures.getInstance().textureRegion.get("Facebook"), 595, 348 + MarsGame.getRatioAdd(), 90, 90);
        if (!touchVKgroup) batch.draw(Textures.getInstance().textureRegion.get("VK"), 589, 475 + MarsGame.getRatioAdd(), 96, 96);
        else batch.draw(Textures.getInstance().textureRegion.get("VK"), 595, 478 + MarsGame.getRatioAdd(), 90, 90);
        if (!touchTwitter) batch.draw(Textures.getInstance().textureRegion.get("Twitter"), 1233, 425 + MarsGame.getRatioAdd(), 96, 96);
        else batch.draw(Textures.getInstance().textureRegion.get("Twitter"), 1233, 428 + MarsGame.getRatioAdd(), 90, 90);

        batch.draw(Textures.getInstance().textureRegion.get("Fixing"), 650, 360 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("Fixing"), 650, 490 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("Fixing"), 1268, 440 + MarsGame.getRatioAdd(), -64, 64);

        if (!touchSite) batch.draw(Textures.getInstance().textureRegion.get("Site"), MarsGame.WIDTH / 2 - 160, 265 + MarsGame.getRatioAdd(), 60, 60);
        else batch.draw(Textures.getInstance().textureRegion.get("Site"), MarsGame.WIDTH / 2 - 157, 268 + MarsGame.getRatioAdd(), 54, 54);
        if (!touchGoogle) batch.draw(Textures.getInstance().textureRegion.get("Google"), MarsGame.WIDTH / 2 - 30, 265 + MarsGame.getRatioAdd(), 60, 60);
        else batch.draw(Textures.getInstance().textureRegion.get("Google"), MarsGame.WIDTH / 2 - 27, 268 + MarsGame.getRatioAdd(), 54, 54);
        if (!touchVK) batch.draw(Textures.getInstance().textureRegion.get("VKpage"), MarsGame.WIDTH / 2 + 98, 265 + MarsGame.getRatioAdd(), 60, 60);
        else batch.draw(Textures.getInstance().textureRegion.get("VKpage"), MarsGame.WIDTH / 2 + 101, 268 + MarsGame.getRatioAdd(), 54, 54);

        batch.draw(Textures.getInstance().textureRegion.get("FrameTop"), 0, MarsGame.HEIGHT - 256);
        if (MarsGame.getRatioAdd() > 120) batch.draw(Textures.getInstance().textureRegion.get("FrameBottom"), 0, 1 + MarsGame.getRatioAdd(), 1920, -64);
        batch.draw(Textures.getInstance().textureRegion.get("FrameBottom"), 0, 0 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("Home"), 320, 80 + MarsGame.getRatioAdd(), 96, 256);

        batch.draw(Textures.getInstance().textureRegion.get("DownLeft"), 580, 315 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("UpLeft"), 580, 535 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("UpRight"), 1265, 485 + MarsGame.getRatioAdd());

        batch.draw(Textures.getInstance().textureRegion.get("UpLeft"), 320, 320 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("DownLeft"), MarsGame.WIDTH / 2 - 182, 205 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("Down"), MarsGame.WIDTH / 2 - 25, 205 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("DownRight"), MarsGame.WIDTH / 2 + 120, 205 + MarsGame.getRatioAdd());
        batch.end();

        stage.act();
        stage.draw();
        r_7.render(batch);

        batch.begin();
        tv.render(batch, MarsGame.WIDTH / 2 - 260, 452 + MarsGame.getRatioAdd(), 257, 112, 0);
        tv.render(batch, MarsGame.WIDTH / 2 - 260, 340 + MarsGame.getRatioAdd(), 257, 112, 0);
        tv.render(batch, MarsGame.WIDTH / 2 - 3, 452 + MarsGame.getRatioAdd(), 257, 112, 0);
        tv.render(batch, MarsGame.WIDTH / 2 - 3, 340 + MarsGame.getRatioAdd(), 257, 112, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        try {
         //   MarsGame.getMusicSound().deleteRobotR7();
            stage.dispose();
            text.clear();
            buttons.clear();
            stars.dispose();
            r_7.dispose();
            tv.dispose();
            MarsGame.getLanguage().disposeText();
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
            if (name.equals("Facebook")) touchFacebook = true;
            else if (name.equals("VK")) touchVKgroup = true;
            else if (name.equals("Twitter")) touchTwitter = true;
            else if (name.equals("Site")) touchSite = true;
            else if (name.equals("Google")) touchGoogle = true;
            else if (name.equals("VKpage")) touchVK = true;
            return true;
        }

        @Override
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();

            if (name.equals("Facebook")) {
                touchFacebook = false;
                Gdx.net.openURI("https://www.facebook.com/groups/rashka.studio/");
            } else if (name.equals("VK")) {
                touchVKgroup = false;
                Gdx.net.openURI("https://vk.com/rashka.studio");
            } else if (name.equals("Twitter")) {
                touchTwitter = false;
                Gdx.net.openURI("https://twitter.com/rashka_studio/");
            } else if (name.equals("Home")) {
                game.set(new Loading(game, "Menu"));
            } else if (name.equals("Site")) {
                touchSite = false;
                Gdx.net.openURI("http://rashka.studio/");
            } else if (name.equals("Google")) {
                touchGoogle = false;
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=studio.rashka.mars2222");
            } else if (name.equals("VKpage")) {
                touchVK = false;
                Gdx.net.openURI("https://vk.com/fobos_vrn");
            }
        }
    }
}