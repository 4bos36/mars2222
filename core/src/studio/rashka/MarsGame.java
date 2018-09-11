package studio.rashka;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Frustum;

import studio.rashka.lib.FontTTF;
import studio.rashka.lib.Game;
import studio.rashka.lib.Language;
import studio.rashka.lib.Monitor;
import studio.rashka.lib.MusicSound;
import studio.rashka.lib.Preference;
import studio.rashka.lib.Textures;
import studio.rashka.models.load.Space;
import studio.rashka.screen.LoadScreenStart;

/**
 * Created by 4bos on 11.10.2017.
 */

public class MarsGame extends ApplicationAdapter {
	public static final int WIDTH = 1920;
	public static int HEIGHT = 1080;
	//public static int HEIGHT = 1200;
	//public static int HEIGHT = 1440;
	public static final String TITLE = "Mars 2222";

	public static PlayServices playServices;
	public MarsGame(PlayServices playServices) {
	    this.playServices = playServices;
    }

	private static SpriteBatch batch;
	private static Game game;
	private static OrthographicCamera camera;
	private static Frustum frustum;

	private static Preference preference;
	private static MusicSound musicSound;
	private static Language language;
	private static Textures textures;

	private Monitor monitor;

	private static float ratioMonitorW, ratioMonitorH, ratioAdd;
	
	@Override
	public void create () {
		preference = new Preference();
		musicSound = new MusicSound();
		textures = new Textures();
		language = new Language();
		monitor = new Monitor();

		batch = new SpriteBatch();
		game = new Game();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
		camera.update();
		frustum = camera.frustum;

		ratioMonitorW = monitor.getRatioMonitorW();
		ratioMonitorH = monitor.getRatioMonitorH();
        ratioAdd = (HEIGHT - 1080) / 2;

		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		game.push(new LoadScreenStart(game));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);

		game.update(Gdx.graphics.getDeltaTime());
		game.render(batch);
	}

	public static OrthographicCamera getCamera() {
		return camera;
	}

	public static Frustum getFrustum() {
		return frustum;
	}

	public static SpriteBatch getBatch() {
		return batch;
	}

	public static void setHEIGHT(int HEIGHT) {
		MarsGame.HEIGHT = HEIGHT;
	}

	public static float getRatioMonitorW() {
		return ratioMonitorW;
	}

	public static float getRatioMonitorH() {
		return ratioMonitorH;
	}

    public static float getRatioAdd() {
        return ratioAdd;
    }

    public static Preference getPreference() {
		return preference;
	}

	public static MusicSound getMusicSound() {
		return musicSound;
	}

	public static Language getLanguage() {
		return language;
	}

	public static Textures getTextures() {
		return textures;
	}

	@Override
	public void pause() {
		try {
			if (MarsGame.getMusicSound().fon.get("Fon").isPlaying()) MarsGame.getMusicSound().fon.get("Fon").pause();
			MarsGame.getPreference().isPlay = false;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void resume() {
		try {
			if (MarsGame.getPreference().loadMusic() == 1) MarsGame.getMusicSound().fon.get("Fon").play();
			MarsGame.getPreference().isPlay = true;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dispose() {
		try {
			MarsGame.getMusicSound().fon.get("Fon").stop();
			musicSound.dispose();
			textures.dispose();
			language.dispose();
			batch.dispose();
			Space.getInstance().dispose();
			FontTTF.getInstance().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}