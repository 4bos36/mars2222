package studio.rashka.models;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.FontTTF;
import studio.rashka.lib.Game;
import studio.rashka.lib.State;
import studio.rashka.lib.Textures;
import studio.rashka.models.load.Space;
import studio.rashka.screen.AboutScreen;
import studio.rashka.screen.ArsenalScreen;
import studio.rashka.screen.ArsenalTowerScreen;
import studio.rashka.screen.BridgeScreen;
import studio.rashka.screen.GameScreen;
import studio.rashka.screen.HelpScreen;
import studio.rashka.screen.LaboratoryScreen;
import studio.rashka.screen.MenuScreen;
import studio.rashka.screen.PirateScreen;
import studio.rashka.screen.ReactorScreen;
import studio.rashka.screen.missions.Missions;

public class Loading extends State {

    private Stage stageLoading;
    private Label text, phrase;
    private String nameScreen, mission;
    private float timeStart = 0;

    private Calendar calendar;
    private SimpleDateFormat time;

    public Loading(Game game, String nameScreen) {
        super(game);
        this.nameScreen = nameScreen;
        stageLoading = new Stage();
        MarsGame.getLanguage().loadScreen();

        if (nameScreen.equals("Menu")) {
        } else if (nameScreen.equals("About")) {
        } else if (nameScreen.equals("Help")) {
        } else if (nameScreen.equals("Game")) {
            updateReward();
        } else if (nameScreen.equals("Hangar")) {
            updateReward();
            Textures.getInstance().clearBoss();
            MarsGame.getMusicSound().getLoadSoundWeapon().clear();
            MarsGame.getMusicSound().disposeSounds();
            MarsGame.getCamera().zoom = 1.0f;
            MarsGame.getCamera().position.set(MarsGame.WIDTH / 2, MarsGame.HEIGHT / 2, 0);
            MarsGame.getCamera().update();
        } else if (nameScreen.equals("Bridge")) {
        } else if (nameScreen.equals("Pirate")) {
        } else if (nameScreen.equals("Arsenal")) {
        } else if (nameScreen.equals("ArsenalTower")) {
        } else if (nameScreen.equals("Laboratory")) {
        } else if (nameScreen.equals("Reactor")) {
        } else if (nameScreen.substring(0, 8).equals("Missions")) {
            this.nameScreen = nameScreen.substring(0, 8);
            mission = nameScreen;//.substring(9);
            MarsGame.getMusicSound().loadSoundWeapon();
        } else if (nameScreen.substring(0, 6).equals("Repeat")) {
            this.nameScreen = nameScreen.substring(0, 6);
            mission = nameScreen.substring(6);
            MarsGame.getCamera().zoom = 1.0f;
            MarsGame.getCamera().position.set(MarsGame.WIDTH / 2, MarsGame.HEIGHT / 2, 0);
            MarsGame.getCamera().update();
        }
        loading();
    }

    private void loading() {
        text = new Label(MarsGame.getLanguage().textScreen.get("loading"), new LabelStyle(FontTTF.getInstance().getFont54(), Color.WHITE));
        phrase = new Label(MarsGame.getLanguage().textScreen.get(String.valueOf(new Random().nextInt(15)+1)), new LabelStyle(FontTTF.getInstance().getFont40(), Color.WHITE));
        text.setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.getPrefWidth() / 2, (MarsGame.HEIGHT + MarsGame.getRatioAdd()) / 2 * MarsGame.getRatioMonitorH());
        phrase.setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - phrase.getPrefWidth() / 2, 64 * MarsGame.getRatioMonitorH());
        stageLoading.addActor(text);
        stageLoading.addActor(phrase);
    }

    private void updateReward() {
        calendar = Calendar.getInstance();
        time = new SimpleDateFormat("D");
        if (MarsGame.getPreference().getRewardDay() == Integer.parseInt(time.format(calendar.getTime())) - 1) {
            MarsGame.getPreference().setRewardBonus(MarsGame.getPreference().getRewardBonus()+1);
            MarsGame.getPreference().setRewardDay(Integer.parseInt(time.format(calendar.getTime())));
            MarsGame.getPreference().setReward(true);
        } else if (MarsGame.getPreference().getRewardDay() == 365 && Integer.parseInt(time.format(calendar.getTime())) == 1) {
            MarsGame.getPreference().setRewardBonus(MarsGame.getPreference().getRewardBonus()+1);
            MarsGame.getPreference().setRewardDay(Integer.parseInt(time.format(calendar.getTime())));
            MarsGame.getPreference().setReward(true);
        } else if (MarsGame.getPreference().getRewardDay() == 366 && Integer.parseInt(time.format(calendar.getTime())) == 1) {
            MarsGame.getPreference().setRewardBonus(MarsGame.getPreference().getRewardBonus()+1);
            MarsGame.getPreference().setRewardDay(Integer.parseInt(time.format(calendar.getTime())));
            MarsGame.getPreference().setReward(true);
        } else if (MarsGame.getPreference().getRewardDay() == 0) {
            MarsGame.getPreference().setRewardBonus(MarsGame.getPreference().getRewardBonus()+1);
            MarsGame.getPreference().setRewardDay(Integer.parseInt(time.format(calendar.getTime())));
            MarsGame.getPreference().setReward(true);
        } else if (MarsGame.getPreference().getRewardDay() < Integer.parseInt(time.format(calendar.getTime())) - 1) {
            MarsGame.getPreference().setRewardBonus(0);
            MarsGame.getPreference().setRewardDay(Integer.parseInt(time.format(calendar.getTime())));
            MarsGame.getPreference().setReward(true);
        }
    }

    @Override
    public void update(float deltaTime) {
        if (nameScreen.equals("Missions") || nameScreen.equals("Hangar")) timeStart += 0.25f;
        else timeStart++;
        if (timeStart >= 60) {
            MarsGame.getLanguage().disposeText();
            if (nameScreen.equals("Missions") || nameScreen.equals("Repeat")) {
                if (MarsGame.getMusicSound().getLoadSoundWeapon().update()) {
                    MarsGame.getLanguage().gameEnd();
                    MarsGame.getLanguage().r7Die();
                    MarsGame.getLanguage().story(mission);
                    if (nameScreen.equals("Missions")) {
                        MarsGame.getMusicSound().clickTerminal();
                        MarsGame.getMusicSound().mission();
                        MarsGame.getMusicSound().soundWeapon();
                    }
                    if (mission.equals("Missions_1_6")) Textures.getInstance().loadBoss1();
                    else if (mission.equals("Missions_2_6")) Textures.getInstance().loadBoss2();
                    else if (mission.equals("Missions_3_6")) Textures.getInstance().loadBoss3();
                    else if (mission.equals("Missions_4_6")) Textures.getInstance().loadBoss4();
                    game.set(new Missions(game, mission));
                }
            } else if (nameScreen.equals("Hangar")) {
                MarsGame.getLanguage().gameScreen();
                MarsGame.getLanguage().menu();
                MarsGame.getLanguage().r7Message();
                MarsGame.getMusicSound().clickTerminal();
                MarsGame.getMusicSound().doors();
                game.set(new GameScreen(game));
            } else if (nameScreen.equals("Menu")) {
                MarsGame.getMusicSound().click();
                game.set(new MenuScreen(game));
            } else if (nameScreen.equals("About")) {
                MarsGame.getLanguage().aboutScreen();
                MarsGame.getLanguage().r7Message();
                MarsGame.getMusicSound().clickTerminal();
                game.set(new AboutScreen(game));
            } else if (nameScreen.equals("Help")) {
                MarsGame.getLanguage().helpScreen();
                MarsGame.getLanguage().r7Message();
                MarsGame.getMusicSound().clickTerminal();
                game.set(new HelpScreen(game));
            } else if (nameScreen.equals("Game")) {
                MarsGame.getLanguage().gameScreen();
                MarsGame.getLanguage().menu();
                MarsGame.getLanguage().r7Message();
                MarsGame.getMusicSound().clickTerminal();
                MarsGame.getMusicSound().doors();
                game.set(new GameScreen(game));
            } else if (nameScreen.equals("Bridge")) {
                MarsGame.getLanguage().bridgeScreen();
                MarsGame.getLanguage().menu();
                MarsGame.getLanguage().r7Message();
                MarsGame.getMusicSound().clickTerminal();
                game.set(new BridgeScreen(game));
            } else if (nameScreen.equals("Pirate")) {
                MarsGame.getMusicSound().clickTerminal();
                game.set(new PirateScreen(game));
            } else if (nameScreen.equals("Arsenal")) {
                MarsGame.getLanguage().arsenalScreen();
                MarsGame.getLanguage().menu();
                MarsGame.getLanguage().r7Message();
                MarsGame.getMusicSound().clickTerminal();
                game.set(new ArsenalScreen(game));
            } else if (nameScreen.equals("ArsenalTower")) {
                MarsGame.getLanguage().arsenalScreen();
                MarsGame.getLanguage().menu();
                MarsGame.getLanguage().r7Message();
                MarsGame.getMusicSound().clickTerminal();
                game.set(new ArsenalTowerScreen(game));
            } else if (nameScreen.equals("Laboratory")) {
                MarsGame.getLanguage().laboratoryScreen();
                MarsGame.getLanguage().menu();
                MarsGame.getLanguage().r7Message();
                MarsGame.getMusicSound().clickTerminal();
                MarsGame.getMusicSound().laboratory();
                game.set(new LaboratoryScreen(game));
            } else if (nameScreen.equals("Reactor")) {
                MarsGame.getLanguage().reactorScreen();
                MarsGame.getLanguage().menu();
                MarsGame.getLanguage().r7Message();
                MarsGame.getMusicSound().reactor();
                MarsGame.getMusicSound().clickTerminal();
                game.set(new ReactorScreen(game));
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        Space.getInstance().render(batch);
        stageLoading.act();
        stageLoading.draw();
    }

    @Override
    public void dispose() {
        try {
            stageLoading.dispose();
            text.clear();
            phrase.clear();
            if (nameScreen.equals("Game") || nameScreen.equals("Hangar")) calendar.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}