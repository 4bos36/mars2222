package studio.rashka.screen.missions.missionCrystals.territory_2;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_2_6 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_2_6() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 24; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_2_6");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_2_6"))
            crystals = MarsGame.getPreference().getCrystal("Missions_2_6");

        if (crystals >= 1500) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(17)), 1256, 1082, 64, 64);
        if (crystals >= 1600) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(18)), 1206, 1082, 64, 64);
        if (crystals >= 1700) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(19)), 1156, 1082, 64, 64);
        if (crystals >= 1800) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(20)), 1106, 1082, 64, 64);
        if (crystals >= 1900) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(21)), 1056, 1082, 64, 64);
        if (crystals >= 1000) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(12)), 1256, 1032, 64, 64);
        if (crystals >= 1100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(13)), 1206, 1032, 64, 64);
        if (crystals >= 1200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(14)), 1156, 1032, 64, 64);
        if (crystals >= 1300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(15)), 1106, 1032, 64, 64);
        if (crystals >= 1400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(16)), 1056, 1032, 64, 64);
        if (crystals >= 900) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(22)), 1206, 982, 64, 64);
        if (crystals >= 950) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(23)), 1256, 982, 64, 64);
        if (crystals >= 800) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(10)), 1206, 932, 64, 64);
        if (crystals >= 850) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(11)), 1256, 932, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 1056, 882, 64, 64);
        if (crystals >= 600) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 1106, 882, 64, 64);
        if (crystals >= 650) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 1156, 882, 64, 64);
        if (crystals >= 700) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(8)), 1206, 882, 64, 64);
        if (crystals >= 750) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(9)), 1256, 882, 64, 64);
        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 1056, 832, 64, 64);
        if (crystals >= 200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 1106, 832, 64, 64);
        if (crystals >= 300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 1156, 832, 64, 64);
        if (crystals >= 400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 1206, 832, 64, 64);
        if (crystals >= 500) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 1256, 832, 64, 64);
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