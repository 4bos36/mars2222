package studio.rashka.models.arsenal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import studio.rashka.MarsGame;

public class BonusTactics {

    private String bonus = "NONE";
    private boolean isLifeActive = false, isRadarActive = false;
    private float damageBonus = 0, critBonus = 0, energyBonus = 0, shieldBonus = 0,
            upLife = 0;

    public BonusTactics() {
        if (MarsGame.getPreference().getTacticsAttackStart()) {
            bonus = "Attack";
            damageBonus = MarsGame.getPreference().getTacticsAttackGeneratorPowerShot() / 100;
            critBonus = MarsGame.getPreference().getTacticsAttackPowerShot();
            if (MarsGame.getPreference().getTacticsAttackGenerator()) energyBonus = MarsGame.getPreference().getTacticsAttackGeneratorEnergy();
        }
        else if (MarsGame.getPreference().getTacticsDefenseStart()) {
            bonus = "Defense";
            shieldBonus = MarsGame.getPreference().getTacticsDefenseGeneratorPowerShield() / 100;
            if (MarsGame.getPreference().getTacticsDefenseGenerator()) energyBonus = MarsGame.getPreference().getTacticsDefenseGeneratorEnergy();
            upLife = MarsGame.getPreference().getTacticsDefenseHeartLife();
            isLifeActive = true;
        }
        else if (MarsGame.getPreference().getTacticsTechnologiesStart()) {
            bonus = "Technologies";
            if (MarsGame.getPreference().getTacticsTechnologiesRadar()) energyBonus = MarsGame.getPreference().getTacticsTechnologiesRadarEnergy();
            isRadarActive = MarsGame.getPreference().getTacticsTechnologiesRadar();
        }
    }

    public void update(float deltaTime) {

    }

    public void render(SpriteBatch batch) {
        if (bonus.equals("Attack")) {
            if (MarsGame.getPreference().getTacticsAttackGenerator()) batch.draw(MarsGame.getTextures().textureRegion.get("DamageActive"), MarsGame.WIDTH / 2 - 32, 134, 40, 40);
            else batch.draw(MarsGame.getTextures().textureRegion.get("DamageNoActive"), MarsGame.WIDTH / 2 - 32, 134, 40, 40);
            if (critBonus > 0) batch.draw(MarsGame.getTextures().textureRegion.get("CriticalActive"), MarsGame.WIDTH / 2 + 32, 134, 40, 40);
            else batch.draw(MarsGame.getTextures().textureRegion.get("CriticalNoActive"), MarsGame.WIDTH / 2 + 32, 134, 40, 40);
        } else if (bonus.equals("Defense")) {
            if (MarsGame.getPreference().getTacticsDefenseGenerator()) batch.draw(MarsGame.getTextures().textureRegion.get("ShieldActive"), MarsGame.WIDTH / 2 - 32, 134, 40, 40);
            else batch.draw(MarsGame.getTextures().textureRegion.get("ShieldNoActive"), MarsGame.WIDTH / 2 - 32, 134, 40, 40);
            if (isLifeActive) batch.draw(MarsGame.getTextures().textureRegion.get("LifeActive"), MarsGame.WIDTH / 2 + 32, 134, 40, 40);
            else batch.draw(MarsGame.getTextures().textureRegion.get("LifeNoActive"), MarsGame.WIDTH / 2 + 32, 134, 40, 40);
        } else if (bonus.equals("Technologies")) {
            if (isRadarActive) batch.draw(MarsGame.getTextures().textureRegion.get("RadarActive"), MarsGame.WIDTH / 2, 134, 40, 40);
            else batch.draw(MarsGame.getTextures().textureRegion.get("RadarNoActive"), MarsGame.WIDTH / 2, 134, 40, 40);
        }
    }

    public float getDamageBonus() {
        return damageBonus;
    }

    public float getEnergyBonus() {
        return energyBonus;
    }

    public boolean isLifeActive() {
        return isLifeActive;
    }

    public void setLifeActive(boolean lifeActive) {
        isLifeActive = lifeActive;
    }

    public float getShieldBonus() {
        return shieldBonus;
    }

    public float getUpLife() {
        return upLife;
    }
}