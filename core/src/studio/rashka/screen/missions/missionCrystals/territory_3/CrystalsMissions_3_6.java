package studio.rashka.screen.missions.missionCrystals.territory_3;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_3_6 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_3_6() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 10; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_3_6");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_3_6"))
            crystals = MarsGame.getPreference().getCrystal("Missions_3_6");

        if (crystals >= 125) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 512, 592, 64, 64);
        if (crystals >= 90) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 512, 544, 64, 64);
        if (crystals >= 45) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 512, 496, 64, 64);
        if (crystals >= 20) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 512, 448, 64, 64);
        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 544, 416, 64, 64);
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