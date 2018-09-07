package studio.rashka.screen.missions;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

import studio.rashka.MarsGame;

public class Crystals {

    private String mission;
    private ArrayList<String> crystalsType;
    private Random random;
    private int crystals;

    public Crystals(String mission) {
        this.mission = mission;

        random = new Random();
        crystalsType = new ArrayList<String>();

        if (mission.equals("Missions_1_1")) for (int i = 0; i < 5; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_1_2")) for (int i = 0; i < 10; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_1_3")) for (int i = 0; i < 12; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_1_4")) for (int i = 0; i < 12; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_1_5")) for (int i = 0; i < 11; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_1_6")) for (int i = 0; i < 11; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_2_1")) for (int i = 0; i < 12; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_2_2")) for (int i = 0; i < 12; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_2_3")) for (int i = 0; i < 15; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_2_4")) for (int i = 0; i < 20; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_2_5")) for (int i = 0; i < 13; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_2_6")) for (int i = 0; i < 24; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_3_1")) for (int i = 0; i < 15; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_3_2")) for (int i = 0; i < 15; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_3_3")) for (int i = 0; i < 15; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_3_4")) for (int i = 0; i < 15; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_3_5")) for (int i = 0; i < 19; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_3_6")) for (int i = 0; i < 10; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_4_1")) for (int i = 0; i < 7; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_4_2")) for (int i = 0; i < 8; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_4_3")) for (int i = 0; i < 6; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_4_4")) for (int i = 0; i < 6; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_4_5")) for (int i = 0; i < 24; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));
        else if (mission.equals("Missions_4_6")) for (int i = 0; i < 7; i++) crystalsType.add(i, "Crystals_" + (random.nextInt(5) + 1));

        crystals = MarsGame.getPreference().getCrystal(mission);
    }

    public void update(float deltaTime) {
    }

    public void render(SpriteBatch batch) {
        if (crystals != MarsGame.getPreference().getCrystal(mission)) crystals = MarsGame.getPreference().getCrystal(mission);
        //region 1
        if (mission.equals("Missions_1_1")) {
            //region code
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), MarsGame.WIDTH / 2 - 132, 1080 + 16, 64, 64);
            if (crystals >= 150) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), MarsGame.WIDTH / 2 - 172, 1080 - 8, 64, 64);
            if (crystals >= 50) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), MarsGame.WIDTH / 2 - 132, 1080 - 24, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), MarsGame.WIDTH / 2 - 172, 1080 - 48, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), MarsGame.WIDTH / 2 - 132, 1080 - 64, 64, 64);
            //endregion
        } else if (mission.equals("Missions_1_2")) {
            //region code
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), MarsGame.WIDTH / 2 + 28, 176, 64, 64);
            if (crystals >= 150) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), MarsGame.WIDTH / 2 + 68, 144, 64, 64);
            if (crystals >= 50) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), MarsGame.WIDTH / 2 + 28, 136, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), MarsGame.WIDTH / 2 + 68, 104, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), MarsGame.WIDTH / 2 + 28, 96, 64, 64);

            if (crystals >= 250) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), MarsGame.WIDTH / 2 - 132, 1080 + 16, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), MarsGame.WIDTH / 2 - 172, 1080 - 8, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), MarsGame.WIDTH / 2 - 132, 1080 - 24, 64, 64);
            if (crystals >= 450) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), MarsGame.WIDTH / 2 - 172, 1080 - 48, 64, 64);
            if (crystals >= 350) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), MarsGame.WIDTH / 2 - 132, 1080 - 64, 64, 64);
            //endregion
        } else if (mission.equals("Missions_1_3")) {
            //region code
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 320, 348, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 264, 348, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 208, 348, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 208, 300, 64, 64);
            if (crystals >= 350) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 264, 300, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 320, 300, 64, 64);
            if (crystals >= 450) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 208, 252, 64, 64);
            if (crystals >= 500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 264, 252, 64, 64);
            if (crystals >= 550) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 320, 252, 64, 64);
            if (crystals >= 600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 208, 204, 64, 64);
            if (crystals >= 650) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 264, 204, 64, 64);
            if (crystals >= 700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 320, 204, 64, 64);
            //endregion
        } else if (mission.equals("Missions_1_4")) {
            //region code
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 1786, 662, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 1786, 614, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 1786, 566, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 1842, 662, 64, 64);
            if (crystals >= 350) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 1842, 614, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 1842, 566, 64, 64);
            if (crystals >= 450) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 1898, 662, 64, 64);
            if (crystals >= 500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 1898, 614, 64, 64);
            if (crystals >= 550) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 1898, 566, 64, 64);
            if (crystals >= 600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 1954, 662, 64, 64);
            if (crystals >= 650) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 1954, 614, 64, 64);
            if (crystals >= 700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 1954, 566, 64, 64);
            //endregion
        } else if (mission.equals("Missions_1_5")) {
            //region code
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 768, 170, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 718, 170, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 818, 170, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 668, 170, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 868, 170, 64, 64);
            if (crystals >= 500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 618, 170, 64, 64);
            if (crystals >= 600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 918, 170, 64, 64);
            if (crystals >= 700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 568, 170, 64, 64);
            if (crystals >= 800) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 968, 170, 64, 64);
            if (crystals >= 850) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 518, 170, 64, 64);
            if (crystals >= 950) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 1018, 170, 64, 64);
            //endregion
        } else if (mission.equals("Missions_1_6")) {
            //region code
            if (crystals >= 950) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 160, 986, 64, 64);
            if (crystals >= 800) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 160, 936, 64, 64);
            if (crystals >= 600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 160, 886, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 160, 836, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 160, 786, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 160, 736, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 160, 686, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 160, 636, 64, 64);
            if (crystals >= 500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 160, 586, 64, 64);
            if (crystals >= 700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 160, 536, 64, 64);
            if (crystals >= 850) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 160, 486, 64, 64);
            //endregion
        }
        //endregion
        //region 2
        else if (mission.equals("Missions_2_1")) {
            //region code
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 896, 1106, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 896, 1056, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 946, 1106, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 946, 1056, 64, 64);
            if (crystals >= 500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 996, 1106, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 996, 1056, 64, 64);
            if (crystals >= 700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 1046, 1106, 64, 64);
            if (crystals >= 600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 1046, 1056, 64, 64);
            if (crystals >= 900) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 1096, 1106, 64, 64);
            if (crystals >= 800) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 1096, 1056, 64, 64);
            if (crystals >= 1100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 1146, 1106, 64, 64);
            if (crystals >= 1000) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 1146, 1056, 64, 64);
            //endregion
        } else if (mission.equals("Missions_2_2")) {
            //region code
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 896, 128, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 896, 78, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 946, 128, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 946, 78, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 996, 128, 64, 64);
            if (crystals >= 500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 996, 78, 64, 64);
            if (crystals >= 600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 1046, 128, 64, 64);
            if (crystals >= 700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 1046, 78, 64, 64);
            if (crystals >= 800) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 1096, 128, 64, 64);
            if (crystals >= 900) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 1096, 78, 64, 64);
            if (crystals >= 1100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 1146, 128, 64, 64);
            if (crystals >= 1300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 1146, 78, 64, 64);
            //endregion
        } else if (mission.equals("Missions_2_3")) {
            //region code
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 576, 288, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 526, 288, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 476, 288, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 576, 238, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 526, 238, 64, 64);
            if (crystals >= 500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 476, 238, 64, 64);
            if (crystals >= 600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 576, 188, 64, 64);
            if (crystals >= 700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 526, 188, 64, 64);
            if (crystals >= 800) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 476, 188, 64, 64);
            if (crystals >= 900) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 576, 138, 64, 64);
            if (crystals >= 1000) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 526, 138, 64, 64);
            if (crystals >= 1100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 476, 138, 64, 64);
            if (crystals >= 1200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(12)), 626, 238, 64, 64);
            if (crystals >= 1300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(13)), 626, 188, 64, 64);
            if (crystals >= 1400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(14)), 626, 138, 64, 64);
            //endregion
        } else if (mission.equals("Missions_2_4")) {
            //region code
            if (crystals >= 1100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 1196, 1106, 64, 64);
            if (crystals >= 1150) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(12)), 846, 1156, 64, 64);
            if (crystals >= 1300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(13)), 896, 1156, 64, 64);
            if (crystals >= 1350) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(14)), 946, 1156, 64, 64);
            if (crystals >= 1400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(15)), 996, 1156, 64, 64);
            if (crystals >= 1450) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(16)), 1046, 1156, 64, 64);
            if (crystals >= 1500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(17)), 1096, 1156, 64, 64);
            if (crystals >= 1550) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(18)), 1146, 1156, 64, 64);
            if (crystals >= 1600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(19)), 1196, 1156, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 846, 1106, 64, 64);
            if (crystals >= 500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 896, 1106, 64, 64);
            if (crystals >= 600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 946, 1106, 64, 64);
            if (crystals >= 700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 996, 1106, 64, 64);
            if (crystals >= 800) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 1046, 1106, 64, 64);
            if (crystals >= 900) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 1096, 1106, 64, 64);
            if (crystals >= 1000) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 1146, 1106, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 846, 1056, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 896, 1056, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 946, 1056, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 996, 1056, 64, 64);
            //endregion
        } else if (mission.equals("Missions_2_5")) {
            //region code
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 896, 176, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 896, 126, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 896, 76, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 946, 76, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 846, 76, 64, 64);
            if (crystals >= 500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 996, 76, 64, 64);
            if (crystals >= 600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 796, 76, 64, 64);
            if (crystals >= 1600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 721, 176, 64, 64);
            if (crystals >= 1500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 721, 126, 64, 64);
            if (crystals >= 1000) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 746, 76, 64, 64);
            if (crystals >= 1700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(12)), 1071, 176, 64, 64);
            if (crystals >= 1200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 1071, 126, 64, 64);
            if (crystals >= 850) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 1046, 76, 64, 64);
            //endregion
        } else if (mission.equals("Missions_2_6")) {
            //region code
            if (crystals >= 1500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(17)), 1256, 1082, 64, 64);
            if (crystals >= 1600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(18)), 1206, 1082, 64, 64);
            if (crystals >= 1700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(19)), 1156, 1082, 64, 64);
            if (crystals >= 1800) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(20)), 1106, 1082, 64, 64);
            if (crystals >= 1900) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(21)), 1056, 1082, 64, 64);
            if (crystals >= 1000) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(12)), 1256, 1032, 64, 64);
            if (crystals >= 1100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(13)), 1206, 1032, 64, 64);
            if (crystals >= 1200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(14)), 1156, 1032, 64, 64);
            if (crystals >= 1300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(15)), 1106, 1032, 64, 64);
            if (crystals >= 1400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(16)), 1056, 1032, 64, 64);
            if (crystals >= 900) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(22)), 1206, 982, 64, 64);
            if (crystals >= 950) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(23)), 1256, 982, 64, 64);
            if (crystals >= 800) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 1206, 932, 64, 64);
            if (crystals >= 850) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 1256, 932, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 1056, 882, 64, 64);
            if (crystals >= 600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 1106, 882, 64, 64);
            if (crystals >= 650) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 1156, 882, 64, 64);
            if (crystals >= 700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 1206, 882, 64, 64);
            if (crystals >= 750) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 1256, 882, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 1056, 832, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 1106, 832, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 1156, 832, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 1206, 832, 64, 64);
            if (crystals >= 500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 1256, 832, 64, 64);
            //endregion
        }
        //endregion
        //region 3
        else if (mission.equals("Missions_3_1")) {
            //region code
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 896, 128, 64, 64);
            if (crystals >= 25) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 896, 64, 64, 64);
            if (crystals >= 40) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 944, 128, 64, 64);
            if (crystals >= 85) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 944, 64, 64, 64);
            if (crystals >= 120) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 848, 128, 64, 64);
            if (crystals >= 165) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 848, 64, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 800, 128, 64, 64);
            if (crystals >= 245) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 800, 64, 64, 64);
            if (crystals >= 270) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 752, 128, 64, 64);
            if (crystals >= 310) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 752, 64, 64, 64);
            if (crystals >= 340) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 704, 128, 64, 64);
            if (crystals >= 375) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 704, 64, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(12)), 656, 128, 64, 64);
            if (crystals >= 450) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(13)), 656, 64, 64, 64);
            if (crystals >= 470) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(14)), 608, 128, 64, 64);
            //endregion
        } else if (mission.equals("Missions_3_2")) {
            //region code
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 896, 128, 64, 64);
            if (crystals >= 25) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 896, 64, 64, 64);
            if (crystals >= 40) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 944, 128, 64, 64);
            if (crystals >= 85) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 944, 64, 64, 64);
            if (crystals >= 120) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 848, 128, 64, 64);
            if (crystals >= 165) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 848, 64, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 800, 128, 64, 64);
            if (crystals >= 245) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 800, 64, 64, 64);
            if (crystals >= 270) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 752, 128, 64, 64);
            if (crystals >= 310) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 752, 64, 64, 64);
            if (crystals >= 340) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 704, 128, 64, 64);
            if (crystals >= 375) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 704, 64, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(12)), 656, 128, 64, 64);
            if (crystals >= 450) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(13)), 656, 64, 64, 64);
            if (crystals >= 470) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(14)), 608, 128, 64, 64);
            //endregion
        } else if (mission.equals("Missions_3_3")) {
            //region code
            if (crystals >= 25) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 1280, 1128, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 1280, 1080, 64, 64);
            if (crystals >= 40) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 1328, 1128, 64, 64);
            if (crystals >= 85) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 1328, 1080, 64, 64);
            if (crystals >= 120) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 1376, 1128, 64, 64);
            if (crystals >= 165) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 1376, 1080, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 1424, 1128, 64, 64);
            if (crystals >= 245) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 1424, 1080, 64, 64);
            if (crystals >= 270) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 1472, 1128, 64, 64);
            if (crystals >= 310) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 1472, 1080, 64, 64);
            if (crystals >= 340) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 1520, 1128, 64, 64);
            if (crystals >= 375) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 1520, 1080, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(12)), 1568, 1128, 64, 64);
            if (crystals >= 450) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(13)), 1568, 1080, 64, 64);
            if (crystals >= 470) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(14)), 1616, 1128, 64, 64);
            //endregion
        } else if (mission.equals("Missions_3_4")) {
            //region code
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 136, 752, 64, 64);
            if (crystals >= 15) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 136, 704, 64, 64);
            if (crystals >= 40) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 184, 752, 64, 64);
            if (crystals >= 60) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 184, 704, 64, 64);
            if (crystals >= 85) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 232, 752, 64, 64);
            if (crystals >= 115) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 232, 704, 64, 64);
            if (crystals >= 140) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 280, 752, 64, 64);
            if (crystals >= 173) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 280, 704, 64, 64);
            if (crystals >= 192) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 328, 752, 64, 64);
            if (crystals >= 211) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 328, 704, 64, 64);
            if (crystals >= 234) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 376, 752, 64, 64);
            if (crystals >= 265) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 376, 704, 64, 64);
            if (crystals >= 280) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(12)), 424, 752, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(13)), 424, 704, 64, 64);
            if (crystals >= 330) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(14)), 88, 720, 64, 64);
            //endregion
        } else if (mission.equals("Missions_3_5")) {
            //region code
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 136, 752, 64, 64);
            if (crystals >= 15) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 136, 704, 64, 64);
            if (crystals >= 40) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 184, 752, 64, 64);
            if (crystals >= 60) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 184, 704, 64, 64);
            if (crystals >= 85) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 232, 752, 64, 64);
            if (crystals >= 115) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 232, 704, 64, 64);
            if (crystals >= 140) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 280, 752, 64, 64);
            if (crystals >= 173) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 280, 704, 64, 64);
            if (crystals >= 192) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 328, 752, 64, 64);
            if (crystals >= 211) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 328, 704, 64, 64);
            if (crystals >= 234) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 376, 752, 64, 64);
            if (crystals >= 265) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 376, 704, 64, 64);
            if (crystals >= 280) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(12)), 424, 752, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(13)), 424, 704, 64, 64);
            if (crystals >= 330) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(14)), 376, 656, 64, 64);
            if (crystals >= 360) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(15)), 376, 608, 64, 64);
            if (crystals >= 390) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(16)), 424, 656, 64, 64);
            if (crystals >= 425) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(17)), 424, 608, 64, 64);
            if (crystals >= 470) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(18)), 88, 720, 64, 64);
            //endregion
        } else if (mission.equals("Missions_3_6")) {
            //region code
            if (crystals >= 125) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 512, 592, 64, 64);
            if (crystals >= 90) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 512, 544, 64, 64);
            if (crystals >= 45) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 512, 496, 64, 64);
            if (crystals >= 20) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 512, 448, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 544, 416, 64, 64);
            //endregion
        }
        //endregion
        //region 4
        else if (mission.equals("Missions_4_1")) {
            //region code
            if (crystals >= 125) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 288, 1136, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 288, 1088, 64, 64);
            if (crystals >= 80) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 288, 1040, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 288, 992, 64, 64);
            if (crystals >= 20) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 288, 944, 64, 64);
            if (crystals >= 40) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 288, 896, 64, 64);
            if (crystals >= 60) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 288, 848, 64, 64);
            //endregion
        } else if (mission.equals("Missions_4_2")) {
            //region code
            if (crystals >= 135) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 1440, 688, 64, 64);
            if (crystals >= 120) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 1440, 640, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 1440, 608, 64, 64);
            if (crystals >= 80) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 1440, 576, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 1440, 544, 64, 64);
            if (crystals >= 20) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 1440, 496, 64, 64);
            if (crystals >= 40) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 1440, 448, 64, 64);
            if (crystals >= 60) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 1440, 400, 64, 64);
            //endregion
        } else if (mission.equals("Missions_4_3")) {
            //region code
            if (crystals >= 130) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 1136, 1152, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 1088, 1152, 64, 64);
            if (crystals >= 80) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 1040, 1152, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 1040, 1104, 64, 64);
            if (crystals >= 20) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 1088, 1104, 64, 64);
            if (crystals >= 50) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 1136, 1104, 64, 64);
            //endregion
        } else if (mission.equals("Missions_4_4")) {
            //region code
            if (crystals >= 130) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 520, 1008, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 520, 960, 64, 64);
            if (crystals >= 80) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 520, 912, 64, 64);
            if (crystals >= 50) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 568, 1008, 64, 64);
            if (crystals >= 20) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 568, 960, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 568, 912, 64, 64);
            //endregion
        } else if (mission.equals("Missions_4_5")) {
            //region code
            if (crystals >= 1800) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(15)), 96, 448, 64, 64);
            if (crystals >= 1400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(16)), 96, 400, 64, 64);
            if (crystals >= 1000) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(22)), 144, 448, 64, 64);
            if (crystals >= 950) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(23)), 144, 400, 64, 64);
            if (crystals >= 800) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(10)), 192, 448, 64, 64);
            if (crystals >= 850) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(11)), 192, 400, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 240, 448, 64, 64);
            if (crystals >= 600) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 240, 400, 64, 64);
            if (crystals >= 650) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(7)), 288, 448, 64, 64);
            if (crystals >= 700) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(8)), 288, 400, 64, 64);
            if (crystals >= 750) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(9)), 336, 448, 64, 64);
            if (crystals >= 300) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 336, 400, 64, 64);
            if (crystals >= 400) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 384, 448, 64, 64);
            if (crystals >= 500) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 384, 400, 64, 64);
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 432, 448, 64, 64);
            if (crystals >= 200) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 432, 400, 64, 64);
            //endregion
        } else if (mission.equals("Missions_4_6")) {
            //region code
            if (crystals > 0) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(0)), 538, 1152, 64, 64);
            if (crystals >= 20) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(1)), 538, 1094, 64, 64);
            if (crystals >= 50) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(2)), 538, 1036, 64, 64);
            if (crystals >= 80) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(3)), 538, 978, 64, 64);
            if (crystals >= 100) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(4)), 538, 920, 64, 64);
            if (crystals >= 120) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(5)), 538, 862, 64, 64);
            if (crystals >= 130) batch.draw(MarsGame.getTextures().textureRegion.get(crystalsType.get(6)), 538, 804, 64, 64);
            //endregion
        }
        //endregion
    }

    public void dispose() {
        try {
            crystalsType.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}