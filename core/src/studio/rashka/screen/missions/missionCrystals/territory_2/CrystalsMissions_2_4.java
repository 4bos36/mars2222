package studio.rashka.screen.missions.missionCrystals.territory_2;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_2_4 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_2_4() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 20; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_2_4");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_2_4"))
            crystals = MarsGame.getPreference().getCrystal("Missions_2_4");

        if (crystals >= 1100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(11)), 1196, 1106, 64, 64);
        if (crystals >= 1150) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(12)), 846, 1156, 64, 64);
        if (crystals >= 1300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(13)), 896, 1156, 64, 64);
        if (crystals >= 1350) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(14)), 946, 1156, 64, 64);
        if (crystals >= 1400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(15)), 996, 1156, 64, 64);
        if (crystals >= 1450) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(16)), 1046, 1156, 64, 64);
        if (crystals >= 1500) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(17)), 1096, 1156, 64, 64);
        if (crystals >= 1550) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(18)), 1146, 1156, 64, 64);
        if (crystals >= 1600) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(19)), 1196, 1156, 64, 64);
        if (crystals >= 400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 846, 1106, 64, 64);
        if (crystals >= 500) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 896, 1106, 64, 64);
        if (crystals >= 600) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 946, 1106, 64, 64);
        if (crystals >= 700) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 996, 1106, 64, 64);
        if (crystals >= 800) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(8)), 1046, 1106, 64, 64);
        if (crystals >= 900) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(9)), 1096, 1106, 64, 64);
        if (crystals >= 1000) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(10)), 1146, 1106, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 846, 1056, 64, 64);
        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 896, 1056, 64, 64);
        if (crystals >= 200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 946, 1056, 64, 64);
        if (crystals >= 300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 996, 1056, 64, 64);
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