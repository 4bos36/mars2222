package studio.rashka.lib.implement.aim;

import studio.rashka.lib.implement.aim.shoot.flare.ShootFlareGun_5;
import studio.rashka.lib.implement.aim.shoot.flare.ShootFlareGun_6;
import studio.rashka.lib.implement.aim.shoot.flare.ShootFlareGun_7;
import studio.rashka.lib.implement.aim.shoot.flare.ShootFlareGun_8;
import studio.rashka.lib.implement.aim.shoot.laser.ShootLaserGun_1;
import studio.rashka.lib.implement.aim.shoot.laser.ShootLaserGun_2;
import studio.rashka.lib.implement.aim.shoot.laser.ShootLaserGun_3;
import studio.rashka.lib.implement.aim.shoot.laser.ShootLaserGun_4;
import studio.rashka.lib.implement.aim.shoot.laser.ShootLaserGun_5;
import studio.rashka.lib.implement.aim.shoot.laser.ShootLaserGun_6;
import studio.rashka.lib.implement.aim.shoot.laser.ShootLaserGun_7;
import studio.rashka.lib.implement.aim.shoot.laser.ShootLaserGun_8;
import studio.rashka.lib.implement.aim.shoot.launcher.ShootLauncherGun_1;
import studio.rashka.lib.implement.aim.shoot.launcher.ShootLauncherGun_2;
import studio.rashka.lib.implement.aim.shoot.launcher.ShootLauncherGun_3;
import studio.rashka.lib.implement.aim.shoot.launcher.ShootLauncherGun_4;
import studio.rashka.lib.implement.aim.shoot.launcher.ShootLauncherGun_5;
import studio.rashka.lib.implement.aim.shoot.launcher.ShootLauncherGun_6;
import studio.rashka.lib.implement.aim.shoot.launcher.ShootLauncherGun_7;
import studio.rashka.lib.implement.aim.shoot.launcher.ShootLauncherGun_8;
import studio.rashka.lib.implement.aim.shoot.machine.ShootMachineGun_1;
import studio.rashka.lib.implement.aim.shoot.machine.ShootMachineGun_2;
import studio.rashka.lib.implement.aim.shoot.machine.ShootMachineGun_3;
import studio.rashka.lib.implement.aim.shoot.machine.ShootMachineGun_4;
import studio.rashka.lib.implement.aim.shoot.machine.ShootMachineGun_5;
import studio.rashka.lib.implement.aim.shoot.machine.ShootMachineGun_6;
import studio.rashka.lib.implement.aim.shoot.machine.ShootMachineGun_8;
import studio.rashka.lib.implement.aim.shoot.flare.ShootFlareGun_1;
import studio.rashka.lib.implement.aim.shoot.flare.ShootFlareGun_2;
import studio.rashka.lib.implement.aim.shoot.flare.ShootFlareGun_3;
import studio.rashka.lib.implement.aim.shoot.flare.ShootFlareGun_4;

public class CreateAim implements AbstractFactoryAim {

    @Override
    public Aims createAim(String type) {
        if (type.equals("MachineGun_1")) return new ShootMachineGun_1();
        else if (type.equals("MachineGun_2")) return new ShootMachineGun_2();
        else if (type.equals("MachineGun_3")) return new ShootMachineGun_3();
        else if (type.equals("MachineGun_4")) return new ShootMachineGun_4();
        else if (type.equals("MachineGun_5")) return new ShootMachineGun_5();
        else if (type.equals("MachineGun_6") || type.equals("MachineGun_7")) return new ShootMachineGun_6();
        else if (type.equals("MachineGun_8")) return new ShootMachineGun_8();
        else if (type.equals("LauncherGun_1")) return new ShootLauncherGun_1();
        else if (type.equals("LauncherGun_2")) return new ShootLauncherGun_2();
        else if (type.equals("LauncherGun_3")) return new ShootLauncherGun_3();
        else if (type.equals("LauncherGun_4")) return new ShootLauncherGun_4();
        else if (type.equals("LauncherGun_5")) return new ShootLauncherGun_5();
        else if (type.equals("LauncherGun_6")) return new ShootLauncherGun_6();
        else if (type.equals("LauncherGun_7")) return new ShootLauncherGun_7();
        else if (type.equals("LauncherGun_8")) return new ShootLauncherGun_8();
        else if (type.equals("FlareGun_1")) return new ShootFlareGun_1();
        else if (type.equals("FlareGun_2")) return new ShootFlareGun_2();
        else if (type.equals("FlareGun_3")) return new ShootFlareGun_3();
        else if (type.equals("FlareGun_4")) return new ShootFlareGun_4();
        else if (type.equals("FlareGun_5")) return new ShootFlareGun_5();
        else if (type.equals("FlareGun_6")) return new ShootFlareGun_6();
        else if (type.equals("FlareGun_7")) return new ShootFlareGun_7();
        else if (type.equals("FlareGun_8")) return new ShootFlareGun_8();
        else if (type.equals("LaserGun_1")) return new ShootLaserGun_1();
        else if (type.equals("LaserGun_2")) return new ShootLaserGun_2();
        else if (type.equals("LaserGun_3")) return new ShootLaserGun_3();
        else if (type.equals("LaserGun_4")) return new ShootLaserGun_4();
        else if (type.equals("LaserGun_5")) return new ShootLaserGun_5();
        else if (type.equals("LaserGun_6")) return new ShootLaserGun_6();
        else if (type.equals("LaserGun_7")) return new ShootLaserGun_7();
        else if (type.equals("LaserGun_8")) return new ShootLaserGun_8();
        return null;
    }
}