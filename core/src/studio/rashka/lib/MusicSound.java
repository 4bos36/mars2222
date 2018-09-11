package studio.rashka.lib;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;
import java.util.Map;

import studio.rashka.MarsGame;

public class MusicSound {

    public Map<String, Music> musics, fon;
    public Map<String, Sound> sounds;

    private AssetManager loadSound, loadSoundWeapon;

    public MusicSound() {
        musics = new HashMap<String, Music>();
        fon = new HashMap<String, Music>();
        sounds = new HashMap<String, Sound>();

        loadSound = new AssetManager();
        loadSoundWeapon = new AssetManager();
    }

    public void loadSounds() {
        loadSound.load("sounds/win.ogg", Music.class);
        loadSound.load("sounds/gameover.ogg", Sound.class);

        loadSound.load("sounds/fon.ogg", Music.class);
        loadSound.load("sounds/click.ogg", Sound.class);
        loadSound.load("sounds/terminal.ogg", Sound.class);
        loadSound.load("sounds/access_denied.ogg", Sound.class);

        loadSound.load("sounds/door_open.ogg", Sound.class);
        loadSound.load("sounds/door_close.ogg", Sound.class);

        loadSound.load("sounds/robot_move.ogg", Sound.class);
        loadSound.load("sounds/robot_stop.ogg", Sound.class);
        loadSound.load("sounds/sendR7.ogg", Sound.class);

        loadSound.load("sounds/laboratory.ogg", Music.class);
        loadSound.load("sounds/moveterminal.ogg", Sound.class);

        loadSound.load("sounds/reactor.ogg", Music.class);
    }

    public void loadSoundWeapon() {
        if (MarsGame.getPreference().getWeaponInstalled("MachineGun_1")) loadSoundWeapon.load("sounds/weapons/MachineGun_1.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_2")) loadSoundWeapon.load("sounds/weapons/MachineGun_2.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_3")) loadSoundWeapon.load("sounds/weapons/MachineGun_3.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_4")) loadSoundWeapon.load("sounds/weapons/MachineGun_4.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_5")) loadSoundWeapon.load("sounds/weapons/MachineGun_5.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_6")) loadSoundWeapon.load("sounds/weapons/MachineGun_6.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_7")) loadSoundWeapon.load("sounds/weapons/MachineGun_7.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_8")) loadSoundWeapon.load("sounds/weapons/MachineGun_8.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_1")) loadSoundWeapon.load("sounds/weapons/LauncherGun_1.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_2")) loadSoundWeapon.load("sounds/weapons/LauncherGun_2.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_3")) loadSoundWeapon.load("sounds/weapons/LauncherGun_3.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_4")) loadSoundWeapon.load("sounds/weapons/LauncherGun_4.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_5")) loadSoundWeapon.load("sounds/weapons/LauncherGun_5.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_6")) loadSoundWeapon.load("sounds/weapons/LauncherGun_6.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_7")) loadSoundWeapon.load("sounds/weapons/LauncherGun_7.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_8")) loadSoundWeapon.load("sounds/weapons/LauncherGun_8.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_1")) loadSoundWeapon.load("sounds/weapons/FlareGun_1.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_2")) loadSoundWeapon.load("sounds/weapons/FlareGun_2.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_3")) loadSoundWeapon.load("sounds/weapons/FlareGun_3.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_4")) loadSoundWeapon.load("sounds/weapons/FlareGun_4.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_5")) loadSoundWeapon.load("sounds/weapons/FlareGun_5.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_6")) loadSoundWeapon.load("sounds/weapons/FlareGun_6.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_7")) loadSoundWeapon.load("sounds/weapons/FlareGun_7.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_8")) loadSoundWeapon.load("sounds/weapons/FlareGun_8.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_1")) loadSoundWeapon.load("sounds/weapons/LaserGun_1.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_2")) loadSoundWeapon.load("sounds/weapons/LaserGun_2.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_3")) loadSoundWeapon.load("sounds/weapons/LaserGun_3.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_4")) loadSoundWeapon.load("sounds/weapons/LaserGun_4.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_5")) loadSoundWeapon.load("sounds/weapons/LaserGun_5.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_6")) loadSoundWeapon.load("sounds/weapons/LaserGun_6.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_7")) loadSoundWeapon.load("sounds/weapons/LaserGun_7.ogg", Sound.class);
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_8")) loadSoundWeapon.load("sounds/weapons/LaserGun_8.ogg", Sound.class);
        loadSoundWeapon.load("sounds/explosion.ogg", Sound.class);
        loadSoundWeapon.load("sounds/fire.ogg", Sound.class);
        loadSoundWeapon.load("sounds/ice.ogg", Sound.class);
        loadSoundWeapon.load("sounds/poison.ogg", Sound.class);
        loadSoundWeapon.load("sounds/energy.ogg", Sound.class);
        loadSoundWeapon.load("sounds/microwave.ogg", Sound.class);
        loadSoundWeapon.load("sounds/shield.ogg", Sound.class);
        loadSoundWeapon.finishLoading();
    }

    public void soundWeapon() {
        if (MarsGame.getPreference().getWeaponInstalled("MachineGun_1")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_1.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_2")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_2.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_3")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_3.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_4")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_4.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_5")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_5.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_6")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_6.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_7")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_7.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("MachineGun_8")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/MachineGun_8.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_1")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_1.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_2")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_2.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_3")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_3.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_4")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_4.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_5")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_5.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_6")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_6.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_7")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_7.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LauncherGun_8")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LauncherGun_8.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_1")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_1.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_2")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_2.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_3")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_3.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_4")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_4.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_5")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_5.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_6")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_6.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_7")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_7.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("FlareGun_8")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/FlareGun_8.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_1")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_1.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_2")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_2.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_3")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_3.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_4")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_4.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_5")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_5.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_6")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_6.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_7")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_7.ogg", Sound.class));
        else if (MarsGame.getPreference().getWeaponInstalled("LaserGun_8")) sounds.put("SoundWeapon", loadSoundWeapon.get("sounds/weapons/LaserGun_8.ogg", Sound.class));
        sounds.put("Explosion", loadSoundWeapon.get("sounds/explosion.ogg", Sound.class));
        sounds.put("Fire", loadSoundWeapon.get("sounds/fire.ogg", Sound.class));
        sounds.put("Ice", loadSoundWeapon.get("sounds/ice.ogg", Sound.class));
        sounds.put("Poison", loadSoundWeapon.get("sounds/poison.ogg", Sound.class));
        sounds.put("Energy", loadSoundWeapon.get("sounds/energy.ogg", Sound.class));
        sounds.put("Microwave", loadSoundWeapon.get("sounds/microwave.ogg", Sound.class));
        sounds.put("Shield", loadSoundWeapon.get("sounds/shield.ogg", Sound.class));
    }

    public void mission() {
        musics.put("Victory", loadSound.get("sounds/win.ogg", Music.class));
        sounds.put("GameOver", loadSound.get("sounds/gameover.ogg", Sound.class));
    }

    public void fonSound() {
        fon.put("Fon", loadSound.get("sounds/fon.ogg", Music.class));
    }

    public void click() {
        sounds.put("Click", loadSound.get("sounds/click.ogg", Sound.class));
    }

    public void clickTerminal() {
        sounds.put("ClickTerminal", loadSound.get("sounds/terminal.ogg", Sound.class));
        sounds.put("AccessDenied", loadSound.get("sounds/access_denied.ogg", Sound.class));
    }

    public void doors() {
        sounds.put("DoorOpen", loadSound.get("sounds/door_open.ogg", Sound.class));
        sounds.put("DoorClose", loadSound.get("sounds/door_close.ogg", Sound.class));
    }

    public void robotR7() {
        sounds.put("R7_Move", loadSound.get("sounds/robot_move.ogg", Sound.class));
        sounds.put("R7_Stop", loadSound.get("sounds/robot_stop.ogg", Sound.class));
        sounds.put("R7_Send", loadSound.get("sounds/sendR7.ogg", Sound.class));
    }

    public void laboratory() {
        musics.put("Laboratory", loadSound.get("sounds/laboratory.ogg", Music.class));
        sounds.put("MoveTerminal", loadSound.get("sounds/moveterminal.ogg", Sound.class));
        if (MarsGame.getPreference().loadMusic() == 1) {
            musics.get("Laboratory").setLooping(true);
            musics.get("Laboratory").setVolume(1.0f);
            musics.get("Laboratory").play();
        }
    }

    public void reactor() {
        musics.put("Reactor", loadSound.get("sounds/reactor.ogg", Music.class));
        if (MarsGame.getPreference().loadMusic() == 1) {
            musics.get("Reactor").setLooping(true);
            musics.get("Reactor").setVolume(1.0f);
            musics.get("Reactor").play();
        }
    }

    public void disposeSounds() {
        musics.clear();
        sounds.clear();
    }

    public AssetManager getLoadSound() {
        return loadSound;
    }

    public AssetManager getLoadSoundWeapon() {
        return loadSoundWeapon;
    }

    public void dispose() {
        try {
            fon.clear();
            loadSound.dispose();
            loadSoundWeapon.dispose();
            disposeSounds();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}