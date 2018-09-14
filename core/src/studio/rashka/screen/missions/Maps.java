package studio.rashka.screen.missions;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import java.util.ArrayList;

import studio.rashka.MarsGame;
import studio.rashka.lib.Textures;
import studio.rashka.lib.implement.Buttons;
import studio.rashka.lib.singleton.ScaleMap;
import studio.rashka.models.games.Towers;

public class Maps {

    private TiledMap map;
    private OrthogonalTiledMapRenderer rendererMap;

    private String mission;
    private ArrayList<Towers> towerses;
    private ArrayList<Buttons> buttons;
    private float sizeBtn = 128;
    private int priceTower = 0, tower;
    private int[] posX, posY;

    private static final Drawable img = Textures.getInstance().getTextureButtonSkin().getDrawable("NULL");

    public Maps(String mission, OrthographicCamera camera) {
        this.mission = mission;
        towerses = new ArrayList<Towers>();
        buttons = new ArrayList<Buttons>();

        //region 1
        if (mission.equals("Missions_1_1")) {
            //region code
            map = new TmxMapLoader().load("map/map1-1.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{640, 352, 1248, 1440};
            posY = new int[]{992, 256, 1088, 448};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_1_2")) {
            //region code
            map = new TmxMapLoader().load("map/map1-2.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{416, 416, 1376, 1376};
            posY = new int[]{800, 384, 800, 384};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_1_3")) {
            //region code
            map = new TmxMapLoader().load("map/map1-3.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 2560, 1280);
            posX = new int[]{1376, 1376, 2080, 2080};
            posY = new int[]{864, 224, 672, 416};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_1_4")) {
            //region code
            map = new TmxMapLoader().load("map/map1-4.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 2560, 1280);
            posX = new int[]{160, 1280, 1376, 2176};
            posY = new int[]{576, 704, 64, 512};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_1_5")) {
            //region code
            map = new TmxMapLoader().load("map/map1-5.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{352, 1184, 1184, 1536};
            posY = new int[]{896, 896, 288, 800};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_1_6")) {
            //region code
            map = new TmxMapLoader().load("map/map1-6.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 2080, 1280);
            posX = new int[]{896, 1248, 1568, 1728};
            posY = new int[]{64, 832, 288, 832};
            tower = 4;
            //endregion
        }
        //endregion
        //region 2
        else if (mission.equals("Missions_2_1")) {
            //region code
            map = new TmxMapLoader().load("map/map2-1.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{256, 576, 1024, 1536};
            posY = new int[]{384, 1024, 96, 544};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_2_2")) {
            //region code
            map = new TmxMapLoader().load("map/map2-2.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{256, 256, 1472, 1472};
            posY = new int[]{672, 256, 864, 384};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_2_3")) {
            //region code
            map = new TmxMapLoader().load("map/map2-3.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{384, 1600, 1568, 1568};
            posY = new int[]{800, 1120, 640, 288};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_2_4")) {
            //region code
            map = new TmxMapLoader().load("map/map2-4.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{128, 256, 1568, 1536};
            posY = new int[]{1024, 384, 704, 192};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_2_5")) {
            //region code
            map = new TmxMapLoader().load("map/map2-5.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{128, 256, 1536, 1536};
            posY = new int[]{768, 256, 832, 320};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_2_6")) {
            //region code
            map = new TmxMapLoader().load("map/map2-6.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{288, 288, 1152, 1696};
            posY = new int[]{768, 320, 544, 96};
            tower = 4;
            //endregion
        }
        //endregion
        //region 3
        else if (mission.equals("Missions_3_1")) {
            //region code
            map = new TmxMapLoader().load("map/map3-1.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{384, 416, 1280, 1728};
            posY = new int[]{800, 288, 864, 288};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_3_2")) {
            //region code
            map = new TmxMapLoader().load("map/map3-2.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{416, 1376, 192, 1600};
            posY = new int[]{832, 832, 192, 192};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_3_3")) {
            //region code
            map = new TmxMapLoader().load("map/map3-3.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{448, 736, 1184, 1408};
            posY = new int[]{960, 224, 640, 96};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_3_4")) {
            //region code
            map = new TmxMapLoader().load("map/map3-4.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{1184, 1536, 1440, 1056};
            posY = new int[]{864, 736, 352, 32};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_3_5")) {
            //region code
            map = new TmxMapLoader().load("map/map3-5.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{544, 1120, 1536, 1472};
            posY = new int[]{224, 864, 736, 352};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_3_6")) {
            //region code
            map = new TmxMapLoader().load("map/map3-6.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{512, 512, 1152, 1728};
            posY = new int[]{736, 192, 928, 736};
            tower = 4;
            //endregion
        }
        //endregion
        //region 4
        else if (mission.equals("Missions_4_1")) {
            //region code
            map = new TmxMapLoader().load("map/map4-1.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{352, 480, 1248, 1376};
            posY = new int[]{352, 736, 352, 736};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_4_2")) {
            //region code
            map = new TmxMapLoader().load("map/map4-2.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{288, 544, 1216, 1504};
            posY = new int[]{288, 864, 288, 864};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_4_3")) {
            //region code
            map = new TmxMapLoader().load("map/map4-3.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{96, 352, 1312, 1632};
            posY = new int[]{96, 352, 288, 704};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_4_4")) {
            //region code
            map = new TmxMapLoader().load("map/map4-4.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{416, 800, 1312, 1632};
            posY = new int[]{288, 1056, 288, 704};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_4_5")) {
            //region code
            map = new TmxMapLoader().load("map/map4-5.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{416, 832, 832, 1440};
            posY = new int[]{800, 64, 1088, 800};
            tower = 4;
            //endregion
        } else if (mission.equals("Missions_4_6")) {
            //region code
            map = new TmxMapLoader().load("map/map4-6.tmx");
            rendererMap = new OrthogonalTiledMapRenderer(map);
            rendererMap.setView(camera.combined, 0, 0, 1920, 1280);
            posX = new int[]{480, 800, 1312, 1696};
            posY = new int[]{288, 1056, 288, 736};
            tower = 4;
            //endregion
        }
        //endregion

        if (tower == 4) {
            towerses.add(0, new Towers(posX[0], posY[0]));
            towerses.add(1, new Towers(posX[1], posY[1]));
            towerses.add(2, new Towers(posX[2], posY[2]));
            towerses.add(3, new Towers(posX[3], posY[3]));
            buttonBuildTower_4();
        }
    }

    private void buttonBuildTower_4() {
        buttons.add(0, new Buttons("0", img, 128, 128, posX[0], posY[0]));
        buttons.add(1, new Buttons("1", img, 128, 128, posX[1], posY[1]));
        buttons.add(2, new Buttons("2", img, 128, 128, posX[2], posY[2]));
        buttons.add(3, new Buttons("3", img, 128, 128, posX[3], posY[3]));

        buttons.get(0).addListener(new ButtonsInputListener(buttons.get(0).getName()));
        buttons.get(1).addListener(new ButtonsInputListener(buttons.get(1).getName()));
        buttons.get(2).addListener(new ButtonsInputListener(buttons.get(2).getName()));
        buttons.get(3).addListener(new ButtonsInputListener(buttons.get(3).getName()));
    }

    public void update(Vector2 positionMap, float deltaTime, float mp) {
        for (int i = 0; i < towerses.size(); i++) towerses.get(i).update(positionMap, deltaTime, mp, ScaleMap.INSTANCE.getScale());
        if (ScaleMap.INSTANCE.getScale() == 1.0f) {
            //region code
            if (sizeBtn != 128) {
                buttons.get(0).setSize(128, 128);
                buttons.get(1).setSize(128, 128);
                buttons.get(2).setSize(128, 128);
                buttons.get(3).setSize(128, 128);
                towerses.get(0).setPosBtnX(posX[0]); towerses.get(0).setPosBtnY(posY[0]);
                towerses.get(1).setPosBtnX(posX[1]); towerses.get(1).setPosBtnY(posY[1]);
                towerses.get(2).setPosBtnX(posX[2]); towerses.get(2).setPosBtnY(posY[2]);
                towerses.get(3).setPosBtnX(posX[3]); towerses.get(3).setPosBtnY(posY[3]);
                sizeBtn = 128;
            }
            buttons.get(0).setPosition(posX[0] + positionMap.x, posY[0] + positionMap.y);
            buttons.get(1).setPosition(posX[1] + positionMap.x, posY[1] + positionMap.y);
            buttons.get(2).setPosition(posX[2] + positionMap.x, posY[2] + positionMap.y);
            buttons.get(3).setPosition(posX[3] + positionMap.x, posY[3] + positionMap.y);
            //endregion
        } else {
            //region 1
            if (mission.equals("Missions_1_1")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(800); towerses.get(0).setPosBtnY(768);
                    towerses.get(1).setPosBtnX(656); towerses.get(1).setPosBtnY(400);
                    towerses.get(2).setPosBtnX(1104); towerses.get(2).setPosBtnY(816);
                    towerses.get(3).setPosBtnX(1200); towerses.get(3).setPosBtnY(496);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(800 + positionMap.x * 0.5f, 768 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(656 + positionMap.x * 0.5f, 400 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1104 + positionMap.x * 0.5f, 816 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1200 + positionMap.x * 0.5f, 496 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_1_2")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(688); towerses.get(0).setPosBtnY(672);
                    towerses.get(1).setPosBtnX(688); towerses.get(1).setPosBtnY(464);
                    towerses.get(2).setPosBtnX(1168); towerses.get(2).setPosBtnY(672);
                    towerses.get(3).setPosBtnX(1168); towerses.get(3).setPosBtnY(464);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(688 + positionMap.x * 0.5f, 672 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(688 + positionMap.x * 0.5f, 464 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1168 + positionMap.x * 0.5f, 672 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1168 + positionMap.x * 0.5f, 464 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_1_3")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(1168); towerses.get(0).setPosBtnY(704);
                    towerses.get(1).setPosBtnX(1168); towerses.get(1).setPosBtnY(384);
                    towerses.get(2).setPosBtnX(1520); towerses.get(2).setPosBtnY(608);
                    towerses.get(3).setPosBtnX(1520); towerses.get(3).setPosBtnY(480);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(1168 + positionMap.x * 0.5f, 704 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(1168 + positionMap.x * 0.5f, 384 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1520 + positionMap.x * 0.5f, 608 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1520 + positionMap.x * 0.5f, 480 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_1_4")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(562); towerses.get(0).setPosBtnY(560);
                    towerses.get(1).setPosBtnX(1120); towerses.get(1).setPosBtnY(622);
                    towerses.get(2).setPosBtnX(1160); towerses.get(2).setPosBtnY(300);
                    towerses.get(3).setPosBtnX(1575); towerses.get(3).setPosBtnY(526);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(562 + positionMap.x * 0.5f, 560 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(1120 + positionMap.x * 0.5f, 622 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1160 + positionMap.x * 0.5f, 300 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1575 + positionMap.x * 0.5f, 526 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_1_5")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(656); towerses.get(0).setPosBtnY(720);
                    towerses.get(1).setPosBtnX(1070); towerses.get(1).setPosBtnY(720);
                    towerses.get(2).setPosBtnX(1070); towerses.get(2).setPosBtnY(418);
                    towerses.get(3).setPosBtnX(1242); towerses.get(3).setPosBtnY(670);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(656 + positionMap.x * 0.5f, 720 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(1070 + positionMap.x * 0.5f, 720 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1070 + positionMap.x * 0.5f, 418 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1242 + positionMap.x * 0.5f, 670 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_1_6")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(930); towerses.get(0).setPosBtnY(300);
                    towerses.get(1).setPosBtnX(1102); towerses.get(1).setPosBtnY(688);
                    towerses.get(2).setPosBtnX(1260); towerses.get(2).setPosBtnY(414);
                    towerses.get(3).setPosBtnX(1342); towerses.get(3).setPosBtnY(688);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(930 + positionMap.x * 0.5f, 300 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(1102 + positionMap.x * 0.5f, 688 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1260 + positionMap.x * 0.5f, 414 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1342 + positionMap.x * 0.5f, 688 + positionMap.y * 0.5f);
                //endregion
            }
            //endregion
            //region 2
            else if (mission.equals("Missions_2_1")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(628); towerses.get(0).setPosBtnY(462);
                    towerses.get(1).setPosBtnX(768); towerses.get(1).setPosBtnY(782);
                    towerses.get(2).setPosBtnX(992); towerses.get(2).setPosBtnY(318);
                    towerses.get(3).setPosBtnX(1248); towerses.get(3).setPosBtnY(542);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(628 + positionMap.x * 0.5f, 462 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(768 + positionMap.x * 0.5f, 782 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(992 + positionMap.x * 0.5f, 318 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1248 + positionMap.x * 0.5f, 542 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_2_2")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(608); towerses.get(0).setPosBtnY(606);
                    towerses.get(1).setPosBtnX(608); towerses.get(1).setPosBtnY(398);
                    towerses.get(2).setPosBtnX(1216); towerses.get(2).setPosBtnY(702);
                    towerses.get(3).setPosBtnX(1216); towerses.get(3).setPosBtnY(462);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(608 + positionMap.x * 0.5f, 606 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(608 + positionMap.x * 0.5f, 398 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1216 + positionMap.x * 0.5f, 702 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1216 + positionMap.x * 0.5f, 462 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_2_3")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(672); towerses.get(0).setPosBtnY(670);
                    towerses.get(1).setPosBtnX(1280); towerses.get(1).setPosBtnY(830);
                    towerses.get(2).setPosBtnX(1264); towerses.get(2).setPosBtnY(590);
                    towerses.get(3).setPosBtnX(1264); towerses.get(3).setPosBtnY(414);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(672 + positionMap.x * 0.5f, 670 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(1280 + positionMap.x * 0.5f, 830 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1264 + positionMap.x * 0.5f, 590 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1264 + positionMap.x * 0.5f, 414 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_2_4")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(544); towerses.get(0).setPosBtnY(782);
                    towerses.get(1).setPosBtnX(608); towerses.get(1).setPosBtnY(462);
                    towerses.get(2).setPosBtnX(1264); towerses.get(2).setPosBtnY(622);
                    towerses.get(3).setPosBtnX(1248); towerses.get(3).setPosBtnY(366);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(544 + positionMap.x * 0.5f, 782 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(608 + positionMap.x * 0.5f, 462 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1264 + positionMap.x * 0.5f, 622 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1248 + positionMap.x * 0.5f, 366 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_2_5")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(544); towerses.get(0).setPosBtnY(654);
                    towerses.get(1).setPosBtnX(608); towerses.get(1).setPosBtnY(398);
                    towerses.get(2).setPosBtnX(1248); towerses.get(2).setPosBtnY(686);
                    towerses.get(3).setPosBtnX(1248); towerses.get(3).setPosBtnY(430);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(544 + positionMap.x * 0.5f, 654 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(608 + positionMap.x * 0.5f, 398 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1248 + positionMap.x * 0.5f, 686 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1248 + positionMap.x * 0.5f, 430 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_2_6")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(544); towerses.get(0).setPosBtnY(654);
                    towerses.get(1).setPosBtnX(608); towerses.get(1).setPosBtnY(398);
                    towerses.get(2).setPosBtnX(1248); towerses.get(2).setPosBtnY(686);
                    towerses.get(3).setPosBtnX(1248); towerses.get(3).setPosBtnY(430);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(624 + positionMap.x * 0.5f, 654 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(624 + positionMap.x * 0.5f, 430 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1056 + positionMap.x * 0.5f, 542 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1328 + positionMap.x * 0.5f, 318 + positionMap.y * 0.5f);
                //endregion
            }
            //endregion
            //region 3
            else if (mission.equals("Missions_3_1")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(672); towerses.get(0).setPosBtnY(670);
                    towerses.get(1).setPosBtnX(688); towerses.get(1).setPosBtnY(416);
                    towerses.get(2).setPosBtnX(1120); towerses.get(2).setPosBtnY(702);
                    towerses.get(3).setPosBtnX(1344); towerses.get(3).setPosBtnY(416);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(672 + positionMap.x * 0.5f, 670 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(688 + positionMap.x * 0.5f, 416 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1120 + positionMap.x * 0.5f, 702 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1344 + positionMap.x * 0.5f, 416 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_3_2")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(686); towerses.get(0).setPosBtnY(686);
                    towerses.get(1).setPosBtnX(1168); towerses.get(1).setPosBtnY(686);
                    towerses.get(2).setPosBtnX(576); towerses.get(2).setPosBtnY(368);
                    towerses.get(3).setPosBtnX(1280); towerses.get(3).setPosBtnY(368);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(686 + positionMap.x * 0.5f, 686 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(1168 + positionMap.x * 0.5f, 686 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(576 + positionMap.x * 0.5f, 368 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1280 + positionMap.x * 0.5f, 368 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_3_3")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(704); towerses.get(0).setPosBtnY(752);
                    towerses.get(1).setPosBtnX(848); towerses.get(1).setPosBtnY(384);
                    towerses.get(2).setPosBtnX(1072); towerses.get(2).setPosBtnY(592);
                    towerses.get(3).setPosBtnX(1184); towerses.get(3).setPosBtnY(320);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(704 + positionMap.x * 0.5f, 752 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(848 + positionMap.x * 0.5f, 384 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1072 + positionMap.x * 0.5f, 592 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1184 + positionMap.x * 0.5f, 320 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_3_4")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(1072); towerses.get(0).setPosBtnY(704);
                    towerses.get(1).setPosBtnX(1248); towerses.get(1).setPosBtnY(640);
                    towerses.get(2).setPosBtnX(1200); towerses.get(2).setPosBtnY(448);
                    towerses.get(3).setPosBtnX(1008); towerses.get(3).setPosBtnY(288);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(1072 + positionMap.x * 0.5f, 704 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(1248 + positionMap.x * 0.5f, 640 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1200 + positionMap.x * 0.5f, 448 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1008 + positionMap.x * 0.5f, 288 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_3_5")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(752); towerses.get(0).setPosBtnY(384);
                    towerses.get(1).setPosBtnX(1040); towerses.get(1).setPosBtnY(704);
                    towerses.get(2).setPosBtnX(1248); towerses.get(2).setPosBtnY(640);
                    towerses.get(3).setPosBtnX(1216); towerses.get(3).setPosBtnY(448);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(752 + positionMap.x * 0.5f, 384 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(1040 + positionMap.x * 0.5f, 704 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1248 + positionMap.x * 0.5f, 640 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1216 + positionMap.x * 0.5f, 448 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_3_6")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(736); towerses.get(0).setPosBtnY(640);
                    towerses.get(1).setPosBtnX(736); towerses.get(1).setPosBtnY(368);
                    towerses.get(2).setPosBtnX(1056); towerses.get(2).setPosBtnY(736);
                    towerses.get(3).setPosBtnX(1344); towerses.get(3).setPosBtnY(640);
                    sizeBtn = 64;
                }
                buttons.get(0).setPosition(736 + positionMap.x * 0.5f, 640 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(736 + positionMap.x * 0.5f, 368 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1056 + positionMap.x * 0.5f, 736 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1344 + positionMap.x * 0.5f, 640 + positionMap.y * 0.5f);
                //endregion
            }
            //endregion
            //region 4
            else if (mission.equals("Missions_4_1")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(656); towerses.get(0).setPosBtnY(448);
                    towerses.get(1).setPosBtnX(720); towerses.get(1).setPosBtnY(640);
                    towerses.get(2).setPosBtnX(1104); towerses.get(2).setPosBtnY(448);
                    towerses.get(3).setPosBtnX(1168); towerses.get(3).setPosBtnY(640);
                    sizeBtn = 64;
                }

                buttons.get(0).setPosition(656 + positionMap.x * 0.5f, 448 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(720 + positionMap.x * 0.5f, 640 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1104 + positionMap.x * 0.5f, 448 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1168 + positionMap.x * 0.5f, 640 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_4_2")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(624); towerses.get(0).setPosBtnY(416);
                    towerses.get(1).setPosBtnX(752); towerses.get(1).setPosBtnY(704);
                    towerses.get(2).setPosBtnX(1088); towerses.get(2).setPosBtnY(416);
                    towerses.get(3).setPosBtnX(1228); towerses.get(3).setPosBtnY(704);
                    sizeBtn = 64;
                }

                buttons.get(0).setPosition(624 + positionMap.x * 0.5f, 416 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(752 + positionMap.x * 0.5f, 704 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1088 + positionMap.x * 0.5f, 416 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1228 + positionMap.x * 0.5f, 704 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_4_3")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(528); towerses.get(0).setPosBtnY(320);
                    towerses.get(1).setPosBtnX(656); towerses.get(1).setPosBtnY(447);
                    towerses.get(2).setPosBtnX(1136); towerses.get(2).setPosBtnY(416);
                    towerses.get(3).setPosBtnX(1298); towerses.get(3).setPosBtnY(624);
                    sizeBtn = 64;
                }

                buttons.get(0).setPosition(528 + positionMap.x * 0.5f, 320 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(656 + positionMap.x * 0.5f, 447 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1136 + positionMap.x * 0.5f, 416 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1298 + positionMap.x * 0.5f, 624 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_4_4")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(688); towerses.get(0).setPosBtnY(415);
                    towerses.get(1).setPosBtnX(880); towerses.get(1).setPosBtnY(800);
                    towerses.get(2).setPosBtnX(1136); towerses.get(2).setPosBtnY(416);
                    towerses.get(3).setPosBtnX(1298); towerses.get(3).setPosBtnY(624);
                    sizeBtn = 64;
                }

                buttons.get(0).setPosition(688 + positionMap.x * 0.5f, 415 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(880 + positionMap.x * 0.5f, 800 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1136 + positionMap.x * 0.5f, 416 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1298 + positionMap.x * 0.5f, 624 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_4_5")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(688); towerses.get(0).setPosBtnY(672);
                    towerses.get(1).setPosBtnX(896); towerses.get(1).setPosBtnY(300);
                    towerses.get(2).setPosBtnX(896); towerses.get(2).setPosBtnY(816);
                    towerses.get(3).setPosBtnX(1202); towerses.get(3).setPosBtnY(672);
                    sizeBtn = 64;
                }

                buttons.get(0).setPosition(688 + positionMap.x * 0.5f, 672 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(896 + positionMap.x * 0.5f, 300 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(896 + positionMap.x * 0.5f, 816 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1202 + positionMap.x * 0.5f, 672 + positionMap.y * 0.5f);
                //endregion
            } else if (mission.equals("Missions_4_6")) {
                //region code
                if (sizeBtn != 64) {
                    buttons.get(0).setSize(64, 64);
                    buttons.get(1).setSize(64, 64);
                    buttons.get(2).setSize(64, 64);
                    buttons.get(3).setSize(64, 64);
                    towerses.get(0).setPosBtnX(720); towerses.get(0).setPosBtnY(415);
                    towerses.get(1).setPosBtnX(880); towerses.get(1).setPosBtnY(800);
                    towerses.get(2).setPosBtnX(1136); towerses.get(2).setPosBtnY(416);
                    towerses.get(3).setPosBtnX(1330); towerses.get(3).setPosBtnY(640);
                    sizeBtn = 64;
                }

                buttons.get(0).setPosition(720 + positionMap.x * 0.5f, 415 + positionMap.y * 0.5f);
                buttons.get(1).setPosition(880 + positionMap.x * 0.5f, 800 + positionMap.y * 0.5f);
                buttons.get(2).setPosition(1136 + positionMap.x * 0.5f, 416 + positionMap.y * 0.5f);
                buttons.get(3).setPosition(1330 + positionMap.x * 0.5f, 640 + positionMap.y * 0.5f);
                //endregion
            }
            //endregion
        }
    }

    public void render(OrthographicCamera camera) {
        rendererMap.setView(camera);
        rendererMap.render();
    }

    public void renderTower(SpriteBatch batch) {
        for (int i = 0; i < towerses.size(); i++) {
            if (MarsGame.getFrustum().sphereInFrustum(towerses.get(i).getPosBtnX() + 64, towerses.get(i).getPosBtnY() + 64, 0, 48)) {
                towerses.get(i).render(batch);
                if (towerses.get(i).isStopShootTower()) towerses.get(i).setSounds(true);
            }
            else towerses.get(i).setSounds(false);
        }
    }

    public ArrayList<Buttons> getButtons() {
        return buttons;
    }

    public ArrayList<Towers> getTowerses() {
        return towerses;
    }

    public ArrayList<Buttons> getButtonsTower(int i) {
        return towerses.get(i).getButtons();
    }

    public int getPriceBuy() {
        if (tower == 4) {
            if (priceTower == 1) return towerses.get(0).getPriceBuy();
            else if (priceTower == 2) return towerses.get(1).getPriceBuy();
            else if (priceTower == 3) return towerses.get(2).getPriceBuy();
            else if (priceTower == 4) return towerses.get(3).getPriceBuy();
            else return 0;
        }
        else return 0;
    }

    public void setPriceBuy(int priceBuy) {
        if (tower == 4) {
            if (priceTower == 1) towerses.get(0).setPriceBuy(priceBuy);
            else if (priceTower == 2) towerses.get(1).setPriceBuy(priceBuy);
            else if (priceTower == 3) towerses.get(2).setPriceBuy(priceBuy);
            else if (priceTower == 4) towerses.get(3).setPriceBuy(priceBuy);
        }
    }

    public float getEnergy() {
        float energy = 0;
        for (int i = 0; i < buttons.size(); i++) {
            energy += towerses.get(i).getEnergy();
        }
        return energy;
    }

    public void dispose() {
        try {
            map.dispose();
            rendererMap.dispose();
            for (int i = 0; i < 4; i++) towerses.get(i).dispose();
            buttons.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ButtonsInputListener extends ClickListener {
        private String name;

        public ButtonsInputListener(String name) {
            this.name = name;
        }

        @Override
        public void clicked (InputEvent event, float x, float y) {

            if (name.equals("0")) {
                if (!towerses.get(0).isBuy()) {
                    if (towerses.get(0).isActiveMenu()) {
                        towerses.get(0).setActiveMenu(false);
                        priceTower = 0;
                    } else {
                        towerses.get(0).setActiveMenu(true);
                        priceTower = 1;
                    }
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                }
            } else if (name.equals("1")) {
                if (!towerses.get(1).isBuy()) {
                    if (towerses.get(1).isActiveMenu()) {
                        towerses.get(1).setActiveMenu(false);
                        priceTower = 0;
                    } else {
                        towerses.get(1).setActiveMenu(true);
                        priceTower = 2;
                    }
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                }
            } else if (name.equals("2")) {
                if (!towerses.get(2).isBuy()) {
                    if (towerses.get(2).isActiveMenu()) {
                        towerses.get(2).setActiveMenu(false);
                        priceTower = 0;
                    } else {
                        towerses.get(2).setActiveMenu(true);
                        priceTower = 3;
                    }
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                }
            } else if (name.equals("3")) {
                if (!towerses.get(3).isBuy()) {
                    if (towerses.get(3).isActiveMenu()) {
                        towerses.get(3).setActiveMenu(false);
                        priceTower = 0;
                    } else {
                        towerses.get(3).setActiveMenu(true);
                        priceTower = 4;
                    }
                    if (MarsGame.getPreference().loadSound() == 1) MarsGame.getMusicSound().sounds.get("ClickTerminal").play();
                }
            }
        }
    }
}