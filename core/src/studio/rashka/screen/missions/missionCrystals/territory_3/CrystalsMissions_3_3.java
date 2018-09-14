package studio.rashka.screen.missions.missionCrystals.territory_3;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_3_3 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_3_3() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 15; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_3_3");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_3_3"))
            crystals = MarsGame.getPreference().getCrystal("Missions_3_3");

        if (crystals >= 25) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 1280, 1128, 64, 64);
        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 1280, 1080, 64, 64);
        if (crystals >= 40) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 1328, 1128, 64, 64);
        if (crystals >= 85) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 1328, 1080, 64, 64);
        if (crystals >= 120) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 1376, 1128, 64, 64);
        if (crystals >= 165) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 1376, 1080, 64, 64);
        if (crystals >= 200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 1424, 1128, 64, 64);
        if (crystals >= 245) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 1424, 1080, 64, 64);
        if (crystals >= 270) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(8)), 1472, 1128, 64, 64);
        if (crystals >= 310) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(9)), 1472, 1080, 64, 64);
        if (crystals >= 340) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(10)), 1520, 1128, 64, 64);
        if (crystals >= 375) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(11)), 1520, 1080, 64, 64);
        if (crystals >= 400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(12)), 1568, 1128, 64, 64);
        if (crystals >= 450) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(13)), 1568, 1080, 64, 64);
        if (crystals >= 470) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(14)), 1616, 1128, 64, 64);
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