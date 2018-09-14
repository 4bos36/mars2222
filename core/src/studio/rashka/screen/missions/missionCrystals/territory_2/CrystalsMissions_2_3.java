package studio.rashka.screen.missions.missionCrystals.territory_2;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_2_3 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_2_3() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 15; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_2_3");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_2_3"))
            crystals = MarsGame.getPreference().getCrystal("Missions_2_3");

        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 576, 288, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 526, 288, 64, 64);
        if (crystals >= 200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 476, 288, 64, 64);
        if (crystals >= 300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 576, 238, 64, 64);
        if (crystals >= 400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 526, 238, 64, 64);
        if (crystals >= 500) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 476, 238, 64, 64);
        if (crystals >= 600) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 576, 188, 64, 64);
        if (crystals >= 700) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 526, 188, 64, 64);
        if (crystals >= 800) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(8)), 476, 188, 64, 64);
        if (crystals >= 900) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(9)), 576, 138, 64, 64);
        if (crystals >= 1000) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(10)), 526, 138, 64, 64);
        if (crystals >= 1100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(11)), 476, 138, 64, 64);
        if (crystals >= 1200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(12)), 626, 238, 64, 64);
        if (crystals >= 1300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(13)), 626, 188, 64, 64);
        if (crystals >= 1400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(14)), 626, 138, 64, 64);
    }

    @Override
    public void dispose() {
        try {
            crystalsType.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}