package studio.rashka.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.brashmonkey.spriter.Data;
import com.brashmonkey.spriter.SCMLReader;
import com.brashmonkey.spriter.gdx.Loader;

import java.util.HashMap;
import java.util.Map;

public class Textures {

    private TextureAtlas textureButton;
    private Skin textureButtonSkin;
    public Texture load;

    private Map<String, AssetManager> spaceShip;
    public Map<String, Texture> texturesSpaceShip, texturesScreen;
    public Map<String, TextureRegion> textureRegion, textureRegionScreen; //массив регионов

    public Map<String, Data> data, dataBoss;
    public Map<String, Loader> loader, loaderBoss;

    private static volatile Textures instance;

    public static Textures getInstance() {
        if (instance == null) {
            synchronized (Textures.class) {
                if (instance == null) {
                    instance = new Textures();
                }
            }
        }
        return instance;
    }

    private Textures() {
        spaceShip = new HashMap<String, AssetManager>();

        load = new Texture("load/load.gif");
        textureButton = new TextureAtlas("buttons.texture");
        textureButtonSkin = new Skin(textureButton);
        texturesSpaceShip = new HashMap<String, Texture>();
        texturesScreen = new HashMap<String, Texture>();
        textureRegion = new HashMap<String, TextureRegion>();
        textureRegionScreen = new HashMap<String, TextureRegion>();

        data = new HashMap<String, Data>();
        dataBoss = new HashMap<String, Data>();
        loader = new HashMap<String, Loader>();
        loaderBoss = new HashMap<String, Loader>();
    }

    public void loadFile() {
        spaceShip.put("SpaceShip", new AssetManager());
        spaceShip.get("SpaceShip").load("spaceship/spaceshipFonTexture.png", Texture.class);
        spaceShip.get("SpaceShip").load("spaceship/spaceshipTexture.png", Texture.class);
        spaceShip.get("SpaceShip").load("spaceship/spaceshipTexture2.png", Texture.class);
    }

    public void loadFile2() {
        spaceShip.get("SpaceShip").load("robots/r-7.png", Texture.class);
        spaceShip.get("SpaceShip").load("robots/r-7Speak.png", Texture.class);

        spaceShip.get("SpaceShip").load("hangar/hangarPack.png", Texture.class);
        spaceShip.get("SpaceShip").load("bridge/bridgePack.png", Texture.class);
        spaceShip.get("SpaceShip").load("arsenal/arsenalPack.png", Texture.class);
        spaceShip.get("SpaceShip").load("arsenal/weaponsPack.png", Texture.class);
        spaceShip.get("SpaceShip").load("laboratory/laboratoryPack.png", Texture.class);
        spaceShip.get("SpaceShip").load("reactor/reactorPack.png", Texture.class);

        spaceShip.get("SpaceShip").load("missions/missionsPack.png", Texture.class);
        spaceShip.get("SpaceShip").load("monsters/monsterDie.png", Texture.class);
    }

    public void loadFileTexture() {
        missions();
        hangar();
        bridge();
        arsenal();
        weapons();
        laboratory();
        reactor();
        r_7();
        r_7Speak();
    }

    public void loadMonsters() {
        //region WormCave
        data.put("WormCave", new SCMLReader(Gdx.files.internal("monsters/worm_cave/monster.scml").read()).getData());
        loader.put("WormCave", new Loader(data.get("WormCave")));
        loader.get("WormCave").load(Gdx.files.internal("monsters/worm_cave/monster.scml").file());
        //endregion
        //region Worker
        data.put("Worker", new SCMLReader(Gdx.files.internal("monsters/robot/robot.scml").read()).getData());
        loader.put("Worker", new Loader(data.get("Worker")));
        loader.get("Worker").load(Gdx.files.internal("monsters/robot/robot.scml").file());
        //endregion
        //region Monster 1
        data.put("Monster_1", new SCMLReader(Gdx.files.internal("monsters/1/monster.scml").read()).getData());
        loader.put("Monster_1", new Loader(data.get("Monster_1")));
        loader.get("Monster_1").load(Gdx.files.internal("monsters/1/monster.scml").file());
        //endregion
        //region Monster 2
        data.put("Monster_2", new SCMLReader(Gdx.files.internal("monsters/2/monster.scml").read()).getData());
        loader.put("Monster_2", new Loader(data.get("Monster_2")));
        loader.get("Monster_2").load(Gdx.files.internal("monsters/2/monster.scml").file());
        //endregion
    }

    public void loadMonsters2() {
        //region Monster 3
        data.put("Monster_3", new SCMLReader(Gdx.files.internal("monsters/3/monster.scml").read()).getData());
        loader.put("Monster_3", new Loader(data.get("Monster_3")));
        loader.get("Monster_3").load(Gdx.files.internal("monsters/3/monster.scml").file());
        //endregion
        //region Monster 4
        data.put("Monster_4", new SCMLReader(Gdx.files.internal("monsters/4/monster.scml").read()).getData());
        loader.put("Monster_4", new Loader(data.get("Monster_4")));
        loader.get("Monster_4").load(Gdx.files.internal("monsters/4/monster.scml").file());
        //endregion
        //region Monster 5
        data.put("Monster_5", new SCMLReader(Gdx.files.internal("monsters/5/monster.scml").read()).getData());
        loader.put("Monster_5", new Loader(data.get("Monster_5")));
        loader.get("Monster_5").load(Gdx.files.internal("monsters/5/monster.scml").file());
        //endregion
    }

    public void loadBoss1() {
        dataBoss.put("Boss_1", new SCMLReader(Gdx.files.internal("monsters/boss_1/boss.scml").read()).getData());
        loaderBoss.put("Boss_1", new Loader(dataBoss.get("Boss_1")));
        loaderBoss.get("Boss_1").load(Gdx.files.internal("monsters/boss_1/boss.scml").file());
    }

    public void loadBoss2() {
        dataBoss.put("Boss_2", new SCMLReader(Gdx.files.internal("monsters/boss_2/boss.scml").read()).getData());
        loaderBoss.put("Boss_2", new Loader(dataBoss.get("Boss_2")));
        loaderBoss.get("Boss_2").load(Gdx.files.internal("monsters/boss_2/boss.scml").file());
    }

    public void loadBoss3() {
        dataBoss.put("Boss_3", new SCMLReader(Gdx.files.internal("monsters/boss_3/boss.scml").read()).getData());
        loaderBoss.put("Boss_3", new Loader(dataBoss.get("Boss_3")));
        loaderBoss.get("Boss_3").load(Gdx.files.internal("monsters/boss_3/boss.scml").file());
    }

    public void loadBoss4() {
        dataBoss.put("Boss_4", new SCMLReader(Gdx.files.internal("monsters/boss_4/boss.scml").read()).getData());
        loaderBoss.put("Boss_4", new Loader(dataBoss.get("Boss_4")));
        loaderBoss.get("Boss_4").load(Gdx.files.internal("monsters/boss_4/boss.scml").file());
    }

    public void clearBoss() {
        dataBoss.clear();
        loaderBoss.clear();
    }

    private void missions() {
        texturesSpaceShip.put("Missions", spaceShip.get("SpaceShip").get("missions/missionsPack.png", Texture.class));
        textureRegion.put("FonButtons", new TextureRegion(texturesSpaceShip.get("Missions"), 0, 0, 640, 214));
        textureRegion.put("BatteryMP", new TextureRegion(texturesSpaceShip.get("Missions"), 0, 214, 64, 115));
        textureRegion.put("ShieldHP", new TextureRegion(texturesSpaceShip.get("Missions"), 64, 214, 100, 110));
        textureRegion.put("ProgressHP", new TextureRegion(texturesSpaceShip.get("Missions"), 192, 256, 256, 32));
        textureRegion.put("ProgressMP", new TextureRegion(texturesSpaceShip.get("Missions"), 192, 288, 256, 32));
        textureRegion.put("ProgressMP_line", new TextureRegion(texturesSpaceShip.get("Missions"), 192, 238, 28, 18));
        textureRegion.put("MP", new TextureRegion(texturesSpaceShip.get("Missions"), 224, 224, 32, 32));
        textureRegion.put("HP", new TextureRegion(texturesSpaceShip.get("Missions"), 256, 224, 32, 32));
        textureRegion.put("Hide", new TextureRegion(texturesSpaceShip.get("Missions"), 288, 224, 32, 32));
        textureRegion.put("Black", new TextureRegion(texturesSpaceShip.get("Missions"), 576, 224, 32, 32));
        textureRegion.put("Fire", new TextureRegion(texturesSpaceShip.get("Missions"), 640, 0, 128, 128));
        textureRegion.put("Poison", new TextureRegion(texturesSpaceShip.get("Missions"), 768, 0, 128, 128));
        textureRegion.put("Ice", new TextureRegion(texturesSpaceShip.get("Missions"), 896, 0, 128, 128));
		textureRegion.put("ShieldHPAdd", new TextureRegion(texturesSpaceShip.get("Missions"), 640, 128, 128, 128));
		textureRegion.put("EnergyAdd", new TextureRegion(texturesSpaceShip.get("Missions"), 768, 128, 128, 128));
		textureRegion.put("Microwave", new TextureRegion(texturesSpaceShip.get("Missions"), 896, 128, 128, 128));
		textureRegion.put("Move", new TextureRegion(texturesSpaceShip.get("Missions"), 0, 329, 192, 192));
		textureRegion.put("Shot", new TextureRegion(texturesSpaceShip.get("Missions"), 192, 320, 192, 192));
		textureRegion.put("BallHandle", new TextureRegion(texturesSpaceShip.get("Missions"), 448, 256, 320, 128));
		textureRegion.put("MenuGames", new TextureRegion(texturesSpaceShip.get("Missions"), 0, 548, 192, 156));
		textureRegion.put("MenuGames2", new TextureRegion(texturesSpaceShip.get("Missions"), 0, 548, 80, 156));
		textureRegion.put("MenuGames3", new TextureRegion(texturesSpaceShip.get("Missions"), 0, 576, 64, 128));
		textureRegion.put("MenuGamesLine", new TextureRegion(texturesSpaceShip.get("Missions"), 32, 548, 64, 156));
		textureRegion.put("MenuGamesHome", new TextureRegion(texturesSpaceShip.get("Missions"), 768, 256, 128, 128));
		textureRegion.put("MenuGamesSettings", new TextureRegion(texturesSpaceShip.get("Missions"), 896, 256, 128, 128));
		textureRegion.put("MenuGamesRate", new TextureRegion(texturesSpaceShip.get("Missions"), 384, 384, 128, 128));
		textureRegion.put("MenuGamesNewly", new TextureRegion(texturesSpaceShip.get("Missions"), 512, 384, 128, 128));
		textureRegion.put("MenuGamesPause", new TextureRegion(texturesSpaceShip.get("Missions"), 640, 384, 128, 128));
		textureRegion.put("MenuGamesPlay", new TextureRegion(texturesSpaceShip.get("Missions"), 768, 384, 128, 128));
		textureRegion.put("MenuGamesSettingsSoundOn", new TextureRegion(texturesSpaceShip.get("Missions"), 896, 384, 128, 128));
		textureRegion.put("MenuGamesSettingsSoundOff", new TextureRegion(texturesSpaceShip.get("Missions"), 896, 512, 128, 128));
		textureRegion.put("MenuGamesSettingsVibroOff", new TextureRegion(texturesSpaceShip.get("Missions"), 768, 512, 128, 128));
		textureRegion.put("MenuGamesSettingsVibroOn", new TextureRegion(texturesSpaceShip.get("Missions"), 640, 512, 128, 128));
		textureRegion.put("MenuGamesSettingsMusicOff", new TextureRegion(texturesSpaceShip.get("Missions"), 512, 512, 128, 128));
		textureRegion.put("MenuGamesSettingsMusicOn", new TextureRegion(texturesSpaceShip.get("Missions"), 384, 512, 128, 128));
		textureRegion.put("Active", new TextureRegion(texturesSpaceShip.get("Missions"), 320, 218, 128, 38));
		textureRegion.put("NotActive", new TextureRegion(texturesSpaceShip.get("Missions"), 448, 218, 128, 38));
		textureRegion.put("Base", new TextureRegion(texturesSpaceShip.get("Missions"), 192, 512, 192, 192));
		textureRegion.put("BaseSupport", new TextureRegion(texturesSpaceShip.get("Missions"), 0, 704, 128, 128));
		textureRegion.put("BaseGoal", new TextureRegion(texturesSpaceShip.get("Missions"), 384, 640, 64, 64)); //76x54
		textureRegion.put("EnergyIcon", new TextureRegion(texturesSpaceShip.get("Missions"), 448, 640, 64, 64)); //76x54
		textureRegion.put("X2", new TextureRegion(texturesSpaceShip.get("Missions"), 512, 640, 64, 64));
		textureRegion.put("X1", new TextureRegion(texturesSpaceShip.get("Missions"), 576, 640, 64, 64));

		textureRegion.put("FastOff", new TextureRegion(texturesSpaceShip.get("Missions"), 576, 896, 64, 64));
		textureRegion.put("FastOk", new TextureRegion(texturesSpaceShip.get("Missions"), 576, 960, 64, 64));

		textureRegion.put("Aim", new TextureRegion(texturesSpaceShip.get("Missions"), 640, 640, 64, 64));
        textureRegion.put("RadarActive", new TextureRegion(texturesSpaceShip.get("Missions"), 0, 832, 64, 64));
        textureRegion.put("RadarNoActive", new TextureRegion(texturesSpaceShip.get("Missions"), 64, 832, 64, 64));
        textureRegion.put("DamageActive", new TextureRegion(texturesSpaceShip.get("Missions"), 128, 832, 64, 64));
        textureRegion.put("DamageNoActive", new TextureRegion(texturesSpaceShip.get("Missions"), 192, 832, 64, 64));
        textureRegion.put("CriticalActive", new TextureRegion(texturesSpaceShip.get("Missions"), 256, 832, 64, 64));
        textureRegion.put("CriticalNoActive", new TextureRegion(texturesSpaceShip.get("Missions"), 320, 832, 64, 64));
        textureRegion.put("LifeActive", new TextureRegion(texturesSpaceShip.get("Missions"), 384, 832, 64, 64));
        textureRegion.put("LifeNoActive", new TextureRegion(texturesSpaceShip.get("Missions"), 448, 832, 64, 64));
        textureRegion.put("ShieldActive", new TextureRegion(texturesSpaceShip.get("Missions"), 512, 832, 64, 64));
        textureRegion.put("ShieldNoActive", new TextureRegion(texturesSpaceShip.get("Missions"), 576, 832, 64, 64));
        textureRegion.put("Radar", new TextureRegion(texturesSpaceShip.get("Missions"), 640, 832, 192, 192));
        textureRegion.put("NextWave", new TextureRegion(texturesSpaceShip.get("Missions"), 832, 832, 128, 128));

        textureRegion.put("ProgressBarHP", new TextureRegion(texturesSpaceShip.get("Missions"), 832, 960, 64, 64));
        textureRegion.put("ProgressBarHPCenter", new TextureRegion(texturesSpaceShip.get("Missions"), 896, 960, 64, 64));

        textureRegion.put("BuyTower", new TextureRegion(texturesSpaceShip.get("Missions"), 128, 704, 128, 128));
        textureRegion.put("BuyTowerMachineGun", new TextureRegion(texturesSpaceShip.get("Missions"), 256, 704, 128, 128));
        textureRegion.put("BuyTowerLauncherGun", new TextureRegion(texturesSpaceShip.get("Missions"), 384, 704, 128, 128));
        textureRegion.put("BuyTowerFlareGun", new TextureRegion(texturesSpaceShip.get("Missions"), 512, 704, 128, 128));
        textureRegion.put("BuyTowerLaserGun", new TextureRegion(texturesSpaceShip.get("Missions"), 640, 704, 128, 128));
        textureRegion.put("BuyTowerNone", new TextureRegion(texturesSpaceShip.get("Missions"), 768, 704, 128, 128));
        textureRegion.put("BuyTowerClose", new TextureRegion(texturesSpaceShip.get("Missions"), 896, 704, 128, 128));

		textureRegion.put("Crystals_1", new TextureRegion(texturesSpaceShip.get("Missions"), 704, 640, 64, 64));
		textureRegion.put("Crystals_2", new TextureRegion(texturesSpaceShip.get("Missions"), 768, 640, 64, 64));
		textureRegion.put("Crystals_3", new TextureRegion(texturesSpaceShip.get("Missions"), 832, 640, 64, 64));
		textureRegion.put("Crystals_4", new TextureRegion(texturesSpaceShip.get("Missions"), 896, 640, 64, 64));
		textureRegion.put("Crystals_5", new TextureRegion(texturesSpaceShip.get("Missions"), 960, 640, 64, 64));

        textureRegion.put("Rank_1", new TextureRegion(texturesSpaceShip.get("Missions"), 0, 896, 128, 128));
        textureRegion.put("Rank_2", new TextureRegion(texturesSpaceShip.get("Missions"), 128, 896, 128, 128));
        textureRegion.put("Rank_3", new TextureRegion(texturesSpaceShip.get("Missions"), 256, 896, 128, 128));
        textureRegion.put("Rank_4", new TextureRegion(texturesSpaceShip.get("Missions"), 384, 896, 128, 128));

        textureRegion.put("MoneyMission", new TextureRegion(texturesSpaceShip.get("Missions"), 512, 896, 64, 64));
        textureRegion.put("MineralMission", new TextureRegion(texturesSpaceShip.get("Missions"), 512, 960, 64, 64));

        texturesSpaceShip.put("MonstersDie", spaceShip.get("SpaceShip").get("monsters/monsterDie.png", Texture.class));
        textureRegion.put("WormCaveDie", new TextureRegion(texturesSpaceShip.get("MonstersDie"), 0, 64, 128, 128));
        textureRegion.put("Monsters_1Die", new TextureRegion(texturesSpaceShip.get("MonstersDie"), 0, 0, 64, 64));
        textureRegion.put("Monsters_2Die", new TextureRegion(texturesSpaceShip.get("MonstersDie"), 64, 0, 64, 64));
        textureRegion.put("Monsters_3Die", new TextureRegion(texturesSpaceShip.get("MonstersDie"), 128, 0, 64, 64));
        textureRegion.put("Monsters_4Die", new TextureRegion(texturesSpaceShip.get("MonstersDie"), 192, 0, 64, 64));
        textureRegion.put("Monsters_5Die", new TextureRegion(texturesSpaceShip.get("MonstersDie"), 256, 0, 64, 64));
    }

    public void spaceship() {
        texturesSpaceShip.put("SpaceshipFon", spaceShip.get("SpaceShip").get("spaceship/spaceshipFonTexture.png", Texture.class));
        textureRegion.put("FonSpaceshipDeck", new TextureRegion(texturesSpaceShip.get("SpaceshipFon"), 0, 0, 1920, 1024));
        textureRegion.put("FonReactor", new TextureRegion(texturesSpaceShip.get("SpaceshipFon"), 0, 1024, 1920, 1024));
        textureRegion.put("FonReactorUP", new TextureRegion(texturesSpaceShip.get("SpaceshipFon"), 0, 1024, 1920, 192));

        texturesSpaceShip.put("Spaceship", spaceShip.get("SpaceShip").get("spaceship/spaceshipTexture.png", Texture.class));
        textureRegion.put("FrameBottom", new TextureRegion(texturesSpaceShip.get("Spaceship"), 0, 0, 1920, 64));
        textureRegion.put("FrameTop", new TextureRegion(texturesSpaceShip.get("Spaceship"), 0, 64, 1920, 256));
        textureRegion.put("FrameTopBG", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1856, 1472, 192, 448));
        textureRegion.put("Fon", new TextureRegion(texturesSpaceShip.get("Spaceship"), 0, 320, 1920, 1152));
        textureRegion.put("FonBG", new TextureRegion(texturesSpaceShip.get("Spaceship"), 840, 448, 64, 64));
        textureRegion.put("Terminal", new TextureRegion(texturesSpaceShip.get("Spaceship"), 0, 1472, 576, 384));
        textureRegion.put("TerminalScreen", new TextureRegion(texturesSpaceShip.get("Spaceship"), 32, 1504, 512, 192));
        textureRegion.put("Goal_l", new TextureRegion(texturesSpaceShip.get("Spaceship"), 576, 1472, 448, 482));
        textureRegion.put("Goal_r", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1024, 1472, 448, 482));
        textureRegion.put("Home", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1920, 0, 128, 320));
        textureRegion.put("HandOFF", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1920, 320, 128, 320));
        textureRegion.put("HandON", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1920, 640, 128, 320));
        textureRegion.put("Money", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1920, 960, 128, 128));
        textureRegion.put("Mineral", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1920, 1088, 128, 128));
        textureRegion.put("ColorWhite", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1920, 1216, 64, 64));
        textureRegion.put("ColorBlack", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1984, 1216, 64, 64));
        textureRegion.put("ColorOrange", new TextureRegion(texturesSpaceShip.get("Spaceship"), 256, 1856, 64, 64));
        textureRegion.put("ColorRed", new TextureRegion(texturesSpaceShip.get("Spaceship"), 320, 1856, 32, 64));
        textureRegion.put("ColorGreen", new TextureRegion(texturesSpaceShip.get("Spaceship"), 352, 1856, 32, 64));
        textureRegion.put("Mars", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1472, 1472, 384, 384));
        textureRegion.put("PlayVideo", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1920, 1344, 128, 128));
        textureRegion.put("TV", new TextureRegion(texturesSpaceShip.get("Spaceship"), 0, 928, 256, 64));
        textureRegion.put("Territory", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1472, 1856, 384, 192));
        textureRegion.put("SizeTerritory", new TextureRegion(texturesSpaceShip.get("Spaceship"), 0, 1920, 128, 128));
        textureRegion.put("MonsterTerritory", new TextureRegion(texturesSpaceShip.get("Spaceship"), 128, 1920, 128, 128));
        textureRegion.put("NLO", new TextureRegion(texturesSpaceShip.get("Spaceship"), 256, 1920, 128, 64));
        textureRegion.put("Ru", new TextureRegion(texturesSpaceShip.get("Spaceship"), 256, 1984, 64, 64));
        textureRegion.put("En", new TextureRegion(texturesSpaceShip.get("Spaceship"), 320, 1984, 64, 64));
        textureRegion.put("Pandora", new TextureRegion(texturesSpaceShip.get("Spaceship"), 384, 1856, 128, 128));

        texturesSpaceShip.put("Spaceship2", spaceShip.get("SpaceShip").get("spaceship/spaceshipTexture2.png", Texture.class));
        textureRegion.put("Monitor", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 0, 0, 704, 692)); //1984
        textureRegion.put("VKpage", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 704, 0, 96, 96));
        textureRegion.put("Site", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 800, 0, 96, 96));
        textureRegion.put("Google", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 896, 0, 96, 96));
        textureRegion.put("UpRight", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 704, 128, 64, 64));
        textureRegion.put("UpLeft", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 768, 128, 64, 64));
        textureRegion.put("DownRight", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 704, 192, 64, 64));
        textureRegion.put("DownLeft", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 768, 192, 64, 64));
        textureRegion.put("Down", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 832, 128, 64, 64));
        textureRegion.put("Fixing", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 832, 192, 64, 64));
        textureRegion.put("MenuButtonL", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1088, 0, 101, 128));
        textureRegion.put("MenuButtonR", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1190, 0, 102, 128));
        textureRegion.put("MenuButtonFon", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1024, 0, 64, 64));
        textureRegion.put("MenuHere", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1024, 64, 64, 64));
        textureRegion.put("Exit", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 0, 704, 192, 192));
        textureRegion.put("Start", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 192, 704, 192, 192));
        textureRegion.put("MusicOn", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 0, 896, 192, 192));
        textureRegion.put("MusicOff", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 192, 896, 192, 192));
        textureRegion.put("SoundOn", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 384, 704, 192, 192));
        textureRegion.put("SoundOff", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 576, 704, 192, 192));
        textureRegion.put("VibroOn", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 384, 896, 192, 192));
        textureRegion.put("VibroOff", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 576, 896, 192, 192));
        textureRegion.put("AboutUs", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 768, 704, 192, 192));
        textureRegion.put("Help", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 768, 896, 192, 192));
        textureRegion.put("Facebook", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 704, 256, 128, 128));
        textureRegion.put("VK", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 704, 384, 128, 128));
        textureRegion.put("Twitter", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 704, 512, 128, 128));
        textureRegion.put("GooglePlus", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 832, 256, 128, 128));
        textureRegion.put("StartToMars", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1344, 0, 192, 128));
        textureRegion.put("TurnOff", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1536, 0, 128, 128));
        textureRegion.put("TerminalUpdateTower", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 960, 384, 128, 320));
        textureRegion.put("TerminalBack", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1088, 384, 128, 320));
        textureRegion.put("InfoStartGame", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1664, 0, 128, 128));
        textureRegion.put("OrbitalStation", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 960, 128, 448, 256));

        textureRegion.put("HelpMission", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1792, 0, 128, 128));
        textureRegion.put("HelpWeapon", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1920, 0, 128, 128));
        textureRegion.put("HelpMonster", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1408, 128, 128, 128));
        textureRegion.put("IconWeapon", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 704, 640, 256, 64));
        textureRegion.put("PrivacyPolicy", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1536, 128, 128, 128));

        textureRegion.put("LightbulbRed", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1920, 1280 / 2, 64, 32));
        textureRegion.put("LightbulbYellow", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1920, 1312 / 2, 64, 32));
        textureRegion.put("LightbulbGreen", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1984, 1280 / 2, 64, 32));
        textureRegion.put("LightbulbBlack", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1984, 1312 / 2, 64, 32));

        textureRegion.put("LightbulbYellowMini", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1920, 1312, 64, 32));
        textureRegion.put("LightbulbRedMini", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1920, 1280, 64, 32));
        textureRegion.put("LightbulbGreenMini", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1984, 1280, 32, 32));
        textureRegion.put("LightbulbBlueMini", new TextureRegion(texturesSpaceShip.get("Spaceship"), 1952, 1120, 32, 32));

        textureRegion.put("PromoKod", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 896, 128, 64, 64));

        textureRegion.put("GPGS_IN", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 960, 704, 128, 192));
        textureRegion.put("GPGS_Achievements", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 1088, 704, 128, 192));
        textureRegion.put("GPGS_Leaderboards", new TextureRegion(texturesSpaceShip.get("Spaceship2"), 960, 896, 128, 192));
    }

    private void hangar() {
        texturesScreen.put("Hangar", spaceShip.get("SpaceShip").get("hangar/hangarPack.png", Texture.class));
        textureRegionScreen.put("ButtonsMission", new TextureRegion(texturesScreen.get("Hangar"), 0, 0, 192, 192));
		textureRegionScreen.put("ButtonMissionNONE", new TextureRegion(texturesScreen.get("Hangar"), 368, 64, 80, 80));		
        textureRegionScreen.put("ButtonMissionRed", new TextureRegion(texturesScreen.get("Hangar"), 192, 0, 80, 80));
        textureRegionScreen.put("ButtonMissionBlue", new TextureRegion(texturesScreen.get("Hangar"), 272, 0, 80, 80));
        textureRegionScreen.put("ButtonMissionGreen", new TextureRegion(texturesScreen.get("Hangar"), 192, 80, 80, 80));
        textureRegionScreen.put("ButtonMissionTurquoise", new TextureRegion(texturesScreen.get("Hangar"), 272, 80, 80, 80));
        textureRegionScreen.put("ButtonMissionNumber", new TextureRegion(texturesScreen.get("Hangar"), 384, 0, 64, 64));
        textureRegionScreen.put("Lock", new TextureRegion(texturesScreen.get("Hangar"), 448, 0, 64, 64));
        textureRegionScreen.put("ButtonNext", new TextureRegion(texturesScreen.get("Hangar"), 448, 64, 64, 64));
    }

    private void bridge() {
        texturesScreen.put("Bridge", spaceShip.get("SpaceShip").get("bridge/bridgePack.png", Texture.class));
        textureRegionScreen.put("TerminalCenter", new TextureRegion(texturesScreen.get("Bridge"), 0, 0, 512, 256));
        textureRegionScreen.put("Pedestal", new TextureRegion(texturesScreen.get("Bridge"), 512, 0, 384, 256));
        textureRegionScreen.put("MonitorVideo", new TextureRegion(texturesScreen.get("Bridge"), 0, 256, 192, 256));
        textureRegionScreen.put("PirateShip", new TextureRegion(texturesScreen.get("Bridge"), 192, 256, 448, 192));
        textureRegionScreen.put("BuyMoney", new TextureRegion(texturesScreen.get("Bridge"), 896, 0, 128, 128));
        textureRegionScreen.put("BuyMineral", new TextureRegion(texturesScreen.get("Bridge"), 896, 128, 128, 128));
        textureRegionScreen.put("BuyShieldHPAdd", new TextureRegion(texturesScreen.get("Bridge"), 640, 256, 128, 128));
        textureRegionScreen.put("BuyEnergyAdd", new TextureRegion(texturesScreen.get("Bridge"), 768, 256, 128, 128));
        textureRegionScreen.put("BuyMicrowave", new TextureRegion(texturesScreen.get("Bridge"), 896, 256, 128, 128));
        textureRegionScreen.put("Home", new TextureRegion(texturesScreen.get("Bridge"), 640, 384, 128, 128));
        textureRegionScreen.put("UP", new TextureRegion(texturesScreen.get("Bridge"), 768, 384, 128, 128));
        textureRegionScreen.put("Cash", new TextureRegion(texturesScreen.get("Bridge"), 192, 448, 64, 64));
    }

    private void arsenal() {
        texturesScreen.put("Arsenal", spaceShip.get("SpaceShip").get("arsenal/arsenalPack.png", Texture.class));
        textureRegionScreen.put("MachineGun", new TextureRegion(texturesScreen.get("Arsenal"), 0, 0, 128, 128));
        textureRegionScreen.put("LauncherGun", new TextureRegion(texturesScreen.get("Arsenal"), 128, 0, 128, 128));
        textureRegionScreen.put("FlareGun", new TextureRegion(texturesScreen.get("Arsenal"), 256, 0, 128, 128));
        textureRegionScreen.put("LaserGun", new TextureRegion(texturesScreen.get("Arsenal"), 384, 0, 128, 128));
        textureRegionScreen.put("CloseGun", new TextureRegion(texturesScreen.get("Arsenal"), 512, 0, 128, 128));
        textureRegionScreen.put("Rack", new TextureRegion(texturesScreen.get("Arsenal"), 0, 128, 128, 192));
        textureRegionScreen.put("Monitor", new TextureRegion(texturesScreen.get("Arsenal"), 128, 128, 320, 192));
        textureRegionScreen.put("MonitorBig", new TextureRegion(texturesScreen.get("Arsenal"), 0, 320, 384, 192)); //512 x 256
        textureRegionScreen.put("ShotPower", new TextureRegion(texturesScreen.get("Arsenal"), 640, 0, 64, 64));
        textureRegionScreen.put("ShotSpeed", new TextureRegion(texturesScreen.get("Arsenal"), 704, 0, 64, 64));
        textureRegionScreen.put("ShotRange", new TextureRegion(texturesScreen.get("Arsenal"), 640, 64, 64, 64));
        textureRegionScreen.put("ShotDistance", new TextureRegion(texturesScreen.get("Arsenal"), 704, 64, 64, 64));
        textureRegionScreen.put("EnergyWeapon", new TextureRegion(texturesScreen.get("Arsenal"), 576, 128, 64, 64));
        textureRegionScreen.put("ProjectionMonitor", new TextureRegion(texturesScreen.get("Arsenal"), 384, 320, 64, 192));
        textureRegionScreen.put("Attack", new TextureRegion(texturesScreen.get("Arsenal"), 768, 0, 128, 128));
        textureRegionScreen.put("Defense", new TextureRegion(texturesScreen.get("Arsenal"), 896, 0, 128, 128));
        textureRegionScreen.put("Technologies", new TextureRegion(texturesScreen.get("Arsenal"), 448, 128, 128, 128));
        textureRegionScreen.put("TacticsClose", new TextureRegion(texturesScreen.get("Arsenal"), 960, 256, 64, 64));
        textureRegionScreen.put("UpTower", new TextureRegion(texturesScreen.get("Arsenal"), 960, 320, 64, 128));

        textureRegionScreen.put("Generator", new TextureRegion(texturesScreen.get("Arsenal"), 640, 128, 128, 128));
        textureRegionScreen.put("DamageX2", new TextureRegion(texturesScreen.get("Arsenal"), 768, 128, 128, 128));
        textureRegionScreen.put("EnergyDown", new TextureRegion(texturesScreen.get("Arsenal"), 896, 128, 128, 128));
        textureRegionScreen.put("Percent", new TextureRegion(texturesScreen.get("Arsenal"), 448, 256, 128, 128));
        textureRegionScreen.put("LauncherGunDTAttack", new TextureRegion(texturesScreen.get("Arsenal"), 576, 256, 128, 128));
        textureRegionScreen.put("FlareGunDTAttack", new TextureRegion(texturesScreen.get("Arsenal"), 704, 256, 128, 128));
        textureRegionScreen.put("LaserGunDTAttack", new TextureRegion(texturesScreen.get("Arsenal"), 832, 256, 128, 128));
        textureRegionScreen.put("Heart", new TextureRegion(texturesScreen.get("Arsenal"), 448, 384, 128, 128));
        textureRegionScreen.put("DefenseShieldHP", new TextureRegion(texturesScreen.get("Arsenal"), 576, 384, 128, 128));
        textureRegionScreen.put("DefenseEnergy", new TextureRegion(texturesScreen.get("Arsenal"), 704, 384, 128, 128));
        textureRegionScreen.put("DefenseMicrowave", new TextureRegion(texturesScreen.get("Arsenal"), 832, 384, 128, 128));
        textureRegionScreen.put("TechnologiesRadar", new TextureRegion(texturesScreen.get("Arsenal"), 0, 1024, 128, 128));
        textureRegionScreen.put("TechnologiesShowLife", new TextureRegion(texturesScreen.get("Arsenal"), 128, 1024, 128, 128));
        textureRegionScreen.put("TechnologiesRobotWorking", new TextureRegion(texturesScreen.get("Arsenal"), 256, 1024, 128, 128));
        textureRegionScreen.put("TechnologiesEnergyAdd", new TextureRegion(texturesScreen.get("Arsenal"), 384, 1024, 128, 128));
        textureRegionScreen.put("TechnologiesEnergyToLife", new TextureRegion(texturesScreen.get("Arsenal"), 512, 1024, 128, 128));
        textureRegionScreen.put("TechnologiesRobotWorkingPower", new TextureRegion(texturesScreen.get("Arsenal"), 640, 1024, 128, 128));
        textureRegionScreen.put("TechnologiesRobotWorkingSpeed", new TextureRegion(texturesScreen.get("Arsenal"), 768, 1024, 128, 128));

        textureRegionScreen.put("Reset", new TextureRegion(texturesScreen.get("Arsenal"), 896, 1024, 128, 128));

        textureRegionScreen.put("MachineGunButton_1", new TextureRegion(texturesScreen.get("Arsenal"), 0, 512, 128, 128));
        textureRegionScreen.put("MachineGunButton_2", new TextureRegion(texturesScreen.get("Arsenal"), 128, 512, 128, 128));
        textureRegionScreen.put("MachineGunButton_3", new TextureRegion(texturesScreen.get("Arsenal"), 256, 512, 128, 128));
        textureRegionScreen.put("MachineGunButton_4", new TextureRegion(texturesScreen.get("Arsenal"), 384, 512, 128, 128));
        textureRegionScreen.put("MachineGunButton_5", new TextureRegion(texturesScreen.get("Arsenal"), 512, 512, 128, 128));
        textureRegionScreen.put("MachineGunButton_6", new TextureRegion(texturesScreen.get("Arsenal"), 640, 512, 128, 128));
        textureRegionScreen.put("MachineGunButton_7", new TextureRegion(texturesScreen.get("Arsenal"), 768, 512, 128, 128));
        textureRegionScreen.put("MachineGunButton_8", new TextureRegion(texturesScreen.get("Arsenal"), 896, 512, 128, 128));

        textureRegionScreen.put("LauncherGunButton_1", new TextureRegion(texturesScreen.get("Arsenal"), 0, 640, 128, 128));
        textureRegionScreen.put("LauncherGunButton_2", new TextureRegion(texturesScreen.get("Arsenal"), 128, 640, 128, 128));
        textureRegionScreen.put("LauncherGunButton_3", new TextureRegion(texturesScreen.get("Arsenal"), 256, 640, 128, 128));
        textureRegionScreen.put("LauncherGunButton_4", new TextureRegion(texturesScreen.get("Arsenal"), 384, 640, 128, 128));
        textureRegionScreen.put("LauncherGunButton_5", new TextureRegion(texturesScreen.get("Arsenal"), 512, 640, 128, 128));
        textureRegionScreen.put("LauncherGunButton_6", new TextureRegion(texturesScreen.get("Arsenal"), 640, 640, 128, 128));
        textureRegionScreen.put("LauncherGunButton_7", new TextureRegion(texturesScreen.get("Arsenal"), 768, 640, 128, 128));
        textureRegionScreen.put("LauncherGunButton_8", new TextureRegion(texturesScreen.get("Arsenal"), 896, 640, 128, 128));

        textureRegionScreen.put("FlareGunButton_1", new TextureRegion(texturesScreen.get("Arsenal"), 0, 768, 128, 128));
        textureRegionScreen.put("FlareGunButton_2", new TextureRegion(texturesScreen.get("Arsenal"), 128, 768, 128, 128));
        textureRegionScreen.put("FlareGunButton_3", new TextureRegion(texturesScreen.get("Arsenal"), 256, 768, 128, 128));
        textureRegionScreen.put("FlareGunButton_4", new TextureRegion(texturesScreen.get("Arsenal"), 384, 768, 128, 128));
        textureRegionScreen.put("FlareGunButton_5", new TextureRegion(texturesScreen.get("Arsenal"), 512, 768, 128, 128));
        textureRegionScreen.put("FlareGunButton_6", new TextureRegion(texturesScreen.get("Arsenal"), 640, 768, 128, 128));
        textureRegionScreen.put("FlareGunButton_7", new TextureRegion(texturesScreen.get("Arsenal"), 768, 768, 128, 128));
        textureRegionScreen.put("FlareGunButton_8", new TextureRegion(texturesScreen.get("Arsenal"), 896, 768, 128, 128));

        textureRegionScreen.put("LaserGunButton_1", new TextureRegion(texturesScreen.get("Arsenal"), 0, 896, 128, 128));
        textureRegionScreen.put("LaserGunButton_2", new TextureRegion(texturesScreen.get("Arsenal"), 128, 896, 128, 128));
        textureRegionScreen.put("LaserGunButton_3", new TextureRegion(texturesScreen.get("Arsenal"), 256, 896, 128, 128));
        textureRegionScreen.put("LaserGunButton_4", new TextureRegion(texturesScreen.get("Arsenal"), 384, 896, 128, 128));
        textureRegionScreen.put("LaserGunButton_5", new TextureRegion(texturesScreen.get("Arsenal"), 512, 896, 128, 128));
        textureRegionScreen.put("LaserGunButton_6", new TextureRegion(texturesScreen.get("Arsenal"), 640, 896, 128, 128));
        textureRegionScreen.put("LaserGunButton_7", new TextureRegion(texturesScreen.get("Arsenal"), 768, 896, 128, 128));
        textureRegionScreen.put("LaserGunButton_8", new TextureRegion(texturesScreen.get("Arsenal"), 896, 896, 128, 128));
    }

    private void weapons() {
        texturesScreen.put("Weapons", spaceShip.get("SpaceShip").get("arsenal/weaponsPack.png", Texture.class));
        textureRegionScreen.put("MachineGun_1", new TextureRegion(texturesScreen.get("Weapons"), 0, 0, 128, 320));
        textureRegionScreen.put("MachineGun_2", new TextureRegion(texturesScreen.get("Weapons"), 128, 0, 128, 320));
        textureRegionScreen.put("MachineGun_3", new TextureRegion(texturesScreen.get("Weapons"), 256, 0, 128, 320));
        textureRegionScreen.put("MachineGun_4", new TextureRegion(texturesScreen.get("Weapons"), 384, 0, 128, 320));
        textureRegionScreen.put("MachineGun_5", new TextureRegion(texturesScreen.get("Weapons"), 512, 0, 128, 320));
        textureRegionScreen.put("MachineGun_6", new TextureRegion(texturesScreen.get("Weapons"), 640, 0, 128, 320));
        textureRegionScreen.put("MachineGun_7", new TextureRegion(texturesScreen.get("Weapons"), 768, 0, 128, 320));
        textureRegionScreen.put("MachineGun_8", new TextureRegion(texturesScreen.get("Weapons"), 896, 0, 128, 256));

        textureRegionScreen.put("LauncherGun_1", new TextureRegion(texturesScreen.get("Weapons"), 0, 320, 128, 320));
        textureRegionScreen.put("LauncherGun_2", new TextureRegion(texturesScreen.get("Weapons"), 128, 320, 128, 320));
        textureRegionScreen.put("LauncherGun_3", new TextureRegion(texturesScreen.get("Weapons"), 256, 320, 128, 320));
        textureRegionScreen.put("LauncherGun_4", new TextureRegion(texturesScreen.get("Weapons"), 384, 320, 128, 320));
        textureRegionScreen.put("LauncherGun_5", new TextureRegion(texturesScreen.get("Weapons"), 512, 320, 128, 320));
        textureRegionScreen.put("LauncherGun_6", new TextureRegion(texturesScreen.get("Weapons"), 640, 320, 128, 320));
        textureRegionScreen.put("LauncherGun_7", new TextureRegion(texturesScreen.get("Weapons"), 768, 320, 128, 320));
        textureRegionScreen.put("LauncherGun_8", new TextureRegion(texturesScreen.get("Weapons"), 896, 320, 128, 320));

        textureRegionScreen.put("FlareGun_1", new TextureRegion(texturesScreen.get("Weapons"), 0, 640, 128, 160));
        textureRegionScreen.put("FlareGun_2", new TextureRegion(texturesScreen.get("Weapons"), 128, 640, 128, 160));
        textureRegionScreen.put("FlareGun_3", new TextureRegion(texturesScreen.get("Weapons"), 256, 640, 128, 256));
        textureRegionScreen.put("FlareGun_4", new TextureRegion(texturesScreen.get("Weapons"), 384, 640, 128, 128));
        textureRegionScreen.put("FlareGun_5", new TextureRegion(texturesScreen.get("Weapons"), 512, 640, 128, 256));
        textureRegionScreen.put("FlareGun_6", new TextureRegion(texturesScreen.get("Weapons"), 384, 768, 128, 128));
        textureRegionScreen.put("FlareGun_7", new TextureRegion(texturesScreen.get("Weapons"), 640, 640, 128, 256));
        textureRegionScreen.put("FlareGun_8", new TextureRegion(texturesScreen.get("Weapons"), 768, 640, 128, 128));

        textureRegionScreen.put("LaserGun_1", new TextureRegion(texturesScreen.get("Weapons"), 0, 896, 128, 256));
        textureRegionScreen.put("LaserGun_2", new TextureRegion(texturesScreen.get("Weapons"), 128, 896, 128, 256));
        textureRegionScreen.put("LaserGun_3", new TextureRegion(texturesScreen.get("Weapons"), 256, 896, 128, 320));
        textureRegionScreen.put("LaserGun_4", new TextureRegion(texturesScreen.get("Weapons"), 384, 896, 128, 256));
        textureRegionScreen.put("LaserGun_5", new TextureRegion(texturesScreen.get("Weapons"), 512, 896, 128, 320));
        textureRegionScreen.put("LaserGun_6", new TextureRegion(texturesScreen.get("Weapons"), 640, 896, 128, 256));
        textureRegionScreen.put("LaserGun_7", new TextureRegion(texturesScreen.get("Weapons"), 768, 896, 128, 320));
        textureRegionScreen.put("LaserGun_8", new TextureRegion(texturesScreen.get("Weapons"), 896, 896, 128, 320));
    }

    private void laboratory() {
        texturesScreen.put("Lab", spaceShip.get("SpaceShip").get("laboratory/laboratoryPack.png", Texture.class));
        textureRegionScreen.put("LabBuyFon", new TextureRegion(texturesScreen.get("Lab"), 0, 0, 256, 320));
        textureRegionScreen.put("LabFirePower", new TextureRegion(texturesScreen.get("Lab"), 256, 0, 128, 128));
        textureRegionScreen.put("LabFireTime", new TextureRegion(texturesScreen.get("Lab"), 384, 0, 128, 128));
        textureRegionScreen.put("LabIcePower", new TextureRegion(texturesScreen.get("Lab"), 256, 128, 128, 128));
        textureRegionScreen.put("LabIceTime", new TextureRegion(texturesScreen.get("Lab"), 384, 128, 128, 128));
        textureRegionScreen.put("LabPoisonPower", new TextureRegion(texturesScreen.get("Lab"), 256, 256, 128, 128));
        textureRegionScreen.put("LabPoisonTime", new TextureRegion(texturesScreen.get("Lab"), 384, 256, 128, 128));
        textureRegionScreen.put("LabCapsule", new TextureRegion(texturesScreen.get("Lab"), 512, 0, 251, 704));
    }

    private void reactor() {
        texturesScreen.put("Reactor", spaceShip.get("SpaceShip").get("reactor/reactorPack.png", Texture.class));
        textureRegionScreen.put("PipesL", new TextureRegion(texturesScreen.get("Reactor"), 0, 0, 832, 512));
        textureRegionScreen.put("PipesR", new TextureRegion(texturesScreen.get("Reactor"), 0, 512, 832, 256));
        textureRegionScreen.put("CapsuleMini", new TextureRegion(texturesScreen.get("Reactor"), 832, 0, 320, 448));
        textureRegionScreen.put("Reactor", new TextureRegion(texturesScreen.get("Reactor"), 1152, 0, 576, 704));
        textureRegionScreen.put("ReactorCase", new TextureRegion(texturesScreen.get("Reactor"), 0, 384, 968, 484));
        textureRegionScreen.put("BuyFon", new TextureRegion(texturesScreen.get("Reactor"), 832, 448, 320, 256));
        textureRegionScreen.put("HP", new TextureRegion(texturesScreen.get("Reactor"), 1024, 704, 128, 128));
        textureRegionScreen.put("HPup", new TextureRegion(texturesScreen.get("Reactor"), 1152, 704, 128, 128));
        textureRegionScreen.put("MP", new TextureRegion(texturesScreen.get("Reactor"), 1280, 704, 128, 128));
        textureRegionScreen.put("MPup", new TextureRegion(texturesScreen.get("Reactor"), 1408, 704, 128, 128));
        textureRegionScreen.put("Close", new TextureRegion(texturesScreen.get("Reactor"), 832, 704, 64, 64));
    }

    private void r_7() {
        texturesScreen.put("R-7", spaceShip.get("SpaceShip").get("robots/r-7.png", Texture.class));
        textureRegionScreen.put("R-7_norm", new TextureRegion(texturesScreen.get("R-7"), 0, 0, 128, 192));
        textureRegionScreen.put("R-7_mimi", new TextureRegion(texturesScreen.get("R-7"), 128, 0, 128, 192));
        textureRegionScreen.put("R-7_anger", new TextureRegion(texturesScreen.get("R-7"), 256, 0, 128, 192));
        textureRegionScreen.put("R-7_surprise", new TextureRegion(texturesScreen.get("R-7"), 384, 0, 128, 192));
        textureRegionScreen.put("R-7_RUN", new TextureRegion(texturesScreen.get("R-7"), 0, 192 / 2, 512, 192));
    }

    private void r_7Speak() {
        texturesScreen.put("R_7Speak", spaceShip.get("SpaceShip").get("robots/r-7Speak.png", Texture.class));
        textureRegionScreen.put("R_7Speak_norm", new TextureRegion(texturesScreen.get("R_7Speak"), 0, 0, 512, 512));
        textureRegionScreen.put("R_7Speak_mimi", new TextureRegion(texturesScreen.get("R_7Speak"), 512, 0, 512, 512));
        textureRegionScreen.put("R_7Speak_surprise", new TextureRegion(texturesScreen.get("R_7Speak"), 0, 512, 512, 512));
        textureRegionScreen.put("R_7Speak_anger", new TextureRegion(texturesScreen.get("R_7Speak"), 512, 512, 512, 512));
        textureRegionScreen.put("Marsian", new TextureRegion(texturesScreen.get("R_7Speak"), 1024, 0, 512, 512));
    }

    public Skin getTextureButtonSkin() {
        return textureButtonSkin;
    }

    public Map<String, AssetManager> getSpaceShip() {
        return spaceShip;
    }

    public void dispose() {
        try {
            load.dispose();
            textureButton.dispose();
            textureButtonSkin.dispose();
            spaceShip.clear();
            data.clear();
            loader.clear();
            dataBoss.clear();
            loaderBoss.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}