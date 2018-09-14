package studio.rashka.screen.missions.missionCrystals.territory_4;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_4_3 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_4_3() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 6; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_4_3");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_4_3"))
            crystals = MarsGame.getPreference().getCrystal("Missions_4_3");

        if (crystals >= 130) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 1136, 1152, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 1088, 1152, 64, 64);
        if (crystals >= 80) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 1040, 1152, 64, 64);
        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 1040, 1104, 64, 64);
        if (crystals >= 20) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 1088, 1104, 64, 64);
        if (crystals >= 50) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 1136, 1104, 64, 64);
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