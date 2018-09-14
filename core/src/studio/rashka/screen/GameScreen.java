package studio.rashka.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
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
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.Buttons;
import studio.rashka.models.Loading;
import studio.rashka.models.Stars;
import studio.rashka.models.bridge.TV;
import studio.rashka.models.hangar.ButtonsMission;
import studio.rashka.models.lightbulb.BlackLightbulb;
import studio.rashka.models.lightbulb.RedLightbulb;
import studio.rashka.models.lightbulb.YellowLightbulb;
import studio.rashka.models.robots.R_7;

public class GameScreen extends State {

    private static final int OPEN = 1, CLOSE = 0;

    private Stage stage;
    private Map<String, Label> text;
    private boolean isOpening = false, isMissionActive = false, isOffTerminal = false, isInfoStartGame = false,
            touchTurnOffTerminal = false, touchStartToMars = false, touchInfoStartGame = false;
    private int goal = CLOSE, goalW = 0, idMission = 0, page;
    private float angleMars = 0;

    private Map<String, Buttons> buttons;
    private R_7 r_7;
    private TV tv;
    private RedLightbulb redLightbulb;
    private YellowLightbulb yellowLightbulb;
    private BlackLightbulb blackLightbulb;
    private ButtonsMission buttonMission;
    private Stars stars;
    private ParticleEffect pandora;

    private static final Drawable img = Textures.getInstance().getTextureButtonSkin().getDrawable("NULL");
    private static final LabelStyle style28 = new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE);
    private static final LabelStyle style40 = new LabelStyle(FontTTF.getInstance().getFont40(), Color.BLACK);

    public GameScreen(Game game) {
        super(game);
        try {
            page = MarsGame.getPreference().loadMissionPage();
        } catch (Exception e) {
            page = 1;
        }
        redLightbulb = new RedLightbulb();
        yellowLightbulb = new YellowLightbulb();
        blackLightbulb = new BlackLightbulb();
        buttonMission = new ButtonsMission(page);
        tv = new TV();
        r_7 = new R_7();

        stage = new Stage();
        stars = new Stars();
        text = new HashMap<String, Label>();
        buttons = new HashMap<String, Buttons>();

        if (MarsGame.getPreference().getReward()) {
            pandora = new ParticleEffect();
            pandora.load(Gdx.files.internal("particles/Pandora.p"), Gdx.files.internal("particles"));
        }
        textLoading();
        if (MarsGame.getPreference().loadMissionFinish("Missions_1_1")) menuButtons();
        buttonsMission();
        buttonMission.textLoad();
        r_7.setX(-150);
        r_7.setY(96);
        r_7.setMove(1);
        stage.addActor(r_7.getClick());

        textPutGet();
        buttons();
    }

    private void textPutGet() {
        text.put("Money", new Label(String.valueOf(MarsGame.getPreference().loadMoney()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.MAGENTA)));
        text.put("Mineral", new Label(String.valueOf(MarsGame.getPreference().loadMineral()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.GREEN)));
        text.put("MissionPlay", new Label("", new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));
        text.put("MissionPage", new Label("", new LabelStyle(FontTTF.getInstance().getFont54(), Color.WHITE)));
        text.put("SizeTerritory", new Label("", style28));
        text.put("MineralTerritory", new Label("", style28));
        text.put("MonsterTerritory", new Label("", style28));
        text.put("MoneyReward", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.MAGENTA)));
        text.put("MineralReward", new Label("", new LabelStyle(FontTTF.getInstance().getFont48(), Color.GREEN)));

        text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
        text.get("Mineral").setPosition((MarsGame.WIDTH / 2 + 132) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("Money"));
        stage.addActor(text.get("Mineral"));
        stage.addActor(text.get("MissionPlay"));
        stage.addActor(text.get("MissionPage"));
        stage.addActor(text.get("SizeTerritory"));
        stage.addActor(text.get("MineralTerritory"));
        stage.addActor(text.get("MonsterTerritory"));
        stage.addActor(text.get("MoneyReward"));
        stage.addActor(text.get("MineralReward"));
    }

    private void buttons() {
        buttons.put("Home", new Buttons("Home", img, 96, 128, 40, 272 + MarsGame.getRatioAdd()));
        buttons.put("Open", new Buttons("Open", img, 96, 128, MarsGame.WIDTH / 2 - 485, 310 + MarsGame.getRatioAdd()));
        buttons.put("TurnOffTerminal", new Buttons("TurnOffTerminal", img, 60, 60, MarsGame.WIDTH - 220, 232 + MarsGame.getRatioAdd()));
        buttons.put("StartToMars", new Buttons("StartToMars", img, 90, 60, MarsGame.WIDTH - 342, 232 + MarsGame.getRatioAdd()));
        buttons.put("InfoStartGame", new Buttons("InfoStartGame", img, 60, 60, MarsGame.WIDTH - 434, 232 + MarsGame.getRatioAdd()));
        buttons.put("PreviousMissions", new Buttons("PreviousMissions", img, 90, 90, MarsGame.WIDTH / 2 - 128, 150 + MarsGame.getRatioAdd()));
        buttons.put("NextMissions", new Buttons("NextMissions", img, 90, 90, MarsGame.WIDTH / 2 + 38, 150 + MarsGame.getRatioAdd()));
        buttons.put("Reward", new Buttons("Reward", img, 128, 128, MarsGame.WIDTH - 352, 576 + MarsGame.getRatioAdd()));
        buttons.put("GPGS_IN", new Buttons("GPGS_IN", img, 80, 120, 220, MarsGame.HEIGHT - 220));
        buttons.put("GPGS_Achievements", new Buttons("GPGS_Achievements", img, 80, 120, 140, MarsGame.HEIGHT - 220));
        buttons.put("GPGS_Leaderboards", new Buttons("GPGS_Leaderboards", img, 80, 120, 300, MarsGame.HEIGHT - 220));

        buttons.get("Home").addListener(new ButtonsInputListener(buttons.get("Home").getName()));
        buttons.get("Open").addListener(new ButtonsInputListener(buttons.get("Open").getName()));
        buttons.get("TurnOffTerminal").addListener(new ButtonsInputListener(buttons.get("TurnOffTerminal").getName()));
        buttons.get("StartToMars").addListener(new ButtonsInputListener(buttons.get("StartToMars").getName()));
        buttons.get("InfoStartGame").addListener(new ButtonsInputListener(buttons.get("InfoStartGame").getName()));
        buttons.get("PreviousMissions").addListener(new ButtonsInputListener(buttons.get("PreviousMissions").getName()));
        buttons.get("NextMissions").addListener(new ButtonsInputListener(buttons.get("NextMissions").getName()));
        buttons.get("Reward").addListener(new ButtonsInputListener(buttons.get("Reward").getName()));
        buttons.get("GPGS_IN").addListener(new ButtonsInputListener(buttons.get("GPGS_IN").getName()));
        buttons.get("GPGS_Achievements").addListener(new ButtonsInputListener(buttons.get("GPGS_Achievements").getName()));
        buttons.get("GPGS_Leaderboards").addListener(new ButtonsInputListener(buttons.get("GPGS_Leaderboards").getName()));

        stage.addActor(buttons.get("Home"));
        stage.addActor(buttons.get("Open"));
        stage.addActor(buttons.get("TurnOffTerminal"));
        stage.addActor(buttons.get("StartToMars"));
        stage.addActor(buttons.get("InfoStartGame"));
        stage.addActor(buttons.get("PreviousMissions"));
        stage.addActor(buttons.get("NextMissions"));
        stage.addActor(buttons.get("Reward"));
        stage.addActor(buttons.get("GPGS_IN"));
        stage.addActor(buttons.get("GPGS_Achievements"));
        stage.addActor(buttons.get("GPGS_Leaderboards"));
        Gdx.input.setInputProcessor(stage);
    }

    private void showInfoMission() {
        if (isInfoStartGame) {
            //region 1
            if (idMission == 1) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_1_1")));
                text.get("MonsterTerritory").setText("???");
            } else if (idMission == 2) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_1_2")));
                text.get("MonsterTerritory").setText("???");
            } else if (idMission == 3) {
                text.get("SizeTerritory").setText("80x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_1_3")));
                text.get("MonsterTerritory").setText("135");
            } else if (idMission == 4) {
                text.get("SizeTerritory").setText("80x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_1_4")));
                text.get("MonsterTerritory").setText("225");
            } else if (idMission == 5) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_1_5")));
                text.get("MonsterTerritory").setText("415");
            } else if (idMission == 6) {
                text.get("SizeTerritory").setText("65x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_1_6")));
                text.get("MonsterTerritory").setText("???");
            }
            //endregion
            //region 2
            else if (idMission == 7) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_2_1")));
                text.get("MonsterTerritory").setText("375");
            } else if (idMission == 8) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_2_2")));
                text.get("MonsterTerritory").setText("530");
            } else if (idMission == 9) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_2_3")));
                text.get("MonsterTerritory").setText("???");
            } else if (idMission == 10) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_2_4")));
                text.get("MonsterTerritory").setText("???");
            } else if (idMission == 11) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_2_5")));
                text.get("MonsterTerritory").setText("650");
            } else if (idMission == 12) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_2_6")));
                text.get("MonsterTerritory").setText("???");
            }
            //endregion
            //region 3
            else if (idMission == 13) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_3_1")));
                text.get("MonsterTerritory").setText("655");
            } else if (idMission == 14) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_3_2")));
                text.get("MonsterTerritory").setText("???");
            } else if (idMission == 15) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_3_3")));
                text.get("MonsterTerritory").setText("???");
            } else if (idMission == 16) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_3_4")));
                text.get("MonsterTerritory").setText("970");
            } else if (idMission == 17) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_3_5")));
                text.get("MonsterTerritory").setText("???");
            } else if (idMission == 18) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_3_6")));
                text.get("MonsterTerritory").setText("???");
            }
            //endregion
            //region 4
            else if (idMission == 19) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_4_1")));
                text.get("MonsterTerritory").setText("1505");
            } else if (idMission == 20) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_4_2")));
                text.get("MonsterTerritory").setText("1880");
            } else if (idMission == 21) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_4_3")));
                text.get("MonsterTerritory").setText("950");
            } else if (idMission == 22) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_4_4")));
                text.get("MonsterTerritory").setText("725+");
            } else if (idMission == 23) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_4_5")));
                text.get("MonsterTerritory").setText("425+");
            } else if (idMission == 24) {
                text.get("SizeTerritory").setText("60x40");
                text.get("MineralTerritory").setText(String.valueOf(MarsGame.getPreference().getCrystal("Missions_4_6")));
                text.get("MonsterTerritory").setText("???");
            }
            //endregion
        }

        text.get("SizeTerritory").setPosition((MarsGame.WIDTH - 492) * MarsGame.getRatioMonitorW(), (335 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("MineralTerritory").setPosition((MarsGame.WIDTH - 320) * MarsGame.getRatioMonitorW(), (335 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("MonsterTerritory").setPosition((MarsGame.WIDTH - 160) * MarsGame.getRatioMonitorW(), (335 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
    }

    private void textLoading() {
        text.put("Menu", new Label(MarsGame.getLanguage().textScreen.get("Menu"), style28));
        text.put("Missions", new Label(MarsGame.getLanguage().textScreen.get("Missions"), style28));
        text.put("OnOff", new Label(MarsGame.getLanguage().textScreen.get("OnOff"), style28));
        text.put("Details", new Label(MarsGame.getLanguage().textScreen.get("Details"), style28));
        text.put("Start", new Label(MarsGame.getLanguage().textScreen.get("Start"), style28));

        text.get("Menu").setPosition(142 * MarsGame.getRatioMonitorW(), (436 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Missions").setPosition((MarsGame.WIDTH / 2 - 495) * MarsGame.getRatioMonitorW() - text.get("Missions").getPrefWidth(), (460 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("OnOff").setPosition((MarsGame.WIDTH - 140) * MarsGame.getRatioMonitorW(), (203 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Details").setPosition((MarsGame.WIDTH + 355) * MarsGame.getRatioMonitorW(), (203 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Start").setPosition((MarsGame.WIDTH + 355) * MarsGame.getRatioMonitorW(), (182 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        if (MarsGame.getPreference().loadMissionFinish("Missions_1_1")) menuButtonsText();
        else {
            text.put("MenuButtonsText", new Label(MarsGame.getLanguage().textScreen.get("MenuButtonsText"), style28));
            text.get("MenuButtonsText").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("MenuButtonsText").getPrefWidth() / 2, (64 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            stage.addActor(text.get("MenuButtonsText"));
        }

        stage.addActor(text.get("Menu"));
        stage.addActor(text.get("Missions"));
        stage.addActor(text.get("OnOff"));
        stage.addActor(text.get("Details"));
        stage.addActor(text.get("Start"));
    }

    private void doors(float deltaTime) {
        if (isOpening) {
            if (goal == OPEN) {
                goalW += deltaTime * 200;
                if (goalW >= 350) {
                    isOpening = false;
                    goalW = 350;
                }
            } else if (goal == CLOSE) {
                goalW -= deltaTime * 170;
                if (goalW <= 0) {
                    isOpening = false;
                    goalW = 0;
                }
            }
        }
    }

    private void menuButtonsText() {
        text.put("Hangar", new Label(MarsGame.getLanguage().textScreen.get("Hangar"), style40));
        text.put("Bridge", new Label(MarsGame.getLanguage().textScreen.get("Bridge"), style40));
        text.put("Arsenal", new Label(MarsGame.getLanguage().textScreen.get("Arsenal"), style40));
        text.put("Laboratory", new Label(MarsGame.getLanguage().textScreen.get("Laboratory"), style40));
        text.put("Reactor", new Label(MarsGame.getLanguage().textScreen.get("Reactor"), style40));

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
        buttons.put("Bridge", new Buttons("Bridge", img, text.get("Bridge").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Bridge").getX() / MarsGame.getRatioMonitorW(), 68));
        buttons.put("Arsenal", new Buttons("Arsenal", img, text.get("Arsenal").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Arsenal").getX() / MarsGame.getRatioMonitorW(), 68));
        buttons.put("Laboratory", new Buttons("Laboratory", img, text.get("Laboratory").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Laboratory").getX() / MarsGame.getRatioMonitorW(), 68));
        buttons.put("Reactor", new Buttons("Reactor", img, text.get("Reactor").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Reactor").getX() / MarsGame.getRatioMonitorW(), 68));

        buttons.get("Bridge").addListener(new ButtonsInputListener(buttons.get("Bridge").getName()));
        buttons.get("Arsenal").addListener(new ButtonsInputListener(buttons.get("Arsenal").getName()));
        buttons.get("Laboratory").addListener(new ButtonsInputListener(buttons.get("Laboratory").getName()));
        buttons.get("Reactor").addListener(new ButtonsInputListener(buttons.get("Reactor").getName()));

        stage.addActor(buttons.get("Bridge"));
        stage.addActor(buttons.get("Arsenal"));
        stage.addActor(buttons.get("Laboratory"));
        stage.addActor(buttons.get("Reactor"));
    }

    private void menuButtonsRender(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonFon"), text.get("Hangar").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Hangar").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonL"), text.get("Hangar").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonR"), (text.get("Hangar").getX() + text.get("Hangar").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);
        batch.draw(Textures.getInstance().textureRegion.get("MenuHere"), (text.get("Hangar").getX() + text.get("Hangar").getPrefWidth() / 2) / MarsGame.getRatioMonitorW() - 6, 115, 12, 12);

        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonFon"), text.get("Bridge").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Bridge").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonL"), text.get("Bridge").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonR"), (text.get("Bridge").getX() + text.get("Bridge").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);

        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonFon"), text.get("Arsenal").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Arsenal").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonL"), text.get("Arsenal").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonR"), (text.get("Arsenal").getX() + text.get("Arsenal").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);

        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonFon"), text.get("Laboratory").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Laboratory").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonL"), text.get("Laboratory").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonR"), (text.get("Laboratory").getX() + text.get("Laboratory").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);

        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonFon"), text.get("Reactor").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Reactor").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonL"), text.get("Reactor").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(Textures.getInstance().textureRegion.get("MenuButtonR"), (text.get("Reactor").getX() + text.get("Reactor").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);
    }

    private void setMission(int mission, int page, int buttons) {
        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
        isMissionActive = true;
        if (buttons == 1) buttonMission.getText("Mission-1").setColor(Color.GREEN);
        else buttonMission.getText("Mission-1").setColor(Color.WHITE);
        if (buttons == 2) buttonMission.getText("Mission-2").setColor(Color.GREEN);
        else buttonMission.getText("Mission-2").setColor(Color.WHITE);
        if (buttons == 3) buttonMission.getText("Mission-3").setColor(Color.GREEN);
        else buttonMission.getText("Mission-3").setColor(Color.WHITE);
        if (buttons == 4) buttonMission.getText("Mission-4").setColor(Color.GREEN);
        else buttonMission.getText("Mission-4").setColor(Color.WHITE);
        if (buttons == 5) buttonMission.getText("Mission-5").setColor(Color.GREEN);
        else buttonMission.getText("Mission-5").setColor(Color.WHITE);
        if (buttons == 6) buttonMission.getText("Mission-6").setColor(Color.GREEN);
        else buttonMission.getText("Mission-6").setColor(Color.WHITE);
        idMission = mission + 6 * (page - 1);
        if (page == 1) {
            text.get("MissionPlay").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("MissionPlay-1")).append(idMission));
            if (isOffTerminal) text.get("MissionPlay").setPosition((MarsGame.WIDTH + 335) * MarsGame.getRatioMonitorW(), (440 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            else text.get("MissionPlay").setPosition((MarsGame.WIDTH - 335) * MarsGame.getRatioMonitorW(), (440 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        } else if (page == 2) {
            text.get("MissionPlay").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("MissionPlay-2")).append(idMission));
            if (isOffTerminal) text.get("MissionPlay").setPosition((MarsGame.WIDTH + 335) * MarsGame.getRatioMonitorW(), (440 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            else text.get("MissionPlay").setPosition((MarsGame.WIDTH - 355) * MarsGame.getRatioMonitorW(), (430 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        } else if (page == 3) {
            text.get("MissionPlay").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("MissionPlay-3")).append(idMission));
            if (isOffTerminal) text.get("MissionPlay").setPosition((MarsGame.WIDTH + 335) * MarsGame.getRatioMonitorW(), (440 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            else text.get("MissionPlay").setPosition((MarsGame.WIDTH - 375) * MarsGame.getRatioMonitorW(), (400 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        } else if (page == 4) {
            text.get("MissionPlay").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("MissionPlay-4")).append(idMission));
            if (isOffTerminal) text.get("MissionPlay").setPosition((MarsGame.WIDTH + 335) * MarsGame.getRatioMonitorW(), (440 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            else text.get("MissionPlay").setPosition((MarsGame.WIDTH - 405) * MarsGame.getRatioMonitorW(), (370 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        }
        text.get("Details").setPosition((MarsGame.WIDTH - 455) * MarsGame.getRatioMonitorW() - text.get("Details").getPrefWidth(), (203 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Start").setPosition((MarsGame.WIDTH - 298) * MarsGame.getRatioMonitorW() - text.get("Start").getPrefWidth() / 2, (182 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        showInfoMission();
    }

    private void buttonsMission() {
        buttons.put("Mission-1", new Buttons("Mission-1", img, 192, 192, 640, 480 + MarsGame.getRatioAdd()));
        buttons.put("Mission-2", new Buttons("Mission-2", img, 192, 192, 860, 480 + MarsGame.getRatioAdd()));
        buttons.put("Mission-3", new Buttons("Mission-3", img, 192, 192, 1080, 480 + MarsGame.getRatioAdd()));
        buttons.put("Mission-4", new Buttons("Mission-4", img, 192, 192, 640, 260 + MarsGame.getRatioAdd()));
        buttons.put("Mission-5", new Buttons("Mission-5", img, 192, 192, 860, 260 + MarsGame.getRatioAdd()));
        buttons.put("Mission-6", new Buttons("Mission-6", img, 192, 192, 1080, 260 + MarsGame.getRatioAdd()));

        buttons.get("Mission-1").addListener(new ButtonsInputListener(buttons.get("Mission-1").getName()));
        buttons.get("Mission-2").addListener(new ButtonsInputListener(buttons.get("Mission-2").getName()));
        buttons.get("Mission-3").addListener(new ButtonsInputListener(buttons.get("Mission-3").getName()));
        buttons.get("Mission-4").addListener(new ButtonsInputListener(buttons.get("Mission-4").getName()));
        buttons.get("Mission-5").addListener(new ButtonsInputListener(buttons.get("Mission-5").getName()));
        buttons.get("Mission-6").addListener(new ButtonsInputListener(buttons.get("Mission-6").getName()));

        stage.addActor(buttons.get("Mission-1"));
        stage.addActor(buttons.get("Mission-2"));
        stage.addActor(buttons.get("Mission-3"));
        stage.addActor(buttons.get("Mission-4"));
        stage.addActor(buttons.get("Mission-5"));
        stage.addActor(buttons.get("Mission-6"));
    }

    @Override
    public void update(float deltaTime) {
        blackLightbulb.update(deltaTime);
        redLightbulb.update(deltaTime);
        yellowLightbulb.update(deltaTime);
        if (goalW > 0) buttonMission.updateButtonMission(deltaTime);
        tv.update(deltaTime);
        r_7.update(deltaTime);
        doors(deltaTime);
        stars.update();
        angleMars -= deltaTime * 2;
        if (MarsGame.getPreference().getReward()) pandora.update(deltaTime);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        stars.render(batch);
        batch.draw(Textures.getInstance().textureRegion.get("Mars"), MarsGame.WIDTH / 2 - 150, 340 + MarsGame.getRatioAdd(), 192, 192, 384, 384, 1, 1, angleMars);
        if (goalW > 0) buttonMission.renderButtonMission(batch);
        batch.end();

        if (goalW > 0) {
            buttonMission.getStageMissions().act();
            buttonMission.getStageMissions().draw();
        }

        batch.begin();
        batch.draw(Textures.getInstance().textureRegion.get("Goal_l"), MarsGame.WIDTH / 2 - 429 - goalW, 224 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("Goal_r"), MarsGame.WIDTH / 2 - 23 + goalW, 224 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("Fon"), 0, 0 + MarsGame.getRatioAdd());
        yellowLightbulb.render(batch, 200, 292 + MarsGame.getRatioAdd(), 180, 16);
        yellowLightbulb.render(batch, 200, 694 + MarsGame.getRatioAdd(), 180, 16);
        yellowLightbulb.render(batch, MarsGame.WIDTH - 385, 292 + MarsGame.getRatioAdd(), 180, 16);
        yellowLightbulb.render(batch, MarsGame.WIDTH - 385, 694 + MarsGame.getRatioAdd(), 180, 16);
        batch.draw(Textures.getInstance().textureRegion.get("Home"), 32, 160 + MarsGame.getRatioAdd(), 96, 256);
        batch.draw(Textures.getInstance().textureRegion.get("Terminal"), MarsGame.WIDTH - 585, 160 + MarsGame.getRatioAdd());
        if (!isOffTerminal)
            batch.draw(Textures.getInstance().textureRegion.get("Territory"), MarsGame.WIDTH - 527, 320 + MarsGame.getRatioAdd(), 448, 192);
        if (goalW == 350) {
            if (text.get("MissionPage").getText().toString().equals("")) {
                text.get("MissionPage").setText(String.valueOf(page));
                text.get("MissionPage").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("MissionPage").getPrefWidth() / 2, (195 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
            }
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonNext"), MarsGame.WIDTH / 2 - 64, 160 + MarsGame.getRatioAdd(), -64, 64);
            batch.draw(Textures.getInstance().textureRegionScreen.get("ButtonNext"), MarsGame.WIDTH / 2 + 64, 160 + MarsGame.getRatioAdd());
            if (!isOffTerminal) {
                if (page == 1) blackLightbulb.render(batch, MarsGame.WIDTH - 400, 475 + MarsGame.getRatioAdd(), 10, 10);
                else if (page == 2) blackLightbulb.render(batch, MarsGame.WIDTH - 420, 465 + MarsGame.getRatioAdd(), 10, 10);
                else if (page == 3) blackLightbulb.render(batch, MarsGame.WIDTH - 440, 435 + MarsGame.getRatioAdd(), 10, 10);
                else if (page == 4) blackLightbulb.render(batch, MarsGame.WIDTH - 470, 405 + MarsGame.getRatioAdd(), 10, 10);
            }
            if (isMissionActive) {
                if (!isOffTerminal) {
                    if (page == 1) batch.draw(Textures.getInstance().textureRegion.get("DownRight"), MarsGame.WIDTH - 404, 420 + MarsGame.getRatioAdd());
                    else if (page == 2) batch.draw(Textures.getInstance().textureRegion.get("DownRight"), MarsGame.WIDTH - 424, 410 + MarsGame.getRatioAdd());
                    else if (page == 3) batch.draw(Textures.getInstance().textureRegion.get("DownRight"), MarsGame.WIDTH - 444, 380 + MarsGame.getRatioAdd());
                    else if (page == 4) batch.draw(Textures.getInstance().textureRegion.get("DownRight"), MarsGame.WIDTH - 474, 350 + MarsGame.getRatioAdd());
                }
                if (!touchStartToMars) batch.draw(Textures.getInstance().textureRegion.get("StartToMars"), MarsGame.WIDTH - 342, 232 + MarsGame.getRatioAdd(), 90, 60);
                else batch.draw(Textures.getInstance().textureRegion.get("StartToMars"), MarsGame.WIDTH - 339, 234 + MarsGame.getRatioAdd(), 84, 56);
                if (!touchInfoStartGame) batch.draw(Textures.getInstance().textureRegion.get("InfoStartGame"), MarsGame.WIDTH - 434, 232 + MarsGame.getRatioAdd(), 60, 60);
                else batch.draw(Textures.getInstance().textureRegion.get("InfoStartGame"), MarsGame.WIDTH - 431, 235 + MarsGame.getRatioAdd(), 54, 54);
                batch.draw(Textures.getInstance().textureRegion.get("DownLeft"), MarsGame.WIDTH - 455, 200 + MarsGame.getRatioAdd());
                batch.draw(Textures.getInstance().textureRegion.get("Down"), MarsGame.WIDTH - 325, 200 + MarsGame.getRatioAdd());
            }
        }
        if (!isOffTerminal) {
            if (idMission != 0) {
                if (isInfoStartGame) {
                    batch.draw(Textures.getInstance().textureRegion.get("SizeTerritory"), MarsGame.WIDTH - 540, 320 + MarsGame.getRatioAdd(), 32, 32);
                    batch.draw(Textures.getInstance().textureRegion.get("Mineral"), MarsGame.WIDTH - 368, 320 + MarsGame.getRatioAdd(), 32, 32);
                    batch.draw(Textures.getInstance().textureRegion.get("MonsterTerritory"), MarsGame.WIDTH - 208, 320 + MarsGame.getRatioAdd(), 32, 32);
                }
            }
        }
        if (!touchTurnOffTerminal) batch.draw(Textures.getInstance().textureRegion.get("TurnOff"), MarsGame.WIDTH - 220, 232 + MarsGame.getRatioAdd(), 60, 60);
        else batch.draw(Textures.getInstance().textureRegion.get("TurnOff"), MarsGame.WIDTH - 217, 235 + MarsGame.getRatioAdd(), 54, 54);
        batch.draw(Textures.getInstance().textureRegion.get("DownRight"), MarsGame.WIDTH - 200, 200 + MarsGame.getRatioAdd());

        if (isOpening) batch.draw(Textures.getInstance().textureRegion.get("HandOFF"), MarsGame.WIDTH / 2 - 495, 185 + MarsGame.getRatioAdd(), 96, 256);
        else batch.draw(Textures.getInstance().textureRegion.get("HandON"), MarsGame.WIDTH / 2 - 495, 185 + MarsGame.getRatioAdd(), 96, 256);

        batch.draw(Textures.getInstance().textureRegion.get("UpRight"), 80, 400 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("UpLeft"), MarsGame.WIDTH / 2 - 495, 425 + MarsGame.getRatioAdd());

        redLightbulb.render(batch, 553, 564 + MarsGame.getRatioAdd(), 16, 16);
        if (goalW > 0) {
            redLightbulb.render(batch, 553, 588 + MarsGame.getRatioAdd(), 16, 16);
            redLightbulb.render(batch, 553, 612 + MarsGame.getRatioAdd(), 16, 16);
        }

        if (MarsGame.getPreference().getReward()) {
            pandora.draw(batch);
            pandora.setPosition(MarsGame.WIDTH - 288, 648 + MarsGame.getRatioAdd());
            batch.draw(Textures.getInstance().textureRegion.get("Pandora"), MarsGame.WIDTH - 352, 576 + MarsGame.getRatioAdd());
        }
        batch.draw(Textures.getInstance().textureRegion.get("FrameTop"), 0, MarsGame.HEIGHT - 256);
        if (MarsGame.getRatioAdd() > 120) batch.draw(Textures.getInstance().textureRegion.get("FrameBottom"), 0, 1 + MarsGame.getRatioAdd(), 1920, -64);
        batch.draw(Textures.getInstance().textureRegion.get("FrameBottom"), 0, 0 + MarsGame.getRatioAdd());
        batch.draw(Textures.getInstance().textureRegion.get("Money"), MarsGame.WIDTH / 2 - 116, MarsGame.HEIGHT - 110, 45, 45);
        batch.draw(Textures.getInstance().textureRegion.get("Mineral"), MarsGame.WIDTH / 2 + 70, MarsGame.HEIGHT - 114, 50, 50);

        if (MarsGame.playServices.getSignedInGPGS()) {
            batch.draw(Textures.getInstance().textureRegion.get("GPGS_Achievements"), 140, MarsGame.HEIGHT - 220, 80, 120);
            batch.draw(Textures.getInstance().textureRegion.get("GPGS_Leaderboards"), 300, MarsGame.HEIGHT - 220, 80, 120);
        } else {
            batch.draw(Textures.getInstance().textureRegion.get("GPGS_IN"), 220, MarsGame.HEIGHT - 220, 80, 120);
        }
        batch.end();

        r_7.render(batch);

        if (MarsGame.getPreference().loadMissionFinish("Missions_1_1")) {
            batch.begin();
            menuButtonsRender(batch);
            batch.end();
        }

        stage.act();
        stage.draw();

        if (!isOffTerminal) {
            batch.begin();
            tv.render(batch, MarsGame.WIDTH - 557, 420 + MarsGame.getRatioAdd(), 257, 112, 0);
            tv.render(batch, MarsGame.WIDTH - 557, 308 + MarsGame.getRatioAdd(), 257, 112, 0);
            tv.render(batch, MarsGame.WIDTH - 300, 420 + MarsGame.getRatioAdd(), 257, 112, 0);
            tv.render(batch, MarsGame.WIDTH - 300, 308 + MarsGame.getRatioAdd(), 257, 112, 0);
            batch.end();
        }
    }

    @Override
    public void dispose() {
        try {
            MarsGame.getMusicSound().sounds.get("DoorOpen").stop();
            MarsGame.getMusicSound().sounds.get("DoorClose").stop();
            stage.dispose();
            text.clear();
            buttons.clear();
            buttonMission.dispose();
            stars.dispose();
            blackLightbulb.dispose();
            redLightbulb.dispose();
            yellowLightbulb.dispose();
            r_7.dispose();
            tv.dispose();
            if (MarsGame.getPreference().getReward()) pandora.dispose();
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
            if (name.equals("TurnOffTerminal")) touchTurnOffTerminal = true;
            else if (name.equals("StartToMars")) {
                if (goalW == 350 && idMission != 0) touchStartToMars = true;
            } else if (name.equals("InfoStartGame")) {
                if (goalW == 350 && idMission != 0 && !isOffTerminal) touchInfoStartGame = true;
            }
            return true;
        }

        @Override
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            if (name.equals("Home")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Menu"));
            } else if (name.equals("Open")) {
                //region
                if (!isOpening) {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    if (goal == CLOSE) {
                        goal = OPEN;
                        isOpening = true;
                        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("DoorOpen").play();
                        text.get("MissionPage").setText("");
                    } else if (goal == OPEN) {
                        goal = CLOSE;
                        isOpening = true;
                        isMissionActive = false;
                        idMission = 0;
                        isInfoStartGame = false;
                        text.get("MissionPlay").setText("");
                        text.get("MissionPage").setText("");
                        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("DoorClose").play();
                        buttonMission.getText("Mission-1").setColor(Color.WHITE);
                        buttonMission.getText("Mission-2").setColor(Color.WHITE);
                        buttonMission.getText("Mission-3").setColor(Color.WHITE);
                        buttonMission.getText("Mission-4").setColor(Color.WHITE);
                        buttonMission.getText("Mission-5").setColor(Color.WHITE);
                        buttonMission.getText("Mission-6").setColor(Color.WHITE);
                        text.get("SizeTerritory").setText("");
                        text.get("MineralTerritory").setText("");
                        text.get("MonsterTerritory").setText("");
                        text.get("Details").setPosition((MarsGame.WIDTH + 355) * MarsGame.getRatioMonitorW(), (203 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("Start").setPosition((MarsGame.WIDTH + 355) * MarsGame.getRatioMonitorW(), (182 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    }
                } else {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                }
                //endregion
            } else if (name.equals("TurnOffTerminal")) {
                //region
                touchTurnOffTerminal = false;
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                if (isOffTerminal) {
                    isOffTerminal = false;
                    text.get("MissionPlay").setPosition((MarsGame.WIDTH - 335) * MarsGame.getRatioMonitorW(), (440 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("SizeTerritory").setPosition((MarsGame.WIDTH - 492) * MarsGame.getRatioMonitorW(), (335 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("MineralTerritory").setPosition((MarsGame.WIDTH - 320) * MarsGame.getRatioMonitorW(), (335 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("MonsterTerritory").setPosition((MarsGame.WIDTH - 160) * MarsGame.getRatioMonitorW(), (335 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                } else {
                    isOffTerminal = true;
                    text.get("MissionPlay").setPosition((MarsGame.WIDTH + 335) * MarsGame.getRatioMonitorW(), (440 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("SizeTerritory").setPosition((MarsGame.WIDTH + 335) * MarsGame.getRatioMonitorW(), (320 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("MineralTerritory").setPosition((MarsGame.WIDTH + 335) * MarsGame.getRatioMonitorW(), (320 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("MonsterTerritory").setPosition((MarsGame.WIDTH + 335) * MarsGame.getRatioMonitorW(), (320 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                }
                //endregion
            } else if (name.equals("StartToMars")) {
                //region
                if (goalW == 350 && idMission != 0) {
                        touchStartToMars = false;
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    if (idMission == 1) game.set(new Loading(game, "Missions_1_1"));
                    else if (idMission == 2) game.set(new Loading(game, "Missions_1_2"));
                    else if (idMission == 3) game.set(new Loading(game, "Missions_1_3"));
                    else if (idMission == 4) game.set(new Loading(game, "Missions_1_4"));
                    else if (idMission == 5) game.set(new Loading(game, "Missions_1_5"));
                    else if (idMission == 6) game.set(new Loading(game, "Missions_1_6"));
                    else if (idMission == 7) game.set(new Loading(game, "Missions_2_1"));
                    else if (idMission == 8) game.set(new Loading(game, "Missions_2_2"));
                    else if (idMission == 9) game.set(new Loading(game, "Missions_2_3"));
                    else if (idMission == 10) game.set(new Loading(game, "Missions_2_4"));
                    else if (idMission == 11) game.set(new Loading(game, "Missions_2_5"));
                    else if (idMission == 12) game.set(new Loading(game, "Missions_2_6"));
                    else if (idMission == 13) game.set(new Loading(game, "Missions_3_1"));
                    else if (idMission == 14) game.set(new Loading(game, "Missions_3_2"));
                    else if (idMission == 15) game.set(new Loading(game, "Missions_3_3"));
                    else if (idMission == 16) game.set(new Loading(game, "Missions_3_4"));
                    else if (idMission == 17) game.set(new Loading(game, "Missions_3_5"));
                    else if (idMission == 18) game.set(new Loading(game, "Missions_3_6"));
                    else if (idMission == 19) game.set(new Loading(game, "Missions_4_1"));
                    else if (idMission == 20) game.set(new Loading(game, "Missions_4_2"));
                    else if (idMission == 21) game.set(new Loading(game, "Missions_4_3"));
                    else if (idMission == 22) game.set(new Loading(game, "Missions_4_4"));
                    else if (idMission == 23) game.set(new Loading(game, "Missions_4_5"));
                    else if (idMission == 24) game.set(new Loading(game, "Missions_4_6"));
                }
                //endregion
            } else if (name.equals("InfoStartGame")) {
                //region
                if (goalW == 350 && idMission != 0 && !isOffTerminal) {
                        touchInfoStartGame = false;
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    if (isInfoStartGame) {
                        isInfoStartGame = false;
                        text.get("SizeTerritory").setText("");
                        text.get("MineralTerritory").setText("");
                        text.get("MonsterTerritory").setText("");
                    } else {
                        isInfoStartGame = true;
                        showInfoMission();
                    }
                }
                //endregion
            } else if (name.equals("PreviousMissions")) {
                //region
                if (goalW == 350) {
                    if (page >= 2) {
                        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        page--;
                        try {
                            MarsGame.getPreference().saveMissionPage(page);
                        } catch (Exception e) {
                            MarsGame.getPreference().saveMissionPage(1);
                        }
                        buttonMission.setPage(page);
                        buttonMission.textLoad();
                        idMission = 0;
                        isMissionActive = false;
                        isInfoStartGame = false;
                        buttonMission.getText("Mission-1").setColor(Color.WHITE);
                        buttonMission.getText("Mission-2").setColor(Color.WHITE);
                        buttonMission.getText("Mission-3").setColor(Color.WHITE);
                        buttonMission.getText("Mission-4").setColor(Color.WHITE);
                        buttonMission.getText("Mission-5").setColor(Color.WHITE);
                        buttonMission.getText("Mission-6").setColor(Color.WHITE);
                        text.get("MissionPlay").setText("");
                        text.get("SizeTerritory").setText("");
                        text.get("MineralTerritory").setText("");
                        text.get("MonsterTerritory").setText("");
                        text.get("MissionPage").setText(String.valueOf(page));
                        text.get("MissionPage").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("MissionPage").getPrefWidth() / 2, (195 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("Details").setPosition((MarsGame.WIDTH + 355) * MarsGame.getRatioMonitorW(), (203 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("Start").setPosition((MarsGame.WIDTH + 355) * MarsGame.getRatioMonitorW(), (182 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    }  else {
                        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("NextMissions")) {
                //region
                if (goalW == 350) {
                    if (page < 4) {
                        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        page++;
                        try {
                            MarsGame.getPreference().saveMissionPage(page);
                        } catch (Exception e) {
                            MarsGame.getPreference().saveMissionPage(1);
                        }
                        buttonMission.setPage(page);
                        buttonMission.textLoad();
                        idMission = 0;
                        isMissionActive = false;
                        isInfoStartGame = false;
                        buttonMission.getText("Mission-1").setColor(Color.WHITE);
                        buttonMission.getText("Mission-2").setColor(Color.WHITE);
                        buttonMission.getText("Mission-3").setColor(Color.WHITE);
                        buttonMission.getText("Mission-4").setColor(Color.WHITE);
                        buttonMission.getText("Mission-5").setColor(Color.WHITE);
                        buttonMission.getText("Mission-6").setColor(Color.WHITE);
                        text.get("MissionPlay").setText("");
                        text.get("SizeTerritory").setText("");
                        text.get("MineralTerritory").setText("");
                        text.get("MonsterTerritory").setText("");
                        text.get("MissionPage").setText(String.valueOf(page));
                        text.get("MissionPage").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("MissionPage").getPrefWidth() / 2, (195 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("Details").setPosition((MarsGame.WIDTH + 355) * MarsGame.getRatioMonitorW(), (203 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("Start").setPosition((MarsGame.WIDTH + 355) * MarsGame.getRatioMonitorW(), (182 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    } else if (page == 4) {
                        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                        page++;
                        try {
                            MarsGame.getPreference().saveMissionPage(page);
                        } catch (Exception e) {
                            MarsGame.getPreference().saveMissionPage(1);
                        }
                        buttonMission.setPage(page);
                        buttonMission.textLoad();
                        idMission = 0;
                        isMissionActive = false;
                        isInfoStartGame = false;
                        buttonMission.getText("Mission-1").setColor(Color.WHITE);
                        buttonMission.getText("Mission-2").setColor(Color.WHITE);
                        buttonMission.getText("Mission-3").setColor(Color.WHITE);
                        buttonMission.getText("Mission-4").setColor(Color.WHITE);
                        buttonMission.getText("Mission-5").setColor(Color.WHITE);
                        buttonMission.getText("Mission-6").setColor(Color.WHITE);
                        text.get("MissionPlay").setText("");
                        text.get("SizeTerritory").setText("");
                        text.get("MineralTerritory").setText("");
                        text.get("MonsterTerritory").setText("");
                        text.get("MissionPage").setText(String.valueOf(page));
                        text.get("MissionPage").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("MissionPage").getPrefWidth() / 2, (195 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("Details").setPosition((MarsGame.WIDTH + 355) * MarsGame.getRatioMonitorW(), (203 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("Start").setPosition((MarsGame.WIDTH + 355) * MarsGame.getRatioMonitorW(), (182 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    } else {
                        if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                    }
                }
                //endregion
            } else if (name.equals("Reward")) {
                //region
                if (MarsGame.getPreference().getReward()) {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    int money = 250 + 185 * MarsGame.getPreference().getRewardBonus();
                    int mineral = 10 + 7 * MarsGame.getPreference().getRewardBonus();
                    MarsGame.getPreference().setReward(false);
                    MarsGame.getPreference().saveCredit(money, mineral);

                    MarsGame.getPreference().setEventEarnMoney(money);
                    MarsGame.getPreference().setAchievementMoney(MarsGame.getPreference().getEventEarnMoney());
                    MarsGame.getPreference().setRecordTop(2);

                    MarsGame.getPreference().setEventEarnMinerals(mineral);
                    MarsGame.getPreference().setAchievementMineral(MarsGame.getPreference().getEventEarnMinerals());

                    text.get("MoneyReward").setText("+" + money + " > " + (250 + 185 * (MarsGame.getPreference().getRewardBonus()+1)));
                    text.get("MineralReward").setText("+" + mineral + " > " + (10 + 7 * (MarsGame.getPreference().getRewardBonus()+1)));
                    text.get("MoneyReward").setPosition((MarsGame.WIDTH - 288) * MarsGame.getRatioMonitorW() - text.get("MoneyReward").getPrefWidth() / 2, (628 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("MineralReward").setPosition((MarsGame.WIDTH - 288) * MarsGame.getRatioMonitorW() - text.get("MineralReward").getPrefWidth() / 2, (588 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

                    text.get("Money").setText(String.valueOf(MarsGame.getPreference().loadMoney()));
                    text.get("Mineral").setText(String.valueOf(MarsGame.getPreference().loadMineral()));
                    text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
                    text.get("Mineral").setPosition((MarsGame.WIDTH / 2 + 132) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
                }
                //endregion
            } else if (name.equals("Bridge")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Bridge"));
            } else if (name.equals("Arsenal")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Arsenal"));
            } else if (name.equals("Laboratory")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Laboratory"));
            } else if (name.equals("Reactor")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Reactor"));
            } else if (name.equals("Mission-1")) {
                //region
                if (goalW == 350) {
                    if (page == 1) setMission(1, 1, 1);
                    else if (page == 2) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_1_6")) setMission(1, 2, 1);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 3) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_2_6")) setMission(1, 3, 1);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 4) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_3_6")) setMission(1, 4, 1);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
                //endregion
            } else if (name.equals("Mission-2")) {
                //region
                if (goalW == 350) {
                    if (page == 1) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_1_1")) setMission(2, 1, 2);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 2) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_2_1")) setMission(2, 2, 2);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 3) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_3_1")) setMission(2, 3, 2);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 4) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_4_1")) setMission(2, 4, 2);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
                //endregion
            } else if (name.equals("Mission-3")) {
                //region
                if (goalW == 350) {
                    if (page == 1) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_1_2")) setMission(3, 1, 3);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 2) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_2_2")) setMission(3, 2, 3);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 3) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_3_2")) setMission(3, 3, 3);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 4) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_4_2")) setMission(3, 4, 3);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
                //endregion
            } else if (name.equals("Mission-4")) {
                //region
                if (goalW == 350) {
                    if (page == 1) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_1_3")) setMission(4, 1, 4);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 2) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_2_3")) setMission(4, 2, 4);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 3) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_3_3")) setMission(4, 3, 4);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 4) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_4_3")) setMission(4, 4, 4);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
                //endregion
            } else if (name.equals("Mission-5")) {
                //region
                if (goalW == 350) {
                    if (page == 1) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_1_4")) setMission(5, 1, 5);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 2) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_2_4")) setMission(5, 2, 5);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 3) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_3_4")) setMission(5, 3, 5);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 4) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_4_4")) setMission(5, 4, 5);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
                //endregion
            } else if (name.equals("Mission-6")) {
                //region
                if (goalW == 350) {
                    if (page == 1) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_1_5")) setMission(6, 1, 6);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 2) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_2_5")) setMission(6, 2, 6);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 3) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_3_5")) setMission(6, 3, 6);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    } else if (page == 4) {
                        if (MarsGame.getPreference().loadMissionFinish("Missions_4_5")) setMission(6, 4, 6);
                        else {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
                //endregion
            } else if (name.equals("GPGS_Achievements")) {
                if (MarsGame.playServices.getSignedInGPGS()) {
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    MarsGame.playServices.getAchievementsGPGS();
                }
            } else if (name.equals("GPGS_Leaderboards")) {
                if (MarsGame.playServices.getSignedInGPGS()) {
                    if (MarsGame.getPreference().loadSound() == 1)
                        MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    MarsGame.playServices.getLeaderboardGPGS();
                }
            } else if (name.equals("GPGS_IN")) {
                if (!MarsGame.playServices.getSignedInGPGS()) {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    MarsGame.playServices.loginGPGS();
                }
            }
        }
    }
}