package studio.rashka.screen.missions.missionCrystals.territory_2;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_2_5 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_2_5() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 13; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_2_5");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_2_5"))
            crystals = MarsGame.getPreference().getCrystal("Missions_2_5");

        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 896, 176, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 896, 126, 64, 64);
        if (crystals >= 200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 896, 76, 64, 64);
        if (crystals >= 300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 946, 76, 64, 64);
        if (crystals >= 400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 846, 76, 64, 64);
        if (crystals >= 500) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 996, 76, 64, 64);
        if (crystals >= 600) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 796, 76, 64, 64);
        if (crystals >= 1600) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(11)), 721, 176, 64, 64);
        if (crystals >= 1500) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(10)), 721, 126, 64, 64);
        if (crystals >= 1000) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(8)), 746, 76, 64, 64);
        if (crystals >= 1700) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(12)), 1071, 176, 64, 64);
        if (crystals >= 1200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(9)), 1071, 126, 64, 64);
        if (crystals >= 850) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 1046, 76, 64, 64);
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