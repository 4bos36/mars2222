package studio.rashka.lib.singleton;

public class SpeedMonster {

    public static final SpeedMonster INSTANCE = new SpeedMonster();

    private int speed;

    private SpeedMonster() {
        speed = 1;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}