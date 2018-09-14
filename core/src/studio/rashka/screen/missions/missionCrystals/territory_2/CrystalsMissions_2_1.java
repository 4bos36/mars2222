package studio.rashka.screen.missions.missionCrystals.territory_2;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_2_1 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_2_1() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 12; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_2_1");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_2_1"))
            crystals = MarsGame.getPreference().getCrystal("Missions_2_1");

        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 896, 1106, 64, 64);
        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 896, 1056, 64, 64);
        if (crystals >= 300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 946, 1106, 64, 64);
        if (crystals >= 200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 946, 1056, 64, 64);
        if (crystals >= 500) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 996, 1106, 64, 64);
        if (crystals >= 400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 996, 1056, 64, 64);
        if (crystals >= 700) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 1046, 1106, 64, 64);
        if (crystals >= 600) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 1046, 1056, 64, 64);
        if (crystals >= 900) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(9)), 1096, 1106, 64, 64);
        if (crystals >= 800) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(8)), 1096, 1056, 64, 64);
        if (crystals >= 1100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(11)), 1146, 1106, 64, 64);
        if (crystals >= 1000) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(10)), 1146, 1056, 64, 64);
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