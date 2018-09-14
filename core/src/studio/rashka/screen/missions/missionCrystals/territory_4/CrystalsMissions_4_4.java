package studio.rashka.screen.missions.missionCrystals.territory_4;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_4_4 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_4_4() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 6; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_4_4");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_4_4"))
            crystals = MarsGame.getPreference().getCrystal("Missions_4_4");

        if (crystals >= 130) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 520, 1008, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 520, 960, 64, 64);
        if (crystals >= 80) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 520, 912, 64, 64);
        if (crystals >= 50) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 568, 1008, 64, 64);
        if (crystals >= 20) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 568, 960, 64, 64);
        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 568, 912, 64, 64);
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