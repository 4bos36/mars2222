package studio.rashka.screen.missions.missionCrystals.territory_4;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_4_6 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_4_6() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 7; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_4_6");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_4_6"))
            crystals = MarsGame.getPreference().getCrystal("Missions_4_6");

        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 538, 1152, 64, 64);
        if (crystals >= 20) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 538, 1094, 64, 64);
        if (crystals >= 50) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 538, 1036, 64, 64);
        if (crystals >= 80) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 538, 978, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 538, 920, 64, 64);
        if (crystals >= 120) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 538, 862, 64, 64);
        if (crystals >= 130) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 538, 804, 64, 64);
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