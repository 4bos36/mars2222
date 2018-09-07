package studio.rashka.lib.implement.guns;

import studio.rashka.models.arsenal.weapons.flareGun.FlareGun_1;
import studio.rashka.models.arsenal.weapons.flareGun.FlareGun_2;
import studio.rashka.models.arsenal.weapons.flareGun.FlareGun_3;
import studio.rashka.models.arsenal.weapons.flareGun.FlareGun_4;
import studio.rashka.models.arsenal.weapons.flareGun.FlareGun_5;
import studio.rashka.models.arsenal.weapons.flareGun.FlareGun_6;
import studio.rashka.models.arsenal.weapons.flareGun.FlareGun_7;
import studio.rashka.models.arsenal.weapons.flareGun.FlareGun_8;
import studio.rashka.models.arsenal.weapons.laserGun.LaserGun_1;
import studio.rashka.models.arsenal.weapons.laserGun.LaserGun_2;
import studio.rashka.models.arsenal.weapons.laserGun.LaserGun_3;
import studio.rashka.models.arsenal.weapons.laserGun.LaserGun_4;
import studio.rashka.models.arsenal.weapons.laserGun.LaserGun_5;
import studio.rashka.models.arsenal.weapons.laserGun.LaserGun_6;
import studio.rashka.models.arsenal.weapons.laserGun.LaserGun_7;
import studio.rashka.models.arsenal.weapons.laserGun.LaserGun_8;
import studio.rashka.models.arsenal.weapons.launcherGun.LauncherGun_1;
import studio.rashka.models.arsenal.weapons.launcherGun.LauncherGun_2;
import studio.rashka.models.arsenal.weapons.launcherGun.LauncherGun_3;
import studio.rashka.models.arsenal.weapons.launcherGun.LauncherGun_4;
import studio.rashka.models.arsenal.weapons.launcherGun.LauncherGun_5;
import studio.rashka.models.arsenal.weapons.launcherGun.LauncherGun_6;
import studio.rashka.models.arsenal.weapons.launcherGun.LauncherGun_7;
import studio.rashka.models.arsenal.weapons.launcherGun.LauncherGun_8;
import studio.rashka.models.arsenal.weapons.machineGun.MachineGun_1;
import studio.rashka.models.arsenal.weapons.machineGun.MachineGun_2;
import studio.rashka.models.arsenal.weapons.machineGun.MachineGun_3;
import studio.rashka.models.arsenal.weapons.machineGun.MachineGun_4;
import studio.rashka.models.arsenal.weapons.machineGun.MachineGun_5;
import studio.rashka.models.arsenal.weapons.machineGun.MachineGun_6;
import studio.rashka.models.arsenal.weapons.machineGun.MachineGun_7;
import studio.rashka.models.arsenal.weapons.machineGun.MachineGun_8;

public class CreateGun implements AbstractFactoryGuns {

    @Override
    public Guns createGuns(int type) {
        if (type == 1) return new MachineGun_1();
        else if (type == 2) return new MachineGun_2();
        else if (type == 3) return new MachineGun_3();
        else if (type == 4) return new MachineGun_4();
        else if (type == 5) return new MachineGun_5();
        else if (type == 6) return new MachineGun_6();
        else if (type == 7) return new MachineGun_7();
        else if (type == 8) return new MachineGun_8();
        else if (type == 9) return new LauncherGun_1();
        else if (type == 10) return new LauncherGun_2();
        else if (type == 11) return new LauncherGun_3();
        else if (type == 12) return new LauncherGun_4();
        else if (type == 13) return new LauncherGun_5();
        else if (type == 14) return new LauncherGun_6();
        else if (type == 15) return new LauncherGun_7();
        else if (type == 16) return new LauncherGun_8();
        else if (type == 17) return new FlareGun_1();
        else if (type == 18) return new FlareGun_2();
        else if (type == 19) return new FlareGun_3();
        else if (type == 20) return new FlareGun_4();
        else if (type == 21) return new FlareGun_5();
        else if (type == 22) return new FlareGun_6();
        else if (type == 23) return new FlareGun_7();
        else if (type == 24) return new FlareGun_8();
        else if (type == 25) return new LaserGun_1();
        else if (type == 26) return new LaserGun_2();
        else if (type == 27) return new LaserGun_3();
        else if (type == 28) return new LaserGun_4();
        else if (type == 29) return new LaserGun_5();
        else if (type == 30) return new LaserGun_6();
        else if (type == 31) return new LaserGun_7();
        else if (type == 32) return new LaserGun_8();
        else return null;
    }
}