package studio.rashka.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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
import studio.rashka.models.bridge.TV;
import studio.rashka.models.robots.R_7;

public class BridgeScreen extends State {

    private Stage stage;
    private Map<String, Label> text;
    private float angleMars = 0;

    private Map<String, Buttons> buttons;
    private R_7 r_7;
    private TV tv;
    private Stars stars;
    private int money, mineral;
    private boolean isMoney = false, isMineral = false;

    private static final Drawable img = MarsGame.getTextures().getTextureButtonSkin().getDrawable("NULL");
    private static final LabelStyle style35 = new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE);

    public BridgeScreen(Game game) {
        super(game);
        tv = new TV();
        r_7 = new R_7();

        stage = new Stage();
        stars = new Stars();
        text = new HashMap<String, Label>();
        buttons = new HashMap<String, Buttons>();
        MarsGame.playServices.showAds(404);

        menuButtonsText();
        textPutGet();
        menuButtons();
        r_7.setX(MarsGame.WIDTH / 2);
        r_7.setAddToMove(MarsGame.WIDTH / 2 + 128);
        r_7.setY(96);
        r_7.setMove(1);
        stage.addActor(r_7.getClick());

        adsButtons();
        Gdx.input.setInputProcessor(stage);

        money = MarsGame.getPreference().loadMoney();
        mineral = MarsGame.getPreference().loadMineral();
    }

    private void textPutGet() {
        text.put("Money", new Label(String.valueOf(MarsGame.getPreference().loadMoney()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.MAGENTA)));
        text.put("Mineral", new Label(String.valueOf(MarsGame.getPreference().loadMineral()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.GREEN)));
        text.put("GetMoney", new Label("+1000", style35));
        text.put("GetMineral", new Label("+20", style35));
        text.put("ShieldHPAdd", new Label(MarsGame.getLanguage().textScreen.get("ShieldHPAdd"), style35));
        text.put("EnergyAdd", new Label(MarsGame.getLanguage().textScreen.get("EnergyAdd"), style35));
        text.put("Microwave", new Label(MarsGame.getLanguage().textScreen.get("Microwave"), style35));
        text.put("Smugglers", new Label(MarsGame.getLanguage().textScreen.get("Smugglers"), style35));

        text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
        text.get("Mineral").setPosition((MarsGame.WIDTH / 2 + 132) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
        text.get("GetMoney").setPosition(610 * MarsGame.getRatioMonitorW(), (400 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("GetMineral").setPosition((MarsGame.WIDTH - 610) * MarsGame.getRatioMonitorW() - text.get("GetMineral").getPrefWidth(), (400 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("ShieldHPAdd").setPosition((MarsGame.WIDTH / 2 - 225) * MarsGame.getRatioMonitorW() - text.get("ShieldHPAdd").getPrefWidth(), (600 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("EnergyAdd").setPosition((MarsGame.WIDTH / 2 - 50) * MarsGame.getRatioMonitorW() - text.get("EnergyAdd").getPrefWidth(), (460 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Microwave").setPosition((MarsGame.WIDTH / 2 + 225) * MarsGame.getRatioMonitorW(), (600 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Smugglers").setPosition(470 * MarsGame.getRatioMonitorW(), (210 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("Money"));
        stage.addActor(text.get("Mineral"));
        stage.addActor(text.get("GetMoney"));
        stage.addActor(text.get("GetMineral"));
        stage.addActor(text.get("ShieldHPAdd"));
        stage.addActor(text.get("EnergyAdd"));
        stage.addActor(text.get("Microwave"));
        stage.addActor(text.get("Smugglers"));
    }

    private void adsButtons() {
        buttons.put("Smugglers", new Buttons("Smugglers", img, 192, 192, 316, 140 + MarsGame.getRatioAdd()));
        buttons.put("GetMoney", new Buttons("GetMoney", img, 192, 100, 416, 440 + MarsGame.getRatioAdd()));
        buttons.put("GetMineral", new Buttons("GetMineral", img, 192, 100, MarsGame.WIDTH - 608, 440 + MarsGame.getRatioAdd()));
        buttons.put("ShieldHPAdd", new Buttons("ShieldHPAdd", img, 120, 75, MarsGame.WIDTH / 2 - 227, 517 + MarsGame.getRatioAdd()));
        buttons.put("EnergyAdd", new Buttons("EnergyAdd", img, 155, 100, MarsGame.WIDTH / 2 - 77, 505 + MarsGame.getRatioAdd()));
        buttons.put("Microwave", new Buttons("Microwave", img, 120, 75, MarsGame.WIDTH / 2 + 110, 517 + MarsGame.getRatioAdd()));

        buttons.get("Smugglers").addListener(new ButtonsInputListener(buttons.get("Smugglers").getName()));
        buttons.get("GetMoney").addListener(new ButtonsInputListener(buttons.get("GetMoney").getName()));
        buttons.get("GetMineral").addListener(new ButtonsInputListener(buttons.get("GetMineral").getName()));
        buttons.get("ShieldHPAdd").addListener(new ButtonsInputListener(buttons.get("ShieldHPAdd").getName()));
        buttons.get("EnergyAdd").addListener(new ButtonsInputListener(buttons.get("EnergyAdd").getName()));
        buttons.get("Microwave").addListener(new ButtonsInputListener(buttons.get("Microwave").getName()));

        stage.addActor(buttons.get("Smugglers"));
        stage.addActor(buttons.get("GetMoney"));
        stage.addActor(buttons.get("GetMineral"));
        stage.addActor(buttons.get("ShieldHPAdd"));
        stage.addActor(buttons.get("EnergyAdd"));
        stage.addActor(buttons.get("Microwave"));
    }

    private void menuButtonsText() {
        text.put("Hangar", new Label(MarsGame.getLanguage().textScreen.get("Hangar"), new LabelStyle(FontTTF.getInstance().getFont40(), Color.BLACK)));
        text.put("Bridge", new Label(MarsGame.getLanguage().textScreen.get("Bridge"), new LabelStyle(FontTTF.getInstance().getFont40(), Color.BLACK)));
        text.put("Arsenal", new Label(MarsGame.getLanguage().textScreen.get("Arsenal"), new LabelStyle(FontTTF.getInstance().getFont40(), Color.BLACK)));
        text.put("Laboratory", new Label(MarsGame.getLanguage().textScreen.get("Laboratory"), new LabelStyle(FontTTF.getInstance().getFont40(), Color.BLACK)));
        text.put("Reactor", new Label(MarsGame.getLanguage().textScreen.get("Reactor"), new LabelStyle(FontTTF.getInstance().getFont40(), Color.BLACK)));

        text.get("Hangar").setPosition((MarsGame.WIDTH / 2 - 384) * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Bridge").setPosition(text.get("Hangar").getX() + text.get("Hangar").getPrefWidth() + 32 * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Arsenal").setPosition(text.get("Bridge").getX() + text.get("Bridge").getPrefWidth() + 32 * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Laboratory").setPosition(text.get("Arsenal").getX() + text.get("Arsenal").getPrefWidth() + 32 * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Reactor").setPosition(text.get("Laboratory").getX() + text.get("Laboratory").getPrefWidth() + 32 * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("Hangar"));
        stage.addActor(text.get("Bridge"));
        stage.addActor(text.get("Arsenal"));
        stage.addActor(text.get("Laboratory"));
        stage.addActor(text.get("Reactor"));
    }

    private void menuButtons() {
        buttons.put("Hangar", new Buttons("Hangar", img, text.get("Hangar").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Hangar").getX() / MarsGame.getRatioMonitorW(), 68));
        buttons.put("Arsenal", new Buttons("Arsenal", img, text.get("Arsenal").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Arsenal").getX() / MarsGame.getRatioMonitorW(), 68));
        buttons.put("Laboratory", new Buttons("Laboratory", img, text.get("Laboratory").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Laboratory").getX() / MarsGame.getRatioMonitorW(), 68));
        buttons.put("Reactor", new Buttons("Reactor", img, text.get("Reactor").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Reactor").getX() / MarsGame.getRatioMonitorW(), 68));

        buttons.get("Hangar").addListener(new ButtonsInputListener(buttons.get("Hangar").getName()));
        buttons.get("Arsenal").addListener(new ButtonsInputListener(buttons.get("Arsenal").getName()));
        buttons.get("Laboratory").addListener(new ButtonsInputListener(buttons.get("Laboratory").getName()));
        buttons.get("Reactor").addListener(new ButtonsInputListener(buttons.get("Reactor").getName()));

        stage.addActor(buttons.get("Hangar"));
        stage.addActor(buttons.get("Arsenal"));
        stage.addActor(buttons.get("Laboratory"));
        stage.addActor(buttons.get("Reactor"));
    }

    private void menuButtonsRender(SpriteBatch batch) {
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Hangar").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Hangar").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Hangar").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Hangar").getX() + text.get("Hangar").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Bridge").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Bridge").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Bridge").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Bridge").getX() + text.get("Bridge").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuHere"), (text.get("Bridge").getX() + text.get("Bridge").getPrefWidth() / 2) / MarsGame.getRatioMonitorW() - 6, 115, 12, 12);

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Arsenal").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Arsenal").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Arsenal").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Arsenal").getX() + text.get("Arsenal").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Laboratory").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Laboratory").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Laboratory").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Laboratory").getX() + text.get("Laboratory").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Reactor").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Reactor").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Reactor").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Reactor").getX() + text.get("Reactor").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);
    }

    @Override
    public void update(float deltaTime) {
        tv.update(deltaTime);
        r_7.update(deltaTime);
        angleMars -= deltaTime * 2;
        stars.update();

        if (isMoney)
            if (MarsGame.getPreference().loadMoney() != money) {
                text.get("Money").setText(String.valueOf(MarsGame.getPreference().loadMoney()));
                money = MarsGame.getPreference().loadMoney();
                isMoney = false;
            }
        if (isMineral)
            if (MarsGame.getPreference().loadMineral() != mineral) {
                text.get("Mineral").setText(String.valueOf(MarsGame.getPreference().loadMineral()));
                mineral = MarsGame.getPreference().loadMineral();
                isMineral = false;
            }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        stars.render(batch);
        batch.draw(MarsGame.getTextures().textureRegion.get("Mars"), MarsGame.WIDTH / 2 - 80, 614 + MarsGame.getRatioAdd(), 80, 80, 160, 160, 1, 1, angleMars);
        batch.draw(MarsGame.getTextures().textureRegion.get("FonBG"), 0, MarsGame.HEIGHT - 64 - MarsGame.getRatioAdd(), MarsGame.WIDTH, 64 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("FonSpaceshipDeck"), 0, 0 + MarsGame.getRatioAdd());

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Pedestal"), MarsGame.WIDTH / 2 - 192, 160 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("TerminalCenter"), MarsGame.WIDTH / 2 - 256, 370 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("MonitorVideo"), 608, 340 + MarsGame.getRatioAdd(), -192, 256);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("MonitorVideo"), 508, 60 + MarsGame.getRatioAdd(), -192, 256);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("MonitorVideo"), MarsGame.WIDTH - 608, 340 + MarsGame.getRatioAdd());

        batch.draw(MarsGame.getTextures().textureRegion.get("PlayVideo"), 480, 450 + MarsGame.getRatioAdd(), 80, 80);
        batch.draw(MarsGame.getTextures().textureRegion.get("PlayVideo"), MarsGame.WIDTH - 545, 453 + MarsGame.getRatioAdd(), 80, 80);
        batch.draw(MarsGame.getTextures().textureRegion.get("PlayVideo"), MarsGame.WIDTH / 2 - 32, 525 + MarsGame.getRatioAdd(), 64, 64);
        batch.draw(MarsGame.getTextures().textureRegion.get("PlayVideo"), MarsGame.WIDTH / 2 - 192, 528 + MarsGame.getRatioAdd(), 48, 48);
        batch.draw(MarsGame.getTextures().textureRegion.get("PlayVideo"), MarsGame.WIDTH / 2 + 150, 528 + MarsGame.getRatioAdd(), 48, 48);

        tv.render(batch, 422, 447 + MarsGame.getRatioAdd(), 180, 90, 12);
        tv.render(batch, 322, 167 + MarsGame.getRatioAdd(), 180, 90, 12);
        tv.render(batch, MarsGame.WIDTH - 602, 447 + MarsGame.getRatioAdd(), 180, 90, -12);

        tv.render(batch, MarsGame.WIDTH / 2 - 77, 505 + MarsGame.getRatioAdd(), 154, 98, 0);
        tv.render(batch, MarsGame.WIDTH / 2 - 227, 517 + MarsGame.getRatioAdd(), 119, 76, 0);
        tv.render(batch, MarsGame.WIDTH / 2 + 110, 517 + MarsGame.getRatioAdd(), 119, 76, 0);

        batch.draw(MarsGame.getTextures().textureRegion.get("Money"), 562, 400 + MarsGame.getRatioAdd(), 40, 40);
        batch.draw(MarsGame.getTextures().textureRegion.get("Mineral"), MarsGame.WIDTH - 600, 400 + MarsGame.getRatioAdd(), 40, 40);

        batch.draw(MarsGame.getTextures().textureRegion.get("DownRight"), 500, 400 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), 400, 180 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("DownLeft"), MarsGame.WIDTH - 564, 400 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("DownLeft"), MarsGame.WIDTH / 2 - 48, 460 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("UpLeft"), MarsGame.WIDTH / 2 - 224, 572 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), MarsGame.WIDTH / 2 + 160, 572 + MarsGame.getRatioAdd());

        batch.draw(MarsGame.getTextures().textureRegion.get("FrameTop"), 0, MarsGame.HEIGHT - 256);
        if (MarsGame.getRatioAdd() > 120) batch.draw(MarsGame.getTextures().textureRegion.get("FrameBottom"), 0, 1 + MarsGame.getRatioAdd(), 1920, -64);
        batch.draw(MarsGame.getTextures().textureRegion.get("FrameBottom"), 0, 0 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("Money"), MarsGame.WIDTH / 2 - 116, MarsGame.HEIGHT - 110, 45, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("Mineral"), MarsGame.WIDTH / 2 + 70, MarsGame.HEIGHT - 114, 50, 50);
        batch.end();

        r_7.render(batch);

        batch.begin();
        menuButtonsRender(batch);
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
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

    private class ButtonsInputListener extends ClickListener {
        private String name;

        public ButtonsInputListener(String name) {
            this.name = name;
        }

        @Override
        public void clicked (InputEvent event, float x, float y) {

            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();

            if (name.equals("Smugglers")) game.set(new Loading(game, "Pirate"));
            else if (name.equals("GetMoney")) {
                MarsGame.playServices.showAds(1);
                isMoney = true;
            } else if (name.equals("GetMineral")) {
                MarsGame.playServices.showAds(2);
                isMineral = true;
            } else if (name.equals("ShieldHPAdd")) MarsGame.playServices.showAds(3);
            else if (name.equals("EnergyAdd")) MarsGame.playServices.showAds(4);
            else if (name.equals("Microwave")) MarsGame.playServices.showAds(5);
            else if (name.equals("Hangar")) game.set(new Loading(game, "Game"));
            else if (name.equals("Arsenal")) game.set(new Loading(game, "Arsenal"));
            else if (name.equals("Laboratory")) game.set(new Loading(game, "Laboratory"));
            else if (name.equals("Reactor")) game.set(new Loading(game, "Reactor"));
        }
    }
}