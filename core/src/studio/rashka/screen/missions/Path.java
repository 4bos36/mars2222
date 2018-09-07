package studio.rashka.screen.missions;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Path {

    private Vector2 position, angel;
    private String mission;
    private int positionStart, numberPath = 1, route, // поворот
            change, change2; // точка движения
    private Random random;

    public Path(String mission, float posX, float posY, int positionStart, float angel) {
        this.mission = mission;
        this.positionStart = positionStart;

        random = new Random();
        position = new Vector2(posX, posY);
        this.angel = new Vector2(angel, 0);
        if (mission.equals("Missions_1_2")) change = random.nextInt(60);
        else if (mission.equals("Missions_1_3")) change = random.nextInt(30);
        else if (mission.equals("Missions_1_4")) change = random.nextInt(30);
        else if (mission.equals("Missions_1_5")) {
            change = random.nextInt(25);
            route = random.nextInt(2);
        } else if (mission.equals("Missions_1_6")) {
            change = random.nextInt(30);
            change2 = random.nextInt(192);
        } else if (mission.equals("Missions_2_2")) route = random.nextInt(2);
        else if (mission.equals("Missions_2_5")) route = random.nextInt(3);
        else if (mission.equals("Missions_3_1")) {
            change = random.nextInt(128);
            change2 = random.nextInt(96);
        } else if (mission.equals("Missions_3_2")) change = random.nextInt(96);
        else if (mission.equals("Missions_3_3")) change = random.nextInt(32);
        else if (mission.equals("Missions_3_5")) change = random.nextInt(32);
        else if (mission.equals("Missions_3_6")) change = random.nextInt(192);
        else if (mission.equals("Missions_4_1")) {
            if (positionStart == 0) route = random.nextInt(3);
            change = random.nextInt(64);
        } else if (mission.equals("Missions_4_6")) change = random.nextInt(64);
    }

    public Vector2 getPosition(float deltaTime, int speed, int speedMove) {
        //region 1
        if (mission.equals("Missions_1_1")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 510) numberPath = 2;
                } else if (numberPath == 2) {
                    position.add(deltaTime * speed / 2 * speedMove, -deltaTime * speed / 2 * speedMove);
                    angel.sub(deltaTime * 11 * speedMove, 0);
                    if (angel.x < 45) {
                        angel.x = 45;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, -deltaTime * speed * speedMove);
                    if (position.y < 930) {
                        numberPath = 4;
                        route = random.nextInt(2);
                    }
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (route == 0 && position.y < 900) numberPath = 6;
                    else if (route == 1 && position.y < 830) numberPath = 6;
                } else if (numberPath == 6) {
                    if (route == 0) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 90) {
                            angel.x = 90;
                            numberPath = 7;
                        }
                    } else  if (route == 1) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < -90) {
                            angel.x = -90;
                            numberPath = 7;
                        }
                    }
                } else if (numberPath == 7) {
                    if (route == 0) {
                        position.add(deltaTime * speed * speedMove, 0);
                        if (position.x > 710) numberPath = 8;
                    } else if (route == 1) {
                        position.sub(deltaTime * speed * speedMove, 0);
                        if (position.x < 510) numberPath = 8;
                    }
                } else if (numberPath == 8) {
                    if (route == 0) {
                        position.add(deltaTime * speed * speedMove, -deltaTime * speed * speedMove);
                        angel.sub(deltaTime * 11 * speedMove, 0);
                        if (angel.x < 45) {
                            angel.x = 45;
                            numberPath = 9;
                        }
                    } else if (route == 1) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 0) {
                            angel.x = 0;
                            numberPath = 9;
                        }
                    }
                } else if (numberPath == 9) {
                    if (route == 0) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 0) {
                            angel.x = 0;
                            numberPath = 10;
                        }
                    } else if (route == 1) {
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 480) numberPath = 10;
                    }
                } else if (numberPath == 10) {
                    if (route == 0) {
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 800) numberPath = 11;
                    } else if (route == 1) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < -90) {
                            angel.x = -90;
                            numberPath = 11;
                        }
                    }
                } else if (numberPath == 11) {
                    if (route == 0) {
                        angel.x = 45;
                        numberPath = 0; /////////////////////////////////
                    } else if (route == 1) {
                        position.sub(deltaTime * speed * speedMove, 0);
                        if (position.x < 160) numberPath = 12;
                    }
                } else if (numberPath == 12) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 13;
                    }
                } else if (numberPath == 13) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 160) numberPath = 14;
                } else if (numberPath == 14) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 15;
                    }
                } else if (numberPath == 15) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1120) numberPath = 16;
                } else if (numberPath == 16) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 17;
                    }
                } else if (numberPath == 17) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 225) numberPath = 18;
                } else if (numberPath == 18) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 19;
                    }
                } else if (numberPath == 19) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1200) numberPath = 20;
                } else if (numberPath == 20) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 225) {
                        angel.x = 225;
                        numberPath = 21;
                    }
                } else if (numberPath == 21) {
                    position.add(-deltaTime * speed * speedMove, deltaTime * speed * speedMove);
                    if (position.x < 1120) numberPath = 22;
                } else if (numberPath == 22) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 23;
                    }
                } else if (numberPath == 23) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 420) numberPath = 24;
                } else if (numberPath == 24) {
                    angel.x = 225;
                    numberPath = 0; /////////////////////////////////
                }
            }
            //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 920) numberPath = 2;
                } else if (numberPath == 2) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    angel.add(deltaTime * 21 * speedMove, 0);
                    if (angel.x > 315) {
                        angel.x = 315;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, deltaTime * speed * speedMove);
                    angel.sub(deltaTime * 12 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1345) {
                        numberPath = 5;
                        route = random.nextInt(2);
                    }
                } else if (numberPath == 5) {
                    if (route == 0) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 180) {
                            angel.x = 180;
                            numberPath = 6;
                        }
                    } else if (route == 1) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 360) {
                            angel.x = 360;
                            numberPath = 6;
                        }
                    }
                } else if (numberPath == 6) {
                    if (route == 0) {
                        position.add(0, deltaTime * speed * speedMove);
                        if (position.y > 990) numberPath = 7;
                    } else if (route == 1) {
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 355) numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    if (route == 0) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 270) {
                            angel.x = 270;
                            numberPath = 8;
                        }
                    } else if (route == 1) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 450) {
                            angel.x = 450;
                            numberPath = 8;
                        }
                    }
                } else if (numberPath == 8) {
                    if (route == 0) {
                        position.sub(deltaTime * speed * speedMove, 0);
                        if (position.x < 1120) numberPath = 9;
                    } else if (route == 1) {
                        position.add(deltaTime * speed * speedMove, 0);
                        if (position.x > 1760) numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    if (route == 0) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 360) {
                            angel.x = 360;
                            numberPath = 10;
                        }
                    } else if (route == 1) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 360) {
                            angel.x = 360;
                            numberPath = 10;
                        }
                    }
                } else if (numberPath == 10) {
                    if (route == 0) {
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 800) numberPath = 11;
                    } else if (route == 1) {
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 225) numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    if (route == 0) {
                        angel.x = 315;
                        numberPath = 0; /////////////////////////////////
                    } else if (route == 1) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 270) {
                            angel.x = 270;
                            numberPath = 12;
                        }
                    }
                } else if (numberPath == 12) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1200) numberPath = 13;
                } else if (numberPath == 13) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 225) {
                        angel.x = 225;
                        numberPath = 14;
                    }
                } else if (numberPath == 14) {
                    position.add(-deltaTime * speed * speedMove, deltaTime * speed * speedMove);
                    if (position.x < 1120) numberPath = 15;
                } else if (numberPath == 15) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 16;
                    }
                } else if (numberPath == 16) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 420) numberPath = 17;
                } else if (numberPath == 17) {
                    angel.x = 225;
                    numberPath = 0; /////////////////////////////////
                }
            }
            //endregion
        } else if (mission.equals("Missions_1_2")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 690 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 710) numberPath = 0; /////////////////////////////////
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 630 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 710) numberPath = 0; /////////////////////////////////
                }
            }  //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 690 - change) {
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1140) numberPath = 0; /////////////////////////////////
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 630 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1140) numberPath = 0; /////////////////////////////////
                }
            }
            //endregion
        } else if (mission.equals("Missions_1_3")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 770) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 45) {
                        angel.x = 45;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, -deltaTime * speed * speedMove);
                    if (position.y < 705) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 720) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 775 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1135) {
                        angel.x = -45;
                        numberPath = 0; /////////////////////////////////
                    }
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 440 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1135) {
                        angel.x = 225;
                        numberPath = 0; /////////////////////////////////
                    }
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 2020) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 775 - change) numberPath = 4;
                }  else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1135) {
                        angel.x = 315;
                        numberPath = 0; /////////////////////////////////
                    }
                }
            } //endregion
            //region code 4
            else if (positionStart == 4) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 2020) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 445 + change) numberPath = 4;
                }  else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1135) {
                        angel.x = 225;
                        numberPath = 0; /////////////////////////////////
                    }
                }
            } //endregion
        } else if (mission.equals("Missions_1_4")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 770) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 45) {
                        angel.x = 45;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, -deltaTime * speed * speedMove);
                    if (position.y < 705) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 700) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 515) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 145) {
                        angel.x = 145;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, deltaTime * speed * speedMove);
                    if (position.y > 575) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 700) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 280 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1275 - change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 230 - change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 810 - change) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 375) {
                        angel.x = 160;
                        numberPath = 0;
                    }
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 2020 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 330 - change) numberPath = 4;
                }  else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1270 - change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 225 - change) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 805 - change) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 370) {
                        angel.x = 160;
                        numberPath = 0;
                    }
                }
            } //endregion
            //region code 4
            else if (positionStart == 4) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 2145 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 830 + change) numberPath = 4;
                }  else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 2020 - change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 930 + change) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1315 - change) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1030 + change) numberPath = 12;
                } else if (numberPath == 12) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 13;
                    }
                } else if (numberPath == 13) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1090 - change) numberPath = 14;
                } else if (numberPath == 14) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 15;
                    }
                } else if (numberPath == 15) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 860) {
                        angel.x = 340;
                        numberPath = 0;
                    }
                }
            } //endregion
            //region code 5
            else if (positionStart == 5) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1055 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1090 - change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 860) {
                        angel.x = -20;
                        numberPath = 0;
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_1_5")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 665 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1750 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1020 + change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1450 - change) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 710 - change) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1175) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (route == 0) {
                    if (numberPath == 1) {
                        position.sub(deltaTime * speed * speedMove, 0);
                        if (position.x < 900 - change) numberPath = 2;
                    } else if (numberPath == 2) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 360) {
                            angel.x = 360;
                            numberPath = 3;
                        }
                    } else if (numberPath == 3) {
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 850) numberPath = 0;
                    }
                } else if (route == 1) {
                    if (numberPath == 1) {
                        position.sub(deltaTime * speed * speedMove, 0);
                        if (position.x < 260 - change) numberPath = 2;
                    } else if (numberPath == 2) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 360) {
                            angel.x = 360;
                            numberPath = 3;
                        }
                    } else if (numberPath == 3) {
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 550 - change) numberPath = 4;
                    } else if (numberPath == 4) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 450) {
                            angel.x = 450;
                            numberPath = 5;
                        }
                    } else if (numberPath == 5) {
                        position.add(deltaTime * speed * speedMove, 0);
                        if (position.x > 720) numberPath = 0;
                    }
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 665 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1175) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_1_6")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1100 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1590 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 740 - change2) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1180) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1635 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 740 - change2) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1180) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 555 + change2) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1180) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1430 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 540 + change2) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1180) numberPath = 0;
                }
            } //endregion
        }
        //endregion
        //region 2
        else if (mission.equals("Missions_2_1")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 672) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 160) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 320) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 448) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1760) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 928) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1440) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 608) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1216) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_2_2")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 960) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -45) {
                        angel.x = -45;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, deltaTime * speed * speedMove);
                    if (position.x < 160) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 160) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 480) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608 && route == 0) numberPath = 10;
                    else if (position.y > 1088 && route == 1) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 640 && route == 0) numberPath = 0;
                    else if (position.x > 928 && route == 1) numberPath = 12;
                } else if (numberPath == 12) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 13;
                    }
                } else if (numberPath == 13) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 896) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608 && route == 0) numberPath = 2;
                    else if (position.y > 1088 && route == 1) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184 && route == 0) numberPath = 0;
                    else if (position.x < 928 && route == 1) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 896) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_2_3")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1824) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 896) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1472) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 672) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1024) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1824) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 896) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1472) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 672) numberPath = 10;
                } else if (numberPath == 11) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 12;
                    }
                } else if (numberPath == 13) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 896) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1472) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 672) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1472) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184) numberPath = 0;
                }
            } //endregion
            //region code 4
            else if (positionStart == 4) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1472) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_2_4")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 928) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1472) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 704) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 928) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 128) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 288) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 480) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 640) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 480) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 640) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 160) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1440) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 96) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1760) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_2_5")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1440) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 736) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 352) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 736) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 640) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 160) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 480) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 640) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184) numberPath = 0;
                }
            } //endregion
            //region code 4
            else if (positionStart == 4) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1760) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 96) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1440) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 480) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_2_6")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 192) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 608) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 608) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 640) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 640) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 576) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 640) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 352) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1568) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 160) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1280) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -180) {
                        angel.x = -180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 448) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1184) numberPath = 0;
                }
            } //endregion
            //region code 4
            else if (positionStart == 4) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 384 && route == 0) numberPath = 2;
                    else if (position.y < 352 && route == 1) numberPath = 2;
                    else if (position.y < 320 && route == 2) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1536 && route == 0) numberPath = 4;
                    else if (position.x < 1568 && route == 1) numberPath = 4;
                    else if (position.x < 1600 && route == 2) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 192 && route == 0) numberPath = 6;
                    else if (position.y < 160 && route == 1) numberPath = 6;
                    else if (position.y < 128 && route == 2) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 192 && route == 0) numberPath = 8;
                    else if (position.x < 160 && route == 1) numberPath = 8;
                    else if (position.x < 128 && route == 2) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -180) {
                        angel.x = -180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 640 && route == 0) numberPath = 10;
                    else if (position.y > 608 && route == 1) numberPath = 10;
                    else if (position.y > 576 && route == 2) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -270) {
                        angel.x = -270;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 608) numberPath = 0;
                }
            } //endregion
        }
        //endregion
        //region 3
        else if (mission.equals("Missions_3_1")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 576) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 672) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 672 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 672) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 928 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1568 - change2) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -180) {
                        angel.x = -180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1120 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 928 - change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_3_2")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 864 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 960 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 672) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1120) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_3_3")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 672 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 576 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 160 - change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 992 + change) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 384) {
                        angel.x = 205;
                        numberPath = 0;
                    }
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 640 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 576 - change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 896 + change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 800 + change) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 800) {
                        angel.x = 30;
                        numberPath = 0;
                    }
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1344 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 256 - change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1056 - change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 160 - change) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 608 - change) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -180) {
                        angel.x = -180;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 896 + change) numberPath = 12;
                } else if (numberPath == 12) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -270) {
                        angel.x = -270;
                        numberPath = 13;
                    }
                } else if (numberPath == 13) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 800 + change) numberPath = 14;
                } else if (numberPath == 14) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -360) {
                        angel.x = -360;
                        numberPath = 15;
                    }
                } else if (numberPath == 15) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 800) {
                        angel.x = -340;
                        numberPath = 0;
                    }
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1472 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 288) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1056 - change) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 384) {
                        angel.x = 205;
                        numberPath = 0;
                    }
                }
            } //endregion
        } else if (mission.equals("Missions_3_4")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1424) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 704) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 624) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 272) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1312) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 512) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1158) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 608) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1158) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1312) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -180) {
                        angel.x = -180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 736) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1160) numberPath = 0;
                }
            } //endregion
            //region code 4
            if (positionStart == 4) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1120) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1424) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 660) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1172) numberPath = 0;
                }
            } //endregion
            //region code 5
            if (positionStart == 5) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1680) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -180) {
                        angel.x = -180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1172) numberPath = 0;
                }
            } //endregion
            //region code 6
            if (positionStart == 6) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 272) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1312) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 512) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1172) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_3_5")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 608) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
            //region code 1
            if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
            //region code 2
            if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1376 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 716 - change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
            //region code 3
            if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1120 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1376 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 716 - change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
            //region code 4
            if (positionStart == 4) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 256) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1312 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 512 + change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_3_6")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 512) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
            //region code 1
            if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 992 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 832 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 832) numberPath = 0;
                }
            } //endregion
            //region code 2
            if (positionStart == 2) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1600 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 704 - change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
            //region code 3
            if (positionStart == 3) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 192) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1408) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 512 + change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
            //region code 4
            if (positionStart == 4) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 224) numberPath = 0;
                }
            } //endregion
        }
        //endregion
        //region 4
        else if (mission.equals("Missions_4_1")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (route == 0) {
                        if (position.x < 1056) numberPath = 2;
                    } else if (route == 1) {
                        if (position.x < 928) numberPath = 2;
                    } else if (route == 2) {
                        if (position.x < 800) numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 416) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 640 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 672) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1024) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 800) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 576 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1120) numberPath = 0;
                }
            } //endregion
            //region code 4
            else if (positionStart == 4) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 640 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 544) numberPath = 0;
                }
            } //endregion
            //region code 5
            else if (positionStart == 5) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1024) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 928) numberPath = 0;
                }
            } //endregion
            //region code 6
            else if (positionStart == 6) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 576 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1248) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_4_2")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 640) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 576) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1088) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 928) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 960) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 256) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 192) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 960) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 400) numberPath = 0;
                }
            } //endregion
            //region code 4
            else if (positionStart == 4) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 192) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 192) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 640) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 704) numberPath = 0;
                }
            } //endregion
            //region code 5
            else if (positionStart == 5) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 192) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 960) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 352) numberPath = 0;
                }
            } //endregion
            //region code 6
            else if (positionStart == 6) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 192) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 192) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 960) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 352) numberPath = 0;
                }
            } //endregion
            //region code 7
            else if (positionStart == 7) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 448) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 640) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 450) {
                        angel.x = 450;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 704) numberPath = 0;
                }
            } //endregion
            //region code 8 - 9
            else if (positionStart == 8 || positionStart == 9) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1088) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 448) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 640) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 736) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_4_3")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 192) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 704) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 576) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 352) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 45) {
                        angel.x = 45;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, -deltaTime * speed * speedMove);
                    if (position.y < 192) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 960) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 384) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 192) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 352) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 45) {
                        angel.x = 45;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, -deltaTime * speed * speedMove);
                    if (position.y < 192) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 960) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 384) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 512) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
            //region code 4
            else if (positionStart == 4) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1536) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 512) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_4_4")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 384) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 320) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 192) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1536) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1088) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1120) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1536) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -180) {
                        angel.x = -180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1152) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 4
            else if (positionStart == 4) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1088) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 5
            else if (positionStart == 5) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 320) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 672) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 512) numberPath = 0;
                }
            } //endregion
            //region code 6
            else if (positionStart == 6) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 608) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1344) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_4_5")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove / 2, deltaTime * speed * speedMove);
                    if (position.y > 992) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 896) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1024) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 896) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1024) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 896) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1664) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 512) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1408) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 272) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 896) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 384) numberPath = 0;
                }
            } //endregion
            //region code 4
            else if (positionStart == 4) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 288) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1440) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 480) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1696) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1008) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 896) numberPath = 12;
                } else if (numberPath == 12) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 13;
                    }
                } else if (numberPath == 13) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 5
            else if (positionStart == 5) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 896) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 384) numberPath = 0;
                }
            } //endregion
            //region code 6
            else if (positionStart == 6) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 272) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 896) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 384) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_4_6")) {
            //region code 0
            if (positionStart == 0) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1024) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1408) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -180) {
                        angel.x = -180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1120) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > -90) {
                        angel.x = -90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 1
            else if (positionStart == 1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 192 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1536 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 928 + change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1408) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1152) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 12;
                } else if (numberPath == 12) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 13;
                    }
                } else if (numberPath == 13) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 2
            else if (positionStart == 2) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1536 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 928 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1408) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1152) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 3
            else if (positionStart == 3) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 128 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1536 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 928 + change) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1408) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1152) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 12;
                } else if (numberPath == 12) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 13;
                    }
                } else if (numberPath == 13) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 4
            else if (positionStart == 4) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 928 + change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1408) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1152) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 5
            else if (positionStart == 5) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1600 - change) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 928 + change) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1408) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1152) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1024) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
            //region code 6
            else if (positionStart == 6) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 608) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 512) numberPath = 0;
                }
            } //endregion
            //region code 7
            else if (positionStart == 7) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1568) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1376) numberPath = 0;
                }
            } //endregion
            //region code 8
            else if (positionStart == 8) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 608) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 704) numberPath = 0;
                }
            } //endregion
            //region code 9
            else if (positionStart == 9) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 352) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 704) numberPath = 0;
                }
            }
            //endregion
            // region code 10
            else if (positionStart == 10) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 160) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 384) numberPath = 0;
                }
            } //endregion
            // region code 11
            else if (positionStart == 11) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 160) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 928) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 384) numberPath = 0;
                }
            } //endregion
            //region code 12
            else if (positionStart == 12) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1568) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1152) numberPath = 0;
                }
            } //endregion
        }
        //endregion
        return position;
    }

    public Vector2 getPositionFlyToWorker(float deltaTime, int speed, int speedMove) {
        if (mission.equals("Missions_2_4")) {
            //region code -1
            if (positionStart == -1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1152) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = -1;
                    }
                }
            } //endregion
        } else if (mission.equals("Missions_2_5")) {
            //region code -1
            if (positionStart == -1) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 160) numberPath = -1;
                }
            } //endregion
        } else if (mission.equals("Missions_2_6")) {
            //region code -1
            if (positionStart == -1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 804) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1254) numberPath = -1;
                }
            } //endregion
        } else if (mission.equals("Missions_3_1") || mission.equals("Missions_3_2")) {
            //region code -1
            if (positionStart == -1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 80) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 928) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = -1;
                    }
                }
            } //endregion
        } else if (mission.equals("Missions_3_3")) {
            //region code -1
            if (positionStart == -1) {
                if (numberPath == 1) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1248) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = -1;
                    }
                }
            } //endregion
        }
        return position;
    }

    public Vector2 getPositionFlyToBase(float deltaTime, int speed, int speedMove) {
        if (mission.equals("Missions_2_4")) {
            //region code -1
            if (positionStart == -1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1152) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 864) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_2_5")) {
            //region code -1
            if (positionStart == -1) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 352) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_2_6")) {
            //region code -1
            if (positionStart == -1) {
                if (numberPath == 1) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 804) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1126) {
                        angel.x = 135;
                        numberPath = 0;
                    }
                }
            } //endregion
        } else if (mission.equals("Missions_3_1")) {
            //region code -1
            if (positionStart == -1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 576) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1120) numberPath = 0;
                }
            } //endregion
        } else if (mission.equals("Missions_3_2")) {
            //region code -1
            if (positionStart == -1) {
                if (numberPath == 1) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 80) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 928) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 384) numberPath = 0;
                }
            } //endregion
        }
        return position;
    }

    public float getAngel() {
        return angel.x;
    }

    public int getNumberPath() {
        return numberPath;
    }
}