package studio.rashka.models.arsenal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;

public class Weapons {

    private String nameWeapons = "NULL",
            money, mineral, energy;
    private int info = 0, form = 0;

    public Weapons() {

    }

    public void price() {
        //region MachineGun
        if (nameWeapons.equals("MachineGun_1")) {
            money = "0";
            mineral = "0";
            energy = "";
        } else if (nameWeapons.equals("MachineGun_2")) {
            money = "4350";
            mineral = "0";
            energy = "";
        } else if (nameWeapons.equals("MachineGun_3")) {
            money = "6750";
            mineral = "0";
            energy = "";
        } else if (nameWeapons.equals("MachineGun_4")) {
            money = "8150";
            mineral = "5";
            energy = "";
        } else if (nameWeapons.equals("MachineGun_5")) {
            money = "10650";
            mineral = "10";
            energy = "";
        } else if (nameWeapons.equals("MachineGun_6")) {
            money = "13350";
            mineral = "15";
            energy = "";
        } else if (nameWeapons.equals("MachineGun_7")) {
            money = "17000";
            mineral = "15";
            energy = "";
        } else if (nameWeapons.equals("MachineGun_8")) {
            money = "21500";
            mineral = "30";
            energy = "";
        }
        //endregion
        //region LauncherGun
        else if (nameWeapons.equals("LauncherGun_1")) {
            money = "4800";
            mineral = "10";
            energy = "";
        } else if (nameWeapons.equals("LauncherGun_2")) {
            money = "5500";
            mineral = "15";
            energy = "";
        } else if (nameWeapons.equals("LauncherGun_3")) {
            money = "7700";
            mineral = "25";
            energy = "";
        } else if (nameWeapons.equals("LauncherGun_4")) {
            money = "8250";
            mineral = "30";
            energy = "";
        } else if (nameWeapons.equals("LauncherGun_5")) {
            money = "11050";
            mineral = "35";
            energy = "";
        } else if (nameWeapons.equals("LauncherGun_6")) {
            money = "13850";
            mineral = "55";
            energy = "";
        } else if (nameWeapons.equals("LauncherGun_7")) {
            money = "16700";
            mineral = "55";
            energy = "";
        } else if (nameWeapons.equals("LauncherGun_8")) {
            money = "20000";
            mineral = "60";
            energy = "";
        }
        //endregion
        //region FlareGun
        else if (nameWeapons.equals("FlareGun_1")) {
            money = "2250";
            mineral = "80";
            energy = "";
        } else if (nameWeapons.equals("FlareGun_2")) {
            money = "3300";
            mineral = "110";
            energy = "";
        } else if (nameWeapons.equals("FlareGun_3")) {
            money = "3900";
            mineral = "145";
            energy = "";
        } else if (nameWeapons.equals("FlareGun_4")) {
            money = "5050";
            mineral = "190";
            energy = "";
        } else if (nameWeapons.equals("FlareGun_5")) {
            money = "8700";
            mineral = "225";
            energy = "";
        } else if (nameWeapons.equals("FlareGun_6")) {
            money = "11400";
            mineral = "290";
            energy = "";
        } else if (nameWeapons.equals("FlareGun_7")) {
            money = "14250";
            mineral = "335";
            energy = "";
        } else if (nameWeapons.equals("FlareGun_8")) {
            money = "17050";
            mineral = "385";
            energy = "";
        }
        //endregion
        //region LaserGun
        else if (nameWeapons.equals("LaserGun_1")) {
            money = "1850";
            mineral = "145";
            energy = "2";
        } else if (nameWeapons.equals("LaserGun_2")) {
            money = "2350";
            mineral = "175";
            energy = "2";
        } else if (nameWeapons.equals("LaserGun_3")) {
            money = "2800";
            mineral = "250";
            energy = "1";
        } else if (nameWeapons.equals("LaserGun_4")) {
            money = "3250";
            mineral = "310";
            energy = "1";
        } else if (nameWeapons.equals("LaserGun_5")) {
            money = "3500";
            mineral = "425";
            energy = "1";
        } else if (nameWeapons.equals("LaserGun_6")) {
            money = "6100";
            mineral = "465";
            energy = "2";
        } else if (nameWeapons.equals("LaserGun_7")) {
            money = "10000";
            mineral = "500";
            energy = "3";
        } else if (nameWeapons.equals("LaserGun_8")) {
            money = "14000";
            mineral = "550";
            energy = "4";
        }
        //endregion
        else if (nameWeapons.equals("NULL")) {
            money = "0";
            mineral = "0";
        }
    }

    public void priceTower() {
        //region MachineGun
        if (nameWeapons.equals("MachineGun_1")) {
            money = "0";
            mineral = "0";
        } else if (nameWeapons.equals("MachineGun_2")) {
            money = "350";
            mineral = "250";
        } else if (nameWeapons.equals("MachineGun_3")) {
            money = "675";
            mineral = "320";
        } else if (nameWeapons.equals("MachineGun_4")) {
            money = "815";
            mineral = "500";
        } else if (nameWeapons.equals("MachineGun_5")) {
            money = "1065";
            mineral = "570";
        } else if (nameWeapons.equals("MachineGun_6")) {
            money = "1330";
            mineral = "615";
        } else if (nameWeapons.equals("MachineGun_7")) {
            money = "1700";
            mineral = "680";
        } else if (nameWeapons.equals("MachineGun_8")) {
            money = "2150";
            mineral = "730";
        }
        //endregion
        //region LauncherGun
        else if (nameWeapons.equals("LauncherGun_1")) {
            money = "0";
            mineral = "0";
        } else if (nameWeapons.equals("LauncherGun_2")) {
            money = "550";
            mineral = "415";
        } else if (nameWeapons.equals("LauncherGun_3")) {
            money = "770";
            mineral = "530";
        } else if (nameWeapons.equals("LauncherGun_4")) {
            money = "870";
            mineral = "580";
        } else if (nameWeapons.equals("LauncherGun_5")) {
            money = "1150";
            mineral = "645";
        } else if (nameWeapons.equals("LauncherGun_6")) {
            money = "1380";
            mineral = "705";
        } else if (nameWeapons.equals("LauncherGun_7")) {
            money = "1670";
            mineral = "760";
        } else if (nameWeapons.equals("LauncherGun_8")) {
            money = "2100";
            mineral = "795";
        }
        //endregion
        //region FlareGun
        else if (nameWeapons.equals("FlareGun_1")) {
            money = "0";
            mineral = "0";
        } else if (nameWeapons.equals("FlareGun_2")) {
            money = "610";
            mineral = "460";
        } else if (nameWeapons.equals("FlareGun_3")) {
            money = "830";
            mineral = "590";
        } else if (nameWeapons.equals("FlareGun_4")) {
            money = "925";
            mineral = "605";
        } else if (nameWeapons.equals("FlareGun_5")) {
            money = "1300";
            mineral = "695";
        } else if (nameWeapons.equals("FlareGun_6")) {
            money = "1440";
            mineral = "745";
        } else if (nameWeapons.equals("FlareGun_7")) {
            money = "1650";
            mineral = "805";
            energy = "";
        } else if (nameWeapons.equals("FlareGun_8")) {
            money = "2100";
            mineral = "840";
            energy = "";
        }
        //endregion
        //region LaserGun
        else if (nameWeapons.equals("LaserGun_1")) {
            money = "0";
            mineral = "0";
        } else if (nameWeapons.equals("LaserGun_2")) {
            money = "800";
            mineral = "500";
        } else if (nameWeapons.equals("LaserGun_3")) {
            money = "1250";
            mineral = "645";
        } else if (nameWeapons.equals("LaserGun_4")) {
            money = "1400";
            mineral = "735";
        } else if (nameWeapons.equals("LaserGun_5")) {
            money = "1555";
            mineral = "780";
        } else if (nameWeapons.equals("LaserGun_6")) {
            money = "1700";
            mineral = "820";
        } else if (nameWeapons.equals("LaserGun_7")) {
            money = "1870";
            mineral = "885";
        } else if (nameWeapons.equals("LaserGun_8")) {
            money = "2250";
            mineral = "1000";
        }
        //endregion
        else if (nameWeapons.equals("NULL")) {
            money = "0";
            mineral = "0";
        }
    }

    private void non(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    //region Пулемёты
    private void machineGun_1(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_1"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_1"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void machineGun_2(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_2"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_2"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void machineGun_3(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_3"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_3"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void machineGun_4(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_4"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_4"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void machineGun_5(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_5"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_5"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void machineGun_6(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_6"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_6"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void machineGun_7(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_7"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_7"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void machineGun_8(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_8"), MarsGame.WIDTH - 416 - form, 256 + MarsGame.getRatioAdd(), 192, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("MachineGun_8"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }
    //endregion
    //region Гранатомёты
    private void launcherGun_1(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_1"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_1"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void launcherGun_2(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_2"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_2"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void launcherGun_3(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_3"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_3"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void launcherGun_4(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_4"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_4"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void launcherGun_5(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_5"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_5"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void launcherGun_6(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_6"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_6"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void launcherGun_7(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_7"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_7"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void launcherGun_8(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_8"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("LauncherGun_8"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }
    //endregion
    //region Ракетницы
    private void flareGun_1(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_1"), MarsGame.WIDTH - 416 - form, 360 + MarsGame.getRatioAdd(), 192, 240);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_1"), 160, MarsGame.HEIGHT - 462, 64, 80, 128, 160, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void flareGun_2(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_2"), MarsGame.WIDTH - 416 - form, 360 + MarsGame.getRatioAdd(), 192, 240);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_2"), 160, MarsGame.HEIGHT - 462, 64, 80, 128, 160, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void flareGun_3(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_3"), MarsGame.WIDTH - 416 - form, 256 + MarsGame.getRatioAdd(), 192, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_3"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void flareGun_4(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_4"), MarsGame.WIDTH - 416 - form, 360 + MarsGame.getRatioAdd(), 192, 192);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_4"), 160, MarsGame.HEIGHT - 447, 64, 64, 128, 128, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void flareGun_5(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_5"), MarsGame.WIDTH - 416 - form, 256 + MarsGame.getRatioAdd(), 192, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_5"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void flareGun_6(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_6"), MarsGame.WIDTH - 416 - form, 360 + MarsGame.getRatioAdd(), 192, 192);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_6"), 160, MarsGame.HEIGHT - 447, 64, 64, 128, 128, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void flareGun_7(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_7"), MarsGame.WIDTH - 416 - form, 256 + MarsGame.getRatioAdd(), 192, 384);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_7"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void flareGun_8(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_8"), MarsGame.WIDTH - 448 - form, 328 + MarsGame.getRatioAdd(), 256, 256);
        if (form == 0) batch.draw(Textures.getInstance().textureRegionScreen.get("FlareGun_8"), 160, MarsGame.HEIGHT - 447, 64, 64, 128, 128, 1, 1, 90);

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }
    //endregion
    //region Лазеры
    private void laserGun_1(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_1"), MarsGame.WIDTH - 416 - form, 256 + MarsGame.getRatioAdd(), 192, 384);
        if (form == 0) {
            batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_1"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);
            batch.draw(Textures.getInstance().textureRegionScreen.get("EnergyWeapon"), MarsGame.WIDTH - 488, 222 + MarsGame.getRatioAdd(), 32, 32);
        }

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void laserGun_2(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_2"), MarsGame.WIDTH - 416 - form, 256 + MarsGame.getRatioAdd(), 192, 384);
        if (form == 0) {
            batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_2"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);
            batch.draw(Textures.getInstance().textureRegionScreen.get("EnergyWeapon"), MarsGame.WIDTH - 488, 222 + MarsGame.getRatioAdd(), 32, 32);
        }

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void laserGun_3(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_3"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) {
            batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_3"), 160, MarsGame.HEIGHT - 504, 61, 128, 102, 256, 1, 1, 90);
            batch.draw(Textures.getInstance().textureRegionScreen.get("EnergyWeapon"), MarsGame.WIDTH - 488, 222 + MarsGame.getRatioAdd(), 32, 32);
        }

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void laserGun_4(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_4"), MarsGame.WIDTH - 416 - form, 256 + MarsGame.getRatioAdd(), 192, 384);
        if (form == 0) {
            batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_4"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);
            batch.draw(Textures.getInstance().textureRegionScreen.get("EnergyWeapon"), MarsGame.WIDTH - 488, 222 + MarsGame.getRatioAdd(), 32, 32);
        }

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void laserGun_5(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_5"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) {
            batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_5"), 160, MarsGame.HEIGHT - 504, 61, 128, 102, 256, 1, 1, 90);
            batch.draw(Textures.getInstance().textureRegionScreen.get("EnergyWeapon"), MarsGame.WIDTH - 488, 222 + MarsGame.getRatioAdd(), 32, 32);
        }

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void laserGun_6(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_6"), MarsGame.WIDTH - 416 - form, 256 + MarsGame.getRatioAdd(), 192, 384);
        if (form == 0) {
            batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_6"), 160, MarsGame.HEIGHT - 510, 64, 128, 128, 256, 1, 1, 90);
            batch.draw(Textures.getInstance().textureRegionScreen.get("EnergyWeapon"), MarsGame.WIDTH - 488, 222 + MarsGame.getRatioAdd(), 32, 32);
        }

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void laserGun_7(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_7"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) {
            batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_7"), 160, MarsGame.HEIGHT - 504, 61, 128, 102, 256, 1, 1, 90);
            batch.draw(Textures.getInstance().textureRegionScreen.get("EnergyWeapon"), MarsGame.WIDTH - 488, 222 + MarsGame.getRatioAdd(), 32, 32);
        }

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }

    private void laserGun_8(SpriteBatch batch) {
        batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_8"), MarsGame.WIDTH - 397 - form, 256 + MarsGame.getRatioAdd(), 154, 384);
        if (form == 0) {
            batch.draw(Textures.getInstance().textureRegionScreen.get("LaserGun_8"), 160, MarsGame.HEIGHT - 504, 61, 128, 102, 256, 1, 1, 90);
            batch.draw(Textures.getInstance().textureRegionScreen.get("EnergyWeapon"), MarsGame.WIDTH - 488, 222 + MarsGame.getRatioAdd(), 32, 32);
        }

        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 350, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 380, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 410, 200, 24);
        batch.draw(Textures.getInstance().textureRegion.get("ColorBlack"), 560 - info, MarsGame.HEIGHT - 440, 200, 24);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 702 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 722 - info, MarsGame.HEIGHT - 348, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 348, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 642 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 662 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 378, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 378, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 682 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 702 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 722 - info, MarsGame.HEIGHT - 408, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 408, 16, 20);

        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 562 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 582 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 602 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 622 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 642 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 662 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 682 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 702 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorGreen"), 722 - info, MarsGame.HEIGHT - 438, 16, 20);
        batch.draw(Textures.getInstance().textureRegion.get("ColorRed"), 742 - info, MarsGame.HEIGHT - 438, 16, 20);

        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotPower"), 524 - info, MarsGame.HEIGHT - 352, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotSpeed"), 524 - info, MarsGame.HEIGHT - 382, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotRange"), 524 - info, MarsGame.HEIGHT - 412, 28, 28);
        batch.draw(Textures.getInstance().textureRegionScreen.get("ShotDistance"), 524 - info, MarsGame.HEIGHT - 442, 28, 28);
    }
    //endregion

    public void render(SpriteBatch batch) {
        if (nameWeapons.equals("MachineGun_1")) machineGun_1(batch);
        else if (nameWeapons.equals("MachineGun_2")) machineGun_2(batch);
        else if (nameWeapons.equals("MachineGun_3")) machineGun_3(batch);
        else if (nameWeapons.equals("MachineGun_4")) machineGun_4(batch);
        else if (nameWeapons.equals("MachineGun_5")) machineGun_5(batch);
        else if (nameWeapons.equals("MachineGun_6")) machineGun_6(batch);
        else if (nameWeapons.equals("MachineGun_7")) machineGun_7(batch);
        else if (nameWeapons.equals("MachineGun_8")) machineGun_8(batch);
        else if (nameWeapons.equals("LauncherGun_1")) launcherGun_1(batch);
        else if (nameWeapons.equals("LauncherGun_2")) launcherGun_2(batch);
        else if (nameWeapons.equals("LauncherGun_3")) launcherGun_3(batch);
        else if (nameWeapons.equals("LauncherGun_4")) launcherGun_4(batch);
        else if (nameWeapons.equals("LauncherGun_5")) launcherGun_5(batch);
        else if (nameWeapons.equals("LauncherGun_6")) launcherGun_6(batch);
        else if (nameWeapons.equals("LauncherGun_7")) launcherGun_7(batch);
        else if (nameWeapons.equals("LauncherGun_8")) launcherGun_8(batch);
        else if (nameWeapons.equals("FlareGun_1")) flareGun_1(batch);
        else if (nameWeapons.equals("FlareGun_2")) flareGun_2(batch);
        else if (nameWeapons.equals("FlareGun_3")) flareGun_3(batch);
        else if (nameWeapons.equals("FlareGun_4")) flareGun_4(batch);
        else if (nameWeapons.equals("FlareGun_5")) flareGun_5(batch);
        else if (nameWeapons.equals("FlareGun_6")) flareGun_6(batch);
        else if (nameWeapons.equals("FlareGun_7")) flareGun_7(batch);
        else if (nameWeapons.equals("FlareGun_8")) flareGun_8(batch);
        else if (nameWeapons.equals("LaserGun_1")) laserGun_1(batch);
        else if (nameWeapons.equals("LaserGun_2")) laserGun_2(batch);
        else if (nameWeapons.equals("LaserGun_3")) laserGun_3(batch);
        else if (nameWeapons.equals("LaserGun_4")) laserGun_4(batch);
        else if (nameWeapons.equals("LaserGun_5")) laserGun_5(batch);
        else if (nameWeapons.equals("LaserGun_6")) laserGun_6(batch);
        else if (nameWeapons.equals("LaserGun_7")) laserGun_7(batch);
        else if (nameWeapons.equals("LaserGun_8")) laserGun_8(batch);
        else if (nameWeapons.equals("NULL")) non(batch);
    }

    public void setNameWeapons(String nameWeapons) {
        this.nameWeapons = nameWeapons;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public String getNameWeapons() {
        return nameWeapons;
    }

    public String getMoney() {
        return money;
    }

    public String getMineral() {
        return mineral;
    }

    public String getEnergy() {
        return energy;
    }
}