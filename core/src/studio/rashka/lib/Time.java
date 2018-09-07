package studio.rashka.lib;

import com.badlogic.gdx.utils.TimeUtils;

public class Time {

    private long startTime;
    private float time = 0, timeUp;
    private String typeTime;
    private boolean isActive = false;

    public Time(float time, String typeTime) {
        this.typeTime = typeTime;
        timeUp = time;
        startTime = TimeUtils.nanoTime();
    }

    public void updateTime() {
        if (time != timeUp) {
            if (typeTime.equals("sec")) {
                if (TimeUtils.nanoTime() - startTime > 1000000000) { /* 1,000,000,000ns == one second */
                    time++;
                    startTime = TimeUtils.nanoTime();
                }
            } else {
                if (TimeUtils.nanoTime() - startTime > 500000000) {
                    time += 0.5f;
                    startTime = TimeUtils.nanoTime();
                }
            }
        } else if (time == timeUp) {
            isActive = true;
        }
    }

    public void updateTime2() {
        if (time != timeUp) {
            if (TimeUtils.nanoTime() - startTime > 250000000) {
                time += 0.5f;
                if (time > timeUp) time = timeUp;
                startTime = TimeUtils.nanoTime();
            }
        }
        else if (time == timeUp) {
            time = timeUp;
            isActive = true;
        }
    }

    public void updateTimeFinish() {
        if (time != timeUp) {
            if (TimeUtils.nanoTime() - startTime > 500000000) { /* 1,000,000,000ns == one second */
                time++;
                startTime = TimeUtils.nanoTime();
            }
        } else if (time == timeUp) {
            isActive = true;
        }
    }

    public void setTimeReset() {
        time = 0;
        isActive = false;
    }

    public float getTime() {
        return time;
    }

    public boolean isActive() {
        return isActive;
    }
}