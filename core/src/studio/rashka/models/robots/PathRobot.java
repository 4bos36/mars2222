package studio.rashka.models.robots;

import com.badlogic.gdx.math.Vector2;

import studio.rashka.MarsGame;

public class PathRobot {

    private static final int WORK = 1, HOME = 2;
    private Vector2 position, angel;
    private String mission, effect = "RunWork";
    private int positionStart, numberPath = 1;
    private int crystal;
    private boolean isWork = true;

    public PathRobot(String mission, float posX, float posY, int positionStart, float angel, int crystal) {
        this.mission = mission;
        this.crystal = crystal;
        this.positionStart = positionStart;

        position = new Vector2(posX, posY);
        this.angel = new Vector2(angel, 0);
    }

    public void startWork() {
        if (mission.equals("Missions_3_3")) {
            positionStart = WORK;
            numberPath = 1;
        } else {
            if (MarsGame.getPreference().getCrystal(mission) <= 0) isWork = false;
            else {
                positionStart = WORK;
                numberPath = 1;
            }
        }
    }

    public void startHome() {
        positionStart = HOME;
        numberPath = 1;
    }

    public Vector2 getPosition(float deltaTime, int speed, int speedMove) {
        //region 1
        if (mission.equals("Missions_1_1")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1120) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1000) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1080) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 45) {
                        angel.x = 45;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(-deltaTime * speed * speedMove, deltaTime * speed * speedMove);
                    if (position.x < 1010) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1120) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 900) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1020) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -180) {
                        angel.x = -180;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 1060) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > -135) {
                        angel.x = -135;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.add(deltaTime * speed * speedMove, -deltaTime * speed * speedMove);
                    if (position.x > 1080) numberPath = 7;
                } else if (numberPath == 7) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > -90) {
                        angel.x = -90;
                        numberPath = 8;
                    }
                } else if (numberPath == 8) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1120) numberPath = 9;
                } else if (numberPath == 9) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -180) {
                        angel.x = -180;
                        numberPath = 10;
                    }
                } else if (numberPath == 10) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 610) numberPath = 11;
                } else if (numberPath == 11) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -270) {
                        angel.x = -270;
                        numberPath = 12;
                    }
                } else if (numberPath == 12) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 930) {
                        angel.x = -90;
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_1_2")) {
            if (MarsGame.getPreference().getCrystal(mission) >= 250) {
                //region Work
                if (positionStart == WORK) {
                    if (numberPath == 1) {
                        position.add(deltaTime * speed * speedMove, 0);
                        if (position.x > 1120) numberPath = 2;
                    } else if (numberPath == 2) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 0) {
                            angel.x = 0;
                            numberPath = 3;
                        }
                    } else if (numberPath == 3) {
                        position.add(0, deltaTime * speed * speedMove);
                        if (position.y > 1000) numberPath = 4;
                    } else if (numberPath == 4) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 90) {
                            angel.x = 90;
                            numberPath = 5;
                        }
                    } else if (numberPath == 5) {
                        position.sub(deltaTime * speed * speedMove, 0);
                        if (position.x < 1080) numberPath = 6;
                    } else if (numberPath == 6) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 45) {
                            angel.x = 45;
                            numberPath = 7;
                        }
                    } else if (numberPath == 7) {
                        position.add(-deltaTime * speed * speedMove, deltaTime * speed * speedMove);
                        if (position.x < 1010) numberPath = 8;
                    } else if (numberPath == 8) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 0) {
                            angel.x = 0;
                            numberPath = 9;
                        }
                    } else if (numberPath == 9) {
                        position.add(0, deltaTime * speed * speedMove);
                        if (position.y > 1120) numberPath = 10;
                    } else if (numberPath == 10) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 90) {
                            angel.x = 90;
                            numberPath = 11;
                        }
                    } else if (numberPath == 11) {
                        position.sub(deltaTime * speed * speedMove, 0);
                        if (position.x < 900) {
                            numberPath = 0;
                            effect = "Open";
                        }
                    }
                }
                //endregion
                //region Home
                else if (positionStart == HOME) {
                    if (numberPath == 1) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < -90) {
                            angel.x = -90;
                            numberPath = 2;
                        }
                    } else if (numberPath == 2) {
                        position.add(deltaTime * speed * speedMove, 0);
                        if (position.x > 1020) numberPath = 3;
                    } else if (numberPath == 3) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < -180) {
                            angel.x = -180;
                            numberPath = 4;
                        }
                    } else if (numberPath == 4) {
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 1060) numberPath = 5;
                    } else if (numberPath == 5) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > -135) {
                            angel.x = -135;
                            numberPath = 6;
                        }
                    } else if (numberPath == 6) {
                        position.add(deltaTime * speed * speedMove, -deltaTime * speed * speedMove);
                        if (position.x > 1080) numberPath = 7;
                    } else if (numberPath == 7) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > -90) {
                            angel.x = -90;
                            numberPath = 8;
                        }
                    } else if (numberPath == 8) {
                        position.add(deltaTime * speed * speedMove, 0);
                        if (position.x > 1120) numberPath = 9;
                    } else if (numberPath == 9) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < -180) {
                            angel.x = -180;
                            numberPath = 10;
                        }
                    } else if (numberPath == 10) {
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 610) numberPath = 11;
                    } else if (numberPath == 11) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < -270) {
                            angel.x = -270;
                            numberPath = 12;
                        }
                    } else if (numberPath == 12) {
                        position.sub(deltaTime * speed * speedMove, 0);
                        if (position.x < 930) {
                            angel.x = -90;
                            MarsGame.getPreference().saveMineral(crystal);
                            startWork();
                        }
                    }
                }
                //endregion
            } else if (MarsGame.getPreference().getCrystal(mission) < 250) {
                //region Work
                if (positionStart == WORK) {
                    if (numberPath == 1) {
                        angel.x = 180;
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 420) numberPath = 2;
                    } else if (numberPath == 2) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 90) {
                            angel.x = 90;
                            numberPath = 3;
                        }
                    } else if (numberPath == 3) {
                        position.sub(deltaTime * speed * speedMove, 0);
                        if (position.x < 770) numberPath = 4;
                    } else if (numberPath == 4) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 180) {
                            angel.x = 180;
                            numberPath = 5;
                        }
                    } else if (numberPath == 5) {
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 255) numberPath = 6;
                    } else if (numberPath == 6) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 270) {
                            angel.x = 270;
                            numberPath = 7;
                        }
                    } else if (numberPath == 7) {
                        position.add(deltaTime * speed * speedMove, 0);
                        if (position.x > 820) numberPath = 8;
                    } else if (numberPath == 8) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 225) {
                            angel.x = 225;
                            numberPath = 9;
                        }
                    } else if (numberPath == 9) {
                        position.add(deltaTime * speed / 2 * speedMove, -deltaTime * speed / 2 * speedMove);
                        if (position.y < 200) numberPath = 10;
                    } else if (numberPath == 10) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 180) {
                            angel.x = 180;
                            numberPath = 11;
                        }
                    } else if (numberPath == 11) {
                        position.sub(0, deltaTime * speed * speedMove);
                        if (position.y < 130) numberPath = 12;
                    } else if (numberPath == 12) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 270) {
                            angel.x = 270;
                            numberPath = 13;
                        }
                    } else if (numberPath == 13) {
                        position.add(deltaTime * speed * speedMove, 0);
                        if (position.x > 975) {
                            numberPath = 0;
                            effect = "Open";
                        }
                    }
                }
                //endregion
                //region Home
                else if (positionStart == HOME) {
                    if (numberPath == 1) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 90) {
                            angel.x = 90;
                            numberPath = 2;
                        }
                    } else if (numberPath == 2) {
                        position.sub(deltaTime * speed * speedMove, 0);
                        if (position.x < 870) numberPath = 3;
                    } else if (numberPath == 3) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 0) {
                            angel.x = 0;
                            numberPath = 4;
                        }
                    } else if (numberPath == 4) {
                        position.add(0, deltaTime * speed * speedMove);
                        if (position.y > 200) numberPath = 5;
                    } else if (numberPath == 5) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 45) {
                            angel.x = 45;
                            numberPath = 6;
                        }
                    } else if (numberPath == 6) {
                        position.add(-deltaTime * speed / 2 * speedMove, deltaTime * speed / 2 * speedMove);
                        if (position.x < 800) numberPath = 7;
                    } else if (numberPath == 7) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 90) {
                            angel.x = 90;
                            numberPath = 8;
                        }
                    } else if (numberPath == 8) {
                        position.sub(deltaTime * speed * speedMove, 0);
                        if (position.x < 770) numberPath = 9;
                    } else if (numberPath == 9) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < 0) {
                            angel.x = 0;
                            numberPath = 10;
                        }
                    } else if (numberPath == 10) {
                        position.add(0, deltaTime * speed * speedMove);
                        if (position.y > 420) numberPath = 11;
                    } else if (numberPath == 11) {
                        angel.sub(deltaTime * 35 * speedMove, 0);
                        if (angel.x < -90) {
                            angel.x = -90;
                            numberPath = 12;
                        }
                    } else if (numberPath == 12) {
                        position.add(deltaTime * speed * speedMove, 0);
                        if (position.x > 930) numberPath = 13;
                    } else if (numberPath == 13) {
                        angel.add(deltaTime * 35 * speedMove, 0);
                        if (angel.x > 0) {
                            angel.x = 0;
                            numberPath = 14;
                        }
                    } else if (numberPath == 14) {
                        position.add(0, deltaTime * speed * speedMove);
                        if (position.y > 610) {
                            angel.x = 180;
                            MarsGame.getPreference().saveMineral(crystal);
                            startWork();
                        }
                    }
                }
                //endregion
            }
        } else if (mission.equals("Missions_1_3")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 90;
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 740) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 480) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 445) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 130) {
                        angel.x = 130;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, deltaTime * speed * speedMove);
                    if (position.x < 375) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -50) {
                        angel.x = -50;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(deltaTime * speed * speedMove, deltaTime * speed * speedMove);
                    if (position.x > 450) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 740) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 610) numberPath = 7;
                } else if (numberPath == 7) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 8;
                    }
                } else if (numberPath == 8) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 930) {
                        angel.x = 90;
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_1_4")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1050) numberPath = 2;
                } else if (numberPath == 2) {
                    position.add(deltaTime * speed * speedMove, deltaTime * speed * speedMove / 2);
                    if (position.y > 640) numberPath = 3;
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1770) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1150) numberPath = 3;
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, deltaTime * speed * speedMove / 2);
                    if (position.y < 610) numberPath = 4;
                } else if (numberPath == 4) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 930) {
                        angel.x = -90;
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_1_5")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 180;
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 420) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 800) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 245) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 430) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 920) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 620) {
                        angel.x = 180;
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_1_6")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 90;
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 495) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 750) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 238) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 495) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 625) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 896) {
                        angel.x = 90;
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        }
        //endregion
        //region 2
        else if (mission.equals("Missions_2_1")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 0;
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1040) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 620) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_2_2")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 180;
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 192) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 620) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_2_3")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 180;
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 320) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 650) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_2_4")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 0;
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1050) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 608) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_2_5")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 180;
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 244) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 608) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_2_6")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = -90;
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1094) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 804) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 608) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 930) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        }
        //endregion
        //region 3
        else if (mission.equals("Missions_3_1") || mission.equals("Missions_3_2")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 180;
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 200) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 620) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_3_3")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = -90;
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1088) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1120) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1260) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1088) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 610) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 896) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_3_4") || mission.equals("Missions_3_5")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 90;
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 736) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 470) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 182) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 690) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 470) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 736) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 612) numberPath = 7;
                } else if (numberPath == 7) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 8;
                    }
                } else if (numberPath == 8) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_3_6")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 90;
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 736) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 448) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 624) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 736) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 612) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        }
        //endregion
        //region 3
        else if (mission.equals("Missions_4_1")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 0;
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 800) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 832) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1024) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 355) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 832) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 800) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) numberPath = 7;
                } else if (numberPath == 7) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 8;
                    }
                } else if (numberPath == 8) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 620) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_4_2")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = -90;
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1088) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -180) {
                        angel.x = -180;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 576) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > -90) {
                        angel.x = -90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1435) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 1088) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 612) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 928) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_4_3")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 0;
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 800) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < -90) {
                        angel.x = -90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 1056) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1088) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 800) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 90) {
                        angel.x = 90;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 928) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 612) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_4_4")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 0;
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 800) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 800) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 928) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 640) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 800) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 800) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) numberPath = 7;
                } else if (numberPath == 7) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 8;
                    }
                } else if (numberPath == 8) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 612) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_4_5")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 90;
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 736) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 672) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 480) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 180) {
                        angel.x = 180;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 512) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 360) {
                        angel.x = 360;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 672) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 270) {
                        angel.x = 270;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 736) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 612) numberPath = 7;
                } else if (numberPath == 7) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 8;
                    }
                } else if (numberPath == 8) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        } else if (mission.equals("Missions_4_6")) {
            //region Work
            if (positionStart == WORK) {
                if (numberPath == 1) {
                    angel.x = 0;
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 784) numberPath = 2;
                } else if (numberPath == 2) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 3;
                    }
                } else if (numberPath == 3) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 800) numberPath = 4;
                } else if (numberPath == 4) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 5;
                    }
                } else if (numberPath == 5) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 928) numberPath = 6;
                } else if (numberPath == 6) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 7;
                    }
                } else if (numberPath == 7) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 672) numberPath = 8;
                } else if (numberPath == 8) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 0) {
                        angel.x = 0;
                        numberPath = 9;
                    }
                } else if (numberPath == 9) {
                    position.add(0, deltaTime * speed * speedMove);
                    if (position.y > 1184) numberPath = 10;
                } else if (numberPath == 10) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 90) {
                        angel.x = 90;
                        numberPath = 11;
                    }
                } else if (numberPath == 11) {
                    position.sub(deltaTime * speed * speedMove, 0);
                    if (position.x < 603) {
                        numberPath = 0;
                        effect = "Open";
                    }
                }
            }
            //endregion
            //region Home
            else if (positionStart == HOME) {
                if (numberPath == 1) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 2;
                    }
                } else if (numberPath == 2) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 672) numberPath = 3;
                } else if (numberPath == 3) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 4;
                    }
                } else if (numberPath == 4) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 928) numberPath = 5;
                } else if (numberPath == 5) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 6;
                    }
                } else if (numberPath == 6) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 800) numberPath = 7;
                } else if (numberPath == 7) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 8;
                    }
                } else if (numberPath == 8) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 784) numberPath = 9;
                } else if (numberPath == 9) {
                    angel.add(deltaTime * 35 * speedMove, 0);
                    if (angel.x > 270) {
                        angel.x = 270;
                        numberPath = 10;
                    }
                } else if (numberPath == 10) {
                    position.add(deltaTime * speed * speedMove, 0);
                    if (position.x > 928) numberPath = 11;
                } else if (numberPath == 11) {
                    angel.sub(deltaTime * 35 * speedMove, 0);
                    if (angel.x < 180) {
                        angel.x = 180;
                        numberPath = 12;
                    }
                } else if (numberPath == 12) {
                    position.sub(0, deltaTime * speed * speedMove);
                    if (position.y < 612) {
                        MarsGame.getPreference().saveMineral(crystal);
                        startWork();
                    }
                }
            }
            //endregion
        }
        //endregion
        return position;
    }

    public void setPosition(float posX, float posY) {
        this.position = position.set(posX, posY);
    }

    public float getAngel() {
        return angel.x;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public void setCrystal(int crystal) {
        this.crystal = crystal;
    }

    public boolean isWork() {
        return isWork;
    }
}