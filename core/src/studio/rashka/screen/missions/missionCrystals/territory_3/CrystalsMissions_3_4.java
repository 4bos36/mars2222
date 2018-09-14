package studio.rashka.screen.missions.missionCrystals.territory_3;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.crystals.Crystals;

public class CrystalsMissions_3_4 implements Crystals {

    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public CrystalsMissions_3_4() {
        random = new Random();
        crystalsType = new ArrayList<String>();

        for (int i = 0; i < 15; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal("Missions_3_4");
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal("Missions_3_4"))
            crystals = MarsGame.getPreference().getCrystal("Missions_3_4");

        if (crystals > 0) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(0)), 136, 752, 64, 64);
        if (crystals >= 15) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(1)), 136, 704, 64, 64);
        if (crystals >= 40) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(2)), 184, 752, 64, 64);
        if (crystals >= 60) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(3)), 184, 704, 64, 64);
        if (crystals >= 85) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(4)), 232, 752, 64, 64);
        if (crystals >= 115) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(5)), 232, 704, 64, 64);
        if (crystals >= 140) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(6)), 280, 752, 64, 64);
        if (crystals >= 173) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(7)), 280, 704, 64, 64);
        if (crystals >= 192) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(8)), 328, 752, 64, 64);
        if (crystals >= 211) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(9)), 328, 704, 64, 64);
        if (crystals >= 234) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(10)), 376, 752, 64, 64);
        if (crystals >= 265) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(11)), 376, 704, 64, 64);
        if (crystals >= 280) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(12)), 424, 752, 64, 64);
        if (crystals >= 300) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(13)), 424, 704, 64, 64);
        if (crystals >= 330) batch.draw(Textures.getInstance().textureRegion.get(crystalsType.get(14)), 88, 720, 64, 64);
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