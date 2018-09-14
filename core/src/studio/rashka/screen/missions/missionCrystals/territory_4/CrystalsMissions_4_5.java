package studio.rashka.screen.missions.missionCrystals.territory_4;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_4_5 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_4_5() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 24; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_4_5");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_4_5"))
            crystals = MarsGame.getPreference().getCrystal("Missions_4_5");

        if (crystals >= 1800) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(15)), 96, 448, 64, 64);
        if (crystals >= 1400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(16)), 96, 400, 64, 64);
        if (crystals >= 1000) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(22)), 144, 448, 64, 64);
        if (crystals >= 950) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(23)), 144, 400, 64, 64);
        if (crystals >= 800) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(10)), 192, 448, 64, 64);
        if (crystals >= 850) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(11)), 192, 400, 64, 64);
        if (crystals >= 100) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 240, 448, 64, 64);
        if (crystals >= 600) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 240, 400, 64, 64);
        if (crystals >= 650) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 288, 448, 64, 64);
        if (crystals >= 700) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(8)), 288, 400, 64, 64);
        if (crystals >= 750) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(9)), 336, 448, 64, 64);
        if (crystals >= 300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 336, 400, 64, 64);
        if (crystals >= 400) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 384, 448, 64, 64);
        if (crystals >= 500) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 384, 400, 64, 64);
        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 432, 448, 64, 64);
        if (crystals >= 200) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 432, 400, 64, 64);
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