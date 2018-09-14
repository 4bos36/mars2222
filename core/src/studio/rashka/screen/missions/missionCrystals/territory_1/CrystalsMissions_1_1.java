package studio.rashka.screen.missions.missionCrystals.territory_1;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_1_1 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_1_1() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 5; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_1_1");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_1_1"))
            crystals = MarsGame.getPreference().getCrystal("Missions_1_1");

        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), MarsGame.WIDTH / 2 - 132, 1080 + 16, 64, 64);
        if (crystals >= 150) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), MarsGame.WIDTH / 2 - 172, 1080 - 8, 64, 64);
        if (crystals >= 50) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), MarsGame.WIDTH / 2 - 132, 1080 - 24, 64, 64);
        if (crystals >= 200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), MarsGame.WIDTH / 2 - 172, 1080 - 48, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), MarsGame.WIDTH / 2 - 132, 1080 - 64, 64, 64);
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