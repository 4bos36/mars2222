package studio.rashka.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
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

public class PirateScreen extends State {

    private Stage stage;
    private Map<String, Label> text;
    private Map<String, Buttons> buttons;
    private TextField setPromo;

    private int numberPrice;
    private float angleMars = 0;
    private boolean isUpFly = true,
            isGetMoney = false,
            isGetMineral = false,
            isShieldHPAdd = false,
            isEnergyAdd = false,
            isMicrowave = false,
            isPromo = false,
            isUP = false,
            isDOWN = false;
    private Vector2 position;
    private Stars stars;
    private ParticleEffect engineUp, engineDown;

    private static final Drawable drawable = Textures.getInstance().getTextureButtonSkin().getDrawable("NULL");

    public PirateScreen(Game game) {
        super(game);

        stage = new Stage();
        stars = new Stars();
        text = new HashMap<String, Label>();
        buttons = new HashMap<String, Buttons>();
        position = new Vector2(0, 0);

        engineUp = new ParticleEffect();
        engineDown = new ParticleEffect();
        engineUp.load(Gdx.files.internal("particles/Engine.p"), Gdx.files.internal("particles"));
        engineDown.load(Gdx.files.internal("particles/Engine.p"), Gdx.files.internal("particles"));
        engineUp.start();
        engineDown.start();

        textSet();
        textPutGet(1);
        adsButtons();

        stage.addActor(text.get("Money"));
        stage.addActor(text.get("getMoney"));
        stage.addActor(text.get("Mineral"));
        stage.addActor(text.get("getMineral"));
        stage.addActor(text.get("ShieldHPAdd"));
        stage.addActor(text.get("getShieldHPAdd"));
        stage.addActor(text.get("EnergyAdd"));
        stage.addActor(text.get("getEnergyAdd"));
        stage.addActor(text.get("Microwave"));
        stage.addActor(text.get("getMicrowave"));
        stage.addActor(setPromo);
        Gdx.input.setInputProcessor(stage);
    }

    private void textSet() {
        setPromo = new TextField("", new TextFieldStyle(FontTTF.getInstance().getFont28(), Color.WHITE, Textures.getInstance().getTextureButtonSkin().getDrawable("Input"), null, Textures.getInstance().getTextureButtonSkin().getDrawable("Text")));
        setPromo.setPosition(64 * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 128) * MarsGame.getRatioMonitorH());
        setPromo.setSize(256 * MarsGame.getRatioMonitorW(), 64 * MarsGame.getRatioMonitorH());
        setPromo.setMessageText("PROMO KOD");

        text.put("Money", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.GOLD)));
        text.put("getMoney", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.GOLD)));
        text.put("Mineral", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.BLUE)));
        text.put("getMineral", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.BLUE)));
        text.put("ShieldHPAdd", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.ORANGE)));
        text.put("getShieldHPAdd", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.ORANGE)));
        text.put("EnergyAdd", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.CORAL)));
        text.put("getEnergyAdd", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.CORAL)));
        text.put("Microwave", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.SKY)));
        text.put("getMicrowave", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.SKY)));
    }

    private void textPutGet(int numberPrice) {
        this.numberPrice = numberPrice;
        if (!MarsGame.getPreference().isBuy()) {
            this.numberPrice = 0;
            text.get("Money").setText("0");
            text.get("Mineral").setText("0");
            text.get("ShieldHPAdd").setText("0");
            text.get("EnergyAdd").setText("0");
            text.get("Microwave").setText("0");
            text.get("getMoney").setText("0");
            text.get("getMineral").setText("0");
            text.get("getShieldHPAdd").setText("0");
            text.get("getEnergyAdd").setText("0");
            text.get("getMicrowave").setText("0");
        } else {
            text.get("Money").setText(String.valueOf(MarsGame.getPreference().priceMoney(numberPrice)));
            text.get("Mineral").setText(String.valueOf(MarsGame.getPreference().priceMineral(numberPrice)));
            text.get("ShieldHPAdd").setText(String.valueOf(MarsGame.getPreference().priceShieldHPAdd(numberPrice)));
            text.get("EnergyAdd").setText(String.valueOf(MarsGame.getPreference().priceEnergyAdd(numberPrice)));
            text.get("Microwave").setText(String.valueOf(MarsGame.getPreference().priceMicrowave(numberPrice)));
            if (numberPrice == 1) {
                text.get("getMoney").setText("+5000");
                text.get("getMineral").setText("+250");
                text.get("getShieldHPAdd").setText("+5");
                text.get("getEnergyAdd").setText("+5");
                text.get("getMicrowave").setText("+5");
            } else if (numberPrice == 2) {
                text.get("getMoney").setText("+11500");
                text.get("getMineral").setText("+500");
                text.get("getShieldHPAdd").setText("+10");
                text.get("getEnergyAdd").setText("+10");
                text.get("getMicrowave").setText("+10");
            } else if (numberPrice == 3) {
                text.get("getMoney").setText("+18000");
                text.get("getMineral").setText("+850");
                text.get("getShieldHPAdd").setText("+15");
                text.get("getEnergyAdd").setText("+15");
                text.get("getMicrowave").setText("+15");
            } else if (numberPrice == 4) {
                text.get("getMoney").setText("+25000");
                text.get("getMineral").setText("+1500");
                text.get("getShieldHPAdd").setText("+20");
                text.get("getEnergyAdd").setText("+20");
                text.get("getMicrowave").setText("+20");
            } else if (numberPrice == 5) {
                text.get("getMoney").setText("+50000");
                text.get("getMineral").setText("+3000");
                text.get("getShieldHPAdd").setText("+45");
                text.get("getEnergyAdd").setText("+45");
                text.get("getMicrowave").setText("+45");
            }
        }

        text.get("Money").setPosition((MarsGame.WIDTH / 2 + 96) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth() / 2, (MarsGame.HEIGHT - 280) * MarsGame.getRatioMonitorH());
        text.get("getMoney").setPosition((MarsGame.WIDTH / 2 + 96) * MarsGame.getRatioMonitorW() - text.get("getMoney").getPrefWidth() / 2, (MarsGame.HEIGHT - 330) * MarsGame.getRatioMonitorH());
        text.get("Mineral").setPosition((MarsGame.WIDTH / 2 + 416) * MarsGame.getRatioMonitorW() - text.get("Mineral").getPrefWidth() / 2, (MarsGame.HEIGHT - 280) * MarsGame.getRatioMonitorH());
        text.get("getMineral").setPosition((MarsGame.WIDTH / 2 + 416) * MarsGame.getRatioMonitorW() - text.get("getMineral").getPrefWidth() / 2, (MarsGame.HEIGHT - 330) * MarsGame.getRatioMonitorH());
        text.get("ShieldHPAdd").setPosition((MarsGame.WIDTH / 2 + 736) * MarsGame.getRatioMonitorW() - text.get("ShieldHPAdd").getPrefWidth() / 2, (MarsGame.HEIGHT - 280) * MarsGame.getRatioMonitorH());
        text.get("getShieldHPAdd").setPosition((MarsGame.WIDTH / 2 + 736) * MarsGame.getRatioMonitorW() - text.get("getShieldHPAdd").getPrefWidth() / 2, (MarsGame.HEIGHT - 330) * MarsGame.getRatioMonitorH());
        text.get("EnergyAdd").setPosition((MarsGame.WIDTH / 2 + 736) * MarsGame.getRatioMonitorW() - text.get("EnergyAdd").getPrefWidth() / 2, (MarsGame.HEIGHT - 600) * MarsGame.getRatioMonitorH());
        text.get("getEnergyAdd").setPosition((MarsGame.WIDTH / 2 + 736) * MarsGame.getRatioMonitorW() - text.get("getEnergyAdd").getPrefWidth() / 2, (MarsGame.HEIGHT - 650) * MarsGame.getRatioMonitorH());
        text.get("Microwave").setPosition((MarsGame.WIDTH / 2 + 736) * MarsGame.getRatioMonitorW() - text.get("Microwave").getPrefWidth() / 2, (MarsGame.HEIGHT - 920) * MarsGame.getRatioMonitorH());
        text.get("getMicrowave").setPosition((MarsGame.WIDTH / 2 + 736) * MarsGame.getRatioMonitorW() - text.get("getMicrowave").getPrefWidth() / 2, (MarsGame.HEIGHT - 970) * MarsGame.getRatioMonitorH());
    }

    private void adsButtons() {
        buttons.put("Home", new Buttons("Home", drawable, 192, 192, 64, 64));
        buttons.put("GetMoney", new Buttons("GetMoney", drawable, 192, 192, MarsGame.WIDTH / 2, MarsGame.HEIGHT - 256));
        buttons.put("GetMineral", new Buttons("GetMineral", drawable, 192, 192, MarsGame.WIDTH / 2 + 320, MarsGame.HEIGHT - 256));
        buttons.put("ShieldHPAdd", new Buttons("ShieldHPAdd", drawable, 192, 192, MarsGame.WIDTH / 2 + 640, MarsGame.HEIGHT - 256));
        buttons.put("EnergyAdd", new Buttons("EnergyAdd", drawable, 192, 192, MarsGame.WIDTH / 2 + 640, MarsGame.HEIGHT - 576));
        buttons.put("Microwave", new Buttons("Microwave", drawable, 192, 192, MarsGame.WIDTH / 2 + 640, MarsGame.HEIGHT - 896));
        buttons.put("Promo", new Buttons("Promo", drawable, 64, 64, 325, MarsGame.HEIGHT - 128));
        buttons.put("UP", new Buttons("UP", drawable, 128, 128, 64, MarsGame.HEIGHT / 2 + 64));
        buttons.put("DOWN", new Buttons("DOWN", drawable, 128, 128, 64, MarsGame.HEIGHT / 2 - 64));

        buttons.get("Home").addListener(new ButtonsInputListener(buttons.get("Home").getName()));
        buttons.get("GetMoney").addListener(new ButtonsInputListener(buttons.get("GetMoney").getName()));
        buttons.get("GetMineral").addListener(new ButtonsInputListener(buttons.get("GetMineral").getName()));
        buttons.get("ShieldHPAdd").addListener(new ButtonsInputListener(buttons.get("ShieldHPAdd").getName()));
        buttons.get("EnergyAdd").addListener(new ButtonsInputListener(buttons.get("EnergyAdd").getName()));
        buttons.get("Microwave").addListener(new ButtonsInputListener(buttons.get("Microwave").getName()));
        buttons.get("Promo").addListener(new ButtonsInputListener(buttons.get("Promo").getName()));
        buttons.get("UP").addListener(new ButtonsInputListener(buttons.get("UP").getName()));
        buttons.get("DOWN").addListener(new ButtonsInputListener(buttons.get("DOWN").getName()));

        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("GetMoney"));
        stage.addActor(buttons.get("GetMineral"));
        stage.addActor(buttons.get("ShieldHPAdd"));
        stage.addActor(buttons.get("EnergyAdd"));
        stage.addActor(buttons.get("Microwave"));
        stage.addActor(buttons.get("Promo"));
        stage.addActor(buttons.get("UP"));
        stage.addActor(buttons.get("DOWN"));
    }

    @Override
    public void update(float deltaTime) {
        if (isUpFly) {
            position.add(deltaTime * 20, deltaTime * 20);
            if (position.x > 80) isUpFly = false;
        } else {
            position.sub(deltaTime * 20, deltaTime * 20);
            if (position.x < -120) isUpFly = true;
        }
        angleMars -= deltaTime * 2;
        stars.update();
        engineUp.update(deltaTime);
        engineDown.update(deltaTime);
        engineUp.setPosition(992 + position.x, 488 + position.y);
        engineDown.setPosition(992 + position.x, 384 + position.y);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        stars.render(batch);
        batch.draw(Textures.getInstance().textureRegion.get("Mars"), 256, MarsGame.HEIGHT / 2, 192, 192, 384, 384, 1, 1, angleMars);

        batch.draw(Textures.getInstance().textureRegionScreen.get("PirateShip"), 320 + position.x, 256 + position.y, 896, 384);
        engineUp.draw(batch);
        engineDown.draw(batch);

        if (!isGetMoney) batch.draw(Textures.getInstance().textureRegionScreen.get("BuyMoney"), MarsGame.WIDTH / 2, MarsGame.HEIGHT - 256, 192, 192);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("BuyMoney"), MarsGame.WIDTH / 2 + 2, MarsGame.HEIGHT - 258, 188, 188);
        if (!isGetMineral) batch.draw(Textures.getInstance().textureRegionScreen.get("BuyMineral"), MarsGame.WIDTH / 2 + 320, MarsGame.HEIGHT - 256, 192, 192);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("BuyMineral"), MarsGame.WIDTH / 2 + 322, MarsGame.HEIGHT - 258, 188, 188);
        if (!isShieldHPAdd) batch.draw(Textures.getInstance().textureRegionScreen.get("BuyShieldHPAdd"), MarsGame.WIDTH / 2 + 640, MarsGame.HEIGHT - 256, 192, 192);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("BuyShieldHPAdd"), MarsGame.WIDTH / 2 + 642, MarsGame.HEIGHT - 258, 188, 188);
        if (!isEnergyAdd) batch.draw(Textures.getInstance().textureRegionScreen.get("BuyEnergyAdd"), MarsGame.WIDTH / 2 + 640, MarsGame.HEIGHT - 576, 192, 192);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("BuyEnergyAdd"), MarsGame.WIDTH / 2 + 642, MarsGame.HEIGHT - 578, 188, 188);
        if (!isMicrowave) batch.draw(Textures.getInstance().textureRegionScreen.get("BuyMicrowave"), MarsGame.WIDTH / 2 + 640, MarsGame.HEIGHT - 896, 192, 192);
        else batch.draw(Textures.getInstance().textureRegionScreen.get("BuyMicrowave"), MarsGame.WIDTH / 2 + 642, MarsGame.HEIGHT - 898, 188, 188);
        batch.draw(Textures.getInstance().textureRegionScreen.get("Home"), 64, 64, 128, 128);

        if (numberPrice != 0) {
            if (numberPrice >= 1 && numberPrice < 5) {
                if (isUP) batch.draw(Textures.getInstance().textureRegionScreen.get("UP"), 66, MarsGame.HEIGHT / 2 + 194, 124, -124);
                else batch.draw(Textures.getInstance().textureRegionScreen.get("UP"), 64, MarsGame.HEIGHT / 2 + 192, 128, -128);
            }
            if (numberPrice > 1 && numberPrice <= 5) {
                if (isDOWN) batch.draw(Textures.getInstance().textureRegionScreen.get("UP"), 66, MarsGame.HEIGHT / 2 - 62, 124, 124);
                else batch.draw(Textures.getInstance().textureRegionScreen.get("UP"), 64, MarsGame.HEIGHT / 2 - 64, 128, 128);
            }
        }

        batch.draw(Textures.getInstance().textureRegionScreen.get("Cash"), text.get("Money").getX() / MarsGame.getRatioMonitorW() - 64, text.get("Money").getY() / MarsGame.getRatioMonitorH() - 25, 48, 48);
        batch.draw(Textures.getInstance().textureRegionScreen.get("Cash"), text.get("Mineral").getX() / MarsGame.getRatioMonitorW() - 64, text.get("Mineral").getY() / MarsGame.getRatioMonitorH() - 25, 48, 48);
        batch.draw(Textures.getInstance().textureRegionScreen.get("Cash"), text.get("ShieldHPAdd").getX() / MarsGame.getRatioMonitorW() - 64, text.get("ShieldHPAdd").getY() / MarsGame.getRatioMonitorH() - 25, 48, 48);
        batch.draw(Textures.getInstance().textureRegionScreen.get("Cash"), text.get("EnergyAdd").getX() / MarsGame.getRatioMonitorW() - 64, text.get("EnergyAdd").getY() / MarsGame.getRatioMonitorH() - 25, 48, 48);
        batch.draw(Textures.getInstance().textureRegionScreen.get("Cash"), text.get("Microwave").getX() / MarsGame.getRatioMonitorW() - 64, text.get("Microwave").getY() / MarsGame.getRatioMonitorH() - 25, 48, 48);

        batch.draw(Textures.getInstance().textureRegion.get("ColorOrange"), 50, MarsGame.HEIGHT - 128, 345, 64);
        if (!isPromo) batch.draw(Textures.getInstance().textureRegion.get("PromoKod"), 325, MarsGame.HEIGHT - 128);
        else batch.draw(Textures.getInstance().textureRegion.get("PromoKod"), 327, MarsGame.HEIGHT - 126, 60, 60);
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
            engineUp.dispose();
            engineDown.dispose();
            setPromo.clear();
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
            if (name.equals("GetMoney")) isGetMoney = true;
            else if (name.equals("GetMineral")) isGetMineral = true;
            else if (name.equals("ShieldHPAdd")) isShieldHPAdd = true;
            else if (name.equals("EnergyAdd")) isEnergyAdd = true;
            else if (name.equals("Microwave")) isMicrowave = true;
            else if (name.equals("Promo")) isPromo = true;
            else if (name.equals("UP")) {
                if (numberPrice >= 1 && numberPrice < 5) isUP = true;
            }
            else if (name.equals("DOWN")) {
                if (numberPrice > 1 && numberPrice <= 5) isDOWN = true;
            }
            return true;
        }

        @Override
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            if (name.equals("Home")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Bridge"));
            } else if (name.equals("GetMoney")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (numberPrice == 1) MarsGame.playServices.showAds(6);
                else if (numberPrice == 2) MarsGame.playServices.showAds(11);
                else if (numberPrice == 3) MarsGame.playServices.showAds(12);
                else if (numberPrice == 4) MarsGame.playServices.showAds(13);
                else if (numberPrice == 5) MarsGame.playServices.showAds(14);
                isGetMoney = false;
            } else if (name.equals("GetMineral")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (numberPrice == 1) MarsGame.playServices.showAds(7);
                else if (numberPrice == 2) MarsGame.playServices.showAds(15);
                else if (numberPrice == 3) MarsGame.playServices.showAds(16);
                else if (numberPrice == 4) MarsGame.playServices.showAds(17);
                else if (numberPrice == 5) MarsGame.playServices.showAds(18);
                isGetMineral = false;
            } else if (name.equals("ShieldHPAdd")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (numberPrice == 1) MarsGame.playServices.showAds(8);
                else if (numberPrice == 2) MarsGame.playServices.showAds(19);
                else if (numberPrice == 3) MarsGame.playServices.showAds(20);
                else if (numberPrice == 4) MarsGame.playServices.showAds(21);
                else if (numberPrice == 5) MarsGame.playServices.showAds(22);
                isShieldHPAdd = false;
            } else if (name.equals("EnergyAdd")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (numberPrice == 1) MarsGame.playServices.showAds(9);
                else if (numberPrice == 2) MarsGame.playServices.showAds(23);
                else if (numberPrice == 3) MarsGame.playServices.showAds(24);
                else if (numberPrice == 4) MarsGame.playServices.showAds(25);
                else if (numberPrice == 5) MarsGame.playServices.showAds(26);
                isEnergyAdd = false;
            } else if (name.equals("Microwave")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (numberPrice == 1) MarsGame.playServices.showAds(10);
                else if (numberPrice == 2) MarsGame.playServices.showAds(27);
                else if (numberPrice == 3) MarsGame.playServices.showAds(28);
                else if (numberPrice == 4) MarsGame.playServices.showAds(29);
                else if (numberPrice == 5) MarsGame.playServices.showAds(30);
                isMicrowave = false;
            } else if (name.equals("Promo")) {
                if (!setPromo.getText().equals("")) {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    Gdx.net.openURI("https://play.google.com/redeem?code=" + setPromo.getText());
                } else {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                }
                isPromo = false;
            } else if (name.equals("UP")) {
                if (numberPrice >= 1 && numberPrice < 5) {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    textPutGet(numberPrice+1);
                    isUP = false;
                }
            } else if (name.equals("DOWN")) {
                if (numberPrice > 1 && numberPrice <= 5) {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    textPutGet(numberPrice-1);
                    isDOWN = false;
                }
            }
        }
    }
}