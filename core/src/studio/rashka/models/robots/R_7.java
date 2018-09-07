package studio.rashka.models.robots;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.AnimationModels;
import studio.rashka.lib.implement.Buttons;

public class R_7 {
    private static final int MOVEMENT = 100;
    private static final int STOP = 0, RUN = 1, NOT = 2;
    private int move = NOT, i = 0, offSend = 0, nomer, addToMove = 0;
    private AnimationModels animation;
    private Vector2 position, velocity;
    private boolean isSend = false;
    private Stage stage;
    private Map<String, Label> text;
    private Buttons buttonClick;
    private Random random;

    public R_7() {
        stage = new Stage();
        random = new Random();
        position = new Vector2(0, 0);
        velocity = new Vector2(0, 0);

        MarsGame.getMusicSound().robotR7();

        text = new HashMap<String, Label>();
        text.put("RobotMessage", new Label("", new LabelStyle(MarsGame.getFontTTF().getFont48(), Color.BLACK)));

        animation = new AnimationModels(new TextureRegion(MarsGame.getTextures().textureRegionScreen.get("R-7_RUN")), 4, 0.6f);

        buttonClick = new Buttons("Click", MarsGame.getTextures().getTextureButtonSkin().getDrawable("NULL"), 128, 128, 320, 96 + MarsGame.getRatioAdd());
        buttonClick.addListener(new ButtonsInputListener("Click"));

        stage.addActor(text.get("RobotMessage"));
    }

    private void robotMessage() {
        nomer = random.nextInt(40) + 1;
        text.get("RobotMessage").setText(MarsGame.getLanguage().textScreen.get("R7Message-" + String.valueOf(nomer)));
        text.get("RobotMessage").setPosition((320 + addToMove - text.get("RobotMessage").getPrefWidth() / 2) * MarsGame.getRatioMonitorW(), (300 + text.get("RobotMessage").getPrefHeight() / 2 + MarsGame.getRatioAdd()) * MarsGame.getRatioMonitorH());
    }

    public void update(float deltaTime) {
        if (move == RUN) {
            if (MarsGame.getPreference().loadSound() == 1)
                if (animation.getFrameCount() == 3) {
                    i++;
                    if (i == 8) {
                        MarsGame.getMusicSound().sounds.get("R7_Move").play();
                        i = 0;
                    }
                }
            animation.update(deltaTime);
            velocity.scl(deltaTime);
            position.add(MOVEMENT * deltaTime, 0);
            velocity.scl(1 / deltaTime);
            if (position.x > 320 + addToMove) {
                move = STOP;
                position.x = 320 + addToMove;
                buttonClick.setPosition(320 + addToMove, 96 + MarsGame.getRatioAdd());
                if (MarsGame.getPreference().loadSound() == 1)
                    MarsGame.getMusicSound().sounds.get("R7_Stop").play();
            }
        }
        if (move == STOP && offSend >= 0) {
            offSend++;
            if (offSend == 20) {
                isSend = true;
                robotMessage();
                if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("R7_Send").play();
            }
            if (offSend == 300) {
                offSend = -1;
                isSend = false;
            }
        }
    }

    public void render(SpriteBatch batch) {
        if (move == RUN) {
            batch.begin();
            batch.draw(animation.getFrame(), position.x, position.y);
            batch.end();
        }
        else if (move == STOP) {
            batch.begin();
            if (!isSend) batch.draw(MarsGame.getTextures().textureRegionScreen.get("R-7_norm"), position.x, position.y);
            else {
                if (nomer == 10 || nomer == 18 || nomer == 19 || nomer == 32 || nomer == 33 || nomer == 35) batch.draw(MarsGame.getTextures().textureRegionScreen.get("R-7_anger"), position.x, position.y);
                else if (nomer == 15 || nomer == 20 || nomer == 30 || nomer == 36 || nomer == 37) batch.draw(MarsGame.getTextures().textureRegionScreen.get("R-7_surprise"), position.x, position.y);
                else batch.draw(MarsGame.getTextures().textureRegionScreen.get("R-7_mimi"), position.x, position.y);
                batch.draw(MarsGame.getTextures().textureRegion.get("ColorWhite"), text.get("RobotMessage").getX() / MarsGame.getRatioMonitorW() - 10,
                        text.get("RobotMessage").getY() / MarsGame.getRatioMonitorH() - text.get("RobotMessage").getPrefHeight() / 2 / MarsGame.getRatioMonitorH(),
                        text.get("RobotMessage").getPrefWidth() / MarsGame.getRatioMonitorW() + 20, text.get("RobotMessage").getPrefHeight() / MarsGame.getRatioMonitorH());
            }
            batch.end();

            if (isSend) {
                stage.act();
                stage.draw();
            }
        }
    }

    public void setX(int x) {
        this.position.x = x;
    }

    public void setY(int y) {
        this.position.y = y + MarsGame.getRatioAdd();
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void setAddToMove(int addToMove) {
        this.addToMove = addToMove;
    }

    public Buttons getClick() {
        return buttonClick;
    }

    public void dispose() {
        try {
            stage.dispose();
            text.clear();
            buttonClick.clear();
            animation.dispose();
            position = null;
            velocity = null;
            random = null;
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
            if (name.equals("Click")) {
                if (offSend == -1) offSend = 0;
            }
        }
    }
}