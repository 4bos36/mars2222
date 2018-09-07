package studio.rashka.lib.implement;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import studio.rashka.MarsGame;

public class Buttons extends Button {

    private String name;

    public Buttons(String name, Drawable imageUp, float sizeW, float sizeH, float posX, float posY) {
        super(imageUp);
        super.setSize(sizeW * MarsGame.getRatioMonitorW(), sizeH * MarsGame.getRatioMonitorH());
        super.setPosition(posX * MarsGame.getRatioMonitorW(), posY * MarsGame.getRatioMonitorH());
        this.name = name;
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width * MarsGame.getRatioMonitorW(), height * MarsGame.getRatioMonitorH());
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x * MarsGame.getRatioMonitorW(), y * MarsGame.getRatioMonitorH());
    }

    public void setImageUp(Drawable imageUp) {
        super.getStyle().up = imageUp;
    }

    public String getName() {
        return name;
    }
}