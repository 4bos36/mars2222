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
import studio.rashka.lib.implement.Buttons;
import studio.rashka.models.Loading;
import studio.rashka.models.Stars;
import studio.rashka.models.lightbulb.GreenLightbulb;
import studio.rashka.models.lightbulb.RedLightbulb;
import studio.rashka.models.lightbulb.YellowLightbulb;
import studio.rashka.models.monsters.WormCave;
import studio.rashka.models.robots.R_7;

public class HelpScreen extends State {

    private Stage stage;
    private Map<String, Label> text;
    private boolean isTouchMission = false, isTouchWeapon = false, isTouchMonster = false;
    private String showIs = "NONE";

    private Map<String, Buttons> buttons;
    private R_7 r_7;
    private RedLightbulb redLightbulb;
    private YellowLightbulb yellowLightbulb;
    private GreenLightbulb greenLightbulb;
    private Stars stars;
    private WormCave wormCave;

    private static final Drawable img = MarsGame.getTextures().getTextureButtonSkin().getDrawable("NULL");

    public HelpScreen(Game game) {
        super(game);
        redLightbulb = new RedLightbulb();
        yellowLightbulb = new YellowLightbulb();
        greenLightbulb = new GreenLightbulb();
        stars = new Stars();
        r_7 = new R_7();
        wormCave = new WormCave(MarsGame.WIDTH / 2 - 50, (int) (540 - 80 + MarsGame.getRatioAdd()), 1.2f, 90);

        stage = new Stage();
        text = new HashMap<String, Label>();
        buttons = new HashMap<String, Buttons>();

        text.put("Menu", new Label(MarsGame.getLanguage().textScreen.get("Menu"), new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("1", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("2", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("3", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("4", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("5", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));

        buttons();
        textLoading();
        r_7.setX(-150);
        r_7.setY(96);
        r_7.setMove(1);
        stage.addActor(r_7.getClick());

        stage.addActor(text.get("Menu"));
        stage.addActor(text.get("1"));
        stage.addActor(text.get("2"));
        stage.addActor(text.get("3"));
        stage.addActor(text.get("4"));
        stage.addActor(text.get("5"));
    }

    private void buttons() {
        buttons.put("Home", new Buttons("Home", img, 108, 128, MarsGame.WIDTH - 155, 272 + MarsGame.getRatioAdd()));
        buttons.put("Mission", new Buttons("Mission", img, 128, 128, MarsGame.WIDTH / 2 - 224, 64 + MarsGame.getRatioAdd()));
        buttons.put("Weapon", new Buttons("Weapon", img, 128, 128, MarsGame.WIDTH / 2 - 64, 64 + MarsGame.getRatioAdd()));
        buttons.put("Monster", new Buttons("Monster", img, 128, 128, MarsGame.WIDTH / 2 + 96, 64 + MarsGame.getRatioAdd()));

        buttons.get("Home").addListener(new ButtonsInputListener(buttons.get("Home").getName()));
        buttons.get("Mission").addListener(new ButtonsInputListener(buttons.get("Mission").getName()));
        buttons.get("Weapon").addListener(new ButtonsInputListener(buttons.get("Weapon").getName()));
        buttons.get("Monster").addListener(new ButtonsInputListener(buttons.get("Monster").getName()));

        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("Mission"));
        stage.addActor(buttons.get("Weapon"));
        stage.addActor(buttons.get("Monster"));
        Gdx.input.setInputProcessor(stage);
    }

    private void textLoading() {
        text.get("Menu").setText(MarsGame.getLanguage().textScreen.get("Menu"));
        text.get("Menu").setPosition((MarsGame.WIDTH - 160) * MarsGame.getRatioMonitorW() - text.get("Menu").getPrefWidth(), (450 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
    }

    @Override
    public void update(float deltaTime) {
        redLightbulb.update(deltaTime);
        yellowLightbulb.update(deltaTime);
        stars.update();
        r_7.update(deltaTime);
        if (showIs.equals("Mission")) greenLightbulb.update(deltaTime);
        else if (showIs.equals("Monster")) wormCave.update();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        stars.render(batch);
        batch.draw(MarsGame.getTextures().textureRegion.get("Goal_l"), MarsGame.WIDTH / 2 - 434, 224 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("Goal_r"), MarsGame.WIDTH / 2 - 28, 224 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("Fon"), 0, 0 + MarsGame.getRatioAdd());
        yellowLightbulb.render(batch, 200, 292 + MarsGame.getRatioAdd(), 180, 16);
        yellowLightbulb.render(batch, 200, 694 + MarsGame.getRatioAdd(), 180, 16);
        yellowLightbulb.render(batch, MarsGame.WIDTH - 385, 292 + MarsGame.getRatioAdd(), 180, 16);
        yellowLightbulb.render(batch, MarsGame.WIDTH - 385, 694 + MarsGame.getRatioAdd(), 180, 16);
        redLightbulb.render(batch, 553, 564 + MarsGame.getRatioAdd(), 16, 16);
        redLightbulb.render(batch, 553, 612 + MarsGame.getRatioAdd(), 16, 16);
        redLightbulb.render(batch, 1359, 366 + MarsGame.getRatioAdd(), 16, 16);

        batch.draw(MarsGame.getTextures().textureRegion.get("Monitor"), MarsGame.WIDTH / 2 - 352, 256 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("FrameTopBG"), MarsGame.WIDTH / 2 - 96, MarsGame.HEIGHT - 340 - MarsGame.getRatioAdd(), 96, 224, 192, 448, 1, 1, 90);
        batch.draw(MarsGame.getTextures().textureRegion.get("FrameTop"), 0, MarsGame.HEIGHT - 256);
        if (MarsGame.getRatioAdd() > 120) batch.draw(MarsGame.getTextures().textureRegion.get("FrameBottom"), 0, 1 + MarsGame.getRatioAdd(), 1920, -64);
        batch.draw(MarsGame.getTextures().textureRegion.get("FrameBottom"), 0, 0 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("Home"), MarsGame.WIDTH - 160, 160 + MarsGame.getRatioAdd(), 96, 256);

        batch.draw(MarsGame.getTextures().textureRegion.get("UpLeft"), MarsGame.WIDTH - 160, 400 + MarsGame.getRatioAdd());

        if (!isTouchMission) batch.draw(MarsGame.getTextures().textureRegion.get("HelpMission"), MarsGame.WIDTH / 2 - 224, 64 + MarsGame.getRatioAdd());
        else batch.draw(MarsGame.getTextures().textureRegion.get("HelpMission"), MarsGame.WIDTH / 2 - 222, 66 + MarsGame.getRatioAdd(), 124, 124);
        if (!isTouchWeapon) batch.draw(MarsGame.getTextures().textureRegion.get("HelpWeapon"), MarsGame.WIDTH / 2 - 64, 64 + MarsGame.getRatioAdd());
        else batch.draw(MarsGame.getTextures().textureRegion.get("HelpWeapon"), MarsGame.WIDTH / 2 - 62, 66 + MarsGame.getRatioAdd(), 124, 124);
        if (!isTouchMonster) batch.draw(MarsGame.getTextures().textureRegion.get("HelpMonster"), MarsGame.WIDTH / 2 + 96, 64 + MarsGame.getRatioAdd());
        else batch.draw(MarsGame.getTextures().textureRegion.get("HelpMonster"), MarsGame.WIDTH / 2 + 98, 66 + MarsGame.getRatioAdd(), 124, 124);

        if (showIs.equals("Mission")) {
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("ButtonsMission"), MarsGame.WIDTH / 2 - 96, 356 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("ButtonMissionRed"), MarsGame.WIDTH / 2 - 96 + 15, 356 + MarsGame.getRatioAdd() + 98);
            greenLightbulb.render(batch, MarsGame.WIDTH / 2 - 96 + 14, 356 + MarsGame.getRatioAdd() + 170, 12, 12);
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("ButtonMissionBlue"), MarsGame.WIDTH / 2 - 96 + 176, 356 + MarsGame.getRatioAdd() + 98, -80, 80);
            greenLightbulb.render(batch, MarsGame.WIDTH / 2 - 96 + 166, 356 + MarsGame.getRatioAdd() + 170, 12, 12);
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("ButtonMissionGreen"), MarsGame.WIDTH / 2 - 96 + 15, 356 + MarsGame.getRatioAdd() + 97, 80, -80);
            greenLightbulb.render(batch, MarsGame.WIDTH / 2 - 96 + 15, 356 + MarsGame.getRatioAdd() + 11, 12, 12);
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("ButtonMissionTurquoise"), MarsGame.WIDTH / 2 - 96 + 176, 356 + MarsGame.getRatioAdd() + 97, -80, -80);
            greenLightbulb.render(batch, MarsGame.WIDTH / 2 - 96 + 165, 356 + MarsGame.getRatioAdd() + 12, 12, 12);

            batch.draw(MarsGame.getTextures().textureRegion.get("UpLeft"), MarsGame.WIDTH / 2 - 100, 500 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("DownLeft"), MarsGame.WIDTH / 2 - 100, 340 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), MarsGame.WIDTH / 2 + 40, 500 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("DownRight"), MarsGame.WIDTH / 2 + 40, 340 + MarsGame.getRatioAdd());
        } else if (showIs.equals("Weapon")) {
            batch.draw(MarsGame.getTextures().textureRegion.get("IconWeapon"), MarsGame.WIDTH / 2 - 128, 420 + MarsGame.getRatioAdd(), 128, 32, 256, 64, 1, 1, -90);
            batch.draw(MarsGame.getTextures().textureRegion.get("UpLeft"), MarsGame.WIDTH / 2 - 60, 540 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("DownLeft"), MarsGame.WIDTH / 2 - 60, 430 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), MarsGame.WIDTH / 2, 470 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("DownRight"), MarsGame.WIDTH / 2, 360 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("DownLeft"), MarsGame.WIDTH / 2 - 60, 300 + MarsGame.getRatioAdd());
        } else if (showIs.equals("Monster")) {
            wormCave.renderHelp();
            batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), MarsGame.WIDTH / 2, 525 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("DownLeft"), MarsGame.WIDTH / 2 - 130, 360 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("DownRight"), MarsGame.WIDTH / 2, 335 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("DownRight"), MarsGame.WIDTH / 2 + 45, 385 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), MarsGame.WIDTH / 2 + 14, 460 + MarsGame.getRatioAdd());
        }
        batch.end();
        r_7.render(batch);

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
            stage.dispose();
            text.clear();
            buttons.clear();
            redLightbulb.dispose();
            yellowLightbulb.dispose();
            greenLightbulb.dispose();
            stars.dispose();
            r_7.dispose();
            wormCave.dispose();
            MarsGame.getMusicSound().disposeSounds();
            MarsGame.getLanguage().disposeText();
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
            if (name.equals("Mission")) isTouchMission = true;
            else if (name.equals("Weapon")) isTouchWeapon = true;
            else if (name.equals("Monster")) isTouchMonster = true;
            return true;
        }

        @Override
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            if (name.equals("Home")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Menu"));
            } else if (name.equals("Mission")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                isTouchMission = false;
                showIs = "Mission";
                text.get("1").setText(MarsGame.getLanguage().textScreen.get("CompleteMission"));
                text.get("3").setText(MarsGame.getLanguage().textScreen.get("CompleteCrystals"));
                text.get("2").setText(MarsGame.getLanguage().textScreen.get("CompleteIntact"));
                text.get("4").setText(MarsGame.getLanguage().textScreen.get("CompleteDieWormCave"));
                text.get("5").setText("");

                text.get("1").setPosition((MarsGame.WIDTH / 2 - 25) * MarsGame.getRatioMonitorW() - text.get("1").getPrefWidth(), (570 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                text.get("3").setPosition((MarsGame.WIDTH / 2 - 25) * MarsGame.getRatioMonitorW() - text.get("3").getPrefWidth(), (335 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                text.get("2").setPosition((MarsGame.WIDTH / 2 + 25) * MarsGame.getRatioMonitorW(), (570 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                text.get("4").setPosition((MarsGame.WIDTH / 2 + 25) * MarsGame.getRatioMonitorW(), (335 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            } else if (name.equals("Weapon")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                isTouchWeapon = false;
                showIs = "Weapon";
                text.get("1").setText(MarsGame.getLanguage().textScreen.get("ShotPower"));
                text.get("2").setText(MarsGame.getLanguage().textScreen.get("RateOfFire"));
                text.get("3").setText(MarsGame.getLanguage().textScreen.get("RechargeTime"));
                text.get("4").setText(MarsGame.getLanguage().textScreen.get("ShotRange"));
                text.get("5").setText(MarsGame.getLanguage().textScreen.get("ShotDistance"));

                text.get("1").setPosition((MarsGame.WIDTH / 2 - 65) * MarsGame.getRatioMonitorW() - text.get("1").getPrefWidth(), (590 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                text.get("2").setPosition((MarsGame.WIDTH / 2 - 65) * MarsGame.getRatioMonitorW() - text.get("2").getPrefWidth(), (450 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                text.get("3").setPosition((MarsGame.WIDTH / 2 + 65) * MarsGame.getRatioMonitorW(), (520 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                text.get("4").setPosition((MarsGame.WIDTH / 2 + 65) * MarsGame.getRatioMonitorW(), (380 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                text.get("5").setPosition((MarsGame.WIDTH / 2 - 65) * MarsGame.getRatioMonitorW() - text.get("5").getPrefWidth(), (320 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            } else if (name.equals("Monster")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                isTouchMonster = false;
                showIs = "Monster";
                text.get("1").setText(MarsGame.getLanguage().textScreen.get("Hide"));
                text.get("2").setText(MarsGame.getLanguage().textScreen.get("Feet"));
                text.get("3").setText(MarsGame.getLanguage().textScreen.get("Feet"));
                text.get("4").setText(MarsGame.getLanguage().textScreen.get("Scrotum"));
                text.get("5").setText(MarsGame.getLanguage().textScreen.get("Immunity"));

                text.get("1").setPosition((MarsGame.WIDTH / 2 - 130) * MarsGame.getRatioMonitorW() - text.get("1").getPrefWidth(), (380 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                text.get("2").setPosition((MarsGame.WIDTH / 2 + 65) * MarsGame.getRatioMonitorW(), (575 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                text.get("3").setPosition((MarsGame.WIDTH / 2 + 65) * MarsGame.getRatioMonitorW(), (355 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                text.get("4").setPosition((MarsGame.WIDTH / 2 + 80) * MarsGame.getRatioMonitorW(), (510 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                text.get("5").setPosition((MarsGame.WIDTH / 2 + 110) * MarsGame.getRatioMonitorW(), (405 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            }
        }
    }
}