package studio.rashka.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
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
import studio.rashka.models.reactor.CaseReactor;
import studio.rashka.models.reactor.Energy;

public class ReactorScreen extends State {

    private static final int HIDE = 0, SHOW = 1;
    private static final int NONE = 0, HP = 1, MP = 2, SPEED = 3;
    private int showMonitor = HIDE, showBuy = NONE;

    private Stage stage;
    private Map<String, Label> text;
    private boolean isShowMonitor = false, isNotClick = false;
    private float angleShowMonitor = 0;

    private Map<String, Buttons> buttons;
    private Energy energy;
    private CaseReactor caseReactor;
    private Stars stars;
    private ParticleEffect core;

    private static final Drawable img = MarsGame.getTextures().getTextureButtonSkin().getDrawable("NULL");
    private static final LabelStyle style28 = new LabelStyle(FontTTF.getInstance().getFont28(), Color.WHITE);

    public ReactorScreen(Game game) {
        super(game);
        energy = new Energy();
        caseReactor = new CaseReactor();
        stars = new Stars();

        stage = new Stage();
        text = new HashMap<String, Label>();
        buttons = new HashMap<String, Buttons>();

        core = new ParticleEffect();
        core.load(Gdx.files.internal("reactor/core.p"), Gdx.files.internal("particles"));
        core.setPosition(MarsGame.WIDTH / 2 - 5, 492 + MarsGame.getRatioAdd());
        core.start();

        textLoading();
        textPutGet();
        menuButtons();
        buttonsTerminalClick();
        Gdx.input.setInputProcessor(stage);
    }

    private void textPutGet() {
        text.put("Money", new Label(String.valueOf(MarsGame.getPreference().loadMoney()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.MAGENTA)));
        text.put("Mineral", new Label(String.valueOf(MarsGame.getPreference().loadMineral()), new LabelStyle(FontTTF.getInstance().getFont48(), Color.GREEN)));
        text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
        text.get("Mineral").setPosition((MarsGame.WIDTH / 2 + 132) * MarsGame.getRatioMonitorW(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("Money"));
        stage.addActor(text.get("Mineral"));

        text.put("HPup", new Label("", style28));
        text.put("CurrentHP", new Label("", style28));
        text.put("NextHP", new Label("", style28));
        text.put("PriceHP", new Label("", style28));
        text.put("BuyHP", new Label("", style28));

        text.put("MPup", new Label("", style28));
        text.put("CurrentMP", new Label("", style28));
        text.put("NextMP", new Label("", style28));
        text.put("PriceMP", new Label("", style28));
        text.put("BuyMP", new Label("",style28));

        text.get("HPup").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("CurrentHP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("NextHP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("PriceHP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("BuyHP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("MPup").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("CurrentMP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("NextMP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("PriceMP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
        text.get("BuyMP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
    }

    private void textLoading() {
        menuButtonsText();

        text.put("HP", new Label(MarsGame.getLanguage().textScreen.get("HP"), new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));
        text.put("MP", new Label(MarsGame.getLanguage().textScreen.get("MP"), new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));
        text.put("Reactor-34M", new Label(MarsGame.getLanguage().textScreen.get("Reactor"), new LabelStyle(FontTTF.getInstance().getFont35(), Color.WHITE)));
        text.get("HP").setPosition(255 * MarsGame.getRatioMonitorW(), (166 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("MP").setPosition((MarsGame.WIDTH - 340) * MarsGame.getRatioMonitorW() - text.get("MP").getPrefWidth(), (187 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
        text.get("Reactor-34M").setPosition((MarsGame.WIDTH / 2 + 80) * MarsGame.getRatioMonitorW(), (572 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

        stage.addActor(text.get("HP"));
        stage.addActor(text.get("MP"));
        stage.addActor(text.get("Reactor-34M"));
    }

    private void buttonsTerminalClick() {
        buttons.put("HP", new Buttons("HP", img, 80, 80, 160, 200 + MarsGame.getRatioAdd()));
        buttons.put("MP", new Buttons("MP", img, 80, 80, MarsGame.WIDTH - 330, 225 + MarsGame.getRatioAdd()));
        buttons.put("Reactor-34M", new Buttons("Reactor-34M", img, 128, 128, MarsGame.WIDTH / 2 - 64, 430 + MarsGame.getRatioAdd()));
        buttons.put("HPbuy", new Buttons("HPbuy", img, 100, 100, MarsGame.WIDTH + 100, 210 + MarsGame.getRatioAdd()));
        buttons.put("HPbuySpeed", new Buttons("HPbuySpeed", img, 100, 100, MarsGame.WIDTH + 100, 210 + MarsGame.getRatioAdd()));
        buttons.put("MPbuy", new Buttons("MPbuy", img, 100, 100, MarsGame.WIDTH + 100, 210 + MarsGame.getRatioAdd()));
        buttons.put("MPbuySpeed", new Buttons("MPbuySpeed", img, 100, 100, MarsGame.WIDTH + 100, 210 + MarsGame.getRatioAdd()));
        buttons.put("Close", new Buttons("Close", img, 64, 64, MarsGame.WIDTH / 2 - 32, 715 + MarsGame.getRatioAdd()));

        buttons.get("HP").addListener(new ButtonsInputListener(buttons.get("HP").getName()));
        buttons.get("MP").addListener(new ButtonsInputListener(buttons.get("MP").getName()));
        buttons.get("Reactor-34M").addListener(new ButtonsInputListener(buttons.get("Reactor-34M").getName()));
        buttons.get("HPbuy").addListener(new ButtonsInputListener(buttons.get("HPbuy").getName()));
        buttons.get("HPbuySpeed").addListener(new ButtonsInputListener(buttons.get("HPbuySpeed").getName()));
        buttons.get("MPbuy").addListener(new ButtonsInputListener(buttons.get("MPbuy").getName()));
        buttons.get("MPbuySpeed").addListener(new ButtonsInputListener(buttons.get("MPbuySpeed").getName()));
        buttons.get("Close").addListener(new ButtonsInputListener(buttons.get("Close").getName()));

        stage.addActor(buttons.get("HP"));
        stage.addActor(buttons.get("MP"));
        stage.addActor(buttons.get("Reactor-34M"));
        stage.addActor(buttons.get("HPbuy"));
        stage.addActor(buttons.get("HPbuySpeed"));
        stage.addActor(buttons.get("MPbuy"));
        stage.addActor(buttons.get("MPbuySpeed"));
        stage.addActor(buttons.get("Close"));
        stage.addActor(text.get("HPup"));
        stage.addActor(text.get("CurrentHP"));
        stage.addActor(text.get("NextHP"));
        stage.addActor(text.get("PriceHP"));
        stage.addActor(text.get("BuyHP"));
        stage.addActor(text.get("MPup"));
        stage.addActor(text.get("CurrentMP"));
        stage.addActor(text.get("NextMP"));
        stage.addActor(text.get("PriceMP"));
        stage.addActor(text.get("BuyMP"));
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
        buttons.put("Bridge", new Buttons("Bridge", img, text.get("Bridge").getPrefWidth() / MarsGame.getRatioMonitorW(), 45, text.get("Bridge").getX() / MarsGame.getRatioMonitorW(), 68));

        buttons.get("Hangar").addListener(new ButtonsInputListener(buttons.get("Hangar").getName()));
        buttons.get("Arsenal").addListener(new ButtonsInputListener(buttons.get("Arsenal").getName()));
        buttons.get("Laboratory").addListener(new ButtonsInputListener(buttons.get("Laboratory").getName()));
        buttons.get("Bridge").addListener(new ButtonsInputListener(buttons.get("Bridge").getName()));

        stage.addActor(buttons.get("Hangar"));
        stage.addActor(buttons.get("Bridge"));
        stage.addActor(buttons.get("Arsenal"));
        stage.addActor(buttons.get("Laboratory"));
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

        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("Reactor").getX() / MarsGame.getRatioMonitorW() - 6, 71, text.get("Reactor").getPrefWidth() / MarsGame.getRatioMonitorW() + 10, 39);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("Reactor").getX() / MarsGame.getRatioMonitorW() - 10, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("Reactor").getX() + text.get("Reactor").getPrefWidth()) / MarsGame.getRatioMonitorW() - 25, 68, 34, 45);
        batch.draw(MarsGame.getTextures().textureRegion.get("MenuHere"), (text.get("Reactor").getX() + text.get("Reactor").getPrefWidth() / 2) / MarsGame.getRatioMonitorW() - 6, 115, 12, 12);
    }

    private void showMonitor(float deltaTime) {
        if (isShowMonitor) {
            if (showBuy == HP || showBuy == MP || showBuy == SPEED) {
                text.get("HP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 210 * MarsGame.getRatioMonitorH());
                text.get("MP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 210 * MarsGame.getRatioMonitorH());
                text.get("Reactor-34M").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 210 * MarsGame.getRatioMonitorH());
                angleShowMonitor += deltaTime * 200;
                if (angleShowMonitor >= 256) {
                    if (showBuy == HP) {
                        text.get("HPup").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("HPup").getPrefWidth() / 2, (550 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("CurrentHP").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("CurrentHP").getPrefWidth() / 2, (510 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("NextHP").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("NextHP").getPrefWidth() / 2, (476 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("PriceHP").setPosition((MarsGame.WIDTH / 2 + 22) * MarsGame.getRatioMonitorW() - text.get("PriceHP").getPrefWidth() / 2, (435 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("BuyHP").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("BuyHP").getPrefWidth() / 2, (390 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        buttons.get("HPbuy").setPosition(text.get("BuyHP").getX() / MarsGame.getRatioMonitorW() - 15, 355 + MarsGame.getRatioAdd());
                        buttons.get("MPbuy").setPosition(MarsGame.WIDTH + 100, 370 + MarsGame.getRatioAdd());
                    } else if (showBuy == MP) {
                        text.get("MPup").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("MPup").getPrefWidth() / 2, (550 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("CurrentMP").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("CurrentMP").getPrefWidth() / 2, (510 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("NextMP").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("NextMP").getPrefWidth() / 2, (476 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("PriceMP").setPosition((MarsGame.WIDTH / 2 + 22) * MarsGame.getRatioMonitorW() - text.get("PriceMP").getPrefWidth() / 2, (435 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("BuyMP").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("BuyMP").getPrefWidth() / 2, (390 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        buttons.get("HPbuy").setPosition(MarsGame.WIDTH + 100, 370 + MarsGame.getRatioAdd());
                        buttons.get("MPbuy").setPosition(text.get("BuyMP").getX() / MarsGame.getRatioMonitorW() - 15, 355 + MarsGame.getRatioAdd());
                    } else if (showBuy == SPEED) {
                        text.get("HPup").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("HPup").getPrefWidth() / 2, (565 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("CurrentHP").setPosition((MarsGame.WIDTH / 2 - 64) * MarsGame.getRatioMonitorW(), (670 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("NextHP").setPosition((MarsGame.WIDTH / 2 - 64) * MarsGame.getRatioMonitorW(), (640 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("PriceHP").setPosition((MarsGame.WIDTH / 2 + 22) * MarsGame.getRatioMonitorW() - text.get("PriceHP").getPrefWidth() / 2, (600 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("BuyHP").setPosition((MarsGame.WIDTH / 2 + 156) * MarsGame.getRatioMonitorW() - text.get("BuyHP").getPrefWidth() / 2, (640 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

                        text.get("MPup").setPosition(MarsGame.WIDTH / 2 * MarsGame.getRatioMonitorW() - text.get("MPup").getPrefWidth() / 2, (515 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("CurrentMP").setPosition((MarsGame.WIDTH / 2 - 64) * MarsGame.getRatioMonitorW(), (440 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("NextMP").setPosition((MarsGame.WIDTH / 2 - 64) * MarsGame.getRatioMonitorW(), (410 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("PriceMP").setPosition((MarsGame.WIDTH / 2 + 22) * MarsGame.getRatioMonitorW() - text.get("PriceMP").getPrefWidth() / 2, (480 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                        text.get("BuyMP").setPosition((MarsGame.WIDTH / 2 - 156) * MarsGame.getRatioMonitorW() - text.get("BuyMP").getPrefWidth() / 2, (432 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());

                        buttons.get("HPbuySpeed").setPosition(text.get("BuyHP").getX() / MarsGame.getRatioMonitorW() - 15, 605 + MarsGame.getRatioAdd());
                        buttons.get("MPbuySpeed").setPosition(text.get("BuyMP").getX() / MarsGame.getRatioMonitorW() - 15, 395 + MarsGame.getRatioAdd());
                    }
                    angleShowMonitor = 256;
                    isShowMonitor = true;
                    showMonitor = SHOW;
                }
            } else if (showBuy == NONE) {
                showMonitor = HIDE;
                text.get("HPup").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("CurrentHP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("NextHP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("PriceHP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("BuyHP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("MPup").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("CurrentMP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("NextMP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("PriceMP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                text.get("BuyMP").setPosition((MarsGame.WIDTH + 100) * MarsGame.getRatioMonitorW(), 540 * MarsGame.getRatioMonitorH());
                angleShowMonitor -= deltaTime * 200;
                if (angleShowMonitor <= 0) {
                    angleShowMonitor = 0;
                    isShowMonitor = false;
                    isNotClick = false;
                    text.get("HP").setPosition(255 * MarsGame.getRatioMonitorW(), (166 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("MP").setPosition((MarsGame.WIDTH - 340) * MarsGame.getRatioMonitorW() - text.get("MP").getPrefWidth(), (187 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                    text.get("Reactor-34M").setPosition((MarsGame.WIDTH / 2 + 80) * MarsGame.getRatioMonitorW(), (572 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
                }
            }
        }
    }

    @Override
    public void update(float deltaTime) {
        showMonitor(deltaTime);
        energy.update(deltaTime);
        caseReactor.update(deltaTime);
        stars.update();
        core.update(deltaTime);
        if (core.isComplete()) core.reset();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        stars.render(batch);
        batch.draw(MarsGame.getTextures().textureRegion.get("FonReactorUP"), 0, 1216 + MarsGame.getRatioAdd(), 1920, -192);
        batch.draw(MarsGame.getTextures().textureRegion.get("FonReactor"), 0, 0 + MarsGame.getRatioAdd());
        energy.render(batch);
        core.draw(batch);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("CapsuleMini"), MarsGame.WIDTH - 405, 145 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("PipesL"), 64, 64 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("PipesR"), MarsGame.WIDTH / 2 + 64, 64 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("CapsuleMini"), 84, 120 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Reactor"), MarsGame.WIDTH / 2 - 288, 140 + MarsGame.getRatioAdd());
        caseReactor.render(batch);
        if (!isShowMonitor) {
            batch.draw(MarsGame.getTextures().textureRegion.get("DownRight"), 190, 166 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("DownLeft"), MarsGame.WIDTH - 340, 187 + MarsGame.getRatioAdd());
            batch.draw(MarsGame.getTextures().textureRegion.get("UpRight"), MarsGame.WIDTH / 2 + 16, 540 + MarsGame.getRatioAdd());
        }

        if (angleShowMonitor == 256) batch.draw(MarsGame.getTextures().textureRegionScreen.get("Close"), MarsGame.WIDTH / 2 - 32, 715 + MarsGame.getRatioAdd());
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("BuyFon"), MarsGame.WIDTH / 2 - (angleShowMonitor * 1.875f) / 2, 540 - (angleShowMonitor * 1.5f) / 2 + MarsGame.getRatioAdd(), angleShowMonitor * 1.875f, angleShowMonitor * 1.5f);
        if (showMonitor == SHOW) {
            if (showBuy == HP) {
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("HP"), MarsGame.WIDTH / 2 - 50, 590 + MarsGame.getRatioAdd(), 100, 100);
                batch.draw(MarsGame.getTextures().textureRegion.get("Money"), text.get("PriceHP").getX() / MarsGame.getRatioMonitorW() - 33, text.get("PriceHP").getY() / MarsGame.getRatioMonitorH() - 11, 22, 22);

                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("BuyHP").getX() / MarsGame.getRatioMonitorW() - 10, text.get("BuyHP").getY() / MarsGame.getRatioMonitorW() - 19, text.get("BuyHP").getPrefWidth() / MarsGame.getRatioMonitorW() + 18, 39);
                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("BuyHP").getX() / MarsGame.getRatioMonitorW() - 12, text.get("BuyHP").getY() / MarsGame.getRatioMonitorW() - 22, 28, 45);
                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("BuyHP").getX() + text.get("BuyHP").getPrefWidth()) / MarsGame.getRatioMonitorW() - 17, text.get("BuyHP").getY() / MarsGame.getRatioMonitorW() - 22, 28, 45);
            }
            else if (showBuy == MP) {
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("MP"), MarsGame.WIDTH / 2 - 50, 590 + MarsGame.getRatioAdd(), 100, 100);
                batch.draw(MarsGame.getTextures().textureRegion.get("Money"), text.get("PriceMP").getX() / MarsGame.getRatioMonitorW() - 33, text.get("PriceMP").getY() / MarsGame.getRatioMonitorH() - 11, 22, 22);

                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("BuyMP").getX() / MarsGame.getRatioMonitorW() - 10, text.get("BuyMP").getY() / MarsGame.getRatioMonitorW() - 19, text.get("BuyMP").getPrefWidth() / MarsGame.getRatioMonitorW() + 18, 39);
                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("BuyMP").getX() / MarsGame.getRatioMonitorW() - 12, text.get("BuyMP").getY() / MarsGame.getRatioMonitorW() - 22, 28, 45);
                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("BuyMP").getX() + text.get("BuyMP").getPrefWidth()) / MarsGame.getRatioMonitorW() - 17, text.get("BuyMP").getY() / MarsGame.getRatioMonitorW() - 22, 28, 45);
            }
            else if (showBuy == SPEED) {
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("HPup"), MarsGame.WIDTH / 2 - 206, 600 + MarsGame.getRatioAdd(), 100, 100);
                batch.draw(MarsGame.getTextures().textureRegionScreen.get("MPup"), MarsGame.WIDTH / 2 + 106, 380 + MarsGame.getRatioAdd(), 100, 100);
                batch.draw(MarsGame.getTextures().textureRegion.get("Mineral"), text.get("PriceHP").getX() / MarsGame.getRatioMonitorW() - 38, text.get("PriceHP").getY() / MarsGame.getRatioMonitorW() - 15, 25, 25);
                batch.draw(MarsGame.getTextures().textureRegion.get("Mineral"), text.get("PriceMP").getX() / MarsGame.getRatioMonitorW() - 38, text.get("PriceMP").getY() / MarsGame.getRatioMonitorW() - 15, 25, 25);

                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("BuyHP").getX() / MarsGame.getRatioMonitorW() - 10, text.get("BuyHP").getY() / MarsGame.getRatioMonitorW() - 19, text.get("BuyHP").getPrefWidth() / MarsGame.getRatioMonitorW() + 18, 39);
                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("BuyHP").getX() / MarsGame.getRatioMonitorW() - 12, text.get("BuyHP").getY() / MarsGame.getRatioMonitorW() - 22, 28, 45);
                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("BuyHP").getX() + text.get("BuyHP").getPrefWidth()) / MarsGame.getRatioMonitorW() - 17, text.get("BuyHP").getY() / MarsGame.getRatioMonitorW() - 22, 28, 45);

                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), text.get("BuyMP").getX() / MarsGame.getRatioMonitorW() - 10, text.get("BuyMP").getY() / MarsGame.getRatioMonitorW() - 19, text.get("BuyMP").getPrefWidth() / MarsGame.getRatioMonitorW() + 18, 39);
                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), text.get("BuyMP").getX() / MarsGame.getRatioMonitorW() - 12, text.get("BuyMP").getY() / MarsGame.getRatioMonitorW() - 22, 28, 45);
                batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (text.get("BuyMP").getX() + text.get("BuyMP").getPrefWidth()) / MarsGame.getRatioMonitorW() - 17, text.get("BuyMP").getY() / MarsGame.getRatioMonitorW() - 22, 28, 45);
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
            if (MarsGame.getMusicSound().musics.get("Reactor").isPlaying()) MarsGame.getMusicSound().musics.get("Reactor").stop();
            stage.dispose();
            text.clear();
            buttons.clear();
            energy.dispose();
            caseReactor.dispose();
            stars.dispose();
            core.dispose();
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
            if (name.equals("HP")) {
                if (!isNotClick) {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    isShowMonitor = true;
                    isNotClick = true;
                    showBuy = HP;
                    text.get("HPup").setText(MarsGame.getLanguage().textScreen.get("HPup"));
                    text.get("CurrentHP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadHPBase()));
                    text.get("NextHP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadHPBase() + 25));
                    int priceUp = 2500 + (MarsGame.getPreference().loadHPBase() - 150) * 10;
                    text.get("PriceHP").setText(Integer.toString(priceUp));
                    if (MarsGame.getPreference().loadMoney() < priceUp) text.get("PriceHP").setColor(Color.RED);
                    text.get("BuyHP").setText(MarsGame.getLanguage().textScreen.get("Buy"));
                    buttons.get("HPbuy").setSize((text.get("BuyHP").getPrefWidth() / MarsGame.getRatioMonitorW()) + 30, 60);
                }
            } else if (name.equals("MP")) {
                if (!isNotClick) {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    isShowMonitor = true;
                    isNotClick = true;
                    showBuy = MP;
                    text.get("MPup").setText(MarsGame.getLanguage().textScreen.get("MPup"));
                    text.get("CurrentMP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadMPEnergy()));
                    text.get("NextMP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadMPEnergy() + 5));
                    int priceUp = 2500 + (MarsGame.getPreference().loadMPEnergy() - 35) * 50;
                    text.get("PriceMP").setText(Integer.toString(priceUp));
                    if (MarsGame.getPreference().loadMoney() < priceUp) text.get("PriceMP").setColor(Color.RED);
                    text.get("BuyMP").setText(MarsGame.getLanguage().textScreen.get("Buy"));
                    buttons.get("MPbuy").setSize((text.get("BuyMP").getPrefWidth() / MarsGame.getRatioMonitorW()) + 30, 60);
                }
            } else if (name.equals("Reactor-34M")) {
                if (!isNotClick) {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    isShowMonitor = true;
                    isNotClick = true;
                    showBuy = SPEED;

                    text.get("HPup").setText(MarsGame.getLanguage().textScreen.get("HPspeed"));
                    text.get("CurrentHP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadHPSpeed()));
                    text.get("NextHP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadHPSpeed() + 1));
                    int priceUpHP = 45 + (MarsGame.getPreference().loadHPSpeed() - 1) * 50;
                    text.get("PriceHP").setText(Integer.toString(priceUpHP));
                    if (MarsGame.getPreference().loadMineral() < priceUpHP) text.get("PriceHP").setColor(Color.RED);
                    text.get("BuyHP").setText(MarsGame.getLanguage().textScreen.get("Buy"));

                    text.get("MPup").setText(MarsGame.getLanguage().textScreen.get("MPspeed"));
                    text.get("CurrentMP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadMPSpeed()));
                    text.get("NextMP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadMPSpeed() + 1));
                    int priceUpMP = 40 + (MarsGame.getPreference().loadMPSpeed() - 1) * 45;
                    text.get("PriceMP").setText(Integer.toString(priceUpMP));
                    if (MarsGame.getPreference().loadMineral() < priceUpMP) text.get("PriceMP").setColor(Color.RED);
                    text.get("BuyMP").setText(MarsGame.getLanguage().textScreen.get("Buy"));

                    buttons.get("HPbuySpeed").setSize((text.get("BuyHP").getPrefWidth() / MarsGame.getRatioMonitorW()) + 30, 60);
                    buttons.get("MPbuySpeed").setSize((text.get("BuyMP").getPrefWidth() / MarsGame.getRatioMonitorW()) + 30, 60);
                }
            } else if (name.equals("HPbuy")) {
                if (showMonitor == SHOW) {
                    if (showBuy == HP) {
                        int priceUp = 2500 + (MarsGame.getPreference().loadHPBase() - 150) * 10;
                        if (MarsGame.getPreference().loadMoney() >= priceUp) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            MarsGame.getPreference().saveHPBase(25, -priceUp);

                            MarsGame.getPreference().setEventSpentMoney(priceUp);
                            MarsGame.getPreference().setAchievementMoneyRemove(MarsGame.getPreference().getEventSpentMoney());
                            MarsGame.getPreference().setAchievementStrongBase();

                            text.get("Money").setText(String.valueOf(MarsGame.getPreference().loadMoney()));
                            text.get("CurrentHP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadHPBase()));
                            text.get("NextHP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadHPBase() + 25));
                            text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
                            priceUp = 2500 + (MarsGame.getPreference().loadHPBase() - 150) * 10;
                            text.get("PriceHP").setText(Integer.toString(priceUp));
                            if (MarsGame.getPreference().loadMoney() < priceUp) text.get("PriceHP").setColor(Color.RED);
                        } else if (MarsGame.getPreference().loadMoney() < priceUp) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
            } else if (name.equals("HPbuySpeed")) {
                if (showMonitor == SHOW) {
                    if (showBuy == SPEED) {
                        int priceUpHP = 45 + (MarsGame.getPreference().loadHPSpeed() - 1) * 50;
                        if (MarsGame.getPreference().loadMineral() >= priceUpHP) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            MarsGame.getPreference().saveHPSpeed(1, -priceUpHP);

                            MarsGame.getPreference().setEventSpentMinerals(priceUpHP);
                            MarsGame.getPreference().setAchievementMineralRemove(MarsGame.getPreference().getEventSpentMinerals());
                            MarsGame.getPreference().setAchievementRepairOfTheBase();

                            text.get("CurrentHP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadHPSpeed()));
                            text.get("NextHP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadHPSpeed() + 1));
                            priceUpHP = 45 + (MarsGame.getPreference().loadHPSpeed() - 1) * 50;
                            text.get("PriceHP").setText(Integer.toString(priceUpHP));
                            if (MarsGame.getPreference().loadMineral() < priceUpHP) text.get("PriceHP").setColor(Color.RED);
                        } else if (MarsGame.getPreference().loadMineral() < priceUpHP) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
            } else if (name.equals("MPbuy")) {
                if (showMonitor == SHOW) {
                    if (showBuy == MP) {
                        int priceUp = 2500 + (MarsGame.getPreference().loadMPEnergy() - 35) * 50;
                        if (MarsGame.getPreference().loadMoney() >= priceUp) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            MarsGame.getPreference().saveMPEnergy(5, -priceUp);

                            MarsGame.getPreference().setEventSpentMoney(priceUp);
                            MarsGame.getPreference().setAchievementMoneyRemove(MarsGame.getPreference().getEventSpentMoney());
                            MarsGame.getPreference().setAchievementImprovedGenerator();

                            text.get("Money").setText(String.valueOf(MarsGame.getPreference().loadMoney()));
                            text.get("CurrentMP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadMPEnergy()));
                            text.get("NextMP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadMPEnergy() + 5));
                            text.get("Money").setPosition((MarsGame.WIDTH / 2 - 128) * MarsGame.getRatioMonitorW() - text.get("Money").getPrefWidth(), (MarsGame.HEIGHT - 116) * MarsGame.getRatioMonitorH());
                            priceUp = 2500 + (MarsGame.getPreference().loadMPEnergy() - 35) * 50;
                            text.get("PriceMP").setText(Integer.toString(priceUp));
                            if (MarsGame.getPreference().loadMoney() < priceUp) text.get("PriceMP").setColor(Color.RED);
                        } else if (MarsGame.getPreference().loadMoney() < priceUp) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
            } else if (name.equals("MPbuySpeed")) {
                if (showMonitor == SHOW) {
                    if (showBuy == SPEED) {
                        int priceUpMP = 40 + (MarsGame.getPreference().loadMPSpeed() - 1) * 45;
                        if (MarsGame.getPreference().loadMineral() >= priceUpMP) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                            MarsGame.getPreference().saveMPSpeed(1, -priceUpMP);

                            MarsGame.getPreference().setEventSpentMinerals(priceUpMP);
                            MarsGame.getPreference().setAchievementMineralRemove(MarsGame.getPreference().getEventSpentMinerals());
                            MarsGame.getPreference().setAchievementEnergyRecovery();

                            text.get("Mineral").setText(String.valueOf(MarsGame.getPreference().loadMineral()));
                            text.get("CurrentMP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Current")).append(MarsGame.getPreference().loadMPSpeed()));
                            text.get("NextMP").setText(new StringBuilder().append(MarsGame.getLanguage().textScreen.get("Next")).append(MarsGame.getPreference().loadMPSpeed() + 1));
                            priceUpMP = 40 + (MarsGame.getPreference().loadMPSpeed() - 1) * 45;
                            text.get("PriceMP").setText(Integer.toString(priceUpMP));
                            if (MarsGame.getPreference().loadMineral() < priceUpMP) text.get("PriceMP").setColor(Color.RED);
                        } else if (MarsGame.getPreference().loadMineral() < priceUpMP) {
                            if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("AccessDenied").play();
                        }
                    }
                }
            } else if (name.equals("Close")) {
                if (angleShowMonitor == 256) {
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                    isShowMonitor = true;
                    showBuy = NONE;
                    text.get("PriceHP").setColor(Color.WHITE);
                    text.get("PriceMP").setColor(Color.WHITE);
                    buttons.get("HPbuy").setPosition(MarsGame.WIDTH + 100, 150);
                    buttons.get("MPbuy").setPosition(MarsGame.WIDTH + 100, 150);
                    buttons.get("HPbuySpeed").setPosition(MarsGame.WIDTH + 100, 150);
                    buttons.get("MPbuySpeed").setPosition(MarsGame.WIDTH + 100, 150);
                }
            } else if (name.equals("Hangar")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Game"));
            } else if (name.equals("Arsenal")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Arsenal"));
            } else if (name.equals("Laboratory")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Laboratory"));
            } else if (name.equals("Bridge")) {
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                game.set(new Loading(game, "Bridge"));
            }
        }
    }
}
