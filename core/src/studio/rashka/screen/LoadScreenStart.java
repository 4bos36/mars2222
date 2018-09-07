package studio.rashka.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import studio.rashka.lib.Game;
import studio.rashka.lib.State;

public class LoadScreenStart extends State {

    private int i = 0;

    public LoadScreenStart(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        i++;
        if (i > 15) game.set(new LoadScreen(game));
    }

    @Override
    public void render(SpriteBatch batch) {
    }

    @Override
    public void dispose() {
    }
}