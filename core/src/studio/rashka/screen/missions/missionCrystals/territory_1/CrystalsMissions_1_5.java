package studio.rashka.screen.missions.missionCrystals.territory_1;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_1_5 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_1_5() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 11; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_1_5");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_1_5"))
            crystals = MarsGame.getPreference().getCrystal("Missions_1_5");

        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 768, 170, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 718, 170, 64, 64);
        if (crystals >= 200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 818, 170, 64, 64);
        if (crystals >= 300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 668, 170, 64, 64);
        if (crystals >= 400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 868, 170, 64, 64);
        if (crystals >= 500) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 618, 170, 64, 64);
        if (crystals >= 600) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 918, 170, 64, 64);
        if (crystals >= 700) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 568, 170, 64, 64);
        if (crystals >= 800) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(8)), 968, 170, 64, 64);
        if (crystals >= 850) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(9)), 518, 170, 64, 64);
        if (crystals >= 950) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(10)), 1018, 170, 64, 64);
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