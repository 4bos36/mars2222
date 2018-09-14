package studio.rashka.screen.missions.missionCrystals.territory_4;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_4_2 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_4_2() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 8; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_4_2");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_4_2"))
            crystals = MarsGame.getPreference().getCrystal("Missions_4_2");

        if (crystals >= 135) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 1440, 688, 64, 64);
        if (crystals >= 120) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 1440, 640, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 1440, 608, 64, 64);
        if (crystals >= 80) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 1440, 576, 64, 64);
        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 1440, 544, 64, 64);
        if (crystals >= 20) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 1440, 496, 64, 64);
        if (crystals >= 40) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 1440, 448, 64, 64);
        if (crystals >= 60) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 1440, 400, 64, 64);
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