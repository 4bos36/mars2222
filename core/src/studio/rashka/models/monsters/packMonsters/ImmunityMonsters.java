package studio.rashka.models.monsters.packMonsters;

import com.brashmonkey.spriter.Player;

import studio.rashka.MarsGame;

public class ImmunityMonsters {

    private static final int NONE = 0, FIRE = 1, ICE = 2, POISON = 3;
    private String immunityMagic;
    private Player monster;

    public ImmunityMonsters(String nameMonster, int immunity) {
        if (nameMonster.equals("Monster_1")) monster = new Player(MarsGame.getTextures().data.get("Monster_1").getEntity(0));
        else if (nameMonster.equals("Monster_2")) monster = new Player(MarsGame.getTextures().data.get("Monster_2").getEntity(0));
        else if (nameMonster.equals("Monster_3")) monster = new Player(MarsGame.getTextures().data.get("Monster_3").getEntity(0));
        else if (nameMonster.equals("Monster_4")) {
            if (immunity == NONE) monster = new Player(MarsGame.getTextures().data.get("Monster_4").getEntity("monster"));
            else if (immunity == FIRE) monster = new Player(MarsGame.getTextures().data.get("Monster_4").getEntity("monsterR"));
            else if (immunity == ICE) monster = new Player(MarsGame.getTextures().data.get("Monster_4").getEntity("monsterB"));
            else if (immunity == POISON) monster = new Player(MarsGame.getTextures().data.get("Monster_4").getEntity("monsterG"));
        } else if (nameMonster.equals("Monster_5")) {
            if (immunity == NONE) monster = new Player(MarsGame.getTextures().data.get("Monster_5").getEntity("monster"));
            else if (immunity == FIRE) monster = new Player(MarsGame.getTextures().data.get("Monster_5").getEntity("monsterR"));
            else if (immunity == ICE) monster = new Player(MarsGame.getTextures().data.get("Monster_5").getEntity("monsterB"));
            else if (immunity == POISON) monster = new Player(MarsGame.getTextures().data.get("Monster_5").getEntity("monsterG"));
        }

        if (immunity == NONE) {
            monster.setAnimation("run");
            immunityMagic = "NONE";
        } else if (immunity == FIRE) {
            if (nameMonster.equals("Monster_1") || nameMonster.equals("Monster_2") || nameMonster.equals("Monster_3")) monster.setAnimation("runR");
            else monster.setAnimation("run");
            immunityMagic = "Fire";
        } else if (immunity == ICE) {
            if (nameMonster.equals("Monster_1") || nameMonster.equals("Monster_2") || nameMonster.equals("Monster_3")) monster.setAnimation("runB");
            else monster.setAnimation("run");
            immunityMagic = "Ice";
        } else if (immunity == POISON) {
            if (nameMonster.equals("Monster_1") || nameMonster.equals("Monster_2") || nameMonster.equals("Monster_3")) monster.setAnimation("runG");
            else monster.setAnimation("run");
            immunityMagic = "Poison";
        }
    }

    public Player getMonster() {
        return monster;
    }

    public void getMonsterAttack() {
        if (monster.getAnimation().name.equals("run")) monster.setAnimation("attack");
        else if (monster.getAnimation().name.equals("runR")) monster.setAnimation("attackR");
        else if (monster.getAnimation().name.equals("runB")) monster.setAnimation("attackB");
        else if (monster.getAnimation().name.equals("runG")) monster.setAnimation("attackG");
    }

    public String getImmunityMagic() {
        return immunityMagic;
    }
}