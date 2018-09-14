package studio.rashka.screen.missions.missionCrystals.territory_3;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_3_1 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_3_1() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 15; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_3_1");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_3_1"))
            crystals = MarsGame.getPreference().getCrystal("Missions_3_1");

        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 896, 128, 64, 64);
        if (crystals >= 25) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 896, 64, 64, 64);
        if (crystals >= 40) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 944, 128, 64, 64);
        if (crystals >= 85) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 944, 64, 64, 64);
        if (crystals >= 120) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 848, 128, 64, 64);
        if (crystals >= 165) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 848, 64, 64, 64);
        if (crystals >= 200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 800, 128, 64, 64);
        if (crystals >= 245) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 800, 64, 64, 64);
        if (crystals >= 270) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(8)), 752, 128, 64, 64);
        if (crystals >= 310) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(9)), 752, 64, 64, 64);
        if (crystals >= 340) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(10)), 704, 128, 64, 64);
        if (crystals >= 375) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(11)), 704, 64, 64, 64);
        if (crystals >= 400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(12)), 656, 128, 64, 64);
        if (crystals >= 450) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(13)), 656, 64, 64, 64);
        if (crystals >= 470) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(14)), 608, 128, 64, 64);
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