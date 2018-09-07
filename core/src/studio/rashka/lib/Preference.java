package studio.rashka.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import studio.rashka.MarsGame;

public class Preference {

    private Preferences setting;
    public float taskGame;
    public boolean isPlay = true;

    public Preference() {
        setting = Gdx.app.getPreferences("Pref_Mars2222"); // настройки приложения
        //setting.clear(); // если изменили тип данных, то разкомментироветь, запускаем и комментируем обратно, т.е. обнуляем всё

        if (!setting.getBoolean("Start_Pref")) runNewSettings();
        //region ADD Crystal
        if (!setting.getBoolean("CrystalMission2")) {
            settingCrystalMission2();
            setting.putBoolean("CrystalMission2", true);
            setting.flush();
        }
        if (!setting.getBoolean("CrystalMission3")) {
            settingCrystalMission3();
            setting.putBoolean("CrystalMission3", true);
            setting.flush();
        }
        if (!setting.getBoolean("CrystalMission4")) {
            settingRewardTime();
            settingCrystalMission4();
            setting.putBoolean("CrystalMission4", true);
            setting.flush();
        }
        //endregion

//        setting.putBoolean("MissionFinish-1-1", true);
//        setting.putBoolean("RewardYes", true);
    }

    private void runNewSettings() {
        setting.putInteger("Sound", 1);
        setting.putInteger("Music", 1);
        setting.putInteger("Vibro", 1);
        setting.putInteger("Money", 0);
        setting.putInteger("Mineral", 0);
        setting.putInteger("HydrogenDamage", 50);
        setting.putInteger("HydrogenCooldown", 30);
        setting.putInteger("RefrigerantDamage", 50);
        setting.putInteger("RefrigerantCooldown", 30);
        setting.putInteger("ZomanDamage", 50);
        setting.putInteger("ZomanCooldown", 30);
        setting.putInteger("HPBase", 150);
        setting.putInteger("HPSpeed", 1);
        setting.putInteger("MPEnergy", 35);
        setting.putInteger("MPSpeed", 1);
        setting.putInteger("ShieldHPAdd", 1);
        setting.putInteger("EnergyAdd", 1);
        setting.putInteger("Microwave", 1);
        settingsMissions();
        settingsWeapons();
        settingsTactics();
        settingRewardTime();
        settingCrystalMission();
        settingCrystalMission2();
        settingCrystalMission3();
        settingCrystalMission4();
        settingStory();

        setting.putBoolean("CrystalMission2", true);
        setting.putBoolean("CrystalMission3", true);
        setting.putBoolean("CrystalMission4", true);
        setting.putBoolean("Start_Pref", true); // сообщаем, что приложение уже было запущено
        setting.flush();
    }

    // !!!!!! Добавлять новые при обновлении
    //region Reward
    private void settingRewardTime() {
        setting.putInteger("RewardDay", 0);
        setting.putInteger("RewardBonus", 0);
        setting.putBoolean("RewardYes", true);
    }

    public boolean getReward() {
        return setting.getBoolean("RewardYes");
    }

    public void setReward(boolean give) {
        setting.putBoolean("RewardYes", give);
        setting.flush();
    }

    public int getRewardDay() {
        return setting.getInteger("RewardDay");
    }

    public void setRewardDay(int day) {
        setting.putInteger("RewardDay", day);
        setAchievementDaysOfGame();
    }

    public int getRewardBonus() {
        return setting.getInteger("RewardBonus");
    }

    public void setRewardBonus(int bonus) {
        setting.putInteger("RewardBonus", bonus);
    }
    //endregion

    private void settingCrystalMission() {
        setting.putInteger("Crystal_1_1", 250);
        setting.putInteger("Crystal_1_2", 500);
        setting.putInteger("Crystal_1_3", 750);
        setting.putInteger("Crystal_1_4", 750);
    }

    private void settingCrystalMission2() {
        setting.putInteger("Crystal_1_5", 1000);
        setting.putInteger("Crystal_1_6", 1000);
        setting.putInteger("Crystal_2_1", 1200);
        setting.putInteger("Crystal_2_2", 1400);
        setting.putInteger("Crystal_2_3", 1500);
        setting.putInteger("Crystal_2_4", 1650);
        setting.putInteger("Crystal_2_5", 1800);
        setting.putInteger("Crystal_2_6", 2000);
    }

    private void settingCrystalMission3() {
        setting.putInteger("Crystal_3_1", 500);
        setting.putInteger("Crystal_3_2", 500);
        setting.putInteger("Crystal_3_3", 500);
        setting.putInteger("Crystal_3_4", 350);
        setting.putInteger("Crystal_3_5", 500);
        setting.putInteger("Crystal_3_6", 150);
    }

    private void settingCrystalMission4() {
        setting.putInteger("Crystal_4_1", 150);
        setting.putInteger("Crystal_4_2", 150);
        setting.putInteger("Crystal_4_3", 150);
        setting.putInteger("Crystal_4_4", 150);
        setting.putInteger("Crystal_4_5", 2000);
        setting.putInteger("Crystal_4_6", 150);
    }

    private void settingsMissions() {
        setting.putInteger("MissionPage", 1);
        //region 1
        setting.putBoolean("MissionFinish-1-1", false);
        setting.putBoolean("MissionFinish-1-2", false);
        setting.putBoolean("MissionFinish-1-3", false);
        setting.putBoolean("MissionFinish-1-4", false);
        setting.putBoolean("MissionFinish-1-5", false);
        setting.putBoolean("MissionFinish-1-6", false);

        setting.putBoolean("MissionLife-1-1", false);
        setting.putBoolean("MissionLife-1-2", false);
        setting.putBoolean("MissionLife-1-3", false);
        setting.putBoolean("MissionLife-1-4", false);
        setting.putBoolean("MissionLife-1-5", false);
        setting.putBoolean("MissionLife-1-6", false);

        setting.putBoolean("MissionMineral-1-1", false);
        setting.putBoolean("MissionMineral-1-2", false);
        setting.putBoolean("MissionMineral-1-3", false);
        setting.putBoolean("MissionMineral-1-4", false);
        setting.putBoolean("MissionMineral-1-5", false);
        setting.putBoolean("MissionMineral-1-6", false);

        setting.putBoolean("MissionSecret-1-1", false);
        setting.putBoolean("MissionSecret-1-2", false);
        setting.putBoolean("MissionSecret-1-3", false);
        setting.putBoolean("MissionSecret-1-4", false);
        setting.putBoolean("MissionSecret-1-5", false);
        setting.putBoolean("MissionSecret-1-6", false);
        //endregion
        //region 2
        setting.putBoolean("MissionFinish-2-1", false);
        setting.putBoolean("MissionFinish-2-2", false);
        setting.putBoolean("MissionFinish-2-3", false);
        setting.putBoolean("MissionFinish-2-4", false);
        setting.putBoolean("MissionFinish-2-5", false);
        setting.putBoolean("MissionFinish-2-6", false);

        setting.putBoolean("MissionLife-2-1", false);
        setting.putBoolean("MissionLife-2-2", false);
        setting.putBoolean("MissionLife-2-3", false);
        setting.putBoolean("MissionLife-2-4", false);
        setting.putBoolean("MissionLife-2-5", false);
        setting.putBoolean("MissionLife-2-6", false);

        setting.putBoolean("MissionMineral-2-1", false);
        setting.putBoolean("MissionMineral-2-2", false);
        setting.putBoolean("MissionMineral-2-3", false);
        setting.putBoolean("MissionMineral-2-4", false);
        setting.putBoolean("MissionMineral-2-5", false);
        setting.putBoolean("MissionMineral-2-6", false);

        setting.putBoolean("MissionSecret-2-1", false);
        setting.putBoolean("MissionSecret-2-2", false);
        setting.putBoolean("MissionSecret-2-3", false);
        setting.putBoolean("MissionSecret-2-4", false);
        setting.putBoolean("MissionSecret-2-5", false);
        setting.putBoolean("MissionSecret-2-6", false);
        //endregion
        //region 3
        setting.putBoolean("MissionFinish-3-1", false);
        setting.putBoolean("MissionFinish-3-2", false);
        setting.putBoolean("MissionFinish-3-3", false);
        setting.putBoolean("MissionFinish-3-4", false);
        setting.putBoolean("MissionFinish-3-5", false);
        setting.putBoolean("MissionFinish-3-6", false);

        setting.putBoolean("MissionLife-3-1", false);
        setting.putBoolean("MissionLife-3-2", false);
        setting.putBoolean("MissionLife-3-3", false);
        setting.putBoolean("MissionLife-3-4", false);
        setting.putBoolean("MissionLife-3-5", false);
        setting.putBoolean("MissionLife-3-6", false);

        setting.putBoolean("MissionMineral-3-1", false);
        setting.putBoolean("MissionMineral-3-2", false);
        setting.putBoolean("MissionMineral-3-3", false);
        setting.putBoolean("MissionMineral-3-4", false);
        setting.putBoolean("MissionMineral-3-5", false);
        setting.putBoolean("MissionMineral-3-6", false);

        setting.putBoolean("MissionSecret-3-1", false);
        setting.putBoolean("MissionSecret-3-2", false);
        setting.putBoolean("MissionSecret-3-3", false);
        setting.putBoolean("MissionSecret-3-4", false);
        setting.putBoolean("MissionSecret-3-5", false);
        setting.putBoolean("MissionSecret-3-6", false);
        //endregion
        //region 4
        setting.putBoolean("MissionFinish-4-1", false);
        setting.putBoolean("MissionFinish-4-2", false);
        setting.putBoolean("MissionFinish-4-3", false);
        setting.putBoolean("MissionFinish-4-4", false);
        setting.putBoolean("MissionFinish-4-5", false);
        setting.putBoolean("MissionFinish-4-6", false);

        setting.putBoolean("MissionLife-4-1", false);
        setting.putBoolean("MissionLife-4-2", false);
        setting.putBoolean("MissionLife-4-3", false);
        setting.putBoolean("MissionLife-4-4", false);
        setting.putBoolean("MissionLife-4-5", false);
        setting.putBoolean("MissionLife-4-6", false);

        setting.putBoolean("MissionMineral-4-1", false);
        setting.putBoolean("MissionMineral-4-2", false);
        setting.putBoolean("MissionMineral-4-3", false);
        setting.putBoolean("MissionMineral-4-4", false);
        setting.putBoolean("MissionMineral-4-5", false);
        setting.putBoolean("MissionMineral-4-6", false);

        setting.putBoolean("MissionSecret-4-1", false);
        setting.putBoolean("MissionSecret-4-2", false);
        setting.putBoolean("MissionSecret-4-3", false);
        setting.putBoolean("MissionSecret-4-4", false);
        setting.putBoolean("MissionSecret-4-5", false);
        setting.putBoolean("MissionSecret-4-6", false);
        //endregion
    }

    private void settingsWeapons() {
        /* Установка */
        setting.putBoolean("MachineGun_1", true);
        setting.putBoolean("MachineGun_2", false);
        setting.putBoolean("MachineGun_3", false);
        setting.putBoolean("MachineGun_4", false);
        setting.putBoolean("MachineGun_5", false);
        setting.putBoolean("MachineGun_6", false);
        setting.putBoolean("MachineGun_7", false);
        setting.putBoolean("MachineGun_8", false);

        setting.putBoolean("LauncherGun_1", false);
        setting.putBoolean("LauncherGun_2", false);
        setting.putBoolean("LauncherGun_3", false);
        setting.putBoolean("LauncherGun_4", false);
        setting.putBoolean("LauncherGun_5", false);
        setting.putBoolean("LauncherGun_6", false);
        setting.putBoolean("LauncherGun_7", false);
        setting.putBoolean("LauncherGun_8", false);

        setting.putBoolean("FlareGun_1", false);
        setting.putBoolean("FlareGun_2", false);
        setting.putBoolean("FlareGun_3", false);
        setting.putBoolean("FlareGun_4", false);
        setting.putBoolean("FlareGun_5", false);
        setting.putBoolean("FlareGun_6", false);
        setting.putBoolean("FlareGun_7", false);
        setting.putBoolean("FlareGun_8", false);

        setting.putBoolean("LaserGun_1", false);
        setting.putBoolean("LaserGun_2", false);
        setting.putBoolean("LaserGun_3", false);
        setting.putBoolean("LaserGun_4", false);
        setting.putBoolean("LaserGun_5", false);
        setting.putBoolean("LaserGun_6", false);
        setting.putBoolean("LaserGun_7", false);
        setting.putBoolean("LaserGun_8", false);

        /* Покупка */
        setting.putBoolean("BuyMachineGun_1", false);
        setting.putBoolean("BuyMachineGun_2", true);
        setting.putBoolean("BuyMachineGun_3", true);
        setting.putBoolean("BuyMachineGun_4", true);
        setting.putBoolean("BuyMachineGun_5", true);
        setting.putBoolean("BuyMachineGun_6", true);
        setting.putBoolean("BuyMachineGun_7", true);
        setting.putBoolean("BuyMachineGun_8", true);
        setting.putBoolean("BuyLauncherGun_1", true);
        setting.putBoolean("BuyLauncherGun_2", true);
        setting.putBoolean("BuyLauncherGun_3", true);
        setting.putBoolean("BuyLauncherGun_4", true);
        setting.putBoolean("BuyLauncherGun_5", true);
        setting.putBoolean("BuyLauncherGun_6", true);
        setting.putBoolean("BuyLauncherGun_7", true);
        setting.putBoolean("BuyLauncherGun_8", true);
        setting.putBoolean("BuyFlareGun_1", true);
        setting.putBoolean("BuyFlareGun_2", true);
        setting.putBoolean("BuyFlareGun_3", true);
        setting.putBoolean("BuyFlareGun_4", true);
        setting.putBoolean("BuyFlareGun_5", true);
        setting.putBoolean("BuyFlareGun_6", true);
        setting.putBoolean("BuyFlareGun_7", true);
        setting.putBoolean("BuyFlareGun_8", true);
        setting.putBoolean("BuyLaserGun_1", true);
        setting.putBoolean("BuyLaserGun_2", true);
        setting.putBoolean("BuyLaserGun_3", true);
        setting.putBoolean("BuyLaserGun_4", true);
        setting.putBoolean("BuyLaserGun_5", true);
        setting.putBoolean("BuyLaserGun_6", true);
        setting.putBoolean("BuyLaserGun_7", true);
        setting.putBoolean("BuyLaserGun_8", true);

        /* Закрыто для покупки */
        setting.putBoolean("CloseMachineGun_1", false);
        setting.putBoolean("CloseMachineGun_2", true);
        setting.putBoolean("CloseMachineGun_3", true);
        setting.putBoolean("CloseMachineGun_4", true);
        setting.putBoolean("CloseMachineGun_5", true);
        setting.putBoolean("CloseMachineGun_6", true);
        setting.putBoolean("CloseMachineGun_7", true);
        setting.putBoolean("CloseMachineGun_8", true);
        setting.putBoolean("CloseLauncherGun_1", true);
        setting.putBoolean("CloseLauncherGun_2", true);
        setting.putBoolean("CloseLauncherGun_3", true);
        setting.putBoolean("CloseLauncherGun_4", true);
        setting.putBoolean("CloseLauncherGun_5", true);
        setting.putBoolean("CloseLauncherGun_6", true);
        setting.putBoolean("CloseLauncherGun_7", true);
        setting.putBoolean("CloseLauncherGun_8", true);
        setting.putBoolean("CloseFlareGun_1", true);
        setting.putBoolean("CloseFlareGun_2", true);
        setting.putBoolean("CloseFlareGun_3", true);
        setting.putBoolean("CloseFlareGun_4", true);
        setting.putBoolean("CloseFlareGun_5", true);
        setting.putBoolean("CloseFlareGun_6", true);
        setting.putBoolean("CloseFlareGun_7", true);
        setting.putBoolean("CloseFlareGun_8", true);
        setting.putBoolean("CloseLaserGun_1", true);
        setting.putBoolean("CloseLaserGun_2", true);
        setting.putBoolean("CloseLaserGun_3", true);
        setting.putBoolean("CloseLaserGun_4", true);
        setting.putBoolean("CloseLaserGun_5", true);
        setting.putBoolean("CloseLaserGun_6", true);
        setting.putBoolean("CloseLaserGun_7", true);
        setting.putBoolean("CloseLaserGun_8", true);
    }

    public void settingsTactics() {
        setting.putBoolean("AttackStart", false);
        setting.putBoolean("AttackGenerator", false);
        setting.putInteger("AttackGeneratorPowerShot", 0);
        setting.putInteger("AttackGeneratorEnergy", 50);
        setting.putInteger("AttackPowerShot", 0);
        setting.putBoolean("AttackLauncherGun", false);
        setting.putInteger("AttackLauncherGunEnergy", 5);
        setting.putBoolean("AttackFlareGun", false);
        setting.putInteger("AttackFlareGunEnergy", 5);
        setting.putBoolean("AttackLaserGun", false);
        setting.putInteger("AttackLaserGunEnergy", 5);

        setting.putBoolean("DefenseStart", false);
        setting.putBoolean("DefenseGenerator", false);
        setting.putInteger("DefenseGeneratorPowerShield", 0);
        setting.putInteger("DefenseGeneratorEnergy", 50);
        setting.putInteger("DefenseHeartLife", 30);
        setting.putBoolean("DefenseShieldHP", false);
        setting.putInteger("DefenseShieldHPup", 30);
        setting.putBoolean("DefenseEnergy", false);
        setting.putInteger("DefenseEnergyUp", 30);
        setting.putBoolean("DefenseMicrowave", false);
        setting.putFloat("DefenseMicrowaveUp", 5);

        setting.putBoolean("TechnologiesStart", false);
        setting.putBoolean("TechnologiesRadar", false);
        setting.putBoolean("TechnologiesShowMonsterLife", false);
        setting.putInteger("TechnologiesRadarEnergy", 50);
        setting.putInteger("TechnologiesRobot", 2);
        setting.putBoolean("TechnologiesPower", false);
        setting.putInteger("TechnologiesPowerEnergy", 0);
        setting.putInteger("TechnologiesCarryingCapacity", 2);
        setting.putInteger("TechnologiesRobotSpeed", 15);
        setting.putBoolean("TechnologiesConverter", false);
        setting.putInteger("TechnologiesConverterLife", 0);
    }

    //region Music, sound
    public int width() {
        return setting.getInteger("Width");
    }

    public int height() {
        return setting.getInteger("Height");
    }

    public void saveSound(int on_off) { // сохраняем настройки звуков
        setting.putInteger("Sound", on_off);
        setting.flush();
    }

    public int loadSound() { // загружаем настройки звуков
        return setting.getInteger("Sound");
    }

    public void saveMusic(int on_off) { // сохраняем настройки музыки
        setting.putInteger("Music", on_off);
        setting.flush();
    }

    public int loadMusic() { // загружаем настройки музыки
        return setting.getInteger("Music");
    }

    public int loadVibro() { // загружаем настройки музыки
        return setting.getInteger("Vibro");
    }

    public void saveVibro(int vibro) { // устанавливаем вибрацию телефона
        setting.putInteger("Vibro", vibro);
        setting.flush();
    }

    public String language() {
        return setting.getString("Lang");
    }

    public void setLanguage(String lang) {
        setting.putString("Lang", lang);
        setting.flush();
    }
    //endregion

    /*** Ресурсы ***/
    public void saveCredit(int money, int mineral) {
        setting.putInteger("Money", setting.getInteger("Money") + money);
        setting.putInteger("Mineral", setting.getInteger("Mineral") + mineral);
        setting.flush();
        MarsGame.playServices.recordGPGS("Money", loadMoney());
        MarsGame.playServices.recordGPGS("Mineral", loadMineral());
        setAchievementAccumulation();
    }

    public int loadMoney() {
        return setting.getInteger("Money");
    }

    public void saveMineral(int mineral) {
        setting.putInteger("Mineral", setting.getInteger("Mineral") + mineral);
        setting.flush();
        MarsGame.playServices.recordGPGS("Mineral", loadMineral());
        setAchievementAccumulation();
    }

    public int loadMineral() {
        return setting.getInteger("Mineral");
    }

    //region PriceInfo
    public boolean isBuy() {
        return setting.getBoolean("isBuy");
    }

    public float priceMoney(int numberPrice) {
        if (numberPrice == 1) return setting.getFloat("PriceMoney");
        if (numberPrice == 2) return setting.getFloat("PriceMoney_2");
        if (numberPrice == 3) return setting.getFloat("PriceMoney_3");
        if (numberPrice == 4) return setting.getFloat("PriceMoney_4");
        if (numberPrice == 5) return setting.getFloat("PriceMoney_5");
        else return setting.getFloat("PriceMoney");
    }

    public float priceMineral(int numberPrice) {
        if (numberPrice == 1) return setting.getFloat("PriceMineral");
        if (numberPrice == 2) return setting.getFloat("PriceMineral_2");
        if (numberPrice == 3) return setting.getFloat("PriceMineral_3");
        if (numberPrice == 4) return setting.getFloat("PriceMineral_4");
        if (numberPrice == 5) return setting.getFloat("PriceMineral_5");
        else return setting.getFloat("PriceMineral");
    }

    public float priceShieldHPAdd(int numberPrice) {
        if (numberPrice == 1) return setting.getFloat("PriceShieldHPAdd");
        if (numberPrice == 2) return setting.getFloat("PriceShieldHPAdd_2");
        if (numberPrice == 3) return setting.getFloat("PriceShieldHPAdd_3");
        if (numberPrice == 4) return setting.getFloat("PriceShieldHPAdd_4");
        if (numberPrice == 5) return setting.getFloat("PriceShieldHPAdd_5");
        else return setting.getFloat("PriceShieldHPAdd");
    }

    public float priceEnergyAdd(int numberPrice) {
        if (numberPrice == 1) return setting.getFloat("PriceEnergyAdd");
        if (numberPrice == 2) return setting.getFloat("PriceEnergyAdd_2");
        if (numberPrice == 3) return setting.getFloat("PriceEnergyAdd_3");
        if (numberPrice == 4) return setting.getFloat("PriceEnergyAdd_4");
        if (numberPrice == 5) return setting.getFloat("PriceEnergyAdd_5");
        else return setting.getFloat("PriceEnergyAdd");
    }

    public float priceMicrowave(int numberPrice) {
        if (numberPrice == 1) return setting.getFloat("PriceMicrowave");
        if (numberPrice == 2) return setting.getFloat("PriceMicrowave_2");
        if (numberPrice == 3) return setting.getFloat("PriceMicrowave_3");
        if (numberPrice == 4) return setting.getFloat("PriceMicrowave_4");
        if (numberPrice == 5) return setting.getFloat("PriceMicrowave_5");
        else return setting.getFloat("PriceMicrowave");
    }
    //endregion

    //region /*** Лаборатория ***/
    public int loadHydrogenDamage() {
        return setting.getInteger("HydrogenDamage");
    }

    public void saveHydrogenDamage(int damage, int money) {
        setting.putInteger("HydrogenDamage", setting.getInteger("HydrogenDamage") + damage);
        setting.putInteger("Money", setting.getInteger("Money") + money);
        setting.flush();
    }

    public int loadHydrogenCooldown() {
        return setting.getInteger("HydrogenCooldown");
    }

    public void saveHydrogenCooldown(int cooldown, int mineral) {
        setting.putInteger("HydrogenCooldown", setting.getInteger("HydrogenCooldown") + cooldown);
        setting.putInteger("Mineral", setting.getInteger("Mineral") + mineral);
        setting.flush();
    }

    public int loadRefrigerantDamage() {
        return setting.getInteger("RefrigerantDamage");
    }

    public void saveRefrigerantDamage(int damage, int money) {
        setting.putInteger("RefrigerantDamage", setting.getInteger("RefrigerantDamage") + damage);
        setting.putInteger("Money", setting.getInteger("Money") + money);
        setting.flush();
    }

    public int loadRefrigerantCooldown() {
        return setting.getInteger("RefrigerantCooldown");
    }

    public void saveRefrigerantCooldown(int cooldown, int mineral) {
        setting.putInteger("RefrigerantCooldown", setting.getInteger("RefrigerantCooldown") + cooldown);
        setting.putInteger("Mineral", setting.getInteger("Mineral") + mineral);
        setting.flush();
    }

    public int loadZomanDamage() {
        return setting.getInteger("ZomanDamage");
    }

    public void saveZomanDamage(int damage, int money) {
        setting.putInteger("ZomanDamage", setting.getInteger("ZomanDamage") + damage);
        setting.putInteger("Money", setting.getInteger("Money") + money);
        setting.flush();
    }

    public int loadZomanCooldown() {
        return setting.getInteger("ZomanCooldown");
    }

    public void saveZomanCooldown(int cooldown, int mineral) {
        setting.putInteger("ZomanCooldown", setting.getInteger("ZomanCooldown") + cooldown);
        setting.putInteger("Mineral", setting.getInteger("Mineral") + mineral);
        setting.flush();
    }
    //endregion

    //region /*** Реактор ***/
    public int loadHPBase() {
        return setting.getInteger("HPBase");
    }

    public void saveHPBase(int upHP, int money) {
        setting.putInteger("HPBase", setting.getInteger("HPBase") + upHP);
        setting.putInteger("Money", setting.getInteger("Money") + money);
        setting.flush();
    }

    public int loadHPSpeed() {
        return setting.getInteger("HPSpeed");
    }

    public void saveHPSpeed(int speed, int mineral) {
        setting.putInteger("HPSpeed", setting.getInteger("HPSpeed") + speed);
        setting.putInteger("Mineral", setting.getInteger("Mineral") + mineral);
        setting.flush();
    }

    public int loadMPEnergy() {
        return setting.getInteger("MPEnergy");
    }

    public void saveMPEnergy(int upMP, int money) {
        setting.putInteger("MPEnergy", setting.getInteger("MPEnergy") + upMP);
        setting.putInteger("Money", setting.getInteger("Money") + money);
        setting.flush();
    }

    public int loadMPSpeed() {
        return setting.getInteger("MPSpeed");
    }

    public void saveMPSpeed(int speed, int mineral) {
        setting.putInteger("MPSpeed", setting.getInteger("MPSpeed") + speed);
        setting.putInteger("Mineral", setting.getInteger("Mineral") + mineral);
        setting.flush();
    }

    public int loadShieldHPAdd() {
        return setting.getInteger("ShieldHPAdd");
    }

    public void saveShieldHPAdd(int number) {
        setting.putInteger("ShieldHPAdd", setting.getInteger("ShieldHPAdd") + number);
        setting.flush();
    }

    public int loadEnergyAdd() {
        return setting.getInteger("EnergyAdd");
    }

    public void saveEnergyAdd(int number) {
        setting.putInteger("EnergyAdd", setting.getInteger("EnergyAdd") + number);
        setting.flush();
    }

    public int loadMicrowave() {
        return setting.getInteger("Microwave");
    }

    public void saveMicrowave(int number) {
        setting.putInteger("Microwave", setting.getInteger("Microwave") + number);
        setting.flush();
    }
    //endregion

    //region /*** Missions ***/
    public void saveMissionPage(int page) {
        setting.putInteger("MissionPage", page);
        setting.flush();
    }

    public int loadMissionPage() {
        return setting.getInteger("MissionPage");
    }

    public void saveMissionFinish(String mission) {
        if (mission.equals("Missions_1_1")) setting.putBoolean("MissionFinish-1-1", true);
        else if (mission.equals("Missions_1_2")) setting.putBoolean("MissionFinish-1-2", true);
        else if (mission.equals("Missions_1_3")) setting.putBoolean("MissionFinish-1-3", true);
        else if (mission.equals("Missions_1_4")) setting.putBoolean("MissionFinish-1-4", true);
        else if (mission.equals("Missions_1_5")) setting.putBoolean("MissionFinish-1-5", true);
        else if (mission.equals("Missions_1_6")) setting.putBoolean("MissionFinish-1-6", true);
        else if (mission.equals("Missions_2_1")) setting.putBoolean("MissionFinish-2-1", true);
        else if (mission.equals("Missions_2_2")) setting.putBoolean("MissionFinish-2-2", true);
        else if (mission.equals("Missions_2_3")) setting.putBoolean("MissionFinish-2-3", true);
        else if (mission.equals("Missions_2_4")) setting.putBoolean("MissionFinish-2-4", true);
        else if (mission.equals("Missions_2_5")) setting.putBoolean("MissionFinish-2-5", true);
        else if (mission.equals("Missions_2_6")) setting.putBoolean("MissionFinish-2-6", true);
        else if (mission.equals("Missions_3_1")) setting.putBoolean("MissionFinish-3-1", true);
        else if (mission.equals("Missions_3_2")) setting.putBoolean("MissionFinish-3-2", true);
        else if (mission.equals("Missions_3_3")) setting.putBoolean("MissionFinish-3-3", true);
        else if (mission.equals("Missions_3_4")) setting.putBoolean("MissionFinish-3-4", true);
        else if (mission.equals("Missions_3_5")) setting.putBoolean("MissionFinish-3-5", true);
        else if (mission.equals("Missions_3_6")) setting.putBoolean("MissionFinish-3-6", true);
        else if (mission.equals("Missions_4_1")) setting.putBoolean("MissionFinish-4-1", true);
        else if (mission.equals("Missions_4_2")) setting.putBoolean("MissionFinish-4-2", true);
        else if (mission.equals("Missions_4_3")) setting.putBoolean("MissionFinish-4-3", true);
        else if (mission.equals("Missions_4_4")) setting.putBoolean("MissionFinish-4-4", true);
        else if (mission.equals("Missions_4_5")) setting.putBoolean("MissionFinish-4-5", true);
        else if (mission.equals("Missions_4_6")) setting.putBoolean("MissionFinish-4-6", true);
        setting.flush();
    }

    public boolean loadMissionFinish(String mission) {
        if (mission.equals("Missions_1_1")) return setting.getBoolean("MissionFinish-1-1");
        else if (mission.equals("Missions_1_2")) return setting.getBoolean("MissionFinish-1-2");
        else if (mission.equals("Missions_1_3")) return setting.getBoolean("MissionFinish-1-3");
        else if (mission.equals("Missions_1_4")) return setting.getBoolean("MissionFinish-1-4");
        else if (mission.equals("Missions_1_5")) return setting.getBoolean("MissionFinish-1-5");
        else if (mission.equals("Missions_1_6")) return setting.getBoolean("MissionFinish-1-6");
        else if (mission.equals("Missions_2_1")) return setting.getBoolean("MissionFinish-2-1");
        else if (mission.equals("Missions_2_2")) return setting.getBoolean("MissionFinish-2-2");
        else if (mission.equals("Missions_2_3")) return setting.getBoolean("MissionFinish-2-3");
        else if (mission.equals("Missions_2_4")) return setting.getBoolean("MissionFinish-2-4");
        else if (mission.equals("Missions_2_5")) return setting.getBoolean("MissionFinish-2-5");
        else if (mission.equals("Missions_2_6")) return setting.getBoolean("MissionFinish-2-6");
        else if (mission.equals("Missions_3_1")) return setting.getBoolean("MissionFinish-3-1");
        else if (mission.equals("Missions_3_2")) return setting.getBoolean("MissionFinish-3-2");
        else if (mission.equals("Missions_3_3")) return setting.getBoolean("MissionFinish-3-3");
        else if (mission.equals("Missions_3_4")) return setting.getBoolean("MissionFinish-3-4");
        else if (mission.equals("Missions_3_5")) return setting.getBoolean("MissionFinish-3-5");
        else if (mission.equals("Missions_3_6")) return setting.getBoolean("MissionFinish-3-6");
        else if (mission.equals("Missions_4_1")) return setting.getBoolean("MissionFinish-4-1");
        else if (mission.equals("Missions_4_2")) return setting.getBoolean("MissionFinish-4-2");
        else if (mission.equals("Missions_4_3")) return setting.getBoolean("MissionFinish-4-3");
        else if (mission.equals("Missions_4_4")) return setting.getBoolean("MissionFinish-4-4");
        else if (mission.equals("Missions_4_5")) return setting.getBoolean("MissionFinish-4-5");
        else if (mission.equals("Missions_4_6")) return setting.getBoolean("MissionFinish-4-6");
        else return false;
    }

    public void saveMissionLife(String mission) {
        if (mission.equals("Missions_1_1")) setting.putBoolean("MissionLife-1-1", true);
        else if (mission.equals("Missions_1_2")) setting.putBoolean("MissionLife-1-2", true);
        else if (mission.equals("Missions_1_3")) setting.putBoolean("MissionLife-1-3", true);
        else if (mission.equals("Missions_1_4")) setting.putBoolean("MissionLife-1-4", true);
        else if (mission.equals("Missions_1_5")) setting.putBoolean("MissionLife-1-5", true);
        else if (mission.equals("Missions_1_6")) setting.putBoolean("MissionLife-1-6", true);
        else if (mission.equals("Missions_2_1")) setting.putBoolean("MissionLife-2-1", true);
        else if (mission.equals("Missions_2_2")) setting.putBoolean("MissionLife-2-2", true);
        else if (mission.equals("Missions_2_3")) setting.putBoolean("MissionLife-2-3", true);
        else if (mission.equals("Missions_2_4")) setting.putBoolean("MissionLife-2-4", true);
        else if (mission.equals("Missions_2_5")) setting.putBoolean("MissionLife-2-5", true);
        else if (mission.equals("Missions_2_6")) setting.putBoolean("MissionLife-2-6", true);
        else if (mission.equals("Missions_3_1")) setting.putBoolean("MissionLife-3-1", true);
        else if (mission.equals("Missions_3_2")) setting.putBoolean("MissionLife-3-2", true);
        else if (mission.equals("Missions_3_3")) setting.putBoolean("MissionLife-3-3", true);
        else if (mission.equals("Missions_3_4")) setting.putBoolean("MissionLife-3-4", true);
        else if (mission.equals("Missions_3_5")) setting.putBoolean("MissionLife-3-5", true);
        else if (mission.equals("Missions_3_6")) setting.putBoolean("MissionLife-3-6", true);
        else if (mission.equals("Missions_4_1")) setting.putBoolean("MissionLife-4-1", true);
        else if (mission.equals("Missions_4_2")) setting.putBoolean("MissionLife-4-2", true);
        else if (mission.equals("Missions_4_3")) setting.putBoolean("MissionLife-4-3", true);
        else if (mission.equals("Missions_4_4")) setting.putBoolean("MissionLife-4-4", true);
        else if (mission.equals("Missions_4_5")) setting.putBoolean("MissionLife-4-5", true);
        else if (mission.equals("Missions_4_6")) setting.putBoolean("MissionLife-4-6", true);
        setting.flush();
    }

    public boolean loadMissionLife(String mission) {
        if (mission.equals("Missions_1_1")) return setting.getBoolean("MissionLife-1-1");
        else if (mission.equals("Missions_1_2")) return setting.getBoolean("MissionLife-1-2");
        else if (mission.equals("Missions_1_3")) return setting.getBoolean("MissionLife-1-3");
        else if (mission.equals("Missions_1_4")) return setting.getBoolean("MissionLife-1-4");
        else if (mission.equals("Missions_1_5")) return setting.getBoolean("MissionLife-1-5");
        else if (mission.equals("Missions_1_6")) return setting.getBoolean("MissionLife-1-6");
        else if (mission.equals("Missions_2_1")) return setting.getBoolean("MissionLife-2-1");
        else if (mission.equals("Missions_2_2")) return setting.getBoolean("MissionLife-2-2");
        else if (mission.equals("Missions_2_3")) return setting.getBoolean("MissionLife-2-3");
        else if (mission.equals("Missions_2_4")) return setting.getBoolean("MissionLife-2-4");
        else if (mission.equals("Missions_2_5")) return setting.getBoolean("MissionLife-2-5");
        else if (mission.equals("Missions_2_6")) return setting.getBoolean("MissionLife-2-6");
        else if (mission.equals("Missions_3_1")) return setting.getBoolean("MissionLife-3-1");
        else if (mission.equals("Missions_3_2")) return setting.getBoolean("MissionLife-3-2");
        else if (mission.equals("Missions_3_3")) return setting.getBoolean("MissionLife-3-3");
        else if (mission.equals("Missions_3_4")) return setting.getBoolean("MissionLife-3-4");
        else if (mission.equals("Missions_3_5")) return setting.getBoolean("MissionLife-3-5");
        else if (mission.equals("Missions_3_6")) return setting.getBoolean("MissionLife-3-6");
        else if (mission.equals("Missions_4_1")) return setting.getBoolean("MissionLife-4-1");
        else if (mission.equals("Missions_4_2")) return setting.getBoolean("MissionLife-4-2");
        else if (mission.equals("Missions_4_3")) return setting.getBoolean("MissionLife-4-3");
        else if (mission.equals("Missions_4_4")) return setting.getBoolean("MissionLife-4-4");
        else if (mission.equals("Missions_4_5")) return setting.getBoolean("MissionLife-4-5");
        else if (mission.equals("Missions_4_6")) return setting.getBoolean("MissionLife-4-6");
        else return false;
    }

    public void saveMissionMineral(String mission) {
        if (mission.equals("Missions_1_1")) setting.putBoolean("MissionMineral-1-1", true);
        else if (mission.equals("Missions_1_2")) setting.putBoolean("MissionMineral-1-2", true);
        else if (mission.equals("Missions_1_3")) setting.putBoolean("MissionMineral-1-3", true);
        else if (mission.equals("Missions_1_4")) setting.putBoolean("MissionMineral-1-4", true);
        else if (mission.equals("Missions_1_5")) setting.putBoolean("MissionMineral-1-5", true);
        else if (mission.equals("Missions_1_6")) setting.putBoolean("MissionMineral-1-6", true);
        else if (mission.equals("Missions_2_1")) setting.putBoolean("MissionMineral-2-1", true);
        else if (mission.equals("Missions_2_2")) setting.putBoolean("MissionMineral-2-2", true);
        else if (mission.equals("Missions_2_3")) setting.putBoolean("MissionMineral-2-3", true);
        else if (mission.equals("Missions_2_4")) setting.putBoolean("MissionMineral-2-4", true);
        else if (mission.equals("Missions_2_5")) setting.putBoolean("MissionMineral-2-5", true);
        else if (mission.equals("Missions_2_6")) setting.putBoolean("MissionMineral-2-6", true);
        else if (mission.equals("Missions_3_1")) setting.putBoolean("MissionMineral-3-1", true);
        else if (mission.equals("Missions_3_2")) setting.putBoolean("MissionMineral-3-2", true);
        else if (mission.equals("Missions_3_3")) setting.putBoolean("MissionMineral-3-3", true);
        else if (mission.equals("Missions_3_4")) setting.putBoolean("MissionMineral-3-4", true);
        else if (mission.equals("Missions_3_5")) setting.putBoolean("MissionMineral-3-5", true);
        else if (mission.equals("Missions_3_6")) setting.putBoolean("MissionMineral-3-6", true);
        else if (mission.equals("Missions_4_1")) setting.putBoolean("MissionMineral-4-1", true);
        else if (mission.equals("Missions_4_2")) setting.putBoolean("MissionMineral-4-2", true);
        else if (mission.equals("Missions_4_3")) setting.putBoolean("MissionMineral-4-3", true);
        else if (mission.equals("Missions_4_4")) setting.putBoolean("MissionMineral-4-4", true);
        else if (mission.equals("Missions_4_5")) setting.putBoolean("MissionMineral-4-5", true);
        else if (mission.equals("Missions_4_6")) setting.putBoolean("MissionMineral-4-6", true);
        setting.flush();
    }

    public boolean loadMissionMineral(String mission) {
        if (mission.equals("Missions_1_1")) return setting.getBoolean("MissionMineral-1-1");
        else if (mission.equals("Missions_1_2")) return setting.getBoolean("MissionMineral-1-2");
        else if (mission.equals("Missions_1_3")) return setting.getBoolean("MissionMineral-1-3");
        else if (mission.equals("Missions_1_4")) return setting.getBoolean("MissionMineral-1-4");
        else if (mission.equals("Missions_1_5")) return setting.getBoolean("MissionMineral-1-5");
        else if (mission.equals("Missions_1_6")) return setting.getBoolean("MissionMineral-1-6");
        else if (mission.equals("Missions_2_1")) return setting.getBoolean("MissionMineral-2-1");
        else if (mission.equals("Missions_2_2")) return setting.getBoolean("MissionMineral-2-2");
        else if (mission.equals("Missions_2_3")) return setting.getBoolean("MissionMineral-2-3");
        else if (mission.equals("Missions_2_4")) return setting.getBoolean("MissionMineral-2-4");
        else if (mission.equals("Missions_2_5")) return setting.getBoolean("MissionMineral-2-5");
        else if (mission.equals("Missions_2_6")) return setting.getBoolean("MissionMineral-2-6");
        else if (mission.equals("Missions_3_1")) return setting.getBoolean("MissionMineral-3-1");
        else if (mission.equals("Missions_3_2")) return setting.getBoolean("MissionMineral-3-2");
        else if (mission.equals("Missions_3_3")) return setting.getBoolean("MissionMineral-3-3");
        else if (mission.equals("Missions_3_4")) return setting.getBoolean("MissionMineral-3-4");
        else if (mission.equals("Missions_3_5")) return setting.getBoolean("MissionMineral-3-5");
        else if (mission.equals("Missions_3_6")) return setting.getBoolean("MissionMineral-3-6");
        else if (mission.equals("Missions_4_1")) return setting.getBoolean("MissionMineral-4-1");
        else if (mission.equals("Missions_4_2")) return setting.getBoolean("MissionMineral-4-2");
        else if (mission.equals("Missions_4_3")) return setting.getBoolean("MissionMineral-4-3");
        else if (mission.equals("Missions_4_4")) return setting.getBoolean("MissionMineral-4-4");
        else if (mission.equals("Missions_4_5")) return setting.getBoolean("MissionMineral-4-5");
        else if (mission.equals("Missions_4_6")) return setting.getBoolean("MissionMineral-4-6");
        else return false;
    }

    public void saveMissionSecret(String mission) {
        if (mission.equals("Missions_1_1")) setting.putBoolean("MissionSecret-1-1", true);
        else if (mission.equals("Missions_1_2")) setting.putBoolean("MissionSecret-1-2", true);
        else if (mission.equals("Missions_1_3")) setting.putBoolean("MissionSecret-1-3", true);
        else if (mission.equals("Missions_1_4")) setting.putBoolean("MissionSecret-1-4", true);
        else if (mission.equals("Missions_1_5")) setting.putBoolean("MissionSecret-1-5", true);
        else if (mission.equals("Missions_1_6")) setting.putBoolean("MissionSecret-1-6", true);
        else if (mission.equals("Missions_2_1")) setting.putBoolean("MissionSecret-2-1", true);
        else if (mission.equals("Missions_2_2")) setting.putBoolean("MissionSecret-2-2", true);
        else if (mission.equals("Missions_2_3")) setting.putBoolean("MissionSecret-2-3", true);
        else if (mission.equals("Missions_2_4")) setting.putBoolean("MissionSecret-2-4", true);
        else if (mission.equals("Missions_2_5")) setting.putBoolean("MissionSecret-2-5", true);
        else if (mission.equals("Missions_2_6")) setting.putBoolean("MissionSecret-2-6", true);
        else if (mission.equals("Missions_3_1")) setting.putBoolean("MissionSecret-3-1", true);
        else if (mission.equals("Missions_3_2")) setting.putBoolean("MissionSecret-3-2", true);
        else if (mission.equals("Missions_3_3")) setting.putBoolean("MissionSecret-3-3", true);
        else if (mission.equals("Missions_3_4")) setting.putBoolean("MissionSecret-3-4", true);
        else if (mission.equals("Missions_3_5")) setting.putBoolean("MissionSecret-3-5", true);
        else if (mission.equals("Missions_3_6")) setting.putBoolean("MissionSecret-3-6", true);
        else if (mission.equals("Missions_4_1")) setting.putBoolean("MissionSecret-4-1", true);
        else if (mission.equals("Missions_4_2")) setting.putBoolean("MissionSecret-4-2", true);
        else if (mission.equals("Missions_4_3")) setting.putBoolean("MissionSecret-4-3", true);
        else if (mission.equals("Missions_4_4")) setting.putBoolean("MissionSecret-4-4", true);
        else if (mission.equals("Missions_4_5")) setting.putBoolean("MissionSecret-4-5", true);
        else if (mission.equals("Missions_4_6")) setting.putBoolean("MissionSecret-4-6", true);
        setting.flush();
    }

    public boolean loadMissionSecret(String mission) {
        if (mission.equals("Missions_1_1")) return setting.getBoolean("MissionSecret-1-1");
        else if (mission.equals("Missions_1_2")) return setting.getBoolean("MissionSecret-1-2");
        else if (mission.equals("Missions_1_3")) return setting.getBoolean("MissionSecret-1-3");
        else if (mission.equals("Missions_1_4")) return setting.getBoolean("MissionSecret-1-4");
        else if (mission.equals("Missions_1_5")) return setting.getBoolean("MissionSecret-1-5");
        else if (mission.equals("Missions_1_6")) return setting.getBoolean("MissionSecret-1-6");
        else if (mission.equals("Missions_2_1")) return setting.getBoolean("MissionSecret-2-1");
        else if (mission.equals("Missions_2_2")) return setting.getBoolean("MissionSecret-2-2");
        else if (mission.equals("Missions_2_3")) return setting.getBoolean("MissionSecret-2-3");
        else if (mission.equals("Missions_2_4")) return setting.getBoolean("MissionSecret-2-4");
        else if (mission.equals("Missions_2_5")) return setting.getBoolean("MissionSecret-2-5");
        else if (mission.equals("Missions_2_6")) return setting.getBoolean("MissionSecret-2-6");
        else if (mission.equals("Missions_3_1")) return setting.getBoolean("MissionSecret-3-1");
        else if (mission.equals("Missions_3_2")) return setting.getBoolean("MissionSecret-3-2");
        else if (mission.equals("Missions_3_3")) return setting.getBoolean("MissionSecret-3-3");
        else if (mission.equals("Missions_3_4")) return setting.getBoolean("MissionSecret-3-4");
        else if (mission.equals("Missions_3_5")) return setting.getBoolean("MissionSecret-3-5");
        else if (mission.equals("Missions_3_6")) return setting.getBoolean("MissionSecret-3-6");
        else if (mission.equals("Missions_4_1")) return setting.getBoolean("MissionSecret-4-1");
        else if (mission.equals("Missions_4_2")) return setting.getBoolean("MissionSecret-4-2");
        else if (mission.equals("Missions_4_3")) return setting.getBoolean("MissionSecret-4-3");
        else if (mission.equals("Missions_4_4")) return setting.getBoolean("MissionSecret-4-4");
        else if (mission.equals("Missions_4_5")) return setting.getBoolean("MissionSecret-4-5");
        else if (mission.equals("Missions_4_6")) return setting.getBoolean("MissionSecret-4-6");
        else return false;
    }
    //endregion

    //region /*** Weapons ***/
    public void setWeaponInstalled(String name) {
        setting.putBoolean("MachineGun_1", false);
        setting.putBoolean("MachineGun_2", false);
        setting.putBoolean("MachineGun_3", false);
        setting.putBoolean("MachineGun_4", false);
        setting.putBoolean("MachineGun_5", false);
        setting.putBoolean("MachineGun_6", false);
        setting.putBoolean("MachineGun_7", false);
        setting.putBoolean("MachineGun_8", false);

        setting.putBoolean("LauncherGun_1", false);
        setting.putBoolean("LauncherGun_2", false);
        setting.putBoolean("LauncherGun_3", false);
        setting.putBoolean("LauncherGun_4", false);
        setting.putBoolean("LauncherGun_5", false);
        setting.putBoolean("LauncherGun_6", false);
        setting.putBoolean("LauncherGun_7", false);
        setting.putBoolean("LauncherGun_8", false);

        setting.putBoolean("FlareGun_1", false);
        setting.putBoolean("FlareGun_2", false);
        setting.putBoolean("FlareGun_3", false);
        setting.putBoolean("FlareGun_4", false);
        setting.putBoolean("FlareGun_5", false);
        setting.putBoolean("FlareGun_6", false);
        setting.putBoolean("FlareGun_7", false);
        setting.putBoolean("FlareGun_8", false);

        setting.putBoolean("LaserGun_1", false);
        setting.putBoolean("LaserGun_2", false);
        setting.putBoolean("LaserGun_3", false);
        setting.putBoolean("LaserGun_4", false);
        setting.putBoolean("LaserGun_5", false);
        setting.putBoolean("LaserGun_6", false);
        setting.putBoolean("LaserGun_7", false);
        setting.putBoolean("LaserGun_8", false);

        if (name.equals("MachineGun_1")) setting.putBoolean("MachineGun_1", true);
        else if (name.equals("MachineGun_2")) setting.putBoolean("MachineGun_2", true);
        else if (name.equals("MachineGun_3")) setting.putBoolean("MachineGun_3", true);
        else if (name.equals("MachineGun_4")) setting.putBoolean("MachineGun_4", true);
        else if (name.equals("MachineGun_5")) setting.putBoolean("MachineGun_5", true);
        else if (name.equals("MachineGun_6")) setting.putBoolean("MachineGun_6", true);
        else if (name.equals("MachineGun_7")) setting.putBoolean("MachineGun_7", true);
        else if (name.equals("MachineGun_8")) setting.putBoolean("MachineGun_8", true);
        else if (name.equals("LauncherGun_1")) setting.putBoolean("LauncherGun_1", true);
        else if (name.equals("LauncherGun_2")) setting.putBoolean("LauncherGun_2", true);
        else if (name.equals("LauncherGun_3")) setting.putBoolean("LauncherGun_3", true);
        else if (name.equals("LauncherGun_4")) setting.putBoolean("LauncherGun_4", true);
        else if (name.equals("LauncherGun_5")) setting.putBoolean("LauncherGun_5", true);
        else if (name.equals("LauncherGun_6")) setting.putBoolean("LauncherGun_6", true);
        else if (name.equals("LauncherGun_7")) setting.putBoolean("LauncherGun_7", true);
        else if (name.equals("LauncherGun_8")) setting.putBoolean("LauncherGun_8", true);
        else if (name.equals("FlareGun_1")) setting.putBoolean("FlareGun_1", true);
        else if (name.equals("FlareGun_2")) setting.putBoolean("FlareGun_2", true);
        else if (name.equals("FlareGun_3")) setting.putBoolean("FlareGun_3", true);
        else if (name.equals("FlareGun_4")) setting.putBoolean("FlareGun_4", true);
        else if (name.equals("FlareGun_5")) setting.putBoolean("FlareGun_5", true);
        else if (name.equals("FlareGun_6")) setting.putBoolean("FlareGun_6", true);
        else if (name.equals("FlareGun_7")) setting.putBoolean("FlareGun_7", true);
        else if (name.equals("FlareGun_8")) setting.putBoolean("FlareGun_8", true);
        else if (name.equals("LaserGun_1")) setting.putBoolean("LaserGun_1", true);
        else if (name.equals("LaserGun_2")) setting.putBoolean("LaserGun_2", true);
        else if (name.equals("LaserGun_3")) setting.putBoolean("LaserGun_3", true);
        else if (name.equals("LaserGun_4")) setting.putBoolean("LaserGun_4", true);
        else if (name.equals("LaserGun_5")) setting.putBoolean("LaserGun_5", true);
        else if (name.equals("LaserGun_6")) setting.putBoolean("LaserGun_6", true);
        else if (name.equals("LaserGun_7")) setting.putBoolean("LaserGun_7", true);
        else if (name.equals("LaserGun_8")) setting.putBoolean("LaserGun_8", true);
        setting.flush();
    }

    public boolean getWeaponInstalled(String name) {
        if (name.equals("MachineGun_1")) return setting.getBoolean("MachineGun_1");
        else if (name.equals("MachineGun_2")) return setting.getBoolean("MachineGun_2");
        else if (name.equals("MachineGun_3")) return setting.getBoolean("MachineGun_3");
        else if (name.equals("MachineGun_4")) return setting.getBoolean("MachineGun_4");
        else if (name.equals("MachineGun_5")) return setting.getBoolean("MachineGun_5");
        else if (name.equals("MachineGun_6")) return setting.getBoolean("MachineGun_6");
        else if (name.equals("MachineGun_7")) return setting.getBoolean("MachineGun_7");
        else if (name.equals("MachineGun_8")) return setting.getBoolean("MachineGun_8");
        else if (name.equals("LauncherGun_1")) return setting.getBoolean("LauncherGun_1");
        else if (name.equals("LauncherGun_2")) return setting.getBoolean("LauncherGun_2");
        else if (name.equals("LauncherGun_3")) return setting.getBoolean("LauncherGun_3");
        else if (name.equals("LauncherGun_4")) return setting.getBoolean("LauncherGun_4");
        else if (name.equals("LauncherGun_5")) return setting.getBoolean("LauncherGun_5");
        else if (name.equals("LauncherGun_6")) return setting.getBoolean("LauncherGun_6");
        else if (name.equals("LauncherGun_7")) return setting.getBoolean("LauncherGun_7");
        else if (name.equals("LauncherGun_8")) return setting.getBoolean("LauncherGun_8");
        else if (name.equals("FlareGun_1")) return setting.getBoolean("FlareGun_1");
        else if (name.equals("FlareGun_2")) return setting.getBoolean("FlareGun_2");
        else if (name.equals("FlareGun_3")) return setting.getBoolean("FlareGun_3");
        else if (name.equals("FlareGun_4")) return setting.getBoolean("FlareGun_4");
        else if (name.equals("FlareGun_5")) return setting.getBoolean("FlareGun_5");
        else if (name.equals("FlareGun_6")) return setting.getBoolean("FlareGun_6");
        else if (name.equals("FlareGun_7")) return setting.getBoolean("FlareGun_7");
        else if (name.equals("FlareGun_8")) return setting.getBoolean("FlareGun_8");
        else if (name.equals("LaserGun_1")) return setting.getBoolean("LaserGun_1");
        else if (name.equals("LaserGun_2")) return setting.getBoolean("LaserGun_2");
        else if (name.equals("LaserGun_3")) return setting.getBoolean("LaserGun_3");
        else if (name.equals("LaserGun_4")) return setting.getBoolean("LaserGun_4");
        else if (name.equals("LaserGun_5")) return setting.getBoolean("LaserGun_5");
        else if (name.equals("LaserGun_6")) return setting.getBoolean("LaserGun_6");
        else if (name.equals("LaserGun_7")) return setting.getBoolean("LaserGun_7");
        else if (name.equals("LaserGun_8")) return setting.getBoolean("LaserGun_8");
        else return setting.getBoolean("FlareGun_1");
    }

    public void setWeaponBuy(String name) {
        if (name.equals("MachineGun_1")) setting.putBoolean("BuyMachineGun_1", false);
        else if (name.equals("MachineGun_2")) setting.putBoolean("BuyMachineGun_2", false);
        else if (name.equals("MachineGun_3")) setting.putBoolean("BuyMachineGun_3", false);
        else if (name.equals("MachineGun_4")) setting.putBoolean("BuyMachineGun_4", false);
        else if (name.equals("MachineGun_5")) setting.putBoolean("BuyMachineGun_5", false);
        else if (name.equals("MachineGun_6")) setting.putBoolean("BuyMachineGun_6", false);
        else if (name.equals("MachineGun_7")) setting.putBoolean("BuyMachineGun_7", false);
        else if (name.equals("MachineGun_8")) setting.putBoolean("BuyMachineGun_8", false);
        else if (name.equals("LauncherGun_1")) setting.putBoolean("BuyLauncherGun_1", false);
        else if (name.equals("LauncherGun_2")) setting.putBoolean("BuyLauncherGun_2", false);
        else if (name.equals("LauncherGun_3")) setting.putBoolean("BuyLauncherGun_3", false);
        else if (name.equals("LauncherGun_4")) setting.putBoolean("BuyLauncherGun_4", false);
        else if (name.equals("LauncherGun_5")) setting.putBoolean("BuyLauncherGun_5", false);
        else if (name.equals("LauncherGun_6")) setting.putBoolean("BuyLauncherGun_6", false);
        else if (name.equals("LauncherGun_7")) setting.putBoolean("BuyLauncherGun_7", false);
        else if (name.equals("LauncherGun_8")) setting.putBoolean("BuyLauncherGun_8", false);
        else if (name.equals("FlareGun_1")) setting.putBoolean("BuyFlareGun_1", false);
        else if (name.equals("FlareGun_2")) setting.putBoolean("BuyFlareGun_2", false);
        else if (name.equals("FlareGun_3")) setting.putBoolean("BuyFlareGun_3", false);
        else if (name.equals("FlareGun_4")) setting.putBoolean("BuyFlareGun_4", false);
        else if (name.equals("FlareGun_5")) setting.putBoolean("BuyFlareGun_5", false);
        else if (name.equals("FlareGun_6")) setting.putBoolean("BuyFlareGun_6", false);
        else if (name.equals("FlareGun_7")) setting.putBoolean("BuyFlareGun_7", false);
        else if (name.equals("FlareGun_8")) setting.putBoolean("BuyFlareGun_8", false);
        else if (name.equals("LaserGun_1")) setting.putBoolean("BuyLaserGun_1", false);
        else if (name.equals("LaserGun_2")) setting.putBoolean("BuyLaserGun_2", false);
        else if (name.equals("LaserGun_3")) setting.putBoolean("BuyLaserGun_3", false);
        else if (name.equals("LaserGun_4")) setting.putBoolean("BuyLaserGun_4", false);
        else if (name.equals("LaserGun_5")) setting.putBoolean("BuyLaserGun_5", false);
        else if (name.equals("LaserGun_6")) setting.putBoolean("BuyLaserGun_6", false);
        else if (name.equals("LaserGun_7")) setting.putBoolean("BuyLaserGun_7", false);
        else if (name.equals("LaserGun_8")) setting.putBoolean("BuyLaserGun_8", false);
        setting.flush();
    }

    public boolean getWeaponBuy(String name) {
        if (name.equals("MachineGun_1")) return setting.getBoolean("BuyMachineGun_1");
        else if (name.equals("MachineGun_2")) return setting.getBoolean("BuyMachineGun_2");
        else if (name.equals("MachineGun_3")) return setting.getBoolean("BuyMachineGun_3");
        else if (name.equals("MachineGun_4")) return setting.getBoolean("BuyMachineGun_4");
        else if (name.equals("MachineGun_5")) return setting.getBoolean("BuyMachineGun_5");
        else if (name.equals("MachineGun_6")) return setting.getBoolean("BuyMachineGun_6");
        else if (name.equals("MachineGun_7")) return setting.getBoolean("BuyMachineGun_7");
        else if (name.equals("MachineGun_8")) return setting.getBoolean("BuyMachineGun_8");
        else if (name.equals("LauncherGun_1")) return setting.getBoolean("BuyLauncherGun_1");
        else if (name.equals("LauncherGun_2")) return setting.getBoolean("BuyLauncherGun_2");
        else if (name.equals("LauncherGun_3")) return setting.getBoolean("BuyLauncherGun_3");
        else if (name.equals("LauncherGun_4")) return setting.getBoolean("BuyLauncherGun_4");
        else if (name.equals("LauncherGun_5")) return setting.getBoolean("BuyLauncherGun_5");
        else if (name.equals("LauncherGun_6")) return setting.getBoolean("BuyLauncherGun_6");
        else if (name.equals("LauncherGun_7")) return setting.getBoolean("BuyLauncherGun_7");
        else if (name.equals("LauncherGun_8")) return setting.getBoolean("BuyLauncherGun_8");
        else if (name.equals("FlareGun_1")) return setting.getBoolean("BuyFlareGun_1");
        else if (name.equals("FlareGun_2")) return setting.getBoolean("BuyFlareGun_2");
        else if (name.equals("FlareGun_3")) return setting.getBoolean("BuyFlareGun_3");
        else if (name.equals("FlareGun_4")) return setting.getBoolean("BuyFlareGun_4");
        else if (name.equals("FlareGun_5")) return setting.getBoolean("BuyFlareGun_5");
        else if (name.equals("FlareGun_6")) return setting.getBoolean("BuyFlareGun_6");
        else if (name.equals("FlareGun_7")) return setting.getBoolean("BuyFlareGun_7");
        else if (name.equals("FlareGun_8")) return setting.getBoolean("BuyFlareGun_8");
        else if (name.equals("LaserGun_1")) return setting.getBoolean("BuyLaserGun_1");
        else if (name.equals("LaserGun_2")) return setting.getBoolean("BuyLaserGun_2");
        else if (name.equals("LaserGun_3")) return setting.getBoolean("BuyLaserGun_3");
        else if (name.equals("LaserGun_4")) return setting.getBoolean("BuyLaserGun_4");
        else if (name.equals("LaserGun_5")) return setting.getBoolean("BuyLaserGun_5");
        else if (name.equals("LaserGun_6")) return setting.getBoolean("BuyLaserGun_6");
        else if (name.equals("LaserGun_7")) return setting.getBoolean("BuyLaserGun_7");
        else if (name.equals("LaserGun_8")) return setting.getBoolean("BuyLaserGun_8");
        else return true;
    }

    public void setWeaponClose(String name) {
        if (name.equals("MachineGun_1")) setting.putBoolean("CloseMachineGun_1", false);
        else if (name.equals("MachineGun_2")) setting.putBoolean("CloseMachineGun_2", false);
        else if (name.equals("MachineGun_3")) setting.putBoolean("CloseMachineGun_3", false);
        else if (name.equals("MachineGun_4")) setting.putBoolean("CloseMachineGun_4", false);
        else if (name.equals("MachineGun_5")) setting.putBoolean("CloseMachineGun_5", false);
        else if (name.equals("MachineGun_6")) setting.putBoolean("CloseMachineGun_6", false);
        else if (name.equals("MachineGun_7")) setting.putBoolean("CloseMachineGun_7", false);
        else if (name.equals("MachineGun_8")) setting.putBoolean("CloseMachineGun_8", false);

        else if (name.equals("LauncherGun_1")) setting.putBoolean("CloseLauncherGun_1", false);
        else if (name.equals("LauncherGun_2")) setting.putBoolean("CloseLauncherGun_2", false);
        else if (name.equals("LauncherGun_3")) setting.putBoolean("CloseLauncherGun_3", false);
        else if (name.equals("LauncherGun_4")) setting.putBoolean("CloseLauncherGun_4", false);
        else if (name.equals("LauncherGun_5")) setting.putBoolean("CloseLauncherGun_5", false);
        else if (name.equals("LauncherGun_6")) setting.putBoolean("CloseLauncherGun_6", false);
        else if (name.equals("LauncherGun_7")) setting.putBoolean("CloseLauncherGun_7", false);
        else if (name.equals("LauncherGun_8")) setting.putBoolean("CloseLauncherGun_8", false);

        else if (name.equals("FlareGun_1")) setting.putBoolean("CloseFlareGun_1", false);
        else if (name.equals("FlareGun_2")) setting.putBoolean("CloseFlareGun_2", false);
        else if (name.equals("FlareGun_3")) setting.putBoolean("CloseFlareGun_3", false);
        else if (name.equals("FlareGun_4")) setting.putBoolean("CloseFlareGun_4", false);
        else if (name.equals("FlareGun_5")) setting.putBoolean("CloseFlareGun_5", false);
        else if (name.equals("FlareGun_6")) setting.putBoolean("CloseFlareGun_6", false);
        else if (name.equals("FlareGun_7")) setting.putBoolean("CloseFlareGun_7", false);
        else if (name.equals("FlareGun_8")) setting.putBoolean("CloseFlareGun_8", false);

        else if (name.equals("LaserGun_1")) setting.putBoolean("CloseLaserGun_1", false);
        else if (name.equals("LaserGun_2")) setting.putBoolean("CloseLaserGun_2", false);
        else if (name.equals("LaserGun_3")) setting.putBoolean("CloseLaserGun_3", false);
        else if (name.equals("LaserGun_4")) setting.putBoolean("CloseLaserGun_4", false);
        else if (name.equals("LaserGun_5")) setting.putBoolean("CloseLaserGun_5", false);
        else if (name.equals("LaserGun_6")) setting.putBoolean("CloseLaserGun_6", false);
        else if (name.equals("LaserGun_7")) setting.putBoolean("CloseLaserGun_7", false);
        else if (name.equals("LaserGun_8")) setting.putBoolean("CloseLaserGun_8", false);
        setting.flush();
    }

    public boolean getWeaponClose(String name) {
        if (name.equals("MachineGun_1")) return setting.getBoolean("CloseMachineGun_1");
        else if (name.equals("MachineGun_2")) return setting.getBoolean("CloseMachineGun_2");
        else if (name.equals("MachineGun_3")) return setting.getBoolean("CloseMachineGun_3");
        else if (name.equals("MachineGun_4")) return setting.getBoolean("CloseMachineGun_4");
        else if (name.equals("MachineGun_5")) return setting.getBoolean("CloseMachineGun_5");
        else if (name.equals("MachineGun_6")) return setting.getBoolean("CloseMachineGun_6");
        else if (name.equals("MachineGun_7")) return setting.getBoolean("CloseMachineGun_7");
        else if (name.equals("MachineGun_8")) return setting.getBoolean("CloseMachineGun_8");
        else if (name.equals("LauncherGun_1")) return setting.getBoolean("CloseLauncherGun_1");
        else if (name.equals("LauncherGun_2")) return setting.getBoolean("CloseLauncherGun_2");
        else if (name.equals("LauncherGun_3")) return setting.getBoolean("CloseLauncherGun_3");
        else if (name.equals("LauncherGun_4")) return setting.getBoolean("CloseLauncherGun_4");
        else if (name.equals("LauncherGun_5")) return setting.getBoolean("CloseLauncherGun_5");
        else if (name.equals("LauncherGun_6")) return setting.getBoolean("CloseLauncherGun_6");
        else if (name.equals("LauncherGun_7")) return setting.getBoolean("CloseLauncherGun_7");
        else if (name.equals("LauncherGun_8")) return setting.getBoolean("CloseLauncherGun_8");
        else if (name.equals("FlareGun_1")) return setting.getBoolean("CloseFlareGun_1");
        else if (name.equals("FlareGun_2")) return setting.getBoolean("CloseFlareGun_2");
        else if (name.equals("FlareGun_3")) return setting.getBoolean("CloseFlareGun_3");
        else if (name.equals("FlareGun_4")) return setting.getBoolean("CloseFlareGun_4");
        else if (name.equals("FlareGun_5")) return setting.getBoolean("CloseFlareGun_5");
        else if (name.equals("FlareGun_6")) return setting.getBoolean("CloseFlareGun_6");
        else if (name.equals("FlareGun_7")) return setting.getBoolean("CloseFlareGun_7");
        else if (name.equals("FlareGun_8")) return setting.getBoolean("CloseFlareGun_8");
        else if (name.equals("LaserGun_1")) return setting.getBoolean("CloseLaserGun_1");
        else if (name.equals("LaserGun_2")) return setting.getBoolean("CloseLaserGun_2");
        else if (name.equals("LaserGun_3")) return setting.getBoolean("CloseLaserGun_3");
        else if (name.equals("LaserGun_4")) return setting.getBoolean("CloseLaserGun_4");
        else if (name.equals("LaserGun_5")) return setting.getBoolean("CloseLaserGun_5");
        else if (name.equals("LaserGun_6")) return setting.getBoolean("CloseLaserGun_6");
        else if (name.equals("LaserGun_7")) return setting.getBoolean("CloseLaserGun_7");
        else if (name.equals("LaserGun_8")) return setting.getBoolean("CloseLaserGun_8");
        else return true;
    }

    public void setWeaponUpgrade(String type, String name) {
        if (type.equals("MachineGun")) setting.putString("UpgradeMachineGun", name);
        else if (type.equals("LauncherGun")) setting.putString("UpgradeLauncherGun", name);
        else if (type.equals("FlareGun")) setting.putString("UpgradeFlareGun", name);
        else if (type.equals("LaserGun")) setting.putString("UpgradeLaserGun", name);
        setting.flush();
    }

    public String getWeaponUpgrade(String type) {
        if (type.equals("MachineGun")) return setting.getString("UpgradeMachineGun");
        else if (type.equals("LauncherGun")) return setting.getString("UpgradeLauncherGun");
        else if (type.equals("FlareGun")) return setting.getString("UpgradeFlareGun");
        else if (type.equals("LaserGun")) return setting.getString("UpgradeLaserGun");
        else return null;
    }
    //endregion

    //region /*** Тактика - Атака ***/
    public void setTacticsAttackStart(boolean active) {
        setting.putBoolean("AttackStart", active);
        setting.flush();
    }

    public boolean getTacticsAttackStart() {
        return setting.getBoolean("AttackStart");
    }

    public void setTacticsAttackGenerator(boolean active) {
        setting.putBoolean("AttackGenerator", active);
        setting.flush();
    }

    public boolean getTacticsAttackGenerator() {
        return setting.getBoolean("AttackGenerator");
    }

    public void setTacticsAttackGeneratorPowerShot(int power) {
        setting.putInteger("AttackGeneratorPowerShot", setting.getInteger("AttackGeneratorPowerShot") + power);
        setting.flush();
    }

    public int getTacticsAttackGeneratorPowerShot() {
        return setting.getInteger("AttackGeneratorPowerShot");
    }

    public void setTacticsAttackGeneratorEnergy(int energy) {
        setting.putInteger("AttackGeneratorEnergy", setting.getInteger("AttackGeneratorEnergy") - energy);
        setting.flush();
    }

    public int getTacticsAttackGeneratorEnergy() {
        return setting.getInteger("AttackGeneratorEnergy");
    }

    public void setTacticsAttackPowerShot(int power) {
        setting.putInteger("AttackPowerShot", setting.getInteger("AttackPowerShot") + power);
        setting.flush();
    }

    public int getTacticsAttackPowerShot() {
        return setting.getInteger("AttackPowerShot");
    }

    public void setTacticsAttackLauncherGun(boolean active) {
        setting.putBoolean("AttackLauncherGun", active);
        setting.flush();
    }

    public boolean getTacticsAttackLauncherGun() {
        return setting.getBoolean("AttackLauncherGun");
    }

    public void setTacticsAttackLauncherGunEnergy(int energy) {
        setting.putInteger("AttackLauncherGunEnergy", setting.getInteger("AttackLauncherGunEnergy") - energy);
        setting.flush();
    }

    public int getTacticsAttackLauncherGunEnergy() {
        return setting.getInteger("AttackLauncherGunEnergy");
    }

    public void setTacticsAttackFlareGun(boolean active) {
        setting.putBoolean("AttackFlareGun", active);
        setting.flush();
    }

    public boolean getTacticsAttackFlareGun() {
        return setting.getBoolean("AttackFlareGun");
    }

    public void setTacticsAttackFlareGunEnergy(int energy) {
        setting.putInteger("AttackFlareGunEnergy", setting.getInteger("AttackFlareGunEnergy") - energy);
        setting.flush();
    }

    public int getTacticsAttackFlareGunEnergy() {
        return setting.getInteger("AttackFlareGunEnergy");
    }

    public void setTacticsAttackLaserGun(boolean active) {
        setting.putBoolean("AttackLaserGun", active);
        setting.flush();
    }

    public boolean getTacticsAttackLaserGun() {
        return setting.getBoolean("AttackLaserGun");
    }

    public void setTacticsAttackLaserGunEnergy(int energy) {
        setting.putInteger("AttackLaserGunEnergy", setting.getInteger("AttackLaserGunEnergy") - energy);
        setting.flush();
    }

    public int getTacticsAttackLaserGunEnergy() {
        return setting.getInteger("AttackLaserGunEnergy");
    }
    //endregion

    //region /*** Тактика - Оборона ***/
    public void setTacticsDefenseStart(boolean active) {
        setting.putBoolean("DefenseStart", active);
        setting.flush();
    }

    public boolean getTacticsDefenseStart() {
        return setting.getBoolean("DefenseStart");
    }

    public void setTacticsDefenseGenerator(boolean active) {
        setting.putBoolean("DefenseGenerator", active);
        setting.flush();
    }

    public boolean getTacticsDefenseGenerator() {
        return setting.getBoolean("DefenseGenerator");
    }

    public void setTacticsDefenseGeneratorPowerShield(int power) {
        setting.putInteger("DefenseGeneratorPowerShield", setting.getInteger("DefenseGeneratorPowerShield") + power);
        setting.flush();
    }

    public int getTacticsDefenseGeneratorPowerShield() {
        return setting.getInteger("DefenseGeneratorPowerShield");
    }

    public void setTacticsDefenseGeneratorEnergy(int energy) {
        setting.putInteger("DefenseGeneratorEnergy", setting.getInteger("DefenseGeneratorEnergy") - energy);
        setting.flush();
    }

    public int getTacticsDefenseGeneratorEnergy() {
        return setting.getInteger("DefenseGeneratorEnergy");
    }

    public void setTacticsDefenseHeartLife(int power) {
        setting.putInteger("DefenseHeartLife", setting.getInteger("DefenseHeartLife") + power);
        setting.flush();
    }

    public int getTacticsDefenseHeartLife() {
        return setting.getInteger("DefenseHeartLife");
    }

    public void setTacticsDefenseShieldHP(boolean active) {
        setting.putBoolean("DefenseShieldHP", active);
        setting.flush();
    }

    public boolean getTacticsDefenseShieldHP() {
        return setting.getBoolean("DefenseShieldHP");
    }

    public void setTacticsDefenseShieldHPup(int power) {
        setting.putInteger("DefenseShieldHPup", setting.getInteger("DefenseShieldHPup") + power);
        setting.flush();
    }

    public int getTacticsDefenseShieldHPup() {
        return setting.getInteger("DefenseShieldHPup");
    }

    public void setTacticsDefenseEnergy(boolean active) {
        setting.putBoolean("DefenseEnergy", active);
        setting.flush();
    }

    public boolean getTacticsDefenseEnergy() {
        return setting.getBoolean("DefenseEnergy");
    }

    public void setTacticsDefenseEnergyUp(int power) {
        setting.putInteger("DefenseEnergyUp", setting.getInteger("DefenseEnergyUp") + power);
        setting.flush();
    }

    public int getTacticsDefenseEnergyUp() {
        return setting.getInteger("DefenseEnergyUp");
    }

    public void setTacticsDefenseMicrowave(boolean active) {
        setting.putBoolean("DefenseMicrowave", active);
        setting.flush();
    }

    public boolean getTacticsDefenseMicrowave() {
        return setting.getBoolean("DefenseMicrowave");
    }

    public void setTacticsDefenseMicrowaveUp(float power) {
        setting.putFloat("DefenseMicrowaveUp", setting.getFloat("DefenseMicrowaveUp") + power);
        setting.flush();
    }

    public float getTacticsDefenseMicrowaveUp() {
        return setting.getFloat("DefenseMicrowaveUp");
    }
    //endregion

    //region /*** Тактика - Технологии ***/
    public void setTacticsTechnologiesStart(boolean active) {
        setting.putBoolean("TechnologiesStart", active);
        setting.flush();
    }

    public boolean getTacticsTechnologiesStart() {
        return setting.getBoolean("TechnologiesStart");
    }

    public void setTacticsTechnologiesRadar(boolean active) {
        setting.putBoolean("TechnologiesRadar", active);
        setting.flush();
    }

    public boolean getTacticsTechnologiesRadar() {
        return setting.getBoolean("TechnologiesRadar");
    }

    public void setTacticsTechnologiesShowMonsterLife(boolean active) {
        setting.putBoolean("TechnologiesShowMonsterLife", active);
        setting.flush();
    }

    public boolean getTacticsTechnologiesShowMonsterLife() {
        return setting.getBoolean("TechnologiesShowMonsterLife");
    }

    public void setTacticsTechnologiesRadarEnergy(int energy) {
        setting.putInteger("TechnologiesRadarEnergy", setting.getInteger("TechnologiesRadarEnergy") - energy);
        setting.flush();
    }

    public int getTacticsTechnologiesRadarEnergy() {
        return setting.getInteger("TechnologiesRadarEnergy");
    }

    public void setTacticsTechnologiesRobot(int robot) {
        setting.putInteger("TechnologiesRobot", setting.getInteger("TechnologiesRobot") + robot);
        setting.flush();
    }

    public int getTacticsTechnologiesRobot() {
        return setting.getInteger("TechnologiesRobot");
    }

    public void setTacticsTechnologiesPower(boolean active) {
        setting.putBoolean("TechnologiesPower", active);
        setting.flush();
    }

    public boolean getTacticsTechnologiesPower() {
        return setting.getBoolean("TechnologiesPower");
    }

    public void setTacticsTechnologiesPowerEnergy(int power) {
        setting.putInteger("TechnologiesPowerEnergy", setting.getInteger("TechnologiesPowerEnergy") + power);
        setting.flush();
    }

    public int getTacticsTechnologiesPowerEnergy() {
        return setting.getInteger("TechnologiesPowerEnergy");
    }

    public void setTacticsTechnologiesCarryingCapacity(int robot) {
        setting.putInteger("TechnologiesCarryingCapacity", setting.getInteger("TechnologiesCarryingCapacity") + robot);
        setting.flush();
    }

    public int getTacticsTechnologiesCarryingCapacity() {
        return setting.getInteger("TechnologiesCarryingCapacity");
    }

    public void setTacticsTechnologiesRobotSpeed(int power) {
        setting.putInteger("TechnologiesRobotSpeed", setting.getInteger("TechnologiesRobotSpeed") + power);
        setting.flush();
    }

    public int getTacticsTechnologiesRobotSpeed() {
        return setting.getInteger("TechnologiesRobotSpeed");
    }

    public void setTacticsTechnologiesConverter(boolean active) {
        setting.putBoolean("TechnologiesConverter", active);
        setting.flush();
    }

    public boolean getTacticsTechnologiesConverter() {
        return setting.getBoolean("TechnologiesConverter");
    }

    public void setTacticsTechnologiesConverterLife(int energy) {
        setting.putInteger("TechnologiesConverterLife", setting.getInteger("TechnologiesConverterLife") + energy);
        setting.flush();
    }

    public int getTacticsTechnologiesConverterLife() {
        return setting.getInteger("TechnologiesConverterLife");
    }
    //endregion

    //region /*** Crystals missions ***/
    public void setCrystal(String mission, int minus) {
        if (mission.equals("Missions_1_1")) setting.putInteger("Crystal_1_1", setting.getInteger("Crystal_1_1") - minus);
        else if (mission.equals("Missions_1_2")) setting.putInteger("Crystal_1_2", setting.getInteger("Crystal_1_2") - minus);
        else if (mission.equals("Missions_1_3")) setting.putInteger("Crystal_1_3", setting.getInteger("Crystal_1_3") - minus);
        else if (mission.equals("Missions_1_4")) setting.putInteger("Crystal_1_4", setting.getInteger("Crystal_1_4") - minus);
        else if (mission.equals("Missions_1_5")) setting.putInteger("Crystal_1_5", setting.getInteger("Crystal_1_5") - minus);
        else if (mission.equals("Missions_1_6")) setting.putInteger("Crystal_1_6", setting.getInteger("Crystal_1_6") - minus);
        else if (mission.equals("Missions_2_1")) setting.putInteger("Crystal_2_1", setting.getInteger("Crystal_2_1") - minus);
        else if (mission.equals("Missions_2_2")) setting.putInteger("Crystal_2_2", setting.getInteger("Crystal_2_2") - minus);
        else if (mission.equals("Missions_2_3")) setting.putInteger("Crystal_2_3", setting.getInteger("Crystal_2_3") - minus);
        else if (mission.equals("Missions_2_4")) setting.putInteger("Crystal_2_4", setting.getInteger("Crystal_2_4") - minus);
        else if (mission.equals("Missions_2_5")) setting.putInteger("Crystal_2_5", setting.getInteger("Crystal_2_5") - minus);
        else if (mission.equals("Missions_2_6")) setting.putInteger("Crystal_2_6", setting.getInteger("Crystal_2_6") - minus);
        else if (mission.equals("Missions_3_1")) setting.putInteger("Crystal_3_1", setting.getInteger("Crystal_3_1") - minus);
        else if (mission.equals("Missions_3_2")) setting.putInteger("Crystal_3_2", setting.getInteger("Crystal_3_2") - minus);
        else if (mission.equals("Missions_3_3")) setting.putInteger("Crystal_3_3", setting.getInteger("Crystal_3_3") - minus);
        else if (mission.equals("Missions_3_4")) setting.putInteger("Crystal_3_4", setting.getInteger("Crystal_3_4") - minus);
        else if (mission.equals("Missions_3_5")) setting.putInteger("Crystal_3_5", setting.getInteger("Crystal_3_5") - minus);
        else if (mission.equals("Missions_3_6")) setting.putInteger("Crystal_3_6", setting.getInteger("Crystal_3_6") - minus);
        else if (mission.equals("Missions_4_1")) setting.putInteger("Crystal_4_1", setting.getInteger("Crystal_4_1") - minus);
        else if (mission.equals("Missions_4_2")) setting.putInteger("Crystal_4_2", setting.getInteger("Crystal_4_2") - minus);
        else if (mission.equals("Missions_4_3")) setting.putInteger("Crystal_4_3", setting.getInteger("Crystal_4_3") - minus);
        else if (mission.equals("Missions_4_4")) setting.putInteger("Crystal_4_4", setting.getInteger("Crystal_4_4") - minus);
        else if (mission.equals("Missions_4_5")) setting.putInteger("Crystal_4_5", setting.getInteger("Crystal_4_5") - minus);
        else if (mission.equals("Missions_4_6")) setting.putInteger("Crystal_4_6", setting.getInteger("Crystal_4_6") - minus);
        setting.flush();
    }

    public int getCrystal(String mission) {
        if (mission.equals("Missions_1_1")) return setting.getInteger("Crystal_1_1");
        else if (mission.equals("Missions_1_2")) return setting.getInteger("Crystal_1_2");
        else if (mission.equals("Missions_1_3")) return setting.getInteger("Crystal_1_3");
        else if (mission.equals("Missions_1_4")) return setting.getInteger("Crystal_1_4");
        else if (mission.equals("Missions_1_5")) return setting.getInteger("Crystal_1_5");
        else if (mission.equals("Missions_1_6")) return setting.getInteger("Crystal_1_6");
        else if (mission.equals("Missions_2_1")) return setting.getInteger("Crystal_2_1");
        else if (mission.equals("Missions_2_2")) return setting.getInteger("Crystal_2_2");
        else if (mission.equals("Missions_2_3")) return setting.getInteger("Crystal_2_3");
        else if (mission.equals("Missions_2_4")) return setting.getInteger("Crystal_2_4");
        else if (mission.equals("Missions_2_5")) return setting.getInteger("Crystal_2_5");
        else if (mission.equals("Missions_2_6")) return setting.getInteger("Crystal_2_6");
        else if (mission.equals("Missions_3_1")) return setting.getInteger("Crystal_3_1");
        else if (mission.equals("Missions_3_2")) return setting.getInteger("Crystal_3_2");
        else if (mission.equals("Missions_3_3")) return setting.getInteger("Crystal_3_3");
        else if (mission.equals("Missions_3_4")) return setting.getInteger("Crystal_3_4");
        else if (mission.equals("Missions_3_5")) return setting.getInteger("Crystal_3_5");
        else if (mission.equals("Missions_3_6")) return setting.getInteger("Crystal_3_6");
        else if (mission.equals("Missions_4_1")) return setting.getInteger("Crystal_4_1");
        else if (mission.equals("Missions_4_2")) return setting.getInteger("Crystal_4_2");
        else if (mission.equals("Missions_4_3")) return setting.getInteger("Crystal_4_3");
        else if (mission.equals("Missions_4_4")) return setting.getInteger("Crystal_4_4");
        else if (mission.equals("Missions_4_5")) return setting.getInteger("Crystal_4_5");
        else if (mission.equals("Missions_4_6")) return setting.getInteger("Crystal_4_6");
        else return 0;
    }
    //endregion

    //region /*** Story mission ***/
    private void settingStory() {
        //region 1
        setting.putBoolean("StoryStart_1_1", false);
        setting.putBoolean("StoryStart_1_2", false);
        setting.putBoolean("StoryStart_1_3", false);
        setting.putBoolean("StoryStart_1_4", false);
        setting.putBoolean("StoryStart_1_5", false);
        setting.putBoolean("StoryStart_1_6", false);

        setting.putBoolean("StoryFinish_1_1", false);
        setting.putBoolean("StoryFinish_1_2", false);
        setting.putBoolean("StoryFinish_1_3", false);
        setting.putBoolean("StoryFinish_1_4", false);
        setting.putBoolean("StoryFinish_1_5", false);
        setting.putBoolean("StoryFinish_1_6", false);
        //endregion
        //region 2
        setting.putBoolean("StoryStart_2_1", false);
        setting.putBoolean("StoryStart_2_2", false);
        setting.putBoolean("StoryStart_2_3", false);
        setting.putBoolean("StoryStart_2_4", false);
        setting.putBoolean("StoryStart_2_5", false);
        setting.putBoolean("StoryStart_2_6", false);

        setting.putBoolean("StoryFinish_2_1", false);
        setting.putBoolean("StoryFinish_2_2", false);
        setting.putBoolean("StoryFinish_2_3", false);
        setting.putBoolean("StoryFinish_2_4", false);
        setting.putBoolean("StoryFinish_2_5", false);
        setting.putBoolean("StoryFinish_2_6", false);
        //endregion
        //region 3
        setting.putBoolean("StoryStart_3_1", false);
        setting.putBoolean("StoryStart_3_2", false);
        setting.putBoolean("StoryStart_3_3", false);
        setting.putBoolean("StoryStart_3_4", false);
        setting.putBoolean("StoryStart_3_5", false);
        setting.putBoolean("StoryStart_3_6", false);

        setting.putBoolean("StoryFinish_3_1", false);
        setting.putBoolean("StoryFinish_3_2", false);
        setting.putBoolean("StoryFinish_3_3", false);
        setting.putBoolean("StoryFinish_3_4", false);
        setting.putBoolean("StoryFinish_3_5", false);
        setting.putBoolean("StoryFinish_3_6", false);
        //endregion
        //region 4
        setting.putBoolean("StoryStart_4_1", false);
        setting.putBoolean("StoryStart_4_2", false);
        setting.putBoolean("StoryStart_4_3", false);
        setting.putBoolean("StoryStart_4_4", false);
        setting.putBoolean("StoryStart_4_5", false);
        setting.putBoolean("StoryStart_4_6", false);

        setting.putBoolean("StoryFinish_4_1", false);
        setting.putBoolean("StoryFinish_4_2", false);
        setting.putBoolean("StoryFinish_4_3", false);
        setting.putBoolean("StoryFinish_4_4", false);
        setting.putBoolean("StoryFinish_4_5", false);
        setting.putBoolean("StoryFinish_4_6", false);
        //endregion
    }

    public void setStoryStart(String mission, int balls) {
        if (mission.equals("Missions_1_1")) setting.putBoolean("StoryStart_1_1", true);
        else if (mission.equals("Missions_1_2")) setting.putBoolean("StoryStart_1_2", true);
        else if (mission.equals("Missions_1_3")) setting.putBoolean("StoryStart_1_3", true);
        else if (mission.equals("Missions_1_4")) setting.putBoolean("StoryStart_1_4", true);
        else if (mission.equals("Missions_1_5")) setting.putBoolean("StoryStart_1_5", true);
        else if (mission.equals("Missions_1_6")) setting.putBoolean("StoryStart_1_6", true);
        else if (mission.equals("Missions_2_1")) setting.putBoolean("StoryStart_2_1", true);
        else if (mission.equals("Missions_2_2")) setting.putBoolean("StoryStart_2_2", true);
        else if (mission.equals("Missions_2_3")) setting.putBoolean("StoryStart_2_3", true);
        else if (mission.equals("Missions_2_4")) setting.putBoolean("StoryStart_2_4", true);
        else if (mission.equals("Missions_2_5")) setting.putBoolean("StoryStart_2_5", true);
        else if (mission.equals("Missions_2_6")) setting.putBoolean("StoryStart_2_6", true);
        else if (mission.equals("Missions_3_1")) setting.putBoolean("StoryStart_3_1", true);
        else if (mission.equals("Missions_3_2")) setting.putBoolean("StoryStart_3_2", true);
        else if (mission.equals("Missions_3_3")) setting.putBoolean("StoryStart_3_3", true);
        else if (mission.equals("Missions_3_4")) setting.putBoolean("StoryStart_3_4", true);
        else if (mission.equals("Missions_3_5")) setting.putBoolean("StoryStart_3_5", true);
        else if (mission.equals("Missions_3_6")) setting.putBoolean("StoryStart_3_6", true);
        else if (mission.equals("Missions_4_1")) setting.putBoolean("StoryStart_4_1", true);
        else if (mission.equals("Missions_4_2")) setting.putBoolean("StoryStart_4_2", true);
        else if (mission.equals("Missions_4_3")) setting.putBoolean("StoryStart_4_3", true);
        else if (mission.equals("Missions_4_4")) setting.putBoolean("StoryStart_4_4", true);
        else if (mission.equals("Missions_4_5")) setting.putBoolean("StoryStart_4_5", true);
        else if (mission.equals("Missions_4_6")) setting.putBoolean("StoryStart_4_6", true);
        setting.putInteger("StoryBalls", setting.getInteger("StoryBalls") + balls);
        setting.flush();
    }

    public void setStoryFinish(String mission, int balls) {
        if (mission.equals("Missions_1_1")) setting.putBoolean("StoryFinish_1_1", true);
        else if (mission.equals("Missions_1_2")) setting.putBoolean("StoryFinish_1_2", true);
        else if (mission.equals("Missions_1_3")) setting.putBoolean("StoryFinish_1_3", true);
        else if (mission.equals("Missions_1_4")) setting.putBoolean("StoryFinish_1_4", true);
        else if (mission.equals("Missions_1_5")) setting.putBoolean("StoryFinish_1_5", true);
        else if (mission.equals("Missions_1_6")) setting.putBoolean("StoryFinish_1_6", true);
        else if (mission.equals("Missions_2_1")) setting.putBoolean("StoryFinish_2_1", true);
        else if (mission.equals("Missions_2_2")) setting.putBoolean("StoryFinish_2_2", true);
        else if (mission.equals("Missions_2_3")) setting.putBoolean("StoryFinish_2_3", true);
        else if (mission.equals("Missions_2_4")) setting.putBoolean("StoryFinish_2_4", true);
        else if (mission.equals("Missions_2_5")) setting.putBoolean("StoryFinish_2_5", true);
        else if (mission.equals("Missions_2_6")) setting.putBoolean("StoryFinish_2_6", true);
        else if (mission.equals("Missions_3_1")) setting.putBoolean("StoryFinish_3_1", true);
        else if (mission.equals("Missions_3_2")) setting.putBoolean("StoryFinish_3_2", true);
        else if (mission.equals("Missions_3_3")) setting.putBoolean("StoryFinish_3_3", true);
        else if (mission.equals("Missions_3_4")) setting.putBoolean("StoryFinish_3_4", true);
        else if (mission.equals("Missions_3_5")) setting.putBoolean("StoryFinish_3_5", true);
        else if (mission.equals("Missions_3_6")) setting.putBoolean("StoryFinish_3_6", true);
        else if (mission.equals("Missions_4_1")) setting.putBoolean("StoryFinish_4_1", true);
        else if (mission.equals("Missions_4_2")) setting.putBoolean("StoryFinish_4_2", true);
        else if (mission.equals("Missions_4_3")) setting.putBoolean("StoryFinish_4_3", true);
        else if (mission.equals("Missions_4_4")) setting.putBoolean("StoryFinish_4_4", true);
        else if (mission.equals("Missions_4_5")) setting.putBoolean("StoryFinish_4_5", true);
        else if (mission.equals("Missions_4_6")) setting.putBoolean("StoryFinish_4_6", true);
        setting.putInteger("StoryBalls", setting.getInteger("StoryBalls") + balls);
        setting.flush();
    }

    public boolean getStoryStart(String mission) {
        if (mission.equals("Missions_1_1")) return setting.getBoolean("StoryStart_1_1");
        else if (mission.equals("Missions_1_2")) return setting.getBoolean("StoryStart_1_2");
        else if (mission.equals("Missions_1_3")) return setting.getBoolean("StoryStart_1_3");
        else if (mission.equals("Missions_1_4")) return setting.getBoolean("StoryStart_1_4");
        else if (mission.equals("Missions_1_5")) return setting.getBoolean("StoryStart_1_5");
        else if (mission.equals("Missions_1_6")) return setting.getBoolean("StoryStart_1_6");
        else if (mission.equals("Missions_2_1")) return setting.getBoolean("StoryStart_2_1");
        else if (mission.equals("Missions_2_2")) return setting.getBoolean("StoryStart_2_2");
        else if (mission.equals("Missions_2_3")) return setting.getBoolean("StoryStart_2_3");
        else if (mission.equals("Missions_2_4")) return setting.getBoolean("StoryStart_2_4");
        else if (mission.equals("Missions_2_5")) return setting.getBoolean("StoryStart_2_5");
        else if (mission.equals("Missions_2_6")) return setting.getBoolean("StoryStart_2_6");
        else if (mission.equals("Missions_3_1")) return setting.getBoolean("StoryStart_3_1");
        else if (mission.equals("Missions_3_2")) return setting.getBoolean("StoryStart_3_2");
        else if (mission.equals("Missions_3_3")) return setting.getBoolean("StoryStart_3_3");
        else if (mission.equals("Missions_3_4")) return setting.getBoolean("StoryStart_3_4");
        else if (mission.equals("Missions_3_5")) return setting.getBoolean("StoryStart_3_5");
        else if (mission.equals("Missions_3_6")) return setting.getBoolean("StoryStart_3_6");
        else if (mission.equals("Missions_4_1")) return setting.getBoolean("StoryStart_4_1");
        else if (mission.equals("Missions_4_2")) return setting.getBoolean("StoryStart_4_2");
        else if (mission.equals("Missions_4_3")) return setting.getBoolean("StoryStart_4_3");
        else if (mission.equals("Missions_4_4")) return setting.getBoolean("StoryStart_4_4");
        else if (mission.equals("Missions_4_5")) return setting.getBoolean("StoryStart_4_5");
        else if (mission.equals("Missions_4_6")) return setting.getBoolean("StoryStart_4_6");
        else return true;
    }

    public boolean getStoryFinish(String mission) {
        if (mission.equals("Missions_1_1")) return setting.getBoolean("StoryFinish_1_1");
        else if (mission.equals("Missions_1_2")) return setting.getBoolean("StoryFinish_1_2");
        else if (mission.equals("Missions_1_3")) return setting.getBoolean("StoryFinish_1_3");
        else if (mission.equals("Missions_1_4")) return setting.getBoolean("StoryFinish_1_4");
        else if (mission.equals("Missions_1_5")) return setting.getBoolean("StoryFinish_1_5");
        else if (mission.equals("Missions_1_6")) return setting.getBoolean("StoryFinish_1_6");
        else if (mission.equals("Missions_2_1")) return setting.getBoolean("StoryFinish_2_1");
        else if (mission.equals("Missions_2_2")) return setting.getBoolean("StoryFinish_2_2");
        else if (mission.equals("Missions_2_3")) return setting.getBoolean("StoryFinish_2_3");
        else if (mission.equals("Missions_2_4")) return setting.getBoolean("StoryFinish_2_4");
        else if (mission.equals("Missions_2_5")) return setting.getBoolean("StoryFinish_2_5");
        else if (mission.equals("Missions_2_6")) return setting.getBoolean("StoryFinish_2_6");
        else if (mission.equals("Missions_3_1")) return setting.getBoolean("StoryFinish_3_1");
        else if (mission.equals("Missions_3_2")) return setting.getBoolean("StoryFinish_3_2");
        else if (mission.equals("Missions_3_3")) return setting.getBoolean("StoryFinish_3_3");
        else if (mission.equals("Missions_3_4")) return setting.getBoolean("StoryFinish_3_4");
        else if (mission.equals("Missions_3_5")) return setting.getBoolean("StoryFinish_3_5");
        else if (mission.equals("Missions_3_6")) return setting.getBoolean("StoryFinish_3_6");
        else if (mission.equals("Missions_4_1")) return setting.getBoolean("StoryFinish_4_1");
        else if (mission.equals("Missions_4_2")) return setting.getBoolean("StoryFinish_4_2");
        else if (mission.equals("Missions_4_3")) return setting.getBoolean("StoryFinish_4_3");
        else if (mission.equals("Missions_4_4")) return setting.getBoolean("StoryFinish_4_4");
        else if (mission.equals("Missions_4_5")) return setting.getBoolean("StoryFinish_4_5");
        else if (mission.equals("Missions_4_6")) return setting.getBoolean("StoryFinish_4_6");
        else return true;
    }
    //endregion

    //region GPGS
    public void setRecordTop(int score) {
        setting.putInteger("RecordTop", getRecordTop() + score);
        setting.flush();
        MarsGame.playServices.recordGPGS("Top", getRecordTop());
    }

    public int getRecordTop() {
        return setting.getInteger("RecordTop");
    }

    public void setAchievementMoney(int money) {
        if (money > 5000) {
            if (!setting.getBoolean("AchievementInitialCapital")) {
                setting.putBoolean("AchievementInitialCapital", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQDA");
                setRecordTop(500);
            }
        }
        if (money > 50000) {
            if (!setting.getBoolean("AchievementSuccessfulInvestment")) {
                setting.putBoolean("AchievementSuccessfulInvestment", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQDQ");
                setRecordTop(1000);
            }
        }
        if (money > 250000) {
            if (!setting.getBoolean("AchievementYoungBusinessman")) {
                setting.putBoolean("AchievementYoungBusinessman", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQDg");
                setRecordTop(1500);
            }
        }
        if (money > 500000) {
            if (!setting.getBoolean("AchievementExcellentBusinessman")) {
                setting.putBoolean("AchievementExcellentBusinessman", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQDw");
                setRecordTop(2000);
            }
        }
        if (money > 1000000) {
            if (!setting.getBoolean("AchievementMyFirstMillion")) {
                setting.putBoolean("AchievementMyFirstMillion", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQEA");
                setRecordTop(2500);
            }
        }
    }

    public void setAchievementMoneyRemove(int money) {
        if (money > 8000) {
            if (!setting.getBoolean("AchievementBum")) {
                setting.putBoolean("AchievementBum", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQHw");
                setRecordTop(500);
            }
        }
        if (money > 75000) {
            if (!setting.getBoolean("AchievementSpender")) {
                setting.putBoolean("AchievementSpender", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQIA");
                setRecordTop(1000);
            }
        }
        if (money > 325000) {
            if (!setting.getBoolean("AchievementStandStill")) {
                setting.putBoolean("AchievementStandStill", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQKA");
                setRecordTop(1500);
            }
        }
        if (money > 800000) {
            if (!setting.getBoolean("AchievementBorrower")) {
                setting.putBoolean("AchievementBorrower", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQKQ");
                setRecordTop(2000);
            }
        }
        if (money > 1750000) {
            if (!setting.getBoolean("AchievementOfficial")) {
                setting.putBoolean("AchievementOfficial", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQKg");
                setRecordTop(2500);
            }
        }
    }

    public void setAchievementMineral(int mineral) {
        if (mineral > 1000) {
            if (!setting.getBoolean("AchievementDigger")) {
                setting.putBoolean("AchievementDigger", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQEQ");
                setRecordTop(500);
            }
        }
        if (mineral > 2500) {
            if (!setting.getBoolean("AchievementExtractor")) {
                setting.putBoolean("AchievementExtractor", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQEg");
                setRecordTop(1000);
            }
        }
        if (mineral > 5000) {
            if (!setting.getBoolean("AchievementIdealCrystals")) {
                setting.putBoolean("AchievementIdealCrystals", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQEw");
                setRecordTop(1500);
            }
        }
        if (mineral > 25000) {
            if (!setting.getBoolean("AchievementPreciousDiamonds")) {
                setting.putBoolean("AchievementPreciousDiamonds", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQFA");
                setRecordTop(2000);
            }
        }
        if (mineral > 75000) {
            if (!setting.getBoolean("AchievementMiner")) {
                setting.putBoolean("AchievementMiner", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQFQ");
                setRecordTop(2500);
            }
        }
    }

    public void setAchievementMineralRemove(int mineral) {
        if (mineral > 4000) {
            if (!setting.getBoolean("AchievementSpeculator")) {
                setting.putBoolean("AchievementSpeculator", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQKw");
                setRecordTop(500);
            }
        }
        if (mineral > 12000) {
            if (!setting.getBoolean("AchievementMolybdenum")) {
                setting.putBoolean("AchievementMolybdenum", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQLA");
                setRecordTop(1000);
            }
        }
        if (mineral > 20000) {
            if (!setting.getBoolean("AchievementWhySoMany")) {
                setting.putBoolean("AchievementWhySoMany", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQLQ");
                setRecordTop(1500);
            }
        }
        if (mineral > 73005) {
            if (!setting.getBoolean("AchievementYouSteal")) {
                setting.putBoolean("AchievementYouSteal", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQLg");
                setRecordTop(2000);
            }
        }
        if (mineral > 160000) {
            if (!setting.getBoolean("AchievementDidYouGetItYourself")) {
                setting.putBoolean("AchievementDidYouGetItYourself", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQLw");
                setRecordTop(2500);
            }
        }
    }

    public void setAchievementBoss(int boss) {
        if (boss == 1) {
            if (!setting.getBoolean("AchievementBoss1")) {
                setting.putBoolean("AchievementBoss1", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQFg");
                setRecordTop(5000);
            }
        } else if (boss == 2) {
            if (!setting.getBoolean("AchievementBoss2")) {
                setting.putBoolean("AchievementBoss2", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQFw");
                setRecordTop(5000);
            }
        } else if (boss == 3) {
            if (!setting.getBoolean("AchievementBoss3")) {
                setting.putBoolean("AchievementBoss3", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQGA");
                setRecordTop(5000);
            }
        } else if (boss == 4) {
            if (!setting.getBoolean("AchievementBoss4")) {
                setting.putBoolean("AchievementBoss4", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQGQ");
                setRecordTop(5000);
            }
        } else if (boss == 5) {
            if (!setting.getBoolean("AchievementBoss5")) {
                setting.putBoolean("AchievementBoss5", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQIg");
                setRecordTop(5000);
            }
        } else if (boss == 6) {
            if (!setting.getBoolean("AchievementBoss6")) {
                setting.putBoolean("AchievementBoss6", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQIw");
                setRecordTop(5000);
            }
        } else if (boss == 7) {
            if (!setting.getBoolean("AchievementBoss7")) {
                setting.putBoolean("AchievementBoss7", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQJA");
                setRecordTop(5000);
            }
        } else if (boss == 8) {
            if (!setting.getBoolean("AchievementBoss8")) {
                setting.putBoolean("AchievementBoss8", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQJQ");
                setRecordTop(5000);
            }
        } else if (boss == 9) {
            if (!setting.getBoolean("AchievementBoss9")) {
                setting.putBoolean("AchievementBoss9", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQJg");
                setRecordTop(5000);
            }
        } else if (boss == 10) {
            if (!setting.getBoolean("AchievementBoss10")) {
                setting.putBoolean("AchievementBoss10", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQJw");
                setRecordTop(5000);
            }
        }
    }

    public void setAchievementKilling(int kills) {
        if (kills > 1000) {
            if (!setting.getBoolean("AchievementSoldier")) {
                setting.putBoolean("AchievementSoldier", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQGg");
                setRecordTop(500);
            }
        }
        if (kills > 5000) {
            if (!setting.getBoolean("AchievementSniper")) {
                setting.putBoolean("AchievementSniper", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQGw");
                setRecordTop(1000);
            }
        }
        if (kills > 10000) {
            if (!setting.getBoolean("AchievementKiller")) {
                setting.putBoolean("AchievementKiller", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQHA");
                setRecordTop(1500);
            }
        }
        if (kills > 25000) {
            if (!setting.getBoolean("AchievementTerminator")) {
                setting.putBoolean("AchievementTerminator", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQHQ");
                setRecordTop(2000);
            }
        }
        if (kills > 50000) {
            if (!setting.getBoolean("AchievementMeatGrinder")) {
                setting.putBoolean("AchievementMeatGrinder", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQHg");
                setRecordTop(2500);
            }
        }
        if (kills > 100000) {
            if (!setting.getBoolean("AchievementTheRipper")) {
                setting.putBoolean("AchievementTheRipper", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQIQ");
                setRecordTop(3000);
            }
        }
    }

    public void setAchievementDeath() {
        if (!setting.getBoolean("AchievementDeath")) {
            setting.putBoolean("AchievementDeath", true);
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQMQ");
            setRecordTop(500);
            setting.flush();
        }
    }

    public void setAchievementDaysOfGame() {
        if (getRewardDay() == 3) {
            if (!setting.getBoolean("AchievementDaysOfGame3")) {
                setting.putBoolean("AchievementDaysOfGame3", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQNQ");
                setRecordTop(500);
                setting.flush();
            }
        } else if (getRewardDay() == 7) {
            if (!setting.getBoolean("AchievementDaysOfGame7")) {
                setting.putBoolean("AchievementDaysOfGame7", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQNg");
                setRecordTop(500);
                setting.flush();
            }
        }
    }

    public void setAchievementAccumulation() {
        if (loadMoney() >= 350000) {
            if (!setting.getBoolean("AchievementBanker")) {
                setting.putBoolean("AchievementBanker", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQNw");
                setRecordTop(500);
                setting.flush();
            }
        }
        if (loadMineral() >= 125000) {
            if (!setting.getBoolean("AchievementCrystalSoldier")) {
                setting.putBoolean("AchievementCrystalSoldier", true);
                MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQOA");
                setRecordTop(500);
                setting.flush();
            }
        }
    }

    public void setAchievement4Stars() {
        if (!setting.getBoolean("Achievement4Stars")) {
            setting.putBoolean("Achievement4Stars", true);
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQNA");
            setRecordTop(500);
            setting.flush();
        }
    }

    public void setAchievementStrongBase() {
        setting.putInteger("AchievementStrongBase", setting.getInteger("AchievementStrongBase") + 1);
        setting.flush();
        if (setting.getInteger("AchievementStrongBase") == 10) {
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQOQ");
            setRecordTop(500);
        }
    }

    public void setAchievementRepairOfTheBase() {
        setting.putInteger("AchievementRepairOfTheBase", setting.getInteger("AchievementRepairOfTheBase") + 1);
        setting.flush();
        if (setting.getInteger("AchievementRepairOfTheBase") == 10) {
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQOw");
            setRecordTop(500);
        }
    }

    public void setAchievementImprovedGenerator() {
        setting.putInteger("AchievementImprovedGenerator", setting.getInteger("AchievementImprovedGenerator") + 1);
        setting.flush();
        if (setting.getInteger("AchievementImprovedGenerator") == 10) {
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQOg");
            setRecordTop(500);
        }
    }

    public void setAchievementEnergyRecovery() {
        setting.putInteger("AchievementEnergyRecovery", setting.getInteger("AchievementEnergyRecovery") + 1);
        setting.flush();
        if (setting.getInteger("AchievementEnergyRecovery") == 10) {
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQPA");
            setRecordTop(500);
        }
    }

    public void setAchievementFire() {
        setting.putInteger("AchievementFire", setting.getInteger("AchievementFire") + 1);
        setting.flush();
        if (setting.getInteger("AchievementFire") == 10) {
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQPQ");
            setRecordTop(500);
        }
    }

    public void setAchievementRestorationOfFire() {
        if (!setting.getBoolean("AchievementRestorationOfFire")) {
            setting.putBoolean("AchievementRestorationOfFire", true);
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQPg");
            setRecordTop(500);
            setting.flush();
        }
    }

    public void setAchievementCold() {
        setting.putInteger("AchievementCold", setting.getInteger("AchievementCold") + 1);
        setting.flush();
        if (setting.getInteger("AchievementCold") == 10) {
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQPw");
            setRecordTop(500);
        }
    }

    public void setAchievementRestorationOfCold() {
        if (!setting.getBoolean("AchievementRestorationOfCold")) {
            setting.putBoolean("AchievementRestorationOfCold", true);
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQQA");
            setRecordTop(500);
            setting.flush();
        }
    }

    public void setAchievementPoison() {
        setting.putInteger("AchievementPoison", setting.getInteger("AchievementPoison") + 1);
        setting.flush();
        if (setting.getInteger("AchievementPoison") == 10) {
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQQQ");
            setRecordTop(500);
        }
    }

    public void setAchievementRestorationOfPoison() {
        if (!setting.getBoolean("AchievementRestorationOfPoison")) {
            setting.putBoolean("AchievementRestorationOfPoison", true);
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQQg");
            setRecordTop(500);
            setting.flush();
        }
    }

    public void setAchievementTechnologies() {
        if (!setting.getBoolean("AchievementTechnologies")) {
            setting.putBoolean("AchievementTechnologies", true);
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQQw");
            setRecordTop(500);
            setting.flush();
        }
    }

    public void setAchievementTurret() {
        setting.putInteger("AchievementTurret", setting.getInteger("AchievementTurret") + 1);
        setting.flush();
        if (setting.getInteger("AchievementTurret") == 5) {
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQRA");
            setRecordTop(500);
        } else if (setting.getInteger("AchievementTurret") == 20) {
            MarsGame.playServices.unlockAchievementGPGS("CgkIhoe1hb4LEAIQRQ");
            setRecordTop(500);
        }
    }

    public void setEventEarnMoney(int money) {
        setting.putInteger("EventEarnMoney", setting.getInteger("EventEarnMoney") + money);
        MarsGame.playServices.submitScoreGPGS("CgkIhoe1hb4LEAIQAQ", money);
        setting.flush();
    }

    public int getEventEarnMoney() {
        return setting.getInteger("EventEarnMoney");
    }

    public void setEventSpentMoney(int money) {
        setting.putInteger("EventSpentMoney", setting.getInteger("EventSpentMoney") + money);
        MarsGame.playServices.submitScoreGPGS("CgkIhoe1hb4LEAIQAg", money);
        setting.flush();
    }

    public int getEventSpentMoney() {
        return setting.getInteger("EventSpentMoney");
    }

    public void setEventEarnMinerals(int minerals) {
        setting.putInteger("EventEarnMinerals", setting.getInteger("EventEarnMinerals") + minerals);
        MarsGame.playServices.submitScoreGPGS("CgkIhoe1hb4LEAIQAw", minerals);
        setting.flush();
    }

    public int getEventEarnMinerals() {
        return setting.getInteger("EventEarnMinerals");
    }

    public void setEventSpentMinerals(int minerals) {
        setting.putInteger("EventSpentMinerals", setting.getInteger("EventSpentMinerals") + minerals);
        MarsGame.playServices.submitScoreGPGS("CgkIhoe1hb4LEAIQBA", minerals);
        setting.flush();
    }

    public int getEventSpentMinerals() {
        return setting.getInteger("EventSpentMinerals");
    }

    public void setEventKillingMonsters(int kills) {
        setting.putInteger("EventKillingMonsters", setting.getInteger("EventKillingMonsters") + kills);
        MarsGame.playServices.submitScoreGPGS("CgkIhoe1hb4LEAIQBQ", kills);
        setting.flush();
    }

    public int getEventKillingMonsters() {
        return setting.getInteger("EventKillingMonsters");
    }

    public void setEventKillingBoss(int boss) {
        if (boss == 1) MarsGame.playServices.submitScoreGPGS("CgkIhoe1hb4LEAIQCA", 1);
        else if (boss == 2) MarsGame.playServices.submitScoreGPGS("CgkIhoe1hb4LEAIQCQ", 1);
        else if (boss == 3) MarsGame.playServices.submitScoreGPGS("CgkIhoe1hb4LEAIQCg", 1);
        else if (boss == 4) MarsGame.playServices.submitScoreGPGS("CgkIhoe1hb4LEAIQCw", 1);
    }

    public void setEventDeath() {
        setting.putInteger("EventDeath", setting.getInteger("EventDeath") + 1);
        MarsGame.playServices.submitScoreGPGS("CgkIhoe1hb4LEAIQMA", 1);
        setting.flush();
    }

    public int getEventDeath() {
        return setting.getInteger("EventDeath");
    }

    public void setDeath() {
        setting.putInteger("Death", setting.getInteger("Death") + 1);
        MarsGame.playServices.submitScoreGPGS("CgkIhoe1hb4LEAIQMQ", 1);
        setting.flush();
    }

    public int getDeath() {
        return setting.getInteger("Death");
    }
    //endregion
}