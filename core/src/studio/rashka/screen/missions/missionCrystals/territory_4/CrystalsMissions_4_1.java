package studio.rashka.screen.missions.missionCrystals.territory_4;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_4_1 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_4_1() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 7; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_4_1");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_4_1"))
            crystals = MarsGame.getPreference().getCrystal("Missions_4_1");

        if (crystals >= 125) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 288, 1136, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 288, 1088, 64, 64);
        if (crystals >= 80) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 288, 1040, 64, 64);
        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 288, 992, 64, 64);
        if (crystals >= 20) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 288, 944, 64, 64);
        if (crystals >= 40) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 288, 896, 64, 64);
        if (crystals >= 60) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 288, 848, 64, 64);
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