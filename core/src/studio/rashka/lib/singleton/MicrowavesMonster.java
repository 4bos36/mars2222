package studio.rashka.lib.singleton;

public class MicrowavesMonster {

    public static final MicrowavesMonster INSTANCE = new MicrowavesMonster();

    private int runMicrowaves;

    private MicrowavesMonster() {
        runMicrowaves = 1;
    }

    public int getRunMicrowaves() {
        return runMicrowaves;
    }

    public void setRunMicrowaves(int runMicrowaves) {
        this.runMicrowaves = runMicrowaves;
    }
}