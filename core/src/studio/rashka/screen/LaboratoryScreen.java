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
import com.badlogic.gdx.utils.StringBuilder;

import java.util.HashMap;
import java.util.Map;

import studio.rashka.MarsGame;
import studio.rashka.lib.FontTTF;
import studio.rashka.lib.Game;
import studio.rashka.lib.State;
import studio.rashka.lib.implement.Buttons;
import studio.rashka.models.Loading;
import studio.rashka.models.Stars;
import studio.rashka.models.laboratory.Chemicals;

public class LaboratoryScreen extends State {

    private static final int DOWN = 0, UP = 1;
    private static final int NONE = 0, FIRE = 1, ICE = 2, POISON = 3;
    private int showMonitor = DOWN, showBuy = NONE;

    private Stage stage;
    private Map<String, Label> text;
    private boolean isShowMonitor = false, isNotClick = false;
    private float angleMars = 0, angleMonitor = -180;

    private Chemicals chemicals;
    private Stars stars;

    private Map<String, Buttons> buttons;
    private static final Drawable img = MarsGame.getTextures().getTextureButtonSkin().getDrawable("NULL");

    public LaboratoryScreen(Game game) {
        super(game);
        chemicals = new Chemicals();

        stage = new Stage();
        stars = new Stars();
        text = new HashMap<String, Label>();
        buttons = new HashMap<String, Buttons>();
        textPutGet();
        textLoading();
        menuButtons();
        buttons();
        Gdx.input.setInputProcessor(stage);
    }

    private void textPutGet() {
        text.put("Money", new Label(String.valueOf(MarsGame.getPreference().loadMoney()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.MAGENTA)));
        text.put("Mineral", new Label(String.valueOf(MarsGame.getPreference().loadMineral()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.GREEN)));
        text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
        text.get("Mineral").setPosition((MarsGame.WIDTH / 2 + 132) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("Money"));
        stage.addActor(text.get("Mineral"));

        text.put("Info", new Label("", new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));
        text.put("SwitchOff", new Label("", new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));
        text.put("Damage", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("Cooldown", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("CurrentPower", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("NextPower", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("BuyPower", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("CurrentTime", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("NextTime", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("BuyTime", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("PricePower", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("PriceTime", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.get("Info").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("SwitchOff").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("Damage").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("Cooldown").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("CurrentPower").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("NextPower").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("BuyPower").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("CurrentTime").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("NextTime").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("BuyTime").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("PricePower").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("PriceTime").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
    }

    private void buttons() {
        buttons.put("Hydrogen", new Buttons("Hydrogen", img, 80, 80, MarsGame.WIDTH / 2 - 480, 245 + MarsGame.getRatioAdd()));
        buttons.put("Refrigerant", new Buttons("Refrigerant", img, 64, 64, MarsGame.WIDTH / 2 - 85, 300 + MarsGame.getRatioAdd()));
        buttons.put("Zoman", new Buttons("Zoman", img, 92, 92, MarsGame.WIDTH / 2 + 280, 238 + MarsGame.getRatioAdd()));
        buttons.put("Info1", new Buttons("Info1", img, 200, 340, MarsGame.WIDTH / 2 - 490, 335 + MarsGame.getRatioAdd()));
        buttons.put("Info2", new Buttons("Info2", img, 165, 300, MarsGame.WIDTH / 2 - 90, 375 + MarsGame.getRatioAdd()));
        buttons.put("Info3", new Buttons("Info3", img, 210, 370, MarsGame.WIDTH / 2 + 280, 330 + MarsGame.getRatioAdd()));
        buttons.put("Close", new Buttons("Close", img, 200, 60, 0, 256 + MarsGame.getRatioAdd()));
        buttons.put("BuyDamage", new Buttons("BuyDamage", img, 192, 60, 0, text.get("BuyPower").getY() / MarsGame.getRatioMonitorH()));
        buttons.put("BuyCooldown", new Buttons("BuyCooldown", img, 192, 60, 0, text.get("BuyTime").getY() / MarsGame.getRatioMonitorH()));

        buttons.get("Hydrogen").addListener(new ButtonsInputListener(buttons.get("Hydrogen").getName()));
        buttons.get("Refrigerant").addListener(new ButtonsInputListener(buttons.get("Refrigerant").getName()));
        buttons.get("Zoman").addListener(new ButtonsInputListener(buttons.get("Zoman").getName()));
        buttons.get("Info1").addListener(new ButtonsInputListener(buttons.get("Info1").getName()));
        buttons.get("Info2").addListener(new ButtonsInputListener(buttons.get("Info2").getName()));
        buttons.get("Info3").addListener(new ButtonsInputListener(buttons.get("Info3").getName()));
        buttons.get("Close").addListener(new ButtonsInputListener(buttons.get("Close").getName()));
        buttons.get("BuyDamage").addListener(new ButtonsInputListener(buttons.get("BuyDamage").getName()));
        buttons.get("BuyCooldown").addListener(new ButtonsInputListener(buttons.get("BuyCooldown").getName()));

        stage.addActor(buttons.get("Info1"));
        stage.addActor(buttons.get("Info2"));
        stage.addActor(buttons.get("Info3"));
        stage.addActor(buttons.get("Close"));
        stage.addActor(buttons.get("BuyDamage"));
        stage.addActor(buttons.get("BuyCooldown"));
        stage.addActor(buttons.get("Hydrogen"));
        stage.addActor(buttons.get("Refrigerant"));
        stage.addActor(buttons.get("Zoman"));
        stage.addActor(text.get("Info"));
        stage.addActor(text.get("SwitchOff"));
        stage.addActor(text.get("Damage"));
        stage.addActor(text.get("Cooldown"));
        stage.addActor(text.get("CurrentPower"));
        stage.addActor(text.get("NextPower"));
        stage.addActor(text.get("PricePower"));
        stage.addActor(text.get("BuyPower"));
        stage.addActor(text.get("CurrentTime"));
        stage.addActor(text.get("NextTime"));
        stage.addActor(text.get("PriceTime"));
        stage.addActor(text.get("BuyTime"));
    }

    private void textLoading() {
        menuButtonsText();

        text.put("Hydrogen", new Label(MarsGame.getLanguage().textScreen.get("Hydrogen"), new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("Refrigerant", new Label(MarsGame.getLanguage().textScreen.get("Refrigerant"), new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("Zoman", new Label(MarsGame.getLanguage().textScreen.get("Zoman"), new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("Info1", new Label(MarsGame.getLanguage().textScreen.get("Info"), new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("Info2", new Label(MarsGame.getLanguage().textScreen.get("Info"), new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));
        text.put("Info3", new Label(MarsGame.getLanguage().textScreen.get("Info"), new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE)));

        text.get("Hydrogen").setPosition((MarsGame.WIDTH / 2 - 490) * MarsGame.getRatioMonitorW() - text.get("Hydrogen").getPrefWidth(), (210 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Refrigerant").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW(), (260 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Zoman").setPosition((MarsGame.WIDTH / 2 + 280) * MarsGame.getRatioMonitorW() - text.get("Zoman").getPrefWidth(), (200 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Info1").setPosition(684 * MarsGame.getRatioMonitorW(), (525 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Info2").setPosition((MarsGame.WIDTH / 2 + 96) * MarsGame.getRatioMonitorW(), (545 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Info3").setPosition((MarsGame.WIDTH / 2 + 504) * MarsGame.getRatioMonitorW(), (565 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("Hydrogen"));
        stage.addActor(text.get("Refrigerant"));
        stage.addActor(text.get("Zoman"));
        stage.addActor(text.get("Info1"));
        stage.addActor(text.get("Info2"));
        stage.addActor(text.get("Info3"));
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
        buttons.put("Bridge", new Buttons("Bridge", img, text.get("Bridge").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Bridge").getX() / MarsGame.getRatioMonitorW(), 68));
        buttons.put("Reactor", new Buttons("Reactor", img, text.get("Reactor").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Reactor").getX() / MarsGame.getRatioMonitorW(), 68));

        buttons.get("Hangar").addListener(new ButtonsInputListener(buttons.get("Hangar").getName()));
        buttons.get("Arsenal").addListener(new ButtonsInputListener(buttons.get("Arsenal").getName()));
        buttons.get("Bridge").addListener(new ButtonsInputListener(buttons.get("Bridge").getName()));
        buttons.get("Reactor").addListener(new ButtonsInputListener(buttons.get("Reactor").getName()));

        stage.addActor(buttons.get("Hangar"));
        stage.addActor(buttons.get("Bridge"));
        stage.addActor(buttons.get("Arsenal"));
        stage.addActor(buttons.get("Reactor"));
    }

    private void menuButtonsRender(SpriteBatch batch) {
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Hangar").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Hangar").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Hangar").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Hangar").getX() + text.get("Hangar").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Bridge").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Bridge").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Bridge").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Bridge").getX() + text.get("Bridge").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Arsenal").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Arsenal").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Arsenal").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Arsenal").getX() + text.get("Arsenal").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Laboratory").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Laboratory").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Laboratory").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Laboratory").getX() + text.get("Laboratory").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuHere"), (text.get("Laboratory").getX() + text.get("Laboratory").getPrefWidth() / 2) / MarsGame.getRatioMonitorW() - 6, 115, 12, 12);

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Reactor").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Reactor").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Reactor").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Reactor").getX() + text.get("Reactor").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);
    }

    private void angleMonitor(float deltaTime) {
        if (isShowMonitor) {
            if (showMonitor == DOWN) {
                text.get("Hydrogen").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 210 * MarsGame.getRatioMonitorH());
                text.get("Refrigerant").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 260 * MarsGame.getRatioMonitorH());
                text.get("Zoman").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 200 * MarsGame.getRatioMonitorH());
                text.get("Info1").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 525 * MarsGame.getRatioMonitorH());
                text.get("Info2").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("Info3").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 565 * MarsGame.getRatioMonitorH());
                angleMonitor += deltaTime * 120;
                if (angleMonitor >= 0) {
                    text.get("Info").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("Info").getPrefWidth() / 2, (724 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH() - text.get("Info").getPrefHeight());
                    text.get("Damage").setPosition((MarsGame.WIDTH / 2 - 160) * MarsGame.getRatioMonitorW() - text.get("Damage").getPrefWidth() / 2, (500 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH() - text.get("Damage").getPrefHeight());
                    text.get("Cooldown").setPosition((MarsGame.WIDTH / 2 + 160) * MarsGame.getRatioMonitorW() - text.get("Cooldown").getPrefWidth() / 2, (500 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH() - text.get("Cooldown").getPrefHeight());

                    text.get("CurrentPower").setPosition((MarsGame.WIDTH / 2 - 160) * MarsGame.getRatioMonitorW() - text.get("CurrentPower").getPrefWidth() / 2, (430 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("NextPower").setPosition((MarsGame.WIDTH / 2  - 160) * MarsGame.getRatioMonitorW() - text.get("NextPower").getPrefWidth() / 2, (400 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("BuyPower").setPosition((MarsGame.WIDTH / 2  - 160) * MarsGame.getRatioMonitorW() - text.get("BuyPower").getPrefWidth() / 2, (330 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("PricePower").setPosition((MarsGame.WIDTH / 2 - 160 + 22) * MarsGame.getRatioMonitorW() - text.get("PricePower").getPrefWidth() / 2, (370 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

                    text.get("CurrentTime").setPosition((MarsGame.WIDTH / 2  + 160) * MarsGame.getRatioMonitorW() - text.get("CurrentTime").getPrefWidth() / 2, (430 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("NextTime").setPosition((MarsGame.WIDTH / 2  + 160) * MarsGame.getRatioMonitorW() - text.get("NextTime").getPrefWidth() / 2, (400 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("BuyTime").setPosition((MarsGame.WIDTH / 2  + 160) * MarsGame.getRatioMonitorW() - text.get("BuyTime").getPrefWidth() / 2, (330 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("PriceTime").setPosition((MarsGame.WIDTH / 2 + 160 + 25) * MarsGame.getRatioMonitorW() - text.get("PriceTime").getPrefWidth() / 2, (370 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

                    text.get("SwitchOff").setPosition((MarsGame.WIDTH / 2 + 317) * MarsGame.getRatioMonitorW() - text.get("SwitchOff").getPrefWidth(), (280 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    buttons.get("BuyDamage").setPosition(text.get("BuyPower").getX() / MarsGame.getRatioMonitorW() - 50, text.get("BuyPower").getY() / MarsGame.getRatioMonitorH() - 30);
                    buttons.get("BuyCooldown").setPosition(text.get("BuyTime").getX() / MarsGame.getRatioMonitorW() - 50, text.get("BuyTime").getY() / MarsGame.getRatioMonitorH() - 30);
                    buttons.get("Close").setPosition(MarsGame.WIDTH / 2 + 125, 250 + MarsGame.getRatioAdd());
                    isShowMonitor = false;
                    angleMonitor = 0;
                    showMonitor = UP;
                }
            } else if (showMonitor == UP) {
                text.get("Info").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("Damage").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("Cooldown").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("CurrentPower").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("NextPower").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("BuyPower").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("CurrentTime").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("NextTime").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("BuyTime").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("PricePower").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("PriceTime").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("SwitchOff").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                buttons.get("BuyDamage").setPosition(0, text.get("BuyPower").getY() / MarsGame.getRatioMonitorH());
                buttons.get("BuyCooldown").setPosition(0, text.get("BuyTime").getY() / MarsGame.getRatioMonitorH());
                buttons.get("Close").setPosition(0, 256);
                angleMonitor -= deltaTime * 120;
                if (angleMonitor <= -180) {
                    isShowMonitor = false;
                    angleMonitor = -180;
                    showMonitor = DOWN;
                    isNotClick = false;
                    text.get("Hydrogen").setPosition((MarsGame.WIDTH / 2 - 490) * MarsGame.getRatioMonitorW() - text.get("Hydrogen").getPrefWidth(), (210 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("Refrigerant").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW(), (260 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("Zoman").setPosition((MarsGame.WIDTH / 2 + 280) * MarsGame.getRatioMonitorW() - text.get("Zoman").getPrefWidth(), (200 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("Info1").setPosition(684 * MarsGame.getRatioMonitorW(), (525 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("Info2").setPosition((MarsGame.WIDTH / 2 + 96) * MarsGame.getRatioMonitorW(), (540 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("Info3").setPosition((MarsGame.WIDTH / 2 + 504) * MarsGame.getRatioMonitorW(), (565 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                }
            }
        }
    }

    @Override
    public void update(float deltaTime) {
        angleMars -= deltaTime * 2;
        angleMonitor(deltaTime);
        chemicals.update(deltaTime);
        stars.update();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        stars.render(batch);
        batch.draw(MarsGame.getTextures().textureRegion.get("Mars"), MarsGame.WIDTH / 2 - 260, 650 + MarsGame.getRatioAdd(), 80, 80, 160, 160, 1, 1, angleMars);
        batch.draw(MarsGame.getTextures().textureRegion.get("FonBG"), 0, MarsGame.HEIGHT - 64 - MarsGame.getRatioAdd(), MarsGame.WIDTH, 64 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("FonSpaceshipDeck"), 0, 0 + MarsGame.getRatioAdd());

        chemicals.render(batch);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("LabCapsule"), MarsGame.WIDTH / 2 - 540, 160 + MarsGame.getRatioAdd(), 300, 840);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("LabCapsule"), MarsGame.WIDTH / 2 - 140, 220 + MarsGame.getRatioAdd(), 260, 728);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("LabCapsule"), MarsGame.WIDTH / 2 + 220, 145 + MarsGame.getRatioAdd(), 320, 896);

        if (angleMonitor <= -180) {
            batch.draw(MarsGame.getTextures().textureRegion.get("DownLeft"), 470, 210 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("DownRight"), MarsGame.WIDTH / 2 - 60, 260 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("DownLeft"), MarsGame.WIDTH / 2 + 280, 200 + MarsGame.getRatioAdd());

            batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), 620, 490 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), MarsGame.WIDTH / 2 + 32, 510 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), MarsGame.WIDTH / 2 + 440, 530 + MarsGame.getRatioAdd());
        }

        batch.draw(MarsGame.getTextures().textureRegion.get("FrameTopBG"), MarsGame.WIDTH / 2 - 396, MarsGame.HEIGHT - 250 - MarsGame.getRatioAdd(), 96, 224, 192, 448, 1, 1, 90);
        batch.draw(MarsGame.getTextures().textureRegion.get("FrameTopBG"), MarsGame.WIDTH / 2 + 204, MarsGame.HEIGHT - 250 - MarsGame.getRatioAdd(), 96, 224, 192, 448, 1, 1, 90);
        batch.draw(MarsGame.getTextures().textureRegion.get("Monitor"), MarsGame.WIDTH / 2 - 352, 256 + MarsGame.getRatioAdd(), 352, 692, 704, 692, 1, 1, angleMonitor);
        batch.draw(MarsGame.getTextures().textureRegion.get("FrameTopBG"), MarsGame.WIDTH / 2 - 96, MarsGame.HEIGHT - 340 - MarsGame.getRatioAdd(), 96, 224, 192, 448, 1, 1, 90);

        if (showMonitor == UP && !isShowMonitor && showBuy != NONE) {
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("LabBuyFon"), MarsGame.WIDTH / 2 - 288, 300 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("LabBuyFon"), MarsGame.WIDTH / 2 + 32, 300 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("Money"), text.get("PricePower").getX() / MarsGame.getRatioMonitorW() - 33, 357 + MarsGame.getRatioAdd(), 22, 22);
            batch.draw(MarsGame.getTextures().textureRegion.get("Mineral"), text.get("PriceTime").getX() / MarsGame.getRatioMonitorW() - 38, 356 + MarsGame.getRatioAdd(), 25, 25);

            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("BuyPower").getX() / MarsGame.getRatioMonitorW() - 10, text.get("BuyPower").getY() / MarsGame.getRatioMonitorH() - 19, text.get("BuyPower").getPrefWidth() / MarsGame.getRatioMonitorW() + 18, 39);
            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("BuyPower").getX() / MarsGame.getRatioMonitorW() - 12, text.get("BuyPower").getY() / MarsGame.getRatioMonitorH() - 22, 28, 45);
            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("BuyPower").getX() + text.get("BuyPower").getPrefWidth()) / MarsGame.getRatioMonitorW() - 17, text.get("BuyPower").getY() / MarsGame.getRatioMonitorH() - 22, 28, 45);

            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("BuyTime").getX() / MarsGame.getRatioMonitorW() - 10, text.get("BuyTime").getY() / MarsGame.getRatioMonitorH() - 19, text.get("BuyTime").getPrefWidth() / MarsGame.getRatioMonitorW() + 18, 39);
            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("BuyTime").getX() / MarsGame.getRatioMonitorW() - 12, text.get("BuyTime").getY() / MarsGame.getRatioMonitorH() - 22, 28, 45);
            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("BuyTime").getX() + text.get("BuyTime").getPrefWidth()) / MarsGame.getRatioMonitorW() - 17, text.get("BuyTime").getY() / MarsGame.getRatioMonitorH() - 22, 28, 45);
            if (showBuy == FIRE) {
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LabFirePower"), MarsGame.WIDTH / 2 - 208, 499 + MarsGame.getRatioAdd(), 96, 96);
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LabFireTime"), MarsGame.WIDTH / 2 + 112, 499 + MarsGame.getRatioAdd(), 96, 96);
            }
            else if (showBuy == ICE) {
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LabIcePower"), MarsGame.WIDTH / 2 - 208, 499 + MarsGame.getRatioAdd(), 96, 96);
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LabIceTime"), MarsGame.WIDTH / 2 + 112, 499 + MarsGame.getRatioAdd(), 96, 96);
            }
            else if (showBuy == POISON) {
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LabPoisonPower"), MarsGame.WIDTH / 2 - 208, 499 + MarsGame.getRatioAdd(), 96, 96);
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("LabPoisonTime"), MarsGame.WIDTH / 2 + 112, 499 + MarsGame.getRatioAdd(), 96, 96);
            }
        }
        batch.draw(MarsGame.getTextures().textureRegion.get("FrameTop"), 0, MarsGame.HEIGHT - 256);
        if (MarsGame.getRatioAdd() > 120) batch.draw(MarsGame.getTextures().textureRegion.get("FrameBottom"), 0, 1 + MarsGame.getRatioAdd(), 1920, -64);
        batch.draw(MarsGame.getTextures().textureRegion.get("FrameBottom"), 0, 0 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("Money"), MarsGame.WIDTH / 2 - 116, MarsGame.HEIGHT - 110, 45, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("Mineral"), MarsGame.WIDTH / 2 + 70, MarsGame.HEIGHT - 114, 50, 50);
        menuButtonsRender(batch);
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
            if (MarsGame.getMusicSound().musics.get("Laboratory").isPlaying()) MarsGame.getMusicSound().musics.get("Laboratory").stop();
          //  MarsGame.getMusicSound().deleteLaboratory();
            stage.dispose();
            text.clear();
            buttons.clear();
            stars.dispose();
            chemicals.dispose();
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
            if (name.equals("Hydrogen")) {
                //region
                if (!isNotClick) {
                    if (MarsGame.getPreference().loadSound() == 1) {
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        MarsGame.getMusicSound().sounds.get("MoveTerminal").play();
                    }
                    isShowMonitor = true;
                    isNotClick = true;
                    showBuy = FIRE;
                    text.get("Damage").setText(MarsGame.getLanguage().textScreen.get("Damage"));
                    text.get("Cooldown").setText(MarsGame.getLanguage().textScreen.get("Cooldown"));
                    text.get("CurrentPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadHydrogenDamage()));
                    text.get("NextPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadHydrogenDamage() + 5));
                    int priceUp = 1500 + (MarsGame.getPreference().loadHydrogenDamage() - 50) * 30;
                    text.get("PricePower").setText(Integer.toString(priceUp));
                    if (MarsGame.getPreference().loadMoney() < priceUp) text.get("PricePower").setColor(Color.RED);
                    text.get("BuyPower").setText(MarsGame.getLanguage().textScreen.get("Buy"));
                    text.get("CurrentTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadHydrogenCooldown()));
                    text.get("NextTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadHydrogenCooldown() - 1));
                    int priceUpM = 15 + (30 - MarsGame.getPreference().loadHydrogenCooldown()) * 30;
                    text.get("PriceTime").setText(Integer.toString(priceUpM));
                    if (MarsGame.getPreference().loadMineral() < priceUpM) text.get("PriceTime").setColor(Color.RED);
                    if (MarsGame.getPreference().loadHydrogenCooldown() <= 15) {
                        text.get("NextTime").setText(MarsGame.getLanguage().textScreen.get("Max"));
                        text.get("PriceTime").setText("-");
                        text.get("BuyTime").setColor(Color.RED);
                    }
                    text.get("BuyTime").setText(MarsGame.getLanguage().textScreen.get("Buy"));
                    text.get("SwitchOff").setText(MarsGame.getLanguage().textScreen.get("SwitchOff"));
                }
                //endregion
            } else if (name.equals("Refrigerant")) {
                //region
                if (!isNotClick) {
                    if (MarsGame.getPreference().loadSound() == 1) {
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        MarsGame.getMusicSound().sounds.get("MoveTerminal").play();
                    }
                    isShowMonitor = true;
                    isNotClick = true;
                    showBuy = ICE;
                    text.get("Damage").setText(MarsGame.getLanguage().textScreen.get("Damage"));
                    text.get("Cooldown").setText(MarsGame.getLanguage().textScreen.get("Cooldown"));
                    text.get("CurrentPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadRefrigerantDamage()));
                    text.get("NextPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadRefrigerantDamage() + 5));
                    int priceUp = 1500 + (MarsGame.getPreference().loadRefrigerantDamage() - 50) * 30;
                    text.get("PricePower").setText(Integer.toString(priceUp));
                    if (MarsGame.getPreference().loadMoney() < priceUp) text.get("PricePower").setColor(Color.RED);
                    text.get("BuyPower").setText(MarsGame.getLanguage().textScreen.get("Buy"));
                    text.get("CurrentTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadRefrigerantCooldown()));
                    text.get("NextTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadRefrigerantCooldown() - 1));
                    int priceUpM = 15 + (30 - MarsGame.getPreference().loadRefrigerantCooldown()) * 30;
                    text.get("PriceTime").setText(Integer.toString(priceUpM));
                    if (MarsGame.getPreference().loadMineral() < priceUpM) text.get("PriceTime").setColor(Color.RED);
                    if (MarsGame.getPreference().loadRefrigerantCooldown() <= 15) {
                        text.get("NextTime").setText(MarsGame.getLanguage().textScreen.get("Max"));
                        text.get("PriceTime").setText("-");
                        text.get("BuyTime").setColor(Color.RED);
                    }
                    text.get("BuyTime").setText(MarsGame.getLanguage().textScreen.get("Buy"));
                    text.get("SwitchOff").setText(MarsGame.getLanguage().textScreen.get("SwitchOff"));
                }
                //endregion
            } else if (name.equals("Zoman")) {
                //region
                if (!isNotClick) {
                    if (MarsGame.getPreference().loadSound() == 1) {
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        MarsGame.getMusicSound().sounds.get("MoveTerminal").play();
                    }
                    isShowMonitor = true;
                    isNotClick = true;
                    showBuy = POISON;
                    text.get("Damage").setText(MarsGame.getLanguage().textScreen.get("Damage"));
                    text.get("Cooldown").setText(MarsGame.getLanguage().textScreen.get("Cooldown"));
                    text.get("CurrentPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadZomanDamage()));
                    text.get("NextPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadZomanDamage() + 5));
                    int priceUp = 1500 + (MarsGame.getPreference().loadZomanDamage() - 50) * 30;
                    text.get("PricePower").setText(Integer.toString(priceUp));
                    if (MarsGame.getPreference().loadMoney() < priceUp) text.get("PricePower").setColor(Color.RED);
                    text.get("BuyPower").setText(MarsGame.getLanguage().textScreen.get("Buy"));
                    text.get("CurrentTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadZomanCooldown()));
                    text.get("NextTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadZomanCooldown() - 1));
                    int priceUpM = 15 + (30 - MarsGame.getPreference().loadZomanCooldown()) * 30;
                    text.get("PriceTime").setText(Integer.toString(priceUpM));
                    if (MarsGame.getPreference().loadMineral() < priceUpM) text.get("PriceTime").setColor(Color.RED);
                    if (MarsGame.getPreference().loadZomanCooldown() <= 15) {
                        text.get("NextTime").setText(MarsGame.getLanguage().textScreen.get("Max"));
                        text.get("PriceTime").setText("-");
                        text.get("BuyTime").setColor(Color.RED);
                    }
                    text.get("BuyTime").setText(MarsGame.getLanguage().textScreen.get("Buy"));
                    text.get("SwitchOff").setText(MarsGame.getLanguage().textScreen.get("SwitchOff"));
                }
                //endregion
            } else if (name.equals("Info1")) {
                //region
                if (!isNotClick) {
                    if (MarsGame.getPreference().loadSound() == 1) {
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        MarsGame.getMusicSound().sounds.get("MoveTerminal").play();
                    }
                    isShowMonitor = true;
                    isNotClick = true;
                    int i = 0;
                    StringBuilder textInfo = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("InfoHydrogen"));
                    while (i + 35 < textInfo.length() && (i = textInfo.lastIndexOf(" ", i + 35)) != -1) textInfo.replace(i, i + 1, "\n");
                    text.get("Info").setText(textInfo);
                    text.get("SwitchOff").setText(MarsGame.getLanguage().textScreen.get("SwitchOff"));
                }
                //endregion
            } else if (name.equals("Info2")) {
                //region
                if (!isNotClick) {
                    if (MarsGame.getPreference().loadSound() == 1) {
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        MarsGame.getMusicSound().sounds.get("MoveTerminal").play();
                    }
                    isShowMonitor = true;
                    isNotClick = true;
                    int i = 0;
                    StringBuilder textInfo = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("InfoRefrigerant"));
                    while (i + 35 < textInfo.length() && (i = textInfo.lastIndexOf(" ", i + 35)) != -1) textInfo.replace(i, i + 1, "\n");
                    text.get("Info").setText(textInfo);
                    text.get("SwitchOff").setText(MarsGame.getLanguage().textScreen.get("SwitchOff"));
                }
                //endregion
            } else if (name.equals("Info3")) {
                //region
                if (!isNotClick) {
                    if (MarsGame.getPreference().loadSound() == 1) {
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        MarsGame.getMusicSound().sounds.get("MoveTerminal").play();
                    }
                    isShowMonitor = true;
                    isNotClick = true;
                    int i = 0;
                    StringBuilder textInfo = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("InfoZoman"));
                    while (i + 35 < textInfo.length() && (i = textInfo.lastIndexOf(" ", i + 35)) != -1) textInfo.replace(i, i + 1, "\n");
                    text.get("Info").setText(textInfo);
                    text.get("SwitchOff").setText(MarsGame.getLanguage().textScreen.get("SwitchOff"));
                }
                //endregion
            } else if (name.equals("Close")) {
                //region
                if (angleMonitor == 0) {
                    if (MarsGame.getPreference().loadSound() == 1) {
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        MarsGame.getMusicSound().sounds.get("MoveTerminal").play();
                    }
                    isShowMonitor = true;
                    showBuy = NONE;
                    text.get("Info").setText("");
                    text.get("Damage").setText("");
                    text.get("Cooldown").setText("");
                    text.get("CurrentPower").setText("");
                    text.get("NextPower").setText("");
                    text.get("BuyPower").setText("");
                    text.get("CurrentTime").setText("");
                    text.get("NextTime").setText("");
                    text.get("BuyTime").setText("");
                    text.get("BuyTime").setColor(Color.WHITE);
                    text.get("SwitchOff").setText("");
                    text.get("PricePower").setText("");
                    text.get("PriceTime").setText("");
                    text.get("PriceTime").setColor(Color.WHITE);
                }
                //endregion
            } else if (name.equals("BuyDamage")) {
                //region
                if (angleMonitor == 0 && showBuy != NONE) {
                    if (showBuy == FIRE) {
                        int priceUp = 1500 + (MarsGame.getPreference().loadHydrogenDamage() - 50) * 30;
                        if (MarsGame.getPreference().loadMoney() >= priceUp) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            MarsGame.getPreference().saveHydrogenDamage(5, -priceUp);

                            MarsGame.getPreference().setEventSpentMoney(priceUp);
                            MarsGame.getPreference().setAchievementMoneyRemove(MarsGame.getPreference().getEventSpentMoney());
                            MarsGame.getPreference().setAchievementFire();

                            text.get("Money").setText(String.valueOf(MarsGame.getPreference().loadMoney()));
                            text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
                            text.get("CurrentPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadHydrogenDamage()));
                            text.get("NextPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadHydrogenDamage() + 5));
                            priceUp = 1500 + (MarsGame.getPreference().loadHydrogenDamage() - 50) * 30;
                            text.get("PricePower").setText(Integer.toString(priceUp));
                        } else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                            text.get("PricePower").setColor(Color.RED);
                        }
                    } else if (showBuy == ICE) {
                        int priceUp = 1500 + (MarsGame.getPreference().loadRefrigerantDamage() - 50) * 30;
                        if (MarsGame.getPreference().loadMoney() >= priceUp) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            MarsGame.getPreference().saveRefrigerantDamage(5, -priceUp);

                            MarsGame.getPreference().setEventSpentMoney(priceUp);
                            MarsGame.getPreference().setAchievementMoneyRemove(MarsGame.getPreference().getEventSpentMoney());
                            MarsGame.getPreference().setAchievementCold();

                            text.get("Money").setText(String.valueOf(MarsGame.getPreference().loadMoney()));
                            text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
                            text.get("CurrentPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadRefrigerantDamage()));
                            text.get("NextPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadRefrigerantDamage() + 5));
                            priceUp = 1500 + (MarsGame.getPreference().loadRefrigerantDamage() - 50) * 30;
                            text.get("PricePower").setText(Integer.toString(priceUp));
                        } else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                            text.get("PricePower").setColor(Color.RED);
                        }
                    } else if (showBuy == POISON) {
                        int priceUp = 1500 + (MarsGame.getPreference().loadZomanDamage() - 50) * 30;
                        if (MarsGame.getPreference().loadMoney() >= priceUp) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            MarsGame.getPreference().saveZomanDamage(5, -priceUp);

                            MarsGame.getPreference().setEventSpentMoney(priceUp);
                            MarsGame.getPreference().setAchievementMoneyRemove(MarsGame.getPreference().getEventSpentMoney());
                            MarsGame.getPreference().setAchievementPoison();

                            text.get("Money").setText(String.valueOf(MarsGame.getPreference().loadMoney()));
                            text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
                            text.get("CurrentPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadZomanDamage()));
                            text.get("NextPower").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadZomanDamage() + 5));
                            priceUp = 1500 + (MarsGame.getPreference().loadZomanDamage() - 50) * 30;
                            text.get("PricePower").setText(Integer.toString(priceUp));
                        } else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                            text.get("PricePower").setColor(Color.RED);
                        }
                    }
                }
                //endregion
            } else if (name.equals("BuyCooldown")) {
                //region
                if (angleMonitor == 0 && showBuy != NONE) {
                    if (showBuy == FIRE) {
                        int priceUpM = 15 + (30 - MarsGame.getPreference().loadHydrogenCooldown()) * 30;
                        if (MarsGame.getPreference().loadMineral() >= priceUpM) {
                            if (MarsGame.getPreference().loadHydrogenCooldown() > 15) {
                                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                                MarsGame.getPreference().saveHydrogenCooldown(-1, -priceUpM);

                                MarsGame.getPreference().setEventSpentMinerals(priceUpM);
                                MarsGame.getPreference().setAchievementMineralRemove(MarsGame.getPreference().getEventSpentMinerals());

                                text.get("Mineral").setText(String.valueOf(MarsGame.getPreference().loadMineral()));
                                text.get("CurrentTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadHydrogenCooldown()));
                                priceUpM = 15 + (30 - MarsGame.getPreference().loadHydrogenCooldown()) * 30;
                                text.get("PriceTime").setText(Integer.toString(priceUpM));
                                if (MarsGame.getPreference().loadHydrogenCooldown() <= 15) {
                                    MarsGame.getPreference().setAchievementRestorationOfFire();
                                    text.get("NextTime").setText(MarsGame.getLanguage().textScreen.get("Max"));
                                    text.get("PriceTime").setText("-");
                                    text.get("BuyTime").setColor(Color.RED);
                                    text.get("NextTime").setPosition((MarsGame.WIDTH / 2 + 160) * MarsGame.getRatioMonitorW() - text.get("NextTime").getPrefWidth() / 2, (400 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                                } else text.get("NextTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadHydrogenCooldown() - 1));
                            } else if (MarsGame.getPreference().loadHydrogenCooldown() <= 15) {
                                if (MarsGame.getPreference().loadSound() == 1)
                                    MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                            }
                        } else if (MarsGame.getPreference().loadMineral() < priceUpM) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (showBuy == ICE) {
                        int priceUpM = 15 + (30 - MarsGame.getPreference().loadRefrigerantCooldown()) * 30;
                        if (MarsGame.getPreference().loadMineral() >= priceUpM) {
                            if (MarsGame.getPreference().loadRefrigerantCooldown() > 15) {
                                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                                MarsGame.getPreference().saveRefrigerantCooldown(-1, -priceUpM);

                                MarsGame.getPreference().setEventSpentMinerals(priceUpM);
                                MarsGame.getPreference().setAchievementMineralRemove(MarsGame.getPreference().getEventSpentMinerals());

                                text.get("Mineral").setText(String.valueOf(MarsGame.getPreference().loadMineral()));
                                text.get("CurrentTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadRefrigerantCooldown()));
                                priceUpM = 15 + (30 - MarsGame.getPreference().loadRefrigerantCooldown()) * 30;
                                text.get("PriceTime").setText(Integer.toString(priceUpM));
                                if (MarsGame.getPreference().loadRefrigerantCooldown() <= 15) {
                                    MarsGame.getPreference().setAchievementRestorationOfCold();
                                    text.get("NextTime").setText(MarsGame.getLanguage().textScreen.get("Max"));
                                    text.get("PriceTime").setText("-");
                                    text.get("BuyTime").setColor(Color.RED);
                                    text.get("NextTime").setPosition((MarsGame.WIDTH / 2 + 160) * MarsGame.getRatioMonitorW() - text.get("NextTime").getPrefWidth() / 2, (400 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                                } else text.get("NextTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadRefrigerantCooldown() - 1));
                            } else if (MarsGame.getPreference().loadRefrigerantCooldown() <= 15) {
                                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                            }
                        } else if (MarsGame.getPreference().loadMineral() < priceUpM) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (showBuy == POISON) {
                        int priceUpM = 15 + (30 - MarsGame.getPreference().loadZomanCooldown()) * 30;
                        if (MarsGame.getPreference().loadMineral() >= priceUpM) {
                            if (MarsGame.getPreference().loadZomanCooldown() > 15) {
                                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                                MarsGame.getPreference().saveZomanCooldown(-1, -priceUpM);

                                MarsGame.getPreference().setEventSpentMinerals(priceUpM);
                                MarsGame.getPreference().setAchievementMineralRemove(MarsGame.getPreference().getEventSpentMinerals());

                                text.get("Mineral").setText(String.valueOf(MarsGame.getPreference().loadMineral()));
                                text.get("CurrentTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadZomanCooldown()));
                                priceUpM = 15 + (30 - MarsGame.getPreference().loadZomanCooldown()) * 30;
                                text.get("PriceTime").setText(Integer.toString(priceUpM));
                                if (MarsGame.getPreference().loadZomanCooldown() <= 15) {
                                    MarsGame.getPreference().setAchievementRestorationOfPoison();
                                    text.get("NextTime").setText(MarsGame.getLanguage().textScreen.get("Max"));
                                    text.get("PriceTime").setText("-");
                                    text.get("BuyTime").setColor(Color.RED);
                                    text.get("NextTime").setPosition((MarsGame.WIDTH / 2 + 160) * MarsGame.getRatioMonitorW() - text.get("NextTime").getPrefWidth() / 2, (400 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                                } else text.get("NextTime").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadZomanCooldown() - 1));
                            } else if (MarsGame.getPreference().loadZomanCooldown() <= 15) {
                                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                            }
                        } else if (MarsGame.getPreference().loadMineral() < priceUpM) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
                //endregion
            } else if (name.equals("Hangar")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Game"));
            } else if (name.equals("Arsenal")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Arsenal"));
            } else if (name.equals("Bridge")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Bridge"));
            } else if (name.equals("Reactor")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Reactor"));
            }
        }
    }
}