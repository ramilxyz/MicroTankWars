package xyz.ramil.microtankwars.actor;

import com.badlogic.gdx.graphics.Color;

import xyz.ramil.microtankwars.MicroTankWarsGame;
import xyz.ramil.microtankwars.screen.GameScreen;

public class Bullet {


    private int positionStart;
    private int tankDirection;
    private Color typeTank;
    private Grid grid;
    private boolean destroyBullet = false;
    private boolean clear = false;
    private float speed;


    Bullet(int positionStart, int tankDirection, Color typeTank, Grid grid) {

        this.positionStart = positionStart;
        this.tankDirection = tankDirection;
        this.typeTank = typeTank;
        this.grid = grid;
    }

    public void render(float v) {

        speed += v;

        if (speed > 0.020) {


            if (typeTank.equals(GameScreen.COLORBLUE) || typeTank.equals(GameScreen.USER_TANK_COLOR_BLUE)) {

                if (tankDirection == 1) {


                    if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED) || grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {

                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED)) {
                            GameScreen.blue = GameScreen.blue + GameScreen.WIN_SCORE;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                MicroTankWarsGame.preferences.putInteger("numberofflagsdestroyed", MicroTankWarsGame.preferences.getInteger("numberofflagsdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE))
                            GameScreen.red = GameScreen.red + GameScreen.WIN_SCORE;

                        clear = true;
                        destroyBullet = true;
                    }
                    //если танк или дерево
                    if (grid.table[positionStart].getColor().equals(GameScreen.WOOD_COLOR) ||
                            grid.table[positionStart].getColor().equals(Color.BROWN) ||
                            grid.table[positionStart].getColor().equals(GameScreen.COLORRED)
                            || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_RED)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.COLORRED) || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_RED)) {
                            GameScreen.blue++;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                MicroTankWarsGame.preferences.putInteger("numberoftanksdestroyed", MicroTankWarsGame.preferences.getInteger("numberoftanksdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;

                    }

                    grid.table[positionStart].setColor(Color.BROWN);
                    grid.table[positionStart - 1].setColor(Color.CLEAR);

                    if (!grid.table[positionStart + 1].getColor().equals(GameScreen.BRICK_COLOR)) {
                        positionStart = positionStart + 1;
                    }

                    //если бетон или свой танк
                    if (grid.table[positionStart + 1].getColor().equals(GameScreen.BRICK_COLOR)
                            || grid.table[positionStart + 1].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) || grid.table[positionStart + 1].getColor().equals(GameScreen.COLORBLUE) || grid.table[positionStart + 1].getColor().equals(Color.BROWN)) {
                        grid.table[positionStart].setColor(Color.CLEAR);
                        grid.table[positionStart - 1].setColor(Color.CLEAR);

                        clear = true;
                        destroyBullet = true;
                    }
                }
                if (tankDirection == 2) {

                    if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED) || grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED)) {
                            GameScreen.blue = GameScreen.blue + GameScreen.WIN_SCORE;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                MicroTankWarsGame.preferences.putInteger("numberofflagsdestroyed", MicroTankWarsGame.preferences.getInteger("numberofflagsdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }


                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE))
                            GameScreen.red = GameScreen.red + GameScreen.WIN_SCORE;
                        clear = true;
                        destroyBullet = true;
                    }

                    //если танк или дерево
                    if (grid.table[positionStart].getColor().equals(GameScreen.WOOD_COLOR) ||
                            grid.table[positionStart].getColor().equals(Color.BROWN) ||
                            grid.table[positionStart].getColor().equals(GameScreen.COLORRED)
                            || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_RED)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.COLORRED) || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_RED)) {
                            GameScreen.blue++;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                MicroTankWarsGame.preferences.putInteger("numberoftanksdestroyed", MicroTankWarsGame.preferences.getInteger("numberoftanksdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;

                    }

                    grid.table[positionStart].setColor(Color.BROWN);
                    grid.table[positionStart - 72].setColor(Color.CLEAR);
                    if (!grid.table[positionStart + 72].getColor().equals(GameScreen.BRICK_COLOR)) {
                        positionStart = positionStart + 72;
                    }

                    //если бетон или свой танк
                    if (grid.table[positionStart + 72].getColor().equals(GameScreen.BRICK_COLOR) ||
                            grid.table[positionStart + 72].getColor().equals(GameScreen.COLORBLUE)
                            || grid.table[positionStart + 72].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                            grid.table[positionStart + 72].getColor().equals(Color.BROWN)) {

                        grid.table[positionStart].setColor(Color.CLEAR);
                        grid.table[positionStart - 72].setColor(Color.CLEAR);

                        clear = true;
                        destroyBullet = true;
                    }

                }

                if (tankDirection == 3) {

                    if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED) || grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED)) {
                            GameScreen.blue = GameScreen.blue + GameScreen.WIN_SCORE;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                MicroTankWarsGame.preferences.putInteger("numberofflagsdestroyed", MicroTankWarsGame.preferences.getInteger("numberofflagsdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE))
                            GameScreen.red = GameScreen.red + GameScreen.WIN_SCORE;
                        clear = true;
                        destroyBullet = true;
                    }

                    //если танк или дерево
                    if (grid.table[positionStart].getColor().equals(GameScreen.WOOD_COLOR) ||
                            grid.table[positionStart].getColor().equals(Color.BROWN) ||
                            grid.table[positionStart].getColor().equals(GameScreen.COLORRED)
                            || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_RED)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.COLORRED) || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_RED)) {
                            GameScreen.blue++;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                MicroTankWarsGame.preferences.putInteger("numberoftanksdestroyed", MicroTankWarsGame.preferences.getInteger("numberoftanksdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;

                    }

                    grid.table[positionStart].setColor(Color.BROWN);
                    grid.table[positionStart + 1].setColor(Color.CLEAR);
                    if (!grid.table[positionStart - 1].getColor().equals(GameScreen.BRICK_COLOR)) {
                        positionStart = positionStart - 1;
                    }

                    //если бетон или свой танк
                    if (grid.table[positionStart - 1].getColor().equals(GameScreen.BRICK_COLOR) ||
                            grid.table[positionStart - 1].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                            grid.table[positionStart - 1].getColor().equals(GameScreen.COLORBLUE) || grid.table[positionStart - 1].getColor().equals(Color.BROWN)) {
                        grid.table[positionStart].setColor(Color.CLEAR);
                        grid.table[positionStart + 1].setColor(Color.CLEAR);

                        clear = true;
                        destroyBullet = true;
                    }

                }
                if (tankDirection == 4) {
                    if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED) || grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED)) {
                            GameScreen.blue = GameScreen.blue + GameScreen.WIN_SCORE;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                MicroTankWarsGame.preferences.putInteger("numberofflagsdestroyed", MicroTankWarsGame.preferences.getInteger("numberofflagsdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE))
                            GameScreen.red = GameScreen.red + GameScreen.WIN_SCORE;
                        clear = true;
                        destroyBullet = true;
                    }

                    //если танк или дерево
                    if (grid.table[positionStart].getColor().equals(GameScreen.WOOD_COLOR) ||
                            grid.table[positionStart].getColor().equals(Color.BROWN) ||
                            grid.table[positionStart].getColor().equals(GameScreen.COLORRED)
                            || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_RED)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.COLORRED) || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_RED)) {
                            GameScreen.blue++;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                MicroTankWarsGame.preferences.putInteger("numberoftanksdestroyed", MicroTankWarsGame.preferences.getInteger("numberoftanksdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;

                    }

                    grid.table[positionStart].setColor(Color.BROWN);
                    grid.table[positionStart + 72].setColor(Color.CLEAR);
                    if (!grid.table[positionStart - 72].getColor().equals(GameScreen.BRICK_COLOR)) {
                        positionStart = positionStart - 72;
                    }

                    //если бетон или свой танк
                    if (grid.table[positionStart - 72].getColor().equals(GameScreen.BRICK_COLOR) ||
                            grid.table[positionStart - 72].getColor().equals(GameScreen.COLORBLUE) ||
                            grid.table[positionStart - 72].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                            grid.table[positionStart - 72].getColor().equals(Color.BROWN)) {

                        grid.table[positionStart].setColor(Color.CLEAR);
                        grid.table[positionStart + 72].setColor(Color.CLEAR);

                        clear = true;
                        destroyBullet = true;
                    }

                }
            }

            if (typeTank.equals(GameScreen.COLORRED) || typeTank.equals(GameScreen.USER_TANK_COLOR_RED)) {


                if (tankDirection == 1) {

                    if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED) || grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED))
                            GameScreen.blue = GameScreen.blue + GameScreen.WIN_SCORE;
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {
                            GameScreen.red = GameScreen.red + GameScreen.WIN_SCORE;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                MicroTankWarsGame.preferences.putInteger("numberofflagsdestroyed", MicroTankWarsGame.preferences.getInteger("numberofflagsdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;
                    }
                    //если танк или дерево
                    if (grid.table[positionStart].getColor().equals(GameScreen.WOOD_COLOR) ||
                            grid.table[positionStart].getColor().equals(Color.BROWN) ||
                            grid.table[positionStart].getColor().equals(GameScreen.COLORBLUE)
                            || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.COLORBLUE) || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                            GameScreen.red++;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                MicroTankWarsGame.preferences.putInteger("numberoftanksdestroyed", MicroTankWarsGame.preferences.getInteger("numberoftanksdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;

                    }

                    grid.table[positionStart].setColor(Color.BROWN);
                    grid.table[positionStart - 1].setColor(Color.CLEAR);
                    if (!grid.table[positionStart + 1].getColor().equals(GameScreen.BRICK_COLOR)) {
                        positionStart = positionStart + 1;
                    }
                    //если бетон или свой танк
                    if (grid.table[positionStart + 1].getColor().equals(GameScreen.BRICK_COLOR) || grid.table[positionStart + 1].getColor().equals(GameScreen.USER_TANK_COLOR_RED) || grid.table[positionStart + 1].getColor().equals(GameScreen.COLORRED) || grid.table[positionStart + 1].getColor().equals(Color.BROWN)) {

                        grid.table[positionStart].setColor(Color.CLEAR);
                        grid.table[positionStart - 1].setColor(Color.CLEAR);

                        clear = true;
                        destroyBullet = true;
                    }
                }
                if (tankDirection == 2) {
                    if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED) || grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED))
                            GameScreen.blue = GameScreen.blue + GameScreen.WIN_SCORE;
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {
                            GameScreen.red = GameScreen.red + GameScreen.WIN_SCORE;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                MicroTankWarsGame.preferences.putInteger("numberofflagsdestroyed", MicroTankWarsGame.preferences.getInteger("numberofflagsdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;
                    }

                    //если танк или дерево
                    if (grid.table[positionStart].getColor().equals(GameScreen.WOOD_COLOR) ||
                            grid.table[positionStart].getColor().equals(Color.BROWN) ||
                            grid.table[positionStart].getColor().equals(GameScreen.COLORBLUE)
                            || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.COLORBLUE) || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                            GameScreen.red++;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                MicroTankWarsGame.preferences.putInteger("numberoftanksdestroyed", MicroTankWarsGame.preferences.getInteger("numberoftanksdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;

                    }

                    grid.table[positionStart].setColor(Color.BROWN);
                    grid.table[positionStart - 72].setColor(Color.CLEAR);

                    if (!grid.table[positionStart + 72].getColor().equals(GameScreen.BRICK_COLOR)) {
                        positionStart = positionStart + 72;
                    }

                    //если бетон или свой танк
                    if (grid.table[positionStart + 72].getColor().equals(GameScreen.BRICK_COLOR) ||
                            grid.table[positionStart + 72].getColor().equals(GameScreen.COLORRED) ||
                            grid.table[positionStart + 72].getColor().equals(GameScreen.USER_TANK_COLOR_RED)
                            || grid.table[positionStart + 72].getColor().equals(Color.BROWN)) {
                        grid.table[positionStart].setColor(Color.CLEAR);

                        grid.table[positionStart - 72].setColor(Color.CLEAR);

                        clear = true;
                        destroyBullet = true;
                    }

                }

                if (tankDirection == 3) {
                    if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED) || grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED))
                            GameScreen.blue = GameScreen.blue + GameScreen.WIN_SCORE;
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {
                            GameScreen.red = GameScreen.red + GameScreen.WIN_SCORE;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                MicroTankWarsGame.preferences.putInteger("numberofflagsdestroyed", MicroTankWarsGame.preferences.getInteger("numberofflagsdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;
                    }

                    //если танк или дерево
                    if (grid.table[positionStart].getColor().equals(GameScreen.WOOD_COLOR) ||
                            grid.table[positionStart].getColor().equals(Color.BROWN) ||
                            grid.table[positionStart].getColor().equals(GameScreen.COLORBLUE)
                            || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.COLORBLUE) || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                            GameScreen.red++;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                MicroTankWarsGame.preferences.putInteger("numberoftanksdestroyed", MicroTankWarsGame.preferences.getInteger("numberoftanksdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;

                    }

                    grid.table[positionStart].setColor(Color.BROWN);
                    grid.table[positionStart + 1].setColor(Color.CLEAR);
                    if (!grid.table[positionStart - 1].getColor().equals(GameScreen.BRICK_COLOR)) {
                        positionStart = positionStart - 1;
                    }

                    //если бетон или свой танк
                    if (grid.table[positionStart - 1].getColor().equals(GameScreen.BRICK_COLOR) ||
                            grid.table[positionStart - 1].getColor().equals(GameScreen.COLORRED) ||
                            grid.table[positionStart - 1].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                            grid.table[positionStart - 1].getColor().equals(Color.BROWN)) {

                        grid.table[positionStart].setColor(Color.CLEAR);
                        grid.table[positionStart + 1].setColor(Color.CLEAR);


                        clear = true;
                        destroyBullet = true;
                    }

                }
                if (tankDirection == 4) {
                    if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED) || grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_RED))
                            GameScreen.blue = GameScreen.blue + GameScreen.WIN_SCORE;
                        if (grid.table[positionStart].getColor().equals(GameScreen.FLAG_BLUE)) {
                            GameScreen.red = GameScreen.red + GameScreen.WIN_SCORE;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                MicroTankWarsGame.preferences.putInteger("numberofflagsdestroyed", MicroTankWarsGame.preferences.getInteger("numberofflagsdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;
                    }

                    //если танк или дерево
                    if (grid.table[positionStart].getColor().equals(GameScreen.WOOD_COLOR) ||
                            grid.table[positionStart].getColor().equals(Color.BROWN) ||
                            grid.table[positionStart].getColor().equals(GameScreen.COLORBLUE)
                            || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                        if (grid.table[positionStart].getColor().equals(GameScreen.COLORBLUE) || grid.table[positionStart].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                            GameScreen.red++;
                            if (typeTank.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                MicroTankWarsGame.preferences.putInteger("numberoftanksdestroyed", MicroTankWarsGame.preferences.getInteger("numberoftanksdestroyed") + 1);
                                MicroTankWarsGame.preferences.flush();
                            }
                        }
                        clear = true;
                        destroyBullet = true;

                    }

                    grid.table[positionStart].setColor(Color.BROWN);
                    grid.table[positionStart + 72].setColor(Color.CLEAR);
                    if (!grid.table[positionStart - 72].getColor().equals(GameScreen.BRICK_COLOR)) {
                        positionStart = positionStart - 72;
                    }

                    //если бетон или свой танк
                    if (grid.table[positionStart - 72].getColor().equals(GameScreen.BRICK_COLOR) ||
                            grid.table[positionStart - 72].getColor().equals(GameScreen.COLORRED) ||
                            grid.table[positionStart - 72].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                            grid.table[positionStart - 72].getColor().equals(Color.BROWN)) {
                        grid.table[positionStart].setColor(Color.CLEAR);
                        grid.table[positionStart + 72].setColor(Color.CLEAR);


                        clear = true;
                        destroyBullet = true;
                    }

                }
            }

            speed = 0;
        }


    }

    void clear() {

        if (positionStart - 1 > 0 && positionStart - 72 > 0) {
            grid.table[positionStart - 1].setColor(Color.CLEAR);
            grid.table[positionStart - 72].setColor(Color.CLEAR);
        }

        if (positionStart + 1 < GameScreen.ARRAY_SIZE && positionStart + 72 < GameScreen.ARRAY_SIZE) {
            grid.table[positionStart + 1].setColor(Color.CLEAR);
            grid.table[positionStart + 72].setColor(Color.CLEAR);
        }


        grid.table[positionStart].setColor(Color.CLEAR);
        clear = true;

    }

    boolean getDestory() {
        if (clear) {
            return destroyBullet;
        } else return false;
    }

}