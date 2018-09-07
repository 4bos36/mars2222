package studio.rashka.models.arsenal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import studio.rashka.MarsGame;

public class Tactics {

    private String nameTactic = "NULL", nameTacticObject = "NULL",
            money, mineral;
    private boolean touchTurnOffTerminal = false, buyShow = false;
    private float buyPositionX = 0, buyWidth = 0;

    public Tactics() {

    }

    public void priceAttack() {
        if (nameTacticObject.equals("AttackStart")) {
            money = "20";
            mineral = "2";
        } else if (nameTacticObject.equals("AttackGenerator")) {
            money = "2500";
            mineral = "100";
        } else if (nameTacticObject.equals("AttackGeneratorPowerShot")) {
            money = "1000";
            mineral = "33";
        } else if (nameTacticObject.equals("AttackGeneratorEnergy")) {
            money = "450";
            mineral = "55";
        } else if (nameTacticObject.equals("AttackPowerShot")) {
            money = "750";
            mineral = "40";
        } else if (nameTacticObject.equals("AttackLauncherGun")) {
            money = "6000";
            mineral = "250";
        } else if (nameTacticObject.equals("AttackLauncherGunEnergy")) {
            money = "1350";
            mineral = "70";
        } else if (nameTacticObject.equals("AttackFlareGun")) {
            money = "8500";
            mineral = "350";
        } else if (nameTacticObject.equals("AttackFlareGunEnergy")) {
            money = "1850";
            mineral = "85";
        } else if (nameTacticObject.equals("AttackLaserGun")) {
            money = "2500";
            mineral = "1250";
        } else if (nameTacticObject.equals("AttackLaserGunEnergy")) {
            money = "750";
            mineral = "285";
        } else if (nameTacticObject.equals("NULL")) {
            money = "0";
            mineral = "0";
        }
    }

    public void priceDefense() {
        if (nameTacticObject.equals("DefenseStart")) {
            money = "20";
            mineral = "2";
        } else if (nameTacticObject.equals("DefenseGenerator")) {
            money = "2500";
            mineral = "100";
        } else if (nameTacticObject.equals("DefenseGeneratorPowerShield")) {
            money = "1000";
            mineral = "33";
        } else if (nameTacticObject.equals("DefenseGeneratorEnergy")) {
            money = "450";
            mineral = "55";
        } else if (nameTacticObject.equals("DefenseHeartLife")) {
            money = "1350";
            mineral = "52";
        } else if (nameTacticObject.equals("DefenseShieldHP")) {
            money = "1800";
            mineral = "205";
        } else if (nameTacticObject.equals("DefenseShieldHPup")) {
            money = "1150";
            mineral = "75";
        } else if (nameTacticObject.equals("DefenseEnergy")) {
            money = "1800";
            mineral = "205";
        } else if (nameTacticObject.equals("DefenseEnergyUp")) {
            money = "1150";
            mineral = "75";
        } else if (nameTacticObject.equals("DefenseMicrowave")) {
            money = "1800";
            mineral = "205";
        } else if (nameTacticObject.equals("DefenseMicrowaveUp")) {
            money = "800";
            mineral = "105";
        } else if (nameTacticObject.equals("NULL")) {
            money = "0";
            mineral = "0";
        }
    }

    public void priceTechnologies() {
        if (nameTacticObject.equals("TechnologiesStart")) {
            money = "20";
            mineral = "2";
        } else if (nameTacticObject.equals("TechnologiesRadar")) {
            money = "4500";
            mineral = "70";
        } else if (nameTacticObject.equals("TechnologiesShowMonsterLife")) {
            money = "350";
            mineral = "250";
        } else if (nameTacticObject.equals("TechnologiesRadarEnergy")) {
            money = "450";
            mineral = "55";
        } else if (nameTacticObject.equals("TechnologiesRobot")) {
            money = "1000";
            mineral = "1000";
        } else if (nameTacticObject.equals("TechnologiesPower")) {
            money = "2500";
            mineral = "170";
        } else if (nameTacticObject.equals("TechnologiesPowerEnergy")) {
            money = "1050";
            mineral = "20";
        } else if (nameTacticObject.equals("TechnologiesCarryingCapacity")) {
            money = "250";
            mineral = "410";
        } else if (nameTacticObject.equals("TechnologiesRobotSpeed")) {
            money = "650";
            mineral = "125";
        } else if (nameTacticObject.equals("TechnologiesConverter")) {
            money = "2500";
            mineral = "1250";
        } else if (nameTacticObject.equals("TechnologiesConverterLife")) {
            money = "1350";
            mineral = "108";
        } else if (nameTacticObject.equals("NULL")) {
            money = "0";
            mineral = "0";
        }
    }

    public void priceReset() {
            money = "100";
            mineral = "5";
    }

    private void attack(SpriteBatch batch) {
        batch.draw(MarsGame.getTextures().textureRegion.get("ColorBlack"), 0, 0, MarsGame.WIDTH, MarsGame.HEIGHT);

        if (!MarsGame.getPreference().getTacticsAttackStart()) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), 242, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 380); // до Generator
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), 242, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 280, 4);
        }
        else {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), 242, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 380); // до Generator
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), 242, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 280, 4);
        }
        if (!MarsGame.getPreference().getTacticsAttackGenerator()) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 - 372, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 250); // от Generator до его улучшений
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 - 435, MarsGame.HEIGHT / 2 + 168 + MarsGame.getRatioAdd() / 2, 150, 4);
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 - 307, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // от Generator до DamageX2
        }
        else {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 - 372, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 250); // от Generator до его улучшений
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 - 435, MarsGame.HEIGHT / 2 + 168 + MarsGame.getRatioAdd() / 2, 150, 4);
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 - 307, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // от Generator до DamageX2
        }
        if (MarsGame.getPreference().getTacticsAttackPowerShot() == 0) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 4, 416); // от DamageX2 до пушек // вертикальная
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 100, 4); // 1
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 14, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // 2
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 100, 4); // 3
        }
        else if (MarsGame.getPreference().getTacticsAttackPowerShot() > 0) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 4, 416); // от DamageX2 до пушек // вертикальная
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 100, 4); // 1
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 14, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // 2
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 100, 4); // 3
        }
        if (!MarsGame.getPreference().getTacticsAttackLauncherGun()) batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 1
        else batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 1
        if (!MarsGame.getPreference().getTacticsAttackFlareGun()) batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 2
        else batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 2
        if (!MarsGame.getPreference().getTacticsAttackLaserGun()) batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 3
        else batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 3

        if (nameTacticObject.equals("AttackGeneratorPowerShot")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 570, MarsGame.HEIGHT / 2 + 100 + MarsGame.getRatioAdd() / 2, 140, 140); // Percent
        else if (nameTacticObject.equals("AttackGeneratorEnergy")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 310, MarsGame.HEIGHT / 2 + 100 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown
        else if (nameTacticObject.equals("AttackGenerator")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 440, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // Generator
        else if (nameTacticObject.equals("AttackPowerShot")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 130, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // DamageX2
        else if (nameTacticObject.equals("AttackLauncherGun")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 180, MarsGame.HEIGHT / 2 + 60 + MarsGame.getRatioAdd() / 2, 140, 140); // LauncherGunDTAttack
        else if (nameTacticObject.equals("AttackLauncherGunEnergy")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 490, MarsGame.HEIGHT / 2 + 60 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown
        else if (nameTacticObject.equals("AttackFlareGun")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 180, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // FlareGunDTAttack
        else if (nameTacticObject.equals("AttackFlareGunEnergy")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 490, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown
        else if (nameTacticObject.equals("AttackLaserGun")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 180, MarsGame.HEIGHT / 2 - 360 + MarsGame.getRatioAdd() / 2, 140, 140); // LaserGunDTAttack
        else if (nameTacticObject.equals("AttackLaserGunEnergy")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 490, MarsGame.HEIGHT / 2 - 360 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Attack"), 184, MarsGame.HEIGHT - 312, 120, 120);
        if (!touchTurnOffTerminal) batch.draw(MarsGame.getTextures().textureRegion.get("TurnOff"), MarsGame.WIDTH - 120, MarsGame.HEIGHT - 256, 64, 64);
        else batch.draw(MarsGame.getTextures().textureRegion.get("TurnOff"), MarsGame.WIDTH - 117, MarsGame.HEIGHT - 253, 58, 58);

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Percent"), MarsGame.WIDTH / 2 - 580, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("EnergyDown"), MarsGame.WIDTH / 2 - 320, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Generator"), MarsGame.WIDTH / 2 - 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("DamageX2"), MarsGame.WIDTH / 2 - 140, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("LauncherGunDTAttack"), MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("EnergyDown"), MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("FlareGunDTAttack"), MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("EnergyDown"), MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("LaserGunDTAttack"), MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("EnergyDown"), MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2, 160, 160);
    }

    private void defense(SpriteBatch batch) {
        batch.draw(MarsGame.getTextures().textureRegion.get("ColorBlack"), 0, 0, MarsGame.WIDTH, MarsGame.HEIGHT);

        if (!MarsGame.getPreference().getTacticsDefenseStart()) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), 242, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 380); // до Generator
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), 242, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 280, 4);
        }
        else {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), 242, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 380); // до Generator
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), 242, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 280, 4);
        }
        if (!MarsGame.getPreference().getTacticsDefenseGenerator()) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 - 372, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 250); // от Generator до его улучшений
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 - 435, MarsGame.HEIGHT / 2 + 168 + MarsGame.getRatioAdd() / 2, 150, 4);
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 - 307, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // от Generator до DamageX2
        }
        else {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 - 372, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 250); // от Generator до его улучшений
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 - 435, MarsGame.HEIGHT / 2 + 168 + MarsGame.getRatioAdd() / 2, 150, 4);
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 - 307, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // от Generator до DamageX2
        }
        if (MarsGame.getPreference().getTacticsDefenseHeartLife() <= 30) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 4, 416); // от Life до пушек // вертикальная
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 100, 4); // 1
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 14, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // 2
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 100, 4); // 3
        }
        else if (MarsGame.getPreference().getTacticsDefenseHeartLife() > 30) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 4, 416); // от Life до пушек // вертикальная
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 100, 4); // 1
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 14, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // 2
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 100, 4); // 3
        }
        if (!MarsGame.getPreference().getTacticsDefenseShieldHP()) batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 1
        else batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 1
        if (!MarsGame.getPreference().getTacticsDefenseEnergy()) batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 2
        else batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 2
        if (!MarsGame.getPreference().getTacticsDefenseMicrowave()) batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 3
        else batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 3

        if (nameTacticObject.equals("DefenseGeneratorPowerShield")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 570, MarsGame.HEIGHT / 2 + 100 + MarsGame.getRatioAdd() / 2, 140, 140); // Percent
        else if (nameTacticObject.equals("DefenseGeneratorEnergy")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 310, MarsGame.HEIGHT / 2 + 100 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown
        else if (nameTacticObject.equals("DefenseGenerator")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 440, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // Generator
        else if (nameTacticObject.equals("DefenseHeartLife")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 130, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // Life
        else if (nameTacticObject.equals("DefenseShieldHP")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 180, MarsGame.HEIGHT / 2 + 60 + MarsGame.getRatioAdd() / 2, 140, 140); // DefenseShieldHP
        else if (nameTacticObject.equals("DefenseShieldHPup")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 490, MarsGame.HEIGHT / 2 + 60 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown
        else if (nameTacticObject.equals("DefenseEnergy")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 180, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // DefenseEnergy
        else if (nameTacticObject.equals("DefenseEnergyUp")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 490, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown
        else if (nameTacticObject.equals("DefenseRocks")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 180, MarsGame.HEIGHT / 2 - 360 + MarsGame.getRatioAdd() / 2, 140, 140); // DefenseRocks
        else if (nameTacticObject.equals("DefenseRocksUp")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 490, MarsGame.HEIGHT / 2 - 360 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Defense"), 184, MarsGame.HEIGHT - 312, 120, 120);
        if (!touchTurnOffTerminal) batch.draw(MarsGame.getTextures().textureRegion.get("TurnOff"), MarsGame.WIDTH - 120, MarsGame.HEIGHT - 256, 64, 64);
        else batch.draw(MarsGame.getTextures().textureRegion.get("TurnOff"), MarsGame.WIDTH - 117, MarsGame.HEIGHT - 253, 58, 58);

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Percent"), MarsGame.WIDTH / 2 - 580, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("EnergyDown"), MarsGame.WIDTH / 2 - 320, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Generator"), MarsGame.WIDTH / 2 - 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Heart"), MarsGame.WIDTH / 2 - 140, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("DefenseShieldHP"), MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Percent"), MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("DefenseEnergy"), MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Percent"), MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("DefenseMicrowave"), MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Percent"), MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2, 160, 160);
    }

    private void technologies(SpriteBatch batch) {
        batch.draw(MarsGame.getTextures().textureRegion.get("ColorBlack"), 0, 0, MarsGame.WIDTH, MarsGame.HEIGHT);

        if (!MarsGame.getPreference().getTacticsTechnologiesStart()) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), 242, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 380); // до Generator
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), 242, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 280, 4);
        }
        else {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), 242, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 380); // до Generator
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), 242, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 280, 4);
        }
        if (!MarsGame.getPreference().getTacticsTechnologiesRadar()) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 - 372, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 250); // от Generator до его улучшений
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 - 435, MarsGame.HEIGHT / 2 + 168 + MarsGame.getRatioAdd() / 2, 150, 4);
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 - 307, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // от Generator до DamageX2
        }
        else {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 - 372, MarsGame.HEIGHT / 2 - 80 + MarsGame.getRatioAdd() / 2, 4, 250); // от Generator до его улучшений
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 - 435, MarsGame.HEIGHT / 2 + 168 + MarsGame.getRatioAdd() / 2, 150, 4);
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 - 307, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // от Generator до DamageX2
        }
        if (MarsGame.getPreference().getTacticsTechnologiesRobot() <= 2) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 4, 416); // от DamageX2 до пушек // вертикальная
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 100, 4); // 1
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 14, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // 2
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 100, 4); // 3
        }
        else {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 4, 416); // от DamageX2 до пушек // вертикальная
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 100, 4); // 1
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 14, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // 2
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 88, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 100, 4); // 3
        }
        if (!MarsGame.getPreference().getTacticsTechnologiesPower()) batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 1
        else batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 + 128 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 1
        if (MarsGame.getPreference().getTacticsTechnologiesCarryingCapacity() <= 2) batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 2
        else batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 82 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 2
        if (!MarsGame.getPreference().getTacticsTechnologiesConverter()) batch.draw(MarsGame.getTextures().textureRegion.get("ColorRed"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 3
        else batch.draw(MarsGame.getTextures().textureRegion.get("ColorGreen"), MarsGame.WIDTH / 2 + 314, MarsGame.HEIGHT / 2 - 288 + MarsGame.getRatioAdd() / 2, 180, 4); // EnergyDown 3

        if (nameTacticObject.equals("TechnologiesShowMonsterLife")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 570, MarsGame.HEIGHT / 2 + 100 + MarsGame.getRatioAdd() / 2, 140, 140); // Percent
        else if (nameTacticObject.equals("TechnologiesRadarEnergy")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 310, MarsGame.HEIGHT / 2 + 100 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown
        else if (nameTacticObject.equals("TechnologiesRadar")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 440, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // Generator
        else if (nameTacticObject.equals("TechnologiesRobot")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 - 130, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // DamageX2
        else if (nameTacticObject.equals("TechnologiesPower")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 180, MarsGame.HEIGHT / 2 + 60 + MarsGame.getRatioAdd() / 2, 140, 140); // LauncherGunDTAttack
        else if (nameTacticObject.equals("TechnologiesPowerEnergy")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 490, MarsGame.HEIGHT / 2 + 60 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown
        else if (nameTacticObject.equals("TechnologiesCarryingCapacity")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 180, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // FlareGunDTAttack
        else if (nameTacticObject.equals("TechnologiesRobotSpeed")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 490, MarsGame.HEIGHT / 2 - 150 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown
        else if (nameTacticObject.equals("TechnologiesConverter")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 180, MarsGame.HEIGHT / 2 - 360 + MarsGame.getRatioAdd() / 2, 140, 140); // LaserGunDTAttack
        else if (nameTacticObject.equals("TechnologiesConverterLife")) batch.draw(MarsGame.getTextures().textureRegion.get("LightbulbGreenMini"), MarsGame.WIDTH / 2 + 490, MarsGame.HEIGHT / 2 - 360 + MarsGame.getRatioAdd() / 2, 140, 140); // EnergyDown

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Technologies"), 184, MarsGame.HEIGHT - 312, 120, 120);
        if (!touchTurnOffTerminal) batch.draw(MarsGame.getTextures().textureRegion.get("TurnOff"), MarsGame.WIDTH - 120, MarsGame.HEIGHT - 256, 64, 64);
        else batch.draw(MarsGame.getTextures().textureRegion.get("TurnOff"), MarsGame.WIDTH - 117, MarsGame.HEIGHT - 253, 58, 58);

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("TechnologiesShowLife"), MarsGame.WIDTH / 2 - 580, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("EnergyDown"), MarsGame.WIDTH / 2 - 320, MarsGame.HEIGHT / 2 + 90 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("TechnologiesRadar"), MarsGame.WIDTH / 2 - 450, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("TechnologiesRobotWorking"), MarsGame.WIDTH / 2 - 140, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);

        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Generator"), MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("TechnologiesEnergyAdd"), MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 + 50 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("TechnologiesRobotWorkingPower"), MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("TechnologiesRobotWorkingSpeed"), MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 - 160 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("Generator"), MarsGame.WIDTH / 2 + 170, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2, 160, 160);
        batch.draw(MarsGame.getTextures().textureRegionScreen.get("TechnologiesEnergyToLife"), MarsGame.WIDTH / 2 + 480, MarsGame.HEIGHT / 2 - 370 + MarsGame.getRatioAdd() / 2, 160, 160);
    }

    public void render(SpriteBatch batch) {
        if (nameTactic.equals("Attack")) attack(batch);
        else if (nameTactic.equals("Defense")) defense(batch);
        else if (nameTactic.equals("Technologies")) technologies(batch);

        if (buyShow) {
            batch.draw(MarsGame.getTextures().textureRegion.get("ColorOrange"), MarsGame.WIDTH / 2 - 296, 196 + MarsGame.getRatioAdd(), 307, 82);
            batch.draw(MarsGame.getTextures().textureRegion.get("Money"), MarsGame.WIDTH / 2 - 190, 212 + MarsGame.getRatioAdd(), 45, 45);
            batch.draw(MarsGame.getTextures().textureRegion.get("Mineral"), MarsGame.WIDTH / 2 - 135, 212 + MarsGame.getRatioAdd(), 50, 50);

            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonFon"), buyPositionX / MarsGame.getRatioMonitorW() - 6, 310 + MarsGame.getRatioAdd(), buyWidth / MarsGame.getRatioMonitorW() + 10, 39);
            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonL"), buyPositionX / MarsGame.getRatioMonitorW() - 10, 307 + MarsGame.getRatioAdd(), 34, 45);
            batch.draw(MarsGame.getTextures().textureRegion.get("MenuButtonR"), (buyPositionX + buyWidth) / MarsGame.getRatioMonitorW() - 25, 307 + MarsGame.getRatioAdd(), 34, 45);
        }
    }

    public void setNameTactic(String nameTactic) {
        this.nameTactic = nameTactic;
    }

    public String getNameTactic() {
        return nameTactic;
    }

    public void setNameTacticObject(String nameTacticObject) {
        this.nameTacticObject = nameTacticObject;
    }

    public String getNameTacticObject() {
        return nameTacticObject;
    }

    public String getMoney() {
        return money;
    }

    public String getMineral() {
        return mineral;
    }

    public void setBuyShow(boolean buyShow) {
        this.buyShow = buyShow;
    }

    public void setBuyPositionX(float buyPositionX) {
        this.buyPositionX = buyPositionX;
    }

    public void setBuyWidth(float buyWidth) {
        this.buyWidth = buyWidth;
    }

    public void setTouchTurnOffTerminal(boolean touchTurnOffTerminal) {
        this.touchTurnOffTerminal = touchTurnOffTerminal;
    }
}