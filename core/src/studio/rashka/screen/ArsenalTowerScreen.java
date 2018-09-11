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
import studio.rashka.models.arsenal.Weapons;
import studio.rashka.models.bridge.TV;
import studio.rashka.models.lightbulb.RedLightbulb;
import studio.rashka.models.lightbulb.YellowLightbulb;

public class ArsenalTowerScreen extends State {

    private final static int NULL = 0, MACHINEGUN = 1, GRENADELAUNCHERS = 2, ROCKETLAUNCHERS = 3, LASERGUNS = 4;

    private Stage stage;
    private Map<String, Label> text;
    private boolean touchTurnOffTerminal = false, touchMachineGun = false, touchLauncherGun = false,
            touchFlareGun = false, touchLaserGun = false, isOffTerminal = false, isBuy = false, isMax = false;
    private int showWeapons = NULL;

    private Map<String, Buttons> buttons;
    private TV tv;
    private RedLightbulb redLightbulb;
    private YellowLightbulb yellowLightbulb;
    private Stars stars;
    private Weapons weapons, weaponsNow;

    private static final Drawable img = MarsGame.getTextures().getTextureButtonSkin().getDrawable("NULL");
    private static final LabelStyle style28 = new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE);

    public ArsenalTowerScreen(Game game) {
        super(game);
        tv = new TV();
        redLightbulb = new RedLightbulb();
        yellowLightbulb = new YellowLightbulb();
        stars = new Stars();
        weapons = new Weapons();
        weaponsNow = new Weapons();

        weapons.setForm(1);
        weaponsNow.setInfo(416);
        weaponsNow.setForm(512);

        stage = new Stage();
        text = new HashMap<String, Label>();
        buttons = new HashMap<String, Buttons>();

        textLoading();
        textPutGet();
        buttons();
        Gdx.input.setInputProcessor(stage);
    }

    private void textPutGet() {
        text.put("Money", new Label(String.valueOf(MarsGame.getPreference().loadMoney()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.MAGENTA)));
        text.put("Mineral", new Label(String.valueOf(MarsGame.getPreference().loadMineral()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.GREEN)));
        text.put("BuyPriceMoney", new Label("", new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));
        text.put("BuyPriceMineral", new Label("", new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));

        text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
        text.get("Mineral").setPosition((MarsGame.WIDTH / 2 + 132) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
        text.get("BuyPriceMoney").setPosition(448 * MarsGame.getRatioMonitorW(), (450 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("BuyPriceMineral").setPosition(448 * MarsGame.getRatioMonitorW(), (400 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("Money"));
        stage.addActor(text.get("Mineral"));
        stage.addActor(text.get("BuyPriceMoney"));
        stage.addActor(text.get("BuyPriceMineral"));
    }

    private void textLoading() {
        text.put("OnOff", new Label(MarsGame.getLanguage().textScreen.get("OnOff"), style28));
        text.put("MachineGun", new Label(MarsGame.getLanguage().textScreen.get("MachineGun"), style28));
        if (MarsGame.getPreference().getTacticsAttackLauncherGun()) text.put("LauncherGun", new Label(MarsGame.getLanguage().textScreen.get("LauncherGun"), style28));
        else text.put("LauncherGun", new Label("", style28));
        if (MarsGame.getPreference().getTacticsAttackFlareGun()) text.put("FlareGun", new Label(MarsGame.getLanguage().textScreen.get("FlareGun"), style28));
        else text.put("FlareGun", new Label("", style28));
        if (MarsGame.getPreference().getTacticsAttackLaserGun()) text.put("LaserGun", new Label(MarsGame.getLanguage().textScreen.get("LaserGun"), style28));
        else text.put("LaserGun", new Label("", style28));
        text.put("Arsenal", new Label(MarsGame.getLanguage().textScreen.get("Arsenal"), style28));
        text.put("WarningTower", new Label(MarsGame.getLanguage().textScreen.get("WarningTower"), new LabelStyle(FontTTF.getInstance().getFont28(), Color.GOLD)));

        text.get("OnOff").setPosition(108 * MarsGame.getRatioMonitorW(), (180 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("MachineGun").setPosition(190 * MarsGame.getRatioMonitorW(), (305 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("LauncherGun").setPosition(275 * MarsGame.getRatioMonitorW(), (180 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("FlareGun").setPosition(462 * MarsGame.getRatioMonitorW(), (295 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("LaserGun").setPosition(556 * MarsGame.getRatioMonitorW(), (200 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Arsenal").setPosition(745 * MarsGame.getRatioMonitorW(), (186 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("WarningTower").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW(), (64 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("OnOff"));
        stage.addActor(text.get("MachineGun"));
        stage.addActor(text.get("LauncherGun"));
        stage.addActor(text.get("FlareGun"));
        stage.addActor(text.get("LaserGun"));
        stage.addActor(text.get("Arsenal"));
        stage.addActor(text.get("WarningTower"));
    }

    private void buttons() {
        buttons.put("TurnOffTerminal", new Buttons("TurnOffTerminal", img, 60, 60, 106, 232 + MarsGame.getRatioAdd()));
        buttons.put("MachineGun", new Buttons("MachineGun", img, 60, 60, 198, 232 + MarsGame.getRatioAdd()));
        buttons.put("LauncherGun", new Buttons("LauncherGun", img, 60, 60, 290, 232 + MarsGame.getRatioAdd()));
        buttons.put("FlareGun", new Buttons("FlareGun", img, 60, 60, 382, 232 + MarsGame.getRatioAdd()));
        buttons.put("LaserGun", new Buttons("LaserGun", img, 60, 60, 476, 232 + MarsGame.getRatioAdd()));
        buttons.put("TerminalArsenal", new Buttons("TerminalArsenal", img, 128, 128, 620, 200 + MarsGame.getRatioAdd()));
        buttons.put("Buy", new Buttons("Buy", img, 128, 128, 185, 355 + MarsGame.getRatioAdd()));

        buttons.get("TurnOffTerminal").addListener(new ButtonsInputListener(buttons.get("TurnOffTerminal").getName()));
        buttons.get("MachineGun").addListener(new ButtonsInputListener(buttons.get("MachineGun").getName()));
        buttons.get("LauncherGun").addListener(new ButtonsInputListener(buttons.get("LauncherGun").getName()));
        buttons.get("FlareGun").addListener(new ButtonsInputListener(buttons.get("FlareGun").getName()));
        buttons.get("LaserGun").addListener(new ButtonsInputListener(buttons.get("LaserGun").getName()));
        buttons.get("TerminalArsenal").addListener(new ButtonsInputListener(buttons.get("TerminalArsenal").getName()));
        buttons.get("Buy").addListener(new ButtonsInputListener(buttons.get("Buy").getName()));

        stage.addActor(buttons.get("TurnOffTerminal"));
        stage.addActor(buttons.get("MachineGun"));
        stage.addActor(buttons.get("LauncherGun"));
        stage.addActor(buttons.get("FlareGun"));
        stage.addActor(buttons.get("LaserGun"));
        stage.addActor(buttons.get("TerminalArsenal"));
        stage.addActor(buttons.get("Buy"));
    }

    private void buyUpdateTower() {
        MarsGame.getPreference().saveCredit(-Integer.parseInt(weapons.getMoney()), -Integer.parseInt(weapons.getMineral()));

        MarsGame.getPreference().setEventSpentMoney(Integer.parseInt(weapons.getMoney()));
        MarsGame.getPreference().setAchievementMoneyRemove(MarsGame.getPreference().getEventSpentMoney());

        MarsGame.getPreference().setEventSpentMinerals(Integer.parseInt(weapons.getMineral()));
        MarsGame.getPreference().setAchievementMineralRemove(MarsGame.getPreference().getEventSpentMinerals());

        MarsGame.getPreference().setAchievementTurret();

        text.get("Money").setText(String.valueOf(MarsGame.getPreference().loadMoney()));
        text.get("Mineral").setText(String.valueOf(MarsGame.getPreference().loadMineral()));
        text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
    }

    private void terminalWeaponsPrice() {
        isMax = false;
        if (showWeapons == MACHINEGUN) {
            //region code
            if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_1") || MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("")) {
                weaponsNow.setNameWeapons("MachineGun_1");
                weapons.setNameWeapons("MachineGun_2");
            } else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_2")) {
                weaponsNow.setNameWeapons("MachineGun_2");
                weapons.setNameWeapons("MachineGun_3");
            } else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_3")) {
                weaponsNow.setNameWeapons("MachineGun_3");
                weapons.setNameWeapons("MachineGun_4");
            } else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_4")) {
                weaponsNow.setNameWeapons("MachineGun_4");
                weapons.setNameWeapons("MachineGun_5");
            } else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_5")) {
                weaponsNow.setNameWeapons("MachineGun_5");
                weapons.setNameWeapons("MachineGun_6");
            } else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_6")) {
                weaponsNow.setNameWeapons("MachineGun_6");
                weapons.setNameWeapons("MachineGun_7");
            } else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_7")) {
                weaponsNow.setNameWeapons("MachineGun_7");
                weapons.setNameWeapons("MachineGun_8");
            } else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_8")) {
                weaponsNow.setNameWeapons("MachineGun_8");
                weapons.setNameWeapons("NULL");
                isMax = true;
            } //endregion
        } else if (showWeapons == GRENADELAUNCHERS) {
            //region code
            if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_1") || MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("")) {
                weaponsNow.setNameWeapons("LauncherGun_1");
                weapons.setNameWeapons("LauncherGun_2");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_2")) {
                weaponsNow.setNameWeapons("LauncherGun_2");
                weapons.setNameWeapons("LauncherGun_3");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_3")) {
                weaponsNow.setNameWeapons("LauncherGun_3");
                weapons.setNameWeapons("LauncherGun_4");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_4")) {
                weaponsNow.setNameWeapons("LauncherGun_4");
                weapons.setNameWeapons("LauncherGun_5");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_5")) {
                weaponsNow.setNameWeapons("LauncherGun_5");
                weapons.setNameWeapons("LauncherGun_6");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_6")) {
                weaponsNow.setNameWeapons("LauncherGun_6");
                weapons.setNameWeapons("LauncherGun_7");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_7")) {
                weaponsNow.setNameWeapons("LauncherGun_7");
                weapons.setNameWeapons("LauncherGun_8");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_8")) {
                weaponsNow.setNameWeapons("LauncherGun_8");
                weapons.setNameWeapons("NULL");
            } //endregion
        } else if (showWeapons == ROCKETLAUNCHERS) {
            //region code
            if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_1") || MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("")) {
                weaponsNow.setNameWeapons("FlareGun_1");
                weapons.setNameWeapons("FlareGun_2");
            } else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_2")) {
                weaponsNow.setNameWeapons("FlareGun_2");
                weapons.setNameWeapons("FlareGun_3");
            } else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_3")) {
                weaponsNow.setNameWeapons("FlareGun_3");
                weapons.setNameWeapons("FlareGun_4");
            } else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_4")) {
                weaponsNow.setNameWeapons("FlareGun_4");
                weapons.setNameWeapons("FlareGun_5");
            } else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_5")) {
                weaponsNow.setNameWeapons("FlareGun_5");
                weapons.setNameWeapons("FlareGun_6");
            } else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_6")) {
                weaponsNow.setNameWeapons("FlareGun_6");
                weapons.setNameWeapons("FlareGun_7");
            } else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_7")) {
                weaponsNow.setNameWeapons("FlareGun_7");
                weapons.setNameWeapons("FlareGun_8");
            } else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_8")) {
                weaponsNow.setNameWeapons("FlareGun_8");
                weapons.setNameWeapons("NULL");
            } //endregion
        } else if (showWeapons == LASERGUNS) {
            //region code
            if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_1") || MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("")) {
                weaponsNow.setNameWeapons("LaserGun_1");
                weapons.setNameWeapons("LaserGun_2");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_2")) {
                weaponsNow.setNameWeapons("LaserGun_2");
                weapons.setNameWeapons("LaserGun_3");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_3")) {
                weaponsNow.setNameWeapons("LaserGun_3");
                weapons.setNameWeapons("LaserGun_4");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_4")) {
                weaponsNow.setNameWeapons("LaserGun_4");
                weapons.setNameWeapons("LaserGun_5");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_5")) {
                weaponsNow.setNameWeapons("LaserGun_5");
                weapons.setNameWeapons("LaserGun_6");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_6")) {
                weaponsNow.setNameWeapons("LaserGun_6");
                weapons.setNameWeapons("LaserGun_7");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_7")) {
                weaponsNow.setNameWeapons("LaserGun_7");
                weapons.setNameWeapons("LaserGun_8");
            } else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_8")) {
                weaponsNow.setNameWeapons("LaserGun_8");
                weapons.setNameWeapons("NULL");
            } //endregion
        }
        weapons.priceTower();
        if (!isMax) {
            isBuy = true;
            text.get("BuyPriceMoney").setText(weapons.getMoney());
            text.get("BuyPriceMineral").setText(weapons.getMineral());
            text.get("BuyPriceMoney").setColor(Color.WHITE);
            text.get("BuyPriceMineral").setColor(Color.WHITE);
            if (MarsGame.getPreference().loadMoney() < Integer.parseInt(weapons.getMoney())) {
                text.get("BuyPriceMoney").setColor(Color.RED);
                isBuy = false;
            }
            if (MarsGame.getPreference().loadMineral() < Integer.parseInt(weapons.getMineral())) {
                text.get("BuyPriceMineral").setColor(Color.RED);
                isBuy = false;
            }
        } else {
            text.get("BuyPriceMoney").setText("");
            text.get("BuyPriceMineral").setText("");
            isBuy = false;
        }
    }

    @Override
    public void update(float deltaTime) {
        tv.update(deltaTime);
        redLightbulb.update(deltaTime);
        yellowLightbulb.update(deltaTime);
        stars.update();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        stars.render(batch);
        batch.draw(MarsGame.getTextures().textureRegion.get("Goal_l"), MarsGame.WIDTH / 2 - 429, 224 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("Goal_r"), MarsGame.WIDTH / 2 - 23, 224 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("Fon"), 0, 0 + MarsGame.getRatioAdd());
        yellowLightbulb.render(batch, 200, 292 + MarsGame.getRatioAdd(), 180, 16);
        yellowLightbulb.render(batch, 200, 694 + MarsGame.getRatioAdd(), 180, 16);
        yellowLightbulb.render(batch, MarsGame.WIDTH - 385, 292 + MarsGame.getRatioAdd(), 180, 16);
        yellowLightbulb.render(batch, MarsGame.WIDTH - 385, 694 + MarsGame.getRatioAdd(), 180, 16);
        redLightbulb.render(batch, 1359, 366 + MarsGame.getRatioAdd(), 16, 16);
        redLightbulb.render(batch, 1359, 342 + MarsGame.getRatioAdd(), 16, 16);

        batch.draw(MarsGame.getTextures().textureRegion.get("Terminal"), 32, 160 + MarsGame.getRatioAdd());
        if (!touchTurnOffTerminal) batch.draw(MarsGame.getTextures().textureRegion.get("TurnOff"), 106, 232 + MarsGame.getRatioAdd(), 60, 60);
        else batch.draw(MarsGame.getTextures().textureRegion.get("TurnOff"), 109, 235 + MarsGame.getRatioAdd(), 54, 54);
        if (!touchMachineGun) batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun"), 198, 232 + MarsGame.getRatioAdd(), 60, 60);
        else batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun"), 201, 235 + MarsGame.getRatioAdd(), 54, 54);
        if (MarsGame.getPreference().getTacticsAttackLauncherGun()) {
            if (!touchLauncherGun) batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun"), 290, 232 + MarsGame.getRatioAdd(), 60, 60);
            else batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun"), 293, 235 + MarsGame.getRatioAdd(), 54, 54);
        }
        if (MarsGame.getPreference().getTacticsAttackFlareGun()) {
            if (!touchFlareGun) batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun"), 382, 232 + MarsGame.getRatioAdd(), 60, 60);
            else batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun"), 385, 235 + MarsGame.getRatioAdd(), 54, 54);
        }
        if (MarsGame.getPreference().getTacticsAttackLaserGun()) {
            if (!touchLaserGun) batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun"), 476, 232 + MarsGame.getRatioAdd(), 60, 60);
            else batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun"), 479, 235 + MarsGame.getRatioAdd(), 54, 54);
        }

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Rack"), 610, MarsGame.HEIGHT - 290, 60, 90);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Rack"), 610, MarsGame.HEIGHT - 200, 60, 90);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Rack"), 194, MarsGame.HEIGHT - 290, 60, 90);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Rack"), 194, MarsGame.HEIGHT - 200, 60, 90);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Monitor"), 480, MarsGame.HEIGHT - 480);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Monitor"), 64, MarsGame.HEIGHT - 480);

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("ProjectionMonitor"), MarsGame.WIDTH - 960, 80 + MarsGame.getRatioAdd(), 32, 96, 64, 192, 1, 1, 90);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("ProjectionMonitor"), MarsGame.WIDTH - 960, 80 + MarsGame.getRatioAdd(), 32, 96, 64, -192, 1, 1, 90);

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("ProjectionMonitor"), MarsGame.WIDTH - 448, 80 + MarsGame.getRatioAdd(), 32, 96, 64, 192, 1, 1, 90);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("ProjectionMonitor"), MarsGame.WIDTH - 448, 80 + MarsGame.getRatioAdd(), 32, 96, 64, -192, 1, 1, 90);

        batch.draw(MarsGame.getTextures().textureRegion.get("ColorOrange"), 500, MarsGame.HEIGHT - 463, 280, 158);
        batch.draw(MarsGame.getTextures().textureRegion.get("ColorOrange"), 84, MarsGame.HEIGHT - 463, 280, 158);

        batch.draw(MarsGame.getTextures().textureRegion.get("Down"), 108, 198 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("Down"), 199, 320 + MarsGame.getRatioAdd(), 64, -64);
        if (MarsGame.getPreference().getTacticsAttackLauncherGun()) batch.draw(MarsGame.getTextures().textureRegion.get("Down"), 293, 198 + MarsGame.getRatioAdd());
        if (MarsGame.getPreference().getTacticsAttackFlareGun()) batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), 400, 262 + MarsGame.getRatioAdd());
        if (MarsGame.getPreference().getTacticsAttackLaserGun()) batch.draw(MarsGame.getTextures().textureRegion.get("DownRight"), 494, 198 + MarsGame.getRatioAdd());

        batch.draw(MarsGame.getTextures().textureRegion.get("TerminalBack"), 640, 64 + MarsGame.getRatioAdd(), 96, 256);
        batch.draw(MarsGame.getTextures().textureRegion.get("DownRight"), 685, 186 + MarsGame.getRatioAdd());

        batch.draw(MarsGame.getTextures().textureRegion.get("FrameTop"), 0, MarsGame.HEIGHT - 256);
        if (MarsGame.getRatioAdd() > 120) batch.draw(MarsGame.getTextures().textureRegion.get("FrameBottom"), 0, 1 + MarsGame.getRatioAdd(), 1920, -64);
        batch.draw(MarsGame.getTextures().textureRegion.get("FrameBottom"), 0, 0 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("Money"), MarsGame.WIDTH / 2 - 116, MarsGame.HEIGHT - 110, 45, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("Mineral"), MarsGame.WIDTH / 2 + 70, MarsGame.HEIGHT - 114, 50, 50);
        batch.end();

        stage.act();
        stage.draw();

        if (!isOffTerminal) {
            batch.begin();
            if (showWeapons != NULL) {
                if (isBuy) {
                    batch.draw(MarsGame.getTextures().textureRegion.get("Money"), 385, 430 + MarsGame.getRatioAdd(), 45, 45);
                    batch.draw(MarsGame.getTextures().textureRegion.get("Mineral"), 385, 375 + MarsGame.getRatioAdd(), 50, 50);
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("UpTower"), 150, 400 + MarsGame.getRatioAdd(), 24, 40, 48, -80, 1, 1, 90);
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("UpTower"), 92, 330 + MarsGame.getRatioAdd(), 32, 64, 64, -128, 1, 1, 90);
                }
            }
            weapons.render(batch);
            weaponsNow.render(batch);
            if (!isMax) {
                if (!weapons.getNameWeapons().equals("NULL")) {
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("UpTower"), 420, MarsGame.HEIGHT - 416, 32, 64);
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("UpTower"), MarsGame.WIDTH - 600, 410 + MarsGame.getRatioAdd());
                }
            }
            tv.render(batch, 321, 420 + MarsGame.getRatioAdd(), 257, 112, 0);
            tv.render(batch, 321, 308 + MarsGame.getRatioAdd(), 257, 112, 0);
            tv.render(batch, 64, 420 + MarsGame.getRatioAdd(), 257, 112, 0);
            tv.render(batch, 64, 308 + MarsGame.getRatioAdd(), 257, 112, 0);
            tv.render(batch, MarsGame.WIDTH - 1024, 200 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 832, 200 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 1024, 328 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 832, 328 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 1024, 456 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 832, 456 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 1024, 584 + MarsGame.getRatioAdd(), 192, 128, 0);
            tv.render(batch, MarsGame.WIDTH - 832, 584 + MarsGame.getRatioAdd(), 192, 128, 0);

            tv.render(batch, MarsGame.WIDTH - 512, 200 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 320, 200 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 512, 328 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 320, 328 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 512, 456 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 320, 456 + MarsGame.getRatioAdd(), 192, 134, 0);
            tv.render(batch, MarsGame.WIDTH - 512, 584 + MarsGame.getRatioAdd(), 192, 128, 0);
            tv.render(batch, MarsGame.WIDTH - 320, 584 + MarsGame.getRatioAdd(), 192, 128, 0);
            batch.end();
        }
    }

    @Override
    public void dispose() {
        try {
            stage.dispose();
            text.clear();
            buttons.clear();
            redLightbulb.dispose();
            yellowLightbulb.dispose();
            stars.dispose();
            tv.dispose();
            weapons = null;
            weaponsNow = null;
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
            if (name.equals("TurnOffTerminal")) touchTurnOffTerminal = true;
            else if (name.equals("MachineGun")) touchMachineGun = true;
            else if (name.equals("LauncherGun")) {
                if (MarsGame.getPreference().getTacticsAttackLauncherGun()) touchLauncherGun = true;
            } else if (name.equals("FlareGun")) {
                if (MarsGame.getPreference().getTacticsAttackFlareGun()) touchFlareGun = true;
            } else if (name.equals("LaserGun")) {
                if (MarsGame.getPreference().getTacticsAttackLaserGun()) touchLaserGun = true;
            }
            return true;
        }

        @Override
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            if (name.equals("TurnOffTerminal")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                touchTurnOffTerminal = false;
                if (isOffTerminal) {
                    isOffTerminal = false;
                    text.get("BuyPriceMoney").setPosition(448 * MarsGame.getRatioMonitorW(), (450 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("BuyPriceMineral").setPosition(448 * MarsGame.getRatioMonitorW(), (400 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                } else {
                    isOffTerminal = true;
                    text.get("BuyPriceMoney").setPosition(MarsGame.WIDTH, (450 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("BuyPriceMineral").setPosition(MarsGame.WIDTH, (400 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                }
            } else if (name.equals("MachineGun")) {
                touchMachineGun = false;
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                showWeapons = MACHINEGUN;
                terminalWeaponsPrice();
            } else if (name.equals("LauncherGun")) {
                if (MarsGame.getPreference().getTacticsAttackLauncherGun()) {
                    touchLauncherGun = false;
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    showWeapons = GRENADELAUNCHERS;
                    terminalWeaponsPrice();
                }
            } else if (name.equals("FlareGun")) {
                if (MarsGame.getPreference().getTacticsAttackFlareGun()) {
                    touchFlareGun = false;
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    showWeapons = ROCKETLAUNCHERS;
                    terminalWeaponsPrice();
                }
            } else if (name.equals("LaserGun")) {
                if (MarsGame.getPreference().getTacticsAttackLaserGun()) {
                    touchLaserGun = false;
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    showWeapons = LASERGUNS;
                    terminalWeaponsPrice();
                }
            } else if (name.equals("TerminalArsenal")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Arsenal"));
            } else if (name.equals("Buy")) {
                //region
                if (!isOffTerminal && isBuy && !weapons.getMoney().equals("0")) {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    if (showWeapons == MACHINEGUN) {
                        if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_1") || MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("")) MarsGame.getPreference().setWeaponUpgrade("MachineGun", "MachineGun_2");
                        else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_2")) MarsGame.getPreference().setWeaponUpgrade("MachineGun", "MachineGun_3");
                        else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_3")) MarsGame.getPreference().setWeaponUpgrade("MachineGun", "MachineGun_4");
                        else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_4")) MarsGame.getPreference().setWeaponUpgrade("MachineGun", "MachineGun_5");
                        else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_5")) MarsGame.getPreference().setWeaponUpgrade("MachineGun", "MachineGun_6");
                        else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_6")) MarsGame.getPreference().setWeaponUpgrade("MachineGun", "MachineGun_7");
                        else if (MarsGame.getPreference().getWeaponUpgrade("MachineGun").equals("MachineGun_7")) MarsGame.getPreference().setWeaponUpgrade("MachineGun", "MachineGun_8");
                        terminalWeaponsPrice();
                    } else if (showWeapons == GRENADELAUNCHERS) {
                        if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_1") || MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("")) MarsGame.getPreference().setWeaponUpgrade("LauncherGun", "LauncherGun_2");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_2")) MarsGame.getPreference().setWeaponUpgrade("LauncherGun", "LauncherGun_3");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_3")) MarsGame.getPreference().setWeaponUpgrade("LauncherGun", "LauncherGun_4");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_4")) MarsGame.getPreference().setWeaponUpgrade("LauncherGun", "LauncherGun_5");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_5")) MarsGame.getPreference().setWeaponUpgrade("LauncherGun", "LauncherGun_6");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_6")) MarsGame.getPreference().setWeaponUpgrade("LauncherGun", "LauncherGun_7");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LauncherGun").equals("LauncherGun_7")) MarsGame.getPreference().setWeaponUpgrade("LauncherGun", "LauncherGun_8");
                        terminalWeaponsPrice();
                    } else if (showWeapons == ROCKETLAUNCHERS) {
                        if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_1") || MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("")) MarsGame.getPreference().setWeaponUpgrade("FlareGun", "FlareGun_2");
                        else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_2")) MarsGame.getPreference().setWeaponUpgrade("FlareGun", "FlareGun_3");
                        else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_3")) MarsGame.getPreference().setWeaponUpgrade("FlareGun", "FlareGun_4");
                        else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_4")) MarsGame.getPreference().setWeaponUpgrade("FlareGun", "FlareGun_5");
                        else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_5")) MarsGame.getPreference().setWeaponUpgrade("FlareGun", "FlareGun_6");
                        else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_6")) MarsGame.getPreference().setWeaponUpgrade("FlareGun", "FlareGun_7");
                        else if (MarsGame.getPreference().getWeaponUpgrade("FlareGun").equals("FlareGun_7")) MarsGame.getPreference().setWeaponUpgrade("FlareGun", "FlareGun_8");
                        terminalWeaponsPrice();
                    } else if (showWeapons == LASERGUNS) {
                        if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_1") || MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("")) MarsGame.getPreference().setWeaponUpgrade("LaserGun", "LaserGun_2");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_2")) MarsGame.getPreference().setWeaponUpgrade("LaserGun", "LaserGun_3");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_3")) MarsGame.getPreference().setWeaponUpgrade("LaserGun", "LaserGun_4");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_4")) MarsGame.getPreference().setWeaponUpgrade("LaserGun", "LaserGun_5");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_5")) MarsGame.getPreference().setWeaponUpgrade("LaserGun", "LaserGun_6");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_6")) MarsGame.getPreference().setWeaponUpgrade("LaserGun", "LaserGun_7");
                        else if (MarsGame.getPreference().getWeaponUpgrade("LaserGun").equals("LaserGun_7")) MarsGame.getPreference().setWeaponUpgrade("LaserGun", "LaserGun_8");
                        terminalWeaponsPrice();
                    }
                    buyUpdateTower();
                }
                //endregion
            }
        }
    }
}