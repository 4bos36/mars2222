package studio.rashka.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;

public class Stars {

    private ArrayList<TextureRegion> stars;
    private ArrayList<Integer> randomsX, randomsY;
    private int offStars = 0;
    private Random random;

    public Stars() {
        random = new Random();

        stars = new ArrayList<TextureRegion>();
        randomsX = new ArrayList<Integer>();
        randomsY = new ArrayList<Integer>();
        for (int i = 0; i < 300; i++) {
            if (i < 50) stars.add(i, new TextureRegion(MarsGame.getTextures().textureRegion.get("LightbulbYellowMini")));
            if (i >= 50 && i < 100) stars.add(i, new TextureRegion(MarsGame.getTextures().textureRegion.get("LightbulbRedMini")));
            if (i >= 100 && i < 150) stars.add(i, new TextureRegion(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini")));
            if (i >= 150 && i < 200) stars.add(i, new TextureRegion(MarsGame.getTextures().textureRegion.get("LightbulbRedMini")));
            if (i >= 200) stars.add(i, new TextureRegion(MarsGame.getTextures().textureRegion.get("LightbulbBlueMini")));
            randomsX.add(i, new Random().nextInt(MarsGame.WIDTH));
            randomsY.add(i, new Random().nextInt(MarsGame.HEIGHT));
        }
    }

    public void update() {
        offStars = random.nextInt(30);
    }

    public void render(SpriteBatch batch) {
        //region code
        for (int i = 0; i < 300; i++) {
            if (i < 25)
                if (offStars != 2)
                    batch.draw(stars.get(i), randomsX.get(i), MarsGame.HEIGHT - randomsY.get(i), 5, 5);
            if (i >= 25 && i < 50)
                if (offStars != 5)
                    batch.draw(stars.get(i), randomsX.get(i), MarsGame.HEIGHT - randomsY.get(i), 5, 5);
            if (i >= 50 && i < 75)
                if (offStars != 8)
                    batch.draw(stars.get(i), randomsX.get(i), MarsGame.HEIGHT - randomsY.get(i), 5, 5);
            if (i >= 75 && i < 100)
                if (offStars != 10)
                    batch.draw(stars.get(i), randomsX.get(i), MarsGame.HEIGHT - randomsY.get(i), 5, 5);
            if (i >= 100 && i < 125)
                if (offStars != 12)
                    batch.draw(stars.get(i), randomsX.get(i), MarsGame.HEIGHT - randomsY.get(i), 4, 4);
            if (i >= 125 && i < 150)
                if (offStars != 15)
                    batch.draw(stars.get(i), randomsX.get(i), MarsGame.HEIGHT - randomsY.get(i), 4, 4);
            if (i >= 150 && i < 175)
                if (offStars != 18)
                    batch.draw(stars.get(i), randomsX.get(i), MarsGame.HEIGHT - randomsY.get(i), 3, 3);
            if (i >= 175 && i < 200)
                if (offStars != 21)
                    batch.draw(stars.get(i), randomsX.get(i), MarsGame.HEIGHT - randomsY.get(i), 3, 3);
            if (i >= 200 && i < 250)
                if (offStars != 24)
                    batch.draw(stars.get(i), randomsX.get(i), MarsGame.HEIGHT - randomsY.get(i), 4, 4);
            if (i >= 250)
                if (offStars != 29)
                    batch.draw(stars.get(i), randomsX.get(i), MarsGame.HEIGHT - randomsY.get(i), 4, 4);
        }//endregion
    }

    public void dispose() {
        try {
            stars.clear();
            randomsX.clear();
            randomsY.clear();
            random = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}