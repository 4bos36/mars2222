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
import studio.rashka.models.arsenal.Tactics;
import studio.rashka.models.arsenal.Weapons;
import studio.rashka.models.bridge.TV;
import studio.rashka.models.lightbulb.RedLightbulb;
import studio.rashka.models.lightbulb.YellowLightbulb;
import studio.rashka.models.robots.R_7;

public class ArsenalScreen extends State {

    private final static int NULL = 0, MACHINEGUN = 1, GRENADELAUNCHERS = 2, ROCKETLAUNCHERS = 3, LASERGUNS = 4;

    private Stage stage;
    private Map<String, Label> text;
    private boolean isBuyTactics = false, touchTurnOffTerminal = false, touchMachineGun = false, touchLauncherGun = false,
            touchFlareGun = false, touchLaserGun = false, isOffTerminal = false, touchReset = false, showReset = false,
            touchWeapons_1 = false, touchWeapons_2 = false, touchWeapons_3 = false, touchWeapons_4 = false,
            touchWeapons_5 = false, touchWeapons_6 = false, touchWeapons_7 = false, touchWeapons_8 = false,
            touchAttack = false, touchDefense = false, touchTechnologies = false;
    private int showWeapons = NULL;
    private String showInfoBuy = "NULL";

    private Map<String, Buttons> buttons;
    private TV tv;
    private R_7 r_7;
    private RedLightbulb redLightbulb;
    private YellowLightbulb yellowLightbulb;
    private Stars stars;
    private Weapons weapons;
    private Tactics tactics;

    private static final Drawable img = MarsGame.getTextures().getTextureButtonSkin().getDrawable("NULL");
    private static final LabelStyle style28 = new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE);

    public ArsenalScreen(Game game) {
        super(game);
        tv = new TV();
        redLightbulb = new RedLightbulb();
        yellowLightbulb = new YellowLightbulb();
        stars = new Stars();
        r_7 = new R_7();
        weapons = new Weapons();
        tactics = new Tactics();

        stage = new Stage();
        text = new HashMap<String, Label>();
        buttons = new HashMap<String, Buttons>();

        textLoading();
        menuButtons();
        r_7.setX(320);
        r_7.setAddToMove(576);
        r_7.setY(96);
        r_7.setMove(1);
        stage.addActor(r_7.getClick());

        textPutGet();
        buttons();
        Gdx.input.setInputProcessor(stage);
    }

    private void textPutGet() {
        text.put("Money", new Label(String.valueOf(MarsGame.getPreference().loadMoney()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.MAGENTA)));
        text.put("Mineral", new Label(String.valueOf(MarsGame.getPreference().loadMineral()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.GREEN)));
        text.put("Installed", new Label("", new LabelStyle(FontTTF.getInstance().getFont40(), Color.WHITE)));
        text.put("InstallBuy", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.BLACK)));
        text.put("BuyPriceMoney", new Label("", new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));
        text.put("BuyPriceMineral", new Label("", new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));
        text.put("EnergyWeapon", new Label("", new LabelStyle(FontTTF.getInstance().getFont35(), Color.GOLD)));
        text.put("TacticsName", new Label("", new LabelStyle(FontTTF.getInstance().getFont35(), Color.SKY)));
        text.put("TacticsInfo", new Label("", new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));
        text.put("TacticsMoney", new Label("", new LabelStyle(FontTTF.getInstance().getFont40(), Color.WHITE)));
        text.put("TacticsMineral", new Label("", new LabelStyle(FontTTF.getInstance().getFont40(), Color.WHITE)));
        text.put("Current", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.GOLD)));
        text.put("Next", new Label("", new LabelStyle(FontTTF.getInstance().getFont28(), Color.GOLDENROD)));
        text.put("BuyTactics", new Label("", new LabelStyle(FontTTF.getInstance().getFont40(), Color.WHITE)));

        text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
        text.get("Mineral").setPosition((MarsGame.WIDTH / 2 + 132) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
        text.get("Installed").setPosition(224 * MarsGame.getRatioMonitorW() - text.get("Installed").getPrefWidth() / 2, (MarsGame.HEIGHT - 380) * MarsGame.getRatioMonitorH());
        text.get("InstallBuy").setPosition(224 * MarsGame.getRatioMonitorW() - text.get("InstallBuy").getPrefWidth() / 2, (MarsGame.HEIGHT - 460) * MarsGame.getRatioMonitorH());
        text.get("BuyPriceMoney").setPosition(220 * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 345) * MarsGame.getRatioMonitorH());
        text.get("BuyPriceMineral").setPosition(220 * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 395) * MarsGame.getRatioMonitorH());
        text.get("EnergyWeapon").setPosition((MarsGame.WIDTH - 444) * MarsGame.getRatioMonitorW(), (240 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("TacticsName").setPosition(220 * MarsGame.getRatioMonitorW(), (230 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("TacticsInfo").setPosition(128 * MarsGame.getRatioMonitorW(), (128 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("TacticsMoney").setPosition((MarsGame.WIDTH / 2 - 205) * MarsGame.getRatioMonitorW() - text.get("TacticsMoney").getPrefWidth(), (235 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("TacticsMineral").setPosition((MarsGame.WIDTH / 2 - 70) * MarsGame.getRatioMonitorW(), (235 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Current").setPosition(200 * MarsGame.getRatioMonitorW(), (200 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Next").setPosition(200 * MarsGame.getRatioMonitorW(), (175 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("Money"));
        stage.addActor(text.get("Mineral"));
        stage.addActor(text.get("Installed"));
        stage.addActor(text.get("InstallBuy"));
        stage.addActor(text.get("BuyPriceMoney"));
        stage.addActor(text.get("BuyPriceMineral"));
        stage.addActor(text.get("EnergyWeapon"));
        stage.addActor(text.get("TacticsName"));
        stage.addActor(text.get("TacticsInfo"));
        stage.addActor(text.get("TacticsMoney"));
        stage.addActor(text.get("TacticsMineral"));
        stage.addActor(text.get("Current"));
        stage.addActor(text.get("Next"));
        stage.addActor(text.get("BuyTactics"));
    }

    private void textLoading() {
        text.put("OnOff", new Label(MarsGame.getLanguage().textScreen.get("OnOff"), style28));
        text.put("MachineGun", new Label(MarsGame.getLanguage().textScreen.get("MachineGun"), style28));
        text.put("LauncherGun", new Label(MarsGame.getLanguage().textScreen.get("LauncherGun"), style28));
        text.put("FlareGun", new Label(MarsGame.getLanguage().textScreen.get("FlareGun"), style28));
        text.put("LaserGun", new Label(MarsGame.getLanguage().textScreen.get("LaserGun"), style28));
        text.put("Attack", new Label(MarsGame.getLanguage().textScreen.get("Attack"), style28));
        text.put("Defense", new Label(MarsGame.getLanguage().textScreen.get("Defense"), style28));
        text.put("Technologies", new Label(MarsGame.getLanguage().textScreen.get("Technologies"), style28));
        if (MarsGame.getPreference().loadMissionFinish("Missions_4_3"))
            text.put("TerminalUpdateTower", new Label(MarsGame.getLanguage().textScreen.get("TerminalUpdateTower"), style28));
        else text.put("TerminalUpdateTower", new Label("", style28));

        text.get("OnOff").setPosition(108 * MarsGame.getRatioMonitorW(), (180 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("MachineGun").setPosition(190 * MarsGame.getRatioMonitorW(), (305 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("LauncherGun").setPosition(275 * MarsGame.getRatioMonitorW(), (180 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("FlareGun").setPosition(462 * MarsGame.getRatioMonitorW(), (295 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("LaserGun").setPosition(556 * MarsGame.getRatioMonitorW(), (200 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Attack").setPosition((MarsGame.WIDTH / 2 - 205) * MarsGame.getRatioMonitorW() - text.get("Attack").getPrefWidth(), (MarsGame.HEIGHT / 2 - 15 + MarsGame.getRatioAdd() / 2) * MarsGame.getRatioMonitorH());
        text.get("Defense").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("Defense").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + MarsGame.getRatioAdd() / 2) * MarsGame.getRatioMonitorH());
        text.get("Technologies").setPosition((MarsGame.WIDTH / 2 + 205) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT / 2 - 15 + MarsGame.getRatioAdd() / 2) * MarsGame.getRatioMonitorH());
        text.get("TerminalUpdateTower").setPosition((MarsGame.WIDTH / 2 + 310) * MarsGame.getRatioMonitorW() - text.get("TerminalUpdateTower").getPrefWidth(), (250 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        menuButtonsText();

        stage.addActor(text.get("OnOff"));
        stage.addActor(text.get("MachineGun"));
        stage.addActor(text.get("LauncherGun"));
        stage.addActor(text.get("FlareGun"));
        stage.addActor(text.get("LaserGun"));
        stage.addActor(text.get("Attack"));
        stage.addActor(text.get("Defense"));
        stage.addActor(text.get("Technologies"));
        stage.addActor(text.get("TerminalUpdateTower"));
    }

    private void buttons() {
        buttons.put("TurnOffTerminal", new Buttons("TurnOffTerminal", img, 60, 60, 106, 232 + MarsGame.getRatioAdd()));
        buttons.put("MachineGun", new Buttons("MachineGun", img, 60, 60, 198, 232 + MarsGame.getRatioAdd()));
        buttons.put("LauncherGun", new Buttons("LauncherGun", img, 60, 60, 290, 232 + MarsGame.getRatioAdd()));
        buttons.put("FlareGun", new Buttons("FlareGun", img, 60, 60, 382, 232 + MarsGame.getRatioAdd()));
        buttons.put("LaserGun", new Buttons("LaserGun", img, 60, 60, 476, 232 + MarsGame.getRatioAdd()));
        buttons.put("BuyActive", new Buttons("BuyActive", img, 100, 80, 170, MarsGame.HEIGHT - 490));
        buttons.put("BuyTactics", new Buttons("BuyTactics", img, 128, 64, MarsGame.WIDTH / 2 - 210, 305 + MarsGame.getRatioAdd()));
        buttons.put("TerminalUpdateTower", new Buttons("TerminalUpdateTower", img, 128, 128, MarsGame.WIDTH / 2 + 310, 256 + MarsGame.getRatioAdd()));

        buttons.put("Weapons_1", new Buttons("Weapons_1", img, 92, 92, 88, 430 + MarsGame.getRatioAdd()));
        buttons.put("Weapons_2", new Buttons("Weapons_2", img, 92, 92, 212, 430 + MarsGame.getRatioAdd()));
        buttons.put("Weapons_3", new Buttons("Weapons_3", img, 92, 92, 336, 430 + MarsGame.getRatioAdd()));
        buttons.put("Weapons_4", new Buttons("Weapons_4", img, 92, 92, 460, 430 + MarsGame.getRatioAdd()));
        buttons.put("Weapons_5", new Buttons("Weapons_5", img, 92, 92, 88, 320 + MarsGame.getRatioAdd()));
        buttons.put("Weapons_6", new Buttons("Weapons_6", img, 92, 92, 212, 320 + MarsGame.getRatioAdd()));
        buttons.put("Weapons_7", new Buttons("Weapons_7", img, 92, 92, 336, 320 + MarsGame.getRatioAdd()));
        buttons.put("Weapons_8", new Buttons("Weapons_8", img, 92, 92, 460, 320 + MarsGame.getRatioAdd()));

        buttons.put("Attack", new Buttons("Attack", img, 120, 120, MarsGame.WIDTH / 2 - 206, MarsGame.HEIGHT / 2 - 145 + MarsGame.getRatioAdd() / 2));
        buttons.put("Defense", new Buttons("Defense", img, 120, 120, MarsGame.WIDTH / 2 - 60, MarsGame.HEIGHT / 2 - 145 + MarsGame.getRatioAdd() / 2));
        buttons.put("Technologies", new Buttons("Technologies", img, 120, 120, MarsGame.WIDTH / 2 + 86, MarsGame.HEIGHT / 2 - 145 + MarsGame.getRatioAdd() / 2));
        buttons.put("Reset", new Buttons("Reset", img, 128, 128, MarsGame.WIDTH - 200, 80 + MarsGame.getRatioAdd()));

        buttons.put("Tactic_1", new Buttons("Tactic_1", img, 120, 120, MarsGame.WIDTH + 450, MarsGame.HEIGHT - 312));
        buttons.put("Tactic_2", new Buttons("Tactic_2", img, 160, 160, MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2));
        buttons.put("Tactic_3", new Buttons("Tactic_3", img, 160, 160, MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2));
        buttons.put("Tactic_4", new Buttons("Tactic_4", img, 160, 160, MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2));
        buttons.put("Tactic_5", new Buttons("Tactic_5", img, 160, 160, MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2));
        buttons.put("Tactic_6", new Buttons("Tactic_6", img, 160, 160, MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2));
        buttons.put("Tactic_7", new Buttons("Tactic_7", img, 160, 160, MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2));
        buttons.put("Tactic_8", new Buttons("Tactic_8", img, 160, 160, MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2));
        buttons.put("Tactic_9", new Buttons("Tactic_9", img, 160, 160, MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2));
        buttons.put("Tactic_10", new Buttons("Tactic_10", img, 160, 160, MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2));
        buttons.put("Tactic_11", new Buttons("Tactic_11", img, 160, 160, MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2));

        buttons.get("Tactic_1").addListener(new ButtonsInputListener(buttons.get("Tactic_1").getName()));
        buttons.get("Tactic_2").addListener(new ButtonsInputListener(buttons.get("Tactic_2").getName()));
        buttons.get("Tactic_3").addListener(new ButtonsInputListener(buttons.get("Tactic_3").getName()));
        buttons.get("Tactic_4").addListener(new ButtonsInputListener(buttons.get("Tactic_4").getName()));
        buttons.get("Tactic_5").addListener(new ButtonsInputListener(buttons.get("Tactic_5").getName()));
        buttons.get("Tactic_6").addListener(new ButtonsInputListener(buttons.get("Tactic_6").getName()));
        buttons.get("Tactic_7").addListener(new ButtonsInputListener(buttons.get("Tactic_7").getName()));
        buttons.get("Tactic_8").addListener(new ButtonsInputListener(buttons.get("Tactic_8").getName()));
        buttons.get("Tactic_9").addListener(new ButtonsInputListener(buttons.get("Tactic_9").getName()));
        buttons.get("Tactic_10").addListener(new ButtonsInputListener(buttons.get("Tactic_10").getName()));
        buttons.get("Tactic_11").addListener(new ButtonsInputListener(buttons.get("Tactic_11").getName()));

        buttons.get("TurnOffTerminal").addListener(new ButtonsInputListener(buttons.get("TurnOffTerminal").getName()));
        buttons.get("MachineGun").addListener(new ButtonsInputListener(buttons.get("MachineGun").getName()));
        buttons.get("LauncherGun").addListener(new ButtonsInputListener(buttons.get("LauncherGun").getName()));
        buttons.get("FlareGun").addListener(new ButtonsInputListener(buttons.get("FlareGun").getName()));
        buttons.get("LaserGun").addListener(new ButtonsInputListener(buttons.get("LaserGun").getName()));
        buttons.get("BuyActive").addListener(new ButtonsInputListener(buttons.get("BuyActive").getName()));
        buttons.get("BuyTactics").addListener(new ButtonsInputListener(buttons.get("BuyTactics").getName()));
        buttons.get("TerminalUpdateTower").addListener(new ButtonsInputListener(buttons.get("TerminalUpdateTower").getName()));
        buttons.get("Weapons_1").addListener(new ButtonsInputListener(buttons.get("Weapons_1").getName()));
        buttons.get("Weapons_2").addListener(new ButtonsInputListener(buttons.get("Weapons_2").getName()));
        buttons.get("Weapons_3").addListener(new ButtonsInputListener(buttons.get("Weapons_3").getName()));
        buttons.get("Weapons_4").addListener(new ButtonsInputListener(buttons.get("Weapons_4").getName()));
        buttons.get("Weapons_5").addListener(new ButtonsInputListener(buttons.get("Weapons_5").getName()));
        buttons.get("Weapons_6").addListener(new ButtonsInputListener(buttons.get("Weapons_6").getName()));
        buttons.get("Weapons_7").addListener(new ButtonsInputListener(buttons.get("Weapons_7").getName()));
        buttons.get("Weapons_8").addListener(new ButtonsInputListener(buttons.get("Weapons_8").getName()));
        buttons.get("Attack").addListener(new ButtonsInputListener(buttons.get("Attack").getName()));
        buttons.get("Defense").addListener(new ButtonsInputListener(buttons.get("Defense").getName()));
        buttons.get("Technologies").addListener(new ButtonsInputListener(buttons.get("Technologies").getName()));
        buttons.get("Reset").addListener(new ButtonsInputListener(buttons.get("Reset").getName()));

        stage.addActor(buttons.get("TurnOffTerminal"));
        stage.addActor(buttons.get("MachineGun"));
        stage.addActor(buttons.get("LauncherGun"));
        stage.addActor(buttons.get("FlareGun"));
        stage.addActor(buttons.get("LaserGun"));
        stage.addActor(buttons.get("BuyActive"));
        stage.addActor(buttons.get("BuyTactics"));
        stage.addActor(buttons.get("TerminalUpdateTower"));
        stage.addActor(buttons.get("Weapons_1"));
        stage.addActor(buttons.get("Weapons_2"));
        stage.addActor(buttons.get("Weapons_3"));
        stage.addActor(buttons.get("Weapons_4"));
        stage.addActor(buttons.get("Weapons_5"));
        stage.addActor(buttons.get("Weapons_6"));
        stage.addActor(buttons.get("Weapons_7"));
        stage.addActor(buttons.get("Weapons_8"));

        stage.addActor(buttons.get("Tactic_1"));
        stage.addActor(buttons.get("Tactic_2"));
        stage.addActor(buttons.get("Tactic_3"));
        stage.addActor(buttons.get("Tactic_4"));
        stage.addActor(buttons.get("Tactic_5"));
        stage.addActor(buttons.get("Tactic_6"));
        stage.addActor(buttons.get("Tactic_7"));
        stage.addActor(buttons.get("Tactic_8"));
        stage.addActor(buttons.get("Tactic_9"));
        stage.addActor(buttons.get("Tactic_10"));
        stage.addActor(buttons.get("Tactic_11"));

        stage.addActor(buttons.get("Attack"));
        stage.addActor(buttons.get("Defense"));
        stage.addActor(buttons.get("Technologies"));
        stage.addActor(buttons.get("Reset"));
    }

    private void attack() {
        if (tactics.getNameTacticObject().equals("AttackStart")) {
            if (!MarsGame.getPreference().getTacticsAttackStart()) {
                MarsGame.getPreference().setTacticsAttackStart(true);
                showReset = true;
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("AttackGenerator")) {
            if (!MarsGame.getPreference().getTacticsAttackGenerator()) {
                MarsGame.getPreference().setTacticsAttackGenerator(true);
                MarsGame.getPreference().setTacticsAttackGeneratorPowerShot(5);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("AttackGeneratorPowerShot")) {
            MarsGame.getPreference().setTacticsAttackGeneratorPowerShot(1);
            buyUpdateDate();
            text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackGeneratorPowerShot()));
            text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackGeneratorPowerShot() + 1));
            buttonBuyTactics(0);
        } else if (tactics.getNameTacticObject().equals("AttackGeneratorEnergy")) {
            if (MarsGame.getPreference().getTacticsAttackGeneratorEnergy() > 20) {
                MarsGame.getPreference().setTacticsAttackGeneratorEnergy(5);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackGeneratorEnergy()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackGeneratorEnergy() - 5));
                if (MarsGame.getPreference().getTacticsAttackGenerator()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsAttackGenerator()) buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsAttackGeneratorEnergy() == 20) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackGeneratorEnergy()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("AttackPowerShot")) {
            if (MarsGame.getPreference().getTacticsAttackPowerShot() < 80) {
                MarsGame.getPreference().setTacticsAttackPowerShot(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackPowerShot()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackPowerShot() + 1));
                if (MarsGame.getPreference().getTacticsAttackGenerator()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsAttackGenerator()) buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsAttackPowerShot() == 80) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackPowerShot()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("AttackLauncherGun")) {
            if (!MarsGame.getPreference().getTacticsAttackLauncherGun()) {
                MarsGame.getPreference().setTacticsAttackLauncherGun(true);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("AttackLauncherGunEnergy")) {
            if (MarsGame.getPreference().getTacticsAttackLauncherGunEnergy() > 1) {
                MarsGame.getPreference().setTacticsAttackLauncherGunEnergy(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackLauncherGunEnergy()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackLauncherGunEnergy() - 1));
                if (MarsGame.getPreference().getTacticsAttackLauncherGun()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsAttackLauncherGun())
                    buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsAttackLauncherGunEnergy() == 1) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackLauncherGunEnergy()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("AttackFlareGun")) {
            if (!MarsGame.getPreference().getTacticsAttackFlareGun()) {
                MarsGame.getPreference().setTacticsAttackFlareGun(true);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("AttackFlareGunEnergy")) {
            if (MarsGame.getPreference().getTacticsAttackFlareGunEnergy() > 1) {
                MarsGame.getPreference().setTacticsAttackFlareGunEnergy(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackFlareGunEnergy()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackFlareGunEnergy() - 1));
                if (MarsGame.getPreference().getTacticsAttackFlareGun()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsAttackFlareGun()) buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsAttackFlareGunEnergy() == 1) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackFlareGunEnergy()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("AttackLaserGun")) {
            if (!MarsGame.getPreference().getTacticsAttackLaserGun()) {
                MarsGame.getPreference().setTacticsAttackLaserGun(true);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("AttackLaserGunEnergy")) {
            if (MarsGame.getPreference().getTacticsAttackLaserGunEnergy() > 1) {
                MarsGame.getPreference().setTacticsAttackLaserGunEnergy(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackLaserGunEnergy()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackLaserGunEnergy() - 1));
                if (MarsGame.getPreference().getTacticsAttackLaserGun()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsAttackLaserGun()) buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsAttackLaserGunEnergy() == 1) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackLaserGunEnergy()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("Reset")) {
            MarsGame.getPreference().settingsTactics();
            showReset = false;
            buyUpdateDate();
            text.get("Current").setText("");
            text.get("Next").setText("");
            buttonBuyTactics(1);
        }
    }

    private void defense() {
        if (tactics.getNameTacticObject().equals("DefenseStart")) {
            if (!MarsGame.getPreference().getTacticsDefenseStart()) {
                MarsGame.getPreference().setTacticsDefenseStart(true);
                showReset = true;
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("DefenseGenerator")) {
            if (!MarsGame.getPreference().getTacticsDefenseGenerator()) {
                MarsGame.getPreference().setTacticsDefenseGenerator(true);
                MarsGame.getPreference().setTacticsDefenseGeneratorPowerShield(5);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("DefenseGeneratorPowerShield")) {
            if (MarsGame.getPreference().getTacticsDefenseGeneratorPowerShield() < 60) {
                MarsGame.getPreference().setTacticsDefenseGeneratorPowerShield(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseGeneratorPowerShield()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseGeneratorPowerShield() + 1));
                if (MarsGame.getPreference().getTacticsDefenseGenerator()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsDefenseGenerator())
                    buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsDefenseGeneratorPowerShield() == 60) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseGeneratorPowerShield()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("DefenseGeneratorEnergy")) {
            if (MarsGame.getPreference().getTacticsDefenseGeneratorEnergy() > 20) {
                MarsGame.getPreference().setTacticsDefenseGeneratorEnergy(5);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseGeneratorEnergy()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseGeneratorEnergy() - 5));
                if (MarsGame.getPreference().getTacticsDefenseGenerator()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsDefenseGenerator())
                    buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsDefenseGeneratorEnergy() == 20) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseGeneratorEnergy()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("DefenseHeartLife")) {
            if (MarsGame.getPreference().getTacticsDefenseHeartLife() == 0) {
                MarsGame.getPreference().setTacticsDefenseHeartLife(30);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(0));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(30));
                if (MarsGame.getPreference().getTacticsDefenseGenerator()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsDefenseGenerator())
                    buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsDefenseHeartLife() > 0 && MarsGame.getPreference().getTacticsDefenseHeartLife() < 80) {
                MarsGame.getPreference().setTacticsDefenseHeartLife(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseHeartLife()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseHeartLife() + 1));
                if (MarsGame.getPreference().getTacticsDefenseGenerator()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsDefenseGenerator())
                    buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsDefenseHeartLife() == 80) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseHeartLife()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("DefenseShieldHP")) {
            if (!MarsGame.getPreference().getTacticsDefenseShieldHP()) {
                MarsGame.getPreference().setTacticsDefenseShieldHP(true);
                MarsGame.getPreference().setTacticsDefenseShieldHPup(10);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("DefenseShieldHPup")) {
            if (MarsGame.getPreference().getTacticsDefenseShieldHPup() < 60) {
                MarsGame.getPreference().setTacticsDefenseShieldHPup(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseShieldHPup()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseShieldHPup() + 1));
                if (MarsGame.getPreference().getTacticsDefenseShieldHP()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsDefenseShieldHP()) buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsDefenseShieldHPup() == 60) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseShieldHPup()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("DefenseEnergy")) {
            if (!MarsGame.getPreference().getTacticsDefenseEnergy()) {
                MarsGame.getPreference().setTacticsDefenseEnergy(true);
                MarsGame.getPreference().setTacticsDefenseEnergyUp(10);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("DefenseEnergyUp")) {
            if (MarsGame.getPreference().getTacticsDefenseEnergyUp() < 60) {
                MarsGame.getPreference().setTacticsDefenseEnergyUp(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseEnergyUp()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseEnergyUp() + 1));
                if (MarsGame.getPreference().getTacticsDefenseEnergy()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsDefenseEnergy()) buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsDefenseEnergyUp() == 60) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseEnergyUp()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("DefenseMicrowave")) {
            if (!MarsGame.getPreference().getTacticsDefenseMicrowave()) {
                MarsGame.getPreference().setTacticsDefenseMicrowave(true);
                MarsGame.getPreference().setTacticsDefenseMicrowaveUp(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("DefenseMicrowaveUp")) {
            if (MarsGame.getPreference().getTacticsDefenseMicrowaveUp() < 10.0f) {
                MarsGame.getPreference().setTacticsDefenseMicrowaveUp(0.5f);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseMicrowaveUp()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseMicrowaveUp() + 0.5f));
                if (MarsGame.getPreference().getTacticsDefenseMicrowave()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsDefenseMicrowave())
                    buttonBuyTactics(1);
            } else if (MarsGame.getPreference().getTacticsDefenseMicrowaveUp() == 10.0f) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseMicrowaveUp()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("Reset")) {
            MarsGame.getPreference().settingsTactics();
            showReset = false;
            buyUpdateDate();
            text.get("Current").setText("");
            text.get("Next").setText("");
            buttonBuyTactics(1);
        }
    }

    private void technologies() {
        if (tactics.getNameTacticObject().equals("TechnologiesStart")) {
            if (!MarsGame.getPreference().getTacticsTechnologiesStart()) {
                MarsGame.getPreference().setTacticsTechnologiesStart(true);
                showReset = true;
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("TechnologiesRadar")) {
            if (!MarsGame.getPreference().getTacticsTechnologiesRadar()) {
                MarsGame.getPreference().setTacticsTechnologiesRadar(true);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("TechnologiesShowMonsterLife")) {
            if (!MarsGame.getPreference().getTacticsTechnologiesShowMonsterLife()) {
                MarsGame.getPreference().setTacticsTechnologiesShowMonsterLife(true);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("TechnologiesRadarEnergy")) {
            if (MarsGame.getPreference().getTacticsTechnologiesRadarEnergy() > 20) {
                MarsGame.getPreference().setTacticsTechnologiesRadarEnergy(5);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRadarEnergy()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesRadarEnergy() - 5));
                if (MarsGame.getPreference().getTacticsTechnologiesRadar()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsTechnologiesRadar())
                    buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsTechnologiesRadarEnergy() == 20) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRadarEnergy()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("TechnologiesRobot")) {
            if (MarsGame.getPreference().getTacticsTechnologiesRobot() < 5) {
                MarsGame.getPreference().setTacticsTechnologiesRobot(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRobot()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesRobot() + 1));
                if (MarsGame.getPreference().getTacticsTechnologiesRadar()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsTechnologiesRadar())
                    buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsTechnologiesRobot() == 5) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRobot()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("TechnologiesPower")) {
            if (!MarsGame.getPreference().getTacticsTechnologiesPower()) {
                MarsGame.getPreference().setTacticsTechnologiesPower(true);
                MarsGame.getPreference().setTacticsTechnologiesPowerEnergy(2);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("TechnologiesPowerEnergy")) {
            if (MarsGame.getPreference().getTacticsTechnologiesPowerEnergy() < 10) {
                MarsGame.getPreference().setTacticsTechnologiesPowerEnergy(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesPowerEnergy()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesPowerEnergy() + 1));
                if (MarsGame.getPreference().getTacticsTechnologiesPower()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsTechnologiesPower())
                    buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsTechnologiesPowerEnergy() == 10) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesPowerEnergy()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("TechnologiesCarryingCapacity")) {
            if (MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity() < 7) {
                MarsGame.getPreference().setTacticsTechnologiesCarryingCapacity(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity() + 1));
                if (MarsGame.getPreference().getTacticsTechnologiesRobot() > 2) buttonBuyTactics(0);
                else if (MarsGame.getPreference().getTacticsTechnologiesRobot() <= 2)
                    buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity() == 7) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("TechnologiesRobotSpeed")) {
            if (MarsGame.getPreference().getTacticsTechnologiesRobotSpeed() < 45) {
                MarsGame.getPreference().setTacticsTechnologiesRobotSpeed(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRobotSpeed()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesRobotSpeed() + 1));
                if (MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity() > 2)
                    buttonBuyTactics(0);
                else if (MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity() <= 2)
                    buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsTechnologiesRobotSpeed() == 45) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRobotSpeed()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("TechnologiesConverter")) {
            if (!MarsGame.getPreference().getTacticsTechnologiesConverter()) {
                MarsGame.getPreference().setTacticsTechnologiesConverter(true);
                MarsGame.getPreference().setTacticsTechnologiesConverterLife(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("TechnologiesConverterLife")) {
            if (MarsGame.getPreference().getTacticsTechnologiesConverterLife() < 10) {
                MarsGame.getPreference().setTacticsTechnologiesConverterLife(1);
                buyUpdateDate();
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesConverterLife()));
                text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesConverterLife() + 1));
                if (MarsGame.getPreference().getTacticsTechnologiesConverter()) buttonBuyTactics(0);
                else if (!MarsGame.getPreference().getTacticsTechnologiesConverter())
                    buttonBuyTactics(1);
            }
            if (MarsGame.getPreference().getTacticsTechnologiesConverterLife() == 10) {
                text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesConverterLife()));
                text.get("Next").setText("");
                buttonBuyTactics(1);
            }
        } else if (tactics.getNameTacticObject().equals("Reset")) {
            MarsGame.getPreference().settingsTactics();
            showReset = false;
            buyUpdateDate();
            text.get("Current").setText("");
            text.get("Next").setText("");
            buttonBuyTactics(1);
        }
    }

    private void setNameInfoWeapons(String name) {
        weapons.setNameWeapons(name);
        text.get("BuyPriceMoney").setColor(Color.WHITE);
        text.get("BuyPriceMineral").setColor(Color.WHITE);

        if (MarsGame.getPreference().getWeaponInstalled(name)) {
            showInfoBuy = "NULL";
            text.get("Installed").setText(MarsGame.getLanguage().textScreen.get("Installed"));
            text.get("Installed").setPosition(224 * MarsGame.getRatioMonitorW() - text.get("Installed").getPrefWidth() / 2, (MarsGame.HEIGHT - 380) * MarsGame.getRatioMonitorH());
            text.get("InstallBuy").setText("");
            text.get("BuyPriceMoney").setText("");
            text.get("BuyPriceMineral").setText("");
        } else if (MarsGame.getPreference().getWeaponBuy(name)) {
            showInfoBuy = "Buy";
            text.get("InstallBuy").setText(MarsGame.getLanguage().textScreen.get("Buy"));
            text.get("InstallBuy").setPosition(224 * MarsGame.getRatioMonitorW() - text.get("InstallBuy").getPrefWidth() / 2, (MarsGame.HEIGHT - 445) * MarsGame.getRatioMonitorH());
            text.get("Installed").setText("");

            weapons.price();
            text.get("BuyPriceMoney").setText(weapons.getMoney());
            text.get("BuyPriceMineral").setText(weapons.getMineral());
            if (MarsGame.getPreference().loadMoney() < Integer.parseInt(weapons.getMoney()))
                text.get("BuyPriceMoney").setColor(Color.ORANGE);
            if (MarsGame.getPreference().loadMineral() < Integer.parseInt(weapons.getMineral()))
                text.get("BuyPriceMineral").setColor(Color.ORANGE);
        } else if (!MarsGame.getPreference().getWeaponBuy(name)) {
            showInfoBuy = "Install";
            text.get("InstallBuy").setText(MarsGame.getLanguage().textScreen.get("Install"));
            text.get("InstallBuy").setPosition(224 * MarsGame.getRatioMonitorW() - text.get("InstallBuy").getPrefWidth() / 2, (MarsGame.HEIGHT - 445) * MarsGame.getRatioMonitorH());
            text.get("Installed").setText("");
            text.get("BuyPriceMoney").setText("");
            text.get("BuyPriceMineral").setText("");
        }
        weapons.price();
        text.get("EnergyWeapon").setText(weapons.getEnergy());
    }

    private void hideTextWeapons() {
        text.get("Installed").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 380) * MarsGame.getRatioMonitorH());
        text.get("InstallBuy").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 460) * MarsGame.getRatioMonitorH());
        text.get("BuyPriceMoney").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 345) * MarsGame.getRatioMonitorH());
        text.get("BuyPriceMineral").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 395) * MarsGame.getRatioMonitorH());
        text.get("EnergyWeapon").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (220 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        text.get("OnOff").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (180 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("MachineGun").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (305 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("LauncherGun").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (180 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("FlareGun").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (295 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("LaserGun").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (200 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Attack").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT / 2 - 15 + MarsGame.getRatioAdd() / 2) * MarsGame.getRatioMonitorH());
        text.get("Defense").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT / 2 + MarsGame.getRatioAdd() / 2) * MarsGame.getRatioMonitorH());
        text.get("Technologies").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT / 2 - 15 + MarsGame.getRatioAdd() / 2) * MarsGame.getRatioMonitorH());
        text.get("TerminalUpdateTower").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), (250 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
    }

    private void buttonBuyTactics(int show) {
        if (show == 0) {
            if (MarsGame.getPreference().loadMoney() < Integer.parseInt(tactics.getMoney()) ||
                    MarsGame.getPreference().loadMineral() < Integer.parseInt(tactics.getMineral())) {
                text.get("BuyTactics").setText(MarsGame.getLanguage().textScreen.get("NotBuyTactics"));
                text.get("BuyTactics").setPosition((MarsGame.WIDTH / 2 - 145) * MarsGame.getRatioMonitorW() - text.get("BuyTactics").getPrefWidth() / 2, (330 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                tactics.setBuyPositionX(text.get("BuyTactics").getX());
                tactics.setBuyWidth(text.get("BuyTactics").getPrefWidth());
                isBuyTactics = false;
            } else {
                text.get("BuyTactics").setText(MarsGame.getLanguage().textScreen.get("BuyTactics"));
                text.get("BuyTactics").setPosition((MarsGame.WIDTH / 2 - 145) * MarsGame.getRatioMonitorW() - text.get("BuyTactics").getPrefWidth() / 2, (330 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                tactics.setBuyPositionX(text.get("BuyTactics").getX());
                tactics.setBuyWidth(text.get("BuyTactics").getPrefWidth());
                isBuyTactics = true;
            }
            if (MarsGame.getPreference().loadMoney() < Integer.parseInt(tactics.getMoney()))
                text.get("TacticsMoney").setColor(Color.RED);
            else text.get("TacticsMoney").setColor(Color.WHITE);
            if (MarsGame.getPreference().loadMineral() < Integer.parseInt(tactics.getMineral()))
                text.get("TacticsMineral").setColor(Color.RED);
            else text.get("TacticsMineral").setColor(Color.WHITE);
            text.get("TacticsMoney").setText(tactics.getMoney());
            text.get("TacticsMineral").setText(tactics.getMineral());
            text.get("TacticsMoney").setPosition((MarsGame.WIDTH / 2 - 205) * MarsGame.getRatioMonitorW() - text.get("TacticsMoney").getPrefWidth(), (235 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        } else if (show == 1) {
            text.get("BuyTactics").setText(MarsGame.getLanguage().textScreen.get("NotBuyTactics"));
            text.get("BuyTactics").setPosition((MarsGame.WIDTH / 2 - 145) * MarsGame.getRatioMonitorW() - text.get("BuyTactics").getPrefWidth() / 2, (330 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            tactics.setBuyPositionX(text.get("BuyTactics").getX());
            tactics.setBuyWidth(text.get("BuyTactics").getPrefWidth());
            isBuyTactics = false;
            text.get("TacticsMoney").setText("-");
            text.get("TacticsMineral").setText("-");
            text.get("TacticsMoney").setColor(Color.WHITE);
            text.get("TacticsMineral").setColor(Color.WHITE);
            text.get("TacticsMoney").setPosition((MarsGame.WIDTH / 2 - 205) * MarsGame.getRatioMonitorW() - text.get("TacticsMoney").getPrefWidth(), (235 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        }
    }

    private void buyUpdateDate() {
        MarsGame.getPreference().saveCredit(-Integer.parseInt(tactics.getMoney()), -Integer.parseInt(tactics.getMineral()));
        text.get("Money").setText(String.valueOf(MarsGame.getPreference().loadMoney()));
        text.get("Mineral").setText(String.valueOf(MarsGame.getPreference().loadMineral()));
        text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
    }

    private void buttonsTacticsObjectShow() {
        buttons.get("Tactic_1").setPosition(184, MarsGame.HEIGHT - 312);
        buttons.get("Tactic_2").setPosition(MarsGame.WIDTH / 2 - 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_3").setPosition(MarsGame.WIDTH / 2 - 580, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_4").setPosition(MarsGame.WIDTH / 2 - 320, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_5").setPosition(MarsGame.WIDTH / 2 - 140, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_6").setPosition(MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_7").setPosition(MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_8").setPosition(MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_9").setPosition(MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_10").setPosition(MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_11").setPosition(MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2);

        text.get("Hangar").setPosition(MarsGame.WIDTH * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Bridge").setPosition(MarsGame.WIDTH * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Arsenal").setPosition(MarsGame.WIDTH * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Laboratory").setPosition(MarsGame.WIDTH * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Reactor").setPosition(MarsGame.WIDTH * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
    }

    private void buttonsTacticsObjectHide() {
        buttons.get("Tactic_1").setPosition(MarsGame.WIDTH + 450, MarsGame.HEIGHT - 312);
        buttons.get("Tactic_2").setPosition(MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_3").setPosition(MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_4").setPosition(MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_5").setPosition(MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_6").setPosition(MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_7").setPosition(MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_8").setPosition(MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_9").setPosition(MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_10").setPosition(MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2);
        buttons.get("Tactic_11").setPosition(MarsGame.WIDTH + 450, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2);

        text.get("Hangar").setPosition((MarsGame.WIDTH / 2 - 384) * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Bridge").setPosition(text.get("Hangar").getX() + text.get("Hangar").getPrefWidth() + 32 * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Arsenal").setPosition(text.get("Bridge").getX() + text.get("Bridge").getPrefWidth() + 32 * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Laboratory").setPosition(text.get("Arsenal").getX() + text.get("Arsenal").getPrefWidth() + 32 * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
        text.get("Reactor").setPosition(text.get("Laboratory").getX() + text.get("Laboratory").getPrefWidth() + 32 * MarsGame.getRatioMonitorW(), 69 * MarsGame.getRatioMonitorH());
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
        buttons.put("Bridge", new Buttons("Bridge", img, text.get("Bridge").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Bridge").getX() / MarsGame.getRatioMonitorW(), 68));
        buttons.put("Laboratory", new Buttons("Laboratory", img, text.get("Laboratory").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Laboratory").getX() / MarsGame.getRatioMonitorW(), 68));
        buttons.put("Reactor", new Buttons("Reactor", img, text.get("Reactor").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Reactor").getX() / MarsGame.getRatioMonitorW(), 68));

        buttons.get("Hangar").addListener(new ButtonsInputListener(buttons.get("Hangar").getName()));
        buttons.get("Bridge").addListener(new ButtonsInputListener(buttons.get("Bridge").getName()));
        buttons.get("Laboratory").addListener(new ButtonsInputListener(buttons.get("Laboratory").getName()));
        buttons.get("Reactor").addListener(new ButtonsInputListener(buttons.get("Reactor").getName()));

        stage.addActor(buttons.get("Hangar"));
        stage.addActor(buttons.get("Bridge"));
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

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Arsenal").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Arsenal").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Arsenal").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Arsenal").getX() + text.get("Arsenal").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuHere"), (text.get("Arsenal").getX() + text.get("Arsenal").getPrefWidth() / 2) / MarsGame.getRatioMonitorW() - 6, 115, 12, 12);

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Laboratory").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Laboratory").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Laboratory").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Laboratory").getX() + text.get("Laboratory").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Reactor").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Reactor").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Reactor").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Reactor").getX() + text.get("Reactor").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);
    }

    private void terminalWeaponsRender(SpriteBatch batch) {
        if (showWeapons == MACHINEGUN) {
            if (!MarsGame.getPreference().getWeaponClose("MachineGun_1")) {
                if (!touchWeapons_1)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_1"), 88, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_1"), 91, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 88, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("MachineGun_2")) {
                if (!touchWeapons_2)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_2"), 212, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_2"), 215, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 212, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("MachineGun_3")) {
                if (!touchWeapons_3)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_3"), 336, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_3"), 339, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 336, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("MachineGun_4")) {
                if (!touchWeapons_4)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_4"), 460, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_4"), 463, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 460, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("MachineGun_5")) {
                if (!touchWeapons_5)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_5"), 88, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_5"), 91, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 88, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("MachineGun_6")) {
                if (!touchWeapons_6)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_6"), 212, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_6"), 215, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 212, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("MachineGun_7")) {
                if (!touchWeapons_7)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_7"), 336, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_7"), 339, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 336, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("MachineGun_8")) {
                if (!touchWeapons_8)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_8"), 460, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGunButton_8"), 463, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 460, 320 + MarsGame.getRatioAdd(), 92, 92);
        } else if (showWeapons == GRENADELAUNCHERS) {
            if (!MarsGame.getPreference().getWeaponClose("LauncherGun_1")) {
                if (!touchWeapons_1)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_1"), 88, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_1"), 91, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 88, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LauncherGun_2")) {
                if (!touchWeapons_2)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_2"), 212, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_2"), 215, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 212, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LauncherGun_3")) {
                if (!touchWeapons_3)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_3"), 336, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_3"), 339, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 336, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LauncherGun_4")) {
                if (!touchWeapons_4)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_4"), 460, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_4"), 463, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 460, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LauncherGun_5")) {
                if (!touchWeapons_5)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_5"), 88, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_5"), 91, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 88, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LauncherGun_6")) {
                if (!touchWeapons_6)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_6"), 212, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_6"), 215, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 212, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LauncherGun_7")) {
                if (!touchWeapons_7)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_7"), 336, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_7"), 339, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 336, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LauncherGun_8")) {
                if (!touchWeapons_8)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_8"), 460, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunButton_8"), 463, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 460, 320 + MarsGame.getRatioAdd(), 92, 92);
        } else if (showWeapons == ROCKETLAUNCHERS) {
            if (!MarsGame.getPreference().getWeaponClose("FlareGun_1")) {
                if (!touchWeapons_1)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_1"), 88, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_1"), 91, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 88, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("FlareGun_2")) {
                if (!touchWeapons_2)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_2"), 212, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_2"), 215, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 212, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("FlareGun_3")) {
                if (!touchWeapons_3)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_3"), 336, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_3"), 339, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 336, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("FlareGun_4")) {
                if (!touchWeapons_4)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_4"), 460, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_4"), 463, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 460, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("FlareGun_5")) {
                if (!touchWeapons_5)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_5"), 88, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_5"), 91, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 88, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("FlareGun_6")) {
                if (!touchWeapons_6)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_6"), 212, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_6"), 215, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 212, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("FlareGun_7")) {
                if (!touchWeapons_7)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_7"), 336, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_7"), 339, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 336, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("FlareGun_8")) {
                if (!touchWeapons_8)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_8"), 460, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunButton_8"), 463, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 460, 320 + MarsGame.getRatioAdd(), 92, 92);
        } else if (showWeapons == LASERGUNS) {
            if (!MarsGame.getPreference().getWeaponClose("LaserGun_1")) {
                if (!touchWeapons_1)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_1"), 88, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_1"), 91, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 88, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LaserGun_2")) {
                if (!touchWeapons_2)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_2"), 212, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_2"), 215, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 212, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LaserGun_3")) {
                if (!touchWeapons_3)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_3"), 336, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_3"), 339, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 336, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LaserGun_4")) {
                if (!touchWeapons_4)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_4"), 460, 430 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_4"), 463, 433 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 460, 430 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LaserGun_5")) {
                if (!touchWeapons_5)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_5"), 88, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_5"), 91, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 88, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LaserGun_6")) {
                if (!touchWeapons_6)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_6"), 212, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_6"), 215, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 212, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LaserGun_7")) {
                if (!touchWeapons_7)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_7"), 336, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_7"), 339, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 336, 320 + MarsGame.getRatioAdd(), 92, 92);

            if (!MarsGame.getPreference().getWeaponClose("LaserGun_8")) {
                if (!touchWeapons_8)
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_8"), 460, 320 + MarsGame.getRatioAdd(), 92, 92);
                else
                    batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunButton_8"), 463, 323 + MarsGame.getRatioAdd(), 86, 86);
            } else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("CloseGun"), 460, 320 + MarsGame.getRatioAdd(), 92, 92);
        }
    }

    @Override
    public void update(float deltaTime) {
        tv.update(deltaTime);
        redLightbulb.update(deltaTime);
        yellowLightbulb.update(deltaTime);
        r_7.update(deltaTime);
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
        if (!touchTurnOffTerminal)
            batch.draw(MarsGame.getTextures().textureRegion.get("TurnOff"), 106, 232 + MarsGame.getRatioAdd(), 60, 60);
        else
            batch.draw(MarsGame.getTextures().textureRegion.get("TurnOff"), 109, 235 + MarsGame.getRatioAdd(), 54, 54);
        if (!touchMachineGun)
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun"), 198, 232 + MarsGame.getRatioAdd(), 60, 60);
        else
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("MachineGun"), 201, 235 + MarsGame.getRatioAdd(), 54, 54);
        if (!touchLauncherGun)
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun"), 290, 232 + MarsGame.getRatioAdd(), 60, 60);
        else
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGun"), 293, 235 + MarsGame.getRatioAdd(), 54, 54);
        if (!touchFlareGun)
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun"), 382, 232 + MarsGame.getRatioAdd(), 60, 60);
        else
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGun"), 385, 235 + MarsGame.getRatioAdd(), 54, 54);
        if (!touchLaserGun)
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun"), 476, 232 + MarsGame.getRatioAdd(), 60, 60);
        else
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGun"), 479, 235 + MarsGame.getRatioAdd(), 54, 54);

        if (!isOffTerminal) terminalWeaponsRender(batch);

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Rack"), 610, MarsGame.HEIGHT - 290, 60, 90);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Rack"), 610, MarsGame.HEIGHT - 200, 60, 90);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Rack"), 194, MarsGame.HEIGHT - 290, 60, 90);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Rack"), 194, MarsGame.HEIGHT - 200, 60, 90);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Rack"), MarsGame.WIDTH / 2 - 64, MarsGame.HEIGHT - 320 - MarsGame.getRatioAdd() / 2);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Rack"), MarsGame.WIDTH / 2 - 64, MarsGame.HEIGHT - 512 - MarsGame.getRatioAdd() / 2);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Monitor"), 480, MarsGame.HEIGHT - 480);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Monitor"), 64, MarsGame.HEIGHT - 480);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("MonitorBig"), MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 220 + MarsGame.getRatioAdd() / 2, 512, 256);

        if (!touchAttack)
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("Attack"), MarsGame.WIDTH / 2 - 206, MarsGame.HEIGHT / 2 - 145 + MarsGame.getRatioAdd() / 2, 120, 120);
        else
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("Attack"), MarsGame.WIDTH / 2 - 203, MarsGame.HEIGHT / 2 - 142 + MarsGame.getRatioAdd() / 2, 114, 114);
        if (!touchDefense)
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("Defense"), MarsGame.WIDTH / 2 - 60, MarsGame.HEIGHT / 2 - 145 + MarsGame.getRatioAdd() / 2, 120, 120);
        else
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("Defense"), MarsGame.WIDTH / 2 - 57, MarsGame.HEIGHT / 2 - 142 + MarsGame.getRatioAdd() / 2, 114, 114);
        if (!touchTechnologies)
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("Technologies"), MarsGame.WIDTH / 2 + 86, MarsGame.HEIGHT / 2 - 145 + MarsGame.getRatioAdd() / 2, 120, 120);
        else
            batch.draw(MarsGame.getTextures().textureRegionScreen.get("Technologies"), MarsGame.WIDTH / 2 + 89, MarsGame.HEIGHT / 2 - 142 + MarsGame.getRatioAdd() / 2, 114, 114);
        if (MarsGame.getPreference().getTacticsAttackStart()) {
            if (!touchDefense)
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 - 50, MarsGame.HEIGHT / 2 - 135 + MarsGame.getRatioAdd() / 2, 100, 100);
            else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 - 45, MarsGame.HEIGHT / 2 - 130 + MarsGame.getRatioAdd() / 2, 90, 90);
            if (!touchTechnologies)
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 + 96, MarsGame.HEIGHT / 2 - 135 + MarsGame.getRatioAdd() / 2, 100, 100);
            else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 + 101, MarsGame.HEIGHT / 2 - 130 + MarsGame.getRatioAdd() / 2, 90, 90);
        } else if (MarsGame.getPreference().getTacticsDefenseStart()) {
            if (!touchAttack)
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 - 196, MarsGame.HEIGHT / 2 - 135 + MarsGame.getRatioAdd() / 2, 100, 100);
            else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 - 191, MarsGame.HEIGHT / 2 - 130 + MarsGame.getRatioAdd() / 2, 90, 90);
            if (!touchTechnologies)
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 + 96, MarsGame.HEIGHT / 2 - 135 + MarsGame.getRatioAdd() / 2, 100, 100);
            else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 + 101, MarsGame.HEIGHT / 2 - 130 + MarsGame.getRatioAdd() / 2, 90, 90);
        } else if (MarsGame.getPreference().getTacticsTechnologiesStart()) {
            if (!touchAttack)
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 - 196, MarsGame.HEIGHT / 2 - 135 + MarsGame.getRatioAdd() / 2, 100, 100);
            else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 - 191, MarsGame.HEIGHT / 2 - 130 + MarsGame.getRatioAdd() / 2, 90, 90);
            if (!touchDefense)
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 - 50, MarsGame.HEIGHT / 2 - 135 + MarsGame.getRatioAdd() / 2, 100, 100);
            else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("TacticsClose"), MarsGame.WIDTH / 2 - 45, MarsGame.HEIGHT / 2 - 130 + MarsGame.getRatioAdd() / 2, 90, 90);
        }

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("ProjectionMonitor"), MarsGame.WIDTH - 448, 80 + MarsGame.getRatioAdd(), 32, 96, 64, 192, 1, 1, 90);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("ProjectionMonitor"), MarsGame.WIDTH - 448, 80 + MarsGame.getRatioAdd(), 32, 96, 64, -192, 1, 1, 90);

        weapons.render(batch);
        if (showInfoBuy.equals("Buy")) {
            batch.draw(MarsGame.getTextures().textureRegion.get("Money"), 160, MarsGame.HEIGHT - 365, 45, 45);
            batch.draw(MarsGame.getTextures().textureRegion.get("Mineral"), 160, MarsGame.HEIGHT - 420, 50, 50);
        }

        batch.draw(MarsGame.getTextures().textureRegion.get("ColorOrange"), 500, MarsGame.HEIGHT - 463, 280, 158);
        batch.draw(MarsGame.getTextures().textureRegion.get("ColorOrange"), 84, MarsGame.HEIGHT - 463, 280, 158);
        batch.draw(MarsGame.getTextures().textureRegion.get("ColorOrange"), MarsGame.WIDTH / 2 - 221, MarsGame.HEIGHT / 2 - 190 + MarsGame.getRatioAdd() / 2, 442, 208);

        batch.draw(MarsGame.getTextures().textureRegion.get("UpLeft"), MarsGame.WIDTH / 2 - 206, MarsGame.HEIGHT / 2 - 50 + MarsGame.getRatioAdd() / 2);
        batch.draw(MarsGame.getTextures().textureRegion.get("Down"), MarsGame.WIDTH / 2 - 30, MarsGame.HEIGHT / 2 + 15 + MarsGame.getRatioAdd() / 2, 64, -64);
        batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), MarsGame.WIDTH / 2 + 145, MarsGame.HEIGHT / 2 - 50 + MarsGame.getRatioAdd() / 2);

        batch.draw(MarsGame.getTextures().textureRegion.get("Down"), 108, 198 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("Down"), 199, 320 + MarsGame.getRatioAdd(), 64, -64);
        batch.draw(MarsGame.getTextures().textureRegion.get("Down"), 293, 198 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), 400, 262 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("DownRight"), 494, 198 + MarsGame.getRatioAdd());

        if (MarsGame.getPreference().loadMissionFinish("Missions_4_3")) {
            batch.draw(MarsGame.getTextures().textureRegion.get("TerminalUpdateTower"), MarsGame.WIDTH / 2 + 320, 128 + MarsGame.getRatioAdd(), 96, 256);
            batch.draw(MarsGame.getTextures().textureRegion.get("DownLeft"), MarsGame.WIDTH / 2 + 310, 250 + MarsGame.getRatioAdd());
        } else
            batch.draw(MarsGame.getTextures().textureRegion.get("HandOFF"), MarsGame.WIDTH / 2 + 320, 128 + MarsGame.getRatioAdd(), 96, 256);
        batch.end();

        r_7.render(batch);

        batch.begin();
        menuButtonsRender(batch);
        if (showInfoBuy.equals("Buy") || showInfoBuy.equals("Install")) {
            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("InstallBuy").getX() / MarsGame.getRatioMonitorW() - 6, MarsGame.HEIGHT - 465, text.get("InstallBuy").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("InstallBuy").getX() / MarsGame.getRatioMonitorW() - 10, MarsGame.HEIGHT - 468, 34, 45);
            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("InstallBuy").getX() + text.get("InstallBuy").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, MarsGame.HEIGHT - 468, 34, 45);
        }

        tactics.render(batch);
        if (showReset) {
            if (!touchReset)
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("Reset"), MarsGame.WIDTH - 200, 80 + MarsGame.getRatioAdd(), 128, 128);
            else
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("Reset"), MarsGame.WIDTH - 196, 84 + MarsGame.getRatioAdd(), 120, 120);
        }

        batch.draw(MarsGame.getTextures().textureRegion.get("FrameTop"), 0, MarsGame.HEIGHT - 256);
        if (MarsGame.getRatioAdd() > 120)
            batch.draw(MarsGame.getTextures().textureRegion.get("FrameBottom"), 0, 1 + MarsGame.getRatioAdd(), 1920, -64);
        batch.draw(MarsGame.getTextures().textureRegion.get("FrameBottom"), 0, 0 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegion.get("Money"), MarsGame.WIDTH / 2 - 116, MarsGame.HEIGHT - 110, 45, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("Mineral"), MarsGame.WIDTH / 2 + 70, MarsGame.HEIGHT - 114, 50, 50);
        batch.end();

        stage.act();
        stage.draw();

        if (tactics.getNameTactic().equals("NULL")) {
            batch.begin();
            if (!isOffTerminal) {
                tv.render(batch, 321, 420 + MarsGame.getRatioAdd(), 257, 112, 0);
                tv.render(batch, 321, 308 + MarsGame.getRatioAdd(), 257, 112, 0);
                tv.render(batch, 64, 420 + MarsGame.getRatioAdd(), 257, 112, 0);
                tv.render(batch, 64, 308 + MarsGame.getRatioAdd(), 257, 112, 0);
            }
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
            //   MarsGame.getMusicSound().deleteRobotR7();
            stage.dispose();
            text.clear();
            buttons.clear();
            redLightbulb.dispose();
            yellowLightbulb.dispose();
            stars.dispose();
            r_7.dispose();
            tv.dispose();
            weapons = null;
            tactics = null;
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
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            if (name.equals("TurnOffTerminal")) {
                if (tactics.getNameTactic().equals("NULL")) touchTurnOffTerminal = true;
                else tactics.setTouchTurnOffTerminal(true);
            } else if (name.equals("MachineGun")) {
                if (tactics.getNameTactic().equals("NULL")) touchMachineGun = true;
            } else if (name.equals("LauncherGun")) {
                if (tactics.getNameTactic().equals("NULL")) touchLauncherGun = true;
            } else if (name.equals("FlareGun")) {
                if (tactics.getNameTactic().equals("NULL")) touchFlareGun = true;
            } else if (name.equals("LaserGun")) {
                if (tactics.getNameTactic().equals("NULL")) touchLaserGun = true;
            } else if (name.equals("Weapons_1")) {
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_1"))
                        touchWeapons_1 = true;
                    else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_1"))
                        touchWeapons_1 = true;
                    else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_1"))
                        touchWeapons_1 = true;
                    else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_1"))
                        touchWeapons_1 = true;
                }
            } else if (name.equals("Weapons_2")) {
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_2"))
                        touchWeapons_2 = true;
                    else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_2"))
                        touchWeapons_2 = true;
                    else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_2"))
                        touchWeapons_2 = true;
                    else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_2"))
                        touchWeapons_2 = true;
                }
            } else if (name.equals("Weapons_3")) {
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_3"))
                        touchWeapons_3 = true;
                    else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_3"))
                        touchWeapons_3 = true;
                    else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_3"))
                        touchWeapons_3 = true;
                    else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_3"))
                        touchWeapons_3 = true;
                }
            } else if (name.equals("Weapons_4")) {
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_4"))
                        touchWeapons_4 = true;
                    else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_4"))
                        touchWeapons_4 = true;
                    else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_4"))
                        touchWeapons_4 = true;
                    else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_4"))
                        touchWeapons_4 = true;
                }
            } else if (name.equals("Weapons_5")) {
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_5"))
                        touchWeapons_5 = true;
                    else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_5"))
                        touchWeapons_5 = true;
                    else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_5"))
                        touchWeapons_5 = true;
                    else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_5"))
                        touchWeapons_5 = true;
                }
            } else if (name.equals("Weapons_6")) {
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_6"))
                        touchWeapons_6 = true;
                    else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_6"))
                        touchWeapons_6 = true;
                    else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_6"))
                        touchWeapons_6 = true;
                    else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_6"))
                        touchWeapons_6 = true;
                }
            } else if (name.equals("Weapons_7")) {
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_7"))
                        touchWeapons_7 = true;
                    else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_7"))
                        touchWeapons_7 = true;
                    else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_7"))
                        touchWeapons_7 = true;
                    else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_7"))
                        touchWeapons_7 = true;
                }
            } else if (name.equals("Weapons_8")) {
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_8"))
                        touchWeapons_8 = true;
                    else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_8"))
                        touchWeapons_8 = true;
                    else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_8"))
                        touchWeapons_8 = true;
                    else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_8"))
                        touchWeapons_8 = true;
                }
            } else if (name.equals("Attack")) {
                if (tactics.getNameTactic().equals("NULL")) touchAttack = true;
            } else if (name.equals("Defense")) {
                if (tactics.getNameTactic().equals("NULL")) touchDefense = true;
            } else if (name.equals("Technologies")) {
                if (tactics.getNameTactic().equals("NULL")) touchTechnologies = true;
            } else if (name.equals("Reset")) {
                if (showReset) touchReset = true;
            }
            return true;
        }

        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

            if (name.equals("TurnOffTerminal")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (tactics.getNameTactic().equals("NULL")) {
                    touchTurnOffTerminal = false;
                    if (isOffTerminal) isOffTerminal = false;
                    else isOffTerminal = true;
                } else {
                    tactics.setTouchTurnOffTerminal(false);
                    tactics.setNameTactic("NULL");
                    tactics.setNameTacticObject("NULL");
                    tactics.setBuyShow(false);
                    isBuyTactics = false;
                    showReset = false;
                    text.get("TacticsName").setText("");
                    text.get("TacticsInfo").setText("");
                    text.get("TacticsMoney").setText("");
                    text.get("TacticsMineral").setText("");
                    text.get("BuyTactics").setText("");
                    text.get("Current").setText("");
                    text.get("Next").setText("");
                    buttonsTacticsObjectHide();
                    buttons.get("TurnOffTerminal").setSize(60, 60);
                    buttons.get("TurnOffTerminal").setPosition(106, 232 + MarsGame.getRatioAdd());

                    text.get("Installed").setPosition(224 * MarsGame.getRatioMonitorW() - text.get("Installed").getPrefWidth() / 2, (MarsGame.HEIGHT - 380) * MarsGame.getRatioMonitorH());
                    text.get("InstallBuy").setPosition(224 * MarsGame.getRatioMonitorW() - text.get("InstallBuy").getPrefWidth() / 2, (MarsGame.HEIGHT - 445) * MarsGame.getRatioMonitorH());
                    text.get("BuyPriceMoney").setPosition(220 * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 345) * MarsGame.getRatioMonitorH());
                    text.get("BuyPriceMineral").setPosition(220 * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 395) * MarsGame.getRatioMonitorH());
                    text.get("EnergyWeapon").setPosition((MarsGame.WIDTH - 444) * MarsGame.getRatioMonitorW(), (240 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("OnOff").setPosition(108 * MarsGame.getRatioMonitorW(), (180 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("MachineGun").setPosition(190 * MarsGame.getRatioMonitorW(), (305 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("LauncherGun").setPosition(275 * MarsGame.getRatioMonitorW(), (180 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("FlareGun").setPosition(462 * MarsGame.getRatioMonitorW(), (295 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("LaserGun").setPosition(556 * MarsGame.getRatioMonitorW(), (200 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("Attack").setPosition((MarsGame.WIDTH / 2 - 205) * MarsGame.getRatioMonitorW() - text.get("Attack").getPrefWidth(), (MarsGame.HEIGHT / 2 - 15 + MarsGame.getRatioAdd() / 2) * MarsGame.getRatioMonitorH());
                    text.get("Defense").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("Defense").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + MarsGame.getRatioAdd() / 2) * MarsGame.getRatioMonitorH());
                    text.get("Technologies").setPosition((MarsGame.WIDTH / 2 + 205) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT / 2 - 15 + MarsGame.getRatioAdd() / 2) * MarsGame.getRatioMonitorH());
                    text.get("TerminalUpdateTower").setPosition((MarsGame.WIDTH / 2 + 310) * MarsGame.getRatioMonitorW() - text.get("TerminalUpdateTower").getPrefWidth(), (250 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

                    buttons.get("Attack").setPosition(MarsGame.WIDTH / 2 - 206, MarsGame.HEIGHT / 2 - 145 + MarsGame.getRatioAdd() / 2);
                    buttons.get("Defense").setPosition(MarsGame.WIDTH / 2 - 60, MarsGame.HEIGHT / 2 - 145 + MarsGame.getRatioAdd() / 2);
                    buttons.get("Technologies").setPosition(MarsGame.WIDTH / 2 + 86, MarsGame.HEIGHT / 2 - 145 + MarsGame.getRatioAdd() / 2);
                }
                //endregion
            } else if (name.equals("MachineGun")) {
                if (tactics.getNameTactic().equals("NULL")) {
                    touchMachineGun = false;
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    showWeapons = MACHINEGUN;
                    text.get("MachineGun").setColor(Color.ORANGE);
                    text.get("LauncherGun").setColor(Color.WHITE);
                    text.get("FlareGun").setColor(Color.WHITE);
                    text.get("LaserGun").setColor(Color.WHITE);
                }
            } else if (name.equals("LauncherGun")) {
                if (tactics.getNameTactic().equals("NULL")) {
                    touchLauncherGun = false;
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    showWeapons = GRENADELAUNCHERS;
                    text.get("MachineGun").setColor(Color.WHITE);
                    text.get("LauncherGun").setColor(Color.ORANGE);
                    text.get("FlareGun").setColor(Color.WHITE);
                    text.get("LaserGun").setColor(Color.WHITE);
                }
            } else if (name.equals("FlareGun")) {
                if (tactics.getNameTactic().equals("NULL")) {
                    touchFlareGun = false;
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    showWeapons = ROCKETLAUNCHERS;
                    text.get("MachineGun").setColor(Color.WHITE);
                    text.get("LauncherGun").setColor(Color.WHITE);
                    text.get("FlareGun").setColor(Color.ORANGE);
                    text.get("LaserGun").setColor(Color.WHITE);
                }
            } else if (name.equals("LaserGun")) {
                if (tactics.getNameTactic().equals("NULL")) {
                    touchLaserGun = false;
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    showWeapons = LASERGUNS;
                    text.get("MachineGun").setColor(Color.WHITE);
                    text.get("LauncherGun").setColor(Color.WHITE);
                    text.get("FlareGun").setColor(Color.WHITE);
                    text.get("LaserGun").setColor(Color.ORANGE);
                }
            } else if (name.equals("BuyActive")) {
                //region
                if (tactics.getNameTactic().equals("NULL")) {
                    if (showInfoBuy.equals("Install")) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        MarsGame.getPreference().setWeaponInstalled(weapons.getNameWeapons());

                        showInfoBuy = "NULL";
                        text.get("Installed").setText(MarsGame.getLanguage().textScreen.get("Installed"));
                        text.get("Installed").setPosition(224 * MarsGame.getRatioMonitorW() - text.get("Installed").getPrefWidth() / 2, (MarsGame.HEIGHT - 380) * MarsGame.getRatioMonitorH());
                        text.get("InstallBuy").setText("");
                        text.get("BuyPriceMoney").setText("");
                        text.get("BuyPriceMineral").setText("");
                    } else if (showInfoBuy.equals("Buy")) {
                        if (MarsGame.getPreference().loadMoney() > Integer.parseInt(weapons.getMoney()) && MarsGame.getPreference().loadMineral() > Integer.parseInt(weapons.getMineral())) {
                            if (MarsGame.getPreference().loadSound() == 1)
                                MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            MarsGame.getPreference().setWeaponBuy(weapons.getNameWeapons());
                            MarsGame.getPreference().saveCredit(-Integer.parseInt(weapons.getMoney()), -Integer.parseInt(weapons.getMineral()));

                            MarsGame.getPreference().setEventSpentMoney(Integer.parseInt(weapons.getMoney()));
                            MarsGame.getPreference().setAchievementMoneyRemove(MarsGame.getPreference().getEventSpentMoney());

                            MarsGame.getPreference().setEventSpentMinerals(Integer.parseInt(weapons.getMineral()));
                            MarsGame.getPreference().setAchievementMineralRemove(MarsGame.getPreference().getEventSpentMinerals());

                            text.get("Money").setText(String.valueOf(MarsGame.getPreference().loadMoney()));
                            text.get("Mineral").setText(String.valueOf(MarsGame.getPreference().loadMineral()));
                            text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());

                            showInfoBuy = "Install";
                            text.get("InstallBuy").setText(MarsGame.getLanguage().textScreen.get("Install"));
                            text.get("InstallBuy").setPosition(224 * MarsGame.getRatioMonitorW() - text.get("InstallBuy").getPrefWidth() / 2, (MarsGame.HEIGHT - 445) * MarsGame.getRatioMonitorH());
                            text.get("Installed").setText("");
                            text.get("BuyPriceMoney").setText("");
                            text.get("BuyPriceMineral").setText("");
                        } else {
                            if (MarsGame.getPreference().loadSound() == 1)
                                MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
                //endregion
            } else if (name.equals("BuyTactics")) {
                if (isBuyTactics) {
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    if (tactics.getNameTactic().equals("Attack")) attack();
                    else if (tactics.getNameTactic().equals("Defense")) defense();
                    else if (tactics.getNameTactic().equals("Technologies")) technologies();
                    text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
                    MarsGame.getPreference().setAchievementTechnologies();
                }
            } else if (name.equals("TerminalUpdateTower")) {
                if (tactics.getNameTactic().equals("NULL")) {
                    if (MarsGame.getPreference().loadMissionFinish("Missions_4_3")) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        game.set(new Loading(game, "ArsenalTower"));
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
            } else if (name.equals("Weapons_1")) {
                //region
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_1")) {
                        touchWeapons_1 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("MachineGun_1");
                    } else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_1")) {
                        touchWeapons_1 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LauncherGun_1");
                    } else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_1")) {
                        touchWeapons_1 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("FlareGun_1");
                    } else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_1")) {
                        touchWeapons_1 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LaserGun_1");
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Weapons_2")) {
                //region
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_2")) {
                        touchWeapons_2 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("MachineGun_2");
                    } else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_2")) {
                        touchWeapons_2 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LauncherGun_2");
                    } else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_2")) {
                        touchWeapons_2 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("FlareGun_2");
                    } else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_2")) {
                        touchWeapons_2 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LaserGun_2");
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Weapons_3")) {
                //region
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_3")) {
                        touchWeapons_3 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("MachineGun_3");
                    } else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_3")) {
                        touchWeapons_3 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LauncherGun_3");
                    } else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_3")) {
                        touchWeapons_3 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("FlareGun_3");
                    } else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_3")) {
                        touchWeapons_3 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LaserGun_3");
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Weapons_4")) {
                //region
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_4")) {
                        touchWeapons_4 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("MachineGun_4");
                    } else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_4")) {
                        touchWeapons_4 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LauncherGun_4");
                    } else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_4")) {
                        touchWeapons_4 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("FlareGun_4");
                    } else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_4")) {
                        touchWeapons_4 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LaserGun_4");
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Weapons_5")) {
                //region
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_5")) {
                        touchWeapons_5 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("MachineGun_5");
                    } else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_5")) {
                        touchWeapons_5 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LauncherGun_5");
                    } else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_5")) {
                        touchWeapons_5 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("FlareGun_5");
                    } else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_5")) {
                        touchWeapons_5 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LaserGun_5");
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Weapons_6")) {
                //region
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_6")) {
                        touchWeapons_6 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("MachineGun_6");
                    } else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_6")) {
                        touchWeapons_6 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LauncherGun_6");
                    } else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_6")) {
                        touchWeapons_6 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("FlareGun_6");
                    } else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_6")) {
                        touchWeapons_6 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LaserGun_6");
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Weapons_7")) {
                //region
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_7")) {
                        touchWeapons_7 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("MachineGun_7");
                    } else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_7")) {
                        touchWeapons_7 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LauncherGun_7");
                    } else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_7")) {
                        touchWeapons_7 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("FlareGun_7");
                    } else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_7")) {
                        touchWeapons_7 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LaserGun_7");
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Weapons_8")) {
                //region
                if (!isOffTerminal && tactics.getNameTactic().equals("NULL")) {
                    if (showWeapons == MACHINEGUN && !MarsGame.getPreference().getWeaponClose("MachineGun_8")) {
                        touchWeapons_8 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("MachineGun_8");
                    } else if (showWeapons == GRENADELAUNCHERS && !MarsGame.getPreference().getWeaponClose("LauncherGun_8")) {
                        touchWeapons_8 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LauncherGun_8");
                    } else if (showWeapons == ROCKETLAUNCHERS && !MarsGame.getPreference().getWeaponClose("FlareGun_8")) {
                        touchWeapons_8 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("FlareGun_8");
                    } else if (showWeapons == LASERGUNS && !MarsGame.getPreference().getWeaponClose("LaserGun_8")) {
                        touchWeapons_8 = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        setNameInfoWeapons("LaserGun_8");
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Attack")) {
                //region
                if (tactics.getNameTactic().equals("NULL")) {
                    touchAttack = false;
                    if (!MarsGame.getPreference().getTacticsDefenseStart() && !MarsGame.getPreference().getTacticsTechnologiesStart()) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        if (MarsGame.getPreference().getTacticsAttackStart()) showReset = true;
                        tactics.setNameTactic("Attack");
                        buttonsTacticsObjectShow();
                        hideTextWeapons();
                        buttons.get("TurnOffTerminal").setSize(64, 64);
                        buttons.get("TurnOffTerminal").setPosition(MarsGame.WIDTH - 120, MarsGame.HEIGHT - 256);

                        buttons.get("Attack").setPosition(MarsGame.WIDTH, 0);
                        buttons.get("Defense").setPosition(MarsGame.WIDTH, 0);
                        buttons.get("Technologies").setPosition(MarsGame.WIDTH, 0);
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Defense")) {
                //region
                if (tactics.getNameTactic().equals("NULL")) {
                    touchDefense = false;
                    if (!MarsGame.getPreference().getTacticsAttackStart() && !MarsGame.getPreference().getTacticsTechnologiesStart()) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        if (MarsGame.getPreference().getTacticsDefenseStart()) showReset = true;
                        tactics.setNameTactic("Defense");
                        buttonsTacticsObjectShow();
                        hideTextWeapons();
                        buttons.get("TurnOffTerminal").setSize(64, 64);
                        buttons.get("TurnOffTerminal").setPosition(MarsGame.WIDTH - 120, MarsGame.HEIGHT - 256);

                        buttons.get("Attack").setPosition(MarsGame.WIDTH, 0);
                        buttons.get("Defense").setPosition(MarsGame.WIDTH, 0);
                        buttons.get("Technologies").setPosition(MarsGame.WIDTH, 0);
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Technologies")) {
                //region
                if (tactics.getNameTactic().equals("NULL")) {
                    touchTechnologies = false;
                    if (!MarsGame.getPreference().getTacticsAttackStart() && !MarsGame.getPreference().getTacticsDefenseStart()) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        if (MarsGame.getPreference().getTacticsTechnologiesStart())
                            showReset = true;
                        tactics.setNameTactic("Technologies");
                        buttonsTacticsObjectShow();
                        hideTextWeapons();
                        buttons.get("TurnOffTerminal").setSize(64, 64);
                        buttons.get("TurnOffTerminal").setPosition(MarsGame.WIDTH - 120, MarsGame.HEIGHT - 256);

                        buttons.get("Attack").setPosition(MarsGame.WIDTH, 0);
                        buttons.get("Defense").setPosition(MarsGame.WIDTH, 0);
                        buttons.get("Technologies").setPosition(MarsGame.WIDTH, 0);
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Reset")) {
                //region
                if (showReset) {
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    tactics.setNameTacticObject("Reset");
                    touchReset = false;
                    tactics.setBuyShow(true);
                    text.get("Current").setText("");
                    text.get("Next").setText("");
                    tactics.priceReset();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("Reset"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("ResetInfo"));
                    buttonBuyTactics(0);
                }
                //endregion
            } else if (name.equals("Hangar")) {
                if (tactics.getNameTactic().equals("NULL")) {
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    game.set(new Loading(game, "Game"));
                }
            } else if (name.equals("Bridge")) {
                if (tactics.getNameTactic().equals("NULL")) {
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    game.set(new Loading(game, "Bridge"));
                }
            } else if (name.equals("Laboratory")) {
                if (tactics.getNameTactic().equals("NULL")) {
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    game.set(new Loading(game, "Laboratory"));
                }
            } else if (name.equals("Reactor")) {
                if (tactics.getNameTactic().equals("NULL")) {
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    game.set(new Loading(game, "Reactor"));
                }
            } else if (name.equals("Tactic_1")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                tactics.setBuyShow(true);
                if (tactics.getNameTactic().equals("Attack")) {
                    tactics.setNameTacticObject("AttackStart");
                    tactics.priceAttack();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("AttackStart"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("AttackStartInfo"));
                    if (!MarsGame.getPreference().getTacticsAttackStart()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        buttonBuyTactics(0);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Defense")) {
                    tactics.setNameTacticObject("DefenseStart");
                    tactics.priceDefense();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("DefenseStart"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("DefenseStartInfo"));
                    if (!MarsGame.getPreference().getTacticsDefenseStart()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        buttonBuyTactics(0);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Technologies")) {
                    tactics.setNameTacticObject("TechnologiesStart");
                    tactics.priceTechnologies();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("TechnologiesStart"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("TechnologiesStartInfo"));
                    if (!MarsGame.getPreference().getTacticsTechnologiesStart()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        buttonBuyTactics(0);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                }
                //endregion
            } else if (name.equals("Tactic_2")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                tactics.setBuyShow(true);
                if (tactics.getNameTactic().equals("Attack")) {
                    tactics.setNameTacticObject("AttackGenerator");
                    tactics.priceAttack();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("AttackGenerator"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("AttackGeneratorInfo"));
                    if (!MarsGame.getPreference().getTacticsAttackGenerator() && MarsGame.getPreference().loadMPEnergy() >= 50) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsAttackStart()) buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsAttackStart())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsAttackGenerator()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Defense")) {
                    tactics.setNameTacticObject("DefenseGenerator");
                    tactics.priceDefense();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("DefenseGenerator"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("DefenseGeneratorInfo"));
                    if (!MarsGame.getPreference().getTacticsDefenseGenerator() && MarsGame.getPreference().loadMPEnergy() >= 50) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsDefenseStart()) buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsDefenseStart())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsDefenseGenerator()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Technologies")) {
                    tactics.setNameTacticObject("TechnologiesRadar");
                    tactics.priceTechnologies();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("TechnologiesRadar"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("TechnologiesRadarInfo"));
                    if (!MarsGame.getPreference().getTacticsTechnologiesRadar() && MarsGame.getPreference().loadMPEnergy() >= 50) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsTechnologiesStart())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsTechnologiesStart())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsTechnologiesRadar()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                }
                //endregion
            } else if (name.equals("Tactic_3")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                tactics.setBuyShow(true);
                if (tactics.getNameTactic().equals("Attack")) {
                    tactics.setNameTacticObject("AttackGeneratorPowerShot");
                    tactics.priceAttack();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("AttackGeneratorPowerShot"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("AttackGeneratorPowerShotInfo"));
                    text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackGeneratorPowerShot()));
                    text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackGeneratorPowerShot() + 1));
                    if (MarsGame.getPreference().getTacticsAttackGenerator()) buttonBuyTactics(0);
                    else if (!MarsGame.getPreference().getTacticsAttackGenerator())
                        buttonBuyTactics(1);
                } else if (tactics.getNameTactic().equals("Defense")) {
                    tactics.setNameTacticObject("DefenseGeneratorPowerShield");
                    tactics.priceDefense();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("DefenseGeneratorPowerShield"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("DefenseGeneratorPowerShieldInfo"));
                    if (MarsGame.getPreference().getTacticsDefenseGeneratorPowerShield() < 60) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseGeneratorPowerShield()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseGeneratorPowerShield() + 1));
                        if (MarsGame.getPreference().getTacticsDefenseGenerator())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsDefenseGenerator())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsDefenseGeneratorPowerShield() == 60) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseGeneratorPowerShield()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Technologies")) {
                    tactics.setNameTacticObject("TechnologiesShowMonsterLife");
                    tactics.priceTechnologies();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("TechnologiesShowMonsterLife"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("TechnologiesShowMonsterLifeInfo"));
                    if (!MarsGame.getPreference().getTacticsTechnologiesShowMonsterLife()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsTechnologiesRadar())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsTechnologiesRadar())
                            buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                }
                //endregion
            } else if (name.equals("Tactic_4")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                tactics.setBuyShow(true);
                if (tactics.getNameTactic().equals("Attack")) {
                    tactics.setNameTacticObject("AttackGeneratorEnergy");
                    tactics.priceAttack();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("AttackGeneratorEnergy"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("AttackGeneratorEnergyInfo"));
                    if (MarsGame.getPreference().getTacticsAttackGeneratorEnergy() > 20) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackGeneratorEnergy()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackGeneratorEnergy() - 5));
                        if (MarsGame.getPreference().getTacticsAttackGenerator())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsAttackGenerator())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsAttackGeneratorEnergy() == 20) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackGeneratorEnergy()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Defense")) {
                    tactics.setNameTacticObject("DefenseGeneratorEnergy");
                    tactics.priceDefense();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("DefenseGeneratorEnergy"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("DefenseGeneratorEnergyInfo"));
                    if (MarsGame.getPreference().getTacticsDefenseGeneratorEnergy() > 20) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseGeneratorEnergy()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseGeneratorEnergy() - 5));
                        if (MarsGame.getPreference().getTacticsDefenseGenerator())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsDefenseGenerator())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsDefenseGeneratorEnergy() == 20) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseGeneratorEnergy()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Technologies")) {
                    tactics.setNameTacticObject("TechnologiesRadarEnergy");
                    tactics.priceTechnologies();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("TechnologiesRadarEnergy"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("TechnologiesRadarEnergyInfo"));
                    if (MarsGame.getPreference().getTacticsTechnologiesRadarEnergy() > 20) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRadarEnergy()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesRadarEnergy() - 5));
                        if (MarsGame.getPreference().getTacticsTechnologiesRadar())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsTechnologiesRadar())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsTechnologiesRadarEnergy() == 20) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRadarEnergy()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                }
                //endregion
            } else if (name.equals("Tactic_5")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                tactics.setBuyShow(true);
                if (tactics.getNameTactic().equals("Attack")) {
                    tactics.setNameTacticObject("AttackPowerShot");
                    tactics.priceAttack();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("AttackPowerShot"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("AttackPowerShotInfo"));
                    if (MarsGame.getPreference().getTacticsAttackPowerShot() < 80) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackPowerShot()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackPowerShot() + 1));
                        if (MarsGame.getPreference().getTacticsAttackGenerator())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsAttackGenerator())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsAttackPowerShot() == 80) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackPowerShot()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Defense")) {
                    tactics.setNameTacticObject("DefenseHeartLife");
                    tactics.priceDefense();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("DefenseHeartLife"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("DefenseHeartLifeInfo"));
                    if (MarsGame.getPreference().getTacticsDefenseHeartLife() == 0) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(0));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(30));
                        if (MarsGame.getPreference().getTacticsDefenseGenerator())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsDefenseGenerator())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsDefenseHeartLife() > 0 && MarsGame.getPreference().getTacticsDefenseHeartLife() < 80) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseHeartLife()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseHeartLife() + 1));
                        if (MarsGame.getPreference().getTacticsDefenseGenerator())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsDefenseGenerator())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsDefenseHeartLife() == 80) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseHeartLife()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Technologies")) {
                    tactics.setNameTacticObject("TechnologiesRobot");
                    tactics.priceTechnologies();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("TechnologiesRobot"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("TechnologiesRobotInfo"));
                    if (MarsGame.getPreference().getTacticsTechnologiesRobot() < 7) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRobot()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesRobot() + 1));
                        if (MarsGame.getPreference().getTacticsTechnologiesRadar())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsTechnologiesRadar())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsTechnologiesRobot() == 7) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRobot()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                }
                //endregion
            } else if (name.equals("Tactic_6")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                tactics.setBuyShow(true);
                if (tactics.getNameTactic().equals("Attack")) {
                    tactics.setNameTacticObject("AttackLauncherGun");
                    tactics.priceAttack();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("AttackLauncherGun"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("AttackLauncherGunInfo"));
                    if (!MarsGame.getPreference().getTacticsAttackLauncherGun()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsAttackPowerShot() > 0)
                            buttonBuyTactics(0);
                        else buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Defense")) {
                    tactics.setNameTacticObject("DefenseShieldHP");
                    tactics.priceDefense();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("DefenseShieldHP"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("DefenseShieldHPInfo"));
                    if (!MarsGame.getPreference().getTacticsDefenseShieldHP()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsDefenseHeartLife() > 30)
                            buttonBuyTactics(0);
                        else buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Technologies")) {
                    tactics.setNameTacticObject("TechnologiesPower");
                    tactics.priceTechnologies();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("TechnologiesPower"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("TechnologiesPowerInfo"));
                    if (!MarsGame.getPreference().getTacticsTechnologiesPower()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsTechnologiesRobot() > 2)
                            buttonBuyTactics(0);
                        else if (MarsGame.getPreference().getTacticsTechnologiesRobot() <= 2)
                            buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                }
                //endregion
            } else if (name.equals("Tactic_7")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                tactics.setBuyShow(true);
                if (tactics.getNameTactic().equals("Attack")) {
                    tactics.setNameTacticObject("AttackLauncherGunEnergy");
                    tactics.priceAttack();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("AttackLauncherGunEnergy"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("AttackLauncherGunEnergyInfo"));
                    if (MarsGame.getPreference().getTacticsAttackLauncherGunEnergy() > 1) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackLauncherGunEnergy()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackLauncherGunEnergy() - 1));
                        if (MarsGame.getPreference().getTacticsAttackLauncherGun())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsAttackLauncherGun())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsAttackLauncherGunEnergy() == 1) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackLauncherGunEnergy()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Defense")) {
                    tactics.setNameTacticObject("DefenseShieldHPup");
                    tactics.priceDefense();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("DefenseShieldHPup"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("DefenseShieldHPupInfo"));
                    if (MarsGame.getPreference().getTacticsDefenseShieldHPup() < 60) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseShieldHPup()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseShieldHPup() + 1));
                        if (MarsGame.getPreference().getTacticsDefenseShieldHP())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsDefenseShieldHP())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsDefenseShieldHPup() == 60) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseShieldHPup()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Technologies")) {
                    tactics.setNameTacticObject("TechnologiesPowerEnergy");
                    tactics.priceTechnologies();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("TechnologiesPowerEnergy"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("TechnologiesPowerEnergyInfo"));
                    if (MarsGame.getPreference().getTacticsTechnologiesPowerEnergy() < 10) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesPowerEnergy()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesPowerEnergy() + 1));
                        if (MarsGame.getPreference().getTacticsTechnologiesPower())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsTechnologiesPower())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsTechnologiesPowerEnergy() == 10) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesPowerEnergy()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                }
                //endregion
            } else if (name.equals("Tactic_8")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                tactics.setBuyShow(true);
                if (tactics.getNameTactic().equals("Attack")) {
                    tactics.setNameTacticObject("AttackFlareGun");
                    tactics.priceAttack();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("AttackFlareGun"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("AttackFlareGunInfo"));
                    if (!MarsGame.getPreference().getTacticsAttackFlareGun()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsAttackPowerShot() > 0)
                            buttonBuyTactics(0);
                        else buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Defense")) {
                    tactics.setNameTacticObject("DefenseEnergy");
                    tactics.priceDefense();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("DefenseEnergy"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("DefenseEnergyInfo"));
                    if (!MarsGame.getPreference().getTacticsDefenseEnergy()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsDefenseHeartLife() > 30)
                            buttonBuyTactics(0);
                        else buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Technologies")) {
                    tactics.setNameTacticObject("TechnologiesCarryingCapacity");
                    tactics.priceTechnologies();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("TechnologiesCarryingCapacity"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("TechnologiesCarryingCapacityInfo"));
                    if (MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity() < 7) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity() + 1));
                        if (MarsGame.getPreference().getTacticsTechnologiesRobot() > 2)
                            buttonBuyTactics(0);
                        else if (MarsGame.getPreference().getTacticsTechnologiesRobot() <= 2)
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity() == 7) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                }
                //endregion
            } else if (name.equals("Tactic_9")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                tactics.setBuyShow(true);
                if (tactics.getNameTactic().equals("Attack")) {
                    tactics.setNameTacticObject("AttackFlareGunEnergy");
                    tactics.priceAttack();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("AttackFlareGunEnergy"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("AttackFlareGunEnergyInfo"));
                    if (MarsGame.getPreference().getTacticsAttackFlareGunEnergy() > 1) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackFlareGunEnergy()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackFlareGunEnergy() - 1));
                        if (MarsGame.getPreference().getTacticsAttackFlareGun())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsAttackFlareGun())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsAttackFlareGunEnergy() == 1) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackFlareGunEnergy()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Defense")) {
                    tactics.setNameTacticObject("DefenseEnergyUp");
                    tactics.priceDefense();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("DefenseEnergyUp"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("DefenseEnergyUpInfo"));
                    if (MarsGame.getPreference().getTacticsDefenseEnergyUp() < 60) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseEnergyUp()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseEnergyUp() + 1));
                        if (MarsGame.getPreference().getTacticsDefenseEnergy()) buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsDefenseEnergy())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsDefenseEnergyUp() == 60) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseEnergyUp()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Technologies")) {
                    tactics.setNameTacticObject("TechnologiesRobotSpeed");
                    tactics.priceTechnologies();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("TechnologiesRobotSpeed"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("TechnologiesRobotSpeedInfo"));
                    if (MarsGame.getPreference().getTacticsTechnologiesRobotSpeed() < 45) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRobotSpeed()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesRobotSpeed() + 1));
                        if (MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity() > 2)
                            buttonBuyTactics(0);
                        else if (MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity() <= 2)
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsTechnologiesRobotSpeed() == 45) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesRobotSpeed()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                }
                //endregion
            } else if (name.equals("Tactic_10")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                tactics.setBuyShow(true);
                if (tactics.getNameTactic().equals("Attack")) {
                    tactics.setNameTacticObject("AttackLaserGun");
                    tactics.priceAttack();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("AttackLaserGun"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("AttackLaserGunInfo"));
                    if (!MarsGame.getPreference().getTacticsAttackLaserGun()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsAttackPowerShot() > 0)
                            buttonBuyTactics(0);
                        else buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Defense")) {
                    tactics.setNameTacticObject("DefenseMicrowave");
                    tactics.priceDefense();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("DefenseMicrowave"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("DefenseMicrowaveInfo"));
                    if (!MarsGame.getPreference().getTacticsDefenseMicrowave()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsDefenseHeartLife() > 30)
                            buttonBuyTactics(0);
                        else buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Technologies")) {
                    tactics.setNameTacticObject("TechnologiesConverter");
                    tactics.priceTechnologies();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("TechnologiesConverter"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("TechnologiesConverterInfo"));
                    if (!MarsGame.getPreference().getTacticsTechnologiesConverter()) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("NotActive")));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        if (MarsGame.getPreference().getTacticsTechnologiesRobot() > 2)
                            buttonBuyTactics(0);
                        else if (MarsGame.getPreference().getTacticsTechnologiesRobot() <= 2)
                            buttonBuyTactics(1);
                    } else {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getLanguage().textScreen.get("Actively")));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                }
                //endregion
            } else if (name.equals("Tactic_11")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                tactics.setBuyShow(true);
                if (tactics.getNameTactic().equals("Attack")) {
                    tactics.setNameTacticObject("AttackLaserGunEnergy");
                    tactics.priceAttack();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("AttackLaserGunEnergy"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("AttackLaserGunEnergyInfo"));
                    if (MarsGame.getPreference().getTacticsAttackLaserGunEnergy() > 1) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackLaserGunEnergy()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsAttackLaserGunEnergy() - 1));
                        if (MarsGame.getPreference().getTacticsAttackLaserGun())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsAttackLaserGun())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsAttackLaserGunEnergy() == 1) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsAttackLaserGunEnergy()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Defense")) {
                    tactics.setNameTacticObject("DefenseMicrowaveUp");
                    tactics.priceDefense();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("DefenseMicrowaveUp"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("DefenseMicrowaveUpInfo"));
                    if (MarsGame.getPreference().getTacticsDefenseMicrowaveUp() < 10.0f) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseMicrowaveUp()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsDefenseMicrowaveUp() + 0.5f));
                        if (MarsGame.getPreference().getTacticsDefenseMicrowave())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsDefenseMicrowave())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsDefenseMicrowaveUp() == 10.0f) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsDefenseMicrowaveUp()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                } else if (tactics.getNameTactic().equals("Technologies")) {
                    tactics.setNameTacticObject("TechnologiesConverterLife");
                    tactics.priceTechnologies();
                    text.get("TacticsName").setText(MarsGame.getLanguage().textScreen.get("TechnologiesConverterLife"));
                    text.get("TacticsInfo").setText(MarsGame.getLanguage().textScreen.get("TechnologiesConverterLifeInfo"));
                    if (MarsGame.getPreference().getTacticsTechnologiesConverterLife() < 10) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesConverterLife()));
                        text.get("Next").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().getTacticsTechnologiesConverterLife() + 1));
                        if (MarsGame.getPreference().getTacticsTechnologiesConverter())
                            buttonBuyTactics(0);
                        else if (!MarsGame.getPreference().getTacticsTechnologiesConverter())
                            buttonBuyTactics(1);
                    } else if (MarsGame.getPreference().getTacticsTechnologiesConverterLife() == 10) {
                        text.get("Current").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().getTacticsTechnologiesConverterLife()));
                        text.get("Next").setText("");
                        buttonBuyTactics(1);
                    }
                }
                //endregion
            }
        }
    }
}