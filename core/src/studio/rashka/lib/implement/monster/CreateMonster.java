package studio.rashka.lib.implement.monster;

import com.badlogic.gdx.math.Vector2;

import studio.rashka.models.monsters.Monster_1;
import studio.rashka.models.monsters.Monster_2;
import studio.rashka.models.monsters.Monster_3;
import studio.rashka.models.monsters.Monster_4;
import studio.rashka.models.monsters.Monster_5;

public class CreateMonster implements AbstractFactoryMonsters {

    @Override
    public Monsters createMonsters(int monster, Vector2 position, int immunity, int type) {
        if (monster == 1) return new Monster_1(position, immunity, type);
        else if (monster == 2) return new Monster_2(position, immunity, type);
        else if (monster == 3) return new Monster_3(position, immunity, type);
        else if (monster == 4) return new Monster_4(position, immunity, type);
        else if (monster == 5) return new Monster_5(position, immunity, type);
        else return null;
    }
}