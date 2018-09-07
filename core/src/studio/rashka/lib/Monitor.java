package studio.rashka.lib;

import studio.rashka.MarsGame;

public class Monitor {

    private float ratioMonitorW = 0, ratioMonitorH = 0;
    private static int mWIDTH = MarsGame.WIDTH, mHEIGHT = MarsGame.HEIGHT;

    public Monitor() {
        onWidth();
        onHeight();
        if (ratioMonitorW != ratioMonitorH) {
            MarsGame.setHEIGHT(1200);
            mHEIGHT = MarsGame.HEIGHT;
            ratioMonitorW = 0;
            ratioMonitorH = 0;
            onWidth();
            onHeight();
            if (ratioMonitorW != ratioMonitorH) {
                MarsGame.setHEIGHT(1440);
                mHEIGHT = MarsGame.HEIGHT;
                ratioMonitorW = 0;
                ratioMonitorH = 0;
                onWidth();
                onHeight();
            }
        }
    }

    private void onWidth() {
        if (MarsGame.getPreference().width() == 0) ratioMonitorW = (float) (MarsGame.WIDTH / 2) / (float) mWIDTH;
        else ratioMonitorW = (float) MarsGame.getPreference().width() / (float) mWIDTH;
    }

    private void onHeight() {
        if (MarsGame.getPreference().height() == 0) ratioMonitorH = (float) (MarsGame.HEIGHT / 2) / (float) mHEIGHT;
        else ratioMonitorH = (float) MarsGame.getPreference().height() / (float) mHEIGHT;
    }

    public float getRatioMonitorW() {
        return ratioMonitorW;
    }

    public float getRatioMonitorH() {
        return ratioMonitorH;
    }
}