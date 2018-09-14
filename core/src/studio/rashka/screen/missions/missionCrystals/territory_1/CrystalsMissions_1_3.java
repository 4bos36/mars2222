package studio.rashka.screen.missions.missionCrystals.territory_1;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_1_3 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_1_3() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 12; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_1_3");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_1_3"))
            crystals = MarsGame.getPreference().getCrystal("Missions_1_3");

        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 320, 348, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 264, 348, 64, 64);
        if (crystals >= 200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 208, 348, 64, 64);
        if (crystals >= 300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 208, 300, 64, 64);
        if (crystals >= 350) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 264, 300, 64, 64);
        if (crystals >= 400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 320, 300, 64, 64);
        if (crystals >= 450) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 208, 252, 64, 64);
        if (crystals >= 500) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 264, 252, 64, 64);
        if (crystals >= 550) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(8)), 320, 252, 64, 64);
        if (crystals >= 600) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(9)), 208, 204, 64, 64);
        if (crystals >= 650) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(10)), 264, 204, 64, 64);
        if (crystals >= 700) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(11)), 320, 204, 64, 64);
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