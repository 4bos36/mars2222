package studio.rashka.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import studio.rashka.MarsGame;
import studio.rashka.PlayServices;

public class DesktopLauncher implements PlayServices {

	private static DesktopLauncher application;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		if (application == null) {
			application = new DesktopLauncher();
		}

		config.forceExit = false;
		config.title = MarsGame.TITLE;
		config.width = MarsGame.WIDTH / 2;
		config.height = MarsGame.HEIGHT / 2;
		new LwjglApplication(new MarsGame(application), config);
	}

	@Override
	public void showAds(int show) {

	}

	@Override
	public boolean getSignedInGPGS() {
		return false;
	}

	@Override
	public void loginGPGS() {

	}

	@Override
	public void logoutGPGS() {

	}

	@Override
	public void recordGPGS(String name, int score) {

	}

	@Override
	public void submitScoreGPGS(String id, int score) {

	}

	@Override
	public void unlockAchievementGPGS(String achievementId) {

	}

	@Override
	public void getLeaderboardGPGS() {

	}

	@Override
	public void getAchievementsGPGS() {

	}

	@Override
	public void loadGameState() {

	}

	@Override
	public void saveGameState() {

	}
}