package studio.rashka.models.monsters.packMonsters;

import java.util.Random;

import studio.rashka.MarsGame;
import studio.rashka.screen.missions.Path;

public class PathChoice {

    private Path path;

    public PathChoice(String mission, int positionStart, Random random) {
        //region 1
        if (mission.equals("Missions_1_1")) {
            if (positionStart == 0) path = new Path(mission, 289, 1080 - (100 - random.nextInt(20)), positionStart, 90);
            else if (positionStart == 1) path = new Path(mission, MarsGame.WIDTH - (240 - random.nextInt(20)), 750, positionStart, 180);
        } else if (mission.equals("Missions_1_2")) {
            if (positionStart == 0) path = new Path(mission, 240 + random.nextInt(64), 1080 - 32, positionStart, 0);
            else if (positionStart == 1) path = new Path(mission, 250 + random.nextInt(44), 256, positionStart, 180);
            else if (positionStart == 2) path = new Path(mission, MarsGame.WIDTH - (250 + random.nextInt(44)), 1080 - 32, positionStart, 0);
            else if (positionStart == 3) path = new Path(mission, MarsGame.WIDTH - (250 + random.nextInt(44)), 256, positionStart, 180);
        } else if (mission.equals("Missions_1_3")) {
            if (positionStart == 0) path = new Path(mission, 350 + random.nextInt(16), 1080 - 128, positionStart, 0);
            else if (positionStart == 1) path = new Path(mission, 1600, 1080 + 180, positionStart, 0);
            else if (positionStart == 2) path = new Path(mission, 1600, 20, positionStart, 180);
            else if (positionStart == 3) path = new Path(mission, 2530, 880, positionStart, 270);
            else if (positionStart == 4) path = new Path(mission, 2530, 336, positionStart, 270);
        } else if (mission.equals("Missions_1_4")) {
            if (positionStart == 0) path = new Path(mission, 350 + random.nextInt(16), 1080 - 128, positionStart, 0);
            else if (positionStart == 1) path = new Path(mission, 350 + random.nextInt(16), 256, positionStart, 180);
            else if (positionStart == 2) path = new Path(mission, 1600, 20, positionStart, 180);
            else if (positionStart == 3) path = new Path(mission, 2530, 400, positionStart, 270);
            else if (positionStart == 4) path = new Path(mission, 2530, 752, positionStart, 270);
            else if (positionStart == 5) path = new Path(mission, 1184, 1080 + 180, positionStart, 0);
        } else if (mission.equals("Missions_1_5")) {
            if (positionStart == 0) path = new Path(mission, MarsGame.WIDTH - 255 + random.nextInt(25), 230, positionStart, 180);
            else if (positionStart == 1) path = new Path(mission, 1888, 1120 + random.nextInt(25), positionStart, 270);
            else if (positionStart == 2) path = new Path(mission, 1408 + random.nextInt(25), 32, positionStart, 180);
        } else if (mission.equals("Missions_1_6")) {
            if (positionStart == 0) path = new Path(mission, 280 + random.nextInt(16), 1250, positionStart, 0);
            else if (positionStart == 1) path = new Path(mission, 2050, 1060 + random.nextInt(16), positionStart, 270);
            else if (positionStart == 2) path = new Path(mission, 1790 + random.nextInt(192), 32, positionStart, 180);
            else if (positionStart == 3) path = new Path(mission, 352, 290 + random.nextInt(16), positionStart, 90);
        }
        //endregion
        //region 2
        else if (mission.equals("Missions_2_1")) {
            if (positionStart == 0) path = new Path(mission, 160, 180, positionStart, 180);
            else if (positionStart == 1) path = new Path(mission, 480, 1248, positionStart, 0);
            else if (positionStart == 2) path = new Path(mission, 1440, 32, positionStart, 180);
        } else if (mission.equals("Missions_2_2")) {
            if (positionStart == 0) path = new Path(mission, 224, 1056, positionStart, 0);
            else if (positionStart == 1) path = new Path(mission, 1696, 32, positionStart, 180);
        } else if (mission.equals("Missions_2_3")) {
            if (positionStart == 0) path = new Path(mission, 160, 1024, positionStart, 90);
            else if (positionStart == 1) path = new Path(mission, 1504, 1248, positionStart, 0);
            else if (positionStart == 2) path = new Path(mission, 1824, 1248, positionStart, 0);
            else if (positionStart == 3) path = new Path(mission, 1890, 544, positionStart, 270);
            else if (positionStart == 4) path = new Path(mission, 1890, 192, positionStart, 270);
        } else if (mission.equals("Missions_2_4")) {
            if (positionStart == -1) path = new Path(mission, 576, 1248, positionStart, 180);
            else if (positionStart == 0) path = new Path(mission, 1696, 1088, positionStart, 0);
            else if (positionStart == 1) path = new Path(mission, 352, 1248, positionStart, 0);
            else if (positionStart == 2) path = new Path(mission, 32, 288, positionStart, 90);
            else if (positionStart == 3) path = new Path(mission, 800, 32, positionStart, 180);
        } else if (mission.equals("Missions_2_5")) {
            if (positionStart == -1) path = new Path(mission, 32, 64, positionStart, -90);
            else if (positionStart == 0) path = new Path(mission, 832, 1088, positionStart, 90);
            else if (positionStart == 1) path = new Path(mission, 32, 992, positionStart, 90);
            else if (positionStart == 2) path = new Path(mission, 32, 224, positionStart, 90);
            else if (positionStart == 3) path = new Path(mission, 1888, 736, positionStart, 270);
            else if (positionStart == 4) path = new Path(mission, 1888, 288, positionStart, 270);
        } else if (mission.equals("Missions_2_6")) {
            if (positionStart == -1) path = new Path(mission, 1408, 1248, positionStart, 180);
            else if (positionStart == 0) path = new Path(mission, 736, 1088, positionStart, -90);
            else if (positionStart == 1) path = new Path(mission, 192, 1248, positionStart, 0);
            else if (positionStart == 2) path = new Path(mission, 192, 32, positionStart, 180);
            else if (positionStart == 3) path = new Path(mission, 1600, 1248, positionStart, 0);
            else if (positionStart == 4) {
                int x = random.nextInt(3);
                if (x == 0) path = new Path(mission, 1728, 1248, positionStart, 0);
                else if (x == 1) path = new Path(mission, 1760, 1248, positionStart, 0);
                else if (x == 2) path = new Path(mission, 1792, 1248, positionStart, 0);
            }
        }
        //endregion
        //region 3
        else if (mission.equals("Missions_3_1")) {
            if (positionStart == -1) path = new Path(mission, 1248, 32, positionStart, 0);
            else if (positionStart == 0) path = new Path(mission, 256, 192, positionStart, 180);
            else if (positionStart == 1) path = new Path(mission, 224 + random.nextInt(32), 1248, positionStart, 0);
            else if (positionStart == 2) path = new Path(mission, 1888, 1120 + random.nextInt(32), positionStart, -90);
            else if (positionStart == 3) path = new Path(mission, 1888, 96 + random.nextInt(64), positionStart, -90);
        } else if (mission.equals("Missions_3_2")) {
            if (positionStart == -1) path = new Path(mission, 1248, 32, positionStart, 0);
            else if (positionStart == 0) path = new Path(mission, 192, 1088 + random.nextInt(32), positionStart, 90);
            else if (positionStart == 1) path = new Path(mission, 1728, 1088 + random.nextInt(32), positionStart, -90);
            else if (positionStart == 2) path = new Path(mission, 32, 448 + random.nextInt(256), positionStart, 90);
            else if (positionStart == 3) path = new Path(mission, 1888, 448 + random.nextInt(256), positionStart, -90);
        } else if (mission.equals("Missions_3_3")) {
            if (positionStart == -1) path = new Path(mission, 1888, 928, positionStart, 90);
            else if (positionStart == 0) path = new Path(mission, 224 + random.nextInt(32), 1088, positionStart, 0);
            else if (positionStart == 1) path = new Path(mission, 224 + random.nextInt(32), 192, positionStart, 180);
            else if (positionStart == 2) path = new Path(mission, 1888, 640, positionStart, -90);
            else if (positionStart == 3) path = new Path(mission, 1632 + random.nextInt(128), 32, positionStart, 180);
        } else if (mission.equals("Missions_3_4")) {
            if (positionStart == 0) path = new Path(mission, 224, 1120 + random.nextInt(32), positionStart, 90);
            else if (positionStart == 1) path = new Path(mission, 224, 176, positionStart, 90);
            else if (positionStart == 2) path = new Path(mission, 1788, 1088, positionStart, 0);
            else if (positionStart == 3) path = new Path(mission, 1728, 155, positionStart, -90);
            else if (positionStart == 4) path = new Path(mission, 832, 1248, positionStart, 0);
            else if (positionStart == 5) path = new Path(mission, 1888, 432, positionStart, -90);
            else if (positionStart == 6) path = new Path(mission, 800, 32, positionStart, 180);
        } else if (mission.equals("Missions_3_5")) {
            if (positionStart == 0) path = new Path(mission, 1788, 1088, positionStart, 0);
            else if (positionStart == 1) path = new Path(mission, 1728, 155, positionStart, 180);
            else if (positionStart == 2) path = new Path(mission, 32, 1120 + random.nextInt(32), positionStart, 90);
            else if (positionStart == 3) path = new Path(mission, 832, 1248, positionStart, 0);
            else if (positionStart == 4) path = new Path(mission, 800, 32, positionStart, 180);
        } else if (mission.equals("Missions_3_6")) {
            if (positionStart == 0) path = new Path(mission, 1728, 155, positionStart, 180);
            else if (positionStart == 1) path = new Path(mission, 192 + random.nextInt(192), 32, positionStart, 180);
            else if (positionStart == 2) path = new Path(mission, 1888, 992 + random.nextInt(192), positionStart, -90);
            else if (positionStart == 3) path = new Path(mission, 800 + random.nextInt(128), 32, positionStart, 180);
            else if (positionStart == 4) path = new Path(mission, 816 + random.nextInt(96), 32, positionStart, 180);
        }
        //endregion
        //region 4
        else if (mission.equals("Missions_4_1")) {
            if (positionStart == 0) path = new Path(mission, 1730, 192, positionStart, 270);
            else if (positionStart == 1) path = new Path(mission, 192 + random.nextInt(64), 32, positionStart, 180);
            else if (positionStart == 2) path = new Path(mission, 1408, 1248, positionStart, 0);
            else if (positionStart == 3) path = new Path(mission, 1600 + random.nextInt(64), 1248, positionStart, 0);
            else if (positionStart == 4) path = new Path(mission, 192 + random.nextInt(64), 32, positionStart, 180);
            else if (positionStart == 5) path = new Path(mission, 1408, 1248, positionStart, 0);
            else if (positionStart == 6) path = new Path(mission, 1600 + random.nextInt(64), 1248, positionStart, 0);
        } else if (mission.equals("Missions_4_2")) {
            if (positionStart == 0) path = new Path(mission, 192, 1118, positionStart, 0);
            else if (positionStart == 1) path = new Path(mission, 1730, 680, positionStart, 180);
            else if (positionStart == 2) path = new Path(mission, 1728, 192, positionStart, 270);
            else if (positionStart == 3) path = new Path(mission, 1408, 32, positionStart, 180);
            else if (positionStart == 4) path = new Path(mission, 704, 32, positionStart, 180);
            else if (positionStart == 5) path = new Path(mission, 192, 32, positionStart, 180);
            else if (positionStart == 6) path = new Path(mission, 32, 448, positionStart, 90);
            else if (positionStart == 7) path = new Path(mission, 1888, 1088, positionStart, 270);
            else if (positionStart == 8) path = new Path(mission, 736, 1248, positionStart, 0);
            else if (positionStart == 9) path = new Path(mission, 1376, 1248, positionStart, 0);
        } else if (mission.equals("Missions_4_3")) {
            if (positionStart == 0) path = new Path(mission, 864, 1024, positionStart, -90);
            else if (positionStart == 1) path = new Path(mission, 192, 1248, positionStart, 0);
            else if (positionStart == 2) path = new Path(mission, 32, 896, positionStart, 90);
            else if (positionStart == 3) path = new Path(mission, 1536, 32, positionStart, 180);
            else if (positionStart == 4) path = new Path(mission, 1888, 928, positionStart, -90);
        } else if (mission.equals("Missions_4_4")) {
            if (positionStart == 0) path = new Path(mission, 170, 192, positionStart, 90);
            else if (positionStart == 1) path = new Path(mission, 32, 1024, positionStart, 90);
            else if (positionStart == 2) path = new Path(mission, 1536, 32, positionStart, 180);
            else if (positionStart == 3) path = new Path(mission, 1888, 224, positionStart, -90);
            else if (positionStart == 4) path = new Path(mission, 1536, 1248, positionStart, 0);
            else if (positionStart == 5) path = new Path(mission, 32, 1024, positionStart, 90);
            else if (positionStart == 6) path = new Path(mission, 1536, 1248, positionStart, 0);
        } else if (mission.equals("Missions_4_5")) {
            if (positionStart == 0) path = new Path(mission, 200, 704, positionStart, 145);
            else if (positionStart == 1) path = new Path(mission, 320 + random.nextInt(64), 1248, positionStart, 0);
            else if (positionStart == 2) path = new Path(mission, 1664 + random.nextInt(64), 1248, positionStart, 0);
            else if (positionStart == 3) path = new Path(mission, 1888, 992, positionStart, 270);
            else if (positionStart == 4) path = new Path(mission, 1760, 32, positionStart, 180);
            else if (positionStart == 5) path = new Path(mission, 32, 272, positionStart, 90);
            else if (positionStart == 6) path = new Path(mission, 384, 32, positionStart, 180);
        } else if (mission.equals("Missions_4_6")) {
            if (positionStart == 0) path = new Path(mission, 1760, 1130, positionStart, 0);
            else if (positionStart == 1) path = new Path(mission, 320 + random.nextInt(64), 1248, positionStart, 0);
            else if (positionStart == 2) path = new Path(mission, 32, 128, positionStart, 90);
            else if (positionStart == 3) path = new Path(mission, 384, 32, positionStart, 180);
            else if (positionStart == 4) path = new Path(mission, 1536, 32, positionStart, 180);
            else if (positionStart == 5) path = new Path(mission, 1888, 128, positionStart, 270);
            else if (positionStart == 6) path = new Path(mission, 352, 1248, positionStart, 0);
            else if (positionStart == 7) path = new Path(mission, 1888, 128, positionStart, 270);
            else if (positionStart == 8) path = new Path(mission, 352, 1248, positionStart, 0);
            else if (positionStart == 9) path = new Path(mission, 32, 128, positionStart, 90);
            else if (positionStart == 10) path = new Path(mission, 384, 32, positionStart, 180);
            else if (positionStart == 11) path = new Path(mission, 1536, 32, positionStart, 180);
            else if (positionStart == 12) path = new Path(mission, 1888, 128, positionStart, 270);
        }
        //endregion
    }

    public Path getPath() {
        return path;
    }
}