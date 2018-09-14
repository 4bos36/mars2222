package studio.rashka.lib.implement.crystals;

import studio.rashka.screen.missions.missionCrystals.territory_1.CrystalsMissions_1_1;
import studio.rashka.screen.missions.missionCrystals.territory_1.CrystalsMissions_1_2;
import studio.rashka.screen.missions.missionCrystals.territory_1.CrystalsMissions_1_3;
import studio.rashka.screen.missions.missionCrystals.territory_1.CrystalsMissions_1_4;
import studio.rashka.screen.missions.missionCrystals.territory_1.CrystalsMissions_1_5;
import studio.rashka.screen.missions.missionCrystals.territory_1.CrystalsMissions_1_6;
import studio.rashka.screen.missions.missionCrystals.territory_2.CrystalsMissions_2_1;
import studio.rashka.screen.missions.missionCrystals.territory_2.CrystalsMissions_2_2;
import studio.rashka.screen.missions.missionCrystals.territory_2.CrystalsMissions_2_3;
import studio.rashka.screen.missions.missionCrystals.territory_2.CrystalsMissions_2_4;
import studio.rashka.screen.missions.missionCrystals.territory_2.CrystalsMissions_2_5;
import studio.rashka.screen.missions.missionCrystals.territory_2.CrystalsMissions_2_6;
import studio.rashka.screen.missions.missionCrystals.territory_3.CrystalsMissions_3_1;
import studio.rashka.screen.missions.missionCrystals.territory_3.CrystalsMissions_3_2;
import studio.rashka.screen.missions.missionCrystals.territory_3.CrystalsMissions_3_3;
import studio.rashka.screen.missions.missionCrystals.territory_3.CrystalsMissions_3_4;
import studio.rashka.screen.missions.missionCrystals.territory_3.CrystalsMissions_3_5;
import studio.rashka.screen.missions.missionCrystals.territory_3.CrystalsMissions_3_6;
import studio.rashka.screen.missions.missionCrystals.territory_4.CrystalsMissions_4_1;
import studio.rashka.screen.missions.missionCrystals.territory_4.CrystalsMissions_4_2;
import studio.rashka.screen.missions.missionCrystals.territory_4.CrystalsMissions_4_3;
import studio.rashka.screen.missions.missionCrystals.territory_4.CrystalsMissions_4_4;
import studio.rashka.screen.missions.missionCrystals.territory_4.CrystalsMissions_4_5;
import studio.rashka.screen.missions.missionCrystals.territory_4.CrystalsMissions_4_6;

public class CreateMissionCrystals implements AbstractFactoryCrystals {

    @Override
    public Crystals createMissionCrystals(String mission) {
        if (mission.equals("Missions_1_1")) return new CrystalsMissions_1_1();
        else if (mission.equals("Missions_1_2")) return new CrystalsMissions_1_2();
        else if (mission.equals("Missions_1_3")) return new CrystalsMissions_1_3();
        else if (mission.equals("Missions_1_4")) return new CrystalsMissions_1_4();
        else if (mission.equals("Missions_1_5")) return new CrystalsMissions_1_5();
        else if (mission.equals("Missions_1_6")) return new CrystalsMissions_1_6();

        else if (mission.equals("Missions_2_1")) return new CrystalsMissions_2_1();
        else if (mission.equals("Missions_2_2")) return new CrystalsMissions_2_2();
        else if (mission.equals("Missions_2_3")) return new CrystalsMissions_2_3();
        else if (mission.equals("Missions_2_4")) return new CrystalsMissions_2_4();
        else if (mission.equals("Missions_2_5")) return new CrystalsMissions_2_5();
        else if (mission.equals("Missions_2_6")) return new CrystalsMissions_2_6();

        else if (mission.equals("Missions_3_1")) return new CrystalsMissions_3_1();
        else if (mission.equals("Missions_3_2")) return new CrystalsMissions_3_2();
        else if (mission.equals("Missions_3_3")) return new CrystalsMissions_3_3();
        else if (mission.equals("Missions_3_4")) return new CrystalsMissions_3_4();
        else if (mission.equals("Missions_3_5")) return new CrystalsMissions_3_5();
        else if (mission.equals("Missions_3_6")) return new CrystalsMissions_3_6();

        else if (mission.equals("Missions_4_1")) return new CrystalsMissions_4_1();
        else if (mission.equals("Missions_4_2")) return new CrystalsMissions_4_2();
        else if (mission.equals("Missions_4_3")) return new CrystalsMissions_4_3();
        else if (mission.equals("Missions_4_4")) return new CrystalsMissions_4_4();
        else if (mission.equals("Missions_4_5")) return new CrystalsMissions_4_5();
        else if (mission.equals("Missions_4_6")) return new CrystalsMissions_4_6();

        else return null;
    }
}