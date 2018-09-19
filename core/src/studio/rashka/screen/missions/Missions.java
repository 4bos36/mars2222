package studio.rashka.screen.missions;

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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.StringBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.FontTTF;
import studio.rashka.lib.Game;
import studio.rashka.lib.State;
import studio.rashka.lib.Textures;
import studio.rashka.lib.Time;
import studio.rashka.lib.implement.Buttons;
import studio.rashka.lib.implement.crystals.AbstractFactoryCrystals;
import studio.rashka.lib.implement.crystals.CreateMissionCrystals;
import studio.rashka.lib.implement.crystals.Crystals;
import studio.rashka.lib.singleton.MicrowavesMonster;
import studio.rashka.lib.singleton.ScaleMap;
import studio.rashka.lib.singleton.SpeedMonster;
import studio.rashka.models.Loading;
import studio.rashka.models.games.AimShoot;
import studio.rashka.models.games.Base;
import studio.rashka.models.games.GamesPanel;

public class Missions extends State {

    private AbstractFactoryCrystals createMissionCrystals = new CreateMissionCrystals();
    private Crystals crystals;

    private static final int NONE = 0, NORM = 1, MIMI = 2, SURPRISE = 3, ANGER = 4, MARSIAN = 5;
    private boolean isCompleteMission, isCompleteCrystals, isCompleteIntact, isCompleteDieWormCave, isGameEnd = false,
            isVibroDie, isSoundDie = true,
            isMicrowaves = false,
            isStoryActive = false;
    private String mission, type;
    private StringBuilder textMission;
    private Map<String, Buttons> buttons;
    private Map<String, Label> text;
    private Stage stage;
    private boolean isLive = true, isShoot = false;
    private int rank = 0, crystalAdd, startNewWave = 0;
    private int money = 0, mineral = 0, robotSpeak = 0, storySpeak = 0;
    private float scale = 1;
    private Vector2 position, newPosition, positionFireAim;
    private Random random;

    private GamesPanel gamesPanel;
    private Base base;
    private AimShoot aimShoot;
    private Maps maps;
    private MonsterArmy monsterArmy;
    private Time runMicrowaves;

    private ParticleEffect explosion;

    private static final Drawable img = Textures.getInstance().getTextureButtonSkin().getDrawable("NULL");
    private static final LabelStyle style100 = new LabelStyle(FontTTF.getInstance().getFont100(), Color.WHITE);
    private static final LabelStyle style54 = new LabelStyle(FontTTF.getInstance().getFont54(), Color.WHITE);
    private static final LabelStyle style48 = new LabelStyle(FontTTF.getInstance().getFont48(), Color.WHITE);
    private static final LabelStyle style28 = new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE);

    private Skin touchpadSkin;
    private Touchpad touchpad;
    private TouchpadStyle touchpadStyle;

    public Missions(Game game, String mission) {
        super(game);
        this.mission = mission;

        MarsGame.getPreference().isPlay = true;

        random = new Random();
        runMicrowaves = new Time(MarsGame.getPreference().getTacticsDefenseMicrowaveUp(), "noSec");
        if (mission.equals("Missions_3_3")) MarsGame.getPreference().taskGame = 3754;

        maps = new Maps(mission, MarsGame.getCamera());
        monsterArmy = new MonsterArmy(mission);
        crystals = createMissionCrystals.createMissionCrystals(mission);
        gamesPanel = new GamesPanel(mission);
        base = new Base();
        aimShoot = new AimShoot(base.getShotPower(), base.getShotSpeed(), base.getShotRange(), base.getShotDistance());

        stage = new Stage();
        buttons = new HashMap<String, Buttons>();
        text = new HashMap<String, Label>();

        position = new Vector2(0, 0);
        newPosition = new Vector2(0, 0);
        positionFireAim = new Vector2(0, 0);

        explosion = new ParticleEffect();
        explosion.load(Gdx.files.internal("particles/Explosion.p"), Gdx.files.internal("particles"));
        explosion.start();

        if (MarsGame.getPreference().loadVibro() == 1) isVibroDie = true;
        else if (MarsGame.getPreference().loadVibro() == 0) isVibroDie = false;

        crystalAdd = MarsGame.getPreference().loadMineral();

        isCompleteMission = MarsGame.getPreference().loadMissionFinish(mission);
        isCompleteCrystals = MarsGame.getPreference().loadMissionMineral(mission);
        isCompleteIntact = MarsGame.getPreference().loadMissionLife(mission);
        isCompleteDieWormCave = MarsGame.getPreference().loadMissionSecret(mission);

        if (!MarsGame.getPreference().getStoryStart(mission)) story("Start");
        else {
            textPutGet();
            buttonMenu();
            buttonGamesPanel();
        }

        Gdx.input.setInputProcessor(stage);
    }

    private void textPutGet() {
        text.put("HPGame", new Label("", style28));
        text.put("MPGame", new Label("", style28));
        text.put("ShieldHPAdd", new Label(String.valueOf(MarsGame.getPreference().loadShieldHPAdd()), style28));
        text.put("EnergyAdd", new Label(String.valueOf(MarsGame.getPreference().loadEnergyAdd()), style28));
        text.put("Microwave", new Label(String.valueOf(MarsGame.getPreference().loadMicrowave()), style28));
        text.put("EnergyIcon1", new Label("25", style28));
        text.put("EnergyIcon2", new Label("25", style28));
        text.put("EnergyIcon3", new Label("25", style28));
        text.put("ShowTitleRate", new Label("", style54));
        text.put("ShowTextRate", new Label("", new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));
        text.put("ShowClickRate", new Label("", style48));

        text.get("ShieldHPAdd").setPosition((MarsGame.WIDTH / 2 - 548) * MarsGame.getRatioMonitorW() - text.get("ShieldHPAdd").getPrefWidth() / 2, 68 * MarsGame.getRatioMonitorH());
        text.get("EnergyAdd").setPosition((MarsGame.WIDTH / 2 - 412) * MarsGame.getRatioMonitorW() - text.get("EnergyAdd").getPrefWidth() / 2, 68 * MarsGame.getRatioMonitorH());
        text.get("Microwave").setPosition((MarsGame.WIDTH / 2 - 278) * MarsGame.getRatioMonitorW() - text.get("Microwave").getPrefWidth() / 2, 68 * MarsGame.getRatioMonitorH());

        text.get("EnergyIcon1").setPosition((MarsGame.WIDTH / 2 + 286) * MarsGame.getRatioMonitorW(), 68 * MarsGame.getRatioMonitorH());
        text.get("EnergyIcon2").setPosition((MarsGame.WIDTH / 2 + 420) * MarsGame.getRatioMonitorW(), 68 * MarsGame.getRatioMonitorH());
        text.get("EnergyIcon3").setPosition((MarsGame.WIDTH / 2 + 556) * MarsGame.getRatioMonitorW(), 68 * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("HPGame"));
        stage.addActor(text.get("MPGame"));
        stage.addActor(text.get("ShieldHPAdd"));
        stage.addActor(text.get("EnergyAdd"));
        stage.addActor(text.get("Microwave"));
        stage.addActor(text.get("EnergyIcon1"));
        stage.addActor(text.get("EnergyIcon2"));
        stage.addActor(text.get("EnergyIcon3"));
        stage.addActor(text.get("ShowTitleRate"));
        stage.addActor(text.get("ShowTextRate"));
        stage.addActor(text.get("ShowClickRate"));
        stage.addActor(monsterArmy.getShowTextEnd());
    }

    private void buttonMenu() {
        for (int i = 0; i < maps.getButtons().size(); i++) stage.addActor(maps.getButtons().get(i));
        for (int i = 0; i < maps.getTowerses().size(); i++) {
            for (int j = 0; j < maps.getButtonsTower(i).size(); j++)
                stage.addActor(maps.getButtonsTower(i).get(j));
        }

        buttons.put("Home", new Buttons("Home", img, 90, 90, MarsGame.WIDTH - 107, MarsGame.HEIGHT - 100));
        buttons.put("PausePlay", new Buttons("PausePlay", img, 90, 90, MarsGame.WIDTH - 107, MarsGame.HEIGHT - 203));
        buttons.put("Newly", new Buttons("Newly", img, 90, 90, MarsGame.WIDTH - 107, MarsGame.HEIGHT - 306));
        buttons.put("Rate", new Buttons("Rate", img, 90, 90, MarsGame.WIDTH - 107, MarsGame.HEIGHT - 409));
        buttons.put("setRate", new Buttons("setRate", img, 512, 256, MarsGame.WIDTH + 256, MarsGame.HEIGHT / 2 - 64));
        buttons.put("Settings", new Buttons("Settings", img, 90, 90, MarsGame.WIDTH - 107, MarsGame.HEIGHT - 512));
        buttons.put("Music", new Buttons("Music", img, 90, 90, MarsGame.WIDTH + 100, MarsGame.HEIGHT - 112));
        buttons.put("Sound", new Buttons("Sound", img, 90, 90, MarsGame.WIDTH + 100, MarsGame.HEIGHT - 208));
        buttons.put("Vibro", new Buttons("Vibro", img, 90, 90, MarsGame.WIDTH + 100, MarsGame.HEIGHT - 162));
        buttons.put("Scale", new Buttons("Scale", img, 80, 80, MarsGame.WIDTH - 250, MarsGame.HEIGHT - 90));
        buttons.put("Faster", new Buttons("Faster", img, 80, 80, MarsGame.WIDTH - 330, MarsGame.HEIGHT - 90));
        buttons.put("NextWave", new Buttons("NextWave", img, 128, 128, -2000, 288));

        buttons.get("Home").addListener(new ButtonsInputListener(buttons.get("Home").getName()));
        buttons.get("PausePlay").addListener(new ButtonsInputListener(buttons.get("PausePlay").getName()));
        buttons.get("Newly").addListener(new ButtonsInputListener(buttons.get("Newly").getName()));
        buttons.get("Rate").addListener(new ButtonsInputListener(buttons.get("Rate").getName()));
        buttons.get("setRate").addListener(new ButtonsInputListener(buttons.get("setRate").getName()));
        buttons.get("Settings").addListener(new ButtonsInputListener(buttons.get("Settings").getName()));
        buttons.get("Music").addListener(new ButtonsInputListener(buttons.get("Music").getName()));
        buttons.get("Sound").addListener(new ButtonsInputListener(buttons.get("Sound").getName()));
        buttons.get("Vibro").addListener(new ButtonsInputListener(buttons.get("Vibro").getName()));
        buttons.get("Scale").addListener(new ButtonsInputListener(buttons.get("Scale").getName()));
        buttons.get("Faster").addListener(new ButtonsInputListener(buttons.get("Faster").getName()));
        buttons.get("NextWave").addListener(new ButtonsInputListener(buttons.get("NextWave").getName()));

        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("PausePlay"));
        stage.addActor(buttons.get("Newly"));
        stage.addActor(buttons.get("Rate"));
        stage.addActor(buttons.get("setRate"));
        stage.addActor(buttons.get("Settings"));
        stage.addActor(buttons.get("Music"));
        stage.addActor(buttons.get("Sound"));
        stage.addActor(buttons.get("Vibro"));
        stage.addActor(buttons.get("Scale"));
        stage.addActor(buttons.get("Faster"));
        stage.addActor(buttons.get("NextWave"));
    }

    private void buttonGamesPanel() {
        buttons.put("Shot", new Buttons("Shot", img, 256, 256, MarsGame.WIDTH - 288, 32));
        buttons.put("Fire", new Buttons("Fire", img, 120, 120, MarsGame.WIDTH / 2 + 218, 60));
        buttons.put("Poison", new Buttons("Poison", img, 120, 120, MarsGame.WIDTH / 2 + 352, 60));
        buttons.put("Ice", new Buttons("Ice", img, 120, 120, MarsGame.WIDTH / 2 + 488, 60));
        buttons.put("ShieldHPAdd", new Buttons("ShieldHPAdd", img, 120, 120, MarsGame.WIDTH / 2 - 608, 60));
        buttons.put("EnergyAdd", new Buttons("EnergyAdd", img, 120, 120, MarsGame.WIDTH / 2 - 472, 60));
        buttons.put("Microwave", new Buttons("Microwave", img, 120, 120, MarsGame.WIDTH / 2 - 338, 60));

        buttons.get("Shot").addListener(new ButtonsInputListener(buttons.get("Shot").getName()));
        buttons.get("Fire").addListener(new ButtonsInputListener(buttons.get("Fire").getName()));
        buttons.get("Poison").addListener(new ButtonsInputListener(buttons.get("Poison").getName()));
        buttons.get("Ice").addListener(new ButtonsInputListener(buttons.get("Ice").getName()));
        buttons.get("ShieldHPAdd").addListener(new ButtonsInputListener(buttons.get("ShieldHPAdd").getName()));
        buttons.get("EnergyAdd").addListener(new ButtonsInputListener(buttons.get("EnergyAdd").getName()));
        buttons.get("Microwave").addListener(new ButtonsInputListener(buttons.get("Microwave").getName()));

        touchpadSkin = new Skin();
        touchpadSkin.add("touchBackground", Textures.getInstance().textureRegion.get("Move"));
        touchpadSkin.add("touchKnob", Textures.getInstance().textureRegion.get("Aim"));
        touchpadStyle = new TouchpadStyle();
        touchpadStyle.background = touchpadSkin.getDrawable("touchBackground");
        touchpadStyle.knob = touchpadSkin.getDrawable("touchKnob");
        touchpad = new Touchpad(10, touchpadStyle);
        touchpad.setBounds(32 * MarsGame.getRatioMonitorW(), 32 * MarsGame.getRatioMonitorH(), 256 * MarsGame.getRatioMonitorW(), 256 * MarsGame.getRatioMonitorH());

        stage.addActor(touchpad);
        stage.addActor(buttons.get("Shot"));
        stage.addActor(buttons.get("Fire"));
        stage.addActor(buttons.get("Poison"));
        stage.addActor(buttons.get("Ice"));
        stage.addActor(buttons.get("ShieldHPAdd"));
        stage.addActor(buttons.get("EnergyAdd"));
        stage.addActor(buttons.get("Microwave"));
    }

    private void story(String typeStartFinish) throws NullPointerException {
        this.type = typeStartFinish;

        if (typeStartFinish.equals("Finish") || typeStartFinish.equals("GameOver")) {
            for (int i = 0; i < 4; i++) maps.getTowerses().get(i).soundsStop();
            buttons.clear();
            text.clear();
            stage.clear();
        }
        //region Text
        text.put("SpeakRobot", new Label("", style48));
        text.put("Version_1", new Label("1", style100));
        text.put("Version_2", new Label("2", style100));
        text.put("Version_3", new Label("3", style100));
        text.put("Version_4", new Label("4", style100));
        text.get("Version_1").setPosition((MarsGame.WIDTH + 200) * MarsGame.getRatioMonitorW(), 0);
        text.get("Version_2").setPosition((MarsGame.WIDTH + 200) * MarsGame.getRatioMonitorW(), 0);
        text.get("Version_3").setPosition((MarsGame.WIDTH + 200) * MarsGame.getRatioMonitorW(), 0);
        text.get("Version_4").setPosition((MarsGame.WIDTH + 200) * MarsGame.getRatioMonitorW(), 0);
        //endregion
        isStoryActive = true;
        MarsGame.getPreference().isPlay = false;

        if (typeStartFinish.equals("GameOver")) storySpeak = random.nextInt(17) + 1;
        else storySpeak = 1;
        storyText(storySpeak);

        buttons.put("NextText", new Buttons("NextText", img, 128, 128, MarsGame.WIDTH - 150, 16));
        buttons.put("Version_1", new Buttons("Version_1", img, 128, 128, MarsGame.WIDTH + 256, MarsGame.HEIGHT / 2 + 96));
        buttons.put("Version_2", new Buttons("Version_2", img, 128, 128, MarsGame.WIDTH + 256, MarsGame.HEIGHT / 2 - 96));
        buttons.put("Version_3", new Buttons("Version_3", img, 128, 128, MarsGame.WIDTH + 64, MarsGame.HEIGHT / 2 - 96));
        buttons.put("Version_4", new Buttons("Version_4", img, 128, 128, MarsGame.WIDTH + 64, MarsGame.HEIGHT / 2 + 96));

        buttons.get("NextText").addListener(new ButtonsInputListener(buttons.get("NextText").getName()));
        buttons.get("Version_1").addListener(new ButtonsInputListener(buttons.get("Version_1").getName()));
        buttons.get("Version_2").addListener(new ButtonsInputListener(buttons.get("Version_2").getName()));
        buttons.get("Version_3").addListener(new ButtonsInputListener(buttons.get("Version_3").getName()));
        buttons.get("Version_4").addListener(new ButtonsInputListener(buttons.get("Version_4").getName()));

        stage.addActor(text.get("SpeakRobot"));
        stage.addActor(text.get("Version_1"));
        stage.addActor(text.get("Version_2"));
        stage.addActor(text.get("Version_3"));
        stage.addActor(text.get("Version_4"));
        stage.addActor(buttons.get("NextText"));
        stage.addActor(buttons.get("Version_1"));
        stage.addActor(buttons.get("Version_2"));
        stage.addActor(buttons.get("Version_3"));
        stage.addActor(buttons.get("Version_4"));
    }

    private void storyText(int storySpeak) {
        int i = 0;
        if (type.equals("Start")) {
            //region 1
            if (mission.equals("Missions_1_1")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 6) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 7) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_1_2")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 6) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_1_3")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_1_4")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_1_5")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_1_6")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 6) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 7) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            }
            //endregion
            //region 2
            else if (mission.equals("Missions_2_1")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 6) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_2_2")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_2_3")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_2_4")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_2_5")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_2_6")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            }
            //endregion
            //region 3
            else if (mission.equals("Missions_3_1")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_3_2")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 6) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_3_3")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_3_4")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 6) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_3_5")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_3_6")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 6) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            }
            //endregion
            //region 4
            else if (mission.equals("Missions_4_1")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 6) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 7) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_4_2")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_4_3")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 6) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 7) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_4_4")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 6) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_4_5")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_4_6")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Start_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            }
            //endregion
        } else if (type.equals("Finish")) {
            //region 1
            if (mission.equals("Missions_1_1")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_1_2")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_1_3")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_1_4")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_1_5")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_1_6")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            }
            //endregion
            //region 2
            else if (mission.equals("Missions_2_1")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_2_2")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_2_3")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_2_4")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_2_5")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_2_6")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            }
            //endregion
            //region 3
            else if (mission.equals("Missions_3_1")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_3_2")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_3_3")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_3_4")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_3_5")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_3_6")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            }
            //endregion
            //region 4
            else if (mission.equals("Missions_4_1")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_4_2")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_4_3")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_4_4")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = ANGER;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_4_5")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = NORM;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            } else if (mission.equals("Missions_4_6")) {
                //region code
                if (storySpeak == 1) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 2) {
                    robotSpeak = MIMI;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 3) {
                    robotSpeak = MARSIAN;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 4) {
                    robotSpeak = SURPRISE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                        textMission.replace(i, i + 1, "\n");
                } else if (storySpeak == 5) {
                    robotSpeak = NONE;
                    textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Finish_" + storySpeak));
                    text.get("Version_1").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_1").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    text.get("Version_2").setPosition((MarsGame.WIDTH / 2 - 192) * MarsGame.getRatioMonitorW() - text.get("Version_2").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_3").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_3").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 - 86) * MarsGame.getRatioMonitorH());
                    text.get("Version_4").setPosition((MarsGame.WIDTH / 2 + 128) * MarsGame.getRatioMonitorW() - text.get("Version_4").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 108) * MarsGame.getRatioMonitorH());
                    buttons.get("NextText").setPosition(MarsGame.WIDTH + 128, 16);
                    buttons.get("Version_1").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    buttons.get("Version_2").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_3").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    buttons.get("Version_4").setPosition(MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                }
                //endregion
            }
            //endregion
        } else if (type.equals("GameOver")) {
            //region code
            if (storySpeak == 1) robotSpeak = SURPRISE;
            else if (storySpeak == 2) robotSpeak = NORM;
            else if (storySpeak == 3) robotSpeak = SURPRISE;
            else if (storySpeak == 4) robotSpeak = SURPRISE;
            else if (storySpeak == 5) robotSpeak = MIMI;
            else if (storySpeak == 6) robotSpeak = SURPRISE;
            else if (storySpeak == 7) robotSpeak = ANGER;
            else if (storySpeak == 8) robotSpeak = ANGER;
            else if (storySpeak == 9) robotSpeak = NORM;
            else if (storySpeak == 10) robotSpeak = MIMI;
            else if (storySpeak == 11) robotSpeak = MIMI;
            else if (storySpeak == 12) robotSpeak = ANGER;
            else if (storySpeak == 13) robotSpeak = ANGER;
            else if (storySpeak == 14) robotSpeak = MIMI;
            else if (storySpeak == 15) robotSpeak = NORM;
            else if (storySpeak == 16) robotSpeak = NORM;
            else if (storySpeak == 17) robotSpeak = ANGER;
            textMission = new StringBuilder().append(MarsGame.getLanguage().textScreen.get("r7Die-" + storySpeak));
            while (i + 75 < textMission.length() && (i = textMission.lastIndexOf(" ", i + 75)) != -1)
                textMission.replace(i, i + 1, "\n");
            //endregion
        }

        text.get("SpeakRobot").setText(textMission);
        text.get("SpeakRobot").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("SpeakRobot").getPrefWidth() / 2, 86 * MarsGame.getRatioMonitorH() + text.get("SpeakRobot").getPrefHeight() / 2);
    }

    private void gameEnd(int type) {
        MarsGame.getCamera().zoom = 1.0f;
        MarsGame.getCamera().position.set(MarsGame.WIDTH / 2, MarsGame.HEIGHT / 2, 0);

        if (type == 0) { // gameover
            rank = 0;
            if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().sounds.get("GameOver").play();
            MarsGame.getPreference().setEventDeath();
            MarsGame.getPreference().setDeath();
            MarsGame.getPreference().setAchievementDeath();
            text.put("Finish", new Label(MarsGame.getLanguage().textScreen.get("Defeat"), new Label.LabelStyle(FontTTF.getInstance().getFont100(), Color.RED)));
        } else if (type == 1) { // gamefinish
            rank = 1;
            if (MarsGame.getPreference().loadSound() == 1)
                MarsGame.getMusicSound().musics.get("Victory").play();
            text.put("Finish", new Label(MarsGame.getLanguage().textScreen.get("Victory"), new Label.LabelStyle(FontTTF.getInstance().getFont100(), Color.GREEN)));
            if (!isCompleteMission) {
                isCompleteMission = true;
                MarsGame.getPreference().saveMissionFinish(mission);
                money += 500;
                mineral += 50;
                //region code anClose Weapons
                if (mission.equals("Missions_1_1")) {
                    MarsGame.getPreference().setWeaponClose("LauncherGun_1");
                    MarsGame.getPreference().setWeaponClose("FlareGun_1");
                    MarsGame.getPreference().setWeaponClose("LaserGun_1");
                } else if (mission.equals("Missions_1_2")) {
                    MarsGame.getPreference().setWeaponClose("MachineGun_2");
                } else if (mission.equals("Missions_1_3")) {
                    MarsGame.getPreference().setWeaponClose("LauncherGun_2");
                    MarsGame.getPreference().setWeaponClose("FlareGun_2");
                    MarsGame.getPreference().setWeaponClose("LaserGun_2");
                } else if (mission.equals("Missions_1_4")) {
                    MarsGame.getPreference().setWeaponClose("MachineGun_3");
                    MarsGame.getPreference().setWeaponClose("LauncherGun_3");
                    MarsGame.getPreference().setWeaponClose("FlareGun_3");
                    MarsGame.getPreference().setWeaponClose("LaserGun_3");
                } else if (mission.equals("Missions_1_5")) {
                    MarsGame.getPreference().setWeaponClose("MachineGun_4");
                    MarsGame.getPreference().setWeaponClose("LauncherGun_4");
                } else if (mission.equals("Missions_1_6")) {
                    MarsGame.getPreference().setWeaponClose("FlareGun_4");
                    MarsGame.getPreference().setWeaponClose("LaserGun_4");
                    MarsGame.getPreference().setEventKillingBoss(1);
                    MarsGame.getPreference().setAchievementBoss(1);
                } else if (mission.equals("Missions_2_1")) {
                    MarsGame.getPreference().setWeaponClose("MachineGun_5");
                    MarsGame.getPreference().setWeaponClose("LauncherGun_5");
                } else if (mission.equals("Missions_2_2")) {
                    MarsGame.getPreference().setWeaponClose("FlareGun_5");
                    MarsGame.getPreference().setWeaponClose("LaserGun_5");
                } else if (mission.equals("Missions_2_3")) {
                    MarsGame.getPreference().setWeaponClose("MachineGun_6");
                    MarsGame.getPreference().setWeaponClose("LauncherGun_6");
                    MarsGame.getPreference().setWeaponClose("FlareGun_6");
                    MarsGame.getPreference().setWeaponClose("LaserGun_6");
                } else if (mission.equals("Missions_2_5"))
                    MarsGame.getPreference().setWeaponClose("MachineGun_7");
                else if (mission.equals("Missions_2_6")) {
                    MarsGame.getPreference().setWeaponClose("LaserGun_7");
                    MarsGame.getPreference().setEventKillingBoss(2);
                    MarsGame.getPreference().setAchievementBoss(2);
                } else if (mission.equals("Missions_3_3"))
                    MarsGame.getPreference().setWeaponClose("MachineGun_8");
                else if (mission.equals("Missions_3_6")) {
                    MarsGame.getPreference().setEventKillingBoss(3);
                    MarsGame.getPreference().setAchievementBoss(3);
                } else if (mission.equals("Missions_4_4"))
                    MarsGame.getPreference().setWeaponClose("FlareGun_7");
                else if (mission.equals("Missions_4_6")) {
                    MarsGame.getPreference().setEventKillingBoss(4);
                    MarsGame.getPreference().setAchievementBoss(4);
                }
                //endregion
            }
            if (!isCompleteCrystals) {
                if (MarsGame.getPreference().getCrystal(mission) <= 0) {
                    isCompleteCrystals = true;
                    MarsGame.getPreference().saveMissionMineral(mission);
                    money += 500;
                    mineral += 50;
                }
            }
            if (!isCompleteIntact) {
                if (gamesPanel.isGoodLife()) {
                    isCompleteIntact = true;
                    MarsGame.getPreference().saveMissionLife(mission);
                    money += 500;
                    mineral += 50;
                }
            }
            if (!isCompleteDieWormCave) {
                if (monsterArmy.getDieWormCave()) {
                    isCompleteDieWormCave = true;
                    MarsGame.getPreference().saveMissionSecret(mission);
                    money += 500;
                    mineral += 50;
                }
            }
            if (isCompleteCrystals) rank++;
            if (isCompleteIntact) rank++;
            if (isCompleteDieWormCave) rank++;
        }

        if (rank == 4) MarsGame.getPreference().setAchievement4Stars();
        money += monsterArmy.getMonsterPrice();

        int crystalAdd;
        if (MarsGame.getPreference().loadMineral() != this.crystalAdd)
            crystalAdd = MarsGame.getPreference().loadMineral() - this.crystalAdd;
        else crystalAdd = 0;

        MarsGame.getPreference().setEventEarnMoney(money);
        MarsGame.getPreference().setAchievementMoney(MarsGame.getPreference().getEventEarnMoney());

        MarsGame.getPreference().setEventEarnMinerals(crystalAdd + mineral);
        MarsGame.getPreference().setAchievementMineral(MarsGame.getPreference().getEventEarnMinerals());

        MarsGame.getPreference().setEventKillingMonsters(monsterArmy.getDieMonster());
        MarsGame.getPreference().setAchievementKilling(MarsGame.getPreference().getEventKillingMonsters());

        int scoreUserRecord;
        if (monsterArmy.getDieMonster() == 0) scoreUserRecord = 1;
        else scoreUserRecord = monsterArmy.getMonsterPrice() / monsterArmy.getDieMonster() * rank;
        MarsGame.getPreference().setRecordTop(scoreUserRecord);

        //region Text
        text.put("Home", new Label(MarsGame.getLanguage().textScreen.get("Home"), style54));
        text.put("Newly", new Label(MarsGame.getLanguage().textScreen.get("Newly"), style54));
        text.put("Money", new Label(new StringBuilder().append("+").append(money), style48));
        text.put("Mineral", new Label(new StringBuilder().append("+").append(crystalAdd).append(" (+").append(mineral).append(")"), style48));

        text.get("Home").setPosition(128 * MarsGame.getRatioMonitorW(), 64 * MarsGame.getRatioMonitorH());
        text.get("Newly").setPosition((MarsGame.WIDTH - 128) * MarsGame.getRatioMonitorW() - text.get("Newly").getPrefWidth(), 64 * MarsGame.getRatioMonitorH());
        text.get("Finish").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("Finish").getPrefWidth() / 2, (MarsGame.HEIGHT - 256) * MarsGame.getRatioMonitorH());

        text.get("Money").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW(), MarsGame.HEIGHT / 2 * MarsGame.getRatioMonitorH());
        text.get("Mineral").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT / 2 - 128) * MarsGame.getRatioMonitorH());
        //endregion

        buttons.put("Home", new Buttons("Home", img, 512, 128, 64, 32));
        buttons.put("Newly", new Buttons("Newly", img, 512, 128, MarsGame.WIDTH - 576, 32));

        buttons.get("Home").addListener(new ButtonsInputListener(buttons.get("Home").getName()));
        buttons.get("Newly").addListener(new ButtonsInputListener(buttons.get("Newly").getName()));

        stage.addActor(text.get("Home"));
        stage.addActor(text.get("Newly"));
        stage.addActor(text.get("Finish"));
        stage.addActor(text.get("Money"));
        stage.addActor(text.get("Mineral"));
        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("Newly"));
    }

    private void clearTextStory() {
        buttons.clear();
        text.clear();
        stage.clear();

        textPutGet();
        buttonMenu();
        buttonGamesPanel();

        isStoryActive = false;
        MarsGame.getPreference().isPlay = true;
    }

    @Override
    public void update(float deltaTime) {
        if (!isGameEnd) {
            if (MarsGame.getPreference().isPlay) {
                if (isMicrowaves) {
                    //region code
                    if (!runMicrowaves.isActive()) {
                        runMicrowaves.updateTime();
                        MicrowavesMonster.INSTANCE.setRunMicrowaves(0);
                    } else {
                        isMicrowaves = false;
                        runMicrowaves.setTimeReset();
                        MicrowavesMonster.INSTANCE.setRunMicrowaves(1);
                    }
                    //endregion
                }
                //region code Game
                if (isLive) base.update(deltaTime);
                aimShoot.update(deltaTime, gamesPanel.getMP());
                gamesPanel.updateRadar(deltaTime);
                if (gamesPanel.getHP() > 0) {
                    gamesPanel.update();
                    if (gamesPanel.getShieldBonus() > 0) {
                        if (monsterArmy.getDamage() > 0)
                            gamesPanel.setRemoveHP((monsterArmy.getDamage() - monsterArmy.getDamage() * gamesPanel.getShieldBonus()) * deltaTime);
                    } else {
                        if (monsterArmy.getDamage() > 0)
                            gamesPanel.setRemoveHP(monsterArmy.getDamage() * deltaTime);
                    }
                    if (!aimShoot.isShoot()/* && aimShoot.getEmitter().getActiveCount() > 0*/)
                        gamesPanel.setRemoveMP(aimShoot.getEnergy());
                    if (monsterArmy.isBoss())
                        if (monsterArmy.isAbsorption()) gamesPanel.setRemoveMP(20 * deltaTime);
                    if (!isShoot)
                        if (aimShoot.getFireAim().isComplete() && aimShoot.getFireShot().isComplete())
                            aimShoot.setFire(false);
                    text.get("HPGame").setText(new StringBuilder().append(gamesPanel.getHP()).append("/").append(MarsGame.getPreference().loadHPBase()));
                    if (gamesPanel.getEnergyBonus() > 0)
                        text.get("MPGame").setText(new StringBuilder().append(gamesPanel.getMP()).append("/").append((int) (MarsGame.getPreference().loadMPEnergy() - gamesPanel.getEnergyBonus())).append(" (").append(MarsGame.getPreference().loadMPEnergy()).append(")"));
                    else
                        text.get("MPGame").setText(new StringBuilder().append(gamesPanel.getMP()).append("/").append(MarsGame.getPreference().loadMPEnergy()));
                    text.get("HPGame").setPosition((MarsGame.WIDTH / 2 - 5) * MarsGame.getRatioMonitorW() - text.get("HPGame").getPrefWidth() / 2, 117 * MarsGame.getRatioMonitorH());
                    text.get("MPGame").setPosition((MarsGame.WIDTH / 2 + 25) * MarsGame.getRatioMonitorW() - text.get("MPGame").getPrefWidth() / 2, 72 * MarsGame.getRatioMonitorH());
                }
                position.set(-touchpad.getKnobPercentX() * 3, -touchpad.getKnobPercentY() * 3);
                newPosition.add(position.x * deltaTime * 120, position.y * deltaTime * 120);
                if (!aimShoot.isShoot()) positionFireAim.add(position.x * deltaTime * 120 * scale, position.y * deltaTime * 120 * scale);
                else if (aimShoot.getFireAim().isComplete()) positionFireAim.set(0, 0);
                monsterArmy.update(deltaTime, aimShoot.getAim(), aimShoot.getShotPower(), aimShoot.getEmitter().getActiveCount(), maps.getTowerses(), gamesPanel.getDamageBonus(), gamesPanel.getMagic());
                maps.update(newPosition, deltaTime, gamesPanel.getMP());
                if (maps.getPriceBuy() > 0) {
                    gamesPanel.setRemoveMP(maps.getPriceBuy());
                    maps.setPriceBuy(0);
                }
                if (maps.getEnergy() > 0 && gamesPanel.getMP() > 0)
                    gamesPanel.setRemoveMP(maps.getEnergy() * deltaTime);
                gamesPanel.getMagic().update(deltaTime);
                //region GameOver
                if (gamesPanel.getHP() <= 0) {
                    text.get("HPGame").setText(new StringBuilder().append(0).append("/").append(MarsGame.getPreference().loadHPBase()));
                    text.get("HPGame").setPosition((MarsGame.WIDTH / 2 - 5) * MarsGame.getRatioMonitorW() - text.get("HPGame").getPrefWidth() / 2, 117 * MarsGame.getRatioMonitorH());
                    explosion.update(deltaTime);
                    if (isSoundDie) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("Explosion").play();
                        isSoundDie = false;
                    }
                    if (isVibroDie) {
                        Gdx.input.vibrate(2000);
                        isVibroDie = false;
                    }
                    if (explosion.isComplete()) {
                        isLive = false;
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("SoundWeapon").stop();
                        MarsGame.getCamera().zoom = 1.0f;
                        MarsGame.getCamera().position.set(MarsGame.WIDTH / 2, MarsGame.HEIGHT / 2, 0);
                        MarsGame.getCamera().update();
                        story("GameOver");
                    }
                }
                //endregion
                //region KillAll
                if (monsterArmy.isGameEnd()) {
                    MarsGame.getCamera().zoom = 1.0f;
                    MarsGame.getCamera().position.set(MarsGame.WIDTH / 2, MarsGame.HEIGHT / 2, 0);
                    MarsGame.getCamera().update();
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("SoundWeapon").stop();
                    if (!MarsGame.getPreference().getStoryFinish(mission)) story("Finish");
                    else {
                        buttons.clear();
                        text.clear();
                        stage.clear();
                        isGameEnd = true;
                        gameEnd(1);
                    }
                }
                //endregion
                //endregion
            }
        }
        crystals.update(deltaTime);
    }

    @Override
    public void render(SpriteBatch batch) {
        if (!isGameEnd) {
            //region code
            if (gamesPanel.getHP() <= 0 && MarsGame.getPreference().isPlay)
                MarsGame.getCamera().position.set(MarsGame.WIDTH / 2 - newPosition.x + random.nextInt(40) - 20,
                        MarsGame.HEIGHT / 2 - newPosition.y + random.nextInt(40) - 20, 0);
            else
                MarsGame.getCamera().position.set(MarsGame.WIDTH / 2 - newPosition.x, MarsGame.HEIGHT / 2 - newPosition.y, 0);

            maps.render(MarsGame.getCamera());

            batch.begin();
            crystals.render(batch);
            monsterArmy.renderDie(batch);
            monsterArmy.render(batch);
            maps.renderTower(batch);
            if (isLive) base.render(batch, newPosition);
            gamesPanel.getMagic().render(batch);
            if (gamesPanel.getHP() <= 0 && MarsGame.getPreference().isPlay) {
                explosion.setPosition(MarsGame.WIDTH / 2 - 64, MarsGame.HEIGHT / 2 + 36);
                explosion.draw(batch);
            }
            aimShoot.render(batch, newPosition, position, positionFireAim, MarsGame.getCamera());
            gamesPanel.render(batch, monsterArmy.getMonster_List());
            if (monsterArmy.isBoss()) gamesPanel.renderBoss(batch, monsterArmy.getBoss());
            if (monsterArmy.isStartNewWave()) {
                batch.draw(Textures.getInstance().textureRegion.get("NextWave"), MarsGame.WIDTH / 2 - 64, 288);
                if (buttons.get("NextWave").getX() == -2000)
                    buttons.get("NextWave").setPosition(MarsGame.WIDTH / 2 - 64, 288);
                startNewWave++;
                batch.draw(Textures.getInstance().textureRegion.get("ColorWhite"), 0, 0, 6.4f * startNewWave, 2);
                if (startNewWave >= 300) {
                    startNewWave = 0;
                    monsterArmy.wavesTotalMonster();
                    buttons.get("NextWave").setPosition(-2000, 288 * MarsGame.getRatioMonitorH());
                }
            }
            batch.end();
            //endregion
            //region Story Start
            if (isStoryActive) {
                batch.begin();
                batch.draw(Textures.getInstance().textureRegion.get("Hide"), 0, 0, MarsGame.WIDTH, MarsGame.HEIGHT);
                if (robotSpeak == NORM)
                    batch.draw(Textures.getInstance().textureRegionScreen.get("R_7Speak_norm"), 80, text.get("SpeakRobot").getPrefHeight() / MarsGame.getRatioMonitorH() + 16);
                else if (robotSpeak == MIMI)
                    batch.draw(Textures.getInstance().textureRegionScreen.get("R_7Speak_mimi"), 80, text.get("SpeakRobot").getPrefHeight() / MarsGame.getRatioMonitorH() + 16);
                else if (robotSpeak == SURPRISE)
                    batch.draw(Textures.getInstance().textureRegionScreen.get("R_7Speak_surprise"), 80, text.get("SpeakRobot").getPrefHeight() / MarsGame.getRatioMonitorH() + 16);
                else if (robotSpeak == ANGER)
                    batch.draw(Textures.getInstance().textureRegionScreen.get("R_7Speak_anger"), 80, text.get("SpeakRobot").getPrefHeight() / MarsGame.getRatioMonitorH() + 16);
                else if (robotSpeak == MARSIAN)
                    batch.draw(Textures.getInstance().textureRegionScreen.get("Marsian"), 80, text.get("SpeakRobot").getPrefHeight() / MarsGame.getRatioMonitorH() + 80);
                batch.draw(Textures.getInstance().textureRegion.get("MP"), 64, 64, MarsGame.WIDTH - 128, text.get("SpeakRobot").getPrefHeight() / MarsGame.getRatioMonitorH() + 42);
                batch.draw(Textures.getInstance().textureRegion.get("Black"), 65, 65, MarsGame.WIDTH - 130, text.get("SpeakRobot").getPrefHeight() / MarsGame.getRatioMonitorH() + 40);
                if (robotSpeak != NONE)
                    batch.draw(Textures.getInstance().textureRegion.get("FastOff"), MarsGame.WIDTH - 100, 16, 80, 80);
                else if (robotSpeak == NONE) {
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGames3"), MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 + 96);
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGames3"), MarsGame.WIDTH / 2 - 128, MarsGame.HEIGHT / 2 + 96, -64, 128);

                    batch.draw(Textures.getInstance().textureRegion.get("MenuGames3"), MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 96);
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGames3"), MarsGame.WIDTH / 2 - 128, MarsGame.HEIGHT / 2 - 96, -64, 128);

                    batch.draw(Textures.getInstance().textureRegion.get("MenuGames3"), MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 - 96);
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGames3"), MarsGame.WIDTH / 2 + 192, MarsGame.HEIGHT / 2 - 96, -64, 128);

                    batch.draw(Textures.getInstance().textureRegion.get("MenuGames3"), MarsGame.WIDTH / 2 + 64, MarsGame.HEIGHT / 2 + 96);
                    batch.draw(Textures.getInstance().textureRegion.get("MenuGames3"), MarsGame.WIDTH / 2 + 192, MarsGame.HEIGHT / 2 + 96, -64, 128);
                }
                batch.end();
            }
            MarsGame.getCamera().update();
            //endregion
        } else {
            batch.begin();
            if (rank == 1)
                batch.draw(Textures.getInstance().textureRegion.get("Rank_1"), MarsGame.WIDTH / 2 - 64, MarsGame.HEIGHT - 416);
            else if (rank == 2)
                batch.draw(Textures.getInstance().textureRegion.get("Rank_2"), MarsGame.WIDTH / 2 - 64, MarsGame.HEIGHT - 416);
            else if (rank == 3)
                batch.draw(Textures.getInstance().textureRegion.get("Rank_3"), MarsGame.WIDTH / 2 - 64, MarsGame.HEIGHT - 416);
            else if (rank == 4)
                batch.draw(Textures.getInstance().textureRegion.get("Rank_4"), MarsGame.WIDTH / 2 - 64, MarsGame.HEIGHT - 416);

            batch.draw(Textures.getInstance().textureRegion.get("MoneyMission"), MarsGame.WIDTH / 2 - 100, MarsGame.HEIGHT / 2);
            batch.draw(Textures.getInstance().textureRegion.get("MineralMission"), MarsGame.WIDTH / 2 - 100, MarsGame.HEIGHT / 2 - 128);
            batch.end();
            MarsGame.getCamera().update();
        }

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        try {
            gamesPanel.dispose();
            base.dispose();
            maps.dispose();
            monsterArmy.dispose();
            crystals.dispose();
            aimShoot.dispose();

            explosion.dispose();

            stage.dispose();
            buttons.clear();
            text.clear();
            position = null;
            newPosition = null;
            positionFireAim = null;
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
        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            if (name.equals("Shot")) {
                //region
                if (gamesPanel.getHP() > 0) {
                    if (MarsGame.getPreference().isPlay) {
                        if (aimShoot.getNameWeapon().substring(0, 4).equals("Mach")) {
                            aimShoot.setFire(true);
                            aimShoot.getFireAim().reset();
                            if (MarsGame.getPreference().loadSound() == 1)
                                MarsGame.getMusicSound().sounds.get("SoundWeapon").loop();
                        } else {
                            aimShoot.setFire(true);
                            isShoot = true;
                        }
                    }
                }
                //endregion
            } else if (name.equals("Fire")) {
                if (MarsGame.getPreference().isPlay)
                    if (gamesPanel.isActiveFire() && gamesPanel.getMP() >= 25)
                        gamesPanel.setTouchFire(true);
            } else if (name.equals("Poison")) {
                if (MarsGame.getPreference().isPlay)
                    if (gamesPanel.isActivePoison() && gamesPanel.getMP() >= 25)
                        gamesPanel.setTouchPoison(true);
            } else if (name.equals("Ice")) {
                if (MarsGame.getPreference().isPlay)
                    if (gamesPanel.isActiveIce() && gamesPanel.getMP() >= 25)
                        gamesPanel.setTouchIce(true);
            } else if (name.equals("ShieldHPAdd")) {
                if (gamesPanel.getHP() > 0) {
                    if (MarsGame.getPreference().loadShieldHPAdd() >= 1)
                        gamesPanel.setTouchShieldHPAdd(true);
                }
            } else if (name.equals("EnergyAdd")) {
                if (gamesPanel.getHP() > 0)
                    if (MarsGame.getPreference().loadEnergyAdd() >= 1)
                        gamesPanel.setTouchEnergyAdd(true);
            } else if (name.equals("Microwave")) {
                if (MarsGame.getPreference().isPlay && gamesPanel.getHP() >= 1)
                    if (MarsGame.getPreference().loadMicrowave() == 1)
                        gamesPanel.setTouchMicrowave(true);
            } else if (name.equals("Home")) gamesPanel.setTouchHome(true);
            else if (name.equals("PausePlay")) gamesPanel.setTouchPausePlay(true);
            else if (name.equals("Newly")) gamesPanel.setTouchNewly(true);
            else if (name.equals("Rate")) gamesPanel.setTouchRate(true);
            else if (name.equals("Settings")) gamesPanel.setTouchSettings(true);
            else if (name.equals("Music")) gamesPanel.setTouchMusic(true);
            else if (name.equals("Sound")) gamesPanel.setTouchSound(true);
            else if (name.equals("Vibro")) gamesPanel.setTouchVibro(true);
            return true;
        }

        @Override
        public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

            if (name.equals("Home")) {
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                MarsGame.getPreference().saveCredit(money, mineral);
                game.set(new Loading(game, "Hangar"));
            } else if (name.equals("Newly")) {
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                MarsGame.getPreference().saveCredit(money, mineral);
                game.set(new Loading(game, "Repeat" + mission));
            } else if (name.equals("NextText")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (type.equals("Start")) {
                    storySpeak += 1;
                    storyText(storySpeak);
                } else if (type.equals("Finish")) {
                    storySpeak += 1;
                    storyText(storySpeak);
                } else if (type.equals("GameOver")) {
                    buttons.clear();
                    text.clear();
                    stage.clear();
                    isGameEnd = true;
                    gameEnd(0);
                }
                //endregion
            } else if (name.equals("Version_1")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (type.equals("Start")) {
                    MarsGame.getPreference().setStoryStart(mission, 1);
                    clearTextStory();
                } else if (type.equals("Finish")) {
                    MarsGame.getPreference().setStoryFinish(mission, 1);
                    buttons.clear();
                    text.clear();
                    stage.clear();
                    isGameEnd = true;
                    gameEnd(1);
                }
                //endregion
            } else if (name.equals("Version_2")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (type.equals("Start")) {
                    MarsGame.getPreference().setStoryStart(mission, 0);
                    clearTextStory();
                } else if (type.equals("Finish")) {
                    MarsGame.getPreference().setStoryFinish(mission, 0);
                    buttons.clear();
                    text.clear();
                    stage.clear();
                    isGameEnd = true;
                    gameEnd(1);
                }
                //endregion
            } else if (name.equals("Version_3")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (type.equals("Start")) {
                    MarsGame.getPreference().setStoryStart(mission, 3);
                    clearTextStory();
                } else if (type.equals("Finish")) {
                    MarsGame.getPreference().setStoryFinish(mission, 3);
                    buttons.clear();
                    text.clear();
                    stage.clear();
                    isGameEnd = true;
                    gameEnd(1);
                }
                //endregion
            } else if (name.equals("Version_4")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (type.equals("Start")) {
                    MarsGame.getPreference().setStoryStart(mission, 2);
                    clearTextStory();
                } else if (type.equals("Finish")) {
                    MarsGame.getPreference().setStoryFinish(mission, 2);
                    buttons.clear();
                    text.clear();
                    stage.clear();
                    isGameEnd = true;
                    gameEnd(1);
                }
                //endregion
            } else if (name.equals("Shot")) {
                //region
                if (MarsGame.getPreference().isPlay && gamesPanel.getHP() > 0) {
                    if (aimShoot.getNameWeapon().substring(0, 4).equals("Mach")) {
                        aimShoot.setFire(false);
                        aimShoot.getFireAim().reset();
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("SoundWeapon").stop();
                    } else isShoot = false;
                }
                //endregion
            } else if (name.equals("Fire")) {
                //region
                if (MarsGame.getPreference().isPlay) {
                    if (gamesPanel.isActiveFire() && gamesPanel.getMP() >= 25) {
                        gamesPanel.setTouchFire(false);
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("Fire").play();
                        gamesPanel.setResetFire(true);
                        gamesPanel.setRemoveMP(25);

                        gamesPanel.getMagic().setMagicPowerFire(MarsGame.getPreference().loadHydrogenDamage());
                        if (scale == 1) {
                            gamesPanel.getMagic().setPushMagicFire(Gdx.input.getX(pointer) / MarsGame.getRatioMonitorW() + MarsGame.getCamera().position.x,
                                    (MarsGame.HEIGHT * MarsGame.getRatioMonitorH() - Gdx.input.getY(pointer)) / MarsGame.getRatioMonitorH() + MarsGame.getCamera().position.y, true);
                        } else if (scale == 0.5f) {
                            gamesPanel.getMagic().setPushMagicFire(Gdx.input.getX(pointer) / MarsGame.getRatioMonitorW() * 2 + MarsGame.getCamera().position.x,
                                    (MarsGame.HEIGHT * MarsGame.getRatioMonitorH() - Gdx.input.getY(pointer)) / MarsGame.getRatioMonitorH() * 2 + MarsGame.getCamera().position.y, true);
                        }
                    } else if (gamesPanel.isActiveFire() && gamesPanel.getMP() < 25) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Poison")) {
                //region
                if (MarsGame.getPreference().isPlay) {
                    if (gamesPanel.isActivePoison() && gamesPanel.getMP() >= 25) {
                        gamesPanel.setTouchPoison(false);
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("Poison").play();
                        gamesPanel.setResetPoison(true);
                        gamesPanel.setRemoveMP(25);

                        gamesPanel.getMagic().setMagicPowerPoison(MarsGame.getPreference().loadZomanDamage());
                        if (scale == 1) {
                            gamesPanel.getMagic().setPushMagicPoison(Gdx.input.getX(pointer) / MarsGame.getRatioMonitorW() + MarsGame.getCamera().position.x,
                                    (MarsGame.HEIGHT * MarsGame.getRatioMonitorH() - Gdx.input.getY(pointer)) / MarsGame.getRatioMonitorW() + MarsGame.getCamera().position.y, true);
                        } else if (scale == 0.5f) {
                            gamesPanel.getMagic().setPushMagicPoison(Gdx.input.getX(pointer) / MarsGame.getRatioMonitorW() * 2 + MarsGame.getCamera().position.x,
                                    (MarsGame.HEIGHT * MarsGame.getRatioMonitorH() - Gdx.input.getY(pointer)) / MarsGame.getRatioMonitorW() * 2 + MarsGame.getCamera().position.y, true);
                        }
                    } else if (gamesPanel.isActivePoison() && gamesPanel.getMP() < 25) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Ice")) {
                //region
                if (MarsGame.getPreference().isPlay) {
                    if (gamesPanel.isActiveIce() && gamesPanel.getMP() >= 25) {
                        gamesPanel.setTouchIce(false);
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("Ice").play();
                        gamesPanel.setResetIce(true);
                        gamesPanel.setRemoveMP(25);

                        gamesPanel.getMagic().setMagicPowerIce(MarsGame.getPreference().loadRefrigerantDamage());
                        if (scale == 1) {
                            gamesPanel.getMagic().setPushMagicIce(Gdx.input.getX(pointer) / MarsGame.getRatioMonitorW() + MarsGame.getCamera().position.x,
                                    (MarsGame.HEIGHT * MarsGame.getRatioMonitorH() - Gdx.input.getY(pointer)) / MarsGame.getRatioMonitorW() + MarsGame.getCamera().position.y, true);
                        } else if (scale == 0.5f) {
                            gamesPanel.getMagic().setPushMagicIce(Gdx.input.getX(pointer) / MarsGame.getRatioMonitorW() * 2 + MarsGame.getCamera().position.x,
                                    (MarsGame.HEIGHT * MarsGame.getRatioMonitorH() - Gdx.input.getY(pointer)) / MarsGame.getRatioMonitorW() * 2 + MarsGame.getCamera().position.y, true);
                        }
                    } else if (gamesPanel.isActiveIce() && gamesPanel.getMP() < 25) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("ShieldHPAdd")) {
                //region
                if (gamesPanel.getHP() > 0) {
                    if (MarsGame.getPreference().loadShieldHPAdd() >= 1) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("Shield").play();
                        gamesPanel.setRemoveHP(-(MarsGame.getPreference().loadHPBase() * MarsGame.getPreference().getTacticsDefenseShieldHPup() / 100));
                        gamesPanel.setTouchShieldHPAdd(false);
                        MarsGame.getPreference().saveShieldHPAdd(-1);
                        text.get("ShieldHPAdd").setText(String.valueOf(MarsGame.getPreference().loadShieldHPAdd()));
                        text.get("ShieldHPAdd").setPosition((MarsGame.WIDTH / 2 - 548) * MarsGame.getRatioMonitorW() - text.get("ShieldHPAdd").getPrefWidth() / 2, 68 * MarsGame.getRatioMonitorH());
                    }
                }
                //endregion
            } else if (name.equals("EnergyAdd")) {
                //region
                if (gamesPanel.getHP() > 0) {
                    if (MarsGame.getPreference().loadEnergyAdd() >= 1) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("Energy").play();
                        gamesPanel.setRemoveMP(-(MarsGame.getPreference().loadMPEnergy() * MarsGame.getPreference().getTacticsDefenseEnergyUp() / 100));
                        gamesPanel.setTouchEnergyAdd(false);
                        MarsGame.getPreference().saveEnergyAdd(-1);
                        text.get("EnergyAdd").setText(String.valueOf(MarsGame.getPreference().loadEnergyAdd()));
                        text.get("EnergyAdd").setPosition((MarsGame.WIDTH / 2 - 412) * MarsGame.getRatioMonitorW() - text.get("EnergyAdd").getPrefWidth() / 2, 68 * MarsGame.getRatioMonitorH());
                    }
                }
                //endregion
            } else if (name.equals("Microwave")) {
                //region
                if (MarsGame.getPreference().isPlay && gamesPanel.getHP() >= 1) {
                    if (MarsGame.getPreference().loadMicrowave() >= 0) {
                        if (MarsGame.getPreference().loadSound() == 1)
                            MarsGame.getMusicSound().sounds.get("Microwave").play();
                        gamesPanel.setTouchMicrowave(false);
                        isMicrowaves = true;
                        MarsGame.getPreference().saveMicrowave(-1);
                        text.get("Microwave").setText(String.valueOf(MarsGame.getPreference().loadMicrowave()));
                        text.get("Microwave").setPosition((MarsGame.WIDTH / 2 - 278) * MarsGame.getRatioMonitorW() - text.get("Microwave").getPrefWidth() / 2, 68 * MarsGame.getRatioMonitorH());
                    }
                }
                //endregion
            } else if (name.equals("Home")) {
                //region
                gamesPanel.setTouchHome(false);
                if (MarsGame.getPreference().loadSound() == 1) {
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    for (int i = 0; i < 4; i++) maps.getTowerses().get(i).soundsStop();
                }
                game.set(new Loading(game, "Hangar"));
                //endregion
            } else if (name.equals("PausePlay")) {
                //region
                gamesPanel.setTouchPausePlay(false);
                if (MarsGame.getPreference().loadSound() == 1) {
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    for (int i = 0; i < 4; i++) maps.getTowerses().get(i).soundsStop();
                }
                if (MarsGame.getPreference().isPlay) {
                    MarsGame.getPreference().isPlay = false;
                } else {
                    MarsGame.getPreference().isPlay = true;
                    gamesPanel.setShowRate(false);
                    text.get("ShowTitleRate").setText("");
                    text.get("ShowTextRate").setText("");
                    text.get("ShowClickRate").setText("");
                    buttons.get("setRate").setPosition(MarsGame.WIDTH + 256, MarsGame.HEIGHT / 2 - 64);
                }
                //endregion
            } else if (name.equals("Newly")) {
                gamesPanel.setTouchNewly(false);
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Repeat" + mission));
            } else if (name.equals("Rate")) {
                //region
                gamesPanel.setTouchRate(false);
                if (MarsGame.getPreference().loadSound() == 1) {
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    for (int i = 0; i < 4; i++) maps.getTowerses().get(i).soundsStop();
                }
                MarsGame.getPreference().isPlay = false;
                if (!gamesPanel.isShowRate()) {
                    gamesPanel.setShowRate(true);
                    buttons.get("setRate").setPosition(MarsGame.WIDTH / 2 - 256, MarsGame.HEIGHT / 2 - 64);

                    text.get("ShowTitleRate").setText(MarsGame.getLanguage().textScreen.get("ShowTitleRate"));
                    text.get("ShowTextRate").setText(MarsGame.getLanguage().textScreen.get("ShowTextRate"));
                    text.get("ShowClickRate").setText(MarsGame.getLanguage().textScreen.get("ShowClickRate"));
                    text.get("ShowTitleRate").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("ShowTitleRate").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 160) * MarsGame.getRatioMonitorH());
                    text.get("ShowTextRate").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("ShowTextRate").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 80) * MarsGame.getRatioMonitorH());
                    text.get("ShowClickRate").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("ShowClickRate").getPrefWidth() / 2, (MarsGame.HEIGHT / 2 + 8) * MarsGame.getRatioMonitorH());
                } else {
                    gamesPanel.setShowRate(false);
                    text.get("ShowTitleRate").setText("");
                    text.get("ShowTextRate").setText("");
                    text.get("ShowClickRate").setText("");
                    buttons.get("setRate").setPosition(MarsGame.WIDTH + 256, MarsGame.HEIGHT / 2 - 64);
                }
                //endregion
            } else if (name.equals("setRate")) {
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=studio.rashka.mars2222");
            } else if (name.equals("Settings")) {
                //region
                gamesPanel.setTouchSettings(false);
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (gamesPanel.isSettings()) {
                    gamesPanel.setSettings(false);
                    buttons.get("Music").setPosition(MarsGame.WIDTH + 100, MarsGame.HEIGHT - 112);
                    buttons.get("Sound").setPosition(MarsGame.WIDTH + 100, MarsGame.HEIGHT - 208);
                    buttons.get("Vibro").setPosition(MarsGame.WIDTH + 100, MarsGame.HEIGHT - 162);
                } else {
                    gamesPanel.setSettings(true);
                    buttons.get("Music").setPosition(MarsGame.WIDTH - 220, MarsGame.HEIGHT - 512);
                    buttons.get("Sound").setPosition(MarsGame.WIDTH - 204, MarsGame.HEIGHT - 602);
                    buttons.get("Vibro").setPosition(MarsGame.WIDTH - 107, MarsGame.HEIGHT - 625);
                }
                //endregion
            } else if (name.equals("Music")) {
                //region
                gamesPanel.setTouchMusic(false);
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (MarsGame.getPreference().loadMusic() == 0) {
                    MarsGame.getPreference().saveMusic(1);
                    MarsGame.getMusicSound().fon.get("Fon").setLooping(true);
                    MarsGame.getMusicSound().fon.get("Fon").play();
                } else if (MarsGame.getPreference().loadMusic() == 1) {
                    MarsGame.getPreference().saveMusic(0);
                    MarsGame.getMusicSound().fon.get("Fon").setLooping(false);
                    MarsGame.getMusicSound().fon.get("Fon").stop();
                }
                //endregion
            } else if (name.equals("Sound")) {
                //region
                gamesPanel.setTouchSound(false);
                if (MarsGame.getPreference().loadSound() == 0) {
                    MarsGame.getPreference().saveSound(1);
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                } else if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getPreference().saveSound(0);
                //endregion
            } else if (name.equals("Vibro")) {
                //region
                gamesPanel.setTouchVibro(false);
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (MarsGame.getPreference().loadVibro() == 0) {
                    MarsGame.getPreference().saveVibro(1);
                    isVibroDie = true;
                } else if (MarsGame.getPreference().loadVibro() == 1) {
                    MarsGame.getPreference().saveVibro(0);
                    isVibroDie = false;
                }
                //endregion
            } else if (name.equals("Scale")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (scale == 1) {
                    scale = 0.5f;
//                    maps.setScale(scale);
//                    gamesPanel.setScale(scale);
                    ScaleMap.INSTANCE.setScale(scale);
                    MarsGame.getCamera().zoom = 2.0f;
                } else if (scale == 0.5f) {
                    scale = 1;
//                    maps.setScale(scale);
//                    gamesPanel.setScale(scale);
                    ScaleMap.INSTANCE.setScale(scale);
                    MarsGame.getCamera().zoom = 1.0f;
                }
                //endregion
            } else if (name.equals("Faster")) {
                //region
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (SpeedMonster.INSTANCE.getSpeed() == 1) SpeedMonster.INSTANCE.setSpeed(2);
                else if (SpeedMonster.INSTANCE.getSpeed() == 2) SpeedMonster.INSTANCE.setSpeed(1);
                //endregion
            } else if (name.equals("NextWave")) {
                if (monsterArmy.isStartNewWave()) {
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    monsterArmy.wavesTotalMonster();
                    buttons.get("NextWave").setPosition(-2000, 288 * MarsGame.getRatioMonitorH());
                }
            }
        }
    }
}