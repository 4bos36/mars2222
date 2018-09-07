package studio.rashka.lib;

import com.badlogic.gdx.utils.TimeUtils;

import studio.rashka.MarsGame;

public class TimeRegeneration {

    private long startTime;
    private float add = 0, hp, mp, upLife = 0;
    private float energyBonus = 0;
    private boolean isGoodLife = true;

    public TimeRegeneration(int type) {
        startTime = TimeUtils.nanoTime();
        if (type == 1) {
            hp = MarsGame.getPreference().loadHPBase();
            add = MarsGame.getPreference().loadHPSpeed();
            upLife = hp * 0.3f;
        }
        if (type == 2) {
            mp = MarsGame.getPreference().loadMPEnergy() - energyBonus;
            add = MarsGame.getPreference().loadMPSpeed();
        }
    }

    public void updateAddHP() {
        if (hp < MarsGame.getPreference().loadHPBase()) {
            if (isGoodLife) isGoodLife = false;
            if (TimeUtils.nanoTime() - startTime > 1000000000) { /* 1,000,000,000ns == one second */
                if (add < MarsGame.getPreference().loadHPBase() - hp) {
                    hp += add;
                    if (MarsGame.getPreference().getTacticsTechnologiesConverter())
                        hp += MarsGame.getPreference().getTacticsTechnologiesConverterLife();
                    startTime = TimeUtils.nanoTime();
                } else if (add >= MarsGame.getPreference().loadHPBase() - hp) {
                    hp = MarsGame.getPreference().loadHPBase();
                    startTime = TimeUtils.nanoTime();
                }
            }
        } else if (hp > MarsGame.getPreference().loadHPBase()) {
            hp = MarsGame.getPreference().loadHPBase();
        }
    }

    public void updateAddHP2() {
        if (hp < MarsGame.getPreference().loadHPBase()) {
            if (isGoodLife) isGoodLife = false;
            if (TimeUtils.nanoTime() - startTime > 500000000) { /* 1,000,000,000ns == one second */
                if (add < MarsGame.getPreference().loadHPBase() - hp) {
                    hp += add;
                    if (MarsGame.getPreference().getTacticsTechnologiesConverter())
                        hp += MarsGame.getPreference().getTacticsTechnologiesConverterLife();
                    startTime = TimeUtils.nanoTime();
                } else if (add >= MarsGame.getPreference().loadHPBase() - hp) {
                    hp = MarsGame.getPreference().loadHPBase();
                    startTime = TimeUtils.nanoTime();
                }
            }
        } else if (hp > MarsGame.getPreference().loadHPBase()) {
            hp = MarsGame.getPreference().loadHPBase();
        }
    }

    public void updateAddMP() {
        if (mp >= 0 && mp <= MarsGame.getPreference().loadMPEnergy() - energyBonus) {
            if (TimeUtils.nanoTime() - startTime > 1000000000) { /* 1,000,000,000ns == one second */
                if (add < MarsGame.getPreference().loadMPEnergy() - mp - energyBonus) {
                    mp += add;
                    if (MarsGame.getPreference().getTacticsTechnologiesConverter()) mp -= MarsGame.getPreference().getTacticsTechnologiesConverterLife();
                    if (MarsGame.getPreference().getTacticsTechnologiesPower()) mp += MarsGame.getPreference().getTacticsTechnologiesPowerEnergy();
                    startTime = TimeUtils.nanoTime();
                } else if (add >= MarsGame.getPreference().loadMPEnergy() - mp - energyBonus) {
                    mp = MarsGame.getPreference().loadMPEnergy() - energyBonus;
                    startTime = TimeUtils.nanoTime();
                }
            }
        } else if (mp < 0) {
            mp = 0;
        } else if (mp > MarsGame.getPreference().loadMPEnergy() - energyBonus) {
            mp = MarsGame.getPreference().loadMPEnergy() - energyBonus;
        }
    }

    public void updateAddMP2() {
        if (mp >= 0 && mp <= MarsGame.getPreference().loadMPEnergy() - energyBonus) {
            if (TimeUtils.nanoTime() - startTime > 500000000) { /* 1,000,000,000ns == one second */
                if (add < MarsGame.getPreference().loadMPEnergy() - mp - energyBonus) {
                    mp += add;
                    if (MarsGame.getPreference().getTacticsTechnologiesConverter()) mp -= MarsGame.getPreference().getTacticsTechnologiesConverterLife();
                    if (MarsGame.getPreference().getTacticsTechnologiesPower()) mp += MarsGame.getPreference().getTacticsTechnologiesPowerEnergy();
                    startTime = TimeUtils.nanoTime();
                } else if (add >= MarsGame.getPreference().loadMPEnergy() - mp - energyBonus) {
                    mp = MarsGame.getPreference().loadMPEnergy() - energyBonus;
                    startTime = TimeUtils.nanoTime();
                }
            }
        } else if (mp < 0) {
            mp = 0;
        } else if (mp > MarsGame.getPreference().loadMPEnergy() - energyBonus) {
            mp = MarsGame.getPreference().loadMPEnergy() - energyBonus;
        }
    }

    public int getHp() {
        return (int)hp;
    }

    public int getMp() {
        return (int)mp;
    }

    public void setHp(float hp) {
        try {
            this.hp -= hp;
        } catch (NullPointerException e) {
            this.hp = 0;
        }
    }

    public void setMp(float mp) {
        try {
            this.mp -= mp;
        } catch (NullPointerException e) {
            this.mp = 0;
        }
    }

    public float getUpLife() {
        return upLife;
    }

    public void setEnergyBonus(float energyBonus) {
        this.energyBonus = energyBonus;
    }

    public boolean isGoodLife() {
        return isGoodLife;
    }
}