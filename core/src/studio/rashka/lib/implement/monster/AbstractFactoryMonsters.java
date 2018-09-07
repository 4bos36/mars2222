package studio.rashka.lib.implement.monster;

import com.badlogic.gdx.math.Vector2;

public interface AbstractFactoryMonsters {

    Monsters createMonsters(int monster, Vector2 position, int immunity, int type);
}